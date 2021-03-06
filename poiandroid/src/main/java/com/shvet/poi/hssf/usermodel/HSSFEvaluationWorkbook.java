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

package com.shvet.poi.hssf.usermodel;

import com.shvet.poi.hssf.model.HSSFFormulaParser;
import com.shvet.poi.hssf.model.InternalWorkbook;
import com.shvet.poi.hssf.record.NameRecord;
import com.shvet.poi.hssf.record.aggregates.FormulaRecordAggregate;
import com.shvet.poi.ss.SpreadsheetVersion;
import com.shvet.poi.ss.formula.EvaluationCell;
import com.shvet.poi.ss.formula.EvaluationName;
import com.shvet.poi.ss.formula.EvaluationSheet;
import com.shvet.poi.ss.formula.EvaluationWorkbook;
import com.shvet.poi.ss.formula.FormulaParseException;
import com.shvet.poi.ss.formula.FormulaParsingWorkbook;
import com.shvet.poi.ss.formula.FormulaRenderingWorkbook;
import com.shvet.poi.ss.formula.FormulaType;
import com.shvet.poi.ss.formula.SheetIdentifier;
import com.shvet.poi.ss.formula.SheetRangeIdentifier;
import com.shvet.poi.ss.formula.ptg.Area3DPtg;
import com.shvet.poi.ss.formula.ptg.NamePtg;
import com.shvet.poi.ss.formula.ptg.NameXPtg;
import com.shvet.poi.ss.formula.ptg.Ptg;
import com.shvet.poi.ss.formula.ptg.Ref3DPtg;
import com.shvet.poi.ss.formula.udf.UDFFinder;
import com.shvet.poi.ss.util.AreaReference;
import com.shvet.poi.ss.util.CellReference;
import com.shvet.poi.util.POILogFactory;
import com.shvet.poi.util.POILogger;

/**
 * Internal POI use only
 */
public final class HSSFEvaluationWorkbook implements FormulaRenderingWorkbook, EvaluationWorkbook, FormulaParsingWorkbook {
    private static POILogger logger = POILogFactory.getLogger(HSSFEvaluationWorkbook.class);
    private final HSSFWorkbook _uBook;
    private final InternalWorkbook _iBook;

    private HSSFEvaluationWorkbook(HSSFWorkbook book) {
        _uBook = book;
        _iBook = book.getWorkbook();
    }

    public static HSSFEvaluationWorkbook create(HSSFWorkbook book) {
        if (book == null) {
            return null;
        }
        return new HSSFEvaluationWorkbook(book);
    }

    public int getExternalSheetIndex(String sheetName) {
        int sheetIndex = _uBook.getSheetIndex(sheetName);
        return _iBook.checkExternSheet(sheetIndex);
    }

    public int getExternalSheetIndex(String workbookName, String sheetName) {
        return _iBook.getExternalSheetIndex(workbookName, sheetName);
    }

    public Ptg get3DReferencePtg(CellReference cr, SheetIdentifier sheet) {
        int extIx = getSheetExtIx(sheet);
        return new Ref3DPtg(cr, extIx);
    }

    public Ptg get3DReferencePtg(AreaReference areaRef, SheetIdentifier sheet) {
        int extIx = getSheetExtIx(sheet);
        return new Area3DPtg(areaRef, extIx);
    }

    public NameXPtg getNameXPtg(String name, SheetIdentifier sheet) {
        int sheetRefIndex = getSheetExtIx(sheet);
        return _iBook.getNameXPtg(name, sheetRefIndex, _uBook.getUDFFinder());
    }

    /**
     * Lookup a named range by its name.
     *
     * @param name       the name to search
     * @param sheetIndex the 0-based index of the sheet this formula belongs to.
     *                   The sheet index is required to resolve sheet-level names. <code>-1</code> means workbook-global names
     */
    public EvaluationName getName(String name, int sheetIndex) {
        for (int i = 0; i < _iBook.getNumNames(); i++) {
            NameRecord nr = _iBook.getNameRecord(i);
            if (nr.getSheetNumber() == sheetIndex + 1 && name.equalsIgnoreCase(nr.getNameText())) {
                return new Name(nr, i);
            }
        }
        return sheetIndex == -1 ? null : getName(name, -1);
    }

    public int getSheetIndex(EvaluationSheet evalSheet) {
        HSSFSheet sheet = ((HSSFEvaluationSheet) evalSheet).getHSSFSheet();
        return _uBook.getSheetIndex(sheet);
    }

    public int getSheetIndex(String sheetName) {
        return _uBook.getSheetIndex(sheetName);
    }

    public String getSheetName(int sheetIndex) {
        return _uBook.getSheetName(sheetIndex);
    }

    public EvaluationSheet getSheet(int sheetIndex) {
        return new HSSFEvaluationSheet(_uBook.getSheetAt(sheetIndex));
    }

    public int convertFromExternSheetIndex(int externSheetIndex) {
        // TODO Update this to expose first and last sheet indexes
        return _iBook.getFirstSheetIndexFromExternSheetIndex(externSheetIndex);
    }

