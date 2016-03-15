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
import com.shvet.poi.hssf.record.aggregates.CFRecordsAggregate;
import com.shvet.poi.ss.usermodel.ConditionalFormatting;
import com.shvet.poi.ss.usermodel.ConditionalFormattingRule;
import com.shvet.poi.ss.util.CellRangeAddress;

/**
 * HSSFConditionalFormatting class encapsulates all settings of Conditional
 * Formatting.
 * <p/>
 * The class can be used
 * <p/>
 * <UL>
 * <LI>
 * to make a copy HSSFConditionalFormatting settings.</LI>
 * <p/>
 * <p/>
 * For example:
 * <p/>
 * <PRE>
 * HSSFConditionalFormatting cf = sheet.getConditionalFormattingAt(index);
 * newSheet.addConditionalFormatting(cf);
 * </PRE>
 * <p/>
 * <LI>
 * or to modify existing Conditional Formatting settings (formatting regions
 * and/or rules).</LI>
 * </UL>
 * <p/>
 * Use
 * {@link com.shvet.poi.hssf.usermodel.HSSFSheet#getSheetConditionalFormatting()}
 * to get access to an instance of this class.
 * <p/>
 * To create a new Conditional Formatting set use the following approach:
 * <p/>
 * <PRE>
 * <p/>
 * // Define a Conditional Formatting rule, which triggers formatting
 * // when cell's value is greater or equal than 100.0 and
 * // applies patternFormatting defined below.
 * HSSFConditionalFormattingRule rule = sheet.createConditionalFormattingRule(
 * ComparisonOperator.GE, &quot;100.0&quot;, // 1st formula
 * null // 2nd formula is not used for comparison operator GE
 * );
 * <p/>
 * // Create pattern with red background
 * HSSFPatternFormatting patternFmt = rule.cretePatternFormatting();
 * patternFormatting.setFillBackgroundColor(HSSFColor.RED.index);
 * <p/>
 * // Define a region containing first column
 * Region[] regions = { new Region(1, (short) 1, -1, (short) 1) };
 * <p/>
 * // Apply Conditional Formatting rule defined above to the regions
 * sheet.addConditionalFormatting(regions, rule);
 * </PRE>
 */
public final class HSSFConditionalFormatting implements ConditionalFormatting {
    private final HSSFSheet sheet;
    private final CFRecordsAggregate cfAggregate;

    HSSFConditionalFormatting(HSSFSheet sheet, CFRecordsAggregate cfAggregate) {
        if (sheet == null) {
            throw new IllegalArgumentException("sheet must not be null");
        }
        if (cfAggregate == null) {
            throw new IllegalArgumentException("cfAggregate must not be null");
        }
        this.sheet = sheet;
        this.cfAggregate = cfAggregate;
    }

    CFRecordsAggregate getCFRecordsAggregate() {
        return cfAggregate;
    }

    /**
     * @deprecated (Aug-2008) use
     * {@link HSSFConditionalFormatting#getFormattingRanges()}
     */
    public com.shvet.poi.ss.util.Region[] getFormattingRegions() {
        CellRangeAddress[] cellRanges = getFormattingRanges();
        return com.shvet.poi.ss.util.Region
                .convertCellRangesToRegions(cellRanges);
    }

    /**
     * @return array of <tt>CellRangeAddress</tt>s. never <code>null</code>
     */
    public CellRangeAddress[] getFormattingRanges() {
        return cfAggregate.getHeader().getCellRanges();
    }

    /**
     * Replaces an existing Conditional Formatting rule at position idx. Older
     * versions of Excel only allow up to 3 Conditional Formatting rules, and
     * will ignore rules beyond that, while newer versions are fine. This method
     * can be useful to modify existing Conditional Formatting rules.
     *
     * @param idx    position of the rule. Should be between 0 and 2 for older
     *               Excel versions
     * @param cfRule - Conditional Formatting rule
     */
    public void setRule(int idx, HSSFConditionalFormattingRule cfRule) {
        cfAggregate.setRule(idx, cfRule.getCfRuleRecord());
    }

    public void setRule(int idx, ConditionalFormattingRule cfRule) {
        setRule(idx, (HSSFConditionalFormattingRule) cfRule);
    }

    /**
     * add a Conditional Formatting rule. Excel allows to create up to 3
     * Conditional Formatting rules.
     *
     * @param cfRule - Conditional Formatting rule
     */
    public void addRule(HSSFConditionalFormattingRule cfRule) {
        cfAggregate.addRule(cfRule.getCfRuleRecord());
    }

    public void addRule(ConditionalFormattingRule cfRule) {
        addRule((HSSFConditionalFormattingRule) cfRule);
    }

    /**
     * @return the Conditional Formatting rule at position idx.
     */
    public HSSFConditionalFormattingRule getRule(int idx) {
        CFRuleBase ruleRecord = cfAggregate.getRule(idx);
        return new HSSFConditionalFormattingRule(sheet, ruleRecord);
    }

    /**
     * @return number of Conditional Formatting rules.
     */
    public int getNumberOfRules() {
        return cfAggregate.getNumberOfRules();
    }

    public String toString() {
        return cfAggregate.toString();
    }
}
