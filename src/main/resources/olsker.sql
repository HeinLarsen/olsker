-- WIP

create database if not exists `olsker`:
use `olsker`;

drop table if exists `roles`;
create table roles (
`id` int not null auto_increment,
`privilege` varchar(45) NOT NULL,
primary key (id)
);

drop table if exists `user`;
create table `user` (
  `id` int NOT NULL auto_increment,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  role int default 1,
  balance float default 0,
  foreign key (role) references roles(id),
  primary key (id)
)

drop table if exists `cupcake_top`;
create table `cupcake_top` (
  id int not null auto_increment,
  topping varchar(45) not null,
  price float not null,
  primary key (id)
)

drop table if exists `cupcake_bottom`;
create table `cupcake_bottom` (
  id int not null auto_increment,
  bottom varchar(45) not null,
  price float not null,
  primary key (id)
) 

drop table if exists `order`;
create table `order` (
  id int not null auto_increment,
  user_id not null,
  date Timestamp not null default current_timestamp,
  foreign key (id) references user(id),
  primary key (id)
)