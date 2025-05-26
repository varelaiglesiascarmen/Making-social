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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserProfile`
--

LOCK TABLES `UserProfile` WRITE;
/*!40000 ALTER TABLE `UserProfile` DISABLE KEYS */;
INSERT INTO `UserProfile` VALUES (1,'Zhou','1234','Zhou',20,'zzh0001@alu.medac.es'),(2,'ADMIN','1234','ADMIN',25,'admin@gmail.com'),(6,'ADMIN2','1234','ADMIN2',25,'admin2@gmail.com'),(9,'antonio','1234','antonio',25,'antonio@doc.medac.es'),(10,'carmen','1234','carmen',26,'cvi0004@alu.medac.es'),(14,'carmen2','1234','carmen2',26,'cvi00048@alu.medac.es'),(19,'Zhihui','1234','Zhihui',20,'zhou@gmail.com'),(20,'mari','qwerty','mari',27,'mmm@gmail.com'),(21,'marica','1234','mariquin',19,'xoxo@gmail.com'),(22,'zzhou','1234','zzhou',20,'zhouz@gmail.com'),(23,'juanma','1234','juanma',25,'juanma@gmail.com');
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

-- Dump completed on 2025-05-26  8:37:13
