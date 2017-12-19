CREATE TABLE bean_lesson(
    name varchar(10) not null primary key comment '课程代号',
    namecn varchar(10) comment '课程中文名',
    lessonorder smallint comment '课程排序'
) comment '课程表';

insert into bean_lesson values('yuwen','语文',1);
insert into bean_lesson values('shuxue','数学',2);
insert into bean_lesson values('yingyu','英语',3);
