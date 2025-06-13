-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: clinic_db
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `end_date_time` datetime(6) NOT NULL,
  `notes` varchar(1000) DEFAULT NULL,
  `reason` varchar(500) NOT NULL,
  `start_date_time` datetime(6) NOT NULL,
  `status` enum('CANCELLED','COMPLETED','CONFIRMED','PENDING') DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `doctor_id` bigint NOT NULL,
  `patient_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmujeo4tymoo98cmf7uj3vsv76` (`doctor_id`),
  KEY `FK8exap5wmg8kmb1g1rx3by21yt` (`patient_id`),
  CONSTRAINT `FK8exap5wmg8kmb1g1rx3by21yt` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKmujeo4tymoo98cmf7uj3vsv76` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,'2025-07-22 03:00:00.000000','2025-07-29 03:30:00.000000','Kind management full condition stuff discussion draw officer.','Follow-up','2025-07-29 03:00:00.000000','CANCELLED',NULL,2,13),(2,'2025-07-15 20:00:00.000000','2025-07-21 20:30:00.000000','Sea relationship eight manager social sort.','Annual checkup','2025-07-21 20:00:00.000000','PENDING',NULL,1,10),(3,'2025-06-26 19:00:00.000000','2025-07-06 19:30:00.000000','Social think such much everybody.','Test results discussion','2025-07-06 19:00:00.000000','CONFIRMED',NULL,7,9),(4,'2025-07-21 03:00:00.000000','2025-07-26 03:30:00.000000','As important baby TV movie.','New symptoms','2025-07-26 03:00:00.000000','CONFIRMED',NULL,4,17),(5,'2025-07-25 01:00:00.000000','2025-08-02 01:30:00.000000','Play door scientist perhaps.','Follow-up','2025-08-02 01:00:00.000000','CONFIRMED',NULL,10,14),(6,'2025-07-12 23:00:00.000000','2025-07-19 23:30:00.000000','Report responsibility rise run relate Congress.','Annual checkup','2025-07-19 23:00:00.000000','CANCELLED',NULL,4,10),(7,'2025-06-27 22:00:00.000000','2025-07-05 22:30:00.000000','Down pattern care yourself baby win church.','Test results discussion','2025-07-05 22:00:00.000000','PENDING',NULL,1,8),(8,'2025-07-04 23:00:00.000000','2025-07-11 23:30:00.000000','Reach phone degree he beyond.','Annual checkup','2025-07-11 23:00:00.000000','CANCELLED',NULL,2,5),(9,'2025-06-16 21:00:00.000000','2025-06-23 21:30:00.000000','Place whose fish shake detail whatever while.','Test results discussion','2025-06-23 21:00:00.000000','CANCELLED',NULL,4,6),(10,'2025-07-09 20:00:00.000000','2025-07-11 20:30:00.000000','Training time success best sister.','Test results discussion','2025-07-11 20:00:00.000000','CONFIRMED',NULL,5,10),(11,'2025-07-18 18:00:00.000000','2025-07-21 18:30:00.000000','Follow American if could.','New symptoms','2025-07-21 18:00:00.000000','CANCELLED',NULL,1,18),(12,'2025-06-27 19:00:00.000000','2025-07-04 19:30:00.000000','Perhaps court he.','New symptoms','2025-07-04 19:00:00.000000','CANCELLED',NULL,2,19),(13,'2025-06-05 23:00:00.000000','2025-06-10 23:30:00.000000','Artist whether whole environment computer.','Follow-up','2025-06-10 23:00:00.000000','PENDING',NULL,10,1),(14,'2025-07-22 01:00:00.000000','2025-07-25 01:30:00.000000','Military fast wife even listen employee.','Follow-up','2025-07-25 01:00:00.000000','CANCELLED',NULL,2,9),(15,'2025-07-03 23:00:00.000000','2025-07-07 23:30:00.000000','Discover one agency sing continue analysis.','Test results discussion','2025-07-07 23:00:00.000000','CANCELLED',NULL,1,5),(16,'2025-07-16 19:00:00.000000','2025-07-20 19:30:00.000000','Thought brother one without city.','New symptoms','2025-07-20 19:00:00.000000','CANCELLED',NULL,9,15),(17,'2025-07-24 19:00:00.000000','2025-07-25 19:30:00.000000','Mr particular toward.','Follow-up','2025-07-25 19:00:00.000000','PENDING',NULL,5,10),(18,'2025-08-04 19:00:00.000000','2025-08-05 19:30:00.000000','Difficult try play buy read score later.','New symptoms','2025-08-05 19:00:00.000000','CANCELLED',NULL,4,13),(19,'2025-06-27 23:00:00.000000','2025-07-06 23:30:00.000000','Situation environmental bring TV majority newspaper.','Annual checkup','2025-07-06 23:00:00.000000','CONFIRMED',NULL,8,15),(20,'2025-06-12 02:00:00.000000','2025-06-20 02:30:00.000000','Use baby pull always particular key four.','Prescription renewal','2025-06-20 02:00:00.000000','CANCELLED',NULL,1,10),(21,'2025-07-17 21:00:00.000000','2025-07-19 21:30:00.000000','Pattern total risk raise morning.','Follow-up','2025-07-19 21:00:00.000000','PENDING',NULL,3,16),(22,'2025-07-02 01:00:00.000000','2025-07-03 01:30:00.000000','Entire company drive far morning.','Annual checkup','2025-07-03 01:00:00.000000','CONFIRMED',NULL,9,11),(23,'2025-07-27 02:00:00.000000','2025-08-04 02:30:00.000000','Various white leg ask other.','Test results discussion','2025-08-04 02:00:00.000000','CANCELLED',NULL,3,17),(24,'2025-07-10 03:00:00.000000','2025-07-20 03:30:00.000000','Price ask road recognize enter.','Test results discussion','2025-07-20 03:00:00.000000','PENDING',NULL,7,4),(25,'2025-07-11 03:00:00.000000','2025-07-17 03:30:00.000000','Even wife put after theory according trouble.','Test results discussion','2025-07-17 03:00:00.000000','PENDING',NULL,1,14),(26,'2025-07-09 23:00:00.000000','2025-07-18 23:30:00.000000','Civil decade something successful difficult.','Prescription renewal','2025-07-18 23:00:00.000000','PENDING',NULL,3,18),(27,'2025-06-20 00:00:00.000000','2025-06-25 00:30:00.000000','You game bring last goal card unit.','Annual checkup','2025-06-25 00:00:00.000000','PENDING',NULL,5,18),(28,'2025-07-14 21:00:00.000000','2025-07-20 21:30:00.000000','Everybody cost card economy raise.','Test results discussion','2025-07-20 21:00:00.000000','PENDING',NULL,5,12),(29,'2025-07-25 00:00:00.000000','2025-08-01 00:30:00.000000','Property share agency maintain you.','Test results discussion','2025-08-01 00:00:00.000000','CANCELLED',NULL,1,2),(30,'2025-06-19 18:00:00.000000','2025-06-22 18:30:00.000000','Want represent rock concern quality myself box everything.','Prescription renewal','2025-06-22 18:00:00.000000','CANCELLED',NULL,1,3),(31,'2025-06-10 20:00:00.000000','2025-06-16 20:30:00.000000','Drug note here traditional exist program.','Test results discussion','2025-06-16 20:00:00.000000','CONFIRMED',NULL,3,17),(32,'2025-06-08 00:00:00.000000','2025-06-16 00:30:00.000000','Quality price exactly nor.','Annual checkup','2025-06-16 00:00:00.000000','CONFIRMED',NULL,4,8),(33,'2025-07-05 22:00:00.000000','2025-07-08 22:30:00.000000','Doctor garden remain interest upon religious price lead.','Test results discussion','2025-07-08 22:00:00.000000','PENDING',NULL,10,6),(34,'2025-06-21 19:00:00.000000','2025-06-23 19:30:00.000000','Challenge statement skin reveal growth sell.','Test results discussion','2025-06-23 19:00:00.000000','PENDING',NULL,1,1),(35,'2025-07-28 02:00:00.000000','2025-08-06 02:30:00.000000','Successful list home control.','Prescription renewal','2025-08-06 02:00:00.000000','CONFIRMED',NULL,7,7);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `office_room` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `specialty_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcaifv0va46t2mu85cg5afmayf` (`email`),
  KEY `FKb4ymcpidvwfn4kybv4adfvxcm` (`specialty_id`),
  CONSTRAINT `FKb4ymcpidvwfn4kybv4adfvxcm` FOREIGN KEY (`specialty_id`) REFERENCES `specialties` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'erica01@jones.org','Brandon','Evans','Room 101','+1-004-055-8945',4),(2,'aaron47@elliott-wilson.com','Robert','Lozano','Room 102','203.455.6399',2),(3,'sean70@reyes-johnson.org','Steven','Walsh','Room 103','(343)830-6606x79498',1),(4,'ericoneal@yahoo.com','Charles','Horne','Room 104','001-303-213-8363',4),(5,'anthonyhall@hotmail.com','Mark','Carroll','Room 105','(433)498-2378x60519',1),(6,'jose44@townsend-johnson.com','Wesley','Lee','Room 106','660.155.5032x70996',5),(7,'alicia01@riley.com','Annette','Williams','Room 107','001-475-136-7772x74364',5),(8,'laura17@hotmail.com','Samuel','Flores','Room 108','(596)909-0208x55512',4),(9,'hcarrillo@hotmail.com','Jennifer','Fox','Room 109','106.862.2146x5516',4),(10,'cameronhorn@smith.com','Valerie','Kelly','Room 110','156-029-1697',1);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_records`
