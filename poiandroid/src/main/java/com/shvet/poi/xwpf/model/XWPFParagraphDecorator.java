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
package com.shvet.poi.xwpf.model;

import com.shvet.poi.xwpf.usermodel.XWPFParagraph;

/**
 * Base decorator class for XWPFParagraph
 */
public abstract class XWPFParagraphDecorator {
    protected XWPFParagraph paragraph;
    protected XWPFParagraphDecorator nextDecorator;

    public XWPFParagraphDecorator(XWPFParagraph paragraph) {
        this(paragraph, null);
    }

    public XWPFParagraphDecorator(XWPFParagraph paragraph,
                                  XWPFParagraphDecorator nextDecorator) {
        this.paragraph = paragraph;
        this.nextDecorator = nextDecorator;
    }

    public String getText() {
        if (nextDecorator != null) {
            return nextDecorator.getText();
        }
        return paragraph.getText();
    }
}