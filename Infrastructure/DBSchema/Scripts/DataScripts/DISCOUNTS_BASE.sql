-- $Id: DISCOUNTS_BASE.sql 888 2007-03-01 16:27:31Z drmills $
REM DISCOUNT_ID
REM DISCOUNT_TYPE_CODE
REM DISCOUNT_AMOUNT
REM APPLY_AS_PERCENTAGE_FLAG
REM EASY_CODE
REM ADD_FREE_SHIPPING_FLAG
REM ONETIME_DISCOUNT_FLAG
REM CREATED_BY
REM CREATION_DATE
REM LAST_UPDATED_BY
REM LAST_UPDATE_DATE
REM OBJECT_VERSION_ID

insert into DISCOUNTS_BASE values(
    1,
    'COUP',
    10,
    'N',
    'TENOFF',
    'N',
    'Y',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into DISCOUNTS_BASE values(
    2,
    'COUP',
    10,
    'N',
    'TENOFFPLUS',
    'Y',
    'Y',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);


insert into DISCOUNTS_BASE values(
    3,
    'MEMB',
    0,
    'N',
    'FREESHIP',
    'Y',
    'Y',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into DISCOUNTS_BASE values(
    4,
    'SLVR',
    5,
    'N',
    'FREESHIPSLVR',
    'Y',
    'Y',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into DISCOUNTS_BASE values(
    5,
    'GOLD',
    10,
    'N',
    'FREESHIPGLD',
    'Y',
    'Y',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into DISCOUNTS_BASE values(
    6,
    'CORP',
    12,
    'Y',
    'CORP1DISC',
    'N',
    'Y',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into DISCOUNTS_BASE values(
    7,
    'PART',
    15,
    'Y',
    'PART1DISC',
    'N',
    'Y',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);