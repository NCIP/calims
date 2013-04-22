/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Locale;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationQuantity;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.RateQuantity;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemQuantity;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerQuantity;
import gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyQuantity;
import gov.nih.nci.calims2.domain.inventory.enumeration.SpecimenQuantity;


/**
 * @author connollym
 *
 */
public class TypeSQLGenerator {
/**
 *   
 * @param id The id of the enumeration.
 * @param name The name of the enumeration.
 * @param description The description of the enumeration.
 * @param type The type of the enumeration.
 * @return String The insert statement.
 */
  public static String getTypeSQL(int id, String name, String description, String type) {
    return "INSERT INTO type (id, createdby, " 
    + "datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) " 
    + "VALUES (" + id + ", NULL, NULL, NULL, NULL, '" + description + "', '" + description + "', '" + description + " ', '" 
    + type + "', "
    + "'CURRENT');";
    
  }

  /**
   * @param args The arguements to the program.
   */
  public static void main(String[] args) {
    
    if (args.length == 0) {
      System.out.println("String argument needed.");
      System.exit(1);
    }

    String filename = args[0];

    try {
       BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
       for (ContainerQuantity cq : ContainerQuantity.values()) {
         bw.write(getTypeSQL(cq.getId(), cq.getName(), cq.getLocalizedValue(Locale.US), 
             TypeEnumeration.CONTAINER_QUANTITY.getName()));
         bw.newLine();
       }
       for (RateQuantity rq : RateQuantity.values()) {
         bw.write(getTypeSQL(rq.getId(), rq.getName(), rq.getLocalizedValue(Locale.US), 
             TypeEnumeration.RATE_QUANTITY.getName()));
         bw.newLine();
       }
       for (ServiceItemQuantity siq : ServiceItemQuantity.values()) {
         bw.write(getTypeSQL(siq.getId(), siq.getName(), siq.getLocalizedValue(Locale.US), 
             TypeEnumeration.SERVICEITEM_QUANTITY.getName()));
         bw.newLine();
       }
      
       for (QuotationQuantity qq : QuotationQuantity.values()) {
         bw.write(getTypeSQL(qq.getId(), qq.getName(), qq.getLocalizedValue(Locale.US), 
             TypeEnumeration.QUOTATION_QUANTITY.getName()));
         bw.newLine();
       }
       
       for (SpecimenQuantity sq : SpecimenQuantity.values()) {
         bw.write(getTypeSQL(sq.getId(), sq.getName(), sq.getLocalizedValue(Locale.US), 
             TypeEnumeration.SPECIMEN_QUANTITY.getName()));
         bw.newLine();
       }
       for (LabSupplyQuantity qt : LabSupplyQuantity.values()) {
         bw.write(getTypeSQL(qt.getId(), qt.getName(), qt.getLocalizedValue(Locale.US), 
             TypeEnumeration.LABSUPPLY_QUANTITY.getName()));
         bw.newLine();
       }
       bw.close();

    } catch (Exception e) {
        System.out.println("Error generating ddl script for ContainerQuantity: " + e.getMessage());
        e.printStackTrace();
    }
  }

}
