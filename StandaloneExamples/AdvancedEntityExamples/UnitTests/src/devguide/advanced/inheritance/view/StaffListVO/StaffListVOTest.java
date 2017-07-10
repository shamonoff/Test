package devguide.advanced.inheritance.view.StaffListVO;

import devguide.advanced.inheritance.applicationModule.PersonModuleAMFixture;

import devguide.advanced.inheritance.queries.common.PersonListRow;
import devguide.advanced.inheritance.queries.common.StaffListRow;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class StaffListVOTest {
    private PersonModuleAMFixture fixture1 = PersonModuleAMFixture.getInstance();

    public StaffListVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("StaffList");
        assertNotNull(view);
    }
    
    @Test
    public void testStaffAttribute(){
        ViewObject view = fixture1.getApplicationModule().findViewObject("StaffList");
        view.setRangeSize(-1);
        Row[] staff = view.getAllRowsInRange();
        for(Row row: staff){
        String discount = (String)row.getAttribute("DiscountEligible");
            assertNotNull("Discount should not be null", discount);
          }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
