/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package com.shvet.poi.hssf.record.cf;

import com.shvet.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Should this move to org.apache.poi.ss.util ?
 */
public final class CellRangeUtil {
    public static final int NO_INTERSECTION = 1;
    public static final int OVERLAP = 2;
    /**
     * first range is within the second range
     */
    public static final int INSIDE = 3;
    /**
     * first range encloses or is equal to the second
     */
    public static final int ENCLOSES = 4;

    private CellRangeUtil() {
        // no instance of this class
    }

    /**
     * Intersect this range with the specified range.
     *
     * @param crB - the specified range
     * @return code which reflects how the specified range is related to this range.<br/>
     * Possible return codes are:
     * NO_INTERSECTION - the specified range is outside of this range;<br/>
     * OVERLAP - both ranges partially overlap;<br/>
     * INSIDE - the specified range is inside of this one<br/>
     * ENCLOSES - the specified range encloses (possibly exactly the same as) this range<br/>
     */
    public static int intersect(CellRangeAddress crA, CellRangeAddress crB) {

        int firstRow = crB.getFirstRow();
        int lastRow = crB.getLastRow();
        int firstCol = crB.getFirstColumn();
        int lastCol = crB.getLastColumn();

        if
                (
                gt(crA.getFirstRow(), lastRow) ||
                        lt(crA.getLastRow(), firstRow) ||
                        gt(crA.getFirstColumn(), lastCol) ||
                        lt(crA.getLastColumn(), firstCol)
                ) {
            return NO_INTERSECTION;
        } else if (contains(crA, crB)) {
            return INSIDE;
        } else if (contains(crB, crA)) {
            return ENCLOSES;
        } else {
            return OVERLAP;
        }
    }

    /**
     * Do all possible cell merges between cells of the list so that:<br>
     * <li>if a cell range is completely inside of another cell range, it gets removed from the list
     * <li>if two cells have a shared border, merge them into one bigger cell range
     *
     * @param cellRanges
     * @return updated List of cell ranges
     */
    public static CellRangeAddress[] mergeCellRanges(CellRangeAddress[] cellRanges) {
        if (cellRanges.length < 1) {
            return cellRanges;
        }

        List<CellRangeAddress> lst = new ArrayList<CellRangeAddress>();
        for (CellRangeAddress cr : cellRanges) {
            lst.add(cr);
        }
        List<CellRangeAddress> temp = mergeCellRanges(lst);
        return toArray(temp);
    }

    private static List<CellRangeAddress> mergeCellRanges(List<CellRangeAddress> cellRangeList) {
        // loop until either only one item is left or we did not merge anything any more
        while (cellRangeList.size() > 1) {
            boolean somethingGotMerged = false;

            // look at all cell-ranges
            for (int i = 0; i < cellRangeList.size(); i++) {
                CellRangeAddress range1 = cellRangeList.get(i);

                // compare each cell range to all other cell-ranges
                for (int j = i + 1; j < cellRangeList.size(); j++) {
                    CellRangeAddress range2 = cellRangeList.get(j);

                    CellRangeAddress[] mergeResult = mergeRanges(range1, range2);
                    if (mergeResult == null) {
                        continue;
                    }
                    somethingGotMerged = true;
                    // overwrite range1 with first result
                    cellRangeList.set(i, mergeResult[0]);
                    // remove range2
                    cellRangeList.remove(j--);
                    // add any extra results beyond the first
                    for (int k = 1; k < mergeResult.length; k++) {
                        j++;
                        cellRangeList.add(j, mergeResult[k]);
                    }
                }
            }
            if (!somethingGotMerged) {
                break;
            }
        }

        return cellRangeList;
    }

