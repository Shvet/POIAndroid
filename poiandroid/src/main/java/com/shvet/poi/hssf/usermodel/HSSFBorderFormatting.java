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

import com.shvet.poi.hssf.record.CFRuleBase;
import com.shvet.poi.hssf.record.cf.BorderFormatting;
import com.shvet.poi.hssf.util.HSSFColor;
import com.shvet.poi.ss.usermodel.Color;

/**
 * High level representation for Border Formatting component
 * of Conditional Formatting settings
 */
public final class HSSFBorderFormatting implements
        com.shvet.poi.ss.usermodel.BorderFormatting {
    private final HSSFWorkbook workbook;
    private final CFRuleBase cfRuleRecord;
    private final BorderFormatting borderFormatting;

    protected HSSFBorderFormatting(CFRuleBase cfRuleRecord, HSSFWorkbook workbook) {
        this.workbook = workbook;
        this.cfRuleRecord = cfRuleRecord;
        this.borderFormatting = cfRuleRecord.getBorderFormatting();
    }

    protected BorderFormatting getBorderFormattingBlock() {
        return borderFormatting;
    }

    public short getBorderBottom() {
        return (short) borderFormatting.getBorderBottom();
    }

    public void setBorderBottom(short border) {
        borderFormatting.setBorderBottom(border);
        if (border != 0) {
            cfRuleRecord.setBottomBorderModified(true);
        } else {
            cfRuleRecord.setBottomBorderModified(false);
        }
    }

    public short getBorderDiagonal() {
        return (short) borderFormatting.getBorderDiagonal();
    }

    public void setBorderDiagonal(short border) {
        borderFormatting.setBorderDiagonal(border);
        if (border != 0) {
            cfRuleRecord.setBottomLeftTopRightBorderModified(true);
            cfRuleRecord.setTopLeftBottomRightBorderModified(true);
        } else {
            cfRuleRecord.setBottomLeftTopRightBorderModified(false);
            cfRuleRecord.setTopLeftBottomRightBorderModified(false);
        }
    }

    public short getBorderLeft() {
        return (short) borderFormatting.getBorderLeft();
    }

    public void setBorderLeft(short border) {
        borderFormatting.setBorderLeft(border);
        if (border != 0) {
            cfRuleRecord.setLeftBorderModified(true);
        } else {
            cfRuleRecord.setLeftBorderModified(false);
        }
    }

    public short getBorderRight() {
        return (short) borderFormatting.getBorderRight();
    }

    public void setBorderRight(short border) {
        borderFormatting.setBorderRight(border);
        if (border != 0) {
            cfRuleRecord.setRightBorderModified(true);
        } else {
            cfRuleRecord.setRightBorderModified(false);
        }
    }

    public short getBorderTop() {
        return (short) borderFormatting.getBorderTop();
    }

    public void setBorderTop(short border) {
        borderFormatting.setBorderTop(border);
        if (border != 0) {
            cfRuleRecord.setTopBorderModified(true);
        } else {
            cfRuleRecord.setTopBorderModified(false);
        }
    }

    public short getBottomBorderColor() {
        return (short) borderFormatting.getBottomBorderColor();
    }

    public void setBottomBorderColor(short color) {
        borderFormatting.setBottomBorderColor(color);
        if (color != 0) {
            cfRuleRecord.setBottomBorderModified(true);
        } else {
            cfRuleRecord.setBottomBorderModified(false);
        }
    }

    public void setBottomBorderColor(Color color) {
        HSSFColor hcolor = HSSFColor.toHSSFColor(color);
        if (hcolor == null) {
            setBottomBorderColor((short) 0);
        } else {
            setBottomBorderColor(hcolor.getIndex());
        }
    }

    public HSSFColor getBottomBorderColorColor() {
        return workbook.getCustomPalette().getColor(
                borderFormatting.getBottomBorderColor()
        );
    }

    public short getDiagonalBorderColor() {
        return (short) borderFormatting.getDiagonalBorderColor();
    }

    public void setDiagonalBorderColor(short color) {
        borderFormatting.setDiagonalBorderColor(color);
        if (color != 0) {
            cfRuleRecord.setBottomLeftTopRightBorderModified(true);
            cfRuleRecord.setTopLeftBottomRightBorderModified(true);
        } else {
            cfRuleRecord.setBottomLeftTopRightBorderModified(false);
            cfRuleRecord.setTopLeftBottomRightBorderModified(false);
        }
    }

    public void setDiagonalBorderColor(Color color) {
        HSSFColor hcolor = HSSFColor.toHSSFColor(color);
        if (hcolor == null) {
            setDiagonalBorderColor((short) 0);
        } else {
            setDiagonalBorderColor(hcolor.getIndex());
        }
    }

    public HSSFColor getDiagonalBorderColorColor() {
        return workbook.getCustomPalette().getColor(
                borderFormatting.getDiagonalBorderColor()
        );
    }

    public short getLeftBorderColor() {
        return (short) borderFormatting.getLeftBorderColor();
    }

    public void setLeftBorderColor(short color) {
        borderFormatting.setLeftBorderColor(color);
        if (color != 0) {
            cfRuleRecord.setLeftBorderModified(true);
        } else {
            cfRuleRecord.setLeftBorderModified(false);
        }
    }

    public void setLeftBorderColor(Color color) {
        HSSFColor hcolor = HSSFColor.toHSSFColor(color);
        if (hcolor == null) {
            setLeftBorderColor((short) 0);
        } else {
            setLeftBorderColor(hcolor.getIndex());
        }
    }

    public HSSFColor getLeftBorderColorColor() {
        return workbook.getCustomPalette().getColor(
                borderFormatting.getLeftBorderColor()
        );
    }

    public short getRightBorderColor() {
        return (short) borderFormatting.getRightBorderColor();
    }

    public void setRightBorderColor(short color) {
        borderFormatting.setRightBorderColor(color);
        if (color != 0) {
            cfRuleRecord.setRightBorderModified(true);
        } else {
            cfRuleRecord.setRightBorderModified(false);
        }
    }

    public void setRightBorderColor(Color color) {
        HSSFColor hcolor = HSSFColor.toHSSFColor(color);
        if (hcolor == null) {
            setRightBorderColor((short) 0);
        } else {
            setRightBorderColor(hcolor.getIndex());
        }
    }

    public HSSFColor getRightBorderColorColor() {
        return workbook.getCustomPalette().getColor(
                borderFormatting.getRightBorderColor()
        );
    }

    public short getTopBorderColor() {
        return (short) borderFormatting.getTopBorderColor();
    }

    public void setTopBorderColor(short color) {
        borderFormatting.setTopBorderColor(color);
        if (color != 0) {
            cfRuleRecord.setTopBorderModified(true);
        } else {
            cfRuleRecord.setTopBorderModified(false);
        }
    }

    public void setTopBorderColor(Color color) {
        HSSFColor hcolor = HSSFColor.toHSSFColor(color);
        if (hcolor == null) {
            setTopBorderColor((short) 0);
        } else {
            setTopBorderColor(hcolor.getIndex());
        }
    }

    public HSSFColor getTopBorderColorColor() {
        return workbook.getCustomPalette().getColor(
                borderFormatting.getTopBorderColor()
        );
    }

    public boolean isBackwardDiagonalOn() {
        return borderFormatting.isBackwardDiagonalOn();
    }

    public void setBackwardDiagonalOn(boolean on) {
        borderFormatting.setBackwardDiagonalOn(on);
        if (on) {
            cfRuleRecord.setTopLeftBottomRightBorderModified(on);
        }
    }

    public boolean isForwardDiagonalOn() {
        return borderFormatting.isForwardDiagonalOn();
    }

    public void setForwardDiagonalOn(boolean on) {
        borderFormatting.setForwardDiagonalOn(on);
        if (on) {
            cfRuleRecord.setBottomLeftTopRightBorderModified(on);
        }
    }
}
