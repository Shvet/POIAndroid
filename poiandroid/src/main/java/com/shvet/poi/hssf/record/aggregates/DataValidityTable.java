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

package com.shvet.poi.hssf.record.aggregates;

import com.shvet.poi.hssf.model.RecordStream;
import com.shvet.poi.hssf.record.DVALRecord;
import com.shvet.poi.hssf.record.DVRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the DVALRecord and DVRecords for a single sheet<br/>
 * See OOO excelfileformat.pdf section 4.14
 *
 * @author Josh Micich
 */
public final class DataValidityTable extends RecordAggregate {

    private final DVALRecord _headerRec;
    /**
     * The list of data validations for the current sheet.
     * Note - this may be empty (contrary to OOO documentation)
     */
    private final List<DVRecord> _validationList;

    public DataValidityTable(RecordStream rs) {
        _headerRec = (DVALRecord) rs.getNext();
        List<DVRecord> temp = new ArrayList<DVRecord>();
        while (rs.peekNextClass() == DVRecord.class) {
            temp.add((DVRecord) rs.getNext());
        }
        _validationList = temp;
    }

    public DataValidityTable() {
        _headerRec = new DVALRecord();
        _validationList = new ArrayList<DVRecord>();
    }

    public void visitContainedRecords(RecordVisitor rv) {
        if (_validationList.isEmpty()) {
            return;
        }
        rv.visitRecord(_headerRec);
        for (int i = 0; i < _validationList.size(); i++) {
            rv.visitRecord(_validationList.get(i));
        }
    }

    public void addDataValidation(DVRecord dvRecord) {
        _validationList.add(dvRecord);
        _headerRec.setDVRecNo(_validationList.size());
    }
}
