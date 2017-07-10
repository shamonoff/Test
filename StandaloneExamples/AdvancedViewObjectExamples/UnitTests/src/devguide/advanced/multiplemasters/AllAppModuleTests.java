package devguide.advanced.multiplemasters;

import devguide.advanced.multiplemasters.applicationModule.AppModuleAMFixture;
import devguide.advanced.multiplemasters.view.CustomersVO.CustomersVOTest;
import devguide.advanced.multiplemasters.view.OrdersVO.OrdersVOTest;
import devguide.advanced.multiplemasters.view.PaymentOptions1VO.PaymentOptions1VOTest;
import devguide.advanced.multiplemasters.view.PaymentOptionsVO.PaymentOptionsVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { PaymentOptions1VOTest.class, OrdersVOTest.class,
                       PaymentOptionsVOTest.class, CustomersVOTest.class })
public class AllAppModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        AppModuleAMFixture.getInstance().release();
    }
}
