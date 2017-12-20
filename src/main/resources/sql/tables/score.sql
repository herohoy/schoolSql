CREATE TABLE midl_score(
    studentId varchar(10) comment '学生id',
    lessonName varchar(10) comment '课程代号',
    point int comment '分数',
    primary key(studentId,lessonName)
) comment '分数表-中间表';


insert into midl_score values('1','yuwen','99');
insert into midl_score values('1','shuxue','72');
insert into midl_score values('1','yingyu','69');
insert into midl_score values('2','yuwen','71');
insert into midl_score values('2','shuxue','100');
insert into midl_score values('2','yingyu','66');
insert into midl_score values('3','yuwen','78');
insert into midl_score values('3','shuxue','65');
insert into midl_score values('3','yingyu','97');
insert into midl_score values('4','yuwen','88');
insert into midl_score values('4','shuxue','95');
insert into midl_score values('4','yingyu','92');
insert into midl_score values('5','yuwen','67');
insert into midl_score values('5','shuxue','75');
insert into midl_score values('5','yingyu','72');
insert into midl_score values('6','yuwen','87');
insert into midl_score values('6','shuxue','73');
insert into midl_score values('6','yingyu','92');
insert into midl_score values('7','yuwen','80');
insert into midl_score values('7','shuxue','80');
insert into midl_score values('7','yingyu','80');
insert into midl_score values('8','yuwen','60');
insert into midl_score values('8','shuxue','53');
insert into midl_score values('8','yingyu','55');
insert into midl_score values('9','yuwen','60');
insert into midl_score values('9','shuxue','70');
insert into midl_score values('9','yingyu','67');
insert into midl_score values('10','yuwen','80');
insert into midl_score values('10','shuxue','87');
insert into midl_score values('10','yingyu','77');
insert into midl_score values('11','yuwen','90');
insert into midl_score values('11','shuxue','98');
insert into midl_score values('11','yingyu','93');
insert into midl_score values('12','yuwen','50');
insert into midl_score values('12','shuxue','66');
insert into midl_score values('12','yingyu','43');
insert into midl_score values('13','yuwen','54');
insert into midl_score values('13','shuxue','59');
insert into midl_score values('13','yingyu','63');
insert into midl_score values('14','yuwen','84');
insert into midl_score values('14','shuxue','89');
insert into midl_score values('14','yingyu','83');
insert into midl_score values('15','yuwen','71');
insert into midl_score values('15','shuxue','99');
insert into midl_score values('15','yingyu','62');
insert into midl_score values('16','yuwen','81');
insert into midl_score values('16','shuxue','79');
insert into midl_score values('16','yingyu','91');
insert into midl_score values('17','yuwen','61');
insert into midl_score values('17','shuxue','64');
insert into midl_score values('17','yingyu','60');
insert into midl_score values('18','yuwen','70');
insert into midl_score values('18','shuxue','91');
insert into midl_score values('18','yingyu','68');
insert into midl_score values('19','yuwen','90');
insert into midl_score values('19','shuxue','63');
insert into midl_score values('19','yingyu','58');
insert into midl_score values('20','yuwen','81');
insert into midl_score values('20','shuxue','54');
insert into midl_score values('20','yingyu','88');