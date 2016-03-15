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

package com.shvet.poi.ss.formula.functions;

import com.shvet.poi.ss.formula.TwoDEval;
import com.shvet.poi.ss.formula.eval.ErrorEval;
import com.shvet.poi.ss.formula.eval.NumberEval;
import com.shvet.poi.ss.formula.eval.RefEval;
import com.shvet.poi.ss.formula.eval.ValueEval;

/**
 * Implementation for Excel COLUMNS function.
 *
 * @author Josh Micich
 */
public final class Columns extends Fixed1ArgFunction {

    public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0) {

        int result;
        if (arg0 instanceof TwoDEval) {
            result = ((TwoDEval) arg0).getWidth();
        } else if (arg0 instanceof RefEval) {
            result = 1;
        } else { // anything else is not valid argument
            return ErrorEval.VALUE_INVALID;
        }
        return new NumberEval(result);
    }
}
