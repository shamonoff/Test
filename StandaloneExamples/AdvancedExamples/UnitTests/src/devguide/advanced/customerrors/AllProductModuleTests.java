package devguide.advanced.customerrors;

import devguide.advanced.customerrors.applicationModule.ProductModuleAMFixture;
import devguide.advanced.customerrors.view.Products1VO.Products1VOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { Products1VOTest.class })
public class AllProductModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ProductModuleAMFixture.getInstance().release();
    }
}
