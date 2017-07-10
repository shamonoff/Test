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
--         <name>ASSIGN_PRODUCT_ID</name>
--         <identifier class="java.math.BigDecimal">20953</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_PRODUCT_ID BEFORE INSERT ON PRODUCTS_BASE
FOR EACH ROW
BEGIN
 IF :NEW.PRODUCT_ID IS NULL OR :NEW.PRODUCT_ID < 0 THEN
   SELECT PRODUCT_SEQ.NEXTVAL
     INTO :NEW.PRODUCT_ID
     FROM DUAL;
   END IF;
END;
/
