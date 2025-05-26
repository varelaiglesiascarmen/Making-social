-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Event`
--

LOCK TABLES `Event` WRITE;
/*!40000 ALTER TABLE `Event` DISABLE KEYS */;
INSERT INTO `Event` VALUES (17,'2025-06-26','19:00:00','Sevilla',41002,1,'Arcoiris',0,1,'LGTBQ+',1,7),(18,'2025-05-26','11:00:00','Sevilla',41002,1,'Rojo',21,1,'Año chino',1,7);
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

-- Dump completed on 2025-05-26 10:52:12
