package devguide.advanced.plsqlwrap;

import devguide.advanced.plsqlwrap.applicationModule.ProductsModuleAMFixture;
import devguide.advanced.plsqlwrap.view.ProductsVO.ProductsVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { ProductsVOTest.class })
public class AllProductsModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ProductsModuleAMFixture.getInstance().release();
    }
}
