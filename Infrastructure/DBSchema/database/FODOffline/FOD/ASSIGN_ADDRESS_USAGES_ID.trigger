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
--         <name>ASSIGN_ADDRESS_USAGES_ID</name>
--         <identifier class="java.math.BigDecimal">20945</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_ADDRESS_USAGES_ID BEFORE INSERT ON ADDRESS_USAGES
FOR EACH ROW
BEGIN
 IF :NEW.ADDRESS_USAGES_ID IS NULL OR :NEW.ADDRESS_USAGES_ID < 0 THEN
   SELECT ADDRESS_USAGES_SEQ.NEXTVAL
     INTO :NEW.ADDRESS_USAGES_ID
     FROM DUAL;
   END IF;
END;
/
