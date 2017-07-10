package devguide.advanced.inmemoryops;

import devguide.advanced.inmemoryops.applicationModule.AppModuleAMFixture;
import devguide.advanced.inmemoryops.view.ClosedOrdersVO.ClosedOrdersVOTest;
import devguide.advanced.inmemoryops.view.CreateProductTranslationsVO.CreateProductTranslationsVOTest;
import devguide.advanced.inmemoryops.view.CustomerListVO.CustomerListVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { CreateProductTranslationsVOTest.class,
                       ClosedOrdersVOTest.class, CustomerListVOTest.class })
public class AllAppModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        AppModuleAMFixture.getInstance().release();
    }
}
