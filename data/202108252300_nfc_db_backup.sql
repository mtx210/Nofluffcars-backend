CREATE DATABASE  IF NOT EXISTS `nofluffcars_data` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nofluffcars_data`;
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

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'USA'),(2,'Great Britain'),(3,'Spain'),(4,'France'),(5,'Germany'),(6,'Italy'),(7,'Norway'),(8,'Sweden'),(9,'Czech Republic'),(10,'Japan'),(999,'unknown');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generations`
--

DROP TABLE IF EXISTS `generations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generations` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `IDmodel` bigint NOT NULL,
  `name` varchar(20) NOT NULL,
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
  KEY `model_fk` (`IDmodel`),
  CONSTRAINT `model_fk` FOREIGN KEY (`IDmodel`) REFERENCES `models` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generations`
--

LOCK TABLES `generations` WRITE;
/*!40000 ALTER TABLE `generations` DISABLE KEYS */;
INSERT INTO `generations` VALUES (1,1,'E30',1982,1994,0,1,1,1,1,0,0,0),(2,1,'E36',1990,2000,1,1,1,1,1,0,0,1),(3,1,'E46',1998,2007,1,1,1,1,1,0,0,1),(8,1,'E21',1975,1983,0,0,0,1,1,0,0,0),(9,1,'E90/1/2/3',2004,2013,0,1,1,1,1,0,0,0),(10,1,'F30/1/4',2012,2020,0,1,1,0,0,1,0,1),(11,1,'G20/1',2018,0,0,1,1,0,0,0,0,0),(12,2,'E12',1972,1981,0,1,0,0,0,0,0,0),(13,2,'E28',1981,1988,0,1,0,0,0,0,0,0),(14,2,'E34',1988,1997,0,1,1,0,0,0,0,0),(15,2,'E39',1995,2004,0,1,1,0,0,0,0,0),(16,2,'E60',2003,2010,0,1,1,0,0,0,0,0),(17,2,'F10/1',2010,2017,0,1,1,0,0,1,0,1),(18,2,'G30/1',2016,0,0,1,1,0,0,0,0,0),(19,3,'E23',1977,1986,0,1,0,0,0,0,0,0),(20,3,'E32',1986,1994,0,1,0,0,0,0,0,0),(21,3,'E38',1994,2001,0,1,0,0,0,0,0,0),(22,3,'E65',2001,2008,0,1,0,0,0,0,0,0),(23,3,'F01',2008,2015,0,1,0,0,0,0,0,0),(24,3,'G11/2',2015,0,0,1,0,0,0,0,0,0),(25,4,'B5',1995,2001,0,1,1,0,0,0,0,0),(26,4,'B6',2000,2006,0,1,1,0,1,0,0,0),(27,4,'B7',2004,2009,0,1,1,0,1,0,0,0),(28,4,'B8',2007,2015,0,1,1,0,0,0,0,1),(29,4,'B9',2015,0,0,1,1,0,0,0,0,1),(30,5,'C4',1994,1997,0,1,1,0,0,0,0,0),(31,5,'C5',1997,2005,0,1,1,0,0,0,0,0),(32,5,'C6',2004,2011,0,1,1,0,0,0,0,1),(33,5,'C7',2011,2017,0,1,1,0,0,0,0,1),(34,5,'C8',2018,0,0,1,1,0,0,0,0,1),(35,6,'D2',1994,2002,0,1,0,0,0,0,0,0),(36,6,'D3',2002,2010,0,1,0,0,0,0,0,0),(37,6,'D4',2010,2017,0,1,0,0,0,0,0,0),(38,6,'D5',2017,0,0,1,0,0,0,0,0,0),(39,7,'W202',1993,2000,0,1,1,0,0,0,0,0),(40,7,'W203',2000,2008,0,1,1,1,0,0,0,0),(41,7,'W204',2006,2014,0,1,1,1,0,0,0,0),(42,7,'W205',2013,0,0,1,1,1,1,0,0,0),(43,7,'W206',2021,0,0,1,1,0,0,0,0,0),(44,8,'W124',1993,1996,0,1,1,1,1,0,0,0),(45,8,'W210',1995,2002,0,1,1,0,0,0,0,0),(46,8,'W211',2002,2009,0,1,1,0,0,0,0,0),(47,8,'W212',2009,2016,0,1,1,1,1,0,0,0),(48,8,'W213',2016,0,0,1,1,1,1,0,0,1),(49,9,'W116',1972,1980,0,1,0,0,0,0,0,0),(50,9,'W126',1979,1991,0,1,0,1,0,0,0,0),(51,9,'W140',1991,1998,0,1,0,1,0,0,0,0),(52,9,'W220',1998,2005,0,1,0,0,0,0,0,0),(53,9,'W221',2005,2013,0,1,0,0,0,0,0,0),(54,9,'W222',2013,2020,0,1,0,1,1,0,0,0),(55,9,'W223/V223',2020,0,0,1,0,0,0,0,0,0);
/*!40000 ALTER TABLE `generations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturers`
--

DROP TABLE IF EXISTS `manufacturers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturers` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `IDcountry` bigint NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `manufacturer_country_ID_fk` (`IDcountry`),
  CONSTRAINT `manufacturer_country_ID_fk` FOREIGN KEY (`IDcountry`) REFERENCES `countries` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturers`
