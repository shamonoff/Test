package devguide.advanced.inheritance.queries.common;

import oracle.jbo.domain.Date;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface SupplierListRow extends PersonListRow {
    void performSupplierFunction();

    Date getContractExpires();

    void setContractExpires(Date value);
}
