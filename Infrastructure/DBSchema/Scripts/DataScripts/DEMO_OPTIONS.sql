REM Define Switches available in the demo 
REM $Id: DEMO_OPTIONS.sql 888 2007-03-01 16:27:31Z drmills $

insert into DEMO_OPTIONS values ('override.customer.email','&&1','java.lang.String','Override email for use when the system sends an email to any customer. If this value is empty then the actual value in the customer table will be used');
insert into DEMO_OPTIONS values ('infrastructure.smtp.server','&&2','java.lang.String','Mail Server for the system to use');
insert into DEMO_OPTIONS values ('option.sip.installed','false','java.lang.Boolean','Is SIP (click to call) integration available?');
insert into DEMO_OPTIONS values ('option.bpel.installed','false','java.lang.Boolean','Is a BPEL engine available?');




