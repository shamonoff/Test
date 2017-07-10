REM  For security reasons, the FOD user is not given create type privileges
REM  To run this script, issue the following statement as system: 
REM  grant create type to fod;

REM  To back out this change, issue the following as FOD:
REM  drop table interesting_points;
REM  drop type point_type;

drop table interesting_points;
drop type point_type;
create type point_type as object ( x_coord number, y_coord number);
.
/
create table interesting_points(
  id number primary key,
  coordinates point_type,
  description varchar2(20)
);
insert into interesting_points values(1001,point_type(0,0),'The origin');
commit;