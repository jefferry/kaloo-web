create database mybatis;
use mybatis;

drop table if exists t_user;
create table t_user(
user_id int not null auto_increment,
user_name varchar(30) default null,
user_birthday date default null,
user_salary double default null,
create_time datetime default null,
update_time datetime default null,
primary key(user_id)
)ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;