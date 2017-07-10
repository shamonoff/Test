REM Define the shipping options available on the system
REM $Id: SHIPPING_OPTION_TRANSLATIONS.sql 1644 2007-06-01 19:21:52Z lmunsing $

INSERT INTO SHIPPING_OPTION_TRANSLATIONS VALUES (1, 1, 'Standard Shipping (3-5 business days)', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 0);
INSERT INTO SHIPPING_OPTION_TRANSLATIONS VALUES (2, 2, 'Two-Day Shipping', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 0);
INSERT INTO SHIPPING_OPTION_TRANSLATIONS VALUES (3, 3, 'One-Day Shipping', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 0);
INSERT INTO SHIPPING_OPTION_TRANSLATIONS VALUES (4, 4, 'Pick-up', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 0);

insert into SHIPPING_OPTION_TRANSLATIONS select null, shipping_option_id, shipping_method, 'JA', 'EN', 0,sysdate,0,sysdate,0 from SHIPPING_OPTION_TRANSLATIONS where language='EN';
insert into SHIPPING_OPTION_TRANSLATIONS select null, shipping_option_id, shipping_method, 'EL', 'EN', 0,sysdate,0,sysdate,0 from SHIPPING_OPTION_TRANSLATIONS where language='EN';
insert into SHIPPING_OPTION_TRANSLATIONS select null, shipping_option_id, shipping_method, 'DE', 'EN', 0,sysdate,0,sysdate,0 from SHIPPING_OPTION_TRANSLATIONS where language='EN';
insert into SHIPPING_OPTION_TRANSLATIONS select null, shipping_option_id, shipping_method, 'FR', 'EN', 0,sysdate,0,sysdate,0 from SHIPPING_OPTION_TRANSLATIONS where language='EN';
