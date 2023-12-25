DROP TABLE IF EXISTS fishes;

CREATE TABLE fishes (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  weight VARCHAR(100) NOT NULL,
  price VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO fishes (name,weight,price) VALUES ("タイ", "1000g","￥1036");
INSERT INTO fishes (name,weight,price) VALUES ("カニ", "1000g","￥9424");
INSERT INTO fishes (name,weight,price) VALUES ("マグロ", "1000g","￥4333");
