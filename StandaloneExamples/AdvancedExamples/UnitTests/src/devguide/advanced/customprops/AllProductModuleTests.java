package devguide.advanced.customprops;

import devguide.advanced.customprops.applicationModule.ProductModuleAMFixture;
import devguide.advanced.customprops.applicationModule.ProductModuleAMTest;
import devguide.advanced.customprops.view.ProductsVO.ProductsVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { ProductsVOTest.class, ProductModuleAMTest.class })
public class AllProductModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ProductModuleAMFixture.getInstance().release();
    }
}
