-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: sapo
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
  `category_code` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_description` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `category_status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'CG_001','ăn','1','2020-08-05 00:00:00','2020-08-05 00:00:00',1),(2,'CG_002','asd','faf','2020-08-05 00:00:00','2020-08-14 14:48:40',1),(3,'CG_003','saf','asfa','2020-08-05 00:00:00','2020-08-05 00:00:00',1),(5,'CG_004','dsdsaf','fdsf','2020-08-14 13:36:08','2020-08-14 14:55:52',1),(6,'CG_005','ds','fdsf','2020-08-15 08:18:59','2020-08-15 08:18:59',1);
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
  `product_code` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `category_id` int NOT NULL,
  `warehouse_id` int NOT NULL,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image_url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `sale_amount` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `product_status` int DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_Products_Categories_idx` (`category_id`),
  KEY `PK_Products_Warehouses_idx` (`warehouse_id`),
  CONSTRAINT `PK_Products_Categories` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `PK_Products_Warehouses` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'SP_001',1,1,'San pham 1','Mo ta tot','https://mywebsites.com/imageurl',10,1,'2020-08-13 00:00:00','2020-08-13 00:00:00',1,1000000),(2,'SP_002',1,1,'an pham 1','Mo ta tot','https://mywebsites.com/imageurl',10,1,'2020-08-13 00:00:00','2020-08-13 00:00:00',1,1000000),(3,'SP_003',1,1,'an pham s 1','Mo ta tot','https://mywebsites.com/imageurl',10,1,'2020-08-13 00:00:00','2020-08-13 00:00:00',1,1000000),(4,'SP_004',2,1,'an s pham 1','Mo ta tot','https://mywebsites.com/imageurl',10,1,'2020-08-13 00:00:00','2020-08-13 00:00:00',1,1000000),(5,'SP_005',1,1,'an s pham 1','Mo ta tot','https://mywebsites.com/imageurl',10,1,'2020-08-13 00:00:00','2020-08-13 00:00:00',1,1000000),(6,'SP_001',1,1,'1','1','1',1,1,'2020-08-15 00:00:00','2020-08-15 10:32:26',1,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouses`
--

DROP TABLE IF EXISTS `warehouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehouses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `warehouse_code` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `warehouse_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `location` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `warehouse_status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouses`
--

LOCK TABLES `warehouses` WRITE;
/*!40000 ALTER TABLE `warehouses` DISABLE KEYS */;
INSERT INTO `warehouses` VALUES (1,'WH_001','fds','dssad','2020-08-13 00:00:00','2020-08-14 14:45:17',1),(2,'WH_002','abc','Hà Nội','2020-08-13 00:00:00','2020-08-13 00:00:00',1),(3,'WH_003','bac','Hà Nội','2020-08-13 00:00:00','2020-08-13 00:00:00',1),(4,'WH_004','cab','Hà Nội','2020-08-13 00:00:00','2020-08-13 00:00:00',1),(5,'WH_005','fdsf','asdsa','2020-08-14 14:09:24','2020-08-14 14:57:14',1);
/*!40000 ALTER TABLE `warehouses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-15 11:41:34
