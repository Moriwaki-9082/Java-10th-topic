DROP TABLE IF EXISTS fishes;

CREATE TABLE fishes (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  priceInYen VARCHAR(255) NOT NULL,
  inventoryQuantity VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO fishes (name,priceInYen,inventoryQuantity) VALUES ("タイ", 1036, 5);
INSERT INTO fishes (name,priceInYen,inventoryQuantity) VALUES ("カニ", 1026, 7);
INSERT INTO fishes (name,priceInYen,inventoryQuantity) VALUES ("マグロ", 4333, 10);

CREATE VIEW fish_view AS
SELECT id, name, CONCAT(priceInYen, '円/kg') AS priceInYen, CONCAT(inventoryQuantity, 'kg') AS inventoryQuantity
FROM fishes;
SELECT * FROM fish_view;
