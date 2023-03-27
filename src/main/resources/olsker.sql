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
  `paid` boolean default false,
  foreign key (user_id) references user(id),
  primary key (id)
);

drop table if exists `order_item`;
create table `order_item` (
  `id` int not null auto_increment,
  `order_id` int not null,
  `cupcake_top_id` int not null,
  `cupcake_bottom_id` int not null,
  `cupcake_top_price` float not null,
  `cupcake_bottom_price` float not null,
  `quantity` int not null,
  foreign key (order_id) references `order`(id),
  foreign key (cupcake_top_id) references cupcake_top(id),
  foreign key (cupcake_bottom_id) references cupcake_bottom(id),
  primary key (id)
)
CREATE VIEW order_item_view AS
SELECT o.id AS order_id,
       u.email,
       CONCAT(ct.topping, ' / ', cb.bottom) AS cupcake_type,
       (oi.cupcake_top_price + oi.cupcake_bottom_price) AS total_price,
       oi.quantity
FROM `order` o
JOIN `user` u ON o.user_id = u.id
JOIN `order_item` oi ON o.id = oi.order_id
JOIN `cupcake_top` ct ON oi.cupcake_top_id = ct.id
JOIN `cupcake_bottom` cb ON oi.cupcake_bottom_id = cb.id;


CREATE DATABASE  IF NOT EXISTS `olsker_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `olsker_test`;
CREATE TABLE olsker_test.user LIKE olsker.user;