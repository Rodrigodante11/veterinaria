CREATE DATABASE  IF NOT EXISTS `veterinaria` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `veterinaria`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: veterinaria
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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `idanimal` int NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `raca` varchar(45) NOT NULL,
  `cliente_cpf` int NOT NULL,
  PRIMARY KEY (`idanimal`),
  KEY `fk_animal_cliente1_idx` (`cliente_cpf`),
  CONSTRAINT `fk_animal_cliente1` FOREIGN KEY (`cliente_cpf`) REFERENCES `cliente` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (333,'Cachorro','Conan','Birmanes',333333333),(444,'Gato','Alladin','Persa',555555555),(555,'Gato','Dexter','Siames',666666666),(666,'Cachorro','Soneca','Pastor Alemao',111111111),(777,'Cachorro','Doguinho','Vira Lata',222222222),(888,'Gato','Miua','Persa',444444444),(999,'Cachorro','Mel','Husky',444444444);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cpf` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `funcionario_crmv` int NOT NULL,
  PRIMARY KEY (`cpf`),
  KEY `fk_cliente_funcionario1_idx` (`funcionario_crmv`),
  CONSTRAINT `fk_cliente_funcionario1` FOREIGN KEY (`funcionario_crmv`) REFERENCES `funcionario` (`crmv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (111111111,'Rodrigo','35984495512','Santa Rira',1111),(222222222,'Ricardo','35986541254','Pouso Alegre',1111),(333333333,'Mayra','35647845215','Santa Rita',1113),(444444444,'Arthur','35647854562','Ouros',1115),(555555555,'Amanda','35687458954','Santa Rita',1114),(666666666,'Vanessa','35647859624','Cambui',1116);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `crmv` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `salario` varchar(45) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  PRIMARY KEY (`crmv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1111,'Dessana','veterinaria Chefe','8000.00',20),(1112,'Pedro','veterinario junior','2000.00',18),(1113,'Julia','veterinario Plena','4000.00',25),(1114,'Milena','veterinaria Plena','3000.00',30),(1115,'Samanta','Veterianaria junior','2500.00',28),(1116,'Thiago','Veterianaria Junior','2600',30);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicacao`
--

DROP TABLE IF EXISTS `medicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicacao` (
  `idmedicacao` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `qtd` int NOT NULL,
  `valor` decimal(2,0) DEFAULT NULL,
  `funcionario_crmv` int NOT NULL,
  `animal_idanimal` int NOT NULL,
  PRIMARY KEY (`idmedicacao`),
  KEY `fk_medicacao_funcionario_idx` (`funcionario_crmv`),
  KEY `fk_medicacao_animal1_idx` (`animal_idanimal`),
  CONSTRAINT `fk_medicacao_animal1` FOREIGN KEY (`animal_idanimal`) REFERENCES `animal` (`idanimal`),
  CONSTRAINT `fk_medicacao_funcionario` FOREIGN KEY (`funcionario_crmv`) REFERENCES `funcionario` (`crmv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicacao`
--

LOCK TABLES `medicacao` WRITE;
/*!40000 ALTER TABLE `medicacao` DISABLE KEYS */;
INSERT INTO `medicacao` VALUES (11,'Antipulga',2,33,1111,666),(12,'Antipulga e antirabica',1,16,1113,333),(13,'Floral Animal',3,53,1114,777),(14,'Vermifugo',2,80,1111,999),(15,'Simparic',3,93,1116,555),(16,'Suplemento Vetril Pelo',1,50,1115,888);
/*!40000 ALTER TABLE `medicacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-11 14:45:28
