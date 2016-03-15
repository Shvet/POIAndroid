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

package com.shvet.poi.hssf.record;

import com.shvet.poi.util.HexDump;
import com.shvet.poi.util.LittleEndianOutput;

/**
 * Title: Beginning Of File (0x0809)
 * <p/>
 * Description: Somewhat of a misnomer, its used for the beginning of a set of
 * records that have a particular purpose or subject. Used in sheets and
 * workbooks.
 * <p/>
 * REFERENCE: PG 289 Microsoft Excel 97 Developer's Kit (ISBN: 1-57231-498-2)
 * <p/>
 *
 * @author Andrew C. Oliver
 * @author Jason Height (jheight at chariot dot net dot au)
 */
public final class BOFRecord extends StandardRecord {
    /**
     * for BIFF8 files the BOF is 0x809. For earlier versions see
     * {@link #biff2_sid} {@link #biff3_sid} {@link #biff4_sid}
     * {@link #biff5_sid}
     */
    public final static short sid = 0x809;
    // SIDs from earlier BIFF versions
    public final static short biff2_sid = 0x009;
    public final static short biff3_sid = 0x209;
    public final static short biff4_sid = 0x409;
    public final static short biff5_sid = 0x809;

    /**
     * suggested default (0x0600 - BIFF8)
     */
    public final static int VERSION = 0x0600;
    /**
     * suggested default 0x10d3
     */
    public final static int BUILD = 0x10d3;
    /**
     * suggested default 0x07CC (1996)
     */
    public final static int BUILD_YEAR = 0x07CC; // 1996
    /**
     * suggested default for a normal sheet (0x41)
     */
    public final static int HISTORY_MASK = 0x41;

    public final static int TYPE_WORKBOOK = 0x05;
    public final static int TYPE_VB_MODULE = 0x06;
    public final static int TYPE_WORKSHEET = 0x10;
    public final static int TYPE_CHART = 0x20;
    public final static int TYPE_EXCEL_4_MACRO = 0x40;
    public final static int TYPE_WORKSPACE_FILE = 0x100;

    private int field_1_version;
    private int field_2_type;
    private int field_3_build;
    private int field_4_year;
    private int field_5_history;
    private int field_6_rversion;

    /**
     * Constructs an empty BOFRecord with no fields set.
     */
    public BOFRecord() {
    }

    private BOFRecord(int type) {
        field_1_version = VERSION;
        field_2_type = type;
        field_3_build = BUILD;
        field_4_year = BUILD_YEAR;
        field_5_history = 0x01;
        field_6_rversion = VERSION;
    }

    public BOFRecord(RecordInputStream in) {
        field_1_version = in.readShort();
        field_2_type = in.readShort();

        // Some external tools don't generate all of
        // the remaining fields
        if (in.remaining() >= 2) {
            field_3_build = in.readShort();
        }
        if (in.remaining() >= 2) {
            field_4_year = in.readShort();
        }
        if (in.remaining() >= 4) {
            field_5_history = in.readInt();
        }
        if (in.remaining() >= 4) {
            field_6_rversion = in.readInt();
        }
    }

    public static BOFRecord createSheetBOF() {
        return new BOFRecord(TYPE_WORKSHEET);
    }

    /**
     * Version number - for BIFF8 should be 0x06
     *
     * @return version number of the generator of this file
     * @see #VERSION
     */
    public int getVersion() {
        return field_1_version;
    }

    /**
     * Version number - for BIFF8 should be 0x06
     *
     * @param version version to be set
     * @see #VERSION
     */
    public void setVersion(int version) {
        field_1_version = version;
    }

    /**
     * type of object this marks
     *
     * @return type of object
     * @see #TYPE_WORKBOOK
     * @see #TYPE_VB_MODULE
     * @see #TYPE_WORKSHEET
     * @see #TYPE_CHART
     * @see #TYPE_EXCEL_4_MACRO
     * @see #TYPE_WORKSPACE_FILE
     */
    public int getType() {
        return field_2_type;
    }

