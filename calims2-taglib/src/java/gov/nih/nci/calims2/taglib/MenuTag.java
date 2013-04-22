/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import gov.nih.nci.calims2.taglib.page.PageTag;
import gov.nih.nci.calims2.uic.dojo.DojoMenuRenderer;
import gov.nih.nci.calims2.uic.menu.MenuComponent;

/**
 * Custom tag wrapper for the DojoMenuRenderer.
 * 
 * @author viseem
 * 
 */
public class MenuTag extends TagSupport {

  private static final long serialVersionUID = -2094745751361863888L;
  
  private String id;
  private MenuComponent menu;

  /**
   * {@inheritDoc}
   */
  public int doStartTag() throws JspException {
    PageTag pageTag = PageTag.getPageTagLocator().getTag(pageContext, this);
    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    DojoMenuRenderer renderer = new DojoMenuRenderer(id, false, request.getContextPath());
    pageTag.getDojoManager().addDojoTypes(renderer.getRequiredTypes());
    menu.accept(renderer);
    try {
      pageContext.getOut().print(renderer.getHtml());
    } catch (IOException e) {
      throw new JspException("Writing error in MenuTag", e);
    }
    return SKIP_BODY;
  }

  /**
   * {@inheritDoc}
   */
  public int doEndTag() {
    id = null;
    menu = null;
    return EVAL_PAGE;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @param menu the menu to set
   */
  public void setMenu(MenuComponent menu) {
    this.menu = menu;
  }

}
