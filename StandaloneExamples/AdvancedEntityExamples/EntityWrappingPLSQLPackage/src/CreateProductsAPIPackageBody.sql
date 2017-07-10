CREATE OR REPLACE PACKAGE BODY products_api IS

   PROCEDURE insert_product(p_prod_id NUMBER,   
                            p_name VARCHAR2,   
                            p_supplier_id NUMBER,   
                            p_list_price NUMBER,   
                            p_min_price NUMBER,   
                            p_ship_code VARCHAR2) IS
  BEGIN
    INSERT INTO products_base(product_id,   
                              product_name,   
                              supplier_id,   
                              list_price,   
                              min_price,   
                              shipping_class_code,   
                              product_status,   
                              created_by,   
                              creation_date,   
                              last_updated_by,   
                              last_update_date,   
                              object_version_id)
    VALUES(p_prod_id,   
           p_name,   
           p_supplier_id,   
           p_list_price,   
           p_min_price,   
           p_ship_code,   
           'AVAILABLE',   
           'ProductsModule',   
           sysdate,   
           'ProductsModule',   
           sysdate,   
           0);
  END insert_product;

  PROCEDURE update_product(p_prod_id NUMBER,   
                           p_name VARCHAR2,   
                           p_supplier_id NUMBER,   
                           p_list_price NUMBER,   
                           p_min_price NUMBER,   
                           p_ship_code VARCHAR2) IS
  BEGIN

    UPDATE products_base
    SET product_name = p_name,
      supplier_id = p_supplier_id,
      list_price = p_list_price,
      min_price = p_min_price,
      shipping_class_code = p_ship_code
    WHERE product_id = p_prod_id;
  END update_product;

  PROCEDURE delete_product(p_prod_id NUMBER) IS
  BEGIN

    DELETE FROM products_base
    WHERE product_id = p_prod_id;
  END;

  PROCEDURE lock_product(p_prod_id NUMBER,   
                         p_name OUT VARCHAR2,   
                         p_supplier_id OUT NUMBER,   
                         p_list_price OUT NUMBER,   
                         p_min_price OUT NUMBER,   
                         p_ship_code OUT VARCHAR2) IS
  BEGIN
    SELECT product_name,
      supplier_id,
      list_price,
      min_price,
      shipping_class_code
    INTO p_name,
      p_supplier_id,
      p_list_price,
      p_min_price,
      p_ship_code
    FROM products_base
    WHERE product_id = p_prod_id FOR

    UPDATE NOWAIT;
  END lock_product;

  PROCEDURE select_product(p_prod_id NUMBER,   
                           p_name OUT VARCHAR2,   
                           p_supplier_id OUT NUMBER,   
                           p_list_price OUT NUMBER,   
                           p_min_price OUT NUMBER,   
                           p_ship_code OUT VARCHAR2) IS
  BEGIN
    SELECT product_name,
      supplier_id,
      list_price,
      min_price,
      shipping_class_code
    INTO p_name,
      p_supplier_id,
      p_list_price,
      p_min_price,
      p_ship_code
    FROM products_base
    WHERE product_id = p_prod_id;
  END select_product;
END products_api;
.
/

 SHOW errors

