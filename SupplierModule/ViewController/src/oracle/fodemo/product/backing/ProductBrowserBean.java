package oracle.fodemo.product.backing;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.fodemo.supplier.view.utils.ADFUtils;

public class ProductBrowserBean {
    private RichTable productTable;

    public ProductBrowserBean() {
    }

    public void confirmDeleteAction(DialogEvent dialogEvent) {
        DialogEvent.Outcome result = dialogEvent.getOutcome();
       // System.out.println("o/c result:" + result);
        if (result == DialogEvent.Outcome.ok ||
            result == DialogEvent.Outcome.yes) {
            Object opResult = null;
             OperationBinding removeEntityBinding =
                this.findOperationBinding("removeProduct");
                 opResult = removeEntityBinding.execute();
            if (!removeEntityBinding.getErrors().isEmpty()) {
                return;//Error needs to be handled
            }
            OperationBinding operationBinding =
                this.findOperationBinding("Delete");
            opResult = operationBinding.execute();
           // System.out.println("opResult1:" + opResult);
            if (!operationBinding.getErrors().isEmpty()) {
                return; //Error needs to be handled
            }
        }
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(productTable);
            

    }

    private OperationBinding findOperationBinding(String pOperationBindingName) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        OperationBinding operation =
            bindings.getOperationBinding(pOperationBindingName);
        return operation;
    }

    public void setProductTable(RichTable productTable) {
        this.productTable = productTable;
    }

    public RichTable getProductTable() {
        return productTable;
    }
}
