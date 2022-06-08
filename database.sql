
CREATE DATABASE acennture WITH OWNER postgres;

create sequence sec_accenture_shared_folder
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  
create table acc_shared_folder(
  id_shared_folder_ INTEGER NOT NULL DEFAULT NEXTVAL('sec_accenture_shared_folder'),
  id_album INTEGER,
  id_usser INTEGER,
  per_read INTEGER,
  per_write INTEGER,
  primary key (id_shared_folder_)
 );  
 
