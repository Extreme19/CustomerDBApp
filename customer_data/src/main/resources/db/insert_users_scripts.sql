
/*SET FOREIGN_KEY_CHECKS = 0;*/
TRUNCATE TABLE `customer_db`.`Customer`;
/*SET FOREIGN_KEY_CHECKS = 1;*/

INSERT INTO `customer_db`.`Customer`(`customerId`,`firstName`,`lastName`,`email`)

VALUES(5,'shola','makinde','sholly@gmail.com'),
(2,'Jerry','Meyers','Meyjay@ymail.com'),
(3,'Charles','Fredrick','C.fred@rocketmail.com');