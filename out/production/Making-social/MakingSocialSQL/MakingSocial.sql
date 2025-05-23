-- MySQL dump 10.13  Distrib 9.0.1, for Linux (aarch64)
--
-- Host: localhost    Database: MakingSocial
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Event`
--

LOCK TABLES `Event` WRITE;
/*!40000 ALTER TABLE `Event` DISABLE KEYS */;
INSERT INTO `Event` VALUES (3,'2025-06-26','19:00:00','Puente bomberos',41002,1,'arcoirirs',0,1,'LGTBQ+',1,3),(4,'2026-02-17','00:01:00','Sevilla',41002,0,'Rojo',0,1,'Año nuevo chino',1,2),(5,'2025-05-23','23:59:00','Montequinto',41002,0,'',6,1,'Mi funeral <3',1,4),(6,'2025-05-23','23:59:00','Montequinto',41002,0,'',6,1,'Mi funeral <3',1,4),(7,'2025-05-23','23:59:00','Montequinto',41002,1,'negro',6,1,'Mi funeral <3',1,4),(8,'2025-05-23','23:59:00','Montequinto',41002,1,'negra',6,1,'mi funeral :)',1,4),(9,'2025-05-31','15:00:00','Dos Hermanas',41002,0,'',6,1,'BBQ',0,4);
/*!40000 ALTER TABLE `Event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GuestModel`
--

DROP TABLE IF EXISTS `GuestModel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GuestModel` (
  `ID_User` int NOT NULL,
  `Photo` varchar(10) DEFAULT NULL,
  `CivilStatus` varchar(10) DEFAULT NULL,
  `RRSS` varchar(10) DEFAULT NULL,
  `BIO` varchar(20) DEFAULT NULL,
  `Attendance` mediumtext,
  `ID_GuestModel` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_GuestModel`),
  UNIQUE KEY `ID_User_UNIQUE` (`ID_User`),
  UNIQUE KEY `ID_GuestModel_UNIQUE` (`ID_GuestModel`),
  CONSTRAINT `ID_User` FOREIGN KEY (`ID_User`) REFERENCES `UserProfile` (`ID_User`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GuestModel`
--

LOCK TABLES `GuestModel` WRITE;
/*!40000 ALTER TABLE `GuestModel` DISABLE KEYS */;
INSERT INTO `GuestModel` VALUES (10,NULL,NULL,NULL,NULL,NULL,1),(1,NULL,NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `GuestModel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HostModel`
--

DROP TABLE IF EXISTS `HostModel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HostModel` (
  `ID_Host` int NOT NULL AUTO_INCREMENT,
  `ID_User` int NOT NULL,
  PRIMARY KEY (`ID_Host`),
  KEY `fk_HostModel_User` (`ID_User`),
  CONSTRAINT `fk_HostModel_User` FOREIGN KEY (`ID_User`) REFERENCES `UserProfile` (`ID_User`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HostModel`
--

LOCK TABLES `HostModel` WRITE;
/*!40000 ALTER TABLE `HostModel` DISABLE KEYS */;
INSERT INTO `HostModel` VALUES (2,1),(4,10),(1,19),(3,21),(5,22);
/*!40000 ALTER TABLE `HostModel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Logs`
--

DROP TABLE IF EXISTS `Logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Logs` (
  `ID_GuestModel` int NOT NULL,
  `ID_Event` int NOT NULL,
  `JoinedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `fk_Logs_GuestModel_idx` (`ID_GuestModel`),
  KEY `fk_Logs_Event_idx` (`ID_Event`),
  CONSTRAINT `fk_Logs_Event` FOREIGN KEY (`ID_Event`) REFERENCES `Event` (`ID_Event`),
  CONSTRAINT `fk_Logs_GuestModel` FOREIGN KEY (`ID_GuestModel`) REFERENCES `GuestModel` (`ID_GuestModel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Prevenir que el usuario pueda registrarse en el mismo evento dos veces';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Logs`
--

LOCK TABLES `Logs` WRITE;
/*!40000 ALTER TABLE `Logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `Logs` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root2`@`%`*/ /*!50003 TRIGGER `prevent_duplicate_log` BEFORE INSERT ON `Logs` FOR EACH ROW BEGIN
  IF EXISTS (SELECT 1 FROM Logs WHERE ID_GuestModel = NEW.ID_GuestModel AND ID_Event = NEW.ID_Event) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El usuario ya está registrado en este evento';
  END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `UserProfile`
--

DROP TABLE IF EXISTS `UserProfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserProfile` (
  `ID_User` int NOT NULL AUTO_INCREMENT,
  `NickName` varchar(15) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Name` varchar(10) NOT NULL,
  `Age` int NOT NULL,
  `E_Mail` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_User`),
  UNIQUE KEY `ID_User_UNIQUE` (`ID_User`),
  UNIQUE KEY `NickName_UNIQUE` (`NickName`),
  UNIQUE KEY `E_Mail_UNIQUE` (`E_Mail`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserProfile`
--

LOCK TABLES `UserProfile` WRITE;
/*!40000 ALTER TABLE `UserProfile` DISABLE KEYS */;
INSERT INTO `UserProfile` VALUES (1,'Zhou','1234','Zhou',20,'zzh0001@alu.medac.es'),(2,'ADMIN','1234','ADMIN',25,'admin@gmail.com'),(6,'ADMIN2','1234','ADMIN2',25,'admin2@gmail.com'),(9,'antonio','1234','antonio',25,'antonio@doc.medac.es'),(10,'carmen','1234','carmen',26,'cvi0004@alu.medac.es'),(14,'carmen2','1234','carmen2',26,'cvi00048@alu.medac.es'),(19,'Zhihui','1234','Zhihui',20,'zhou@gmail.com'),(20,'mari','qwerty','mari',27,'mmm@gmail.com'),(21,'marica','1234','mariquin',19,'xoxo@gmail.com'),(22,'zzhou','1234','zzhou',20,'zhouz@gmail.com');
/*!40000 ALTER TABLE `UserProfile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-23 20:54:18