--

DROP TABLE IF EXISTS `medical_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_records` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(2000) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `record_date` date NOT NULL,
  `record_type` tinyint NOT NULL,
  `doctor_id` bigint DEFAULT NULL,
  `patient_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtny13k9v4o58styd47st3s2l5` (`doctor_id`),
  KEY `FKrav12h9aiw7pegjt62p8owwn3` (`patient_id`),
  CONSTRAINT `FKrav12h9aiw7pegjt62p8owwn3` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKtny13k9v4o58styd47st3s2l5` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_records`
--

LOCK TABLES `medical_records` WRITE;
/*!40000 ALTER TABLE `medical_records` DISABLE KEYS */;
INSERT INTO `medical_records` VALUES (1,'Far prevent clearly eat foreign protect wear. Trouble tax opportunity be.','2025-01-10 00:00:00.000000','2025-01-10',0,10,13),(2,'Establish garden mention step describe nothing. Decide major employee sign.','2025-03-03 00:00:00.000000','2025-03-03',0,5,8),(3,'Season might bill investment item. Include bad film.','2024-09-21 00:00:00.000000','2024-09-21',2,9,1),(4,'Be task quickly wife mouth technology. Soldier character relate point mind with act. Fly clearly understand.','2024-12-26 00:00:00.000000','2024-12-26',1,10,17),(5,'Ago paper body to.','2025-02-02 00:00:00.000000','2025-02-02',0,6,17),(6,'School professor me bar look protect factor. Church recent agree carry bed both perform.','2024-10-17 00:00:00.000000','2024-10-17',0,7,12),(7,'Method open perhaps if. Give wish security.','2024-09-10 00:00:00.000000','2024-09-10',0,8,20),(8,'Worker show Congress thus other approach happen. Central kind number room economic available. Bar data strategy contain language room cultural southern. Lot important main magazine beat.','2024-10-18 00:00:00.000000','2024-10-18',1,1,1),(9,'Republican treat trade tax poor of section. One value term maintain possible. Simply good education pretty two throw open.','2025-04-30 00:00:00.000000','2025-04-30',0,5,3),(10,'Build direction simply protect. However oil water.','2025-04-29 00:00:00.000000','2025-04-29',0,6,20),(11,'Research author chair specific activity attorney population why.','2025-03-23 00:00:00.000000','2025-03-23',0,9,11),(12,'Paper participant though evidence bill. Traditional lead serve time. Involve move staff hard themselves manager.','2025-01-27 00:00:00.000000','2025-01-27',2,6,4),(13,'Themselves region herself bank really. Project necessary cut thing forget either spring. Tonight black increase able hope. Surface follow different response about.','2025-01-18 00:00:00.000000','2025-01-18',1,2,12),(14,'Put chance wonder continue side. Might course child seek.','2025-03-14 00:00:00.000000','2025-03-14',2,9,10),(15,'Side so moment professional generation. Some perhaps sometimes.','2025-04-13 00:00:00.000000','2025-04-13',0,5,14),(16,'Require less describe happy deep none. About blue similar thousand.','2025-05-09 00:00:00.000000','2025-05-09',0,3,14),(17,'Down eye let sense television. Particularly second still arrive life report.','2024-11-02 00:00:00.000000','2024-11-02',1,10,16),(18,'Hand any note material then.','2025-01-08 00:00:00.000000','2025-01-08',1,3,3),(19,'Inside dream know pay significant town. Group truth perhaps table. Trip class similar themselves list debate.','2025-03-24 00:00:00.000000','2025-03-24',1,9,8),(20,'Maybe per decide exactly reveal. With play memory soldier assume. Suffer so value realize member base.','2024-10-21 00:00:00.000000','2024-10-21',0,5,6),(21,'Probably eat study wall worry.','2025-02-03 00:00:00.000000','2025-02-03',1,9,13),(22,'Lead kid we against respond. Analysis discussion message difference little.','2024-12-21 00:00:00.000000','2024-12-21',0,3,17),(23,'Still whom impact really. Season become fact stay offer change.','2025-02-22 00:00:00.000000','2025-02-22',0,9,1),(24,'Civil rate case exist practice environmental debate. Within chair room.','2025-03-01 00:00:00.000000','2025-03-01',2,9,7),(25,'Phone reveal ball our cold defense very. Score bad its practice among perhaps teacher half. Certain top someone international factor.','2024-08-28 00:00:00.000000','2024-08-28',1,5,5),(26,'Draw expert loss wind. Night happy themselves popular wind doctor. Because improve control exactly cut attention.','2024-11-28 00:00:00.000000','2024-11-28',1,10,17),(27,'Year down suddenly score owner. Office before collection. About music power action environment prevent.','2024-12-10 00:00:00.000000','2024-12-10',2,9,12),(28,'Where argue assume financial media. Draw decision international.','2025-05-08 00:00:00.000000','2025-05-08',1,3,11),(29,'Behind deep economic past old. Reveal today compare add.','2024-12-31 00:00:00.000000','2024-12-31',0,9,15),(30,'Force bad look above various ability. Together to kitchen almost. Set space baby ever.','2024-08-19 00:00:00.000000','2024-08-19',1,10,9),(31,'Common sport maintain leave four wall. Idea buy people space. Doctor key generation ability bag. Power fine pretty service.','2024-09-02 00:00:00.000000','2024-09-02',1,1,13),(32,'Star security staff lose. Tree treat nearly after finish do.','2024-12-28 00:00:00.000000','2024-12-28',0,5,5),(33,'Season price fall style nation expect. Town world eight hot. Within medical before sea among suddenly small travel.','2025-04-12 00:00:00.000000','2025-04-12',0,3,5),(34,'Police ability course kitchen since while. Human pay land me economic. Mind yourself past eight.','2025-05-15 00:00:00.000000','2025-05-15',1,7,3),(35,'Fill interest wait every kind heart reality she. Red treat plant physical economic law leg.','2025-01-31 00:00:00.000000','2025-01-31',0,1,8),(36,'Possible thought shoulder up. Risk into baby sell. Whatever their ability born right career reality.','2024-10-23 00:00:00.000000','2024-10-23',2,3,12),(37,'Couple maybe then grow. Participant himself discussion.','2025-04-18 00:00:00.000000','2025-04-18',0,6,6),(38,'Strong everybody west suffer on close open.','2025-03-27 00:00:00.000000','2025-03-27',2,4,15),(39,'Authority arrive effort toward site. Man why hear out road. On true keep stop peace alone. Live piece condition production without.','2025-04-27 00:00:00.000000','2025-04-27',2,1,10),(40,'Soon affect and news produce area sure. Mission loss teach black. Article we green response whom.','2024-09-09 00:00:00.000000','2024-09-09',0,10,18),(41,'Although far condition realize Congress onto road. Together eight quickly.','2024-06-08 00:00:00.000000','2024-06-08',2,1,13),(42,'Role newspaper such behavior specific mission. Onto scientist floor you improve. There expect risk address.','2025-03-20 00:00:00.000000','2025-03-20',0,6,8),(43,'Fly crime as manage. Method public own sense successful six more.','2025-02-17 00:00:00.000000','2025-02-17',2,4,19),(44,'Manage economic central reach around leave PM.','2025-03-28 00:00:00.000000','2025-03-28',0,3,11),(45,'Box early government phone particular turn.','2025-01-26 00:00:00.000000','2025-01-26',0,5,5),(46,'Hard husband weight involve history. Tax prepare true. Growth concern conference rate.','2024-11-03 00:00:00.000000','2024-11-03',0,6,13),(47,'Figure pattern occur argue sport hotel boy movement. Life player majority tough task. Operation he doctor really.','2024-09-16 00:00:00.000000','2024-09-16',2,4,8),(48,'Attack base guy. Thought season firm effort already both. Range pretty rock agent.','2024-06-18 00:00:00.000000','2024-06-18',2,10,20),(49,'If country tonight always we arrive. Its painting several stuff necessary. Generation three north space who.','2024-11-07 00:00:00.000000','2024-11-07',2,9,7),(50,'Smile ready teach sea few win specific. Child evidence election simply describe.','2025-04-17 00:00:00.000000','2025-04-17',1,7,17),(51,'Finish section base agent here be star. Full professional not drug personal. Reflect teacher level science.','2024-09-03 00:00:00.000000','2024-09-03',0,9,1),(52,'Kind range recent through. I past dark simply serious so. Garden suffer skill meeting decide.','2024-10-27 00:00:00.000000','2024-10-27',0,8,8),(53,'Race about relationship name relationship can. Offer lot true wife seat operation. Simply seek see someone decision write watch.','2025-03-20 00:00:00.000000','2025-03-20',0,4,20),(54,'East be open wrong section. Improve star world above minute difference former. Republican work summer marriage might cover.','2025-02-17 00:00:00.000000','2025-02-17',0,9,15),(55,'Cell all mean energy two institution father. Civil TV most.','2025-01-24 00:00:00.000000','2025-01-24',1,2,1),(56,'Believe prevent itself. Final threat sort information whatever war.','2025-01-19 00:00:00.000000','2025-01-19',1,3,6),(57,'Company modern material allow start war. Stock together order maybe enough.','2024-08-11 00:00:00.000000','2024-08-11',2,8,6),(58,'This affect carry. Couple position consumer civil group.','2025-03-20 00:00:00.000000','2025-03-20',0,8,3),(59,'Property behavior former me other meeting body. Short identify bring. Lot mind body gun administration simply learn.','2024-09-06 00:00:00.000000','2024-09-06',2,9,3),(60,'Loss raise industry bill. Letter determine body own during law page. World only matter situation school skin.','2025-05-02 00:00:00.000000','2025-05-02',1,10,12),(61,'Quite operation product million boy minute. Send way force practice decide. All age goal involve threat my determine method.','2024-11-08 00:00:00.000000','2024-11-08',1,8,20),(62,'Late bad even. Though must social last senior recognize shake.','2025-02-27 00:00:00.000000','2025-02-27',2,8,16),(63,'Carry want until most author. Production ready teacher return serious. Popular toward kid if better various study.','2025-04-24 00:00:00.000000','2025-04-24',0,7,1),(64,'Traditional speech increase challenge. Race choice contain.','2025-02-03 00:00:00.000000','2025-02-03',0,5,2),(65,'Today speak save wall try discover. Natural them him meet agreement evening. Professional like return fly once better.','2024-07-07 00:00:00.000000','2024-07-07',2,6,16),(66,'Develop window institution question. Present born arrive. No no maybe least.','2024-11-02 00:00:00.000000','2024-11-02',1,2,3),(67,'Early foreign attorney the four hit whose but. Poor drop partner religious charge send.','2024-09-17 00:00:00.000000','2024-09-17',0,9,7),(68,'Nature thought find year. Save could blood listen. Old company teacher support.','2024-10-15 00:00:00.000000','2024-10-15',1,3,9),(69,'Relate government speech country challenge fight experience. Hospital firm song baby establish gun. Factor wind suddenly question road thing change.','2025-02-03 00:00:00.000000','2025-02-03',2,3,9),(70,'Add hard size wind road threat. Certainly fire responsibility listen. On respond manager sign some prevent term.','2024-07-14 00:00:00.000000','2024-07-14',0,10,3),(71,'Simply son record car to. High letter others staff.','2025-05-15 00:00:00.000000','2025-05-15',1,1,12),(72,'Share which these land large case. Section six like.','2024-12-21 00:00:00.000000','2024-12-21',2,2,9),(73,'Guy visit writer physical.','2025-04-13 00:00:00.000000','2025-04-13',1,1,18),(74,'Owner be although fund eat. Upon action form entire sister decade listen.','2025-03-26 00:00:00.000000','2025-03-26',1,7,5),(75,'Much institution tell human much exist. Yes kid environmental able.','2024-10-11 00:00:00.000000','2024-10-11',0,2,14),(76,'Discover whatever but bar. Stock animal mother region rule TV least.','2025-04-04 00:00:00.000000','2025-04-04',1,8,1),(77,'Wait mention still affect series must court. Strategy interest seem individual.','2024-07-14 00:00:00.000000','2024-07-14',0,4,13),(78,'Kid draw production high answer. Magazine matter others case happy. Inside machine thing now.','2025-03-25 00:00:00.000000','2025-03-25',1,8,15),(79,'Daughter arm newspaper scientist indicate relationship. All program early wait exist political letter computer. Throw once billion final team me follow under.','2024-10-06 00:00:00.000000','2024-10-06',1,8,6),(80,'Everybody research institution late eat.','2024-10-12 00:00:00.000000','2024-10-12',2,6,4),(81,'Knowledge blood put all. Letter media sport sit however value. Gas with operation phone society do significant.','2025-03-22 00:00:00.000000','2025-03-22',1,3,5),(82,'Much similar number. Of bed consider area drug.','2025-05-28 00:00:00.000000','2025-05-28',0,10,7),(83,'Stay very century game do clearly. Suggest into loss central compare best. Change poor article so the.','2024-10-14 00:00:00.000000','2024-10-14',2,10,3),(84,'Quite war election certain whole reality while. Respond close great. Require seem force trade. Minute add nice line evening figure human.','2024-10-23 00:00:00.000000','2024-10-23',2,9,11),(85,'Effort street investment sing TV later student. Trip skin forget. Music opportunity after ten candidate reduce.','2024-06-09 00:00:00.000000','2024-06-09',1,3,1),(86,'Information process walk full physical. Nature night build with or husband over gun. Within maybe hand green question ask.','2024-07-30 00:00:00.000000','2024-07-30',1,8,2),(87,'Run wonder sense charge bar ball.','2024-11-30 00:00:00.000000','2024-11-30',2,3,8),(88,'Decade newspaper hospital blood. Number drive sister leg machine network too. Practice impact against person short.','2024-09-29 00:00:00.000000','2024-09-29',0,3,9),(89,'Thank south generation then family eye single personal. Station green opportunity effect guess citizen. Part risk social bad plan more whole.','2024-12-14 00:00:00.000000','2024-12-14',0,9,2),(90,'Method join theory number arrive product. Admit drop medical time effort fish. Example arm need move return always finally image.','2025-04-19 00:00:00.000000','2025-04-19',0,1,1),(91,'Nothing democratic part church now environmental. Compare prevent card ground during. Race tell another talk strategy.','2024-07-08 00:00:00.000000','2024-07-08',0,3,4),(92,'Within none hospital. Reason become song admit. Force white table allow billion high.','2024-09-16 00:00:00.000000','2024-09-16',2,5,9),(93,'Share point enough member cup whole direction. Medical general whatever. Sense minute Congress north seat law.','2024-07-12 00:00:00.000000','2024-07-12',1,2,3),(94,'Stage oil remain she election.','2024-11-29 00:00:00.000000','2024-11-29',1,6,4),(95,'Police race relate ago.','2024-10-05 00:00:00.000000','2024-10-05',1,8,11),(96,'Manually created content','2025-06-13 10:18:03.528092','2025-07-23',0,7,17),(97,'Manually created content 2','2025-06-13 10:18:43.178776','2025-08-16',1,3,10);
/*!40000 ALTER TABLE `medical_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(1000) DEFAULT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `gender` enum('FEMALE','MALE') NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `primary_doctor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfijsfcoc650a2167vuujkrvhl` (`primary_doctor_id`),
  CONSTRAINT `FKfijsfcoc650a2167vuujkrvhl` FOREIGN KEY (`primary_doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'7451 Williamson Flats\nCharlesview, ID 85363','1945-03-25','iburke@hotmail.com','Paul','MALE','Charles','071-851-6700',5),(2,'77948 Jennifer Mountains\nPaulbury, IL 30423','1961-03-26','lopezmegan@gmail.com','Ralph','FEMALE','Bright','8108496157',9),(3,'1760 Charles Shoal\nNorth Keithmouth, MT 98547','1976-12-29','gina20@gmail.com','Todd','MALE','Costa','(536)456-6458x0469',4),(4,'635 Daniel Flats Suite 272\nPort Jonathanberg, AZ 60448','1991-09-28','fgray@clark.com','Brian','MALE','Barker','605.375.6651',5),(5,'38031 Levine Stravenue\nChanland, DE 52707','2023-10-03','melissa75@ruiz-hayes.com','Katelyn','MALE','Jackson','001-066-766-0701x20647',6),(6,'Unit 0620 Box 7656\nDPO AA 40584','1980-10-13','jordanmitchell@goodwin.com','Billy','MALE','Yang','+1-343-807-3485x66855',8),(7,'0118 Jackie Drives Apt. 450\nMooretown, AL 32125','1978-04-09','tmorgan@gmail.com','Jacob','MALE','Morris','802.793.4845x63437',5),(8,'Unit 1602 Box 0411\nDPO AE 60537','1969-02-20','ysanchez@fox-morris.com','Kyle','FEMALE','Griffith','9537627905',3),(9,'672 Robert Stravenue Suite 517\nPerrybury, OR 76735','1976-01-20','bmyers@yahoo.com','Gabriela','FEMALE','Cummings','161.538.4932',10),(10,'PSC 2324, Box 2001\nAPO AA 08307','1952-01-07','wallaceelizabeth@gmail.com','Kari','FEMALE','Goodwin','+1-535-087-8873x3167',10),(11,'30152 Williams Field\nEast Jacobshire, MA 73582','2001-07-23','tammy89@hotmail.com','Timothy','MALE','Meadows','547-874-1257',8),(12,'899 Antonio Drives\nJillianmouth, IA 02712','2022-11-01','thomasjuan@white.com','Darrell','FEMALE','Wells','057-653-9193x55211',8),(13,'PSC 8770, Box 7741\nAPO AA 71830','2018-02-19','santiagocheryl@yahoo.com','Austin','MALE','Gibson','+1-443-179-0330x20094',2),(14,'4574 Colleen Circle\nRobertsbury, NM 51746','1934-10-27','william63@hotmail.com','Christopher','MALE','Ball','910-894-9406',5),(15,'5969 Adam Highway\nJohnsonland, NM 40902','1989-09-09','ksalinas@white.com','Stephanie','MALE','Alvarez','0754117197',4),(16,'83921 Casey Walks\nMooreville, NE 89050','1966-06-01','garciajeff@gmail.com','David','MALE','Castillo','+1-364-127-9715x077',9),(17,'8278 Skinner Field Suite 267\nEast Jessicaberg, HI 69426','1953-12-25','brenda78@gmail.com','Laurie','MALE','Moore','+1-016-212-1069x71334',4),(18,'642 Paul Ford Suite 174\nJacksonborough, CT 06945','2008-10-04','john09@hotmail.com','Tyler','FEMALE','Hall','536.732.8863',3),(19,'5177 Woods Valleys Suite 827\nMillerfort, GA 05463','1995-10-30','sarahoover@hotmail.com','Brian','MALE','Orr','001-946-092-1060x00392',8),(20,'87623 Kaitlin Cove Suite 178\nNew Shane, NH 55807','1997-10-22','lowewilliam@rivera.com','Diane','MALE','Ryan','(629)910-4626x39262',3);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialties`
--

DROP TABLE IF EXISTS `specialties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialties` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(500) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKbhb8s9o5hv30lkbidtod9cixc` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialties`
--

LOCK TABLES `specialties` WRITE;
/*!40000 ALTER TABLE `specialties` DISABLE KEYS */;
INSERT INTO `specialties` VALUES (1,'Heart and blood vessel disorders','Cardiology'),(2,'Brain and nervous system conditions','Neurology'),(3,'Healthcare for children','Pediatrics'),(4,'Skin conditions','Dermatology'),(5,'Mental health treatment','Psychiatry');
/*!40000 ALTER TABLE `specialties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visits`
--

DROP TABLE IF EXISTS `visits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visits` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `complaints` varchar(1000) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `diagnosis` varchar(2000) DEFAULT NULL,
  `recommendations` varchar(1000) DEFAULT NULL,
  `treatment` varchar(2000) DEFAULT NULL,
  `visit_date_time` datetime(6) NOT NULL,
  `appointment_id` bigint DEFAULT NULL,
  `doctor_id` bigint NOT NULL,
  `patient_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK73yxi7qscoj1sv4tb5bqwdbs3` (`appointment_id`),
  KEY `FKth95fndjk3y3nepjfu3f66r63` (`doctor_id`),
  KEY `FKra5p2e0tp6djolm46kdr42cyt` (`patient_id`),
  CONSTRAINT `FKfpy5talf3e95w9iie6gr8emsy` FOREIGN KEY (`appointment_id`) REFERENCES `appointments` (`id`),
  CONSTRAINT `FKra5p2e0tp6djolm46kdr42cyt` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKth95fndjk3y3nepjfu3f66r63` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visits`
--

LOCK TABLES `visits` WRITE;
/*!40000 ALTER TABLE `visits` DISABLE KEYS */;
INSERT INTO `visits` VALUES (1,'Chest pain','2025-01-20 10:00:00.000000','Migraine','Avoid allergens','Rest','2025-01-20 10:00:00.000000',1,2,13),(2,'Cough','2024-12-20 10:00:00.000000','Allergy','Hydration','Cream','2024-12-20 10:00:00.000000',2,1,10),(3,'Rash','2025-05-28 10:00:00.000000','Flu','Hydration','Rest','2025-05-28 10:00:00.000000',3,7,9),(4,'Back pain','2025-03-25 10:00:00.000000','Migraine','Hydration','Rest','2025-03-25 10:00:00.000000',4,4,17),(5,'Chest pain','2025-05-25 10:00:00.000000','Allergy','Follow up in 2 weeks','Cream','2025-05-25 10:00:00.000000',5,10,14),(6,'Rash','2025-05-31 10:00:00.000000','Allergy','Hydration','Physiotherapy','2025-05-31 10:00:00.000000',6,4,10),(7,'Headache','2025-02-17 10:00:00.000000','Migraine','Avoid allergens','Cream','2025-02-17 10:00:00.000000',7,1,8),(8,'Cough','2025-01-12 10:00:00.000000','Eczema','Avoid allergens','Rest','2025-01-12 10:00:00.000000',8,2,5),(9,'Chest pain','2025-03-09 10:00:00.000000','Eczema','Hydration','Cream','2025-03-09 10:00:00.000000',9,4,6),(10,'Back pain','2025-05-20 10:00:00.000000','Eczema','Avoid allergens','Rest','2025-05-20 10:00:00.000000',10,5,10),(11,'Headache','2025-02-26 10:00:00.000000','Flu','Hydration','Physiotherapy','2025-02-26 10:00:00.000000',11,1,18),(12,'Rash','2025-04-20 10:00:00.000000','Flu','Hydration','Rest','2025-04-20 10:00:00.000000',12,2,19),(13,'Rash','2025-04-21 10:00:00.000000','Hypertension','Hydration','Medication','2025-04-21 10:00:00.000000',13,10,1),(14,'Rash','2025-05-15 10:00:00.000000','Eczema','Use prescribed ointment','Rest','2025-05-15 10:00:00.000000',14,2,9),(15,'Chest pain','2025-01-28 10:00:00.000000','Migraine','Avoid allergens','Diet change','2025-01-28 10:00:00.000000',15,1,5),(16,'Back pain','2025-06-03 10:00:00.000000','Hypertension','Use prescribed ointment','Cream','2025-06-03 10:00:00.000000',16,9,15),(17,'Back pain','2025-04-12 10:00:00.000000','Flu','Hydration','Cream','2025-04-12 10:00:00.000000',17,5,10),(18,'Headache','2025-05-22 10:00:00.000000','Allergy','Avoid allergens','Diet change','2025-05-22 10:00:00.000000',18,4,13),(19,'Cough','2025-04-24 10:00:00.000000','Eczema','Use prescribed ointment','Physiotherapy','2025-04-24 10:00:00.000000',19,8,15),(20,'Cough','2025-01-16 10:00:00.000000','Flu','Use prescribed ointment','Medication','2025-01-16 10:00:00.000000',20,1,10),(21,'Rash','2025-02-26 10:00:00.000000','Migraine','Hydration','Medication','2025-02-26 10:00:00.000000',21,3,16),(22,'Cough','2025-03-18 10:00:00.000000','Eczema','Use prescribed ointment','Cream','2025-03-18 10:00:00.000000',22,9,11),(23,'Headache','2025-02-26 10:00:00.000000','Flu','Hydration','Physiotherapy','2025-02-26 10:00:00.000000',23,3,17),(24,'Headache','2025-03-15 10:00:00.000000','Eczema','Hydration','Medication','2025-03-15 10:00:00.000000',24,7,4),(25,'Headache','2025-01-24 10:00:00.000000','Eczema','Use prescribed ointment','Medication','2025-01-24 10:00:00.000000',25,1,14),(26,'Headache','2025-02-26 10:00:00.000000','Flu','Avoid allergens','Rest','2025-02-26 10:00:00.000000',26,3,18),(27,'Rash','2025-05-31 10:00:00.000000','Allergy','Hydration','Physiotherapy','2025-05-31 10:00:00.000000',27,5,18),(28,'Headache','2025-03-12 10:00:00.000000','Migraine','Use prescribed ointment','Medication','2025-03-12 10:00:00.000000',28,5,12),(29,'Chest pain','2025-02-14 10:00:00.000000','Eczema','Follow up in 2 weeks','Cream','2025-02-14 10:00:00.000000',29,1,2),(30,'Rash','2025-04-25 10:00:00.000000','Hypertension','Daily monitoring','Cream','2025-04-25 10:00:00.000000',30,1,3),(31,'Rash','2025-01-05 10:00:00.000000','Migraine','Hydration','Physiotherapy','2025-01-05 10:00:00.000000',31,3,17),(32,'Back pain','2025-04-14 10:00:00.000000','Allergy','Daily monitoring','Rest','2025-04-14 10:00:00.000000',32,4,8),(33,'Cough','2025-05-04 10:00:00.000000','Migraine','Avoid allergens','Physiotherapy','2025-05-04 10:00:00.000000',33,10,6),(34,'Cough','2025-01-15 10:00:00.000000','Allergy','Use prescribed ointment','Rest','2025-01-15 10:00:00.000000',34,1,1),(35,'Back pain','2025-01-24 10:00:00.000000','Hypertension','Avoid allergens','Medication','2025-01-24 10:00:00.000000',35,7,7);
/*!40000 ALTER TABLE `visits` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-13 15:26:18
