DROP TABLE IF EXISTS fishes;

-- 情報テーブル作成
CREATE TABLE fishes (
  -- 管理idデータ設定
  id int unsigned AUTO_INCREMENT,
  -- 名前データ設定
  name VARCHAR(255) NOT NULL,
  -- 重量単価データ設定
  priceInYen VARCHAR(255) NOT NULL,
  -- 在庫量データ設定
  inventoryQuantity VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);

--初期データベース作成
INSERT INTO fishes (name,priceInYen,inventoryQuantity) VALUES ("タイ", 1036, 5);
INSERT INTO fishes (name,priceInYen,inventoryQuantity) VALUES ("カニ", 1026, 7);
INSERT INTO fishes (name,priceInYen,inventoryQuantity) VALUES ("マグロ", 4333, 10);

-- 表示用テーブル作成
CREATE VIEW fish_view AS
SELECT id, name, CONCAT(priceInYen, '円/kg') AS priceInYen, CONCAT(inventoryQuantity, 'kg') AS inventoryQuantity
FROM fishes;
SELECT * FROM fish_view;
