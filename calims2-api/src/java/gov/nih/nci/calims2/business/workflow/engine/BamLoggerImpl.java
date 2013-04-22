/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.workflow.engine;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.process.audit.NodeInstanceLog;
import org.drools.process.audit.ProcessInstanceLog;

import gov.nih.nci.calims2.dao.GenericDao;

/**
 * @author viseem
 * 
 */
public class BamLoggerImpl implements BamLogger {

  private GenericDao genericDao;

  /**
   * {@inheritDoc}
   */
  public void createNodeInstanceLog(NodeInstanceLog log) {
    genericDao.create(log);
  }

  /**
   * {@inheritDoc}
   */
  public void createProcessInstanceLog(ProcessInstanceLog log) {
    genericDao.create(log);
  }

  /**
   * {@inheritDoc}
   */
  public void updateProcessInstanceLog(long processInstanceId) {
    String query = "from ProcessInstanceLog as log where log.processInstanceId = :processInstanceId and log.end is null";
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("processInstanceId", processInstanceId);
    List<ProcessInstanceLog> result = genericDao.findByHQLQuery(query, params);
    if (result != null && result.size() != 0) {
      ProcessInstanceLog log = result.get(result.size() - 1);
      log.setEnd(new Date());
      genericDao.update(log);
    }

  }

  /**
   * @param genericDao the genericDao to set
   */
  public void setGenericDao(GenericDao genericDao) {
    this.genericDao = genericDao;
  }

}
