package devguide.advanced.postingorder.common;

import devguide.advanced.postingorder.Result;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface PostModule extends ApplicationModule {
    Result newProductForNewSupplier(String supplierName, String supplierStatus, 
                                    String productName, String productStatus, 
                                    Number listPrice, Number minPrice, 
                                    String shipCode);
}
