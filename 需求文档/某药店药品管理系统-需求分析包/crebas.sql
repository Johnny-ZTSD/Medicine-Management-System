/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/6 20:48:19                            */
/*==============================================================*/


drop table if exists TB_Major;

drop table if exists TB_Student;

/*==============================================================*/
/* Table: TB_Major                                              */
/*==============================================================*/
create table TB_Major
(
   Mno                  char(4) not null,
   Sno                  char(14),
   Mname                varchar(20),
   Mcollege             varchar(50),
   MleaderId            char(14),
   primary key (Mno)
);

/*==============================================================*/
/* Table: TB_Student                                            */
/*==============================================================*/
create table TB_Student
(
   Sno                  char(14) not null,
   Mno                  char(4),
   Sname                varchar(20),
   major                char(10),
   sex                  char(1),
   primary key (Sno)
);

alter table TB_Major add constraint "FK_Student-Major2" foreign key (Sno)
      references TB_Student (Sno) on delete restrict on update restrict;

alter table TB_Student add constraint "FK_Student-Major" foreign key (Mno)
      references TB_Major (Mno) on delete restrict on update restrict;

