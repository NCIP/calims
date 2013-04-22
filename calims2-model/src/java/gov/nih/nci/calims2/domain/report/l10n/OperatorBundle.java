/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.report.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.report.enumeration.Operator;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class OperatorBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{Operator.LESS_THAN.name(), "Less Than"},
{Operator.GREATER_THAN.name(), "Greater Than"},
{Operator.LESS_THAN_OR_EQUAL.name(), "Less Than Or Equal To"},
{Operator.GREATER_THAN_OR_EQUAL.name(), "Greater Than Or Equal To"},
{Operator.EQUAL_TO.name(), "Equal To"},
{Operator.NOT_EQUAL_TO.name(), "Not Equal To"},
{Operator.IS_NULL.name(), "Is Null"},
{Operator.IS_NOT_NULL.name(), "Is Not Null"},
{Operator.IS_NOT_LIKE.name(), "Is Not Like"},
{Operator.IS_LIKE.name(), "Is Like"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}