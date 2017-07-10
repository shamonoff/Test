package devguide.advanced.inheritance.view.SupplierListVO;

import devguide.advanced.inheritance.applicationModule.PersonModuleAMFixture;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class SupplierListVOTest {
    private PersonModuleAMFixture fixture1 = PersonModuleAMFixture.getInstance();

    public SupplierListVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("SupplierList");
        assertNotNull(view);
    }
    
    @Test
    public void testSupplierAttribute(){
        ViewObject view = fixture1.getApplicationModule().findViewObject("SupplierList");
        view.setRangeSize(-1);
        Row[] supplier = view.getAllRowsInRange();
        for(Row row: supplier){
        oracle.jbo.domain.Date contract = (oracle.jbo.domain.Date)row.getAttribute("ContractExpires");
            assertNotNull("Contract expires should not be null", contract.toString());
          }
    }


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
