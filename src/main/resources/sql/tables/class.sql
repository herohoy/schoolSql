CREATE TABLE bean_clazz(
    id varchar(10) not null primary key comment '班级id',
    name varchar(10) comment '班级名称',
    classorder int(2) comment '排序',
    grade_id varchar(10) comment '年级id'
) comment '班级表';
insert into bean_clazz values('1','一班',1,'1');
insert into bean_clazz values('2','二班',2,'1');
insert into bean_clazz values('3','三班',3,'1');
insert into bean_clazz values('4','一班',1,'2');
insert into bean_clazz values('5','二班',2,'2');
insert into bean_clazz values('6','一班',1,'3');
insert into bean_clazz values('7','二班',2,'3');
insert into bean_clazz values('8','一班',1,'4');
insert into bean_clazz values('9','二班',2,'4');
insert into bean_clazz values('10','一班',1,'5');
insert into bean_clazz values('11','二班',2,'5');
insert into bean_clazz values('12','一班',1,'6');
insert into bean_clazz values('13','二班',2,'6');
