-- Populate the Fusion Order Demo tables with Seed data 
-- $Id: populateFODSchemaTables.sql 2095 2007-08-08 06:26:32Z csteriad $
-- Note when running from Ant this script is bypassed

-- General settings for the demo
@@DataScripts/DEMO_OPTIONS &&1 &&2

-- Languages Supported by the System 
@@DataScripts/AVAILABLE_LANGUAGES

-- Standard List of country codes
@@DataScripts/COUNTRY_CODES US
@@DataScripts/COUNTRY_CODES F
@@DataScripts/COUNTRY_CODES D
@@DataScripts/COUNTRY_CODES JP
@@DataScripts/COUNTRY_CODES EL

-- Lookup codes for each supported language
@@DataScripts/LOOKUP_CODES US
@@DataScripts/LOOKUP_CODES F
@@DataScripts/LOOKUP_CODES D
@@DataScripts/LOOKUP_CODES JP
@@DataScripts/LOOKUP_CODES EL

-- Other Schema Objects
@@DataScripts/ADDRESSES
@@DataScripts/MEMBERSHIPS_BASE
@@DataScripts/MEMBERSHIP_TRANSLATIONS
@@DataScripts/SUPPLIERS
@@DataScripts/PERSONS
@@DataScripts/ADDRESS_USAGES
@@DataScripts/PRODUCT_CATEGORIES_BASE
@@DataScripts/CATEGORY_TRANSLATIONS
@@DataScripts/PRODUCTS_BASE
@@DataScripts/CUSTOMER_INTERESTS
@@DataScripts/SHIPPING_OPTIONS_BASE
@@DataScripts/SHIPPING_OPTION_TRANSLATIONS
@@DataScripts/WAREHOUSES
@@DataScripts/WAREHOUSE_STOCK_LEVELS
@@DataScripts/CUSTOMER_IDENTIFICATIONS
@@DataScripts/PAYMENT_OPTIONS
@@DataScripts/DISCOUNTS_BASE
@@DataScripts/DISCOUNT_TRANSLATIONS
@@DataScripts/ELIGIBLE_DISCOUNTS
@@DataScripts/ORDERS
@@DataScripts/COUPON_USAGES
@@DataScripts/ORDER_ITEMS
@@DataScripts/PRODUCT_TRANSLATIONS
@@DataScripts/HELP_TRANSLATIONS
@@DataScripts/ALTER_TABLES
commit;


