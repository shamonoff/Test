package devguide.examples.readonlyvo;

import devguide.examples.readonlyvo.applicationModule.PersonServiceAMFixture;
import devguide.examples.readonlyvo.view.AllPendingOrBackorderedOrdersVO.AllPendingOrBackorderedOrdersVOTest;
import devguide.examples.readonlyvo.view.OrdersToShipToCustomerVO.OrdersToShipToCustomerVOTest;
import devguide.examples.readonlyvo.view.PersonListVO.PersonListVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { OrdersToShipToCustomerVOTest.class,
                       PersonListVOTest.class,
                       AllPendingOrBackorderedOrdersVOTest.class })
public class AllPersonServiceTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        PersonServiceAMFixture.getInstance().release();
    }
}
