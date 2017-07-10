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
--         <name>ASSIGN_LINE_ITEM_ID</name>
--         <identifier class="java.math.BigDecimal">20956</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_LINE_ITEM_ID BEFORE INSERT ON ORDER_ITEMS
FOR EACH ROW
BEGIN
 IF :NEW.LINE_ITEM_ID IS NULL OR :NEW.LINE_ITEM_ID < 0 THEN
   SELECT ORDER_ITEMS_SEQ.NEXTVAL
     INTO :NEW.LINE_ITEM_ID
     FROM DUAL;
   END IF;
END;
/
