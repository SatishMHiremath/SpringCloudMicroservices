DROP TABLE IF EXISTS coupon;

CREATE TABLE coupon (
  id number AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(20) NOT NULL,
  discount number NOT NULL,
  expdate VARCHAR(100)
);

