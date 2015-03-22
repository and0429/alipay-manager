drop table if exists t_loginer;
create table if not exists t_loginer(
	l_id varchar(40) primary key,
	l_username varchar(20) not null,
	l_password varchar(40) not null,
	l_role int,
	l_custOrDistributorId varchar(40)
);