package unittests;

import devguide.advanced.baseproject.extsub.view.ProductsByNameVO.ProductsByNameVOTest;
import devguide.advanced.customerrors.view.Products1VO.Products1VOTest;
import devguide.advanced.customprops.applicationModule.ProductModuleAMTest;
import devguide.advanced.customprops.view.ProductsVO.ProductsVOTest;
import devguide.advanced.storedproc.applicationModule.StoredProcTestModuleAMTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { StoredProcTestModuleAMTest.class, ProductsVOTest.class,
                       devguide.advanced.baseproject.extsub.view.ProductsVO.ProductsVOTest.class,
                       ProductsByNameVOTest.class, Products1VOTest.class,
                       ProductModuleAMTest.class })
public class AllTests {
}
