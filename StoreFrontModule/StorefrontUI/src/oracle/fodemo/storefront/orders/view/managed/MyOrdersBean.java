package oracle.fodemo.storefront.orders.view.managed;

import java.util.Date;
import java.util.HashSet;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.OperationBinding;

import oracle.fodemo.storefront.adf.util.ADFUtils;
import oracle.fodemo.storefront.cart.view.managed.ShoppingCartBean;
import oracle.fodemo.storefront.jsf.util.JSFUtils;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlAttrsBinding;


public class MyOrdersBean {

    private boolean editGiftMessage;
    
    public String registerNav = ControllerContext.getInstance().getGlobalViewActivityURL("register");
    public String profileNav =  ControllerContext.getInstance().getGlobalViewActivityURL("updateUserInfo");
    public String homeNav =  ControllerContext.getInstance().getGlobalViewActivityURL("home");



    public MyOrdersBean() {
        editGiftMessage = false;
    }

    /**
     * @param evt
     */
    public void cancelOrderActionListener(ActionEvent evt){
        OperationBinding opBinding = ADFUtils.findOperation("cancelOrder");
        opBinding.execute();
    }


    /**
     * @param evt
     */
    public void commitDialogListener(DialogEvent evt){       
        commit();
    }

    /**
     * @param evt
     */
    public void toggleEditGiftMessageActionListener(ActionEvent evt){
        editGiftMessage = !editGiftMessage;
    }

    /**
     * @param evt
     */
    public void removeItemActionListener(ActionEvent evt){
        OperationBinding opBinding = ADFUtils.findOperation("deleteCurrentMyOrderItem");
        opBinding.execute();
    }

    /**
     * @param evt
     */
    public void commitActionListener(ActionEvent evt){
        commit();   
    }

    private void commit(){
        DCBindingContainer bindings =
            (DCBindingContainer)JSFUtils.resolveExpression("#{bindings}");
        OperationBinding opBinding = bindings.getOperationBinding("Commit");
        JUCtrlAttrsBinding invoiceTotal =
            (JUCtrlAttrsBinding)bindings.findNamedObject("InvoiceTotal");
        JUCtrlAttrsBinding orderTotal =
            (JUCtrlAttrsBinding)bindings.findNamedObject("OrderTotal");
        orderTotal.setAttribute("OrderTotal", invoiceTotal.getAttribute("InvoiceTotal"));
        opBinding.execute();       
    }
        
    /**
     * @return
     */
    public String cancelButtonAction() {
        // the use cancelled the edit on the order. With the cancelling the operation, there
        // are 3 possible states
        // i)   The user didn't change a value
        // ii)  The user changed a value but this hasn't been submitted to the model
        // iii) The user has changed a value and the change has been submitted to the 
        //      model but hasn't been committed yet. 
        // we don't need to do anything special for i) and ii) but need to handle iii), 
        // which we can do by checking #{bindings.Commit.enabled} on a "Commit" binding 
        // in the pageDef file. If there has been an update to the model then the commit
        // binding shows enabled to persist the change. This information is what we will
        // look at to determine if there is a need to do anything
        
        Boolean commitState = (Boolean) JSFUtils.resolveExpression("#{bindings.Commit.enabled}");
        // if the expression cannot be resolved then assume that no clean up is required. The expression
        // cannot be resolved if the commit binding is missing, which might be the case if this code
        // line is used in a custom application
        boolean commitEnabled = commitState!= null?commitState.booleanValue():false;
        
        // A Rollback operation is defined in the pageDef file and is used to undo the changes. Note that 
        // this rollback does undo all changes that haven't been persisted so far
        
        if (commitEnabled){
            //todo: i think this should be calling rollback (like what we do above for commit, not ordersiterator - ?
            DCBindingContainer dcbindings = (DCBindingContainer) JSFUtils.resolveExpression("#{bindings}");
            DCIteratorBinding dciter = (DCIteratorBinding) dcbindings.get("OrdersIterator");
            dciter.getCurrentRow().refresh(Row.REFRESH_UNDO_CHANGES);
        }
        return null;
    }

    /**
     * @param actionEvent
     */
    public void onEditOrders(ActionEvent actionEvent) {
        synchronizeViewAndBinding(actionEvent);
    }

    /**
     * @param actionEvent
     */
    public void onCancelOrders(ActionEvent actionEvent) {
        synchronizeViewAndBinding(actionEvent);
    }

    /**
     * deletes all orders and order items.
     * @param actionEvent
     */
    public void onConfirmCancelOrders(ActionEvent actionEvent) {    
        DCBindingContainer dcbindings = (DCBindingContainer) JSFUtils.resolveExpression("#{bindings}");
        DCIteratorBinding dciter = (DCIteratorBinding) dcbindings.get("OrdersIterator");
        HashSet<Key> keySet = new HashSet<Key>();
        keySet.add(dciter.getCurrentRow().getKey());
        
        //call externalized method on the AM
        OperationBinding deleteOrdersOperationBinding = dcbindings.getOperationBinding("cancelOrders");
        deleteOrdersOperationBinding.getParamsMap().put("keySet",keySet);
        // delete orders and order items
        deleteOrdersOperationBinding.execute();                    
    }
    
    /**
     * method ensures that the current displayed table record is synchronized with 
     * the OrdersIterator current row
     * @param actionEvent
     */
    private void synchronizeViewAndBinding(ActionEvent actionEvent){
        RichCommandLink link = (RichCommandLink) actionEvent.getSource();
        RichTable table = (RichTable) link.getParent().getParent();
        // The table current row data is of type FacesCtrHierNodeBinding, which
        // contains the current row
        Row rw = ((FacesCtrlHierNodeBinding) table.getRowData()).getRow();
        //synchornize the binding with the table. This seems to be required because clicking
        //onto the command link that launches the edit dialog doesn't set the current row in time
        DCBindingContainer dcbindings = (DCBindingContainer) JSFUtils.resolveExpression("#{bindings}");
        DCIteratorBinding dciter = (DCIteratorBinding) dcbindings.get("OrdersIterator");
        dciter.setCurrentRowWithKey(rw.getKey().toStringFormat(true));
        dciter.refreshIfNeeded();
        return;
    }

    /**
     * @param newshippingAddressEditable
     */
    public void setEditGiftMessage(boolean newshippingAddressEditable) {
        this.editGiftMessage = newshippingAddressEditable;
    }

    /**
     * @return
     */
    public boolean isEditGiftMessage() {
        return editGiftMessage;
    }

    public void setRegisterNav(String registerNav) {
        this.registerNav = registerNav;
    }

    public String getRegisterNav() {
        return registerNav;
    }

    public void setProfileNav(String profileNav) {
        this.profileNav = profileNav;
    }

    public String getProfileNav() {
        return profileNav;
    }

    public void setHomeNav(String homeNav) {
        this.homeNav = homeNav;
    }

    public String getHomeNav() {
        return homeNav;
    }
}
