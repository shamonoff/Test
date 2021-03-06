<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="XSD">
      <schema location="oramds:/apps/FusionOrderDemoShared/services/oracle/fodemo/storefront/entities/events/OrderEO.xsd"/>
      <rootElement name="NewOrderSubmittedInfo" namespace="/oracle/fodemo/storefront/entities/events/schema/OrderEO"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="oramds:/apps/FusionOrderDemoShared/services/orderbooking/OrderBookingProcessor.wsdl"/>
      <rootElement name="process" namespace="http://www.globalcompany.example.com/ns/OrderBookingService"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.0.0(build 090109.0200.2393) AT [MON JAN 12 18:49:42 PST 2009]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:ns2="http://www.globalcompany.example.com/ns/OrderBookingService/rules"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:xpath20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:ns0="/oracle/fodemo/storefront/entities/events/schema/OrderEO"
                xmlns:ns3="http://www.globalcompany.example.com/ns/InternalWarehouse"
                xmlns:plnk="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:ns5="commonj.sdo/xml"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:ns6="commonj.sdo/java"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.GetRequestHeaderExtnFunction"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:ns1="/oracle/fodemo/storefront/store/queries/common/"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:ns4="commonj.sdo"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:client="http://www.globalcompany.example.com/ns/OrderBookingService"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl ns0 xsd ns2 ns3 plnk wsdl ns5 ns6 ns1 ns4 client bpws xpath20 ora socket oraext dvm hwf mhdr med ids xdk xref ldap">
  <xsl:template match="/">
    <client:process>
      <client:orderId>
        <xsl:value-of select="/ns0:NewOrderSubmittedInfo/ns0:OrderId/ns0:newValue/@value"/>
      </client:orderId>
    </client:process>
  </xsl:template>
</xsl:stylesheet>
