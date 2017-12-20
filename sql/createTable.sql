CREATE TABLE `bookinfo` (
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `author` varchar(45) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
