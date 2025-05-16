CREATE SEQUENCE USERS_SEQ;

CREATE TABLE USERS (

   ID          number(38)   NOT NULL,
   NAME        VARCHAR(200) NOT NULL,
   SURNAME     VARCHAR(200) NOT NULL,
   EMAIL       VARCHAR(200) NOT NULL,
   EXTERNAL_ID VARCHAR(36)  NOT NULL,
   AGE         number(2)    NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);
alter table USERS add constraint uk_users UNIQUE (EXTERNAL_ID);


INSERT INTO USERS (ID, EXTERNAL_ID, NAME, SURNAME,EMAIL, AGE) VALUES (USERS_SEQ.nextval, 'feaa864c-0932-4855-a06d-ac6ee767e596','Pluto','Paperino', 'pluto@mail.com', 52);