package devguide.advanced.xml.queries;

import devguide.advanced.xml.queries.applicationModule.AppModuleAMFixture;
import devguide.advanced.xml.queries.view.CustomersViewVO.CustomersViewVOTest;
import devguide.advanced.xml.queries.view.OrdersViewVO.OrdersViewVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { OrdersViewVOTest.class, CustomersViewVOTest.class })
public class AllAppModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        AppModuleAMFixture.getInstance().release();
    }
    
    
}
