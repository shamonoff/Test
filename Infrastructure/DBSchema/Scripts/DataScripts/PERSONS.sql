REM Populate the Fusion Order persons table with Seed data 
REM 100-107 are staff, and are flagged as provisioned. 108-129 are customers and flagged as non-provisioned
REM No titles given yet
REM $Id: PERSONS.sql 2511 2007-09-20 20:20:59Z lmunsing $


INSERT INTO persons VALUES 
        ( 100
        , 'SKING'
        , NULL
        , 'Steven'
        , 'King'
        , 'STAFF'
        , NULL
        , 'Y'
        , 33
        , NULL
        , NULL
        , 'SKING'
        , 'SKING'
        , '920.555.0137'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 101
        , 'NKOCHHAR'
        , NULL
        , 'Neena'
        , 'Kochhar'
        , 'STAFF'
        , NULL
        , 'Y'
        , 34
        , NULL
        , NULL
        , 'NKOCHHAR'
        , 'NKOCHHAR'
        , '248.555.0186'
        , NULL
        , NULL
        , TO_DATE('21-09-1959', 'dd-mm-yyyy')
        , 'SING'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 102
        , 'LDEHAAN'
        , NULL
        , 'Lex'
        , 'De Haan'
        , 'STAFF'
        , NULL
        , 'Y'
        , 35
        , NULL
        , NULL
        , 'LDEHAAN'
        , 'LDEHAAN'
        , '317.555.0152'
        , NULL
        , NULL
        , TO_DATE('13-01-1963', 'dd-mm-yyyy')
        , 'MARR'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 103
        , 'AHUNOLD'
        , NULL
        , 'Alexander'
        , 'Hunold'
        , 'STAFF'
        , NULL        
        , 'Y'
        , 36
        , NULL
        , NULL
        , 'AHUNOLD'
        , 'AHUNOLD'
        , '590.555.0192'
        , NULL
        , NULL
        , TO_DATE('03-01-1960', 'dd-mm-yyyy')
        , 'MARR'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 104
        , 'BERNST'
        , NULL
        , 'Bruce'
        , 'Ernst'
        , 'STAFF'
        , NULL        
        , 'Y'
        , 38
        , NULL
        , NULL
        , 'BERNST'
        , 'BERNST'
        , '970.555.0162'
        , NULL
        , NULL
        , TO_DATE('21-05-1961', 'dd-mm-yyyy')
        , 'COHB'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 105
        , 'DAUSTIN'
        , NULL
        , 'David'
        , 'Austin'
        , 'STAFF'
        , NULL        
        , 'Y'
        , 39
        , NULL
        , NULL
        , 'DAUSTIN'
        , 'DAUSTIN'
        , '401.555.0129'
        , NULL
        , NULL
        , TO_DATE('25-06-1967', 'dd-mm-yyyy')
        , 'MARR'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 106
        , 'VPATABAL'
        , NULL
        , 'Valli'
        , 'Pataballa'
        , 'STAFF'
        , NULL        
        , 'Y'
        , 40
        , NULL
        , NULL
        , 'VPATABAL'
        , 'VPATABAL'
        , '256.555.0130'
        , NULL
        , NULL
        , TO_DATE('05-02-1978', 'dd-mm-yyyy')
        , 'MARR'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 107
        , 'DLORENTZ'
        , NULL
        , 'Diana'
        , 'Lorentz'
        , 'STAFF'
        , NULL        
        , 'Y'
        , 41
        , NULL
        , NULL
        , 'DLORENTZ'
        , 'DLORENTZ'
        , '530.555.0150'
        , NULL
        , NULL
        , TO_DATE('07-02-1969', 'dd-mm-yyyy')
        , 'SING'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 108
        , 'NGREENBE'
        , NULL
        , 'Nancy'
        , 'Greenberg'
        , 'CUST'
        , NULL        
        , 'N'
        , 97
        , NULL
        , NULL
        , 'NGREENBE'
        , 'NGREENBE'
        , '865.555.0102'
        , NULL
        , NULL
        , TO_DATE('17-08-1974', 'dd-mm-yyyy')
        , 'MARR'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 109
        , 'DFAVIET'
        , NULL
        , 'Daniel'
        , 'Faviet'
        , 'CUST'
        , NULL        
        , 'N'
        , 54
        , NULL
        , NULL
        , 'DFAVIET'
        , 'DFAVIET'
        , '331.555.0124'
        , NULL
        , NULL
        , TO_DATE('16-08-1964', 'dd-mm-yyyy')
        , 'MARR'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 110
        , 'JCHEN'
        , NULL
        , 'John'
        , 'Chen'
        , 'CUST'
        , NULL        
        , 'N'
        , 37
        , NULL
        , 1
        , 'JCHEN'
        , 'JCHEN'
        , '706.555.0103'
        , NULL
        , NULL
        , TO_DATE('28-09-1967', 'dd-mm-yyyy')
        , 'MARR'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 111
        , 'ISCIARRA'
        , NULL
        , 'Ismael'
        , 'Sciarra'
        , 'CUST'
        , NULL        
        , 'N'
        , 42
        , NULL
        , 2
        , 'ISCIARRA'
        , 'ISCIARRA'
        , '228.555.0126'
        , NULL
        , NULL
        , TO_DATE('30-09-1971', 'dd-mm-yyyy')
        , 'SING'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 112
        , 'JMURMAN'
        , NULL
        , 'Jose Manuel'
        , 'Urman'
        , 'CUST'
        , NULL        
        , 'N'
        , 55
        , NULL
        , 3
        , 'JMURMAN'
        , 'JMURMAN'
        , '519.555.0121'
        , NULL
        , NULL
        , TO_DATE('07-03-1966', 'dd-mm-yyyy')
        , 'SING'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 113
        , 'LPOPP'
        , NULL
        , 'Luis'
        , 'Popp'
        , 'CUST'
        , NULL        
        , 'N'
        , 14
        , NULL
        , 4
        , 'LPOPP'
        , 'LPOPP'
        , '484.555.0141'
        , NULL
        , NULL
        , TO_DATE('07-12-1969', 'dd-mm-yyyy')
        , 'DIV'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 114
        , 'DRAPHEAL'
        , NULL
        , 'Den'
        , 'Raphaely'
        , 'CUST'
        , NULL        
        , 'N'
        , 22
        , NULL
        , 5
        , 'DRAPHEAL'
        , 'DRAPHEAL'
        , '910.555.0109'
        , NULL
        , NULL
        , TO_DATE('07-12-1974', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 115
        , 'AKHOO'
        , NULL
        , 'Alexander'
        , 'Khoo'
        , 'CUST'
        , NULL        
        , 'N'
        , 63
        , NULL
        , 6
        , 'AKHOO'
        , 'AKHOO'
        , '385.555.0125'
        , NULL
        , NULL
        , TO_DATE('18-05-1965', 'dd-mm-yyyy')
        , 'SING'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 116
        , 'SBAIDA'
        , NULL
        , 'Shelli'
        , 'Baida'
        , 'CUST'
        , NULL        
        , 'N'
        , 74
        , NULL
        , 7
        , 'SBAIDA'
        , 'SBAIDA'
        , '740.555.0184'
        , NULL
        , NULL
        , TO_DATE('24-12-1967', 'dd-mm-yyyy')
        , 'MARR'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 117
        , 'STOBIAS'
        , NULL
        , 'Sigal'
        , 'Tobias'
        , 'CUST'
        , NULL        
        , 'N'
        , 15
        , NULL
        , 8
        , 'STOBIAS'
        , 'STOBIAS'
        , '719.555.0113'
        , NULL
        , NULL
        , TO_DATE('24-07-1967', 'dd-mm-yyyy')
        , 'MARR'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 118
        , 'GHIMURO'
        , NULL
        , 'Guy'
        , 'Himuro'
        , 'CUST'
        , NULL        
        , 'N'
        , 24
        , NULL
        , 9
        , 'GHIMURO'
        , 'GHIMURO'
        , '808.555.0167'
        , NULL
        , NULL
        , TO_DATE('15-11-1968', 'dd-mm-yyyy')
        , 'MARR'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 119
        , 'KCOLMENA'
        , NULL
        , 'Karen'
        , 'Colmenares'
        , 'CUST'
        , NULL        
        , 'N'
        , 28
        , NULL
        , 10
        , 'KCOLMENA'
        , 'KCOLMENA'
        , '848.555.0134'
        , NULL
        , NULL
        , TO_DATE('10-08-1969', 'dd-mm-yyyy')
        , 'PERS'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 120
        , 'MWEISS'
        , NULL
        , 'Matthew'
        , 'Weiss'
        , 'CUST'
        , NULL        
        , 'N'
        , 69
        , NULL
        , 11
        , 'MWEISS'
        , 'MWEISS'
        , '502.555.0182'
        , NULL
        , NULL
        , TO_DATE('18-07-1966', 'dd-mm-yyyy')
        , 'SING'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 121
        , 'AFRIPP'
        , NULL
        , 'Adam'
        , 'Fripp'
        , 'CUST'
        , NULL        
        , 'N'
        , 73
        , NULL
        , 12
        , 'AFRIPP'
        , 'AFRIPP'
        , '330.555.0119'
        , NULL
        , NULL
        , TO_DATE('10-04-1977', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 122
        , 'PKAUFLIN'
        , NULL
        , 'Payam'
        , 'Kaufling'
        , 'CUST'
        , NULL        
        , 'N'
        , 45
        , NULL
        , 13
        , 'PKAUFLIN'
        , 'PKAUFLIN'
        , '650.555.0178'
        , NULL
        , NULL
        , TO_DATE('01-05-1975', 'dd-mm-yyyy')
        , 'COHB'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 123
        , 'SVOLLMAN'
        , NULL
        , 'Shanta'
        , 'Vollman'
        , 'CUST'
        , NULL        
        , 'N'
        , 47
        , NULL
        , 14
        , 'SVOLLMAN'
        , 'SVOLLMAN'
        , '434.555.0139'
        , NULL
        , NULL
        , TO_DATE('10-10-1967', 'dd-mm-yyyy')
        , 'DIV'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 124
        , 'KMOURGOS'
        , NULL
        , 'Kevin'
        , 'Mourgos'
        , 'CUST'
        , NULL        
        , 'N'
        , 32
        , NULL
        , 6
        , 'KMOURGOS'
        , 'KMOURGOS'
        , '907.555.0101'
        , NULL
        , NULL
        , TO_DATE('16-11-1969', 'dd-mm-yyyy')
        , 'MARR'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 125
        , 'JNAYER'
        , NULL
        , 'Julia'
        , 'Nayer'
        , 'CUST'
        , NULL        
        , 'N'
        , 83
        , NULL
        , 12
        , 'JNAYER'
        , 'JNAYER'
        , '424.555.0196'
        , NULL
        , NULL
        , TO_DATE('16-07-1977', 'dd-mm-yyyy')
        , 'MARR'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 126
        , 'IMIKKILI'
        , NULL
        , 'Irene'
        , 'Mikkilineni'
        , 'CUST'
        , NULL        
        , 'N'
        , 91
        , NULL
        , 2
        , 'IMIKKILI'
        , 'IMIKKILI'
        , '240.555.0159'
        , NULL
        , NULL
        , TO_DATE('28-09-1958', 'dd-mm-yyyy')
        , 'MARR'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 127
        , 'JLANDRY'
        , NULL
        , 'James'
        , 'Landry'
        , 'CUST'
        , NULL        
        , 'N'
        , 75
        , NULL
        , 3
        , 'JLANDRY'
        , 'JLANDRY'
        , '518.555.0166'
        , NULL
        , NULL
        , TO_DATE('14-01-1959', 'dd-mm-yyyy')
        , 'SING'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 128
        , 'SMARKLE'
        , NULL
        , 'Steven'
        , 'Markle'
        , 'CUST'
        , NULL        
        , 'N'
        , 10
        , NULL
        , 7
        , 'SMARKLE'
        , 'SMARKLE'
        , '862.555.0180'
        , NULL
        , NULL
        , TO_DATE('08-03-1961', 'dd-mm-yyyy')
        , 'SING'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 129
        , 'LBISSOT'
        , NULL
        , 'Laura'
        , 'Bissot'
        , 'CUST'
        , NULL        
        , 'N'
        , 58
        , NULL
        , NULL
        , 'LBISSOT'
        , 'LBISSOT'
        , '340.555.0114'
        , NULL
        , NULL
        , TO_DATE('20-08-1963', 'dd-mm-yyyy')
        , 'COHB'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'Y'
        , 'Y'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );
        
/* The following are supplier contacts */
INSERT INTO persons VALUES 
        ( 200
        , 'PBROWN'
        , NULL
        , 'Patrick'
        , 'Brown'
        , 'SUPP'
        , 100
        , 'Y'
        , 43
        , NULL
        , NULL
        , 'PBROWN'
        , 'PBROWN'
        , '425.555.0143'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 201
        , 'TBRALICK'
        , NULL
        , 'Terra'
        , 'Bralick'
        , 'SUPP'
        , 101
        , 'Y'
        , 44
        , NULL
        , NULL
        , 'TBRALICK'
        , 'TBRALICK'
        , '512.555.0148'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );
        
INSERT INTO persons VALUES 
        ( 202
        , 'JBOYLE'
        , NULL
        , 'John'
        , 'Boyle'
        , 'SUPP'
        , 102
        , 'Y'
        , 46
        , NULL
        , NULL
        , 'JBOYLE'
        , 'JBOYLE'
        , '651.555.0107'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );

INSERT INTO persons VALUES 
        ( 203
        , 'RBERMAN'
        , NULL
        , 'Rachel'
        , 'Berman'
        , 'SUPP'
        , 103
        , 'Y'
        , 48
        , NULL
        , NULL
        , 'RBERMAN'
        , 'RBERMAN'
        , '337.555.0161'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );
        
INSERT INTO persons VALUES 
        ( 204
        , 'CBENGHIAT'
        , NULL
        , 'Claudia'
        , 'Benghiat'
        , 'SUPP'
        , 104
        , 'Y'
        , 49
        , NULL
        , NULL
        , 'CBENGHIAT'
        , 'CBENGHIAT'
        , '563.555.0127'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        ); 
        
INSERT INTO persons VALUES 
        ( 205
        , 'DSUDEEP'
        , NULL
        , 'Damian'
        , 'Sudeep'
        , 'SUPP'
        , 105
        , 'Y'
        , 50
        , NULL
        , NULL
        , 'DSUDEEP'
        , 'DSUDEEP'
        , '281.555.0198'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        ); 
        
INSERT INTO persons VALUES 
        ( 206
        , 'SHEMANT'
        , NULL
        , 'Sharon'
        , 'Hemant'
        , 'SUPP'
        , 106
        , 'Y'
        , 51
        , NULL
        , NULL
        , 'SHEMANT'
        , 'SHEMANT'
        , '514.555.0199'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );    
        
INSERT INTO persons VALUES 
        ( 207
        , 'JARMSTRONG'
        , NULL
        , 'Jose'
        , 'Armstrong'
        , 'SUPP'
        , 107
        , 'Y'
        , 52
        , NULL
        , NULL
        , 'JARMSTRONG'
        , 'JARMSTRONG'
        , '818.555.0116'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );  
        
INSERT INTO persons VALUES 
        ( 208
        , 'SROYA'
        , NULL
        , 'Steven'
        , 'Roya'
        , 'SUPP'
        , 108
        , 'Y'
        , 53
        , NULL
        , NULL
        , 'SROYA'
        , 'SROYA'
        , '660.555.0145'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        ); 
        
INSERT INTO persons VALUES 
        ( 209
        , 'ACHEN'
        , NULL
        , 'Alison'
        , 'Chen'
        , 'SUPP'
        , 109
        , 'Y'
        , 56
        , NULL
        , NULL
        , 'ACHEN'
        , 'ACHEN'
        , '340.555.0135'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        ); 
        
INSERT INTO persons VALUES 
        ( 210
        , 'ADUCKERS'
        , NULL
        , 'Alex'
        , 'Duckers'
        , 'SUPP'
        , 110
        , 'Y'
        , 57
        , NULL
        , NULL
        , 'ADUCKERS'
        , 'ADUCKERS'
        , '662.555.0106'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 211
        , 'ADEE'
        , NULL
        , 'Anand'
        , 'Dee'
        , 'SUPP'
        , 111
        , 'Y'
        , 59
        , NULL
        , NULL
        , 'ADEE'
        , 'ADEE'
        , '219.555.0144'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 212
        , 'CROUSE'
        , NULL
        , 'Christopher'
        , 'Rouse'
        , 'SUPP'
        , 112
        , 'Y'
        , 60
        , NULL
        , NULL
        , 'CROUSE'
        , 'CROUSE'
        , '815.555.0188'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 213
        , 'KDODD'
        , NULL
        , 'Kyle'
        , 'Dodd'
        , 'SUPP'
        , 113
        , 'Y'
        , 61
        , NULL
        , NULL
        , 'KDODD'
        , 'KDODD'
        , '602.555.0155'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 214
        , 'RCOLLINS'
        , NULL
        , 'Rob'
        , 'Collins'
        , 'SUPP'
        , 114
        , 'Y'
        , 62
        , NULL
        , NULL
        , 'RCOLLINS'
        , 'RCOLLINS'
        , '225.555.0179'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 215
        , 'BSATYANARAYANA'
        , NULL
        , 'Bhaskar'
        , 'Satyanarayana'
        , 'SUPP'
        , 115
        , 'Y'
        , 64
        , NULL
        , NULL
        , 'BSATYANARAYANA'
        , 'BSATYANARAYANA'
        , '864.555.0100'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 216
        , 'SGRAFF'
        , NULL
        , 'Scott'
        , 'Graff'
        , 'SUPP'
        , 116
        , 'Y'
        , 65
        , NULL
        , NULL
        , 'SGRAFF'
        , 'SGRAFF'
        , '732.555.0110'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 217
        , 'FHALVERSON'
        , NULL
        , 'Frank'
        , 'Halverson'
        , 'SUPP'
        , 117
        , 'Y'
        , 66
        , NULL
        , NULL
        , 'FHALVERSON'
        , 'FHALVERSON'
        , '307.555.0176'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
        
INSERT INTO persons VALUES 
        ( 218
        , 'KHAN'
        , NULL
        , 'Katrina'
        , 'Han'
        , 'SUPP'
        , 118
        , 'Y'
        , 67
        , NULL
        , NULL
        , 'KHAN'
        , 'KHAN'
        , '475.555.0147'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'F'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 219
        , 'FSCOTT'
        , NULL
        , 'Frank'
        , 'Scott'
        , 'SUPP'
        , 119
        , 'Y'
        , 68
        , NULL
        , NULL
        , 'FSCOTT'
        , 'FSCOTT'
        , '804.555.0187'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
        
INSERT INTO persons VALUES 
        ( 220
        , 'MGUJAR'
        , NULL
        , 'Mukul'
        , 'Gujar'
        , 'SUPP'
        , 120
        , 'Y'
        , 70
        , NULL
        , NULL
        , 'MGUJAR'
        , 'MGUJAR'
        , '214.555.0191'
        , NULL
        , NULL
        , TO_DATE('17-06-1957', 'dd-mm-yyyy')
        , 'PERS'
        , 'M'
        , NULL
        , NULL
        , NULL
        , 'N'
        , 'N'
        , 0
        , SYSDATE
        , 0
        , SYSDATE
        , 1
        );          
