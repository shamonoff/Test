package devguide.advanced.xml.client;

import java.io.IOException;

import java.net.URL;

import oracle.jbo.ApplicationModule;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.XMLInterface;
import oracle.jbo.client.Configuration;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLNode;

import oracle.xml.parser.v2.XMLParseException;

import oracle.xml.parser.v2.XSLException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.xml.sax.SAXException;

public class TestClientReadXML {
    public static void main(String[] args) throws IOException, XMLParseException, 
                                                  SAXException, XSLException {
      String amDef = "devguide.advanced.xml.queries.AppModule";
      String config = "AppModuleLocal";
      ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
      ViewObject vo = am.findViewObject("CustomersView");
      Key k = new Key(new Object[] { 110 }); // customer jchen
      Row jchen = vo.findByKey(k, 1)[0];
      printXML(jchen.writeXML(-1, XMLInterface.XML_OPT_ALL_ROWS));
      Element xmlToRead = getInsertUpdateDeleteXMLGram();
      printXML(xmlToRead);
      jchen.readXML(getInsertUpdateDeleteXMLGram(), -1);
      printXML(jchen.writeXML(-1,
        XMLInterface.XML_OPT_ALL_ROWS | 
        XMLInterface.XML_OPT_ASSOC_CONSISTENT));
      Configuration.releaseRootApplicationModule(am, true);
    }
    private static void printXML(Node n) throws IOException {
      ((XMLNode)n).print(System.out);
    }
    private static Element getInsertUpdateDeleteXMLGram() throws XMLParseException, 
                                                                 SAXException, 
                                                                 IOException {
      String xmlurl = "InsertUpdateDelete.xml";
      URL xmlURL = TestClientReadXML.class.getResource(xmlurl);
      DOMParser dp = new DOMParser();
      dp.parse(xmlURL);
      return dp.getDocument().getDocumentElement();
    }
    }
