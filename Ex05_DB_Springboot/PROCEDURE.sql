DROP procedure IF EXISTS read_all_products_by_name;
DELIMITER $$

CREATE PROCEDURE read_all_products_by_name(IN pageNumber INT(11),IN productName NVARCHAR(100),IN recordNum INT(11))
BEGIN
 --    DECLARE `_rollback` BOOL DEFAULT 0;
--     DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
--     START TRANSACTION;
	
	Select p.* from products as p
    where p.product_name like concat('%',productName,'%')
    and p.product_status = 1
    order by p.product_name
    limit recordNum
    offset pageNumber;
END$$

DELIMITER ;

DROP procedure IF EXISTS get_product_by_id;
DELIMITER $$

CREATE PROCEDURE get_product_by_id(IN id INT(11))
BEGIN
 --    DECLARE `_rollback` BOOL DEFAULT 0;
--     DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
--     START TRANSACTION;
	Select p.* from products as p
    where p.id = id
    and p.product_status = 1;
END$$

DELIMITER ;

-- DROP procedure IF EXISTS insert_product;
-- DELIMITER $$

-- CREATE PROCEDURE insert_product(IN id INT(11))
-- BEGIN
-- 	DECLARE `_rollback` BOOL DEFAULT 0;
-- 	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
-- 	START TRANSACTION;
-- 	INSERT INTO products (id, product_code, category_id, warehouse_id, product_name, product_description, image_url, amount, sale_amount, `created_at`, `updated_at`, `product_status`, `price`) VALUES ('5', 'SP_05', '1', '1', 'an s pham 1', 'Mo ta tot', 'https://mywebsites.com/imageurl', '10', '1', '2020-08-13 00:00:00', '2020-08-13 00:00:00', '0', '1000000');
-- END$$

-- DELIMITER ;

-- DROP procedure IF EXISTS exist_category;
-- DELIMITER $$

-- CREATE PROCEDURE exist_category(IN id INT(11))
-- BEGIN
-- 	DECLARE `_rollback` BOOL DEFAULT 0;
-- 	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
-- 	START TRANSACTION;
-- 	Select count(*) from categories
--     where categories.id = id;
-- END$$

-- DELIMITER ;

DROP procedure IF EXISTS read_all_products;
DELIMITER $$

CREATE PROCEDURE read_all_products(IN pageNumber INT(11),IN recordNum INT(11))
BEGIN
 --    DECLARE `_rollback` BOOL DEFAULT 0;
--     DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
--     START TRANSACTION;
	
	Select p.* from products as p
    where p.product_status = 1
    limit recordNum
    offset pageNumber;
END$$

DELIMITER ;

DROP procedure IF EXISTS get_last_code;
DELIMITER $$

CREATE PROCEDURE get_last_code()
BEGIN
 --    DECLARE `_rollback` BOOL DEFAULT 0;
--     DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
--     START TRANSACTION;
		SELECT product_code FROM products
        order by product_code desc
        limit 1;
END$$

DELIMITER ;

DROP procedure IF EXISTS check_code;
DELIMITER $$

CREATE PROCEDURE check_code(IN product_code VARCHAR(10),In id INT)
BEGIN
 --    DECLARE `_rollback` BOOL DEFAULT 0;
--     DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
--     START TRANSACTION;
		SELECT count(*) FROM products
		where products.product_code = product_code
		and products.id != id;
END$$

DELIMITER ;

DROP procedure IF EXISTS insert_product;
DELIMITER $$


CREATE PROCEDURE insert_product(IN image_url1 VARCHAR(1000),
							In amount1 INT(11),
                            In category_id1 INT(11),
                            In created_at1 datetime,
                            In price1 Decimal,
                            In product_code1 VARCHAR(10),
                            In product_description1 NVARCHAR(5000),
                            In product_status1 INT(2),
                            In product_name1 NVARCHAR(1000),
                            In sale_amount1 INT(11),
                            In updated_at1 datetime,
                            In warehouse_id1 INT(11))
BEGIN
	-- 	DECLARE `_rollback` BOOL DEFAULT 0;
