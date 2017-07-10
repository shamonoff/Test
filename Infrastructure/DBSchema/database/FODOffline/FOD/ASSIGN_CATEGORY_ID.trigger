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
--         <name>ASSIGN_CATEGORY_ID</name>
--         <identifier class="java.math.BigDecimal">20952</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_CATEGORY_ID BEFORE INSERT ON PRODUCT_CATEGORIES_BASE
FOR EACH ROW
BEGIN
 IF :NEW.CATEGORY_ID IS NULL OR :NEW.CATEGORY_ID < 0 THEN
   SELECT CATEGORY_SEQ.NEXTVAL
     INTO :NEW.CATEGORY_ID
     FROM DUAL;
   END IF;
END;
/
