-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nofluffcars_data
-- ------------------------------------------------------
-- Server version	8.0.25

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

CREATE DATABASE IF NOT EXISTS `nofluffcars` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nofluffcars`;

--
-- Table structure for table `generation`
--

DROP TABLE IF EXISTS `generation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generation` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `ID_model` bigint NOT NULL,
  `name` varchar(50) NOT NULL,
  `prod_year_start` smallint NOT NULL,
  `prod_year_end` smallint NOT NULL,
  `bt_hatchback` tinyint(1) NOT NULL DEFAULT '0',
  `bt_sedan` tinyint(1) NOT NULL DEFAULT '0',
  `bt_wagon` tinyint(1) NOT NULL DEFAULT '0',
  `bt_coupe` tinyint(1) NOT NULL DEFAULT '0',
  `bt_convertible` tinyint(1) NOT NULL DEFAULT '0',
  `bt_suv` tinyint(1) NOT NULL DEFAULT '0',
  `bt_van` tinyint(1) NOT NULL DEFAULT '0',
  `bt_other` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `generation_ID_uindex` (`ID`),
  KEY `model_fk` (`ID_model`),
  CONSTRAINT `model_fk` FOREIGN KEY (`ID_model`) REFERENCES `model` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generation`
--

LOCK TABLES `generation` WRITE;
/*!40000 ALTER TABLE `generation` DISABLE KEYS */;
INSERT INTO `generation` VALUES (1,1,'E30',1982,1994,0,1,1,1,1,0,0,0),(2,1,'E36',1990,2000,1,1,1,1,1,0,0,1),(3,1,'E46',1998,2007,1,1,1,1,1,0,0,1),(8,1,'E21',1975,1983,0,0,0,1,1,0,0,0),(9,1,'E90/1/2/3',2004,2013,0,1,1,1,1,0,0,0),(10,1,'F30/1/4',2012,2020,0,1,1,0,0,1,0,1),(11,1,'G20/1',2018,0,0,1,1,0,0,0,0,0),(12,2,'E12',1972,1981,0,1,0,0,0,0,0,0),(13,2,'E28',1981,1988,0,1,0,0,0,0,0,0),(14,2,'E34',1988,1997,0,1,1,0,0,0,0,0),(15,2,'E39',1995,2004,0,1,1,0,0,0,0,0),(16,2,'E60',2003,2010,0,1,1,0,0,0,0,0),(17,2,'F10/1',2010,2017,0,1,1,0,0,1,0,1),(18,2,'G30/1',2016,0,0,1,1,0,0,0,0,0),(19,3,'E23',1977,1986,0,1,0,0,0,0,0,0),(20,3,'E32',1986,1994,0,1,0,0,0,0,0,0),(21,3,'E38',1994,2001,0,1,0,0,0,0,0,0),(22,3,'E65',2001,2008,0,1,0,0,0,0,0,0),(23,3,'F01',2008,2015,0,1,0,0,0,0,0,0),(24,3,'G11/2',2015,0,0,1,0,0,0,0,0,0),(25,4,'B5',1995,2001,0,1,1,0,0,0,0,0),(26,4,'B6',2000,2006,0,1,1,0,1,0,0,0),(27,4,'B7',2004,2009,0,1,1,0,1,0,0,0),(28,4,'B8',2007,2015,0,1,1,0,0,0,0,1),(29,4,'B9',2015,0,0,1,1,0,0,0,0,1),(30,5,'C4',1994,1997,0,1,1,0,0,0,0,0),(31,5,'C5',1997,2005,0,1,1,0,0,0,0,0),(32,5,'C6',2004,2011,0,1,1,0,0,0,0,1),(33,5,'C7',2011,2017,0,1,1,0,0,0,0,1),(34,5,'C8',2018,0,0,1,1,0,0,0,0,1),(35,6,'D2',1994,2002,0,1,0,0,0,0,0,0),(36,6,'D3',2002,2010,0,1,0,0,0,0,0,0),(37,6,'D4',2010,2017,0,1,0,0,0,0,0,0),(38,6,'D5',2017,0,0,1,0,0,0,0,0,0),(39,7,'W202',1993,2000,0,1,1,0,0,0,0,0),(40,7,'W203',2000,2008,0,1,1,1,0,0,0,0),(41,7,'W204',2006,2014,0,1,1,1,0,0,0,0),(42,7,'W205',2013,0,0,1,1,1,1,0,0,0),(43,7,'W206',2021,0,0,1,1,0,0,0,0,0),(44,8,'W124',1993,1996,0,1,1,1,1,0,0,0),(45,8,'W210',1995,2002,0,1,1,0,0,0,0,0),(46,8,'W211',2002,2009,0,1,1,0,0,0,0,0),(47,8,'W212',2009,2016,0,1,1,1,1,0,0,0),(48,8,'W213',2016,0,0,1,1,1,1,0,0,1),(49,9,'W116',1972,1980,0,1,0,0,0,0,0,0),(50,9,'W126',1979,1991,0,1,0,1,0,0,0,0),(51,9,'W140',1991,1998,0,1,0,1,0,0,0,0),(52,9,'W220',1998,2005,0,1,0,0,0,0,0,0),(53,9,'W221',2005,2013,0,1,0,0,0,0,0,0),(54,9,'W222',2013,2020,0,1,0,1,1,0,0,0),(55,9,'W223/V223',2020,0,0,1,0,0,0,0,0,0);
/*!40000 ALTER TABLE `generation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturer` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `manufacturer_ID_uindex` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'BMW'),(2,'Audi'),(3,'Mercedes-Benz');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `ID_manufacturer` bigint NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `model_ID_uindex` (`ID`),
  KEY `manufacturer_fk` (`ID_manufacturer`),
  CONSTRAINT `manufacturer_fk` FOREIGN KEY (`ID_manufacturer`) REFERENCES `manufacturer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,1,'3 series'),(2,1,'5 series'),(3,1,'7 series'),(4,2,'A4'),(5,2,'A6'),(6,2,'A8'),(7,3,'C class'),(8,3,'E class'),(9,3,'S class');
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-13 19:01:26
