-- Script to create Fusion Order Demo schema owner
-- Note that the actual schema owner is passed in as a parameter
-- to allow for multiple instances on a shared sever

-- $Id: createFODSchema.sql 2242 2007-08-28 01:23:48Z lmunsing $

DROP USER &&1 CASCADE;

CREATE USER &&1 IDENTIFIED BY &&2 DEFAULT TABLESPACE users 
                                  TEMPORARY TABLESPACE temp  
                                  QUOTA UNLIMITED ON users;

GRANT create session TO &&1 ;
GRANT alter session TO &&1 ;
GRANT create table TO &&1 ;
GRANT create trigger TO &&1 ;
GRANT create view TO &&1 ;
GRANT create sequence TO &&1 ;
GRANT create synonym TO &&1 ;
GRANT create type TO &&1 ;
GRANT create procedure TO &&1 ;

