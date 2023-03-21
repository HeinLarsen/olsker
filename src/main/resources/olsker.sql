-- WIP

create database if not exists `olsker`;
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
  `role` int default 1,
  `balance` float default 0,
  foreign key (role) references roles(id),
  primary key (id)
);

drop table if exists `cupcake_top`;
create table `cupcake_top` (
  `id` int not null auto_increment,
  `topping` varchar(45) not null,
  `price` float not null,
  primary key (id)
);

drop table if exists `cupcake_bottom`;
create table `cupcake_bottom` (
  `id` int not null auto_increment,
  `bottom` varchar(45) not null,
  `price` float not null,
  primary key (id)
);

drop table if exists `order`;
create table `order` (
  `id` int not null auto_increment,
  `user_id` int not null,
  `created` Timestamp not null default current_timestamp,
  foreign key (user_id) references user(id),
  primary key (id)
);

drop table if exists `order_item`;
create table `order_item` (
  `id` int not null auto_increment,
  `order_id` int not null,
  `cupcake_top_id` int not null,
  `cupcake_bottom_id` int not null,
  `quantity` int not null,
  foreign key (order_id) references `order`(id),
  foreign key (cupcake_top_id) references cupcake_top(id),
  foreign key (cupcake_bottom_id) references cupcake_bottom(id),
  primary key (id)
);