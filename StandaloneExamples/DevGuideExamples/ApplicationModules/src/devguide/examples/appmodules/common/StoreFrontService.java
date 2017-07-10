package devguide.examples.appmodules.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface StoreFrontService extends ApplicationModule {
    String findOrderTotal(long orderId);

    String findOrderCustomer(long orderId);

    void updateOrderStatus(long orderId, String newStatus);

    long createProduct(String name, String status, String shipCode);
}
