java org.apache.derby.tools.ij
connect 'jdbc:derby:sumanta;create=true';

create table Users(UserName varchar(40), Password varchar(40)); 
insert into Users values ('sumanta','abcd'); 
insert into Users values ('dodo','efgh'); 

create table Comments(ID varchar(40), comment varchar(400), DATE varchar(40));
insert into Comments values ('sumanta#2012/06/25 12:12:12','hiiiiiiiiii','2012/06/25 12:12:12'); 

disconnect;
exit;

echo DONE
