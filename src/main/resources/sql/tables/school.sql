CREATE TABLE bean_school(
    id varchar(10) not null primary key comment '学校id',
    name varchar(100) comment '学校名'
) comment '学校表';
insert into bean_school values('1','今天SCALA学校');