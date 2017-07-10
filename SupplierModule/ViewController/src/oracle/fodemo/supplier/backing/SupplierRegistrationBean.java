package oracle.fodemo.supplier.backing;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import java.sql.Timestamp;

import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;

import javax.el.ExpressionFactory;

import javax.el.MethodExpression;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;

import oracle.adfinternal.view.faces.bi.util.JsfUtils;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.fodemo.supplier.model.AddressUsage;
import oracle.fodemo.supplier.model.Addresses;
import oracle.fodemo.supplier.model.Person;
import oracle.fodemo.supplier.model.Supplier;
import oracle.fodemo.supplier.view.utils.ADFUtils;
import oracle.fodemo.supplier.view.utils.JSFUtils;


public class SupplierRegistrationBean {

    private Person person = null;
    private Supplier supplier = null;
    private Addresses address = null;
    private final String SUPPLIER_PORTAL = "SUPPLIER_PORTAL";

    public SupplierRegistrationBean() {

    }

    public String saveSupplier() {

        person.setAddresses(address);
        // Persist the supplier's first Person associated with it
        HashMap map = new HashMap();
        map.put("supplier", supplier);
        map.put("person", person);
        if (executeOperationBinding("saveSupplierDetails", map)) {
            return "globalHome";
        } else {
            return null;
        }
    }


    public void setPerson(Person person) {

        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setSupplier(Supplier supplier) {

        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setAddress(Addresses address) {

        this.address = address;
    }

    public Addresses getAddress() {
        return address;
    }

    private boolean executeOperationBinding(String methodAction, Map param) {
        OperationBinding ob = ADFUtils.findOperation(methodAction);

        if (param != null) {
            Map paramOps = ob.getParamsMap();
            paramOps.putAll(param);
        }
        Object result = ob.execute();
        if (!ob.getErrors().isEmpty()) {
            JSFUtils.addFacesErrorMessage("An error occured while serving your request.");
            ADFUtils.printOperationBindingExceptions(ob.getErrors());
            return false;
        }
        return true;
    }

    public void validateConfirmedEmail(FacesContext facesContext,
                                       UIComponent uIComponent,
                                       Object object) {
        // Add event code here...
        // person = ADFUtils..ADFUbindings.personIterator.currentRow.dataProvider

        String email = (String)ADFUtils.getBoundAttributeValue("email");

        if (object == null || object.toString().trim().length() == 0) {
            return;
        }
        if (email == null || email.trim().length() == 0) {
            return;
        }

        if (!object.toString().equals(email)) {
            String errMsg =
                JsfUtils.getResourceString("person.cnfmemail.validationerr",
                                           "oracle.fodemo.supplier.view.ViewControllerBundle");

            JSFUtils.addFacesErrorMessage(uIComponent.getClientId(facesContext),
                                          "Confirmed Email", errMsg);

        }
    }

    public String validateBindingContainer() {
        DCBindingContainer dcBindingContainer =
            ADFUtils.getDCBindingContainer();
        dcBindingContainer.validate();
        return null;
    }

    /**
     * Finalizer for task flow
     */
    public void finalizer() {

        FacesContext adfFacesContext = FacesContext.getCurrentInstance();
        String flag =
            (String)adfFacesContext.getExternalContext().getSessionMap().get("supplierRegRefreshFlag");

        if (flag == null) {
            flag = "false";
        }
        Boolean bflag = Boolean.valueOf(flag);
        bflag = !bflag;
        System.out.println("finalizer:" + flag);
        adfFacesContext.getExternalContext().getSessionMap().put("supplierRegRefreshFlag",
                                                                 bflag.toString());
    }
}
