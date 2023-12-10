DROP TABLE IF EXISTS fishes;

CREATE TABLE fishes (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  weight VARCHAR(100) NOT NULL,
  price VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO fishes (name,weight,price) VALUES ("タイ", "2200g","￥1400");
INSERT INTO fishes (name,weight,price) VALUES ("カニ", "500g","￥10000");
INSERT INTO fishes (name,weight,price) VALUES ("マグロ", "30000g","￥93510");
