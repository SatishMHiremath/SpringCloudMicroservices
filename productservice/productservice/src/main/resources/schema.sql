DROP TABLE IF EXISTS coupon;

CREATE TABLE product (
  id number AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price number NOT NULL
);

