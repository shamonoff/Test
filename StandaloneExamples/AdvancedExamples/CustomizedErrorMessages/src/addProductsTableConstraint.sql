REM  To back out this change, issue the following:
REM  alter table products_base drop constraint name_cannot_begin_with_u;

alter table products_base add (
  constraint name_cannot_begin_with_u
      check (upper(substr(product_name,1,1)) != 'U')
);