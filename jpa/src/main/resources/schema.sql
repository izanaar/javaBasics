create table adv_groups (id bigint not null, groupId bigint, groupName varchar(255), group_id bigint, primary key (id));




create table users (
  id bigint not null,
  description varchar(255),
  login varchar(255),
  password varchar(255),
  title varchar(255),
  primary key (id));