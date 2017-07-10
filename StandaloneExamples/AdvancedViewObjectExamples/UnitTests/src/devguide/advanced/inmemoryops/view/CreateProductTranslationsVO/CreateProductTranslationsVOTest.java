package devguide.advanced.inmemoryops.view.CreateProductTranslationsVO;

import devguide.advanced.inmemoryops.applicationModule.AppModuleAMFixture;

import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class CreateProductTranslationsVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public CreateProductTranslationsVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("CreateProductTranslations");
        assertNotNull(view);
    }
    
    @Test
    public void testFilterEntityCache(){ 
    ViewObject view = fixture1.getApplicationModule().findViewObject("CreateProductTranslations");
    view.setAssociationConsistent(false);
    Row newProd1 = view.createRow();
    newProd1.setAttribute("ProductId","1111");
    newProd1.setAttribute("Language", "US");
    newProd1.setAttribute("Description","First of the new products");
    view.insertRow(newProd1);
    String firstProduct = view.getCurrentRow().getAttribute("ProductId").toString();
    Row newProd2 = view.createRow();
    newProd2.setAttribute("ProductId","1112");
    newProd2.setAttribute("Language", "US");
    newProd2.setAttribute("Description","Product with interesting features");
    view.insertRow(newProd2);    
    String secondProduct = view.getCurrentRow().getAttribute("ProductId").toString();
    assertTrue("ProductIds should not be equal", firstProduct != secondProduct);
    view.clearCache();
    view.setQueryMode(ViewObject.QUERY_MODE_SCAN_ENTITY_ROWS);
    ViewCriteria vc = view.createViewCriteria();
    ViewCriteriaRow vcr = vc.createViewCriteriaRow();
    vcr.setAttribute("Description","LIKE '%interesting%'");
    vc.add(vcr);
    view.applyViewCriteria(vc);
    vc.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
    view.executeQuery();
    String newQueryId = view.first().getAttribute("ProductId").toString();
    assertEquals("New Id should be equal to 1112", "1112", newQueryId);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
