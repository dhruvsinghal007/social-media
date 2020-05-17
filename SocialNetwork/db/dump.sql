CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

  
CREATE TABLE `friend` (
  `id` varchar(45) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `friend_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;



INSERT INTO ``user` (`id`, `first_name`, `last_name`, `avatar`) VALUES ('1', 'Dhruve', 'Singal', 'Dummy');
INSERT INTO ``user` (`id`, `first_name`, `last_name`, `avatar`) VALUES ('2', 'Archit', 'Batra', 'Dummy');
INSERT INTO ``user` (`id`, `first_name`, `last_name`, `avatar`) VALUES ('3', 'Lakhan', 'Sejwani', 'Dummy');

INSERT INTO `friend` (`id`, `user_id`, `friend_id`) VALUES ('a1', '1', '2');
INSERT INTO `friend` (`id`, `user_id`, `friend_id`) VALUES ('a2', '2', '3');

