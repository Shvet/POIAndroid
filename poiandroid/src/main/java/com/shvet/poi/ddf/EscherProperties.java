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

package com.shvet.poi.ddf;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides a list of all known escher properties including the description and
 * type.
 *
 * @author Glen Stampoultzis (glens at apache.org)
 */
public final class EscherProperties {

    // Property constants
    public static final short TRANSFORM__ROTATION = 4;
    public static final short PROTECTION__LOCKROTATION = 119;
    public static final short PROTECTION__LOCKASPECTRATIO = 120;
    public static final short PROTECTION__LOCKPOSITION = 121;
    public static final short PROTECTION__LOCKAGAINSTSELECT = 122;
    public static final short PROTECTION__LOCKCROPPING = 123;
    public static final short PROTECTION__LOCKVERTICES = 124;
    public static final short PROTECTION__LOCKTEXT = 125;
    public static final short PROTECTION__LOCKADJUSTHANDLES = 126;
    public static final short PROTECTION__LOCKAGAINSTGROUPING = 127;
    public static final short TEXT__TEXTID = 128;
    public static final short TEXT__TEXTLEFT = 129;
    public static final short TEXT__TEXTTOP = 130;
    public static final short TEXT__TEXTRIGHT = 131;
    public static final short TEXT__TEXTBOTTOM = 132;
    public static final short TEXT__WRAPTEXT = 133;
    public static final short TEXT__SCALETEXT = 134;
    public static final short TEXT__ANCHORTEXT = 135;
    public static final short TEXT__TEXTFLOW = 136;
    public static final short TEXT__FONTROTATION = 137;
    public static final short TEXT__IDOFNEXTSHAPE = 138;
    public static final short TEXT__BIDIR = 139;
    public static final short TEXT__SINGLECLICKSELECTS = 187;
    public static final short TEXT__USEHOSTMARGINS = 188;
    public static final short TEXT__ROTATETEXTWITHSHAPE = 189;
    public static final short TEXT__SIZESHAPETOFITTEXT = 190;
    public static final short TEXT__SIZE_TEXT_TO_FIT_SHAPE = 191;
    public static final short GEOTEXT__UNICODE = 192;
    public static final short GEOTEXT__RTFTEXT = 193;
    public static final short GEOTEXT__ALIGNMENTONCURVE = 194;
    public static final short GEOTEXT__DEFAULTPOINTSIZE = 195;
    public static final short GEOTEXT__TEXTSPACING = 196;
    public static final short GEOTEXT__FONTFAMILYNAME = 197;
    public static final short GEOTEXT__REVERSEROWORDER = 240;
    public static final short GEOTEXT__HASTEXTEFFECT = 241;
    public static final short GEOTEXT__ROTATECHARACTERS = 242;
    public static final short GEOTEXT__KERNCHARACTERS = 243;
    public static final short GEOTEXT__TIGHTORTRACK = 244;
    public static final short GEOTEXT__STRETCHTOFITSHAPE = 245;
    public static final short GEOTEXT__CHARBOUNDINGBOX = 246;
    public static final short GEOTEXT__SCALETEXTONPATH = 247;
    public static final short GEOTEXT__STRETCHCHARHEIGHT = 248;
    public static final short GEOTEXT__NOMEASUREALONGPATH = 249;
    public static final short GEOTEXT__BOLDFONT = 250;
    public static final short GEOTEXT__ITALICFONT = 251;
    public static final short GEOTEXT__UNDERLINEFONT = 252;
    public static final short GEOTEXT__SHADOWFONT = 253;
    public static final short GEOTEXT__SMALLCAPSFONT = 254;
    public static final short GEOTEXT__STRIKETHROUGHFONT = 255;
    public static final short BLIP__CROPFROMTOP = 256;
    public static final short BLIP__CROPFROMBOTTOM = 257;
    public static final short BLIP__CROPFROMLEFT = 258;
    public static final short BLIP__CROPFROMRIGHT = 259;
    public static final short BLIP__BLIPTODISPLAY = 260;
    public static final short BLIP__BLIPFILENAME = 261;
    public static final short BLIP__BLIPFLAGS = 262;
    public static final short BLIP__TRANSPARENTCOLOR = 263;
    public static final short BLIP__CONTRASTSETTING = 264;
    public static final short BLIP__BRIGHTNESSSETTING = 265;
    public static final short BLIP__GAMMA = 266;
    public static final short BLIP__PICTUREID = 267;
    public static final short BLIP__DOUBLEMOD = 268;
    public static final short BLIP__PICTUREFILLMOD = 269;
    public static final short BLIP__PICTURELINE = 270;
    public static final short BLIP__PRINTBLIP = 271;
    public static final short BLIP__PRINTBLIPFILENAME = 272;
    public static final short BLIP__PRINTFLAGS = 273;
    public static final short BLIP__NOHITTESTPICTURE = 316;
    public static final short BLIP__PICTUREGRAY = 317;
    public static final short BLIP__PICTUREBILEVEL = 318;
    public static final short BLIP__PICTUREACTIVE = 319;
    public static final short GEOMETRY__LEFT = 320;
    public static final short GEOMETRY__TOP = 321;
    public static final short GEOMETRY__RIGHT = 322;
    public static final short GEOMETRY__BOTTOM = 323;
    public static final short GEOMETRY__SHAPEPATH = 324;
    public static final short GEOMETRY__VERTICES = 325;
    public static final short GEOMETRY__SEGMENTINFO = 326;
    public static final short GEOMETRY__ADJUSTVALUE = 327;
    public static final short GEOMETRY__ADJUST2VALUE = 328;
    public static final short GEOMETRY__ADJUST3VALUE = 329;
    public static final short GEOMETRY__ADJUST4VALUE = 330;
    public static final short GEOMETRY__ADJUST5VALUE = 331;
    public static final short GEOMETRY__ADJUST6VALUE = 332;
    public static final short GEOMETRY__ADJUST7VALUE = 333;
    public static final short GEOMETRY__ADJUST8VALUE = 334;
    public static final short GEOMETRY__ADJUST9VALUE = 335;
    public static final short GEOMETRY__ADJUST10VALUE = 336;
    public static final short GEOMETRY__SHADOWok = 378;
    public static final short GEOMETRY__3DOK = 379;
    public static final short GEOMETRY__LINEOK = 380;
    public static final short GEOMETRY__GEOTEXTOK = 381;
    public static final short GEOMETRY__FILLSHADESHAPEOK = 382;
    public static final short GEOMETRY__FILLOK = 383;
    public static final short FILL__FILLTYPE = 384;
    public static final short FILL__FILLCOLOR = 385;
    public static final short FILL__FILLOPACITY = 386;
    public static final short FILL__FILLBACKCOLOR = 387;
    public static final short FILL__BACKOPACITY = 388;
    public static final short FILL__CRMOD = 389;
    public static final short FILL__PATTERNTEXTURE = 390;
    public static final short FILL__BLIPFILENAME = 391;
    public static final short FILL__BLIPFLAGS = 392;
    public static final short FILL__WIDTH = 393;
    public static final short FILL__HEIGHT = 394;
    public static final short FILL__ANGLE = 395;
    public static final short FILL__FOCUS = 396;
    public static final short FILL__TOLEFT = 397;
    public static final short FILL__TOTOP = 398;
    public static final short FILL__TORIGHT = 399;
    public static final short FILL__TOBOTTOM = 400;
    public static final short FILL__RECTLEFT = 401;
    public static final short FILL__RECTTOP = 402;
    public static final short FILL__RECTRIGHT = 403;
    public static final short FILL__RECTBOTTOM = 404;
    public static final short FILL__DZTYPE = 405;
    public static final short FILL__SHADEPRESET = 406;
    public static final short FILL__SHADECOLORS = 407;
    public static final short FILL__ORIGINX = 408;
    public static final short FILL__ORIGINY = 409;
    public static final short FILL__SHAPEORIGINX = 410;
    public static final short FILL__SHAPEORIGINY = 411;
    public static final short FILL__SHADETYPE = 412;
    public static final short FILL__FILLED = 443;
    public static final short FILL__HITTESTFILL = 444;
    public static final short FILL__SHAPE = 445;
    public static final short FILL__USERECT = 446;
    public static final short FILL__NOFILLHITTEST = 447;
    public static final short LINESTYLE__COLOR = 448;
    public static final short LINESTYLE__OPACITY = 449;
    public static final short LINESTYLE__BACKCOLOR = 450;
    public static final short LINESTYLE__CRMOD = 451;
    public static final short LINESTYLE__LINETYPE = 452;
    public static final short LINESTYLE__FILLBLIP = 453;
    public static final short LINESTYLE__FILLBLIPNAME = 454;
    public static final short LINESTYLE__FILLBLIPFLAGS = 455;
    public static final short LINESTYLE__FILLWIDTH = 456;
    public static final short LINESTYLE__FILLHEIGHT = 457;
    public static final short LINESTYLE__FILLDZTYPE = 458;
    public static final short LINESTYLE__LINEWIDTH = 459;
    public static final short LINESTYLE__LINEMITERLIMIT = 460;
    public static final short LINESTYLE__LINESTYLE = 461;
    public static final short LINESTYLE__LINEDASHING = 462;
    public static final short LINESTYLE__LINEDASHSTYLE = 463;
    public static final short LINESTYLE__LINESTARTARROWHEAD = 464;
    public static final short LINESTYLE__LINEENDARROWHEAD = 465;
    public static final short LINESTYLE__LINESTARTARROWWIDTH = 466;
    public static final short LINESTYLE__LINEESTARTARROWLENGTH = 467;
    public static final short LINESTYLE__LINEENDARROWWIDTH = 468;
    public static final short LINESTYLE__LINEENDARROWLENGTH = 469;
    public static final short LINESTYLE__LINEJOINSTYLE = 470;
    public static final short LINESTYLE__LINEENDCAPSTYLE = 471;
    public static final short LINESTYLE__ARROWHEADSOK = 507;
    public static final short LINESTYLE__ANYLINE = 508;
    public static final short LINESTYLE__HITLINETEST = 509;
    public static final short LINESTYLE__LINEFILLSHAPE = 510;
    public static final short LINESTYLE__NOLINEDRAWDASH = 511;
    public static final short SHADOWSTYLE__TYPE = 512;
    public static final short SHADOWSTYLE__COLOR = 513;
    public static final short SHADOWSTYLE__HIGHLIGHT = 514;
    public static final short SHADOWSTYLE__CRMOD = 515;
    public static final short SHADOWSTYLE__OPACITY = 516;
    public static final short SHADOWSTYLE__OFFSETX = 517;
    public static final short SHADOWSTYLE__OFFSETY = 518;
    public static final short SHADOWSTYLE__SECONDOFFSETX = 519;
    public static final short SHADOWSTYLE__SECONDOFFSETY = 520;
    public static final short SHADOWSTYLE__SCALEXTOX = 521;
    public static final short SHADOWSTYLE__SCALEYTOX = 522;
    public static final short SHADOWSTYLE__SCALEXTOY = 523;
    public static final short SHADOWSTYLE__SCALEYTOY = 524;
    public static final short SHADOWSTYLE__PERSPECTIVEX = 525;
    public static final short SHADOWSTYLE__PERSPECTIVEY = 526;
    public static final short SHADOWSTYLE__WEIGHT = 527;
    public static final short SHADOWSTYLE__ORIGINX = 528;
    public static final short SHADOWSTYLE__ORIGINY = 529;
    public static final short SHADOWSTYLE__SHADOW = 574;
    public static final short SHADOWSTYLE__SHADOWOBSURED = 575;
    public static final short PERSPECTIVE__TYPE = 576;
    public static final short PERSPECTIVE__OFFSETX = 577;
    public static final short PERSPECTIVE__OFFSETY = 578;
    public static final short PERSPECTIVE__SCALEXTOX = 579;
    public static final short PERSPECTIVE__SCALEYTOX = 580;
    public static final short PERSPECTIVE__SCALEXTOY = 581;
    public static final short PERSPECTIVE__SCALEYTOY = 582;
    public static final short PERSPECTIVE__PERSPECTIVEX = 583;
    public static final short PERSPECTIVE__PERSPECTIVEY = 584;
    public static final short PERSPECTIVE__WEIGHT = 585;
    public static final short PERSPECTIVE__ORIGINX = 586;
    public static final short PERSPECTIVE__ORIGINY = 587;
    public static final short PERSPECTIVE__PERSPECTIVEON = 639;
    public static final short THREED__SPECULARAMOUNT = 640;
    public static final short THREED__DIFFUSEAMOUNT = 661;
    public static final short THREED__SHININESS = 662;
    public static final short THREED__EDGETHICKNESS = 663;
    public static final short THREED__EXTRUDEFORWARD = 664;
    public static final short THREED__EXTRUDEBACKWARD = 665;
    public static final short THREED__EXTRUDEPLANE = 666;
    public static final short THREED__EXTRUSIONCOLOR = 667;
    public static final short THREED__CRMOD = 648;
    public static final short THREED__3DEFFECT = 700;
    public static final short THREED__METALLIC = 701;
    public static final short THREED__USEEXTRUSIONCOLOR = 702;
    public static final short THREED__LIGHTFACE = 703;
    public static final short THREEDSTYLE__YROTATIONANGLE = 704;
    public static final short THREEDSTYLE__XROTATIONANGLE = 705;
    public static final short THREEDSTYLE__ROTATIONAXISX = 706;
    public static final short THREEDSTYLE__ROTATIONAXISY = 707;
    public static final short THREEDSTYLE__ROTATIONAXISZ = 708;
    public static final short THREEDSTYLE__ROTATIONANGLE = 709;
    public static final short THREEDSTYLE__ROTATIONCENTERX = 710;
    public static final short THREEDSTYLE__ROTATIONCENTERY = 711;
    public static final short THREEDSTYLE__ROTATIONCENTERZ = 712;
    public static final short THREEDSTYLE__RENDERMODE = 713;
    public static final short THREEDSTYLE__TOLERANCE = 714;
    public static final short THREEDSTYLE__XVIEWPOINT = 715;
    public static final short THREEDSTYLE__YVIEWPOINT = 716;
    public static final short THREEDSTYLE__ZVIEWPOINT = 717;
    public static final short THREEDSTYLE__ORIGINX = 718;
    public static final short THREEDSTYLE__ORIGINY = 719;
    public static final short THREEDSTYLE__SKEWANGLE = 720;
    public static final short THREEDSTYLE__SKEWAMOUNT = 721;
    public static final short THREEDSTYLE__AMBIENTINTENSITY = 722;
    public static final short THREEDSTYLE__KEYX = 723;
    public static final short THREEDSTYLE__KEYY = 724;
    public static final short THREEDSTYLE__KEYZ = 725;
    public static final short THREEDSTYLE__KEYINTENSITY = 726;
    public static final short THREEDSTYLE__FILLX = 727;
    public static final short THREEDSTYLE__FILLY = 728;
    public static final short THREEDSTYLE__FILLZ = 729;
    public static final short THREEDSTYLE__FILLINTENSITY = 730;
    public static final short THREEDSTYLE__CONSTRAINROTATION = 763;
    public static final short THREEDSTYLE__ROTATIONCENTERAUTO = 764;
    public static final short THREEDSTYLE__PARALLEL = 765;
    public static final short THREEDSTYLE__KEYHARSH = 766;
    public static final short THREEDSTYLE__FILLHARSH = 767;
    public static final short SHAPE__MASTER = 769;
    public static final short SHAPE__CONNECTORSTYLE = 771;
    public static final short SHAPE__BLACKANDWHITESETTINGS = 772;
    public static final short SHAPE__WMODEPUREBW = 773;
    public static final short SHAPE__WMODEBW = 774;
    public static final short SHAPE__OLEICON = 826;
    public static final short SHAPE__PREFERRELATIVERESIZE = 827;
    public static final short SHAPE__LOCKSHAPETYPE = 828;
    public static final short SHAPE__DELETEATTACHEDOBJECT = 830;
    public static final short SHAPE__BACKGROUNDSHAPE = 831;
    public static final short CALLOUT__CALLOUTTYPE = 832;
    public static final short CALLOUT__XYCALLOUTGAP = 833;
    public static final short CALLOUT__CALLOUTANGLE = 834;
    public static final short CALLOUT__CALLOUTDROPTYPE = 835;
    public static final short CALLOUT__CALLOUTDROPSPECIFIED = 836;
    public static final short CALLOUT__CALLOUTLENGTHSPECIFIED = 837;
    public static final short CALLOUT__ISCALLOUT = 889;
    public static final short CALLOUT__CALLOUTACCENTBAR = 890;
    public static final short CALLOUT__CALLOUTTEXTBORDER = 891;
    public static final short CALLOUT__CALLOUTMINUSX = 892;
    public static final short CALLOUT__CALLOUTMINUSY = 893;
    public static final short CALLOUT__DROPAUTO = 894;
    public static final short CALLOUT__LENGTHSPECIFIED = 895;
    public static final short GROUPSHAPE__SHAPENAME = 0x0380;
    public static final short GROUPSHAPE__DESCRIPTION = 0x0381;
    public static final short GROUPSHAPE__HYPERLINK = 0x0382;
    public static final short GROUPSHAPE__WRAPPOLYGONVERTICES = 0x0383;
    public static final short GROUPSHAPE__WRAPDISTLEFT = 0x0384;
    public static final short GROUPSHAPE__WRAPDISTTOP = 0x0385;
    public static final short GROUPSHAPE__WRAPDISTRIGHT = 0x0386;
    public static final short GROUPSHAPE__WRAPDISTBOTTOM = 0x0387;
    public static final short GROUPSHAPE__REGROUPID = 0x0388;
    public static final short GROUPSHAPE__UNUSED906 = 0x038A;
    public static final short GROUPSHAPE__TOOLTIP = 0x038D;
    public static final short GROUPSHAPE__SCRIPT = 0x038E;
    public static final short GROUPSHAPE__POSH = 0x038F;
    public static final short GROUPSHAPE__POSRELH = 0x0390;
    public static final short GROUPSHAPE__POSV = 0x0391;
    public static final short GROUPSHAPE__POSRELV = 0x0392;
    public static final short GROUPSHAPE__HR_PCT = 0x0393;
    public static final short GROUPSHAPE__HR_ALIGN = 0x0394;
    public static final short GROUPSHAPE__HR_HEIGHT = 0x0395;
    public static final short GROUPSHAPE__HR_WIDTH = 0x0396;
    public static final short GROUPSHAPE__SCRIPTEXT = 0x0397;
    public static final short GROUPSHAPE__SCRIPTLANG = 0x0398;
    public static final short GROUPSHAPE__BORDERTOPCOLOR = 0x039B;
    public static final short GROUPSHAPE__BORDERLEFTCOLOR = 0x039C;
    public static final short GROUPSHAPE__BORDERBOTTOMCOLOR = 0x039D;
    public static final short GROUPSHAPE__BORDERRIGHTCOLOR = 0x039E;
    public static final short GROUPSHAPE__TABLEPROPERTIES = 0x039F;
    public static final short GROUPSHAPE__TABLEROWPROPERTIES = 0x03A0;
    public static final short GROUPSHAPE__WEBBOT = 0x03A5;
    public static final short GROUPSHAPE__METROBLOB = 0x03A9;
    public static final short GROUPSHAPE__ZORDER = 0x03AA;
    public static final short GROUPSHAPE__FLAGS = 0x03BF;
    public static final short GROUPSHAPE__EDITEDWRAP = 953;
    public static final short GROUPSHAPE__BEHINDDOCUMENT = 954;
    public static final short GROUPSHAPE__ONDBLCLICKNOTIFY = 955;
    public static final short GROUPSHAPE__ISBUTTON = 956;
    public static final short GROUPSHAPE__1DADJUSTMENT = 957;
    public static final short GROUPSHAPE__HIDDEN = 958;
    public static final short GROUPSHAPE__PRINT = 959;

