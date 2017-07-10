package devguide.advanced.customprops;

import devguide.advanced.customprops.common.ProductModule;
import devguide.advanced.customprops.common.Products;

import oracle.jbo.AttributeDef;
import oracle.jbo.client.Configuration;

public class TestClient {
    public static void main(String[] args) {
      String        amDef = "devguide.advanced.customprops.ProductModule";
      String        config = "ProductModuleLocal";
      ProductModule svc =
        (ProductModule)Configuration.createRootApplicationModule(amDef,config);
      Products products = svc.useProducts();
      System.out.println("AppModuleCustomProperty="+
                         svc.getProperty("AppModuleCustomProperty"));
      System.out.println("ViewObjectCustomProperty="+
                         products.getProperty("ViewObjectCustomProperty"));
      AttributeDef nameAttr = products.findAttributeDef("ProductName");
      AttributeDef descAttr = products.findAttributeDef("ProductStatus");
      System.out.println("ProductNameAttrCustomProperty="+
        nameAttr.getProperty("ProductNameAttrCustomProperty"));    
      System.out.println("NameTypeCustomProperty="+
        nameAttr.getProperty("NameTypeCustomProperty"));    
      System.out.println("ProductStatusAttrCustomProperty="+
        descAttr.getProperty("ProductStatusAttrCustomProperty"));
      svc.setAppModuleCustomProperty("RuntimeAppModuleCustomProperty","X");
      products.setViewObjectAttrCustomProperty("ListPrice",
        "RuntimeListPriceAttrCustomProperty","X");
      products.setViewObjectCustomProperty(
        "RuntimeViewObjectCustomProperty","X");      
      Configuration.releaseRootApplicationModule(svc,true);
    }
    
}
