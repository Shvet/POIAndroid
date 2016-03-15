/*
 *  ====================================================================
 *    Licensed to the Apache Software Foundation (ASF) under one or more
 *    contributor license agreements.  See the NOTICE file distributed with
 *    this work for additional information regarding copyright ownership.
 *    The ASF licenses this file to You under the Apache License, Version 2.0
 *    (the "License"); you may not use this file except in compliance with
 *    the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * ====================================================================
 */

package com.shvet.poi.ss.usermodel;

/**
 * High level representation for Border Formatting component
 * of Conditional Formatting settings
 */
public interface BorderFormatting {
    /**
     * No border
     */
    short BORDER_NONE = 0x0;
    /**
     * Thin border
     */
    short BORDER_THIN = 0x1;
    /**
     * Medium border
     */
    short BORDER_MEDIUM = 0x2;
    /**
     * dash border
     */
    short BORDER_DASHED = 0x3;
    /**
     * dot border
     */
    short BORDER_HAIR = 0x4;
    /**
     * Thick border
     */
    short BORDER_THICK = 0x5;
    /**
     * double-line border
     */
    short BORDER_DOUBLE = 0x6;
    /**
     * hair-line border
     */
    short BORDER_DOTTED = 0x7;
    /**
     * Medium dashed border
     */
    short BORDER_MEDIUM_DASHED = 0x8;
    /**
     * dash-dot border
     */
    short BORDER_DASH_DOT = 0x9;
    /**
     * medium dash-dot border
     */
    short BORDER_MEDIUM_DASH_DOT = 0xA;
    /**
     * dash-dot-dot border
     */
    short BORDER_DASH_DOT_DOT = 0xB;
    /**
     * medium dash-dot-dot border
     */
    short BORDER_MEDIUM_DASH_DOT_DOT = 0xC;
    /**
     * slanted dash-dot border
     */
    short BORDER_SLANTED_DASH_DOT = 0xD;

    short getBorderBottom();

    void setBorderBottom(short border);

    short getBorderDiagonal();

    /**
     * Set diagonal border.
     *
     * @param border MUST be a BORDER_* constant
     */
    void setBorderDiagonal(short border);

    short getBorderLeft();

    /**
     * Set left border.
     *
     * @param border MUST be a BORDER_* constant
     */
    void setBorderLeft(short border);

    short getBorderRight();

    /**
     * Set right border.
     *
     * @param border MUST be a BORDER_* constant
     */
    void setBorderRight(short border);

    short getBorderTop();

    /**
     * Set top border.
     *
     * @param border MUST be a BORDER_* constant
     */
    void setBorderTop(short border);

    short getBottomBorderColor();

    void setBottomBorderColor(short color);

    void setBottomBorderColor(Color color);

    Color getBottomBorderColorColor();

    short getDiagonalBorderColor();

    void setDiagonalBorderColor(short color);

    void setDiagonalBorderColor(Color color);

    Color getDiagonalBorderColorColor();

    short getLeftBorderColor();

    void setLeftBorderColor(short color);

    void setLeftBorderColor(Color color);

    Color getLeftBorderColorColor();

    short getRightBorderColor();

    void setRightBorderColor(short color);

    void setRightBorderColor(Color color);

    Color getRightBorderColorColor();

    short getTopBorderColor();

    void setTopBorderColor(short color);

    void setTopBorderColor(Color color);

    Color getTopBorderColorColor();
}
