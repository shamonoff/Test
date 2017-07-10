package oracle.fodemo.storefront.account.view.managed;

import java.io.Serializable;
import oracle.adf.controller.TaskFlowId;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.fodemo.storefront.adf.util.ADFUtils;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;


public class RegistrationBean implements Serializable{
    
    private String taskFlowId = "/WEB-INF/customer-registration-task-flow.xml#customer-registration-task-flow";
    public RegistrationBean() {
    }

    /**
     * @return
     */
    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    /**
     * @return
     */
    public String employeeregistrationtaskflow() {
        taskFlowId = "/WEB-INF/employee-registration-task-flow.xml#employee-registration-task-flow";
        return null;
    }

    /**
     * @return
     */
    public String customerregistrationtaskflow() {
        taskFlowId = "/WEB-INF/customer-registration-task-flow.xml#customer-registration-task-flow";
        return null;
    }
    

}
