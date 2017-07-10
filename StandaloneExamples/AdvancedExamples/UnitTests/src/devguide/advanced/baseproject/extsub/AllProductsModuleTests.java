package devguide.advanced.baseproject.extsub;

import devguide.advanced.baseproject.extsub.applicationModule.ProductsModuleAMFixture;
import devguide.advanced.baseproject.extsub.view.ProductsByNameVO.ProductsByNameVOTest;
import devguide.advanced.baseproject.extsub.view.ProductsVO.ProductsVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { ProductsByNameVOTest.class, ProductsVOTest.class })
public class AllProductsModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ProductsModuleAMFixture.getInstance().release();
    }
}
