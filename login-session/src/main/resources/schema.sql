DROP TABLE IF EXISTS login_user;
CREATE TABLE login_user(
  user_pk BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id varchar(255) NOT NULL,
  password varchar(255) NOT NULL
);