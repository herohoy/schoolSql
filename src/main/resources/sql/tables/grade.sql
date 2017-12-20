CREATE TABLE bean_grade(
    id varchar(10) not null primary key comment '年级id',
    level tinyint(2) comment '学制级别 1、幼儿园 2、小学 3、初中 4、高中',
    year int(4) comment '学年',
    school_id varchar(10) comment '学校id'
) comment '年级表';
insert into bean_grade values('1',2,2017,'1');
insert into bean_grade values('2',2,2016,'1');
insert into bean_grade values('3',2,2015,'1');
insert into bean_grade values('4',2,2014,'1');
insert into bean_grade values('5',2,2013,'1');
insert into bean_grade values('6',2,2012,'1');
