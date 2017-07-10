<?xml version="1.0" encoding="windows-1252" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <CustomerEmailAddresses>
      <xsl:for-each select="/PersonsView/PersonsViewRow[count(OrdersView/OrdersViewRow) > 1]">
        <xsl:sort select="Email"/>
        <Customer Contact="{Email}"/>
      </xsl:for-each>
    </CustomerEmailAddresses>
  </xsl:template>
</xsl:stylesheet>
