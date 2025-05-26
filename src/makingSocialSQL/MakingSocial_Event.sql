-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: host100.tplinkdns.com    Database: MakingSocial
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `Event`
--

DROP TABLE IF EXISTS `Event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Event` (
  `ID_Event` int NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Schedule` time NOT NULL,
  `Location` mediumtext NOT NULL,
  `PostalCode` int NOT NULL,
  `DressCode` tinyint NOT NULL,
  `description1` varchar(15) DEFAULT NULL,
  `AllowedAge` int NOT NULL,
  `Theme` tinyint NOT NULL,
  `description2` varchar(15) DEFAULT NULL,
  `Access` tinyint NOT NULL,
  `ID_Host` int NOT NULL,
  PRIMARY KEY (`ID_Event`),
  UNIQUE KEY `ID_Event_UNIQUE` (`ID_Event`),
  KEY `fk_Event_HostModel_idx` (`ID_Host`),
  CONSTRAINT `fk_Event_HostModel` FOREIGN KEY (`ID_Host`) REFERENCES `HostModel` (`ID_Host`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Event`
--

LOCK TABLES `Event` WRITE;
/*!40000 ALTER TABLE `Event` DISABLE KEYS */;
INSERT INTO `Event` VALUES (3,'2025-06-26','19:00:00','Puente bomberos',41002,1,'arcoirirs',0,1,'LGTBQ+',1,3),(4,'2026-02-17','00:01:00','Sevilla',41002,0,'Rojo',0,1,'Año nuevo chino',1,2),(5,'2025-05-23','23:59:00','Montequinto',41002,0,'',6,1,'Mi funeral <3',1,4),(6,'2025-05-23','23:59:00','Montequinto',41002,0,'',6,1,'Mi funeral <3',1,4),(7,'2025-05-23','23:59:00','Montequinto',41002,1,'negro',6,1,'Mi funeral <3',1,4),(8,'2025-05-23','23:59:00','Montequinto',41002,1,'negra',6,1,'mi funeral :)',1,4),(9,'2025-05-31','15:00:00','Dos Hermanas',41002,0,'',6,1,'BBQ',0,4),(10,'2025-05-25','20:00:00','Sevilla',41002,0,'',18,0,'',1,5),(11,'2025-05-25','20:00:00','Montequinto',41089,0,'',18,0,'',1,6),(12,'2025-05-24','17:00:00','Montequinto',41089,0,'',5,0,'',1,4),(13,'2025-05-27','12:00:00','Casa',52489,1,'pijama',0,1,'Cumple',0,4),(14,'2025-05-27','20:00:00','Sevilla',10000,0,'',16,0,'',1,5),(15,'2025-05-25','19:00:00','El huertino',41089,1,'taparrabo',5,1,'jungla',1,4),(16,'2025-05-24','20:00:00','Madrid',50000,1,'Traje',25,0,'',1,5);
/*!40000 ALTER TABLE `Event` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-26  8:47:23
