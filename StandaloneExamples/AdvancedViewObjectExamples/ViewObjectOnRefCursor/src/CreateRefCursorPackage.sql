REM  For security reasons, the FOD user is not given create procedure privileges
REM  To run this script, issue the following statement as system: 
REM  grant create procedure to fod;

REM  To back out this change, issue the following as FOD:
REM  drop package RefCursorExample;
REM  And run the following as system:
REM  revoke create procedure from fod;

CREATE OR REPLACE PACKAGE RefCursorExample IS
  TYPE ref_cursor IS REF CURSOR;
  FUNCTION get_orders_for_customer(p_email VARCHAR2) RETURN ref_cursor;
  FUNCTION count_orders_for_customer(p_email VARCHAR2) RETURN NUMBER;
END RefCursorExample;
.
/
show errors
CREATE OR REPLACE PACKAGE BODY RefCursorExample IS
  FUNCTION get_orders_for_customer(p_email VARCHAR2) RETURN ref_cursor IS
    the_cursor ref_cursor;
  BEGIN
    OPEN the_cursor FOR
      SELECT o.order_id, o.order_status_code, o.order_total
        FROM orders o, persons p
     WHERE o.customer_id = p.person_id
       AND p.email = p_email;
    RETURN the_cursor;
  END get_orders_for_customer;
  
  FUNCTION count_orders_for_customer(p_email VARCHAR2) RETURN NUMBER IS
    the_count NUMBER;
  BEGIN
    SELECT COUNT(*) 
      INTO the_count
      FROM orders o, persons p
     WHERE o.customer_id = p.person_id
       AND p.email = p_email;
    RETURN the_count;
  END count_orders_for_customer;
END RefCursorExample;
.
/
show errors
