CREATE SEQUENCE CONFIGURATION_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE CONFIGURATION
(
   id          number(38)   NOT NULL,
   name        VARCHAR(200) NOT NULL,
   description VARCHAR(500) NOT NULL,
   value       VARCHAR(500) NOT NULL
);

insert into CONFIGURATION (id,name, description,value) values (CONFIGURATION_SEQ.nextval,'HEALTHY', 'This values defines if the application is healthy or not', 'true' );