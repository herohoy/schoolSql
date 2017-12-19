CREATE TABLE bean_student(
    id varchar(10) not null primary key comment '学生id',
    name varchar(10) comment '学生名称',
    sex varchar(1) comment '性别 1、男 2、女',
    class_id varchar(10) comment '班级id'
) comment '学生表';

insert into bean_student values('1','小文艺','1','1');
insert into bean_student values('2','小数学','1','1');
insert into bean_student values('3','小国际','2','1');
insert into bean_student values('4','小全能','2','2');
insert into bean_student values('5','小体育','1','2');
insert into bean_student values('6','小语言','2','2');
insert into bean_student values('7','爱学习','2','3');
insert into bean_student values('8','学不进','1','3');
insert into bean_student values('9','一般般','1','3');
insert into bean_student values('10','还可以','2','4');
insert into bean_student values('11','学习好','1','5');
insert into bean_student values('12','学习差','1','5');
insert into bean_student values('13','不爱学','2','6');
insert into bean_student values('14','均衡型','2','7');
insert into bean_student values('15','爆发型','1','8');
insert into bean_student values('16','平稳型','2','9');
insert into bean_student values('17','及格型','2','10');
insert into bean_student values('18','小机灵','1','11');
insert into bean_student values('19','小帅哥','1','13');
insert into bean_student values('20','小美女','2','12');
