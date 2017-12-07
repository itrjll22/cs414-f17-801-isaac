CREATE DATABASE  IF NOT EXISTS `gym_manager_hibernate` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gym_manager_hibernate`;
-- MySQL dump 10.13  Distrib 5.5.57, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: gym_manager_hibernate
-- ------------------------------------------------------
-- Server version	5.5.57-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Address` (
  `id` varchar(255) NOT NULL,
  `addressLine1` varchar(255) DEFAULT NULL,
  `addressLine2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES ('677a7500-d7d6-43f1-8ec9-b06955c660cc','283 Costa Rica Dr NE','','Albuquerque','NM','87123'),('6a169f86-1a55-4962-9e5a-4b12d15553d0','439 Some Place NW','','Denver','Colorado','80912'),('751cf914-793c-4de8-b617-2b05f5f7fc25','6437 5th St.','Apt. 432','Santa Fe','NM','87125'),('d615a615-3721-4be9-9868-c91feca7dc75','123 Some Place','','Albuquerque','NM','87125');
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `id` varchar(255) NOT NULL,
  `isActive` bit(1) NOT NULL,
  `userAccount_username` varchar(255) DEFAULT NULL,
  `userInformation_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr1flvrivd1y91cm0bqarsc5up` (`userAccount_username`),
  KEY `FKk31xrl2pdlwvfvpqd74d75eti` (`userInformation_id`),
  CONSTRAINT `FKk31xrl2pdlwvfvpqd74d75eti` FOREIGN KEY (`userInformation_id`) REFERENCES `UserInformation` (`id`),
  CONSTRAINT `FKr1flvrivd1y91cm0bqarsc5up` FOREIGN KEY (`userAccount_username`) REFERENCES `UserAccount` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES ('jane-123','','jane','d4b58776-f2de-41f9-aa04-4123a8cd30db'),('john-001','','john','5edad9d1-4242-442e-b69c-c74ec6f16725');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer_WorkoutRoutine`
--

DROP TABLE IF EXISTS `Customer_WorkoutRoutine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer_WorkoutRoutine` (
  `Customer_id` varchar(255) NOT NULL,
  `workoutRoutines_id` varchar(255) NOT NULL,
  PRIMARY KEY (`Customer_id`,`workoutRoutines_id`),
  KEY `FK4x5s3pc80ws5wbt8yb67bgarj` (`workoutRoutines_id`),
  CONSTRAINT `FKoyduhcmgjd9n5tq0jmgxo4ywi` FOREIGN KEY (`Customer_id`) REFERENCES `Customer` (`id`),
  CONSTRAINT `FK4x5s3pc80ws5wbt8yb67bgarj` FOREIGN KEY (`workoutRoutines_id`) REFERENCES `WorkoutRoutine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer_WorkoutRoutine`
--

LOCK TABLES `Customer_WorkoutRoutine` WRITE;
/*!40000 ALTER TABLE `Customer_WorkoutRoutine` DISABLE KEYS */;
/*!40000 ALTER TABLE `Customer_WorkoutRoutine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Email`
--

DROP TABLE IF EXISTS `Email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Email` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h74y7pqueo2gx4bfj4q40hupa` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Email`
--

LOCK TABLES `Email` WRITE;
/*!40000 ALTER TABLE `Email` DISABLE KEYS */;
INSERT INTO `Email` VALUES ('1d6c49c7-1ac1-44b3-9dcc-5eaa347c20e3','itrjll22@colostate.edu','student'),('53afeb33-6819-40df-be9c-268f98c659b2','johndoe@test.com',''),('b52d1b52-bc08-45dc-8ce1-369823661ebb','janedoe@test.com',''),('b550d61b-e964-4490-ac23-10e44e7406cf','itrjll22@outlook.com','personal');
/*!40000 ALTER TABLE `Email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EquipmentItem`
--

DROP TABLE IF EXISTS `EquipmentItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EquipmentItem` (
  `id` varchar(255) NOT NULL,
  `image` longblob,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EquipmentItem`
--

LOCK TABLES `EquipmentItem` WRITE;
/*!40000 ALTER TABLE `EquipmentItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `EquipmentItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exercise`
--

DROP TABLE IF EXISTS `Exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Exercise` (
  `id` varchar(255) NOT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exercise`
--

LOCK TABLES `Exercise` WRITE;
/*!40000 ALTER TABLE `Exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `Exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ExerciseSet`
--

DROP TABLE IF EXISTS `ExerciseSet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ExerciseSet` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `repititions` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ExerciseSet`
--

LOCK TABLES `ExerciseSet` WRITE;
/*!40000 ALTER TABLE `ExerciseSet` DISABLE KEYS */;
/*!40000 ALTER TABLE `ExerciseSet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exercise_EquipmentItem`
--

DROP TABLE IF EXISTS `Exercise_EquipmentItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Exercise_EquipmentItem` (
  `Exercise_id` varchar(255) NOT NULL,
  `equipmentItems_id` varchar(255) NOT NULL,
  PRIMARY KEY (`Exercise_id`,`equipmentItems_id`),
  KEY `FK227n6atlxdxapifkhb6muqgiw` (`equipmentItems_id`),
  CONSTRAINT `FKkspo6edu5isig9lmxd6etv2da` FOREIGN KEY (`Exercise_id`) REFERENCES `Exercise` (`id`),
  CONSTRAINT `FK227n6atlxdxapifkhb6muqgiw` FOREIGN KEY (`equipmentItems_id`) REFERENCES `EquipmentItem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exercise_EquipmentItem`
--

LOCK TABLES `Exercise_EquipmentItem` WRITE;
/*!40000 ALTER TABLE `Exercise_EquipmentItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `Exercise_EquipmentItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exercise_ExerciseSet`
--

DROP TABLE IF EXISTS `Exercise_ExerciseSet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Exercise_ExerciseSet` (
  `Exercise_id` varchar(255) NOT NULL,
  `exerciseSets_id` varchar(255) NOT NULL,
  PRIMARY KEY (`Exercise_id`,`exerciseSets_id`),
  KEY `FKsjqjgqabiesvu4p0k4scl9vl1` (`exerciseSets_id`),
  CONSTRAINT `FKd0a1k4wn3cp3k23407xg1vhms` FOREIGN KEY (`Exercise_id`) REFERENCES `Exercise` (`id`),
  CONSTRAINT `FKsjqjgqabiesvu4p0k4scl9vl1` FOREIGN KEY (`exerciseSets_id`) REFERENCES `ExerciseSet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exercise_ExerciseSet`
--

LOCK TABLES `Exercise_ExerciseSet` WRITE;
/*!40000 ALTER TABLE `Exercise_ExerciseSet` DISABLE KEYS */;
/*!40000 ALTER TABLE `Exercise_ExerciseSet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FitnessClass`
--

DROP TABLE IF EXISTS `FitnessClass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FitnessClass` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `schedule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FitnessClass`
--

LOCK TABLES `FitnessClass` WRITE;
/*!40000 ALTER TABLE `FitnessClass` DISABLE KEYS */;
/*!40000 ALTER TABLE `FitnessClass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FitnessClass_Customer`
--

DROP TABLE IF EXISTS `FitnessClass_Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FitnessClass_Customer` (
  `FitnessClass_id` varchar(255) NOT NULL,
  `customers_id` varchar(255) NOT NULL,
  PRIMARY KEY (`FitnessClass_id`,`customers_id`),
  KEY `FKr1376w5ec502r9g8yaqm4vrb9` (`customers_id`),
  CONSTRAINT `FKa4glf1adc6focq1v4xth5vql2` FOREIGN KEY (`FitnessClass_id`) REFERENCES `FitnessClass` (`id`),
  CONSTRAINT `FKr1376w5ec502r9g8yaqm4vrb9` FOREIGN KEY (`customers_id`) REFERENCES `Customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FitnessClass_Customer`
--

LOCK TABLES `FitnessClass_Customer` WRITE;
/*!40000 ALTER TABLE `FitnessClass_Customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `FitnessClass_Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HealthInsuranceProvider`
--

DROP TABLE IF EXISTS `HealthInsuranceProvider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HealthInsuranceProvider` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mp16mfiw8pne26l894lgvr1e5` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HealthInsuranceProvider`
--

LOCK TABLES `HealthInsuranceProvider` WRITE;
/*!40000 ALTER TABLE `HealthInsuranceProvider` DISABLE KEYS */;
INSERT INTO `HealthInsuranceProvider` VALUES ('8b32ad9f-4492-4dba-82c6-a36dad3da35e','Green Cross Green Shield'),('a06420f0-e7fa-4094-8643-00878590dfae','United HealthCare');
/*!40000 ALTER TABLE `HealthInsuranceProvider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Manager`
--

DROP TABLE IF EXISTS `Manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Manager` (
  `id` varchar(255) NOT NULL,
  `userAccount_username` varchar(255) DEFAULT NULL,
  `userInformation_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4jhotkqrjk73b3frtyya997kn` (`userAccount_username`),
  KEY `FK6tv0e7knfqwmmc8jmb2ugw7f6` (`userInformation_id`),
  CONSTRAINT `FK6tv0e7knfqwmmc8jmb2ugw7f6` FOREIGN KEY (`userInformation_id`) REFERENCES `UserInformation` (`id`),
  CONSTRAINT `FK4jhotkqrjk73b3frtyya997kn` FOREIGN KEY (`userAccount_username`) REFERENCES `UserAccount` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manager`
--

LOCK TABLES `Manager` WRITE;
/*!40000 ALTER TABLE `Manager` DISABLE KEYS */;
INSERT INTO `Manager` VALUES ('684154a6-b704-4ea1-afd6-aa9cc67cbc2b','itrjllManager','87e075f5-503e-4966-b496-b5ddb8faefb5');
/*!40000 ALTER TABLE `Manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Phone`
--

DROP TABLE IF EXISTS `Phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Phone` (
  `id` varchar(255) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Phone`
--

LOCK TABLES `Phone` WRITE;
/*!40000 ALTER TABLE `Phone` DISABLE KEYS */;
INSERT INTO `Phone` VALUES ('1e7c5f4c-cf2b-43ed-b2a9-9bb72715382a','555-555-5555',''),('4cb78cca-10b2-4706-873f-dff46ba2f4d7','555-555-5555','mobile'),('c154384e-0a10-47ba-860e-27c3b2612c8a','5555555555',''),('f001ab7c-d298-45a6-bfe9-221d5d0bff78','555-555-5555','mobile');
/*!40000 ALTER TABLE `Phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trainer`
--

DROP TABLE IF EXISTS `Trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Trainer` (
  `id` varchar(255) NOT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `workHours` varchar(255) DEFAULT NULL,
  `userAccount_username` varchar(255) DEFAULT NULL,
  `userInformation_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKierj0nu9i1qt16ky4byv5foaj` (`userAccount_username`),
  KEY `FK242hj6xs99c9n60dm576g58h9` (`userInformation_id`),
  CONSTRAINT `FK242hj6xs99c9n60dm576g58h9` FOREIGN KEY (`userInformation_id`) REFERENCES `UserInformation` (`id`),
  CONSTRAINT `FKierj0nu9i1qt16ky4byv5foaj` FOREIGN KEY (`userAccount_username`) REFERENCES `UserAccount` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trainer`
--

LOCK TABLES `Trainer` WRITE;
/*!40000 ALTER TABLE `Trainer` DISABLE KEYS */;
INSERT INTO `Trainer` VALUES ('32d65641-d33b-4487-bdf3-9068f5378371',NULL,NULL,'itrjllTrainer','e436fae0-f25f-4e6d-b0e2-125e7836d869');
/*!40000 ALTER TABLE `Trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserAccount`
--

DROP TABLE IF EXISTS `UserAccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserAccount` (
  `username` varchar(255) NOT NULL,
  `id` varchar(255) DEFAULT NULL,
  `passwordHash` tinyblob,
  `salt` tinyblob,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserAccount`
--

LOCK TABLES `UserAccount` WRITE;
/*!40000 ALTER TABLE `UserAccount` DISABLE KEYS */;
INSERT INTO `UserAccount` VALUES ('itrjllManager','d324794e-cc97-48ca-9b3e-d4bb06beec22','ÚºD3¶UÊI\\€ºöDûã˜eª9rx:4ÑlÇz9','[∫·Õú\"àﬂÀa)h!A—ø·Î'),('itrjllTrainer','a9433520-6c20-4ffc-be05-fe8e127b221a','C\"óù°R6*\r∫‘±u®©‘or«ès5(πd7mk','ÅDÑØ2ªló∆á≠e◊ÿ˚'),('jane','e9ece08c-65f6-4597-94c2-85e2e038fd23','ü®(›0\nƒåf,`pı_}ÛêòF4Hˆ‘ê<õ»',' ybu¨çÆë∏1µL3™Äé˙Ù'),('john','f95e35ca-8f62-47cc-9662-d6027dfb3a15','ê…-‡Œ‰€Á˙±ªﬂ=,\0}Gïåıù)t6ß™Oj¥(','åEe G\nÜ`Ho÷]÷∑|’aÖÙ');
/*!40000 ALTER TABLE `UserAccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserInformation`
--

DROP TABLE IF EXISTS `UserInformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserInformation` (
  `id` varchar(255) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `address_id` varchar(255) DEFAULT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `healthInsuranceProvider_id` varchar(255) DEFAULT NULL,
  `manager_id` varchar(255) DEFAULT NULL,
  `phone_id` varchar(255) DEFAULT NULL,
  `trainer_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk2963hnnut6vovm07asu1vdgr` (`address_id`),
  KEY `FKrmc9sd59vo6q7511pqg49q50o` (`customer_id`),
  KEY `FKa9gc5pg8imfw8hei5qn6pqyai` (`email_id`),
  KEY `FKryjejmtrcjfc3o3dox1fr0eat` (`healthInsuranceProvider_id`),
  KEY `FKdvju86v1h48ayffl5h5g0udwj` (`manager_id`),
  KEY `FKouxejeqw5mnrcgmftsfo59g75` (`phone_id`),
  KEY `FKfp09rti7bqnuo0oieagg8e6eu` (`trainer_id`),
  CONSTRAINT `FKfp09rti7bqnuo0oieagg8e6eu` FOREIGN KEY (`trainer_id`) REFERENCES `Trainer` (`id`),
  CONSTRAINT `FKa9gc5pg8imfw8hei5qn6pqyai` FOREIGN KEY (`email_id`) REFERENCES `Email` (`id`),
  CONSTRAINT `FKdvju86v1h48ayffl5h5g0udwj` FOREIGN KEY (`manager_id`) REFERENCES `Manager` (`id`),
  CONSTRAINT `FKk2963hnnut6vovm07asu1vdgr` FOREIGN KEY (`address_id`) REFERENCES `Address` (`id`),
  CONSTRAINT `FKouxejeqw5mnrcgmftsfo59g75` FOREIGN KEY (`phone_id`) REFERENCES `Phone` (`id`),
  CONSTRAINT `FKrmc9sd59vo6q7511pqg49q50o` FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`id`),
  CONSTRAINT `FKryjejmtrcjfc3o3dox1fr0eat` FOREIGN KEY (`healthInsuranceProvider_id`) REFERENCES `HealthInsuranceProvider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserInformation`
--

LOCK TABLES `UserInformation` WRITE;
/*!40000 ALTER TABLE `UserInformation` DISABLE KEYS */;
INSERT INTO `UserInformation` VALUES ('5edad9d1-4242-442e-b69c-c74ec6f16725','John','Doe','6a169f86-1a55-4962-9e5a-4b12d15553d0',NULL,'53afeb33-6819-40df-be9c-268f98c659b2','8b32ad9f-4492-4dba-82c6-a36dad3da35e',NULL,'c154384e-0a10-47ba-860e-27c3b2612c8a',NULL),('87e075f5-503e-4966-b496-b5ddb8faefb5','Isaac','Trujillo','751cf914-793c-4de8-b617-2b05f5f7fc25',NULL,'1d6c49c7-1ac1-44b3-9dcc-5eaa347c20e3','a06420f0-e7fa-4094-8643-00878590dfae',NULL,'4cb78cca-10b2-4706-873f-dff46ba2f4d7',NULL),('d4b58776-f2de-41f9-aa04-4123a8cd30db','Jane','Doe','677a7500-d7d6-43f1-8ec9-b06955c660cc',NULL,'b52d1b52-bc08-45dc-8ce1-369823661ebb','a06420f0-e7fa-4094-8643-00878590dfae',NULL,'1e7c5f4c-cf2b-43ed-b2a9-9bb72715382a',NULL),('e436fae0-f25f-4e6d-b0e2-125e7836d869','Isaac','Trujillo','d615a615-3721-4be9-9868-c91feca7dc75',NULL,'b550d61b-e964-4490-ac23-10e44e7406cf','8b32ad9f-4492-4dba-82c6-a36dad3da35e',NULL,'f001ab7c-d298-45a6-bfe9-221d5d0bff78',NULL);
/*!40000 ALTER TABLE `UserInformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WorkoutRoutine`
--

DROP TABLE IF EXISTS `WorkoutRoutine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WorkoutRoutine` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WorkoutRoutine`
--

LOCK TABLES `WorkoutRoutine` WRITE;
/*!40000 ALTER TABLE `WorkoutRoutine` DISABLE KEYS */;
/*!40000 ALTER TABLE `WorkoutRoutine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WorkoutRoutine_Exercise`
--

DROP TABLE IF EXISTS `WorkoutRoutine_Exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WorkoutRoutine_Exercise` (
  `WorkoutRoutine_id` varchar(255) NOT NULL,
  `exercises_id` varchar(255) NOT NULL,
  PRIMARY KEY (`WorkoutRoutine_id`,`exercises_id`),
  KEY `FKfjbkybhkpnsqpi1tyeyv0jxrt` (`exercises_id`),
  CONSTRAINT `FK1i11supu6radmsj0tsn5u1rbl` FOREIGN KEY (`WorkoutRoutine_id`) REFERENCES `WorkoutRoutine` (`id`),
  CONSTRAINT `FKfjbkybhkpnsqpi1tyeyv0jxrt` FOREIGN KEY (`exercises_id`) REFERENCES `Exercise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WorkoutRoutine_Exercise`
--

LOCK TABLES `WorkoutRoutine_Exercise` WRITE;
/*!40000 ALTER TABLE `WorkoutRoutine_Exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `WorkoutRoutine_Exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fitnessClass_Trainer`
--

DROP TABLE IF EXISTS `fitnessClass_Trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fitnessClass_Trainer` (
  `fitnessClass_id` varchar(255) NOT NULL,
  `trainer_id` varchar(255) NOT NULL,
  PRIMARY KEY (`fitnessClass_id`,`trainer_id`),
  KEY `FK64rkk4350o7keg635ygsmq7hr` (`trainer_id`),
  CONSTRAINT `FKowyeq9j2ypnlhaxqbtnpxtmu6` FOREIGN KEY (`fitnessClass_id`) REFERENCES `FitnessClass` (`id`),
  CONSTRAINT `FK64rkk4350o7keg635ygsmq7hr` FOREIGN KEY (`trainer_id`) REFERENCES `Trainer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fitnessClass_Trainer`
--

LOCK TABLES `fitnessClass_Trainer` WRITE;
/*!40000 ALTER TABLE `fitnessClass_Trainer` DISABLE KEYS */;
/*!40000 ALTER TABLE `fitnessClass_Trainer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-06 19:45:13
