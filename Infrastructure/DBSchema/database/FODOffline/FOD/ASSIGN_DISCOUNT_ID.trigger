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
--         <name>ASSIGN_DISCOUNT_ID</name>
--         <identifier class="java.math.BigDecimal">20950</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_DISCOUNT_ID BEFORE INSERT ON DISCOUNTS_BASE
FOR EACH ROW
BEGIN
 IF :NEW.DISCOUNT_ID IS NULL OR :NEW.DISCOUNT_ID < 0 THEN
   SELECT DISCOUNT_SEQ.NEXTVAL
     INTO :NEW.DISCOUNT_ID
     FROM DUAL;
   END IF;
END;
/
