package devguide.advanced.inheritance;

import devguide.advanced.inheritance.applicationModule.PersonModuleAMFixture;
import devguide.advanced.inheritance.view.PersonListVO.PersonListVOTest;
import devguide.advanced.inheritance.view.StaffListVO.StaffListVOTest;
import devguide.advanced.inheritance.view.SupplierListVO.SupplierListVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { SupplierListVOTest.class, StaffListVOTest.class,
                       PersonListVOTest.class })
public class AllPersonModuleTests {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        PersonModuleAMFixture.getInstance().release();
    }
}