    /**
     * type of object this marks
     *
     * @param type type to be set
     * @see #TYPE_WORKBOOK
     * @see #TYPE_VB_MODULE
     * @see #TYPE_WORKSHEET
     * @see #TYPE_CHART
     * @see #TYPE_EXCEL_4_MACRO
     * @see #TYPE_WORKSPACE_FILE
     */
    public void setType(int type) {
        field_2_type = type;
    }

    /**
     * get the build that wrote this file
     *
     * @return short build number of the generator of this file
     * @see #BUILD
     */
    public int getBuild() {
        return field_3_build;
    }

    /**
     * build that wrote this file
     *
     * @param build build number to set
     * @see #BUILD
     */
    public void setBuild(int build) {
        field_3_build = build;
    }

    /**
     * Year of the build that wrote this file
     *
     * @return short build year of the generator of this file
     * @see #BUILD_YEAR
     */
    public int getBuildYear() {
        return field_4_year;
    }

    /**
     * Year of the build that wrote this file
     *
     * @param year build year to set
     * @see #BUILD_YEAR
     */
    public void setBuildYear(int year) {
        field_4_year = year;
    }

    /**
     * get the history bit mask (not very useful)
     *
     * @return int bitmask showing the history of the file (who cares!)
     * @see #HISTORY_MASK
     */
    public int getHistoryBitMask() {
        return field_5_history;
    }

    /**
     * set the history bit mask (not very useful)
     *
     * @param bitmask bitmask to set for the history
     * @see #HISTORY_MASK
     */
    public void setHistoryBitMask(int bitmask) {
        field_5_history = bitmask;
    }

    /**
     * get the minimum version required to read this file
     *
     * @return int least version that can read the file
     * @see #VERSION
     */
    public int getRequiredVersion() {
        return field_6_rversion;
    }

    /**
     * set the minimum version required to read this file
     *
     * @param version version to set
     * @see #VERSION
     */
    public void setRequiredVersion(int version) {
        field_6_rversion = version;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("[BOF RECORD]\n");
        buffer.append("    .version  = ")
                .append(HexDump.shortToHex(getVersion())).append("\n");
        buffer.append("    .type     = ").append(HexDump.shortToHex(getType()));
        buffer.append(" (").append(getTypeName()).append(")").append("\n");
        buffer.append("    .build    = ")
                .append(HexDump.shortToHex(getBuild())).append("\n");
        buffer.append("    .buildyear= ").append(getBuildYear()).append("\n");
        buffer.append("    .history  = ")
                .append(HexDump.intToHex(getHistoryBitMask())).append("\n");
        buffer.append("    .reqver   = ")
                .append(HexDump.intToHex(getRequiredVersion())).append("\n");
        buffer.append("[/BOF RECORD]\n");
        return buffer.toString();
    }

    private String getTypeName() {
        switch (field_2_type) {
            case TYPE_CHART:
                return "chart";
            case TYPE_EXCEL_4_MACRO:
                return "excel 4 macro";
            case TYPE_VB_MODULE:
                return "vb module";
            case TYPE_WORKBOOK:
                return "workbook";
            case TYPE_WORKSHEET:
                return "worksheet";
            case TYPE_WORKSPACE_FILE:
                return "workspace file";
        }
        return "#error unknown type#";
    }

    public void serialize(LittleEndianOutput out) {
        out.writeShort(getVersion());
        out.writeShort(getType());
        out.writeShort(getBuild());
        out.writeShort(getBuildYear());
        out.writeInt(getHistoryBitMask());
        out.writeInt(getRequiredVersion());
    }

    protected int getDataSize() {
        return 16;
    }

    public short getSid() {
        return sid;
    }

    public Object clone() {
        BOFRecord rec = new BOFRecord();
        rec.field_1_version = field_1_version;
        rec.field_2_type = field_2_type;
        rec.field_3_build = field_3_build;
        rec.field_4_year = field_4_year;
        rec.field_5_history = field_5_history;
        rec.field_6_rversion = field_6_rversion;
        return rec;
    }
}
