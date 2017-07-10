package devguide.advanced.multiplevc.view.PersonsViewVO;

import devguide.advanced.multiplevc.applicationModule.AppModuleAMFixture;

import devguide.advanced.multiplevc.common.PersonsView;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonsViewVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public PersonsViewVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("PersonsView");
        assertNotNull(view);
    }
    
    @Test
    public void testMultipleCriteria() {
        PersonsView view =
            (PersonsView)fixture1.getApplicationModule().findViewObject("PersonsView");
        view.showMaleCustomers();
        view.setRangeSize(-1);
        Row[] allRows = view.getAllRowsInRange();
        for (Row row : allRows) {
            String genderAttr = row.getAttribute("Gender").toString();
            assertEquals("Gender should be male", "M", genderAttr);
        }
        view.applyViewCriteria(null);
        view.showFemaleStaff();
        view.setRangeSize(-1);
        Row[] femaleStaff = view.getAllRowsInRange();
        for (Row row : femaleStaff) {
            String genderAttr = row.getAttribute("Gender").toString();
            String personType =
                view.first().getAttribute("PersonTypeCode").toString();
            assertEquals("Gender should be female", "F", genderAttr);
            assertTrue("Type should not be CUST", personType != "CUST");
        }
        view.showFemaleCustomers();
        view.setRangeSize(-1);
        Row[] femaleCustomers = view.getAllRowsInRange();
        for (Row row : femaleCustomers) {
            String genderAttr = row.getAttribute("Gender").toString();
            String personType =
                view.first().getAttribute("PersonTypeCode").toString();
            assertEquals("Gender should be female", "F", genderAttr);
            assertEquals("Type should be CUST", "CUST", personType);
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
