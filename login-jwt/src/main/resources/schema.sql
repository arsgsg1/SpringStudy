DROP TABLE IF EXISTS user_authority;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username varchar(50) UNIQUE,
  password varchar(100),
  nickname varchar(50),
  activated boolean
);
CREATE TABLE authority(
  authority_name varchar(50) NOT NULL PRIMARY KEY
);
CREATE TABLE user_authority(
    user_authority_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    authority_name varchar(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES
        user(user_id) ON UPDATE CASCADE,
    FOREIGN KEY (authority_name) REFERENCES
        authority(authority_name) ON UPDATE CASCADE
);