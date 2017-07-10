REM  For security reasons, the FOD user is not given create procedure privileges
REM  To run this script, issue the following statement as system: 
REM  grant create procedure to fod;

REM  To back out this change, issue the following as FOD:
REM  drop package devguidepkg;
REM  And run the following as system:
REM  revoke create procedure from fod;

create or replace package devguidepkg as
  procedure proc_with_no_args;
  procedure proc_with_three_args(n number, d date, v varchar2);
  function  func_with_three_args(n number, d date, v varchar2)
                                 return varchar2;
  procedure proc_with_out_args(n number, d out date, v in out varchar2);
end devguidepkg;
.
/
create or replace package body devguidepkg as
  procedure proc_with_no_args is
  begin
    null;
  end proc_with_no_args;
  procedure proc_with_three_args(n number,d date, v varchar2) is
  begin
    null;
  end proc_with_three_args;
  function  func_with_three_args(n number,d date, v varchar2)
  return VARCHAR2 is 
  begin
    return to_char(n)||','||to_char(d)||','||v;
  end func_with_three_args;
  procedure proc_with_out_args(n number, d out date, v in out varchar2) is
  begin
    d := sysdate;
    v := '('||v||')';
  end proc_with_out_args;
end devguidepkg;
.
/
