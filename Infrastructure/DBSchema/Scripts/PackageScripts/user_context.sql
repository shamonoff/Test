CREATE OR REPLACE
PACKAGE user_context_pkg
IS
PROCEDURE set_app_user_lang
  (
    user_lang IN VARCHAR2);
END user_context_pkg;
/
CREATE OR REPLACE
PACKAGE body user_context_pkg
IS
PROCEDURE set_app_user_lang
  (
    user_lang IN VARCHAR2)
              IS
BEGIN
  dbms_application_info.set_client_info(user_lang);
EXCEPTION
WHEN OTHERS THEN
  raise_application_error (-20001, 'Error in user_context_pkg.set_app_user_lang: ' || SQLERRM);
END;
END user_context_pkg;
/