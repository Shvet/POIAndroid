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

package com.shvet.poi.wp.usermodel;

/**
 * This class represents a run of text that share common properties.
 */
public interface CharacterRun {
    boolean isBold();

    void setBold(boolean bold);

    boolean isItalic();

    void setItalic(boolean italic);

    boolean isSmallCaps();

    void setSmallCaps(boolean smallCaps);

    boolean isCapitalized();

    void setCapitalized(boolean caps);

    boolean isStrikeThrough();

    void setStrikeThrough(boolean strike);

    boolean isDoubleStrikeThrough();

    void setDoubleStrikethrough(boolean dstrike);

    boolean isShadowed();

    void setShadow(boolean shadow);

    boolean isEmbossed();

    void setEmbossed(boolean emboss);

    boolean isImprinted();

    void setImprinted(boolean imprint);

    int getFontSize();

    void setFontSize(int halfPoints);

    int getCharacterSpacing();

    void setCharacterSpacing(int twips);

    int getKerning();

    void setKerning(int kern);

    String getFontName();

    /**
     * @return The text of the run, including any tabs/spaces/etc
     */
    String text();

    // HWPF uses indexes, XWPF special
    // public int getUnderlineCode();
    // public void setUnderlineCode(int kul);

    // HWPF uses indexes, XWPF special vertical alignments
    // public short getSubSuperScriptIndex();
    // public void setSubSuperScriptIndex(short iss);

    // HWPF uses indexes, XWPF special vertical alignments
    // public int getVerticalOffset();
    // public void setVerticalOffset(int hpsPos);

    // HWPF has colour indexes, XWPF colour names
    // public int getColor();
    // public void setColor(int color);

    // TODO Review these, and add to XWPFRun if possible
    /*
     * public boolean isFldVanished(); public void setFldVanish(boolean
	 * fldVanish);
	 * 
	 * public boolean isOutlined(); public void setOutline(boolean outlined);
	 * 
	 * public boolean isVanished(); public void setVanished(boolean vanish);
	 * 
	 * public boolean isMarkedDeleted(); public void markDeleted(boolean mark);
	 * 
	 * public boolean isMarkedInserted(); public void markInserted(boolean
	 * mark);
	 */
}
