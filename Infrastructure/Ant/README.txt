The ant build scripts (and the sql scripts that these tasks call)
create a user account named FOD in the USERS tablespace of the database 
specified in the build.properties configuration file.

To create this user and the demo tables, specify the following properties
in the build.properties file:
jdbc.urlBase
jdbc.port                        
jdbc.sid                         

You will be prompted for the system password.

To remove this user, as well as clean up the files copied as a part of this install,
right click build.xml and choose Run Ant Target -> dropAll. Finally, to completely remove the demo from 
your machine, the last step is to delete the directory where you extracted FusionOrderDemo_R1PS3.zip.