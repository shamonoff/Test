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
--         <name>ASSIGN_WAREHOUSE_ID</name>
--         <identifier class="java.math.BigDecimal">20960</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_WAREHOUSE_ID BEFORE INSERT ON WAREHOUSES
FOR EACH ROW
BEGIN
 IF :NEW.WAREHOUSE_ID IS NULL OR :NEW.WAREHOUSE_ID < 0 THEN
   SELECT SUPPLIER_SEQ.NEXTVAL
     INTO :NEW.WAREHOUSE_ID
     FROM DUAL;
   END IF;
END;
/
