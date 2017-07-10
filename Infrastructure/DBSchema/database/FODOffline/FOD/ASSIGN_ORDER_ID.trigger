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
--         <name>ASSIGN_ORDER_ID</name>
--         <identifier class="java.math.BigDecimal">20955</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_ORDER_ID BEFORE INSERT ON ORDERS
FOR EACH ROW
BEGIN
 IF :NEW.ORDER_ID IS NULL OR :NEW.ORDER_ID < 0 THEN
   SELECT ORDER_SEQ.NEXTVAL
     INTO :NEW.ORDER_ID
     FROM DUAL;
   END IF;
END;
/
