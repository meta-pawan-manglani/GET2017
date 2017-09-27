create database get_testdb;
CREATE USER 'get_user'@'localhost' IDENTIFIED BY 'get_pwd';
GRANT ALL ON get_testdb.* TO 'get_user'@'localhost';

use get_testdb;

create TABLE Product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25),
  price double
);