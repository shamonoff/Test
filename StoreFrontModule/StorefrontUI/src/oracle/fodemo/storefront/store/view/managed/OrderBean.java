package oracle.fodemo.storefront.store.view.managed;

import java.util.Date;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.OperationBinding;

import oracle.fodemo.storefront.adf.util.ADFUtils;

import oracle.fodemo.storefront.cart.view.managed.ShoppingCartBean;
import oracle.fodemo.storefront.jsf.util.JSFUtils;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlAttrsBinding;
import oracle.jbo.uicli.binding.JUCtrlListBinding;


public class OrderBean {

    public OrderBean() {
    }

    /**
     * @param evt
     */
    public void editPaymentOption(ActionEvent evt) {
        edit("FindPaymentOptionsByIdExecuteWithParams", "PaymentOptionId", "paymentId", "PaymentOptionId");
    }

    /**
     * @param evt
     */
    public void editAddress(ActionEvent evt) {
        edit("ExecuteWithParamsFindAddressesById", "ShipToAddressId", "id", "AddressId");
    }

    private Object edit(String opName, String listBindingName, String varName, String colName) {
        DCBindingContainer bindings = ADFUtils.getDCBindingContainer();
        OperationBinding ob = 
            (OperationBinding)bindings.get(opName);
        JUCtrlListBinding  listBinding = (JUCtrlListBinding)bindings.get(listBindingName) ;
        Row row = (Row)listBinding.getSelectedValue();
        ob.getParamsMap().put( varName, row.getAttribute(colName) );
        return ob.execute();             
    }

    /**
     * @param evt
     */
    public void confirmAddPaymentOptionsActionListener(ActionEvent evt){
        commit();
        DCBindingContainer bindings = ADFUtils.getDCBindingContainer();
        JUCtrlListBinding listBinding = (JUCtrlListBinding)bindings.get("PaymentOptionId");
        listBinding.getListIterBinding().executeQuery();
    }

    private void commit(){
        ADFUtils.findOperation("Commit").execute();
    }

    /**
     * @param evt
     */
    public void cancelAddPaymentOptionsActionListener(ActionEvent evt){
        cancelAdd("PaymentOptionsForUserIterator");
    }
    
    private void cancelAdd(String itrName){
        DCIteratorBinding itr = ADFUtils.findIterator(itrName);
        itr.removeCurrentRow();
    }

    /**
     * @param evt
     */
    public void confirmEditPaymentOptionsActionListener(ActionEvent evt){
        commit(); 
        DCBindingContainer bindings = ADFUtils.getDCBindingContainer();
        JUCtrlListBinding listBinding = (JUCtrlListBinding)bindings.get("PaymentOptionId");
        listBinding.getListIterBinding().executeQuery();
    }


    /**
     * @param evt
     */
    public void confirmAddAddressUsagesActionListener(ActionEvent evt){
        commit();  
        DCBindingContainer bindings = ADFUtils.getDCBindingContainer();
        JUCtrlListBinding listBinding = (JUCtrlListBinding)bindings.get("ShipToAddressId");
        listBinding.getListIterBinding().executeQuery();
    }

    /**
     * @param evt
     */
    public void cancelAddAddressUsagesActionListener(ActionEvent evt){
        cancelAdd("AddressesAndUsagesIterator");
    }

    /**
     * @param evt
     */
    public void confirmEditAddressUsagesActionListener(ActionEvent evt){
        commit(); 
        DCBindingContainer bindings = ADFUtils.getDCBindingContainer();
        JUCtrlListBinding listBinding = (JUCtrlListBinding)bindings.get("ShipToAddressId");
        listBinding.getListIterBinding().executeQuery();
    }

    /**
     * @return
     */
    public String submitOrder() {
        DCBindingContainer bindings =
            (DCBindingContainer)JSFUtils.resolveExpression("#{bindings}");
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        JUCtrlAttrsBinding statusCode =
            (JUCtrlAttrsBinding)bindings.findNamedObject("OrderStatusCode");
        statusCode.setAttribute("OrderStatusCode", "PENDING");
        JUCtrlAttrsBinding orderDate =
            (JUCtrlAttrsBinding)bindings.findNamedObject("OrderDate");
        orderDate.setAttribute("OrderDate", new Date());
        JUCtrlAttrsBinding orderId =
            (JUCtrlAttrsBinding)bindings.findNamedObject("OrderId");
        JSFUtils.storeOnSession("orderId", orderId.getAttribute("OrderId"));

        JUCtrlAttrsBinding invoiceTotal =
            (JUCtrlAttrsBinding)bindings.findNamedObject("InvoiceTotal");

        JUCtrlAttrsBinding orderTotal =
            (JUCtrlAttrsBinding)bindings.findNamedObject("OrderTotal");
        orderTotal.setAttribute("OrderTotal", invoiceTotal.getAttribute("InvoiceTotal"));

        Object result = operationBinding.execute();
        
        ShoppingCartBean shoppingCartBean = (ShoppingCartBean)JSFUtils.resolveExpression("#{shoppingCartBean}");
        shoppingCartBean.removeAllItems();
        return "orderSummary";
    }
    
}
