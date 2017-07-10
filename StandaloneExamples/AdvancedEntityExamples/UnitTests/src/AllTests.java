import devguide.advanced.inheritance.view.PersonListVO.PersonListVOTest;
import devguide.advanced.inheritance.view.StaffListVO.StaffListVOTest;
import devguide.advanced.inheritance.view.SupplierListVO.SupplierListVOTest;
import devguide.advanced.plsqlwrap.view.ProductsVO.ProductsVOTest;
import devguide.advanced.postingorder.applicationModule.PostModuleAMTest;
import devguide.advanced.simpledomains.view.PersonsVO.PersonsVOTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { SupplierListVOTest.class, StaffListVOTest.class,
                       ProductsVOTest.class, PostModuleAMTest.class,
                       PersonsVOTest.class, PersonListVOTest.class })
public class AllTests {
}
