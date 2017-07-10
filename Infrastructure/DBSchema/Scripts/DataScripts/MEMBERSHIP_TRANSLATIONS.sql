-- $Id: MEMBERSHIP_TRANSLATIONS.sql 888 2007-03-01 16:27:31Z drmills $
REM insert into MEMBERSHIP_TRANSLATIONS values (
REM    MEMBERSHIP_TRANSLATIONS_ID,
REM    MEMBERSHIP_ID,
REM    MEMBERSHIP_NAME,
REM    DESCRIPTION,
REM    LANGUAGE,
REM    SOURCE_LANGUAGE,
REM    CREATED_BY,
REM    CREATION_DATE,
REM    LAST_UPDATED_BY,
REM    LAST_UPDATE_DATE,
REM    OBJECT_VERSION_ID
REM );

insert into MEMBERSHIP_TRANSLATIONS values (
    1,
    1,
    'Frugal Personal Membership',
    'Personal Membership.',
    'EN',
    'EN',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into MEMBERSHIP_TRANSLATIONS values (
    2,
    2,
    'Save the Habitat',
    'Group discount.',
    'EN',
    'EN',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into MEMBERSHIP_TRANSLATIONS values (
    3,
    3,
    'Lasoraz Inc.',
    'Corp discount.',
    'EN',
    'EN',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into MEMBERSHIP_TRANSLATIONS values (
    4,
    4,
    'Hendrix Intl.',
    'Partner discount.',
    'EN',
    'EN',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into MEMBERSHIP_TRANSLATIONS values (
    5,
    5,
    'Saver Personal Membership',
    'Personal Membership.',
    'EN',
    'EN',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into MEMBERSHIP_TRANSLATIONS values (
    6,
    6,
    'Marcus Mitchell LLC.',
    'Corp Membership.',
    'EN',
    'EN',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into MEMBERSHIP_TRANSLATIONS values (
    7,
    7,
    'Silicon Valley Product Management Assoc.',
    'Group Membership.',
    'EN',
    'EN',
    0,
    SYSDATE,
    0,
    SYSDATE,
    0
);

insert into MEMBERSHIP_TRANSLATIONS select null, membership_id, membership_name, description, 'EL', 'EN', 0,sysdate,0,sysdate,0 from MEMBERSHIP_TRANSLATIONS where language='EN';
insert into MEMBERSHIP_TRANSLATIONS select null, membership_id, membership_name, description, 'FR', 'EN', 0,sysdate,0,sysdate,0 from MEMBERSHIP_TRANSLATIONS where language='EN';
insert into MEMBERSHIP_TRANSLATIONS select null, membership_id, membership_name, description, 'DE', 'EN', 0,sysdate,0,sysdate,0 from MEMBERSHIP_TRANSLATIONS where language='EN';
insert into MEMBERSHIP_TRANSLATIONS select null, membership_id, membership_name, description, 'JA', 'EN', 0,sysdate,0,sysdate,0 from MEMBERSHIP_TRANSLATIONS where language='EN';
