package devguide.advanced.inheritance.view.PersonListVO;

import devguide.advanced.inheritance.PersonsImpl;
import devguide.advanced.inheritance.applicationModule.PersonModuleAMFixture;

import devguide.advanced.inheritance.queries.common.PersonList;
import devguide.advanced.inheritance.queries.common.PersonListRow;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonListVOTest {
    private PersonModuleAMFixture fixture1 = PersonModuleAMFixture.getInstance();

    public PersonListVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("PersonList");
        assertNotNull(view);
    }
    
    @Test
    public void testPersonFunction(){
       PersonList view = (PersonList)fixture1.getApplicationModule().findViewObject("PersonList");
        PersonListRow newPerson = (PersonListRow)view.createRow();
        PersonListRow newStaff  = view.createStaffRow();
        PersonListRow newSupplier = view.createSupplierRow();
        newPerson.performPersonFunction();
        newStaff.performPersonFunction();
        newSupplier.performPersonFunction();
        assertNotNull("New Person should not be null", newPerson);
        assertNotNull("New Staff should not be null", newStaff);
        assertNotNull("New Supplier should not be null", newSupplier);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
