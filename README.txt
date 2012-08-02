1.Please put the WAP_MVC_SUMANTA folder into tomcat's webapps folder.

2.From the scripts folder run the two batch files. In the "build.bat" change 
the specified path if required as I have used a 64 bit OS.The sample tables 
are created in derby by "create_sample_db.bat". The sql scripts are separately 
written in the sql "scripts.txt" file.

3.provide the suitable entrys in the file .\WAP_MVC_SUMANTA\WEB-INF\classes\DAO\Config.txt.
"login table" and "message table" are the tablenames for storing tables Users(varchar,varchar)" 
and "Comments(Varchar,varchar,varchar)".

4..\WAP_MVC_SUMANTA\WEB-INF\lib is the derby's lib folder with all it's contents.
this may nedd to be changed if version differs.

5.To start the application after running tomcat in brosers URL bar write 
http://127.0.0.1:8080:WAP_MVC_SUMANTA/login.html




If some problem occurs or some modification is needed kindly make me know.
----------------------------------------------------------------------------------
Sumanta Bhattacharjee
B.E. I.T.
Jadavpur University
Kolkata, India
email:sumanta1190@gmail.com