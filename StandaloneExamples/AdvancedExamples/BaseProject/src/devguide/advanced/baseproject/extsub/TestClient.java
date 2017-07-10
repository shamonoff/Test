package devguide.advanced.baseproject.extsub;

import devguide.advanced.baseproject.extsub.common.Products;

import devguide.advanced.baseproject.extsub.common.ProductsByName;
import devguide.advanced.baseproject.extsub.common.ProductsByNameRow;
import devguide.advanced.baseproject.extsub.common.ProductsRow;

import oracle.jbo.ApplicationModule;
import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.StructureDef;
import oracle.jbo.ValidationException;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClient {  
    public static void main(String[] args) {
    String        amDef = "devguide.advanced.baseproject.extsub.ProductsModule";
    String        config = "ProductsModuleLocal";
    ApplicationModule am =
    Configuration.createRootApplicationModule(amDef,config);
    Products products = (Products)am.findViewObject("Products");
    products.executeQuery();
    ProductsRow product = (ProductsRow)products.first();
    printAllAttributes(products,product);
    testSomethingOnProductsRow(product);
    products = (Products)am.findViewObject("ProductsByName");
    ProductsByName productsByName = (ProductsByName)products;
    productsByName.settheProductName("Ipod");
    productsByName.executeQuery();
    product = (ProductsRow)productsByName.first();
    printAllAttributes(productsByName,product);
    testSomethingOnProductsRow(product);
    am.getTransaction().rollback();
    Configuration.releaseRootApplicationModule(am,true);
  }
  private static void testSomethingOnProductsRow(ProductsRow product) {
    try {
      if (product instanceof ProductsByNameRow) {
        ProductsByNameRow productByName = (ProductsByNameRow)product;
        productByName.someExtraFeature("Test");        
      }
      product.setProductName("Q");
      System.out.println("Setting the Name attribute to 'Q' succeeded.");
    }
    catch (ValidationException v) {
      System.out.println(v.getLocalizedMessage());      
    }    
  }
  private static void printAllAttributes(ViewObject vo, Row r) {
    String viewObjName = vo.getName();
    System.out.println("Printing attribute for a row in VO '"+
                       viewObjName+"'");
    StructureDef def = r.getStructureDef();
    StringBuilder sb = new StringBuilder();
    int numAttrs = def.getAttributeCount();
    AttributeDef[] attrDefs = def.getAttributeDefs();
    for (int z = 0; z < numAttrs; z++) {
      Object value = r.getAttribute(z);
      sb.append(z > 0 ? "  " : "")
        .append(attrDefs[z].getName())
        .append("=")
        .append(value == null ? "<null>" : value)
        .append(z < numAttrs - 1 ? "\n" : "");
    }
    System.out.println(sb.toString());
  }
}