--

LOCK TABLES `manufacturers` WRITE;
/*!40000 ALTER TABLE `manufacturers` DISABLE KEYS */;
INSERT INTO `manufacturers` VALUES (7,10,'Acura'),(8,999,'Aixam'),(9,6,'Alfa Romeo'),(10,999,'Alpine'),(11,5,'Audi'),(12,999,'Bentley'),(13,5,'BMW'),(14,4,'Bugatti'),(15,1,'Buick'),(16,1,'Cadillac'),(17,1,'Chevrolet'),(18,1,'Chrysler'),(19,4,'Citroen'),(20,999,'Cupra'),(21,999,'Dacia'),(22,999,'Daewoo'),(23,999,'Daihatsu'),(24,999,'DeLorean'),(25,1,'Dodge'),(26,999,'DS'),(27,6,'Ferrari'),(28,6,'Fiat'),(29,1,'Ford'),(30,999,'FSO'),(31,10,'Honda'),(32,1,'Hummer'),(33,999,'Hyundai'),(34,10,'Infiniti'),(35,999,'Isuzu'),(36,999,'Iveco'),(37,2,'Jaguar'),(38,999,'Jeep'),(39,999,'Kia'),(40,6,'Lamborghini'),(41,999,'Lancia'),(42,999,'Land Rover'),(43,10,'Lexus'),(44,1,'Lincoln'),(45,999,'Lotus'),(46,6,'Maserati'),(47,5,'Maybach'),(48,10,'Mazda'),(49,5,'Mercedes'),(50,999,'Mercury'),(51,999,'MG'),(52,999,'Mini'),(53,10,'Mitsubishi'),(54,10,'Nissan'),(55,5,'Opel'),(56,4,'Peugeot'),(57,1,'Plymouth'),(58,1,'Pontiac'),(59,5,'Porsche'),(60,4,'Renault'),(61,999,'Rolls-Royce'),(62,999,'Rover'),(63,999,'Saab'),(64,10,'Scion'),(65,3,'Seat'),(66,9,'Skoda'),(67,999,'Smart'),(68,999,'Ssangyong'),(69,10,'Subaru'),(70,10,'Suzuki'),(71,1,'Tesla'),(72,10,'Toyota'),(73,5,'Volkswagen'),(74,8,'Volvo');
/*!40000 ALTER TABLE `manufacturers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `IDmanufacturer` bigint NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `model_ID_uindex` (`ID`),
  KEY `manufacturer_fk` (`IDmanufacturer`),
  CONSTRAINT `manufacturer_fk` FOREIGN KEY (`IDmanufacturer`) REFERENCES `manufacturers` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` VALUES (1,13,'3 series'),(2,13,'5 series'),(3,13,'7 series'),(4,11,'A4'),(5,11,'A6'),(6,11,'A8'),(7,49,'C class'),(8,49,'E class'),(9,49,'S class');
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-25 23:50:20
