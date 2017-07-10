package devguide.advanced.blockops;

import devguide.advanced.blockops.applicationModule.AppModuleAMFixture;
import devguide.advanced.blockops.view.ProductsInsertOnlyVO.ProductsInsertOnlyVOTest;
import devguide.advanced.blockops.view.ProductsNoDeleteVO.ProductsNoDeleteVOTest;
import devguide.advanced.blockops.view.ProductsUpdateOnlyVO.ProductsUpdateOnlyVOTest;
import devguide.advanced.blockops.view.ProductsVO.ProductsVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { ProductsUpdateOnlyVOTest.class,
                       ProductsNoDeleteVOTest.class,
                       ProductsInsertOnlyVOTest.class, ProductsVOTest.class })
public class AllAppModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        AppModuleAMFixture.getInstance().release();
    }
}
