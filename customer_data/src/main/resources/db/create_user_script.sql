DROP USER IF EXISTS 'springapp_user'@'loclhost';

CREATE USER 'springapp_user'@'localhost' IDENTIFIED BY 'mypassword';

GRANT ALL PRIVILEGES ON customer.* TO 'springapp_user'@'localhost';

FLUSH PRIVILEGES;