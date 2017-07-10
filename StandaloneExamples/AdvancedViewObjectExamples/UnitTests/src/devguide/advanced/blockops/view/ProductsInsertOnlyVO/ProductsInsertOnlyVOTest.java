package devguide.advanced.blockops.view.ProductsInsertOnlyVO;

import devguide.advanced.blockops.applicationModule.AppModuleAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductsInsertOnlyVOTest {
    private ApplicationModule am;


    public ProductsInsertOnlyVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = am.findViewObject("ProductsInsertOnly");
        assertNotNull(view);
    }
    
    @Test
    public void testUpdatingFails() {
        ViewObject view = am.findViewObject("ProductsInsertOnly");
        try{
            view.first().setAttribute("ProductName", "Test");
            am.getTransaction().commit();
        }catch (JboException ex){
            assertEquals("Exception should be 'No updates allowed in this view'", ex.getDetailMessage(), "No updates allowed in this view");
        }
    }
    
    @Test
    public void testInsert() {
    ViewObject view = am.findViewObject("ProductsInsertOnly");
    Row newRow = view.createRow();
        newRow.setAttribute("ProductId", 5000);
            newRow.setAttribute("SupplierId", 101);
            newRow.setAttribute("ProductName", "Test");
            newRow.setAttribute("ProductStatus", "NEW");
            newRow.setAttribute("ListPrice", new Number(1));
            newRow.setAttribute("MinPrice", new Number(1));
            newRow.setAttribute("ShippingClassCode", "CLASS1");   
        assertNotNull(newRow);
        newRow.remove();
    }


    @Before
    public void setUp() throws Exception {
        am = Configuration.createRootApplicationModule("devguide.advanced.blockops.AppModule","AppModuleLocal");
    }

    @After
    public void tearDown() throws Exception {
        Configuration.releaseRootApplicationModule(am, true);
    }
}
