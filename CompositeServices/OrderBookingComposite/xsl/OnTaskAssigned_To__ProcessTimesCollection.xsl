<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="XSD">
      <schema location="oramds:/soa/shared/workflow/TaskService.xsd"/>
      <rootElement name="taskAssignedMessage" namespace="http://xmlns.oracle.com/bpel/workflow/taskService"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../BAM_ProcessTimeDO.wsdl"/>
      <rootElement name="_ProcessTimesCollection" namespace="http://xmlns.oracle.com/bam"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.0.0(build 090105.0200.2377) AT [WED JAN 07 15:23:04 PST 2009]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:xpath20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:imp1="http://xmlns.oracle.com/bam"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:wfcommon="http://xmlns.oracle.com/bpel/workflow/common"
                xmlns:tsc="http://xmlns.oracle.com/bpel/workflow/common/tsc"
                xmlns:ns0="http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService"
                xmlns:ns1="http://xmlns.oracle.com/pcbpel/adapter/bam/WebLogicFusionOrderDemo/OrderBookingComposite/BAM_ProcessTimeDO/"
                xmlns:plt="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:routingslip="http://xmlns.oracle.com/bpel/workflow/routingSlip"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.GetRequestHeaderExtnFunction"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:tns="http://xmlns.oracle.com/bpel/workflow/taskService"
                xmlns:task="http://xmlns.oracle.com/bpel/workflow/task"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl wfcommon tsc ns0 routingslip xsd tns task imp1 ns1 plt wsdl bpws xpath20 ora socket oraext dvm hwf mhdr med ids xdk xref ldap">
  <xsl:template match="/">
    <imp1:_ProcessTimesCollection>
      <imp1:_ProcessTimes>
        <imp1:_ECID>
          <xsl:value-of select="/tns:taskAssignedMessage/task:task/task:sca/task:compositeInstanceId"/>
        </imp1:_ECID>
        <imp1:_CompositeName>
          <xsl:value-of select="/tns:taskAssignedMessage/task:task/task:sca/task:compositeName"/>
        </imp1:_CompositeName>
        <imp1:_CompositeVersion>
          <xsl:value-of select="/tns:taskAssignedMessage/task:task/task:sca/task:compositeVersion"/>
        </imp1:_CompositeVersion>
        <imp1:_AssigneeID>
          <xsl:value-of select="/tns:taskAssignedMessage/task:task/task:systemAttributes/task:assignees/task:id"/>
        </imp1:_AssigneeID>
      </imp1:_ProcessTimes>
    </imp1:_ProcessTimesCollection>
  </xsl:template>
</xsl:stylesheet>
