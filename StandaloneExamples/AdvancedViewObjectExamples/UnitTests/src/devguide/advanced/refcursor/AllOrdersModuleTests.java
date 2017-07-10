package devguide.advanced.refcursor;

import devguide.advanced.refcursor.applicationModule.OrdersModuleAMFixture;
import devguide.advanced.refcursor.view.OrdersForCustomerVO.OrdersForCustomerVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { OrdersForCustomerVOTest.class })
public class AllOrdersModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        OrdersModuleAMFixture.getInstance().release();
    }
}