-- 		DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
-- 		START TRANSACTION;
		INSERT INTO products (product_code, category_id, warehouse_id, product_name, product_description, image_url, amount, sale_amount, created_at, updated_at, product_status, price) 
        VALUES (product_code1, category_id1, warehouse_id1, product_name1, product_description1, image_url1, amount1, sale_amount1, created_at1, updated_at1, product_status1, price1);
		
END$$

DELIMITER ;

DROP procedure IF EXISTS update_product;
DELIMITER $$


CREATE PROCEDURE update_product(IN image_url1 VARCHAR(1000),
							In amount1 INT(11),
                            In category_id1 INT(11),
                            In created_at1 datetime,
                            In price1 Decimal,
                            In product_code1 VARCHAR(10),
                            In product_description1 NVARCHAR(5000),
                            In product_status1 INT(2),
                            In product_name1 NVARCHAR(1000),
                            In sale_amount1 INT(11),
                            In updated_at1 datetime,
                            In warehouse_id1 INT(11),
                            in id1 int)
BEGIN
		-- UPDATE products SET image_url = image_url1 WHERE (id = id1);
-- 		if image_url1 != '' then UPDATE products SET image_url = image_url1 WHERE (id = id1); end if;
--         if amount1 != 0 then UPDATE products SET amount = amount1 WHERE (id = id1); end if;
--         if category_id1 != 0 then UPDATE products SET category_id = category_id1 WHERE (id = id1); end if;
--         if DATE_FORMAT(created_at1, '%d %m %Y') != "" != null then UPDATE products SET created_at = created_at1 WHERE (id = id1); end if;
--         if price1 != 0 then UPDATE products SET price = price1 WHERE (id = id1); end if;
--         if product_code1 != "" then UPDATE products SET product_code = product_code WHERE (id = id1); end if;
--         if product_description1 != "" then UPDATE products SET product_description = product_description1 WHERE (id = id1); end if;
--         if product_status1 != -1 then UPDATE products SET product_status = product_status1 WHERE (id = id1); end if;
--         if product_name1 != "" then UPDATE products SET product_name = product_name1 WHERE (id = id1); end if;
-- 		if sale_amount1 != -1 then UPDATE products SET sale_amount = sale_amount1 WHERE (id = id1); end if;
--         if DATE_FORMAT(updated_at1, '%d %m %Y') != "" then UPDATE products SET updated_at = updated_at1 WHERE (id = id1); end if;
--         if warehouse_id1 != 0 then UPDATE products SET warehouse_id = warehouse_id1 WHERE (id = id1); end if;
		UPDATE products SET product_code = product_code1, category_id = category_id1, warehouse_id = warehouse_id1, product_name = product_name1,
        product_description = product_description1, image_url = image_url1, amount = amount1, sale_amount = sale_amount1,
        created_at = created_at1, updated_at = updated_at1, product_status = product_status1, price = price1 WHERE (id = id1);

END$$

DELIMITER ;

DROP procedure IF EXISTS delete_product;
DELIMITER $$

CREATE PROCEDURE delete_product(In id1 INT)
BEGIN
 --    DECLARE `_rollback` BOOL DEFAULT 0;
--     DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
--     START TRANSACTION;
		UPDATE products SET product_status = 0
        where (id = id1);
END$$

DELIMITER ;

DROP procedure IF EXISTS delete_product_by_warehouse_id;
DELIMITER $$

CREATE PROCEDURE delete_product_by_warehouse_id(In warehouse_id1 INT)
BEGIN
		UPDATE products SET product_status = 0
        where (warehouse_id = warehouse_id1 );
END$$

DELIMITER ;

DROP procedure IF EXISTS delete_product_by_category_id;
DELIMITER $$

CREATE PROCEDURE delete_product_by_category_id(In category_id1 INT)
BEGIN
		UPDATE products SET product_status = 0
        where (category_id = category_id1 );
END$$

DELIMITER ;

DROP procedure IF EXISTS get_products_by_category_id;
DELIMITER $$

CREATE PROCEDURE get_products_by_category_id(In category_id1 INT)
BEGIN
		select * from products
        where category_id = category_id1;
END$$

DELIMITER ;

DROP procedure IF EXISTS get_products_by_warehouse_id;
DELIMITER $$

CREATE PROCEDURE get_products_by_warehouse_id(In warehouse_id1 INT)
BEGIN
		select * from products
        where warehouse_id = warehouse_id1;
END$$

DELIMITER ;









