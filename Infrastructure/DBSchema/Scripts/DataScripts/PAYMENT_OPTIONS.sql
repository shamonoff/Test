REM Define the payment options for customers in the system
REM $Id: PAYMENT_OPTIONS.sql 2511 2007-09-20 20:20:59Z lmunsing $
REM TODO:// Change 1020-1057 to have varying account information
REM TODO:// Change all records to have billing id match address of type 'IN' for each person

insert into PAYMENT_OPTIONS values (1001, 108, 'CC', 3, 4111111111111111, 'VISA', add_months(sysdate,+30), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1002, 108, 'CC', 3, 378282246310005, 'AMEX', add_months(sysdate,+22), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1003, 108, 'DD', 3, 123456765432, null, null, null, 789456124, 'Western States Bank', sysdate, null, 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1004, 109, 'CC', 4, 4012888888881881, 'VISA', add_months(sysdate,+12), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1005, 110, 'DD', 5, 9876543219876, null, null, null, 9874321, 'Eastern Credit Union', sysdate, null, 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1006, 111, 'CC', 7, 5555555555551111, 'MSTR', add_months(sysdate,+25), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1007, 112, 'PP', 11, 65432287, null, null, null, null, null, sysdate, null, 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1008, 113, 'CC', 12, 5500000000000004, 'MSTR', add_months(sysdate,+14), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1009, 114, 'CC', 15, 5105105105105100, 'MSTR', add_months(sysdate,+16), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1010, 115, 'PP', 16, 3498763, null, null, null, null, null, sysdate, null, 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1011, 116, 'CC', 17, 343434343434343, 'AMEX', add_months(sysdate,+21), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1012, 117, 'DD', 18, 4408041234567893, '', add_months(sysdate,+30), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1013, 118, 'IN', 1, 9531793216, null, null, null, null, null, sysdate, null, 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1014, 119, 'DD', 20, 7642096532, null, null, null, 43275983, 'First Southern Bank', sysdate, null, 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1015, 120, 'CC', 21, 5555555555554444, 'MSTR', add_months(sysdate,+27), 333, null, null, sysdate, last_day(add_months(sysdate,+30)), 0, SYSDATE,0,SYSDATE,0);
insert into PAYMENT_OPTIONS values (1016, 108, 'IN', 3, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1017, 109, 'IN', 4, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1018, 110, 'IN', 5, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1019, 114, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);

insert into PAYMENT_OPTIONS values (1020, 100, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1021, 101, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1022, 102, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1023, 103, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1024, 104, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1025, 105, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1026, 106, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1027, 107, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);

insert into PAYMENT_OPTIONS values (1028, 121, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1029, 122, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1030, 123, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1031, 124, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1032, 125, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1033, 126, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1034, 127, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1035, 128, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1036, 129, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);

insert into PAYMENT_OPTIONS values (1037, 200, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1038, 201, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1039, 202, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1040, 203, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1041, 204, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1042, 205, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1043, 206, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1044, 207, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1045, 208, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1046, 209, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1047, 210, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1048, 211, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1049, 212, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1050, 213, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1051, 214, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1052, 215, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1053, 216, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1054, 217, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1055, 218, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1056, 219, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
insert into PAYMENT_OPTIONS values (1057, 220, 'IN', 2, 95317932161, null, null, null, null, null, sysdate, null, 0, sysdate, 0, sysdate,0);
