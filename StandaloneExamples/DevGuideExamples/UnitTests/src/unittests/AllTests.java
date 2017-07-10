package unittests;

import devguide.examples.appmodules.applicationModule.StoreFrontServiceAMTest;
import devguide.examples.readonlyvo.view.AllPendingOrBackorderedOrdersVO.AllPendingOrBackorderedOrdersVOTest;
import devguide.examples.readonlyvo.view.OrdersToShipToCustomerVO.OrdersToShipToCustomerVOTest;
import devguide.examples.readonlyvo.view.PersonListVO.PersonListVOTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { StoreFrontServiceAMTest.class, PersonListVOTest.class,
                       OrdersToShipToCustomerVOTest.class,
                       AllPendingOrBackorderedOrdersVOTest.class })
public class AllTests {
}
