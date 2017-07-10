<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="XSD">
      <schema location="../../SensorActionSensorAction_1.xsd"/>
      <rootElement name="actionData" namespace="http://xmlns.oracle.com/bpel/sensor"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../Demos/Fusion%20Order%20Demo/ProcessTime.wsdl"/>
      <rootElement name="_ProcessTimesCollection" namespace="http://xmlns.oracle.com/bam"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.0.0(build 081112.0200.2165) AT [THU NOV 13 12:56:05 PST 2008]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:xpath20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:ns0="http://xmlns.oracle.com/bam"
                xmlns:tns="http://xmlns.oracle.com/bpel/sensor"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.GetRequestHeaderExtnFunction"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:nxsd="http://xmlns.oracle.com/pcbpel/nxsd"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:sensor="http://www.globalcompany.example.com/ns/InternalWarehouse"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl tns nxsd sensor xsd ns0 xsi xpath20 bpws oraext dvm hwf med mhdr ids xdk xref ora socket ldap">
  <xsl:template match="/">
    <ns0:_ProcessTimesCollection>
      <ns0:_ProcessTimes>
        <ns0:_ECID>
          <xsl:value-of select="/tns:actionData/tns:header/tns:compositeInstanceId"/>
        </ns0:_ECID>
        <ns0:_ReceiveInternalWarehouseRespo>
          <xsl:value-of select="/tns:actionData/tns:header/tns:timestamp"/>
        </ns0:_ReceiveInternalWarehouseRespo>
        <ns0:_InternalWarehouseQuote>
          <xsl:value-of select="/tns:actionData/tns:payload/tns:variableData/tns:data/sensor:WarehouseResponse/sensor:orderTotal"/>
        </ns0:_InternalWarehouseQuote>
      </ns0:_ProcessTimes>
    </ns0:_ProcessTimesCollection>
  </xsl:template>
</xsl:stylesheet>