    public ExternalSheet getExternalSheet(int externSheetIndex) {
        ExternalSheet sheet = _iBook.getExternalSheet(externSheetIndex);
        if (sheet == null) {
            // Try to treat it as a local sheet
            int localSheetIndex = convertFromExternSheetIndex(externSheetIndex);
            if (localSheetIndex == -1) {
                // The sheet referenced can't be found, sorry
                return null;
            }
            if (localSheetIndex == -2) {
                // Not actually sheet based at all - is workbook scoped
                return null;
            }

            // Look up the local sheet
            String sheetName = getSheetName(localSheetIndex);

            // Is it a single local sheet, or a range?
            int lastLocalSheetIndex = _iBook.getLastSheetIndexFromExternSheetIndex(externSheetIndex);
            if (lastLocalSheetIndex == localSheetIndex) {
                sheet = new ExternalSheet(null, sheetName);
            } else {
                String lastSheetName = getSheetName(lastLocalSheetIndex);
                sheet = new ExternalSheetRange(null, sheetName, lastSheetName);
            }
        }
        return sheet;
    }

    public ExternalSheet getExternalSheet(String firstSheetName, String lastSheetName, int externalWorkbookNumber) {
        throw new IllegalStateException("XSSF-style external references are not supported for HSSF");
    }

    public ExternalName getExternalName(int externSheetIndex, int externNameIndex) {
        return _iBook.getExternalName(externSheetIndex, externNameIndex);
    }

    public ExternalName getExternalName(String nameName, String sheetName, int externalWorkbookNumber) {
        throw new IllegalStateException("XSSF-style external names are not supported for HSSF");
    }

    public String resolveNameXText(NameXPtg n) {
        return _iBook.resolveNameXText(n.getSheetRefIndex(), n.getNameIndex());
    }

    public String getSheetFirstNameByExternSheet(int externSheetIndex) {
        return _iBook.findSheetFirstNameFromExternSheet(externSheetIndex);
    }

    public String getSheetLastNameByExternSheet(int externSheetIndex) {
        return _iBook.findSheetLastNameFromExternSheet(externSheetIndex);
    }

    public String getNameText(NamePtg namePtg) {
        return _iBook.getNameRecord(namePtg.getIndex()).getNameText();
    }

    public EvaluationName getName(NamePtg namePtg) {
        int ix = namePtg.getIndex();
        return new Name(_iBook.getNameRecord(ix), ix);
    }

    @SuppressWarnings("unused")
    public Ptg[] getFormulaTokens(EvaluationCell evalCell) {
        HSSFCell cell = ((HSSFEvaluationCell) evalCell).getHSSFCell();
        if (false) {
            // re-parsing the formula text also works, but is a waste of time
            // It is useful from time to time to run all unit tests with this code
            // to make sure that all formulas POI can evaluate can also be parsed.
            try {
                return HSSFFormulaParser.parse(cell.getCellFormula(), _uBook, FormulaType.CELL, _uBook.getSheetIndex(cell.getSheet()));
            } catch (FormulaParseException e) {
                // Note - as of Bugzilla 48036 (svn r828244, r828247) POI is capable of evaluating
                // IntesectionPtg.  However it is still not capable of parsing it.
                // So FormulaEvalTestData.xls now contains a few formulas that produce errors here.
                logger.log(POILogger.ERROR, e.getMessage());
            }
        }
        FormulaRecordAggregate fra = (FormulaRecordAggregate) cell.getCellValueRecord();
        return fra.getFormulaTokens();
    }

    public UDFFinder getUDFFinder() {
        return _uBook.getUDFFinder();
    }

    private int getSheetExtIx(SheetIdentifier sheetIden) {
        int extIx;
        if (sheetIden == null) {
            extIx = -1;
        } else {
            String workbookName = sheetIden.getBookName();
            String firstSheetName = sheetIden.getSheetIdentifier().getName();
            String lastSheetName = firstSheetName;

            if (sheetIden instanceof SheetRangeIdentifier) {
                lastSheetName = ((SheetRangeIdentifier) sheetIden).getLastSheetIdentifier().getName();
            }

            if (workbookName == null) {
                int firstSheetIndex = _uBook.getSheetIndex(firstSheetName);
                int lastSheetIndex = _uBook.getSheetIndex(lastSheetName);
                extIx = _iBook.checkExternSheet(firstSheetIndex, lastSheetIndex);
            } else {
                extIx = _iBook.getExternalSheetIndex(workbookName, firstSheetName, lastSheetName);
            }
        }
        return extIx;
    }

    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL97;
    }

    private static final class Name implements EvaluationName {
        private final NameRecord _nameRecord;
        private final int _index;

        public Name(NameRecord nameRecord, int index) {
            _nameRecord = nameRecord;
            _index = index;
        }

        public Ptg[] getNameDefinition() {
            return _nameRecord.getNameDefinition();
        }

        public String getNameText() {
            return _nameRecord.getNameText();
        }

        public boolean hasFormula() {
            return _nameRecord.hasFormula();
        }

        public boolean isFunctionName() {
            return _nameRecord.isFunctionName();
        }

        public boolean isRange() {
            return _nameRecord.hasFormula(); // TODO - is this right?
        }

        public NamePtg createPtg() {
            return new NamePtg(_index);
        }
    }
}
