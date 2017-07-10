package oracle.fodemo.storefront.account.view.managed;
    /** This is the backing bean for the updateUserInfo page
     * 
     */
 
import java.util.Iterator;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.fodemo.storefront.adf.util.ADFUtils;

import oracle.fodemo.storefront.jsf.util.JSFUtils;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class UpdateUserInfoBean {
    String beanName = "UpdateUserInfoBean";
    String allItemsIteratorName;
    String allItemsValueAttrName;
    String allItemsDisplayAttrName;
    String allItemsDescriptionAttrName;
    String selectedValuesIteratorName;
    String selectedValuesValueAttrName;
    List selectedValues;
    List allItems;
    private RichTable addressTable;
    private boolean refreshSelectedList = false;
    private RichTable paymentOptionsTable;

    public UpdateUserInfoBean() {
    }


    /**
     * Setter for 'allItemsIteratorName' property.
     * @param allItemsIteratorName Name of the iterator for all items in the list
     */
    public void setAllItemsIteratorName(String allItemsIteratorName) {
        this.allItemsIteratorName = allItemsIteratorName;
    }

    /**
     * Getter for 'allItemsIteratorName' property.
     * @return Name of the iterator to use for all items in the list
     */
    public String getAllItemsIteratorName() {
        return allItemsIteratorName;
    }

    /**
     * Set allItems value attribute name.
     * @param allItemsValueAttrName name of attr to use as value of all items list
     */
    public void setAllItemsValueAttrName(String allItemsValueAttrName) {
        this.allItemsValueAttrName = allItemsValueAttrName;
    }

    /**
     * Get allItems value attribute name.
     * @return name of attr to use as value of all items list
     */
    public String getAllItemsValueAttrName() {
        return allItemsValueAttrName;
    }

    /**
     * Setter for 'allItemsDisplayAttrName' property.
     * @param allItemsDisplayAttrName attr to use for display in all items list
     */
    public void setAllItemsDisplayAttrName(String allItemsDisplayAttrName) {
        this.allItemsDisplayAttrName = allItemsDisplayAttrName;
    }

    /**
     * Getter for 'allItemsDisplayAttrName' property.
     * @return attr to use for display in all items list
     */
    public String getAllItemsDisplayAttrName() {
        return allItemsDisplayAttrName;
    }

    /**
     * Setter for 'allItemsDescriptionAttrName' property.
     * @param allItemsDescriptionAttrName attrib for description in all items list
     */
    public void setAllItemsDescriptionAttrName(String allItemsDescriptionAttrName) {
        this.allItemsDescriptionAttrName = allItemsDescriptionAttrName;
    }

    /**
     * Getter for 'allItemsDescriptionAttrName' property.
     * @return attrib for description in all items list
     */
    public String getAllItemsDescriptionAttrName() {
        return allItemsDescriptionAttrName;
    }

    /**
     * Setter for 'selectedValuesIteratorName' property.
     * @param selectedValuesIteratorName name of iterator for selected values
     */
    public void setSelectedValuesIteratorName(String selectedValuesIteratorName) {
        this.selectedValuesIteratorName = selectedValuesIteratorName;
    }

    /**
     * Getter for 'selectedValuesIteratorName' property.
     * @return name of iterator for selected values
     */
    public String getSelectedValuesIteratorName() {
        return selectedValuesIteratorName;
    }

    /**
     * Setter for 'selectedValuesValueAttrName' property.
     * @param selectedValuesValueAttrName name of attr to use for selected value
     */
    public void setSelectedValuesValueAttrName(String selectedValuesValueAttrName) {
        this.selectedValuesValueAttrName = selectedValuesValueAttrName;
    }

    /**
     * Getter for 'selectedValuesValueAttrName' property.
     * @return name of attr to use for selected value
     */
    public String getSelectedValuesValueAttrName() {
        return selectedValuesValueAttrName;
    }

    /**
     * Setter for 'selectedValues' property.
     * @param selectedValues List of selected values in shuttle
     */
    public void setSelectedValues(List selectedValues) {
        this.selectedValues = selectedValues;
    }

    /**
     * Event handler for shuttle value change event.
     * @param event value change event
     */
    public void refreshSelectedList(ValueChangeEvent event) {
        refreshSelectedList = true;
    }

    /**
     * Getter for 'selectedValues' property.
     * @return List of selected values in shuttle
     */
    public List getSelectedValues() {
        if (selectedValues == null || refreshSelectedList) {
            selectedValues = 
                    ADFUtils.attributeListForIterator(selectedValuesIteratorName, 
                                                      selectedValuesValueAttrName);
        }
        return selectedValues;
    }

    /**
     * Setter for 'allItems' property.
     * @param allItems list of SelectItem representing all items in available list
     */
    public void setAllItems(List allItems) {
        this.allItems = allItems;
    }

    /**
     * Getter for 'allItems' property.
     * @return list of SelectItem representing all items in available list
     */
    public List getAllItems() {
        if (allItems == null) {
            allItems = 
                    ADFUtils.selectItemsForIterator(allItemsIteratorName, allItemsValueAttrName, 
                                                    allItemsDisplayAttrName, 
                                                    allItemsDescriptionAttrName);
        }
        return allItems;
    }

    /**
     * @param paymentOptionsTable
     */
    public void setPaymentOptionsTable(RichTable paymentOptionsTable) {
        this.paymentOptionsTable = paymentOptionsTable;
    }

    /**
     * @return
     */
    public RichTable getPaymentOptionsTable() {
        return paymentOptionsTable;
    }

    /**
     * @return
     */
    public RichTable getAddressTable() {
        return addressTable;
    }

    /**
     * @param table
     */
    public void setAddressTable(RichTable table) {
        this.addressTable = table;
    }



    /**
     * Action handler for the (Update Interests) button.
     * 
     * Note that this event handler does not execute the ADF OperationBinding
     * since that gets executed by JSF by virtue of the EL expression in the
     * ActionListener property of the button:
     * 
     * @return JSF navigation rule name - null to stay on same page
     */
    public String onUpdateInterests() {
        FacesMessage msg = 
            JSFUtils.getMessageFromBundle("userInterests.changedApplied", 
                                          FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }


    /**
     * @param evt
     */
    public void createAddress_action(ActionEvent evt) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding dcitr = 
            (DCIteratorBinding)bindings.get("AddressesAndUsagesIterator");
        RowSetIterator rowSetItr = dcitr.getRowSetIterator();
        Row currentRow = rowSetItr.createRow();
        rowSetItr.insertRow(currentRow);
        String rowKey = currentRow.getKey().toStringFormat(true);
        dcitr.setCurrentRowWithKey(currentRow.getKey().toStringFormat(true));
        dcitr.refreshIfNeeded();
     }

    /**
     * @param e
     */
    public void confirmDeleteAddressDialogListener(DialogEvent e) {
        DialogEvent.Outcome result = e.getOutcome();

        if (result == DialogEvent.Outcome.ok || 
            result == DialogEvent.Outcome.yes) {
            deleteOnTable(getAddressTable());
        }
    }


    /**
     * @param e
     */
    public void addAddressDialogListener(DialogEvent e) {
        DialogEvent.Outcome result = e.getOutcome();

        if (result == DialogEvent.Outcome.no) {
              deleteOnTable(getAddressTable());               
         
        }
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding dcitr = 
            (DCIteratorBinding)bindings.get("AddressesAndUsagesIterator");
        dcitr.refreshIfNeeded();
    }


    /**
     * @param e
     */
    public void editAddressDialogListener(DialogEvent e) {
        DialogEvent.Outcome result = e.getOutcome();
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding dcitr = (DCIteratorBinding)bindings.get("AddressesAndUsagesIterator");
        if (result == DialogEvent.Outcome.ok || 
            result == DialogEvent.Outcome.yes) {
            dcitr.refreshIfNeeded();
        }
        else {            
            RowSetIterator rowSetItr = dcitr.getRowSetIterator();
            rowSetItr.getCurrentRow().refresh(Row.REFRESH_UNDO_CHANGES);       
        }                
    }


    /**
     * Method to perform single or multiple record delete on a table
     * that contains a binding.
     * @param myTable , the RichTable from which we remove the records
     */
    
    public void deleteOnTable(RichTable myTable) {
        RowKeySet rowKeySet = (RowKeySet) myTable.getSelectedRowKeys();
        CollectionModel cm = (CollectionModel) myTable.getValue();
        for (Object facesTreeRowKey : rowKeySet) {
            cm.setRowKey(facesTreeRowKey);
            JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)
                cm.getRowData();
            rowData.getRow().remove();
        }
    }


    /**
     * @param evt
     */
    public void setCurrentAddress_action(ActionEvent evt) {
        RowKeySet rowSet = this.getAddressTable().getSelectedRowKeys();
        Iterator rowSetIter = rowSet.iterator();
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("AddressesAndUsagesIterator");
        if (rowSetIter.hasNext()) {
            List l = (List)rowSetIter.next();
            Key key = (Key)l.get(0);         
            iter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = iter.getCurrentRow();
        }
    }

    /**
     * @param actionEvent
     */
    public void saveUserInformation(ActionEvent actionEvent) {            
            BindingContainer bindings = ADFUtils.getBindingContainer();
            OperationBinding operation = bindings.getOperationBinding("Commit");
            operation.execute();
         
    }

    /**
     * @param actionEvent
     */
    public void addPaymentOption_action(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding dcitr = 
            (DCIteratorBinding)bindings.get("PaymentOptionsForUserIterator");
        RowSetIterator rowSetItr = dcitr.getRowSetIterator();
        Row currentRow = rowSetItr.createRow();
        rowSetItr.insertRow(currentRow);
        String rowKey = currentRow.getKey().toStringFormat(true);
        dcitr.setCurrentRowWithKey(currentRow.getKey().toStringFormat(true));
        dcitr.refreshIfNeeded();
    }

    /**
     * @param dialogEvent
     */
    public void addPaymentOptionsDialogListener(DialogEvent dialogEvent) {
        DialogEvent.Outcome result = dialogEvent.getOutcome();

        if (result == DialogEvent.Outcome.no) {
            deleteOnTable(this.getPaymentOptionsTable());               
           
        }
    }

    /**
     * @param actionEvent
     */
    public void setCurrentPaymentOptions_action(ActionEvent actionEvent) {
        RowKeySet rowSet = getPaymentOptionsTable().getSelectedRowKeys();
        Iterator rowSetIter = rowSet.iterator();
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("PaymentOptionsForUserIterator");
        if (rowSetIter.hasNext()) {
            List l = (List)rowSetIter.next();
            Key key = (Key)l.get(0);         
            iter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = iter.getCurrentRow();
        }
    }

    /**
     * @param dialogEvent
     */
    public void editPaymentOptionsDialogListener(DialogEvent dialogEvent) {
        DialogEvent.Outcome result = dialogEvent.getOutcome();
        BindingContainer bindings = ADFUtils.getBindingContainer();
        DCIteratorBinding dcitr = (DCIteratorBinding)bindings.get("PaymentOptionsForUserIterator");
        if (result == DialogEvent.Outcome.ok || 
            result == DialogEvent.Outcome.yes) {
            dcitr.refreshIfNeeded();
        }
        else {            
            RowSetIterator rowSetItr = dcitr.getRowSetIterator();
            rowSetItr.getCurrentRow().refresh(Row.REFRESH_UNDO_CHANGES);       
        }
    }

    /**
     * @param e
     */
    public void confirmDeletePaymentOptionsDialogListener(DialogEvent e) {
        DialogEvent.Outcome result = e.getOutcome();
        if (result == DialogEvent.Outcome.ok || 
            result == DialogEvent.Outcome.yes) {
            deleteOnTable(getPaymentOptionsTable());  
        }
    }
}
