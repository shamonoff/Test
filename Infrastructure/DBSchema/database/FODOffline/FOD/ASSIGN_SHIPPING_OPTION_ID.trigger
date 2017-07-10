-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1112/offlinedb">
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">FOD</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>ASSIGN_SHIPPING_OPTION_ID</name>
--         <identifier class="java.math.BigDecimal">20957</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_SHIPPING_OPTION_ID BEFORE INSERT ON SHIPPING_OPTIONS_BASE
FOR EACH ROW
BEGIN
 IF :NEW.SHIPPING_OPTION_ID IS NULL OR :NEW.SHIPPING_OPTION_ID < 0 THEN
   SELECT SHIPPING_OPTION_SEQ.NEXTVAL
     INTO :NEW.SHIPPING_OPTION_ID
     FROM DUAL;
   END IF;
END;
/
