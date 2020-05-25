create table exam(
	syear char(1),
	sclass char(2),
	sno char(2),
	kor number(3),
	eng number(3),
	math number(3),
	primary key(syear, sclass, sno)
);

create table student(
	syear char(1),
	sclass char(2),
	sno char(2),
	sname varchar(30),
	birth date,
	gender char(1),
	tel1 char(3),
	tel2 char(4),
	tel3 char(4),
	primary key(syear, sclass, sno)
);

create table teacher(
	syear char(1),
	sclass char(2),
	tname varchar(30),
	primary key(syear, sclass)
);

insert into exam values('1','01','01','50','50','50');
insert into exam values('1','01','02','60','40','100');
insert into exam values('1','01','03','70','70','70');
insert into exam values('1','02','01','80','80','80');
insert into exam values('1','02','02','50','50','50');
insert into exam values('1','02','03','40','90','80');
insert into exam values('1','03','01','70','70','70');
insert into exam values('1','03','02','80','60','90');
insert into exam values('1','03','03','90','80','70');

insert into student values('1','01','01','김학생','20020101','F','010','1234','1001');
insert into student values('1','01','02','이학생','20020201','M','010','1234','1002');
insert into student values('1','01','03','박학생','20020301','M','010','1234','1003');
insert into student values('1','02','01','조학생','20020401','M','010','1234','1004');
insert into student values('1','02','02','유학생','20020501','M','010','1234','1005');
insert into student values('1','02','03','여학생','20020601','M','010','1234','1006');
insert into student values('1','03','01','남학생','20020701','F','010','1234','1007');
insert into student values('1','03','02','황학생','20020801','F','010','1234','1008');
insert into student values('1','03','03','전학생','20020901','F','010','1234','1009');

insert into teacher values('1','01','김교사');
insert into teacher values('1','02','이교사');
insert into teacher values('1','03','박교사');