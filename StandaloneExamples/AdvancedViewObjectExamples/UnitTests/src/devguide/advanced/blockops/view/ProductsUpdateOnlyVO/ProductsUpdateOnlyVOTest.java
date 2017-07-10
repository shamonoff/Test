package devguide.advanced.blockops.view.ProductsUpdateOnlyVO;

import devguide.advanced.blockops.applicationModule.AppModuleAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductsUpdateOnlyVOTest {
    private ApplicationModule am;


    public ProductsUpdateOnlyVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = am.findViewObject("ProductsUpdateOnly");
        assertNotNull(view);
    }
    
    @Test
    public void testUpdate(){  
    ViewObject view = am.findViewObject("ProductsUpdateOnly");
        view.first().setAttribute("ProductName", "TestUpdate");
        assertEquals("view", view.first().getAttribute("ProductName"), "TestUpdate");
    }
    
    @Test
    public void testInsertFails() {
        ViewObject view = am.findViewObject("ProductsUpdateOnly");
        try{
            Row newRow = view.createRow();
        }catch (JboException ex){
            assertEquals("Exception should be 'Insert not allowed in this view'", ex.getDetailMessage(), "Insert not allowed in this view");
        }       
    }

    @Before
    public void setUp() {
        am = Configuration.createRootApplicationModule("devguide.advanced.blockops.AppModule","AppModuleLocal");
    }

    @After
    public void tearDown() {
            Configuration.releaseRootApplicationModule(am, true);
    }
}
