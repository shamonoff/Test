package devguide.advanced.xml.client;


import java.io.IOException;

import java.net.URL;

import java.util.HashMap;

import oracle.jbo.client.Configuration;
import oracle.jbo.*;
import oracle.xml.parser.v2.XMLNode;
import oracle.xml.parser.v2.XMLParseException;
import oracle.xml.parser.v2.XSLException;
import oracle.xml.parser.v2.XSLProcessor;
import oracle.xml.parser.v2.XSLStylesheet;

import org.w3c.dom.Node;

import org.xml.sax.SAXException;

public class TestClientWriteXML {
    public static void main(String[] args) throws IOException, XMLParseException, 
                                                  SAXException, XSLException {
      String        amDef = "devguide.advanced.xml.queries.AppModule";
      String        config = "AppModuleLocal";
      ApplicationModule am =
      Configuration.createRootApplicationModule(amDef,config);
      // Show the XML with all attributes and all view link levels
      ViewObject vo = am.findViewObject("CustomersView");
      printXML(vo.writeXML(-1,XMLInterface.XML_OPT_ALL_ROWS));
      // Show the XML with all attributes and all view link levels    
      HashMap viewDefMap = new HashMap();
      viewDefMap.put("devguide.advanced.xml.queries.PersonsView",
                     new String[]{"PersonId","Email","PersonTypeCode","OrdersView"});
      viewDefMap.put("devguide.advanced.xml.queries.OrdersView",
                     new String[]{"OrderId","OrderStatusCode","OrderTotal"});  
      printXML(vo.writeXML(XMLInterface.XML_OPT_ALL_ROWS,viewDefMap));    
      // Show the XML after transforming it by an XSLT Stylesheet
      XSLStylesheet xsl = getXSLStylesheet();
      printXML(vo.writeXML(XMLInterface.XML_OPT_ALL_ROWS,viewDefMap,xsl));

      Configuration.releaseRootApplicationModule(am,true);
    }
    private static XSLStylesheet getXSLStylesheet() throws XMLParseException, SAXException, 
                                                           IOException, XSLException {
      String xslurl = "Example.xsl";
      URL xslURL = TestClientWriteXML.class.getResource(xslurl);
      XSLProcessor xslProc = new XSLProcessor();
      return xslProc.newXSLStylesheet(xslURL);
    }
    private static void printXML(Node n) throws IOException {
      ((XMLNode)n).print(System.out);
    }
}
