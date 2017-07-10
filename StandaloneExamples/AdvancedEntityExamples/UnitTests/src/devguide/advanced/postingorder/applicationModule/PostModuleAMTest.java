package devguide.advanced.postingorder.applicationModule;

import devguide.advanced.postingorder.Result;
import devguide.advanced.postingorder.common.PostModule;

import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;

import org.junit.*;
import static org.junit.Assert.*;

public class PostModuleAMTest {
    private PostModule _amImpl;

    public PostModuleAMTest() {
        _amImpl = (PostModule)Configuration.createRootApplicationModule("devguide.advanced.postingorder.PostModule","PostModuleLocal");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNewProductForNewSupplier() {
        Number listPrice = new Number(1);
        Number maxPrice = new Number(1);
        Result result = _amImpl.newProductForNewSupplier("Test", "ACTIVE", "NewProduct", "NEW", listPrice, maxPrice, "CLASS1");
        Integer productId = result.getProductId().intValue();
        Integer supplierId = result.getSupplierId().intValue();
        assertTrue("ProductId should be greater than 100", productId > 100);
        assertTrue("SupplierId should be greater than 300", supplierId > 300);
    }
}
