REM Define the product category names on the system
REM $Id: CATEGORY_TRANSLATIONS.sql 888 2007-03-01 16:27:31Z drmills $

INSERT INTO CATEGORY_TRANSLATIONS VALUES (2, 'Office', 'Office Supplies', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (3, 'Electronics', 'Consumer Electronics', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (1, 'Media', 'Books, Music, and Movies', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (4, 'Audio and Video', 'Audio and Video', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (5, 'Camera and Photo', 'Camera and Photo', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (6, 'Cell Phones', 'Cell Phones and Service', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (7, 'Games', 'Computer and Video Games', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (8, 'Books', 'Books', 'EN', 'EN', '0', SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (9, 'DVDs', 'DVDs', 'EN', 'EN', '0', SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (10, 'Periodicals', 'Magazines and Newspapers', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (11, 'Music', 'CDs', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (12, 'Hardware', 'Computers', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (13, 'Supplies', 'Office Supplies', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);
INSERT INTO CATEGORY_TRANSLATIONS VALUES (14, 'Software', 'Software', 'EN', 'EN', 0, SYSDATE, 0, SYSDATE, 1);

-- Clone for alternative languages    
insert into CATEGORY_TRANSLATIONS select category_id, category_name, category_description, 'EL', 'EN', 0,sysdate,0,sysdate,0 from CATEGORY_TRANSLATIONS where language='EN';
insert into CATEGORY_TRANSLATIONS select category_id, category_name, category_description, 'FR', 'EN', 0,sysdate,0,sysdate,0 from CATEGORY_TRANSLATIONS where language='EN';
insert into CATEGORY_TRANSLATIONS select category_id, category_name, category_description, 'DE', 'EN', 0,sysdate,0,sysdate,0 from CATEGORY_TRANSLATIONS where language='EN';
insert into CATEGORY_TRANSLATIONS select category_id, category_name, category_description, 'JA', 'EN', 0,sysdate,0,sysdate,0 from CATEGORY_TRANSLATIONS where language='EN';

