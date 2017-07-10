package oracle.fodemo.supplier.backing;

import oracle.adf.controller.TaskFlowId;

public class SupplierRegistrationServiceBean {
    private String taskFlowId = "/WEB-INF/supplier-registrationprocess-task-flow.xml#supplier-registrationprocess-task-flow";

    public SupplierRegistrationServiceBean() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }
}
