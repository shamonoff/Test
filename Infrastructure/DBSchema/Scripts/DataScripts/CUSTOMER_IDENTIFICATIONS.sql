-- $Id: CUSTOMER_IDENTIFICATIONS.sql 888 2007-03-01 16:27:31Z drmills $

REM insert into CUSTOMER_IDENTIFICATIONS (
REM    CUSTOMER_ID,
REM    ID_TYPE_CODE,
REM    ID_DETAIL,
REM    ADDITIONAL_INFORMATION,
REM    VERIFIED_FLAG,
REM    VERIFIED_DATE,
REM    VERIFIED_BY,
REM    VERIFICATION_METHOD_CODE,
REM    CREATED_BY,
REM    CREATION_DATE,
REM    LAST_UPDATED_BY,
REM    LAST_UPDATE_DATE,
REM    OBJECT_VERSION_ID
REM );

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    106,
    'SSN',
    '999-99-9999',
    'Birth Certificate',
    'Y',
    SYSDATE,
    100,
    'COPY',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);


insert into CUSTOMER_IDENTIFICATIONS VALUES (
    107,
    'ITIN',
    '999999999',
    'Pending verification of SSN Card',
    'N',
    SYSDATE,
    101,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    108,
    'PASS',
    '1293459439',
    'Passport',
    'Y',
    SYSDATE,
    103,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    109,
    'DL',
    'S-4574-34344',
    'Drivers License',
    'Y',
    SYSDATE,
    104,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    110,
    'DL',
    'C-D344-21224',
    'License',
    'Y',
    SYSDATE,
    105,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);


insert into CUSTOMER_IDENTIFICATIONS VALUES (
    111,
    'DL',
    'CD-D564-SE224',
    'License',
    'Y',
    SYSDATE,
    101,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    112,
    'DL',
    'AA-2364-29224',
    'License',
    'Y',
    SYSDATE,
    101,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    113,
    'DL',
    'ZZ-2XC64-2WEQ24',
    'License',
    'Y',
    SYSDATE,
    102,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    114,
    'SSN',
    '231-45-2321',
    'SSN',
    'Y',
    SYSDATE,
    103,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    115,
    'SSN',
    '121-12-2321',
    'SSN',
    'Y',
    SYSDATE,
    104,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    116,
    'PASS',
    '8989889EW',
    'Passport',
    'Y',
    SYSDATE,
    104,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);


insert into CUSTOMER_IDENTIFICATIONS VALUES (
    117,
    'PASS',
    'QWE8980',
    'Passport',
    'Y',
    SYSDATE,
    105,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);


insert into CUSTOMER_IDENTIFICATIONS VALUES (
    118,
    'PASS',
    '9232057387577748',
    'Passport',
    'Y',
    SYSDATE,
    100,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    119,
    'PASS',
    'ZGHGHA87577748',
    'Passport',
    'Y',
    SYSDATE,
    101,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    120,
    'SSN',
    '908-23-3444',
    'SSN',
    'Y',
    SYSDATE,
    102,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    121,
    'SSN',
    '908-23-3444',
    'SSN',
    'Y',
    SYSDATE,
    103,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    122,
    'SSN',
    '234-23-1244',
    'SSN',
    'Y',
    SYSDATE,
    104,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    123,
    'DL',
    '234-AS-SDHJS23',
    'DL',
    'Y',
    SYSDATE,
    104,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    124,
    'DL',
    '536353-SDHJS23',
    'DL',
    'Y',
    SYSDATE,
    104,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    125,
    'PASS',
    '89980SDHJS23',
    'Passport',
    'Y',
    SYSDATE,
    104,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    126,
    'PASS',
    '1233SDHJS23',
    'Passport',
    'Y',
    SYSDATE,
    105,
    'BUR',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    127,
    'PASS',
    'AD45SDHJS23',
    'Passport',
    'Y',
    SYSDATE,
    105,
    'COPY',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);

insert into CUSTOMER_IDENTIFICATIONS VALUES (
    128,
    'PASS',
    '783792ASD18919',
    'Passport',
    'Y',
    SYSDATE,
    105,
    'COPY',
    0,
    SYSDATE,
    SYSDATE,
    SYSDATE,
    0
);