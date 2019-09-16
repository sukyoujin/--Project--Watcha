
/* Drop Tables */

DROP TABLE watcha CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE watcha
(
	name varchar2(60) NOT NULL,
	star varchar2(10),
	PRIMARY KEY (name)
);



