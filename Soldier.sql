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
 
alter table "SOLDIER" add constraint "PK_SOLDIER" primary key ("NUMBER");
alter table "DIVISION" add constraint "PK_DIVISION" primary key ("NUMBER");
alter table "POSITION" add constraint "PK_POSITION" primary key ("NUMBER");
alter table "YEAR" add constraint "PK_YEAR" primary key ("NUMBER");

alter table "SOLDIER" add constraint "FK_DIVISION_CODE" foreign key("DIVISION_CODE") references "DIVISION"("NUMBER") on delete cascade;
alter table "SOLDIER" add constraint "FK_POSITION_CODE" foreign key("POSITION_CODE") references "POSITION"("NUMBER") on delete cascade;
alter table "SOLDIER" add constraint "FK_YEAR_CODE" foreign key("YEAR") references "YEAR"("NUMBER") on delete cascade;
 
create sequence "SEQ_SOLDIER" nocache;
create sequence "SEQ_DIVISION" nocache;
create sequence "SEQ_POSITION" nocache;
create sequence "SEQ_YEAR" nocache;

insert into "DIVISION" values ("SEQ_DIVISION".nextval, '육군');
insert into "DIVISION" values ("SEQ_DIVISION".nextval, '공군');
insert into "DIVISION" values ("SEQ_DIVISION".nextval, '해군');
insert into "DIVISION" values ("SEQ_DIVISION".nextval, '해병대');

insert into "POSITION" values ("SEQ_POSITION".nextval, '보병');
insert into "POSITION" values ("SEQ_POSITION".nextval, '행정병');
insert into "POSITION" values ("SEQ_POSITION".nextval, '운전병');
insert into "POSITION" values ("SEQ_POSITION".nextval, '의무병');
insert into "POSITION" values ("SEQ_POSITION".nextval, '취사병');

insert into "YEAR" values ("SEQ_YEAR".nextval, '1년차');
insert into "YEAR" values ("SEQ_YEAR".nextval, '2년차');
insert into "YEAR" values ("SEQ_YEAR".nextval, '3년차');
insert into "YEAR" values ("SEQ_YEAR".nextval, '4년차');
insert into "YEAR" values ("SEQ_YEAR".nextval, '5년차');
insert into "YEAR" values ("SEQ_YEAR".nextval, '6년차');
insert into "YEAR" values ("SEQ_YEAR".nextval, '7년차~');