package devguide.advanced.customprops.view.ProductsVO;

import devguide.advanced.customprops.applicationModule.ProductModuleAMFixture;

import oracle.jbo.AttributeDef;
import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductsVOTest {
    private ProductModuleAMFixture fixture1 = ProductModuleAMFixture.getInstance();

    public ProductsVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Products");
        assertNotNull(view);
    }
    
    @Test
    public void testGetVOCustomProperty() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Products");
        String propertyValue = view.getProperty("ViewObjectCustomProperty").toString();
        assertEquals("Property value should be 'ViewObjectCustomPropertyValue'", propertyValue, "ViewObjectCustomPropertyValue");
    }
    
    @Test
    public void testGetAttrCustomProperty() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Products");
        AttributeDef nameAttr = view.findAttributeDef("ProductName");
        String propertyValue = nameAttr.getProperty("ProductNameAttrCustomProperty").toString();
        assertEquals("Property value should be 'ProductNameAttrCustomPropertyValue'", propertyValue, "ProductNameAttrCustomPropertyValue");
    }


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