    /**
     * @return the new range(s) to replace the supplied ones.  <code>null</code> if no merge is possible
     */
    private static CellRangeAddress[] mergeRanges(CellRangeAddress range1, CellRangeAddress range2) {
        int x = intersect(range1, range2);
        switch (x) {
            case CellRangeUtil.NO_INTERSECTION:
                // nothing in common: at most they could be adjacent to each other and thus form a single bigger area
                if (hasExactSharedBorder(range1, range2)) {
                    return new CellRangeAddress[]{createEnclosingCellRange(range1, range2),};
                }
                // else - No intersection and no shared border: do nothing
                return null;
            case CellRangeUtil.OVERLAP:
                // commented out the cells overlap implementation, it caused endless loops, see Bug 55380
                // disabled for now, the algorithm will not detect some border cases this way currently!
                //return resolveRangeOverlap(range1, range2);
                return null;
            case CellRangeUtil.INSIDE:
                // Remove range2, since it is completely inside of range1
                return new CellRangeAddress[]{range1};
            case CellRangeUtil.ENCLOSES:
                // range2 encloses range1, so replace it with the enclosing one
                return new CellRangeAddress[]{range2};
        }
        throw new RuntimeException("unexpected intersection result (" + x + ")");
    }

    private static CellRangeAddress[] toArray(List<CellRangeAddress> temp) {
        CellRangeAddress[] result = new CellRangeAddress[temp.size()];
        temp.toArray(result);
        return result;
    }

    /**
     * Check if the specified range is located inside of this cell range.
     *
     * @param crB
     * @return true if this cell range contains the argument range inside if it's area
     */
    public static boolean contains(CellRangeAddress crA, CellRangeAddress crB) {
        int firstRow = crB.getFirstRow();
        int lastRow = crB.getLastRow();
        int firstCol = crB.getFirstColumn();
        int lastCol = crB.getLastColumn();
        return le(crA.getFirstRow(), firstRow) && ge(crA.getLastRow(), lastRow)
                && le(crA.getFirstColumn(), firstCol) && ge(crA.getLastColumn(), lastCol);
    }

    /**
     * Check if the two cell ranges have a shared border.
     *
     * @return <code>true</code> if the ranges have a complete shared border (i.e.
     * the two ranges together make a simple rectangular region.
     */
    public static boolean hasExactSharedBorder(CellRangeAddress crA, CellRangeAddress crB) {
        int oFirstRow = crB.getFirstRow();
        int oLastRow = crB.getLastRow();
        int oFirstCol = crB.getFirstColumn();
        int oLastCol = crB.getLastColumn();

        if (crA.getFirstRow() > 0 && crA.getFirstRow() - 1 == oLastRow ||
                oFirstRow > 0 && oFirstRow - 1 == crA.getLastRow()) {
            // ranges have a horizontal border in common
            // make sure columns are identical:
            return crA.getFirstColumn() == oFirstCol && crA.getLastColumn() == oLastCol;
        }

        if (crA.getFirstColumn() > 0 && crA.getFirstColumn() - 1 == oLastCol ||
                oFirstCol > 0 && crA.getLastColumn() == oFirstCol - 1) {
            // ranges have a vertical border in common
            // make sure rows are identical:
            return crA.getFirstRow() == oFirstRow && crA.getLastRow() == oLastRow;
        }
        return false;
    }

    /**
     * Create an enclosing CellRange for the two cell ranges.
     *
     * @return enclosing CellRange
     */
    public static CellRangeAddress createEnclosingCellRange(CellRangeAddress crA, CellRangeAddress crB) {
        if (crB == null) {
            return crA.copy();
        }

        return new CellRangeAddress(
                lt(crB.getFirstRow(), crA.getFirstRow()) ? crB.getFirstRow() : crA.getFirstRow(),
                gt(crB.getLastRow(), crA.getLastRow()) ? crB.getLastRow() : crA.getLastRow(),
                lt(crB.getFirstColumn(), crA.getFirstColumn()) ? crB.getFirstColumn() : crA.getFirstColumn(),
                gt(crB.getLastColumn(), crA.getLastColumn()) ? crB.getLastColumn() : crA.getLastColumn()
        );
    }

    /**
     * @return true if a < b
     */
    private static boolean lt(int a, int b) {
        return a == -1 ? false : (b == -1 ? true : a < b);
    }

    /**
     * @return true if a <= b
     */
    private static boolean le(int a, int b) {
        return a == b || lt(a, b);
    }

    /**
     * @return true if a > b
     */
    private static boolean gt(int a, int b) {
        return lt(b, a);
    }

    /**
     * @return true if a >= b
     */
    private static boolean ge(int a, int b) {
        return !lt(a, b);
    }
}