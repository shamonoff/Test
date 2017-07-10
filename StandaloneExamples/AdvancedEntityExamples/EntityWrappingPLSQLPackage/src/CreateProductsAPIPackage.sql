create or replace package products_api is
  procedure insert_product(p_prod_id number,
                           p_name varchar2,
                           p_supplier_id number,
                           p_list_price number,
                           p_min_price number,
                           p_ship_code varchar2);
  procedure update_product(p_prod_id number,
                           p_name varchar2,
                           p_supplier_id number,
                           p_list_price number,
                           p_min_price number,
                           p_ship_code varchar2);
  procedure delete_product(p_prod_id number);
  procedure lock_product(p_prod_id number,
                         p_name OUT varchar2,
                         p_supplier_id OUT number,
                         p_list_price OUT number,
                         p_min_price OUT number,
                         p_ship_code OUT varchar2);
  procedure select_product(p_prod_id number,
                         p_name OUT varchar2,
                         p_supplier_id OUT number,
                         p_list_price OUT number,
                         p_min_price OUT number,
                         p_ship_code OUT varchar2);  
end products_api;
.
/
show errors