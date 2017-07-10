REM Define the one-time coupons used (not recurring discounts) for customer orders in the system
REM $Id: COUPON_USAGES.sql 888 2007-03-01 16:27:31Z drmills $

insert into COUPON_USAGES values (108, 1, sysdate-11, 1001, 0, SYSDATE, 0, SYSDATE, 0);
insert into COUPON_USAGES values (109, 2, sysdate-3, 1009, 0, SYSDATE, 0, SYSDATE, 0);