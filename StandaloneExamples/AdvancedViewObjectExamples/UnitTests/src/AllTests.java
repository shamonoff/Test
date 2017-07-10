import devguide.advanced.blockops.view.ProductsInsertOnlyVO.ProductsInsertOnlyVOTest;
import devguide.advanced.blockops.view.ProductsNoDeleteVO.ProductsNoDeleteVOTest;
import devguide.advanced.blockops.view.ProductsUpdateOnlyVO.ProductsUpdateOnlyVOTest;
import devguide.advanced.blockops.view.ProductsVO.ProductsVOTest;
import devguide.advanced.inmemoryops.view.ClosedOrdersVO.ClosedOrdersVOTest;
import devguide.advanced.inmemoryops.view.CreateProductTranslationsVO.CreateProductTranslationsVOTest;
import devguide.advanced.inmemoryops.view.CustomerListVO.CustomerListVOTest;
import devguide.advanced.multiplemasters.view.CustomersVO.CustomersVOTest;
import devguide.advanced.multiplemasters.view.OrdersVO.OrdersVOTest;
import devguide.advanced.multiplemasters.view.PaymentOptions1VO.PaymentOptions1VOTest;
import devguide.advanced.multiplemasters.view.PaymentOptionsVO.PaymentOptionsVOTest;
import devguide.advanced.multiplevc.view.PersonsViewVO.PersonsViewVOTest;
import devguide.advanced.refcursor.view.OrdersForCustomerVO.OrdersForCustomerVOTest;
import devguide.advanced.xml.queries.view.CustomersViewVO.CustomersViewVOTest;
import devguide.advanced.xml.queries.view.OrdersViewVO.OrdersViewVOTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { ProductsVOTest.class, ProductsUpdateOnlyVOTest.class,
                       ProductsNoDeleteVOTest.class,
                       ProductsInsertOnlyVOTest.class, PersonsViewVOTest.class,
                       PaymentOptionsVOTest.class, PaymentOptions1VOTest.class,
                       OrdersViewVOTest.class, OrdersVOTest.class,
                       OrdersForCustomerVOTest.class,
                       CustomersViewVOTest.class, CustomersVOTest.class,
                       CustomerListVOTest.class,
                       CreateProductTranslationsVOTest.class,
                       ClosedOrdersVOTest.class })
public class AllTests {
}
