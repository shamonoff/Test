package devguide.advanced.inheritance.queries.client;

import devguide.advanced.inheritance.queries.common.SupplierListRow;

import oracle.jbo.domain.Date;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SupplierListRowClient extends PersonListRowClient implements SupplierListRow {
    /**This is the default constructor (do not remove).
     */
    public SupplierListRowClient() {
    }


    public void performSupplierFunction() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"performSupplierFunction",null,null);
        return;
    }

    public Date getContractExpires() {
        return (Date)getAttribute("ContractExpires");
    }

    public void setContractExpires(Date value) {
        setAttribute("ContractExpires", value);
    }
}
