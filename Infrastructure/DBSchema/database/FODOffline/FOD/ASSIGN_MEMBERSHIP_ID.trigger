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
--         <name>ASSIGN_MEMBERSHIP_ID</name>
--         <identifier class="java.math.BigDecimal">20947</identifier>
--         <schemaName>FOD</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
-- </trigger>

TRIGGER ASSIGN_MEMBERSHIP_ID BEFORE INSERT ON MEMBERSHIPS_BASE
FOR EACH ROW
BEGIN
 IF :NEW.MEMBERSHIP_ID IS NULL OR :NEW.MEMBERSHIP_ID < 0 THEN
   SELECT MEMBER_SEQ.NEXTVAL
     INTO :NEW.MEMBERSHIP_ID
     FROM DUAL;
   END IF;
END;
/
