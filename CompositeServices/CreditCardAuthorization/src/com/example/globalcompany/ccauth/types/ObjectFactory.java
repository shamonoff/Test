
package com.example.globalcompany.ccauth.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.globalcompany.ccauth.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Status_QNAME = new QName("http://www.globalcompany.example.com/ns/CCAuthorizationService", "status");
    private final static QName _Error_QNAME = new QName("http://www.globalcompany.example.com/ns/CCAuthorizationService", "error");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.globalcompany.ccauth.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthInformation }
     * 
     */
    public AuthInformation createAuthInformation() {
        return new AuthInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.globalcompany.example.com/ns/CCAuthorizationService", name = "status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.globalcompany.example.com/ns/CCAuthorizationService", name = "error")
    public JAXBElement<String> createError(String value) {
        return new JAXBElement<String>(_Error_QNAME, String.class, null, value);
    }

}
