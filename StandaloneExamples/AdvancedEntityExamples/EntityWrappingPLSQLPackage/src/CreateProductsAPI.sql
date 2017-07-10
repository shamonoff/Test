REM  For security reasons, the FOD user is not given create procedure privileges
REM  To run this script, issue the following statement as system: 
REM  grant create procedure to fod;

REM  To back out this change, issue the following as FOD:
REM  drop package products_api;
REM  And run the following as system:
REM  revoke create procedure from fod;

@@CreateProductsAPIPackage
@@CreateProductsAPIPackageBody