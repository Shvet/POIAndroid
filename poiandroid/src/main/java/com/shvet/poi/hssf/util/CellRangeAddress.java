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

package com.shvet.poi.hssf.util;

import com.shvet.poi.hssf.record.RecordInputStream;
import com.shvet.poi.hssf.record.SelectionRecord;

/**
 * See OOO documentation: excelfileformat.pdf sec 2.5.14 - 'Cell Range Address'<p/>
 * <p/>
 * Note - {@link SelectionRecord} uses the BIFF5 version of this structure
 *
 * @deprecated use {@link com.shvet.poi.ss.util.CellRangeAddress}
 */
public class CellRangeAddress extends com.shvet.poi.ss.util.CellRangeAddress {

    public CellRangeAddress(int firstRow, int lastRow, int firstCol, int lastCol) {
        super(firstRow, lastRow, firstCol, lastCol);
    }

    public CellRangeAddress(RecordInputStream in) {
        super(in);
    }
}
