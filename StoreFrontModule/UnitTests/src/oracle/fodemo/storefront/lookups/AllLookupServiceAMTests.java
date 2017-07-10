package oracle.fodemo.storefront.lookups;

import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMFixture;
import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMTest;
import oracle.fodemo.storefront.lookups.view.AddressOwnerTypesVO.AddressOwnerTypesVOTest;
import oracle.fodemo.storefront.lookups.view.AddressUsageTypesVO.AddressUsageTypesVOTest;
import oracle.fodemo.storefront.lookups.view.AllAddressesVO.AllAddressesVOTest;
import oracle.fodemo.storefront.lookups.view.BillingAddressesVO.BillingAddressesVOTest;
import oracle.fodemo.storefront.lookups.view.ContactMethodTypesVO.ContactMethodTypesVOTest;
import oracle.fodemo.storefront.lookups.view.CountriesVO.CountriesVOTest;
import oracle.fodemo.storefront.lookups.view.CreditCardTypesVO.CreditCardTypesVOTest;
import oracle.fodemo.storefront.lookups.view.DiscountTypesVO.DiscountTypesVOTest;
import oracle.fodemo.storefront.lookups.view.GenderTypesVO.GenderTypesVOTest;
import oracle.fodemo.storefront.lookups.view.HelpTranslationsVO.HelpTranslationsVOTest;
import oracle.fodemo.storefront.lookups.view.IdentificationTypesVO.IdentificationTypesVOTest;
import oracle.fodemo.storefront.lookups.view.MaritalStatusTypesVO.MaritalStatusTypesVOTest;
import oracle.fodemo.storefront.lookups.view.MembershipTypesVO.MembershipTypesVOTest;
import oracle.fodemo.storefront.lookups.view.OrderStatusTypesVO.OrderStatusTypesVOTest;
import oracle.fodemo.storefront.lookups.view.PaymentTypesVO.PaymentTypesVOTest;
import oracle.fodemo.storefront.lookups.view.PersonTitleTypesVO.PersonTitleTypesVOTest;
import oracle.fodemo.storefront.lookups.view.PersonTypesVO.PersonTypesVOTest;
import oracle.fodemo.storefront.lookups.view.ShippingAddressesVO.ShippingAddressesVOTest;
import oracle.fodemo.storefront.lookups.view.ShippingClassTypesVO.ShippingClassTypesVOTest;
import oracle.fodemo.storefront.lookups.view.VerificationTypesVO.VerificationTypesVOTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { HelpTranslationsVOTest.class, CountriesVOTest.class,
                       ShippingAddressesVOTest.class,
                       BillingAddressesVOTest.class, AllAddressesVOTest.class,
                       VerificationTypesVOTest.class,
                       ShippingClassTypesVOTest.class, PersonTypesVOTest.class,
                       PersonTitleTypesVOTest.class, PaymentTypesVOTest.class,
                       OrderStatusTypesVOTest.class,
                       MembershipTypesVOTest.class,
                       MaritalStatusTypesVOTest.class,
                       IdentificationTypesVOTest.class,
                       GenderTypesVOTest.class, DiscountTypesVOTest.class,
                       CreditCardTypesVOTest.class,
                       ContactMethodTypesVOTest.class,
                       AddressUsageTypesVOTest.class,
                       AddressOwnerTypesVOTest.class,
                       LookupServiceAMTest.class })
public class AllLookupServiceAMTests {
    @BeforeClass
    public static void setUp() {
        
    }

    @AfterClass
    public static void tearDown() throws Exception {
        LookupServiceAMFixture.getInstance().release();
    }
}
