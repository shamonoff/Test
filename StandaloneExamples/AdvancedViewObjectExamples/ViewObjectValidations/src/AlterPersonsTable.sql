REM  To back out this change, execute the following statements:
REM  alter table persons drop column discount_eligible;
REM  alter table persons drop column contract_expires;

alter table persons add (
  discount_eligible varchar2(1),
  contract_expires date
);
update persons set discount_eligible = 'Y'
 where person_type_code = 'STAFF';
update persons 
   set contract_expires = trunc(sysdate+trunc(dbms_random.value(1,30)))
   where person_type_code = 'SUPP';
commit;