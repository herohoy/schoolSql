-- use root of mysql to set dbschema by scripts below
create database school DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;  
grant all on school.* to 'schoolAdmin'@'%' identified by 'tdSchool_1';   
flush privileges;
