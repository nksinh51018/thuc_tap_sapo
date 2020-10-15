-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: sapo2
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_code` varchar(10) DEFAULT NULL,
  `category_name` nvarchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_description` text COLLATE utf8_bin,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Apple','Các sản phẩm Apple','2020-08-11 00:00:00','2020-08-11 00:00:00'),(2,'Samsung','Các sản phẩm Samsung','2020-08-11 00:00:00','2020-08-11 00:00:00');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `repository_id` int NOT NULL,
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_description` text COLLATE utf8_bin,
  `image_url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `sale_amount` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_Product_Category` (`category_id`),
  KEY `PK_Product_Repository` (`repository_id`),
  CONSTRAINT `PK_Product_Category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `PK_Product_Repository` FOREIGN KEY (`repository_id`) REFERENCES `repositories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,1,1,'Iphone 12','Sản phẩm mới nhất của Apple','https://genk.mediacdn.vn/thumb_w/640/139269124445442048/2020/8/8/photo1596861783634-1596861783818613625814.jpeg',200,500,'2020-08-11 00:00:00','2020-08-11 00:00:00'),(2,2,1,'Samsung Galaxy A51','Sản phẩm tốt của Samsung','https://salt.tikicdn.com/cache/550x550/ts/product/9a/da/fd/c806910bc5a12d1c43a2e0932ff10732.jpg',100,20,'2020-08-11 00:00:00','2020-08-11 00:00:00');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repositories`
--

DROP TABLE IF EXISTS `repositories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repositories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `repository_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `location` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repositories`
--

LOCK TABLES `repositories` WRITE;
/*!40000 ALTER TABLE `repositories` DISABLE KEYS */;
INSERT INTO `repositories` VALUES (1,'Kho 1','Hà Nội','2020-08-11 00:00:00','2020-08-11 00:00:00'),(2,'Kho 2','Bắc Ninh','2020-08-11 00:00:00','2020-08-11 00:00:00');
/*!40000 ALTER TABLE `repositories` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

DROP procedure IF EXISTS delete_category;
DELIMITER $$

CREATE PROCEDURE delete_category(IN num INT(11))
BEGIN
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
	delete from products
	where (category_id = num);
    delete from categories
	where (id = num);
    IF `_rollback` THEN
        ROLLBACK;
    END IF;
END$$

DELIMITER ;

DROP procedure IF EXISTS delete_repository;
DELIMITER $$

CREATE PROCEDURE delete_repository(IN num INT(11))
BEGIN
    DECLARE exit handler for sqlexception
      BEGIN
      ROLLBACK;
   END;
    START TRANSACTION;
	delete from products
	where (repository_id = num);
    delete from repositories
	where (id = num);
END$$

DELIMITER ;

DROP procedure IF EXISTS delete_product;
DELIMITER $$

CREATE PROCEDURE delete_product(IN num INT(11))
BEGIN
    DECLARE exit handler for sqlexception
      BEGIN
      ROLLBACK;
   END;
    START TRANSACTION;
	delete from products
	where (id = num);
END$$

DELIMITER ;

CALL delete_product(3);

-- Dump completed on 2020-08-12 13:45:07
