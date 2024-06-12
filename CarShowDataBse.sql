-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: db_carshow
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `tbl_carro`
--

DROP TABLE IF EXISTS `tbl_carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_carro` (
  `id_carro` bigint NOT NULL AUTO_INCREMENT,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `precio` int NOT NULL,
  `referencia` varchar(255) DEFAULT NULL,
  `proveedor_id_proveedor` bigint DEFAULT NULL,
  `estado_carro_id_estado_carro` bigint DEFAULT NULL,
  PRIMARY KEY (`id_carro`),
  KEY `FK2l9osjw4a40h9nretosu914cr` (`proveedor_id_proveedor`),
  KEY `FKd0g90wwjisqdnermnmth78epk` (`estado_carro_id_estado_carro`),
  CONSTRAINT `FK2l9osjw4a40h9nretosu914cr` FOREIGN KEY (`proveedor_id_proveedor`) REFERENCES `tbl_proveedor` (`id_proveedor`),
  CONSTRAINT `FKd0g90wwjisqdnermnmth78epk` FOREIGN KEY (`estado_carro_id_estado_carro`) REFERENCES `tbl_estado_carro` (`id_estado_carro`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_carro`
--

LOCK TABLES `tbl_carro` WRITE;
/*!40000 ALTER TABLE `tbl_carro` DISABLE KEYS */;
INSERT INTO `tbl_carro` VALUES (3,'Mazda','2024',150000000,'Mazda CX-5',3,1),(4,'Mazda','2024',160000000,'Mazda Miata',3,1),(5,'BMW','2023',474900000,'BMW M3 Competition',4,1),(6,'BMW','2023',549900000,'BMW X6 M50i',4,1),(7,'Toyota','2024',210000000,'Supra Mk5',5,1);
/*!40000 ALTER TABLE `tbl_carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cliente`
--

DROP TABLE IF EXISTS `tbl_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cliente` (
  `user_name` varchar(255) DEFAULT NULL,
  `id_cliente` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `edad` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cliente`
--

LOCK TABLES `tbl_cliente` WRITE;
/*!40000 ALTER TABLE `tbl_cliente` DISABLE KEYS */;
INSERT INTO `tbl_cliente` VALUES ('juandini',23,'1234','calde',21,'juan'),('jesus',24,'1234','caca',23,'jesus');
/*!40000 ALTER TABLE `tbl_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estado_carro`
--

DROP TABLE IF EXISTS `tbl_estado_carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_estado_carro` (
  `id_estado_carro` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_estado_carro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estado_carro`
--

LOCK TABLES `tbl_estado_carro` WRITE;
/*!40000 ALTER TABLE `tbl_estado_carro` DISABLE KEYS */;
INSERT INTO `tbl_estado_carro` VALUES (1,'disponible'),(2,'no disponible');
/*!40000 ALTER TABLE `tbl_estado_carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estado_fac`
--

DROP TABLE IF EXISTS `tbl_estado_fac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_estado_fac` (
  `id_estado_fac` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_estado_fac`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estado_fac`
--

LOCK TABLES `tbl_estado_fac` WRITE;
/*!40000 ALTER TABLE `tbl_estado_fac` DISABLE KEYS */;
INSERT INTO `tbl_estado_fac` VALUES (1,'Pagado'),(2,'Sin pagar');
/*!40000 ALTER TABLE `tbl_estado_fac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_factura`
--

DROP TABLE IF EXISTS `tbl_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_factura` (
  `id_factura` bigint NOT NULL AUTO_INCREMENT,
  `montofinal` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `estado_fac_id_estado_fac` bigint DEFAULT NULL,
  `personalizacion_carro_id_personalizacion_carro` bigint DEFAULT NULL,
  `vendedor_id_vendedor` bigint DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `FKowlvw1ff3bcxygrpxerdu5x7j` (`estado_fac_id_estado_fac`),
  KEY `FKov248rjp3b47msckp6ut50d4l` (`personalizacion_carro_id_personalizacion_carro`),
  KEY `FK5xqqys4xj7nbhqqquftxd0iv2` (`vendedor_id_vendedor`),
  CONSTRAINT `FK5xqqys4xj7nbhqqquftxd0iv2` FOREIGN KEY (`vendedor_id_vendedor`) REFERENCES `tbl_vendedor` (`id_vendedor`),
  CONSTRAINT `FKov248rjp3b47msckp6ut50d4l` FOREIGN KEY (`personalizacion_carro_id_personalizacion_carro`) REFERENCES `tbl_personalizacion_x_carro` (`id_personalizacion_carro`),
  CONSTRAINT `FKowlvw1ff3bcxygrpxerdu5x7j` FOREIGN KEY (`estado_fac_id_estado_fac`) REFERENCES `tbl_estado_fac` (`id_estado_fac`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_factura`
--

LOCK TABLES `tbl_factura` WRITE;
/*!40000 ALTER TABLE `tbl_factura` DISABLE KEYS */;
INSERT INTO `tbl_factura` VALUES (1,183000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan','2024-05-25',2,36,NULL),(2,183000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus','2024-05-25',2,37,NULL),(3,183000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan','2024-05-25',2,38,NULL),(4,183000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus','2024-05-28',2,43,NULL),(5,162000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan','2024-05-28',2,44,NULL),(6,155000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan','2024-06-03',2,48,NULL),(7,181000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus','2024-06-03',2,49,NULL),(8,183000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus','2024-06-10',2,51,1),(9,486900000,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus','2024-06-10',2,57,1),(10,222000000,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan','2024-06-10',2,67,1),(11,216000000,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus','2024-06-10',2,68,1),(12,222000000,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan','2024-06-10',2,69,1),(13,222000000,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan','2024-06-10',2,69,1),(14,222000000,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan','2024-06-10',2,71,1),(15,222000000,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan','2024-06-10',2,71,1),(16,222000000,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan','2024-06-10',2,71,1),(17,215000000,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan','2024-06-10',2,72,1),(18,162000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus','2024-06-10',2,75,1),(19,162000000,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus','2024-06-10',2,75,1);
/*!40000 ALTER TABLE `tbl_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_personalizacion`
--

DROP TABLE IF EXISTS `tbl_personalizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_personalizacion` (
  `id_personalizacion` bigint NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` int NOT NULL,
  `rines` varchar(255) DEFAULT NULL,
  `proveedor_perso_id_proveedor_perso` bigint DEFAULT NULL,
  PRIMARY KEY (`id_personalizacion`),
  KEY `FK9x5cgg72993k49tg61e8j5q8j` (`proveedor_perso_id_proveedor_perso`),
  CONSTRAINT `FK9x5cgg72993k49tg61e8j5q8j` FOREIGN KEY (`proveedor_perso_id_proveedor_perso`) REFERENCES `tbl_proveedor_perso` (`id_proveedor_perso`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_personalizacion`
--

LOCK TABLES `tbl_personalizacion` WRITE;
/*!40000 ALTER TABLE `tbl_personalizacion` DISABLE KEYS */;
INSERT INTO `tbl_personalizacion` VALUES (1,'azul','Mazda cx-5-Azul-Basica',5000000,'1',3),(2,'azul','Mazda cx-5-Azul-mejorada',11000000,'2',3),(3,'azul','Mazda cx-5-Azul-full',31000000,'3',3),(4,'roja','Mazda cx-5-Roja-Basica',6000000,'1',3),(5,'roja','Mazda cx-5-Roja-mejorada',12000000,'2',3),(6,'roja','Mazda cx-5-Roja-full',32000000,'3',3),(7,'blanca','Mazda cx-5-Blanca-Basica',7000000,'1',3),(8,'blanca','Mazda cx-5-Roja-mejorada',13000000,'2',3),(9,'blanca','Mazda cx-5-Roja-full',33000000,'3',3),(10,'amarillo','BMW M3 amarillo1',5000002,'1',4),(11,'amarillo','BMW M3 amarillo2',11000002,'2',4),(12,'amarillo','BMW M3 amarillo3',13000002,'3',4),(13,'azul','BMW M3 azul1',6000002,'1',4),(14,'azul','BMW M3 azul2',12000002,'2',4),(15,'azul','BMW M3 azul3',14000002,'3',4),(16,'rojo','BMW M3 rojo1',7000002,'1',4),(17,'rojo','BMW M3 rojo2',13000002,'2',4),(18,'rojo','BMW M3 rojo3',15000002,'3',4),(19,'negro','BMW X6 M50i negrol1',5000003,'1',4),(20,'negro','BMW X6 M50i negro2',11000003,'2',4),(21,'negro','BMW X6 M50i negro3',21000003,'3',4),(22,'azul','BMW X6 M50i azul1',6000003,'1',4),(23,'azul','BMW X6 M50i azul2',12000003,'2',4),(24,'azul','BMW X6 M50i azul3',22000003,'3',4),(25,'rojo','BMW X6 M50i rojo1',9000003,'1',4),(26,'rojo','BMW X6 M50i rojo2',15000003,'2',4),(27,'rojo','BMW X6 M50i rojo3',25000003,'3',4),(28,'blanco','BMW X6 M50i blanco1',6300003,'1',4),(29,'blanco','BMW X6 M50i blanco2',12300003,'2',4),(30,'blanco','BMW X6 M50i blanco3',22300003,'3',4),(31,'rojo','Miata mx-5 rojo',1000000,'1',3),(32,'gris','Miata mx-5 gris',4000000,'1',3),(33,'blanco','Miata mx-5 blanco',2000000,'1',3),(34,'azul','Supra Mk5 azul1',5000001,'1',5),(35,'azul','Supra Mk5 azul2',11000001,'2',5),(36,'azul','Supra Mk5 azul3',14000001,'3',5),(37,'blanco','Supra Mk5 blanco1',6000001,'1',5),(38,'blanco','Supra Mk5 blanco2',12000001,'2',5),(39,'blanco','Supra Mk5 blanco3',15000001,'3',5),(40,'negro','Supra Mk5 negro1',5500001,'1',5),(41,'negro','Supra Mk5 negro2',11500001,'2',5),(42,'negro','Supra Mk5 negro3',14500001,'3',5),(43,'rojo','Supra Mk5 rojo1',7000001,'1',5),(44,'rojo','Supra Mk5 rojo2',13000001,'2',5),(45,'rojo','Supra Mk5 rojo3',16000001,'3',5),(46,'naranja','Supra Mk5 naranja1',6400001,'1',5),(47,'naranja','Supra Mk5 naranja2',12400001,'2',5);
/*!40000 ALTER TABLE `tbl_personalizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_personalizacion_x_carro`
--

DROP TABLE IF EXISTS `tbl_personalizacion_x_carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_personalizacion_x_carro` (
  `id_personalizacion_carro` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio_total` int NOT NULL,
  `carro_id_carro` bigint DEFAULT NULL,
  `cliente_id_cliente` bigint DEFAULT NULL,
  `personalizacion_id_personalizacion` bigint DEFAULT NULL,
  PRIMARY KEY (`id_personalizacion_carro`),
  KEY `FKoe5wcox8u2hin0ivq562cpuxa` (`carro_id_carro`),
  KEY `FKa8jt0nb377a6a94nclk7yc2ql` (`cliente_id_cliente`),
  KEY `FKpp3m8uc5x6gg6nfv54p5a6n65` (`personalizacion_id_personalizacion`),
  CONSTRAINT `FKa8jt0nb377a6a94nclk7yc2ql` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`),
  CONSTRAINT `FKoe5wcox8u2hin0ivq562cpuxa` FOREIGN KEY (`carro_id_carro`) REFERENCES `tbl_carro` (`id_carro`),
  CONSTRAINT `FKpp3m8uc5x6gg6nfv54p5a6n65` FOREIGN KEY (`personalizacion_id_personalizacion`) REFERENCES `tbl_personalizacion` (`id_personalizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_personalizacion_x_carro`
--

LOCK TABLES `tbl_personalizacion_x_carro` WRITE;
/*!40000 ALTER TABLE `tbl_personalizacion_x_carro` DISABLE KEYS */;
INSERT INTO `tbl_personalizacion_x_carro` VALUES (23,'jaja',155000000,3,24,1),(24,'jaja',155000000,3,24,1),(25,'jaja',155000000,3,23,1),(26,'jaja',155000000,3,23,1),(28,'jaja',183000000,3,23,9),(29,'jaja',155000000,3,23,1),(30,'jaja',181000000,3,23,3),(31,'jaja',157000000,3,23,7),(32,'carro 2024 Mazda CX-5 de modelo Mazda facturado al cliente de nombre juan',157000000,3,23,7),(33,'carro Mazda CX-5 de modelo Mazda facturado al cliente de nombre jesus',183000000,3,24,9),(34,'carro Mazda CX-5 de modelo 2024 facturado al cliente de nombre jesus',183000000,3,24,9),(35,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',157000000,3,24,7),(36,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan',183000000,3,23,9),(37,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',183000000,3,24,9),(38,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan',183000000,3,23,9),(39,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',182000000,3,24,6),(40,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan',181000000,3,23,3),(41,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',181000000,3,24,3),(42,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan',157000000,3,23,7),(43,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',183000000,3,24,9),(44,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan',162000000,3,23,5),(45,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan',155000000,3,23,1),(48,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan',155000000,3,23,1),(49,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',181000000,3,24,3),(51,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',183000000,3,24,9),(52,'carro Mazda CX-5 de modelo 2024 facturado a nombre de juan',162000000,3,23,5),(53,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',156000000,3,24,4),(54,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',162000000,3,24,5),(55,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',162000000,3,24,5),(56,'carro Mazda Miata de modelo 2024 facturado a nombre de jesus',172000000,4,24,5),(57,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus',486900000,5,24,5),(64,'carro BMW X6 M50i de modelo 2023 facturado a nombre de jesus',561900000,6,24,5),(65,'carro BMW M3 Competition de modelo 2023 facturado a nombre de juan',486900000,5,23,5),(67,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan',222000000,7,23,5),(68,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',216000000,7,24,4),(69,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan',222000000,7,23,5),(71,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan',222000000,7,23,5),(72,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan',215000000,7,23,1),(74,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',217000000,7,24,7),(75,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',162000000,3,24,5),(82,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan',436000000,7,23,45),(88,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',226000000,7,24,45),(90,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan',221000001,7,23,35),(91,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',216000001,7,24,37),(92,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',215500001,7,24,40),(93,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',217000001,7,24,43),(94,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',216400001,7,24,46),(95,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',222400001,7,24,47),(96,'carro Supra Mk5 de modelo 2024 facturado a nombre de jesus',215000001,7,24,34),(97,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus',486900000,5,24,5),(98,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus',479900000,5,24,1),(99,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus',486900000,5,24,5),(100,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus',486900000,5,24,5),(101,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus',486900002,5,24,14),(102,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus',489900002,5,24,18),(103,'carro BMW M3 Competition de modelo 2023 facturado a nombre de jesus',485900002,5,24,11),(104,'carro BMW X6 M50i de modelo 2023 facturado a nombre de jesus',561900000,6,24,5),(105,'carro BMW X6 M50i de modelo 2023 facturado a nombre de jesus',555900000,6,24,4),(106,'carro Supra Mk5 de modelo 2024 facturado a nombre de juan',232300003,7,23,30),(107,'carro BMW X6 M50i de modelo 2023 facturado a nombre de juan',572200003,6,23,30),(108,'carro BMW X6 M50i de modelo 2023 facturado a nombre de jesus',572200003,6,24,30),(109,'carro BMW X6 M50i de modelo 2023 facturado a nombre de jesus',562200003,6,24,29),(110,'carro BMW X6 M50i de modelo 2023 facturado a nombre de jesus',556200003,6,24,28),(111,'carro Mazda Miata de modelo 2024 facturado a nombre de jesus',164000000,4,24,32),(112,'carro Mazda Miata de modelo 2024 facturado a nombre de jesus',161000000,4,24,31),(115,'carro Mazda Miata de modelo 2024 facturado a nombre de jesus',161000000,4,24,31),(117,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',183000000,3,24,9),(118,'carro Mazda CX-5 de modelo 2024 facturado a nombre de jesus',162000000,3,24,5);
/*!40000 ALTER TABLE `tbl_personalizacion_x_carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_proveedor`
--

DROP TABLE IF EXISTS `tbl_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_proveedor` (
  `id_proveedor` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_proveedor`
--

LOCK TABLES `tbl_proveedor` WRITE;
/*!40000 ALTER TABLE `tbl_proveedor` DISABLE KEYS */;
INSERT INTO `tbl_proveedor` VALUES (3,'Mazda','info@mazda.com','+1-800-222-5500'),(4,'BMW','info@bmw.com','+1-800-831-1117'),(5,'Toyota','info@toyota.com','+1-800-331-4331');
/*!40000 ALTER TABLE `tbl_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_proveedor_perso`
--

DROP TABLE IF EXISTS `tbl_proveedor_perso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_proveedor_perso` (
  `id_proveedor_perso` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor_perso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_proveedor_perso`
--

LOCK TABLES `tbl_proveedor_perso` WRITE;
/*!40000 ALTER TABLE `tbl_proveedor_perso` DISABLE KEYS */;
INSERT INTO `tbl_proveedor_perso` VALUES (3,'info@mazda.com','Mazda','+1-800-222-5500'),(4,'info@bmw.com','BMW','+1-800-831-1117'),(5,'info@toyota.com','Toyota','+1-800-331-4331');
/*!40000 ALTER TABLE `tbl_proveedor_perso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_vendedor`
--

DROP TABLE IF EXISTS `tbl_vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_vendedor` (
  `id_vendedor` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `edad` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_vendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_vendedor`
--

LOCK TABLES `tbl_vendedor` WRITE;
/*!40000 ALTER TABLE `tbl_vendedor` DISABLE KEYS */;
INSERT INTO `tbl_vendedor` VALUES (1,'Garcia',26,'Gustabo','123','Gusta');
/*!40000 ALTER TABLE `tbl_vendedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-12 10:45:06
