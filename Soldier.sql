create table "SOLDIER" (
 "NUMBER" number,
 "NAME" varchar2(100),
 "BIRTH" date,
 "DIVISION_CODE" number,
 "POSITION_CODE" number,
 "INDAY" date,
 "OUTDAY" date,
 "YEAR" number
 );
 
 create table "DIVISION" (
 "NUMBER" number,
 "DIVISION_NAME" varchar2(100)
 );
 
 create table "POSITION" (
 "NUMBER" number,
 "POSITION_NAME" varchar2(100) 
 );
 
 create table "YEAR" (
 "NUMBER" number,
 "YEAR" varchar(50)
 );
 
 