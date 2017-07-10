package oracle.fodemo.storefront.account.view.managed;

import java.io.Serializable;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.binding.OperationBinding;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;

import oracle.fodemo.storefront.adf.util.ADFUtils;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

public class CustRegDefineAddressesBean implements Serializable {
    String beanName = "CustRegDefineAddressesBean";
    
    public CustRegDefineAddressesBean() {
        
    }


    /**
     * @param pEvent
     */
    public void listChangeListener(ValueChangeEvent pEvent){
        this.refreshAddressIterator();
    }
    
    public void refreshAddressIterator(){
        OperationBinding refresh = this.findOperationBinding("RefreshCustomerAddressIterator");
        refresh.execute();
    }

    /**
     * @param event
     */
    public void editAddressDialogListener(DialogEvent event){
        DialogEvent.Outcome outcome = event.getOutcome();
    /**
        if ( event.getOutcome().equals(event.cancel)){
            OperationBinding operation = findOperationBinding("cancelEditAddress");
            operation.execute();
        } 
    **/
    }
    
    private OperationBinding findOperationBinding(String pOperationBindingName){
        BindingContainer bindings = ADFUtils.getBindingContainer();
        OperationBinding operation = bindings.getOperationBinding(pOperationBindingName);
        return operation;
    }

    /**
     * @param event
     */
    public void addNewAddress(ActionEvent event) {
        OperationBinding createInsert = this.findOperationBinding("addNewAddress");
        createInsert.execute();
    }
    
    /**
     * Trigger action for canceling an Address edit. This Needed because 
     * DialogEventListener does not trigger for the Dialog's default cancel
     * button.
     * @param event
     */
    public void cancelEditAddress(ActionEvent event){
        OperationBinding operation = findOperationBinding("cancelEditAddress");
        operation.execute();        
    }

    /**
     * @return
     */
    public String createAddress() {   
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding dcitr = 
            (DCIteratorBinding)bindings.get("CustomerAddressIterator");
        RowSetIterator rowSetItr = dcitr.getRowSetIterator();
        Row currentRow = rowSetItr.createRow();
        rowSetItr.insertRow(currentRow);
        dcitr.setCurrentRowWithKey(currentRow.getKey().toStringFormat(true));
        dcitr.refreshIfNeeded();
        return null;
    }

    /**
     * @param param
     */
    public void setBeanName(String param) {
        this.beanName = param;
    }

    /**
     * @return
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * @param e
     */
    public void confirmDeleteDialogListener(DialogEvent e){
        OperationBinding oper = this.findOperationBinding("deleteAddress");
        DialogEvent.Outcome result = e.getOutcome();
        
        if (result == DialogEvent.Outcome.ok || result == DialogEvent.Outcome.yes){
            oper.execute();
        }
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding dcitr = (DCIteratorBinding)bindings.get("CustomerAddressIterator");
        dcitr.refreshIfNeeded();
    }

    /**
     * @param e
     */
    public void discardAddressChanges(ActionEvent e){
        OperationBinding oper = this.findOperationBinding("discardAddressChanges");
        oper.execute();
    }

    /**
     * @param e
     */
    public void refreshAndDiscardChanges(ActionEvent e){
        OperationBinding oper = this.findOperationBinding("refreshAndDiscardChanges");
        oper.execute();
    }
    
    
}
