---Database
CREATE DATABASE acennture WITH OWNER postgres;
Commit;

--Secuencia
create sequence sec_accenture_shared_folder
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
Commit;

--Tabla 
create table acc_shared_folder(
  id_shared_folder_ INTEGER NOT NULL DEFAULT NEXTVAL('sec_accenture_shared_folder'),
  id_album INTEGER,
  id_usser INTEGER,
  per_read INTEGER,
  per_write INTEGER,
  primary key (id_shared_folder_)
 );  
 

 Commit;


COMMENT ON COLUMN acc_shared_folder.id_shared_folder_ IS 'Identificador del album compartido';
COMMENT ON COLUMN acc_shared_folder.id_album IS 'Identificador del album';
COMMENT ON COLUMN acc_shared_folder.id_usser IS 'Identificador del usuario';
COMMENT ON COLUMN acc_shared_folder.per_read IS 'Permiso de lectura - true es que que tiene permiso  y false es que no';
COMMENT ON COLUMN acc_shared_folder.per_write IS 'Permiso de escritura - true es que que tiene permiso  y false es que no';


COMMENT ON TABLE acc_shared_folder IS 'Tabla que almacena los permisos a los albumnes compartidos por usuario';

Commit;