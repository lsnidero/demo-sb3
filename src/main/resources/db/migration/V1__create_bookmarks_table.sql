CREATE SEQUENCE bookmark_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE bookmarks
(
   id         number(38)   NOT NULL,
   title      VARCHAR(200) NOT NULL,
   url        VARCHAR(500) NOT NULL,
   created_at TIMESTAMP DEFAULT systimestamp NOT NULL,
   updated_at TIMESTAMP,
   CONSTRAINT pk_bookmarks PRIMARY KEY (id)
);