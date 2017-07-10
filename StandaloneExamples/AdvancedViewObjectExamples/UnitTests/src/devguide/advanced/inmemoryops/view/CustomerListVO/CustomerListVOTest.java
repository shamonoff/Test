package devguide.advanced.inmemoryops.view.CustomerListVO;

import devguide.advanced.inmemoryops.applicationModule.AppModuleAMFixture;

import oracle.jbo.Row;
import oracle.jbo.RowMatch;
import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class CustomerListVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public CustomerListVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("CustomerList");
        assertNotNull(view);
    }
    
    @Test
    public void testCustomerQuery(){
    ViewObject view = fixture1.getApplicationModule().findViewObject("CustomerList");
    String firstAttr = view.first().getAttribute("FirstName").toString();
    assertEquals("First name should be Nancy", "Nancy", firstAttr);
    markOddRowsAsSelected(view);
    view.reset();
    view.next();
    Row row = view.next();
    Boolean evenRowAttr = (Boolean)row.getAttribute("Selected");
    assertEquals("Second row should be marked selected", true, evenRowAttr);
    RowMatch rm = new RowMatch("Selected = true");
    view.setRowMatch(rm);
    view.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
    view.executeQuery();
    String filterSelectedAttr = view.first().getAttribute("FirstName").toString();
    assertEquals("First row should be Daniel", "Daniel", filterSelectedAttr);
    rm = new RowMatch("LastName = 'Popp' or (FirstName like 'A%' and LastName like 'K%')");
    view.setRowMatch(rm);
    view.executeQuery();
    String complexFilterAttr = view.first().getAttribute("FirstName").toString();
    assertEquals("First row should be Luis", "Luis", complexFilterAttr);
        }
    
    private static void markOddRowsAsSelected(ViewObject vo) {
      vo.reset();
      while (vo.hasNext()) {
        Row r = vo.next();
        if (vo.getCurrentRowIndex() % 2 == 1) {
          r.setAttribute("Selected",Boolean.TRUE);
        }
      }
    }
    
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
