/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.html;

/**
 * @author viseem
 *
 */
public enum HtmlElement {
  /** A tag. */
  A,
  /** ADDRESS tag. */
  ADDRESS,
  /** APPLET tag. */
  APPLET,
  /** AREA tag. */
  AREA,
  /** B tag. */
  B,
  /** BASE tag. */
  BASE,
  /** BASEFONT tag. */
  BASEFONT, 
  /** BIG tag. */
  BIG, 
  /** BLOCKQUOTE tag. */
  BLOCKQUOTE, 
  /** BODY tag. */
  BODY, 
  /** BR tag. */
  BR, 
  /** CAPTION tag. */
  CAPTION, 
  /** CENTER tag. */
  CENTER, 
  /** CITE tag. */
  CITE, 
  /** CODE tag. */
  CODE,
  /** DD tag. */
  DD, 
  /** DFN tag. */
  DFN, 
  /** DIR tag. */
  DIR, 
  /** DIV tag. */
  DIV, 
  /** DL tag. */
  DL, 
  /** DT tag. */
  DT, 
  /** EM tag. */
  EM, 
  /** FONT tag. */
  FONT, 
  /** FORM tag. */
  FORM, 
  /** FRAME tag. */
  FRAME,
  /** FRAMESET tag. */
  FRAMESET, 
  /** H1 tag. */
  H1, 
  /** H2 tag. */
  H2, 
  /** H3 tag. */
  H3, 
  /** H4 tag. */
  H4, 
  /** H5 tag. */
  H5, 
  /** H6 tag. */
  H6,
  /** HEAD tag. */
  HEAD, 
  /** HR tag. */
  HR, 
  /** HTML tag. */
  HTML,
  /** I tag. */
  I, 
  /** IMG tag. */
  IMG, 
  /** IMPLIED tag. */
  IMPLIED,
  /** INPUT tag. */
  INPUT, 
  /** ISINDEX tag. */
  ISINDEX,
  /** KBD tag. */
  KBD, 
  /** LI tag. */
  LI, 
  /** LINK tag. */
  LINK, 
  /** MAP tag. */
  MAP,
  /** MENU tag. */
  MENU,
  /** META tag. */
  META, 
  /** NOFRAMES tag. */
  NOFRAMES,
  /** OBJECT tag. */
  OBJECT, 
  /** OL tag. */
  OL,
  /** OPTION tag. */
  OPTION,
  /** P tag. */
  P,
  /** PARAM tag. */
  PARAM,
  /** PRE tag. */
  PRE, 
  /** S tag. */
  S,
  /** SAMP tag. */
  SAMP, 
  /** SCRIPT tag. */
  SCRIPT,
  /** SELECT tag. */
  SELECT,
  /** SMALL tag. */
  SMALL, 
  /** SPAN tag. */
  SPAN, 
  /** STRIKE tag. */
  STRIKE,
  /** STRONG tag. */
  STRONG,
  /** STYLE tag. */
  STYLE,
  /** SUB tag. */
  SUB,
  /** SUP tag. */
  SUP,
  /** TABLE tag. */
  TABLE,
  /** TABLE tag. */
  TD, 
  /** TEXTAREA tag. */
  TEXTAREA,
  /** TH tag. */
  TH, 
  /** TITLE tag. */
  TITLE,
  /** TR tag. */
  TR,
  /** TT tag. */
  TT,
  /** U tag. */
  U,
  /** UL tag. */
  UL, 
  /** VAR tag. */
  VAR;
  
  /**
   * Return the tagName of this HtmlElement.
   * @return the tagName of this HtmlElement.
   */
  public String getTagName() {
    return name().toLowerCase();
  }
}