    private static final Map<Short, EscherPropertyMetaData> properties = initProps();

    private static Map<Short, EscherPropertyMetaData> initProps() {
        Map<Short, EscherPropertyMetaData> m = new HashMap<Short, EscherPropertyMetaData>();
        addProp(m, TRANSFORM__ROTATION, "transform.rotation");
        addProp(m, PROTECTION__LOCKROTATION, "protection.lockrotation");
        addProp(m, PROTECTION__LOCKASPECTRATIO, "protection.lockaspectratio");
        addProp(m, PROTECTION__LOCKPOSITION, "protection.lockposition");
        addProp(m, PROTECTION__LOCKAGAINSTSELECT,
                "protection.lockagainstselect");
        addProp(m, PROTECTION__LOCKCROPPING, "protection.lockcropping");
        addProp(m, PROTECTION__LOCKVERTICES, "protection.lockvertices");
        addProp(m, PROTECTION__LOCKTEXT, "protection.locktext");
        addProp(m, PROTECTION__LOCKADJUSTHANDLES,
                "protection.lockadjusthandles");
        addProp(m, PROTECTION__LOCKAGAINSTGROUPING,
                "protection.lockagainstgrouping",
                EscherPropertyMetaData.TYPE_BOOLEAN);
        addProp(m, TEXT__TEXTID, "text.textid");
        addProp(m, TEXT__TEXTLEFT, "text.textleft");
        addProp(m, TEXT__TEXTTOP, "text.texttop");
        addProp(m, TEXT__TEXTRIGHT, "text.textright");
        addProp(m, TEXT__TEXTBOTTOM, "text.textbottom");
        addProp(m, TEXT__WRAPTEXT, "text.wraptext");
        addProp(m, TEXT__SCALETEXT, "text.scaletext");
        addProp(m, TEXT__ANCHORTEXT, "text.anchortext");
        addProp(m, TEXT__TEXTFLOW, "text.textflow");
        addProp(m, TEXT__FONTROTATION, "text.fontrotation");
        addProp(m, TEXT__IDOFNEXTSHAPE, "text.idofnextshape");
        addProp(m, TEXT__BIDIR, "text.bidir");
        addProp(m, TEXT__SINGLECLICKSELECTS, "text.singleclickselects");
        addProp(m, TEXT__USEHOSTMARGINS, "text.usehostmargins");
        addProp(m, TEXT__ROTATETEXTWITHSHAPE, "text.rotatetextwithshape");
        addProp(m, TEXT__SIZESHAPETOFITTEXT, "text.sizeshapetofittext");
        addProp(m, TEXT__SIZE_TEXT_TO_FIT_SHAPE, "text.sizetexttofitshape",
                EscherPropertyMetaData.TYPE_BOOLEAN);
        addProp(m, GEOTEXT__UNICODE, "geotext.unicode");
        addProp(m, GEOTEXT__RTFTEXT, "geotext.rtftext");
        addProp(m, GEOTEXT__ALIGNMENTONCURVE, "geotext.alignmentoncurve");
        addProp(m, GEOTEXT__DEFAULTPOINTSIZE, "geotext.defaultpointsize");
        addProp(m, GEOTEXT__TEXTSPACING, "geotext.textspacing");
        addProp(m, GEOTEXT__FONTFAMILYNAME, "geotext.fontfamilyname");
        addProp(m, GEOTEXT__REVERSEROWORDER, "geotext.reverseroworder");
        addProp(m, GEOTEXT__HASTEXTEFFECT, "geotext.hastexteffect");
        addProp(m, GEOTEXT__ROTATECHARACTERS, "geotext.rotatecharacters");
        addProp(m, GEOTEXT__KERNCHARACTERS, "geotext.kerncharacters");
        addProp(m, GEOTEXT__TIGHTORTRACK, "geotext.tightortrack");
        addProp(m, GEOTEXT__STRETCHTOFITSHAPE, "geotext.stretchtofitshape");
        addProp(m, GEOTEXT__CHARBOUNDINGBOX, "geotext.charboundingbox");
        addProp(m, GEOTEXT__SCALETEXTONPATH, "geotext.scaletextonpath");
        addProp(m, GEOTEXT__STRETCHCHARHEIGHT, "geotext.stretchcharheight");
        addProp(m, GEOTEXT__NOMEASUREALONGPATH, "geotext.nomeasurealongpath");
        addProp(m, GEOTEXT__BOLDFONT, "geotext.boldfont");
        addProp(m, GEOTEXT__ITALICFONT, "geotext.italicfont");
        addProp(m, GEOTEXT__UNDERLINEFONT, "geotext.underlinefont");
        addProp(m, GEOTEXT__SHADOWFONT, "geotext.shadowfont");
        addProp(m, GEOTEXT__SMALLCAPSFONT, "geotext.smallcapsfont");
        addProp(m, GEOTEXT__STRIKETHROUGHFONT, "geotext.strikethroughfont");
        addProp(m, BLIP__CROPFROMTOP, "blip.cropfromtop");
        addProp(m, BLIP__CROPFROMBOTTOM, "blip.cropfrombottom");
        addProp(m, BLIP__CROPFROMLEFT, "blip.cropfromleft");
        addProp(m, BLIP__CROPFROMRIGHT, "blip.cropfromright");
        addProp(m, BLIP__BLIPTODISPLAY, "blip.bliptodisplay");
        addProp(m, BLIP__BLIPFILENAME, "blip.blipfilename");
        addProp(m, BLIP__BLIPFLAGS, "blip.blipflags");
        addProp(m, BLIP__TRANSPARENTCOLOR, "blip.transparentcolor");
        addProp(m, BLIP__CONTRASTSETTING, "blip.contrastsetting");
        addProp(m, BLIP__BRIGHTNESSSETTING, "blip.brightnesssetting");
        addProp(m, BLIP__GAMMA, "blip.gamma");
        addProp(m, BLIP__PICTUREID, "blip.pictureid");
        addProp(m, BLIP__DOUBLEMOD, "blip.doublemod");
        addProp(m, BLIP__PICTUREFILLMOD, "blip.picturefillmod");
        addProp(m, BLIP__PICTURELINE, "blip.pictureline");
        addProp(m, BLIP__PRINTBLIP, "blip.printblip");
        addProp(m, BLIP__PRINTBLIPFILENAME, "blip.printblipfilename");
        addProp(m, BLIP__PRINTFLAGS, "blip.printflags");
        addProp(m, BLIP__NOHITTESTPICTURE, "blip.nohittestpicture");
        addProp(m, BLIP__PICTUREGRAY, "blip.picturegray");
        addProp(m, BLIP__PICTUREBILEVEL, "blip.picturebilevel");
        addProp(m, BLIP__PICTUREACTIVE, "blip.pictureactive");
        addProp(m, GEOMETRY__LEFT, "geometry.left");
        addProp(m, GEOMETRY__TOP, "geometry.top");
        addProp(m, GEOMETRY__RIGHT, "geometry.right");
        addProp(m, GEOMETRY__BOTTOM, "geometry.bottom");
        addProp(m, GEOMETRY__SHAPEPATH, "geometry.shapepath",
                EscherPropertyMetaData.TYPE_SHAPEPATH);
        addProp(m, GEOMETRY__VERTICES, "geometry.vertices",
                EscherPropertyMetaData.TYPE_ARRAY);
        addProp(m, GEOMETRY__SEGMENTINFO, "geometry.segmentinfo",
                EscherPropertyMetaData.TYPE_ARRAY);
        addProp(m, GEOMETRY__ADJUSTVALUE, "geometry.adjustvalue");
        addProp(m, GEOMETRY__ADJUST2VALUE, "geometry.adjust2value");
        addProp(m, GEOMETRY__ADJUST3VALUE, "geometry.adjust3value");
        addProp(m, GEOMETRY__ADJUST4VALUE, "geometry.adjust4value");
        addProp(m, GEOMETRY__ADJUST5VALUE, "geometry.adjust5value");
        addProp(m, GEOMETRY__ADJUST6VALUE, "geometry.adjust6value");
        addProp(m, GEOMETRY__ADJUST7VALUE, "geometry.adjust7value");
        addProp(m, GEOMETRY__ADJUST8VALUE, "geometry.adjust8value");
        addProp(m, GEOMETRY__ADJUST9VALUE, "geometry.adjust9value");
        addProp(m, GEOMETRY__ADJUST10VALUE, "geometry.adjust10value");
        addProp(m, GEOMETRY__SHADOWok, "geometry.shadowOK");
        addProp(m, GEOMETRY__3DOK, "geometry.3dok");
        addProp(m, GEOMETRY__LINEOK, "geometry.lineok");
        addProp(m, GEOMETRY__GEOTEXTOK, "geometry.geotextok");
        addProp(m, GEOMETRY__FILLSHADESHAPEOK, "geometry.fillshadeshapeok");
        addProp(m, GEOMETRY__FILLOK, "geometry.fillok",
                EscherPropertyMetaData.TYPE_BOOLEAN);
        addProp(m, FILL__FILLTYPE, "fill.filltype");
        addProp(m, FILL__FILLCOLOR, "fill.fillcolor",
                EscherPropertyMetaData.TYPE_RGB);
        addProp(m, FILL__FILLOPACITY, "fill.fillopacity");
        addProp(m, FILL__FILLBACKCOLOR, "fill.fillbackcolor",
                EscherPropertyMetaData.TYPE_RGB);
        addProp(m, FILL__BACKOPACITY, "fill.backopacity");
        addProp(m, FILL__CRMOD, "fill.crmod");
        addProp(m, FILL__PATTERNTEXTURE, "fill.patterntexture");
        addProp(m, FILL__BLIPFILENAME, "fill.blipfilename");
        addProp(m, FILL__BLIPFLAGS, "fill.blipflags");
        addProp(m, FILL__WIDTH, "fill.width");
        addProp(m, FILL__HEIGHT, "fill.height");
        addProp(m, FILL__ANGLE, "fill.angle");
        addProp(m, FILL__FOCUS, "fill.focus");
        addProp(m, FILL__TOLEFT, "fill.toleft");
        addProp(m, FILL__TOTOP, "fill.totop");
        addProp(m, FILL__TORIGHT, "fill.toright");
        addProp(m, FILL__TOBOTTOM, "fill.tobottom");
        addProp(m, FILL__RECTLEFT, "fill.rectleft");
        addProp(m, FILL__RECTTOP, "fill.recttop");
        addProp(m, FILL__RECTRIGHT, "fill.rectright");
        addProp(m, FILL__RECTBOTTOM, "fill.rectbottom");
        addProp(m, FILL__DZTYPE, "fill.dztype");
        addProp(m, FILL__SHADEPRESET, "fill.shadepreset");
        addProp(m, FILL__SHADECOLORS, "fill.shadecolors",
                EscherPropertyMetaData.TYPE_ARRAY);
        addProp(m, FILL__ORIGINX, "fill.originx");
        addProp(m, FILL__ORIGINY, "fill.originy");
        addProp(m, FILL__SHAPEORIGINX, "fill.shapeoriginx");
        addProp(m, FILL__SHAPEORIGINY, "fill.shapeoriginy");
        addProp(m, FILL__SHADETYPE, "fill.shadetype");
        addProp(m, FILL__FILLED, "fill.filled");
        addProp(m, FILL__HITTESTFILL, "fill.hittestfill");
        addProp(m, FILL__SHAPE, "fill.shape");
        addProp(m, FILL__USERECT, "fill.userect");
        addProp(m, FILL__NOFILLHITTEST, "fill.nofillhittest",
                EscherPropertyMetaData.TYPE_BOOLEAN);
        addProp(m, LINESTYLE__COLOR, "linestyle.color",
                EscherPropertyMetaData.TYPE_RGB);
        addProp(m, LINESTYLE__OPACITY, "linestyle.opacity");
        addProp(m, LINESTYLE__BACKCOLOR, "linestyle.backcolor",
                EscherPropertyMetaData.TYPE_RGB);
        addProp(m, LINESTYLE__CRMOD, "linestyle.crmod");
        addProp(m, LINESTYLE__LINETYPE, "linestyle.linetype");
        addProp(m, LINESTYLE__FILLBLIP, "linestyle.fillblip");
        addProp(m, LINESTYLE__FILLBLIPNAME, "linestyle.fillblipname");
        addProp(m, LINESTYLE__FILLBLIPFLAGS, "linestyle.fillblipflags");
        addProp(m, LINESTYLE__FILLWIDTH, "linestyle.fillwidth");
        addProp(m, LINESTYLE__FILLHEIGHT, "linestyle.fillheight");
        addProp(m, LINESTYLE__FILLDZTYPE, "linestyle.filldztype");
        addProp(m, LINESTYLE__LINEWIDTH, "linestyle.linewidth");
        addProp(m, LINESTYLE__LINEMITERLIMIT, "linestyle.linemiterlimit");
        addProp(m, LINESTYLE__LINESTYLE, "linestyle.linestyle");
        addProp(m, LINESTYLE__LINEDASHING, "linestyle.linedashing");
        addProp(m, LINESTYLE__LINEDASHSTYLE, "linestyle.linedashstyle",
                EscherPropertyMetaData.TYPE_ARRAY);
        addProp(m, LINESTYLE__LINESTARTARROWHEAD,
                "linestyle.linestartarrowhead");
        addProp(m, LINESTYLE__LINEENDARROWHEAD, "linestyle.lineendarrowhead");
        addProp(m, LINESTYLE__LINESTARTARROWWIDTH,
                "linestyle.linestartarrowwidth");
        addProp(m, LINESTYLE__LINEESTARTARROWLENGTH,
                "linestyle.lineestartarrowlength");
        addProp(m, LINESTYLE__LINEENDARROWWIDTH, "linestyle.lineendarrowwidth");
        addProp(m, LINESTYLE__LINEENDARROWLENGTH,
                "linestyle.lineendarrowlength");
        addProp(m, LINESTYLE__LINEJOINSTYLE, "linestyle.linejoinstyle");
        addProp(m, LINESTYLE__LINEENDCAPSTYLE, "linestyle.lineendcapstyle");
        addProp(m, LINESTYLE__ARROWHEADSOK, "linestyle.arrowheadsok");
        addProp(m, LINESTYLE__ANYLINE, "linestyle.anyline");
        addProp(m, LINESTYLE__HITLINETEST, "linestyle.hitlinetest");
        addProp(m, LINESTYLE__LINEFILLSHAPE, "linestyle.linefillshape");
        addProp(m, LINESTYLE__NOLINEDRAWDASH, "linestyle.nolinedrawdash",
                EscherPropertyMetaData.TYPE_BOOLEAN);
        addProp(m, SHADOWSTYLE__TYPE, "shadowstyle.type");
        addProp(m, SHADOWSTYLE__COLOR, "shadowstyle.color",
                EscherPropertyMetaData.TYPE_RGB);
        addProp(m, SHADOWSTYLE__HIGHLIGHT, "shadowstyle.highlight");
        addProp(m, SHADOWSTYLE__CRMOD, "shadowstyle.crmod");
        addProp(m, SHADOWSTYLE__OPACITY, "shadowstyle.opacity");
        addProp(m, SHADOWSTYLE__OFFSETX, "shadowstyle.offsetx");
        addProp(m, SHADOWSTYLE__OFFSETY, "shadowstyle.offsety");
        addProp(m, SHADOWSTYLE__SECONDOFFSETX, "shadowstyle.secondoffsetx");
        addProp(m, SHADOWSTYLE__SECONDOFFSETY, "shadowstyle.secondoffsety");
        addProp(m, SHADOWSTYLE__SCALEXTOX, "shadowstyle.scalextox");
        addProp(m, SHADOWSTYLE__SCALEYTOX, "shadowstyle.scaleytox");
        addProp(m, SHADOWSTYLE__SCALEXTOY, "shadowstyle.scalextoy");
        addProp(m, SHADOWSTYLE__SCALEYTOY, "shadowstyle.scaleytoy");
        addProp(m, SHADOWSTYLE__PERSPECTIVEX, "shadowstyle.perspectivex");
        addProp(m, SHADOWSTYLE__PERSPECTIVEY, "shadowstyle.perspectivey");
        addProp(m, SHADOWSTYLE__WEIGHT, "shadowstyle.weight");
        addProp(m, SHADOWSTYLE__ORIGINX, "shadowstyle.originx");
        addProp(m, SHADOWSTYLE__ORIGINY, "shadowstyle.originy");
        addProp(m, SHADOWSTYLE__SHADOW, "shadowstyle.shadow");
        addProp(m, SHADOWSTYLE__SHADOWOBSURED, "shadowstyle.shadowobscured");
        addProp(m, PERSPECTIVE__TYPE, "perspective.type");
        addProp(m, PERSPECTIVE__OFFSETX, "perspective.offsetx");
        addProp(m, PERSPECTIVE__OFFSETY, "perspective.offsety");
        addProp(m, PERSPECTIVE__SCALEXTOX, "perspective.scalextox");
        addProp(m, PERSPECTIVE__SCALEYTOX, "perspective.scaleytox");
        addProp(m, PERSPECTIVE__SCALEXTOY, "perspective.scalextoy");
        addProp(m, PERSPECTIVE__SCALEYTOY, "perspective.scaleytoy");
        addProp(m, PERSPECTIVE__PERSPECTIVEX, "perspective.perspectivex");
        addProp(m, PERSPECTIVE__PERSPECTIVEY, "perspective.perspectivey");
        addProp(m, PERSPECTIVE__WEIGHT, "perspective.weight");
        addProp(m, PERSPECTIVE__ORIGINX, "perspective.originx");
        addProp(m, PERSPECTIVE__ORIGINY, "perspective.originy");
        addProp(m, PERSPECTIVE__PERSPECTIVEON, "perspective.perspectiveon");
        addProp(m, THREED__SPECULARAMOUNT, "3d.specularamount");
        addProp(m, THREED__DIFFUSEAMOUNT, "3d.diffuseamount");
        addProp(m, THREED__SHININESS, "3d.shininess");
        addProp(m, THREED__EDGETHICKNESS, "3d.edgethickness");
        addProp(m, THREED__EXTRUDEFORWARD, "3d.extrudeforward");
        addProp(m, THREED__EXTRUDEBACKWARD, "3d.extrudebackward");
        addProp(m, THREED__EXTRUDEPLANE, "3d.extrudeplane");
        addProp(m, THREED__EXTRUSIONCOLOR, "3d.extrusioncolor",
                EscherPropertyMetaData.TYPE_RGB);
        addProp(m, THREED__CRMOD, "3d.crmod");
        addProp(m, THREED__3DEFFECT, "3d.3deffect");
        addProp(m, THREED__METALLIC, "3d.metallic");
        addProp(m, THREED__USEEXTRUSIONCOLOR, "3d.useextrusioncolor",
                EscherPropertyMetaData.TYPE_RGB);
        addProp(m, THREED__LIGHTFACE, "3d.lightface");
        addProp(m, THREEDSTYLE__YROTATIONANGLE, "3dstyle.yrotationangle");
        addProp(m, THREEDSTYLE__XROTATIONANGLE, "3dstyle.xrotationangle");
        addProp(m, THREEDSTYLE__ROTATIONAXISX, "3dstyle.rotationaxisx");
        addProp(m, THREEDSTYLE__ROTATIONAXISY, "3dstyle.rotationaxisy");
        addProp(m, THREEDSTYLE__ROTATIONAXISZ, "3dstyle.rotationaxisz");
        addProp(m, THREEDSTYLE__ROTATIONANGLE, "3dstyle.rotationangle");
        addProp(m, THREEDSTYLE__ROTATIONCENTERX, "3dstyle.rotationcenterx");
        addProp(m, THREEDSTYLE__ROTATIONCENTERY, "3dstyle.rotationcentery");
        addProp(m, THREEDSTYLE__ROTATIONCENTERZ, "3dstyle.rotationcenterz");
        addProp(m, THREEDSTYLE__RENDERMODE, "3dstyle.rendermode");
        addProp(m, THREEDSTYLE__TOLERANCE, "3dstyle.tolerance");
        addProp(m, THREEDSTYLE__XVIEWPOINT, "3dstyle.xviewpoint");
        addProp(m, THREEDSTYLE__YVIEWPOINT, "3dstyle.yviewpoint");
        addProp(m, THREEDSTYLE__ZVIEWPOINT, "3dstyle.zviewpoint");
        addProp(m, THREEDSTYLE__ORIGINX, "3dstyle.originx");
        addProp(m, THREEDSTYLE__ORIGINY, "3dstyle.originy");
        addProp(m, THREEDSTYLE__SKEWANGLE, "3dstyle.skewangle");
        addProp(m, THREEDSTYLE__SKEWAMOUNT, "3dstyle.skewamount");
        addProp(m, THREEDSTYLE__AMBIENTINTENSITY, "3dstyle.ambientintensity");
        addProp(m, THREEDSTYLE__KEYX, "3dstyle.keyx");
        addProp(m, THREEDSTYLE__KEYY, "3dstyle.keyy");
        addProp(m, THREEDSTYLE__KEYZ, "3dstyle.keyz");
        addProp(m, THREEDSTYLE__KEYINTENSITY, "3dstyle.keyintensity");
        addProp(m, THREEDSTYLE__FILLX, "3dstyle.fillx");
        addProp(m, THREEDSTYLE__FILLY, "3dstyle.filly");
        addProp(m, THREEDSTYLE__FILLZ, "3dstyle.fillz");
        addProp(m, THREEDSTYLE__FILLINTENSITY, "3dstyle.fillintensity");
        addProp(m, THREEDSTYLE__CONSTRAINROTATION, "3dstyle.constrainrotation");
        addProp(m, THREEDSTYLE__ROTATIONCENTERAUTO,
                "3dstyle.rotationcenterauto");
        addProp(m, THREEDSTYLE__PARALLEL, "3dstyle.parallel");
        addProp(m, THREEDSTYLE__KEYHARSH, "3dstyle.keyharsh");
        addProp(m, THREEDSTYLE__FILLHARSH, "3dstyle.fillharsh");
        addProp(m, SHAPE__MASTER, "shape.master");
        addProp(m, SHAPE__CONNECTORSTYLE, "shape.connectorstyle");
        addProp(m, SHAPE__BLACKANDWHITESETTINGS, "shape.blackandwhitesettings");
        addProp(m, SHAPE__WMODEPUREBW, "shape.wmodepurebw");
        addProp(m, SHAPE__WMODEBW, "shape.wmodebw");
        addProp(m, SHAPE__OLEICON, "shape.oleicon");
        addProp(m, SHAPE__PREFERRELATIVERESIZE, "shape.preferrelativeresize");
        addProp(m, SHAPE__LOCKSHAPETYPE, "shape.lockshapetype");
        addProp(m, SHAPE__DELETEATTACHEDOBJECT, "shape.deleteattachedobject");
        addProp(m, SHAPE__BACKGROUNDSHAPE, "shape.backgroundshape");
        addProp(m, CALLOUT__CALLOUTTYPE, "callout.callouttype");
        addProp(m, CALLOUT__XYCALLOUTGAP, "callout.xycalloutgap");
        addProp(m, CALLOUT__CALLOUTANGLE, "callout.calloutangle");
        addProp(m, CALLOUT__CALLOUTDROPTYPE, "callout.calloutdroptype");
        addProp(m, CALLOUT__CALLOUTDROPSPECIFIED,
                "callout.calloutdropspecified");
        addProp(m, CALLOUT__CALLOUTLENGTHSPECIFIED,
                "callout.calloutlengthspecified");
        addProp(m, CALLOUT__ISCALLOUT, "callout.iscallout");
        addProp(m, CALLOUT__CALLOUTACCENTBAR, "callout.calloutaccentbar");
        addProp(m, CALLOUT__CALLOUTTEXTBORDER, "callout.callouttextborder");
        addProp(m, CALLOUT__CALLOUTMINUSX, "callout.calloutminusx");
        addProp(m, CALLOUT__CALLOUTMINUSY, "callout.calloutminusy");
        addProp(m, CALLOUT__DROPAUTO, "callout.dropauto");
        addProp(m, CALLOUT__LENGTHSPECIFIED, "callout.lengthspecified");
        addProp(m, GROUPSHAPE__SHAPENAME, "groupshape.shapename");
        addProp(m, GROUPSHAPE__DESCRIPTION, "groupshape.description");
        addProp(m, GROUPSHAPE__HYPERLINK, "groupshape.hyperlink");
        addProp(m, GROUPSHAPE__WRAPPOLYGONVERTICES,
                "groupshape.wrappolygonvertices",
                EscherPropertyMetaData.TYPE_ARRAY);
        addProp(m, GROUPSHAPE__WRAPDISTLEFT, "groupshape.wrapdistleft");
        addProp(m, GROUPSHAPE__WRAPDISTTOP, "groupshape.wrapdisttop");
        addProp(m, GROUPSHAPE__WRAPDISTRIGHT, "groupshape.wrapdistright");
        addProp(m, GROUPSHAPE__WRAPDISTBOTTOM, "groupshape.wrapdistbottom");
        addProp(m, GROUPSHAPE__REGROUPID, "groupshape.regroupid");
        addProp(m, GROUPSHAPE__UNUSED906, "unused906"); // 0x038A;
        addProp(m, GROUPSHAPE__TOOLTIP, "groupshape.wzTooltip"); // 0x038D;
        addProp(m, GROUPSHAPE__SCRIPT, "groupshape.wzScript"); // 0x038E;
        addProp(m, GROUPSHAPE__POSH, "groupshape.posh"); // 0x038F;
        addProp(m, GROUPSHAPE__POSRELH, "groupshape.posrelh"); // 0x0390;
        addProp(m, GROUPSHAPE__POSV, "groupshape.posv"); // 0x0391;
        addProp(m, GROUPSHAPE__POSRELV, "groupshape.posrelv"); // 0x0392;
        addProp(m, GROUPSHAPE__HR_PCT, "groupshape.pctHR"); // 0x0393;
        addProp(m, GROUPSHAPE__HR_ALIGN, "groupshape.alignHR"); // 0x0394;
        addProp(m, GROUPSHAPE__HR_HEIGHT, "groupshape.dxHeightHR"); // 0x0395;
        addProp(m, GROUPSHAPE__HR_WIDTH, "groupshape.dxWidthHR"); // 0x0396;
        addProp(m, GROUPSHAPE__SCRIPTEXT, "groupshape.wzScriptExtAttr"); // 0x0397;
        addProp(m, GROUPSHAPE__SCRIPTLANG, "groupshape.scriptLang"); // 0x0398;
        addProp(m, GROUPSHAPE__BORDERTOPCOLOR, "groupshape.borderTopColor"); // 0x039B;
        addProp(m, GROUPSHAPE__BORDERLEFTCOLOR, "groupshape.borderLeftColor"); // 0x039C;
        addProp(m, GROUPSHAPE__BORDERBOTTOMCOLOR,
                "groupshape.borderBottomColor"); // 0x039D;
        addProp(m, GROUPSHAPE__BORDERRIGHTCOLOR, "groupshape.borderRightColor"); // 0x039E;
        addProp(m, GROUPSHAPE__TABLEPROPERTIES, "groupshape.tableProperties"); // 0x039F;
        addProp(m, GROUPSHAPE__TABLEROWPROPERTIES,
                "groupshape.tableRowProperties"); // 0x03A0;
        addProp(m, GROUPSHAPE__WEBBOT, "groupshape.wzWebBot"); // 0x03A5;
        addProp(m, GROUPSHAPE__METROBLOB, "groupshape.metroBlob"); // 0x03A9;
        addProp(m, GROUPSHAPE__ZORDER, "groupshape.dhgt"); // 0x03AA;
        addProp(m, GROUPSHAPE__FLAGS, "groupshape.GroupShapeBooleanProperties"); // 0x03BF;

        addProp(m, GROUPSHAPE__EDITEDWRAP, "groupshape.editedwrap");
        addProp(m, GROUPSHAPE__BEHINDDOCUMENT, "groupshape.behinddocument");
        addProp(m, GROUPSHAPE__ONDBLCLICKNOTIFY, "groupshape.ondblclicknotify");
        addProp(m, GROUPSHAPE__ISBUTTON, "groupshape.isbutton");
        addProp(m, GROUPSHAPE__1DADJUSTMENT, "groupshape.1dadjustment");
        addProp(m, GROUPSHAPE__HIDDEN, "groupshape.hidden");
        addProp(m, GROUPSHAPE__PRINT, "groupshape.print",
                EscherPropertyMetaData.TYPE_BOOLEAN);
        return m;
    }

    private static void addProp(Map<Short, EscherPropertyMetaData> m, int s,
                                String propName) {
        m.put(Short.valueOf((short) s), new EscherPropertyMetaData(propName));
    }

    private static void addProp(Map<Short, EscherPropertyMetaData> m, int s,
                                String propName, byte type) {
        m.put(Short.valueOf((short) s), new EscherPropertyMetaData(propName,
                type));
    }

    public static String getPropertyName(short propertyId) {
        EscherPropertyMetaData o = properties.get(Short.valueOf(propertyId));
        return o == null ? "unknown" : o.getDescription();
    }

    public static byte getPropertyType(short propertyId) {
        EscherPropertyMetaData escherPropertyMetaData = properties.get(Short
                .valueOf(propertyId));
        return escherPropertyMetaData == null ? 0 : escherPropertyMetaData
                .getType();
    }
}
