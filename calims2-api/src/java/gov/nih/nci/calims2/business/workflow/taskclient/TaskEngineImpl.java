/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.workflow.taskclient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.drools.task.Task;
import org.drools.task.query.TaskSummary;
import org.drools.task.service.TaskClient;
import org.drools.task.service.TaskClientHandler.TaskOperationResponseHandler;
import org.drools.task.service.responsehandlers.BlockingGetTaskResponseHandler;
import org.drools.task.service.responsehandlers.BlockingTaskOperationResponseHandler;
import org.drools.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;

/**
 * @author viseem
 * 
 */
public class TaskEngineImpl extends TaskClientSupport implements TaskEngine {
  /**
   * The locale to use with the TaskEngine. This is hard-coded here because at this time, it is also hardcoded in the
   * WSHumanTaskHandler.
   */
  private static final String LOCALE = "en-UK";
  private static final int DEFAULT_WAIT_TIME = 10000;

  /**
   * {@inheritDoc}
   */
  public List<TaskListItem> getTasksForUser(final String userName) {
    TaskClientCallback<List<TaskListItem>> callback = new TaskClientCallback<List<TaskListItem>>() {

      public List<TaskListItem> doInTaskClient(TaskClient client) {
        BlockingTaskSummaryResponseHandler summaryHandler = new BlockingTaskSummaryResponseHandler();
        client.getTasksAssignedAsPotentialOwner(userName, LOCALE, summaryHandler);
        summaryHandler.waitTillDone(DEFAULT_WAIT_TIME);
        if (summaryHandler.hasError()) {
          throw summaryHandler.getError();
        }
        List<TaskListItem> result = new ArrayList<TaskListItem>();
        for (TaskSummary summary : summaryHandler.getResults()) {
          result.add(new TaskListItem(summary));
        }
        return result;
      }

    };
    return getTaskClientTemplate().execute(callback);
  }

  /**
   * {@inheritDoc}
   */
  public void executeTaskTransition(final String userName, final TaskTransition transition, final Long taskId) {
    TaskClientCallback<Object> callback = new TaskClientCallback<Object>() {

      public Object doInTaskClient(TaskClient client) {
        BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
        try {
          Method method = client.getClass().getMethod(transition.getMethodName(), long.class, String.class,
              TaskOperationResponseHandler.class);
          method.invoke(client, taskId, userName, responseHandler);
        } catch (SecurityException e) {
          throw new InternalError("Can not happen - transition methods are public");
        } catch (NoSuchMethodException e) {
          throw new InternalError("Can not happen - transition methods exist");
        } catch (IllegalArgumentException e) {
          throw new InternalError("Can not happen - parameters are correct");
        } catch (IllegalAccessException e) {
          throw new InternalError("Can not happen - transition methods are public");
        } catch (InvocationTargetException e) {
          throw new RuntimeException(e.getCause());
        }
        responseHandler.waitTillDone(DEFAULT_WAIT_TIME);
        if (responseHandler.hasError()) {
          throw responseHandler.getError();
        }
        return null;
      }

    };
    getTaskClientTemplate().execute(callback);
  }
  
  /**
   * {@inheritDoc}
   */
  public void completeTask(final String userName, final Long taskId) {
    TaskClientCallback<Object> callback = new TaskClientCallback<Object>() {

      public Object doInTaskClient(TaskClient client) {
        BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
        client.complete(taskId, userName, null, responseHandler);
        responseHandler.waitTillDone(DEFAULT_WAIT_TIME);
        if (responseHandler.hasError()) {
          throw responseHandler.getError();
        }
        return null;
      }

    };
    getTaskClientTemplate().execute(callback);
  }

  /**
   * {@inheritDoc}
   */
  public void failTask(final String userName, final Long taskId) {
    TaskClientCallback<Object> callback = new TaskClientCallback<Object>() {

      public Object doInTaskClient(TaskClient client) {
        BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
        client.fail(taskId, userName, null, responseHandler);
        responseHandler.waitTillDone(DEFAULT_WAIT_TIME);
        if (responseHandler.hasError()) {
          throw responseHandler.getError();
        }
        return null;
      }
    };
    getTaskClientTemplate().execute(callback);
  }

  /**
   * {@inheritDoc}
   */
  public Task getTask(final long taskId) {
    TaskClientCallback<Task> callback = new TaskClientCallback<Task>() {

      public Task doInTaskClient(TaskClient client) {
        BlockingGetTaskResponseHandler taskHandler = new BlockingGetTaskResponseHandler();
        client.getTask(taskId, taskHandler);
        taskHandler.waitTillDone(DEFAULT_WAIT_TIME);
        if (taskHandler.hasError()) {
          throw taskHandler.getError();
        }
        return taskHandler.getTask();
      }

    };
    return getTaskClientTemplate().execute(callback);
  }

 

}
