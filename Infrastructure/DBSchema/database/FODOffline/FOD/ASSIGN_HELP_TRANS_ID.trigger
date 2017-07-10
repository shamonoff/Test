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
--         <name>ASSIGN_HELP_TRANS_ID</name>
--         <identifier class="java.math.BigDecimal">20961</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_HELP_TRANS_ID BEFORE INSERT ON HELP_TRANSLATIONS
FOR EACH ROW
BEGIN
 IF :NEW.HELP_TRANSLATIONS_ID IS NULL OR :NEW.HELP_TRANSLATIONS_ID < 0 THEN
   SELECT HELP_TRANSLATIONS_SEQ.NEXTVAL
     INTO :NEW.HELP_TRANSLATIONS_ID
     FROM DUAL;
   END IF;
END;
/
