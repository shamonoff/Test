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
--         <name>ASSIGN_CUSTOMER_INTRSTS_ID</name>
--         <identifier class="java.math.BigDecimal">20949</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_CUSTOMER_INTRSTS_ID BEFORE INSERT ON CUSTOMER_INTERESTS
FOR EACH ROW
BEGIN
 IF :NEW.CUSTOMER_INTERESTS_ID IS NULL OR :NEW.CUSTOMER_INTERESTS_ID < 0 THEN
   SELECT CUSTOMER_INTERESTS_SEQ.NEXTVAL
     INTO :NEW.CUSTOMER_INTERESTS_ID
     FROM DUAL;
   END IF;
END;
/
