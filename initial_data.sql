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
INSERT INTO `Address` VALUES ('283627e6-5732-4808-830a-d87297476749','123 Some Place','','Albuquerque','NM','87125'),('3bfd50e3-6943-4c76-950a-17e56de142d2','123 Some Place','','Albuquerque','NM','87125'),('677a7500-d7d6-43f1-8ec9-b06955c660cc','283 Costa Rica Dr NE','','Albuquerque','NM','87123'),('6a169f86-1a55-4962-9e5a-4b12d15553d0','439 Some Place NW','','Denver','Colorado','80912'),('751cf914-793c-4de8-b617-2b05f5f7fc25','6437 5th St.','Apt. 432','Santa Fe','NM','87125'),('7e26562a-caa7-4d6e-aaba-375b99308dc5','234 54th Street NE','','Albuquerque','NM','87125'),('d615a615-3721-4be9-9868-c91feca7dc75','123 Some Place','','Albuquerque','NM','87125');
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
INSERT INTO `Customer` VALUES ('e44ebec0-7574-4dbf-9309-2d8c1936ecbc','','DWG9VQL02PENDR2W2G','7e66a7cc-f4cb-4f7d-8726-0ab23a207ff1'),('jane-123','','jane','d4b58776-f2de-41f9-aa04-4123a8cd30db'),('john-001','','john','5edad9d1-4242-442e-b69c-c74ec6f16725');
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
INSERT INTO `Email` VALUES ('1d6c49c7-1ac1-44b3-9dcc-5eaa347c20e3','itrjll22@colostate.edu','student'),('53afeb33-6819-40df-be9c-268f98c659b2','johndoe@test.com',''),('5a1c87be-790e-46fa-9dcd-5211a7fb3140','jsmith@test.com','personal'),('b52d1b52-bc08-45dc-8ce1-369823661ebb','janedoe@test.com',''),('b550d61b-e964-4490-ac23-10e44e7406cf','itrjll22@outlook.com','personal'),('b932108a-04e1-46e1-82ce-22431d5d9a59','testacct@test.com','student'),('dfd2e295-9be7-4016-a68c-03a2a65cae31','isaac.trujillo@colostate.edu','student');
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
INSERT INTO `EquipmentItem` VALUES ('1d42155e-b39e-4d27-83e0-30f7d54045f0','ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0„\0	(!\Z%!2!%5+0..383,7(-.+\n\n\n\r\Z+ &+.7-70-/++//65+++7-7-7+02+.+--+-+-+--++++++7--/---ÿÀ\0\0á\0á\"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÄ\0G\0		\0\0\0\0!1A\"Qaq‘2BR¡#br‚’±3s¢ÁÃÑS²ğñ$Ccƒ“ÂÒá4ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÄ\0\'\0\0\0\0\0\0\0\0\0!1q±aÁ\"#ACQÿÚ\0\0\0?\0¼b\"\" \"\"\" \"\"\" \"\"\" \"\"aöß)°˜B½P®EÂ³•İ|£P4:›\r&K‰JTŞ£œ¨ŠY‰ÜEÉôÍ[kl6\"½\\EM\Z«cîÓ\Z\"y\0İ¼•bî§Î6ÏcaQÉ;‡FÚ™ÍyÁÙüj0ñ¦÷ôóÏÔêµî›Æº§g	\'·]	Í•û=¶–Nıü%ñÛËĞ49k€{e¯¿wÑÔ^ò¶“°ü¡Â?³‰¢{ºEĞ›Ï5kT±Ë_Š*‚<\nÈ @¶¤üÌ—mI³§QX]H#´Q9Ï*ro”•ğøÊuhÕ¨)‡Rèä©A2î%”gª‘\0AÔãzî–I{>ÄD¨DDD@DDD@DDD@DDD@DDD§¹Şåñ,Û7öc¦*²ŸaxÒR=îxnß|¡ÙÎg/èÖ§S…bİ`+Ö«Ê¦ìˆ×ër4µÅÍÍª*µƒoà¸IÎ¢„@Š-˜Ø6¾½úYÏû&©öi–7Ğ«+\råxuVô—nW´Úe8öÊÈÊòso.<Ìûß¤Ëà,WÇyã6,O,éäèªáòÜÜº”¨ÇCÛPé­ôµ¬<&£CeÑÈ:SUïú6(/¨±á±ó˜í§‡Jl9pEîW-›[®»ÈÓÖk§)ù5f¿¹døû¹çÑá—ênwó«¿º)6ˆ¯\\½5*€\0£(A© w“äÆ!Xñ=Q÷‡Xù-ÇŞ¨\r/òãé>c¡>>ö÷>½_Û•îí†3u?d­˜€ÆÂúö¯å=EÈ¼Q«³ğ®u&0Ok*…?1<˜ªj¥ÑHêß.`7‹ğ–$ùwS\0)¬øf¾zõ0\r‹Q°`oÕÜÚî:Â/è8,RU¦•i°duWF™R<AĞ¨çGTÃgÂàœ5}EJ¢Ì´8^W»rñÔ·Şr†\r[ƒlØ¦v]z#»ş!‡\rı—£ğUÕß;3jÄ«j|m R¡V½\\¢åœ’nIcsrõïßrOl—[aª¡,ä€¡“.v½¬ ›÷ß‡Il–KåµlşQaB\nO‡ÌúÌ»ÉÖıeÓÖM\\NÍ}ô2ı‘—üĞÃ¨Ë{r,Iİk^ò%L+ÓbT‚A×. Úy/GÇr¹cr—é•zqë3ôÉf6}d«9h`²ÖªŸ~§wÆà=$¡„™˜v8¤şö~N­©í•]<UuÜïæsCy6‡(j.ˆã½rŸQ§Êg><¦¿+ï¬¾]pëf?ÇŒöŞ?\rŸ”°ê+5T{YQU2mH;Íìu=ÂiÕ“^çO.&dßháë(VÏG[ğd¾íNÿ\0Ë|‘‡Ø¬½t\" ;ŠéÕîı<ğÇYåê¾ÚyùùqäËÕŒ×û·&r¯úv“å¬É{èG7\r;I×ÄÎ¤L€ƒíkê‡Äñò³næ·bş•Vazt-Uû3ƒôKã˜fû†wp]œÀ>…¾*h{3*€mİy‘ˆ\"\"\" \"\"\" \"\"\" \'Ç`$€\0¹\'@\0ŞIŸf¡Î¦$¦Îu\Zt•)!û\"½@{Š+8ûCœ-™GÚÅ+ùjõ~tÔâfÏ&4Juêw…D_Ş|ß)Dâk‹õ˜\\ö2n`bëÑaq}ÅhÔËøÈÊ=`o<©ç†µzMOG ¹ÕúBîÉcuÑW%ôÔºU˜¥g=\"SP‡€U²‘¡\Z5›öšı«PùÖ—íj ùS,~SOd¾¤¥ˆHroìÚÛÉğÒ™pÔÍ¬\ZÃ¤eÒì}”[	ğÆS®ÕX»1$÷›[°wMJS[\\Û²÷&\\¼”äVÍ«‚£Q°´İªÓGf`†e¨qb\0$; QX`¦@*»ÏZİa{\\ßÈzMƒ•;¿D¥ˆ£Q*ƒ-`ºdÄiOg\rxe£æ‹fT¾AZ‰í§T·Ê®q5îQò?³°¯úœMR+ÓªŠÄ Ğ>P:Äu\\¤\08\r&¢Ì¬ñTµZª¦ìŒ4b/”÷É¸İ’i©%_îİÿ\0¨ºµ$jºjyº¥ß1\ZñË—³Œ…‡¯‰Té¸§›(kõKÚö\0ïò•v~«¾UM8¶ì£´‘ùM»0ÃÓZTÍÈ¹á}I>»§ÜĞô}!éĞ²RxÚB¨¤}÷×ÇŒ Ï@sY±—³é·¿\\\n®~Ğê/’ÛÏ1ã(lÍs¸oï<ôŸ$Çûö¾h£-D@DDD@DDD@DDÀÒ¯LÓ­MjSoiC)¶¢à÷ÉÎØ¸\\8µ=\Z_³¦‰ş\'Ä@MÎMĞ«¯‰—§@ŒUuÍq¸Ù/¿°MşAÛ¸.Ÿ\rZ÷”ª\'›)óåŠ3(\'}µ„æ—Òlº ›šmQ“±QøYg¶iê‘ØÇç¬ºùŠÅŞ†&ÃQ_Ê¢eşT>k¾å+`h#SUjµ_£§šùåg.ÀXÚÂ×$k6y^s»³±Wôi=TCW:ÓV¨áÜ ¦r($­ƒ‚x\\@§vÕ_Ò«\ZÏfÖÔé%-ö\'>@3·{_ÆF§‡EöT_·ŒÜ¶76;F¨PÈ”X^«]¬ğ‰säÅfé²y Ã.¸šÕk*¿AOÑIŞFãëzl¡…¿)°VÀŠ‡8k\0Ú×áã,şZóaF¥5l\ZiQ-tĞ¹¾/¼ïÎ‚UTñ¦–zGWFe+ğº’¬	ât\r‡’ü™|UAF™\n fw<ö&Şñ½„¾08QJ’R[åDTßdEûô”§3X¦şÓlÆùğî<ÃÓao eåÊûk	ĞmeÁj¾Qõs¿+Mó™,^\\mZ|*Q\'ïSu·ÉÚ`yİÁô[i›…jhÿ\0ºó¦}gÎm±}ÔÃØ32üèÊâ+éÑqÍ›[\n´öŞ.™PÀÖªÁXhMU5æâzNyë\Zİ¨Àåé…@x”S½ìæ3›ÆÏ£X]e*#é>ÛÃ*‚ªİ ±¾ãNªü(>rö|ÁÕñø\Z–Unš’¸P¤ÒÌH\ZÄaå=1ÓÛx±·»|òNK!³‘)Oö…Âe«ƒÄñ#åe ~ûJÿ\0gc:\Zôªÿ\0wQğ8oá..0=&ËÎ7ÒªäÁ“óeô”r>e´˜ë bb¹+Œé°Xj¼^2~ÑA›çy•€ˆˆ	Eóï†Ë´pÕ~:<éTcüß”½%EşĞXn®\n¯ÃR­?ûŠ­ü¸\ZVØÚhBTF,èâ¥k‚K1û€ÊƒM\'¤U®.8Ï)UüÄôï\'1=.Sã£I¿)œø¸ç>™á¾NK^ªÈÄDèÁ5Şpğ]6ÌÅ¥¯ô,ÀwÓúAóYå¼\rN —†{½ êÊw0 øc<sˆ¤ÔkU¢A,•õÇæ zS™ìgI²©ÜÓjˆ|œ°…„İeÍ§/fa+¥j5]š¯IM{¢«\\û¾Àõ;Wüs¹©S¢¼÷ñ& ±>¡byïÏV5Hé:3ûJV¿¦DÛ¶O=›õØrÅEÖ§ª¶[z˜´®9úÃfÙŠÿ\0İb)7“¥üÁé6]ËŸ‰°§ˆ@ÇÜ©zM~ÀÙ¼¯!s·…év>,u ÿ\0¤éSòX¾‚z+›lF}—…=ˆSşÛ5?ügœhµĞKç™œFm˜à«U}H©ÿ\0œ\rê\" \"\"\" \"\"\" \"\"\" \"$l~Ğ¥AsV¨”×µØ(ğŞ`I‰ íu0”®(+×nßÕÓ¿{0¿ÊİóFÛ<äcëÜ+Š	ÙLY­Şæì<VĞ.ün>•ÍZ¢S^×`£Ô™©m^s°n»vR]/öŞËéyCãv¸f,ÎÕ\\ï7.O‹o;ÈqÕu~&õ:@´vŸ;8š•pÈtVıcÜébX\0/Ü<åkÛC¤¨ÅK33bm™‰$±Óy:È&ív=­©ùîœøG¤	8\r¢j½Š€;¯y>¶ãBì\"`Ú’ïŞ\Z\">¢nlÃ±µùïõÎ¶ÊQÀ§Ùİéº@«³u[‘¿¤ÌÑÛk¹Ô¯xë–¿)óÀTh@±õ¸2bª¡¶`ßV ³zş³5†å}d¡SÒU¤•)º\Zdç¤UÔ©²àïÎG:‹ì\"ò&7¥NVËõIºù_ÙòLÀ5é‰tó_ıßO²²¿ã¦ùrØÆôíÙ,Ngñf9…È\rHÜ_BA¸ãm}eÔNâs€ˆˆˆ€ˆˆ‰Â­EU,Ä*€I$Ø\05$“¸@çOÚüãàhèŒk·e!uüfÀ³y¥mns1µn(ªP^ßmÿ\0|‡Œ‹§IKÕuEÙØ*34ı±În\n•Å,ÕØ|*y³pï\0Êgjm2ÍŸ]¾»o\0.HÛ¦>¦1ˆÍN™\n8¸²Üñ\0o07í¯ÎV:½Å,´êÍn÷oÍlf‘´6 g-Z«Ts¿SQÏq\'øÌmw-úÊ…şªõWÎu­L¾Àà5õ&¦%Ï²¢˜íssä?„ŠáO´Z§ULÄïÖ|¼µ\Zü\0îÂpŸLùx->^|&À\\÷@lÒušÇÚê÷o3\'„Ùj5ï6°0)ƒw\ZwÎ%ogu€î\0o3$˜Uõü§a2ˆ#=ãøtñ˜]»@ “ñ;c#2ä½ÍmÚn´×¶¦Ğj‡Vû«ºA3“í£ù½stm_°ÿ\0ÂWün³	°áqÕ(8©I²ºî6N ƒ¥ˆ¸ózz¢I˜^MbJÙ·”RmºåA6ó™©B\" \"$±´WIê½ÈQr]\0\0í&ÃÎÛÌÚå†qZºæÑ>’§š¥Èñ6¥å,q¸€T}\r#šÔé±ÌÀ+ÒÔŞB‹\rm®ù UË¨b>ÊõÈ>VU“¾ôºV¶Şç¤®ˆîz§1ümûŞSKÆò³Š»bë°§Á	‡° ±=óZW·°wè_Íï)Ç(½÷Ó©õ1£iíµ@¾E,OÕP8Ó\"VÅUiì;ª=w™ÒÆq¼¨ïÂÕèï\0O °á¡:îüç]jÌÇ¬IñááÙ8^|€¼øgÙòğ>Dù~M¡³*6­d[§õ™ÎßÙ];N‹êfg\r³pÌ{Xh<ÓÔL,!cmXöó§å	Cex–=ƒAë¿ò™<>\0\r\0Ü7“ç¯¬ÊşˆˆHÖ#İB¬Àë¡7îù‰®Ü§LZš¨<O¶Ü}ã ò”vÒÙÄv¹±ßmyÜ}$|f!‘ıšj|¸yÌ.ĞåfëÔµôÒì@ï#p‚Ó!²«líí\\3v8d_B5ó&@§Vµcj(mÅ»<IĞL“åzÕj±í\nÄâÇÊtb¹T€eÃSÏm¥!áÅ¼Áb«VÄ0]ªº’ıÈº·à`¶¦ÍwT= Ö`ÁÆ[›]†€Úq6Ã¬nxíà;ü%‹°¹¾ÄÖ·Ij)ğ€ÛÀh¾~’Ëäç ğø{§ÖøÛ¬ÿ\0ˆîğ<õ†Ùõ°Ì¦µ\'¦u3‚·±ïãİ¾nü˜ä¶&½Zniå¤K\Z‚ÙHUŞn;l5—²ìT¶é+³•x@ëÙlŠÉÎ*¶œ \"\"kœºàë[á¿ Ÿ›ÄòjĞ©LhYA; x`å†ĞrÙoar¶K/õßl8*‚\0Ğ‹iÃIar\'`¹Çb:Zd°WdĞ=õÄj|;tŞöç\"¨biÚ¢u€êºèëàßÀÜw@óÕzL‡QçÂp7^QòOƒ¹eé¨üj:Ê?æ\'qá5j˜Ã53å%à	Å”ƒb,gbÀùhË;\ZËí|ÿ\0)ÙJƒ¹²¥»Ø\\ù/õ’:‘mÂòeš=ò|ñ3X=Œà«PÙp£Ğh<5’Z½:c-!¯Ä©ÔÄV?†\n:Švï\'ÏıgpAâ{Lë©\\.®ÖñŞ|·™ív	E1İ¡f>\n%FR•e]j¨\ZåÓyìß\"âùBOU;M•E¹ĞîÕ¯2Û#›üV †Ä7F¿³?ş«óğ–O\'y‡ÃØ¥1›‹·YÏŞ;¼„‚¬Ùœ“Çbì\\tH~ A·u1©ûÖ–\'¹¹¡JÌW¤‰õ±î]Ãóï–g*ğ“V˜4Ìw °•u©‡¤Ç´¢æüV¼¯y{ÍZ¥ø\n¤(roNÍ|¡Ú×¾];//{Nº”AAlNoqH8£]ùTİüùùK7“Ü¡‡§L/iŞÇÅ¦m‰„QÂwªÚL>W„–ªå8ºŞrˆW/y#,å!âpJÜ%sÊ¾ni¹50ÿ\0CSy°ú6?YFãŞ<Á–”éÄ \"œ*l\'—¹J›ul÷ïĞŞßçIòÃ]2¶éÙÚ	×w’å}fLn\'! ‡6±¶¹A]LmBÙ‡uÈ‹6K¦M¶m\ZFÅ‰í¹½¾Êÿ\0‘üy~œJHëO§	7I¸Õl´Öæ××@<Oiv‹ŠÆ[ZŒIà7Ÿ!Âcjíb‰ ,I6»XÛØSF»SgÎÂÙˆˆ\raÜiæÓ’&µEÄÕE7¤¾Ãß?Tpí:îäJØÚ=BäıD?âs¯§¬³6$¨Ğ\\´éª6\ZŸ´w“ã6*$à E¡‚Uá$…´å8U\ZNq˜å·#q\'V½,µÍòƒ•×@8èwvùM®ÌÄ±¡Vÿ\0³é=9Wx‘e)áŒÙ–ÅUµĞÓ¯¡ü;ım,ÎLòYh%·“«1\Z“ütÚélõ$µ¦\nkjóVõ1ÍT×½¨j2•=.­˜Ó\r²ğ¾ğ4·hlš)¨\0mÀh\0Êšbr\0	ö\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" ÿÙ','Treadmill',10),('6397f350-7182-4ce0-bd6d-35e74a83fd9d','ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0„\0	\Z\Z( \Z&\Z\"1\"%)+... 383,7(-.+\n\n\n\r--..+-+---.----+------+-/--++---+----++-0+-+-----+8ÿÀ\0\0Ë\0ø\"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÄ\0M\0\n		\0\0\0\0!1AQ\"aq‘¡#2BR’±Á$%3br‚¢²ÂÑCSsƒ£³áğÃDETUct”ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÄ\0#\0	\0\0\0\0\0\0\0\0a!\"1AQRq¡ÑÿÚ\0\0\0?\0¼‰%kEÜàÑÜ>ÕúÇ‡‚î\rĞzDDD@DDD@DDD@DDE®ÆqêjF‡TÎÈù!ÇW[£Z<N>€PlQE¨·‡‡JàÑQ”FH¦Œ}i\0õ•(c\0‚:‚9z‚ƒõy»i%YOKcQ(\'3¬Dmßn§µôôòSZÚ¦ÆÇ=ÆÀ’~ÕÍÛC´©õñÏ-‹³cfŒ¿§Ÿ­·© ¶Jƒ%T\'Å#³kl×\r\Z‹eû³ØìÌ:GBğˆÒÚe{m­Ç{»=˜Q¬\"0Î!ùA£C§ojÏfÌ\Z/áÈræ¹ ØÎç¡û{(«[w»xÌA@\"ªˆ^Ftp\Zgg•ùŠ3±Ü’¶¦8&…‘üœ™ˆ:EÏ#e\0Äg’Š²šhAÎAsH±ÈæXjM/B×ìÃ+iÜ~k£hıyc‹øÕTˆˆ‚\" \"\"\" \"\"\" mîĞ|•Óf ‹†–îwÍoˆn§N‹ñ<Iï›‰U)}D…¼YÍÃi#ÂÆVùE»ªÂß6,UÙtòôõ»Ãúª©Â‡\ZwI!9A.qôjâŠØŠ`GXrxl÷†Ù_nÊ˜îÛoÅ‚	_#©m¨ÏÃ?I¥¦ù{‹yy×ì²¤—­÷5­ço Û\ZÄ8<1GƒmN¶¶¤½}j´†V½­sHs\\šA¸ ‹‚æ,½®İnÙÏI,NOÁj\ZøNq³Òy0»B=k A²|z8´¹×ÆÌy¢«f«\\Os”ÒË,¢ª¢>#Üü Æ@.$›{\\h5ûÖÛÃ|1cÔµÍ7{œÓ£€6°TŞ/Ãsé˜ÒIh!ı€\0[øMıJG¼½–dì…’>Xä‰²É–ùƒŞ×·Â\0°‡õ”tSK²sùÖî:BŠaøûéK*#cÚ5k^æ‡K	Ğk>·k¦«Š>+šZKœÏÉ´İ£)å¯K[ÈsZZ¢yéá€±l@ºö$\0@¸¹àê@¹ÊÛòXØ~\n^ÄmòŞös¹\\†–Aõf-$†	ÀÌìæÚÓ{n~ˆcN\Zî¼ş»:èã•²€ø4.\ZWNãÏ°iö-Ëğ¸p™„73ÆšòIÒÅÆî667²“ìÆÀáõbrZáÂ“\'ÅÊâ\rØ×suû¦†Èí6)>\"É%$QÈé31ÌhdlÈçGâµÃ\r\'[Ÿ%j\nè¿µg×oóQ÷gJ\0\r¨¬\0\0ªü—ã·cMÿ\0ª¬ã7ïb¨™\ZÈÿ\0´gÖoóAWöŒúÍşj7cù5ÕÍôMÿ\0¤¾nİƒ:bUş¹b?ôĞNÄÍ<œ¬/Üã¸öªüîµ¿û…W¬SŸ	yvë;b5#õ)şæ °Á_ª·vêİÓŸ×øWàİ|Ã–)(ÿ\0?á!’Š·víªºbÏõÀ>éñÿ\0wİ1sÿ\0çwİ:-jv‹u3\ZYÎ&À»(°æocÜie\n¼ÄşoşLƒìcb¶Ä$hÄY-Às%g§\\ïöYq‰Tš¼IåÆÁÒF×vnn,–õfQFTe†w·Ã˜ØÁî½½š/¬¸‹£–Y\0¹Ík\\”×4ò×‘+\\÷|Aœß°¢²èäÉİÜ>¹×Ü\n–lÅ‘|0—GÃ.Ğ‡»XÙpB5¶—òQ*:q#KI €T®dG1Â×Ç&g7‹ÆËké6i¶^¶ÿ\0d\Z¬j\\Œa{ZY™ÃÀâ\Zs´·^D}t§6K54T“Ÿ•$1½ß¤X3{î¹Š­õ/…åÏh|“ÂÛñáw=ÙnìÌØÇ±_Z\\*¼±Š*Îh,1‰²AikmoB£«‘r¯Á±6õÄë©rœîºjÿ\0„DÇº !søî”İ™\Z2øô·Ê>ŸR¼QDDDAŞæÈÿ\0HQ—F>>Ÿ4‘~p·/Ö\0[óšÕDRÔµÔ®s\ZXË‡H¶Aá‹¼´]`¨íåì#é%’¶•†Ji	tñ´\\ÆI»XîIüÛœ‚!²[XiÄ‘¹¾;óy³0ùÍwÒ:h³ë6¾PÇ4¸åxÉ‘ Ù¯áÜÍÊŒÁ‡°¿ŠÇ]§[yŸ>ËïS klÑñ—¹sO\"Z9^Ä€O+ßˆÏ³7U÷®Åg¥™¡²µï‹#İ”E%‹Ÿ#GäĞÜlîf–8èåk_™Ü@füÙ8mÌÀm¨Âıî£xÂKM†Ö×T0¶ƒ¿àñÚîãGôÏonªMº.X)f®|‚@	ÔÀ,îÆàè­k9Bı^cä=zUE£Ú-¦Š”ZÜI-£·­Îù£Ú|oS˜¶İWÈOFÀ;FÆ“ëtŞë-Kvç„æ\\OÌ–8ËO§(k½„ ¾Qiv?Ô‘T†ä.=—¾W4–¸_¨¸¸=At€ˆˆˆƒ¶ªŒÅS]É4õ6SoÙ±ZÆÆáè>Ãü®¬íø`\nÿ\0„ñu-İ„hk‡­¡®úÊ\r.ÆÃ±8¼Ã¨i1ÊsXyÆöµİÚá§$V\r‘á†Î-éÏÂnmçk­ŞÊí	9#tqÈ<.wÚ75¬O.eh)K¢v½…n›JÂÇäi}ïÌü®@V½ıªQ’Éä«’CA‘8†04”òl\Z>ï%ÔX5‚(¢dQ¿r¬÷a±rq#«©ˆÂÈÇàñ8x¯oÊ8t=uÔŸ!­°TFq=€Ãgq{éMË¢/ˆ“Ü˜œÛŸJÊÁöBŠ•ÁĞÓµ®œâç¸z!$z–ñhöÇ‚˜ÉPòÆ¹Â6×;ÄAph\'“N¾J#³ûqCiOêGõrßç~ošúïªX¤Ã¤Í{¢æµÀ¹…×0KµÇš¤ğiN]¼Ô«K„W²xc–3v8hH#‘-:0Vb„îÊaMå±ifhˆ:dysƒtñI\'­Æ¦ÊKb‚\"ü¥ÎäÖ€MÏ¹:·vfRÆ6Óã1‘{İ Ê/m9ò:ú•U[R\\\\çG)$’I=Os—ÖÖ§i¦ùÑ<“Ìç“é_-²@Ô\r,±¤Û	9¹ëóÿ\07-ÇƒCnŞ}ÊÅÿ\0Kö_×õsÊ=4ÌÃ›é ıÁcEH*_Âˆ›Ø’H°\0t½ùAn1}¥uC[Hóo\"ÜÎ¡ €\0× h!~ìæg˜RÓêÖœÕj38t£GØ-Ìë®nÍÌü‰¾êî[=šZÈÃ ±:2ò}c5š¬l:‰°Æ#`ĞjOru.>d¬•Ò2\"\"\" „o3eL…ı_iê×[0óÔúA!QA³4oË;36Ì”±ípĞ`ët:zŸc»Ë|’HÓNÂ6„Hu¸¡iæÚà›ÍtòÓÄúXÛdn.ºÁÄêĞ=«?SôÔnqk\ZÇJó kÉôÏÔ®í×îëàÖ««`ãó2s¿8ôÏözN–-%,LŒeşƒZ/ì!Xˆªˆ€ˆˆˆ€ˆˆˆ€ˆˆ9ënö¢‰Õ¸„“1ôòÌ÷9±æâZYs2íušlâÛê¡Ø3Ã¸„^×¸\0õìJ¾÷Û&\\&w‡ıVª3bpùjLcy™ÜšÑcÌıÃT«±Õ-¤{€…¾³nAFqÚ÷LòâtäaÙxŠBÈ!ƒ1sb``Ò×·[,\n‚ Â•Åk+«2Oü=,³ê—ä£òçj\ZC;½ß~£Ú ÉÁ*ß%KbÊ^eğ;.¥ òÊy‹_¿¨ZóÙŒ	”‘\03^|ûzwºZúÆã#¢l¼Wd„ØEÔé×KËÄ­ÅaDDUD@Z¥Ú:jxõRpØ\\4s‰q††´M>¥¶Q-äl_ô¬CÇàd—‰›‡ş6ÖÌÛ|®wèƒ›6³dõURFNGÔK#¨»]#‹Mˆ¸<”Óa)Üúœ=\0’	±älÌÆş T\ZÃÛO4Ôî%æ)dŒ<Xd°œºÛPM®¬ı×·ğü8vd‡ÙYï™ÔËóYè¾\"eš`öˆ¬™2 ˆŠ‚\" \"\"\" \"\"\" \"/Ç”måa¢}.pÎ#ã$ó³Y#\\âSa§™\n9E†ÅMaŒoN¤õsWêC‹Õçyö-D¤(¬Ä•«6U­Ä*$Ø[UŸ«ÊÒ3 g’À¡¡ãğiùoä_çé\\-Ú ñés;¬Jº£$€4]îÑ­ì;ÆŞÀ¥;¬¡â>z«\ZM47Ìn4–ópcG`ËwAkà\0ÛaòZ@;yr¥³^ +CGAÿ\0\nö¬AD@DDƒ¶Ï½]_ÿ\0j£ıw«u£ñ…”RŸò­÷ª»j$½]go„N}²¹Z»«Œi< ”şËŞ¥UèˆŠ ˆˆˆ€ˆˆˆ€Š¶»]WQÅƒ0Ç”â\0Ò9Xá{óÔ*ãâĞË%<ø…Q•™nèœòÂÖ¸hdT\n‹©wŸ[,mX˜t3Â3 Aık¯lŞn$ó¥K¢8Gïƒ –\'!°hê	>«[Ş}Ê–‹xø ş¶\'ş“aş¹¶û´¹°‚Û‹³(¸6ÑÁÒêˆ·U4OªáDY¶ÕVñÀÇş‰ìq_Cn$.gA©Í§¤ésêQ[üFµ±´¹Ä\0?æŠŒcN•Öo{çççåÑ`šÊšéƒ\Z×>G\ZÓÌı\\[½İÃi2ÔUYóóky¶?>ÅŞáçÍCúØn-dÃğ¹í+>p’m\Zí~ppÛs­­`nóàClÚ{0Œqc\\ù,>OÏ:ø{Yh6¶³áxÄ_â¨^şÆ¦ µ±4 AwVCÁ…Œ./u†g:ÙœmlÎ¶—6ÖİUDUD@DDDAÅøù½MQï4¿¾åon ~1§ò¥”ÿ\0¤9Š:óL{ÈóíqW>éGã(ü©%ıøBU]Èˆˆ\"\"\" \"\"\" *{8UKk¥ÉK,±Êæ–Ê\"/»œÁà\r<„\rŠu½´¨ÃLÊpÏl®qp¹3·Ğ|³ÌŠ³{ÌÄ$BI™ |Ñ³+âmò>L®³£\r\0nc¯[\" ÍVS³‰=ñ2á¹œİ.yâ ¶ä:ß«üÕí¾ŒM‘Ğ‹d‘âfx	B×´¸´é{ú@Uf7µØtŸ0Ğ˜ÜÏËXDĞ÷œIÍ£dÛçA§§kdc¤g±®.-ÌA \\ó:ñ¨™Œ¶y2ö»]öµ¤+Û^8lÄ¶îÉ#…Îe¼f9_m5ÖŞÕÇjè§ÍÀÃ$€‘ás«@=\rÌp÷¦!Êì”kÔ;|•òŸ\"íÌı,Ö´õêIĞ®8I\r{à\rµFÃí_*ZÍ2×˜¿®ıSû¹L.vÃ-TÀ5³†Ç„’_w\\r-¡ğòå{ÄMÕ|ˆ˜éècI°óÑWÛ©ÛÊÒSÒ:aì™%ğæ»‰|.½Æ—¿’øoiY•Ø~fø„o•·³Òûä  vÿ\0z¶ì0Ù\\ÁU5¸•o}T·¾`d#†Ù¡—Ğı ¬Õ^l>ÔÃ5HŠ\nw$yå.crµ\0Xİ¬\0CÍXj@DEA\n\'ª|–úNıâ®ÍĞ·ñƒu½©$×üHU8×¹¿´«›s­ü`ï*3ï–?ä¢®”DUD@DDD@DDÏı ÇÆaÿ\0İÔşõ:«(Ï‡Ûö•goêC,´±µi‰²İÏa„~-üœF]yZáWTŠas˜\rÆ HágóĞİJ¬v@Á{4kÏÎÚëë_´´&I\r…ş2ÆÒã¡<ÀM}Ë¦°ı „7%$7\0Î®vs8u»¢Í\0À[ìTr¼Ğ¹’64Ç)-hã#®ûe]b/qÏºÎÁğIªj[H\nG9í¼¡Íhs%¦À›øOK+×Øø_=MVVÈùã’2F1Í< à-˜]¤9­Q=—ØöÒ×ÉSá1ê8fÄ=¡¹mÔë};v‚;´›¸–Š’Z©*şOXísÈÖ|²ákf¿.Šµ†Š¯{ãq¹Ê×·ĞæèïeÕù¼¢¤Š¢‘•\rÈ—0xhÊö?Äü¶ÃŞ[‡–?+ß´åcÁ×‘ÈnßA±Õ%^<CˆĞÙã>3£ôÇ6ş°öª7Û‰Ÿ9\"Î¶¹@Ğš÷N\\”’<^ì1ÃGNÇ›ƒ+\'ã`™ûÁ^†æ1E9s²\'K•Å‘°Ø¥ X«Ï¥Q½İ>Ü<æ¨œ6:ˆó	/<62y]ÄºÖ==“J-óÓØ	)eoè:7~ñj«p\r›’j“†ÃQ›#Á–FYÑ‘\rÜ$Ä#y{¨ö-	â9±$m$‹ö\'Ç–æÀô+3‰:½}Mtm6õğ×\r_#\r¹:7{.Û·Ş³è÷‰†ÉoÂšÃ`H9–¸Ä‘—ØW/áğÉ| ¨¶$’M¼ k#ˆ;jß¢:Î‹¦›ò5Iú5ÃÚ?%¸âª{6ú-kØÛ]ºÍ¡ÛœB/‘Y0ì8#ê—[Ü’J:é1Pï{a±¨şHã>ö´zÜÓïÒ¹¤g†™ãÉ²4úoœÛØ–y¼Èl	ò*—¡ßã®¡#Î9ı—0}«w6ùèO)h–9xoá¶Hîòœ ˜Üt&İ¹¤–Š\Zeg +‹rìü6cÚ˜ó©.]ì[ö…}nZ$™¯¹toiŒ€Ğ×ÆZãbtuÍ¿EeVÒ\"*‚\" \"\"\" \"\"\n{şĞíğáçÎ²/ä 5KB^l1q=\Z×f> ¯¾©¬”ÓBéŒn¼4°ÖØÙÄ_QÒêıˆ¯’¢²œ–3àÍ9œÆŸ_v¸ƒab\rõ¿+¨«¾“W9¬$åælm¯c×Ô³âu\'½v—Àµ¸¶œ4x¾ß÷YµŒf{ÚÁİÄí+C_·˜l7ÏY·12dAÅiFÔlÕ?#˜\Zàæå±sCäk^Ğ×vÜ‚5\Zé×Å(ÀwC†µüiª\0şP0j.4ŒA*¢­¨k±\Zš®$Æ7Í;Úø.YìšH9e úVïc¶Òl5²ğád®’×só_@,	ææ‚ıJ*qµX\r-$Œe4\\&5¥¯Êç¹Ïq¶q%Ä4‘~FêO²»*èé#setRÈßÔZŞ–èn”ÉU4[væŠÇK|³¹ÏiÀÇ8X\0I[\\õï¤~¿hêæüµTÏî+òŸÔ7Ü¦	Şß\r’¢‘óİVÎ+•¿dqi\r$ÜXtèæ¡uDXd66ÍŞún–_´˜sæ¿Ìo¯\n7?_CRz\rÜb“ZÔ|1ô¦{î¾ÙA§¥ÄbŠ¦)£e›ã“#İ{ä-.ØèH=ô=V-plÏšRÂÂ÷½á£.VçqvQä/ky+ÜC¬f©†.â6¾Oy,[Öî>˜0…Ôgú@E—ê–ßö•Û”Ài§§ª|ĞG)€’68eáÄşN\ZêJ˜×îÓ\n›åPÄßîóGş™7böR,6Ã’IæG:BÛæ-kl@\0Y£Ş¤ŠÊ¿qøkõÓÃú2d\'Ş£õÛ‚á¯#ÊHAı¦¼}ŠíDçW¸ìE—ÈúyGKHöŸc™ozĞâ{»Äi˜÷ËFö±.sÚèœZ.\\KH\0kªê¢TWl±Ê\'RUÀú¸ƒ¤‚Xì×µÎØZ4¹êƒ˜¡\08zGÚ®=ÅÍQåµßìª&S¼—$‚lZmsåÎÊsƒíE$Ml\r…\rs†0\\Z]™¢Í xyoÍ\'­WD\" ©÷­ˆÆ<O†Oï#ÀZ¯<. É28\0_@äš	ı5V£)D@DDD@DD&ušâ:}Ë™êöúº %L€ºß‘‘Ñ\r|™Ì.†Ç°ªÚ+¥h\0Š•ì\ZÚ÷kNWrê\rµî ÎÜ¥pá4Ío;x/{ı,¶·–TÔ÷qÌ÷f=\\÷}§U•C†K7ä`|İ/oxö´+ÿ\0İõ\r#ÄŒˆ½àX:Wsë—äßÎÊR´ºç¬?w”Ÿøqï,Œo¸ïrRnfwXÍW}ÄqºOPs‹>Ås\"\"¼Ã÷?BÏÊ¾yÏç<0z„`z’áû‡Ác7œæ»ë>çŞ·Èƒñ\0\0\0\0r’ıD@DDD@DDõ§¦©…„K‘´ºöì-Û[\\ªB}Ùb±Y(äxs[Ñ&U\"\nSİ%[ÿ\0+$P7°¼ú¢Íı¥)ÃwIFËq¤–sÔ\\1¾Æø¿iXHƒQ…ì½=¸4±0}w]Şõ·D@DDD@DDD@DDD@DDD@DDD@DDD@DDD@DDD@DDD@DDÿÙ','Bench Press',5),('69b79df8-a56f-45af-961b-8b176a6134ad','ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0„\0	  4%$&1 %3$1+.000+583-74.0+\n\n\n\r	\r\Z\r+++++++++++++++++++++++++++++++++++++++++++++++++++ÿÀ\0\0À\0À\"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÄ\0?\0\0\0\0\0\0!1AQ\"aq‘2B¡±ÁRbrÑá#3‚²ğ’Âñ4ScsÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0!ÿÚ\0\0\0?\0î(ˆ€ˆˆ‹ v§–§«°{$\\‚ÇÕGÑÖÖ<ghtİpCü”ÆÔP©Üí´‡·ó7öº‹Àñ&²7\r5\0´8åñ²*ºœ@f{AcZÛ‘˜Iß}B™Ù¼EÓÃ™ú¼\r…¯È­J\\I ¿7W•î»\\çG,‹Of#HÁ¼n$4ğ6Ô|[‘eVVQk>ºì®•ßt½ ú*ÿ\0Hm©û4Ù‰íµ„‡¹„¥µĞØ®II³Õs¹¬ê·™$¼M#™ÍôAŞªñcşl¬ó<5r­¤¬–9Üi« t.s²1»Û~bÅMìæÈáôÄKUUó\r{R4FÓàN¾ks­Â™„r@×‡´0´œ÷ÖÖæT)ëßf‰ŸmKªåg^\no’~Ñ61‹5Ûd»omÄ¸æ*Ÿ·ÕĞÏ4RSÈÇ´Ó<hğãc¯ë÷³8,úÚÖ=TaçıN·ËÕr¢«V6H$ÛœÓv•îª»g„Ác`ÈÚ,\ZØŸ`=–µø}AË\rSïºnÇ\'\0‚qe`\"ÊÂÊ\"Â¢ÂÊ\" \"\"\" \"\"ªc»OU3¦’G‡8\rR¹\\+Z ã[WÑÓéb|ğM6¸8epÔ5#0—@÷LÙ™P\Z\0c]œs—îõİ«é4O‰âì{KOTZ®‹iº’Øå]rZ÷[(î°à‚™‚ì|µÙLtÍ¦€o‘ÅÇ?™ßä¯İÒ4Èòm­ƒĞ¨Ú¹èÚLA„Ã{6P.@½¼ÇÅtêZ–JÆÉÃØápæ›‚ƒŸâ>7u”dš.xÚà|íôU¡¥…‘HÉğ³ITØ–+²\'?¿İ²í‹Îhö–½¡í;Ãš’9²;]ˆRBÉ*#|ô%Å¹·º2;øxÕğlb\n¨Ä°HŞ\"ı¦N¼X|-ŒÂØ˜Øµì\0Íwè¨8ŞÅTRÈk0‡–8jè/ÙpäŞ” é©{\'·±T¢ }š¬;²×»ºûqWDE”A…”DD@DDD@DDD@Bˆ‚áTÀè§`{Kßùšnu‚¤TP×`Ò`&¢ˆ»´Ó¸xñÑ0wvÿ\0Ñÿ\0ÜVëØ ‹ƒÀê\n}›ÚZzÖf‰Öxö£>Û?QŞ¦ÕØ6¶¡•Tot8—1†ßèı›ÄzÁ‘ÿ\0Í^ûÿ\0d—B‹(*ûY±tõ£1U@\ZJÑ¯õ*¯‡í-n#i±&™`ÜÉ‡h†øñÇUÔ­}S0Ç+Œ<ãÏÅhk#š6ËÃØá¡VÊ®Ié—t.=¦òıÔü‡´9¦àè= \"\"\" \"\"\" \"\"ñª›#şM%iãxÌT±:YI°ÜÖ‹½Şs¥é³Âè¡‰ÌÌEË©o-]6s‰®- >Mù…†k•d_:AÄY€Ç­û. à¯HsŒ¨Í€³æAÔÔ.7FE§G4İÖâ9­<Clé¡êËƒÜÇ‹‡´Şğ¦(q8\'Â‘²7ÃÁ¦T%Œ;È­µ‡¦gÅî“§İú)´E”sDÒ×‚>ó®§vëİ§üæ¦ÔV3¬”hC­ú|~h%VWœ/ÌĞîbëÑiâu‚(Ëís¸en*®ÙUÙÑÅ~Çä>¨*[I…šŒòµÇ¬v¦î$y_ä¨5îc‹^,xtjZ‚\\ûèÓ’×Å°¶LÓ§kÒÿ\0º»P\"”¨¸RĞ¾7Ú³¹•ŠaS±îËPöÇÀ\0Ğæw;OŠÑ8y6Í4çy\rŠ‚~²¡ÅŒ\\µ¦úéoUøÃ1“M {ecà^ı:1}	ñu×áôì³EíÉtÙİ£Š·ªx ºå¤Äïÿ\0<UÍ¥|Û°ØƒàÄ©C]–9ek\\=ÓÈüWv;G+MË!kK	k®7_š	Å•…”^Ñæã[¨[®îÅ¹<¿U¶´pÃÙş–ş‹x \"\"\" \"\"\" .UµX€’ªSœ´5Å¢Çxn‹§WK’)=ØŞ}×ÄXD„öiñ¸A·\rI¾“Üæ)\nyd´æ‘ÜÛš¯5nRÔ¡İòAârI,‚;5 –Û(»í¾åDÅ.aÈ©<~Œ±æfû=¯Âş~j\Z¡¾ót<móAû”ÿ\0U«\"ñ’¿ß$7²ÈÂN„ç]uAû¢”6¦•À‹Šˆÿ\0Ä®=3T˜±(^Ó¾š2ly9Ê³„amûD:æ²ŞªÕÓZêèÁ-¦Œ[Ô ºôo¶‚­‚g^p;.:u­î\nú¾U¤®4ó5Ì%»Æöºú¾ƒØ}§ml¢ì;~÷âÅ`¢ò«”27¸ği>®ë/©R\n;aë¿Aè€A”D@DDD@DDU1gcÙ÷šG¨\\{h\Zs‚EœÖ†<~&è»2æ;y••gAw\\¼‘¿ÅQ«Ş ¿sÒ–- Ø‚,A^´ñ ö0µÂí\"Äs\n¡‰Ğº–›–ïiæ@¦§¸²ÕÄğá#í\rÄğ(9ô.ÊtÜx/id^uP8´‚,x¯:—833@$oÈ\'v.˜Ë]w€ëŸçÒx—©p:dĞ~ŠO£÷º«\0XÒ-½Û‡Äª,M#œçf$“ÃRƒB¾NØü¿U=±›E%4Ìsg4é}ÎZ{ŠŒ8eìMüÖFébƒêªOì¸j8±ÜA^Xìİ–D7½ÚşFê~ƒÍqîv¿ìódÿ\0îË&º1Ûƒÿ\0UÓèqê+NSœîÒ5`Œ^ıî½¹† °ÒÇ•m¯ŠöXY@DDD@DDD@\\·hÛ×b¬gşöL£èWQ+™àíëqf¿xÏ#ÿ\0¸˜AbÛ,;zöÓE¼Ş~J£Gë*>7…}^±£øN:ş°%l±æ·àqà¿U1]‡»T÷k0ËÚF‹l7ÓÑTã¸9wke|Úê€Ø„~ûœ¬n«¸Ş”¶P4>Ğïàƒ{Ä\"m•ŒÈâïü-¿¦ª½4¾kÆæüV”Õñ‚EõÈ=óÉk½ë^LDÀ­gÕ;’(*rÈIÕ¥Ä8-ºîıbpÈ%eÿ\0ˆ\ZÌ ›ŞºŞg_%óÿ\0Tx+.ÅãrRÏÚlæ:à}æûÍóAõ-#¦O»^/ŞVò\" \"\"\" \"\"\nÙ2Ç#¹1ÇĞ*ÀÇš¶WıØ© ~ªå´²å¥œş=tU®Œâÿ\0¹“›˜>eáxÕÓ6F8\\½ÑB]ÌñaûÍä¶ËT®-CÖ²ÃG´İ®äåM.vE.99;Åpùd{§p \\åÜBÔâê×;0\"Ä¢ìõxcÈØZkôĞõJÚ&9ƒšÖ€ğ\rœ¬îÁ6–SËK¨ÜN˜æh$;~›Š•5,„H%mÍˆ“ÁZ0b²JLvoVôh4YLãÂËÓìÿ\0¾ò¼Or\rWBò’\\¶pàŞW(ê‡›Û’ßĞ¾.é\rLãZÇ‹{-qĞ—¢êkç6‚¢‘òc$ÈÖ›uyÃƒ~<WpÙ,Z¦¦7º¦œÀC†[‚ÜâÛìPO\"\"\" \"\"\" Ç©úÊyZÎ[ÎÚÛàªVµ²M6.±™\Z~*³W³9g5ÎyŞ¿v…™eSaÚ¹[PúWµ²ÌÆİÍmÃ€ç¥ÇÉKÓm4ÑÙ£?‰·Í·A4 ñÊbÇ}¥‚öÒFy¼ü”´Q¼]kÇs^Æû­­÷ …ep’7Xë•W\\]@1İÇ½ibâš`èˆt.Ía~\0ê†!´°å.mËí£H¶½å[È9æÔaımlã1c´³svï¨Q”˜LŒqk$iRmÉM™Iy{µqq\'Ä­èc™n’L¤ec38æÿ\0•~x²é˜;NËNwÛr·Òt‰ÈÒã‰ ^ò<4ú•ˆàV®ë»gBŞ©ı“ã¸ ­ÔÔp½Ï%ù…Ç™%mœ07W;^dY]z>Ø·ÕKÖ\\ÙcÆÜdŞŒ°¼½¢4&·w¿aó½t@µpÚAcŒXRy•¶€ˆˆˆ€ˆˆˆ€ˆˆ<ÄM¹vQ˜ñ¶¥xÔPE\'·\\yÛ_U´ˆ jvf3¬otn¸Ôï¿á6]‘Ñ²v–¸[3Üâæáoª²¢iì“`ŒÒHç¹Î’ùCmÈyªF!O,GV7˜_@‘}ëB«§“ÚˆkÄv~H>|’É#XÈËç\0¬.W_ØÍœ–’2r´Ìûfqà9ëˆlD9Ì$n-¹òµ•cğÜIÓ‰\Zù ¤lÍ¼r—9€j|Pt1§Ú}»š™Â!>Ósx­ğ²‚¯W°ÔoÜÒÏGŠªÂªh¥dT&Bé2Üˆo[{v q]bÈ#ğ(jU ’{»3›ìïĞnŠ\"\" \"\"ÿÙ','Stair Stepper',4);
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
INSERT INTO `FitnessClass` VALUES ('74bee327-d993-4fb7-8215-bac6ccfe031f','Yoga','MWF 6-7pm');
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
INSERT INTO `FitnessClass_Customer` VALUES ('74bee327-d993-4fb7-8215-bac6ccfe031f','e44ebec0-7574-4dbf-9309-2d8c1936ecbc'),('74bee327-d993-4fb7-8215-bac6ccfe031f','jane-123');
/*!40000 ALTER TABLE `FitnessClass_Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FitnessClass_Trainer`
--

DROP TABLE IF EXISTS `FitnessClass_Trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FitnessClass_Trainer` (
  `FitnessClass_id` varchar(255) NOT NULL,
  `trainers_id` varchar(255) NOT NULL,
  PRIMARY KEY (`FitnessClass_id`,`trainers_id`),
  KEY `FKjf88e4ol2m5d63jk0bisl1lhu` (`trainers_id`),
  CONSTRAINT `FK8gu03u7hcrxksc5rjdejv6fsh` FOREIGN KEY (`FitnessClass_id`) REFERENCES `FitnessClass` (`id`),
  CONSTRAINT `FKjf88e4ol2m5d63jk0bisl1lhu` FOREIGN KEY (`trainers_id`) REFERENCES `Trainer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FitnessClass_Trainer`
--

LOCK TABLES `FitnessClass_Trainer` WRITE;
/*!40000 ALTER TABLE `FitnessClass_Trainer` DISABLE KEYS */;
INSERT INTO `FitnessClass_Trainer` VALUES ('74bee327-d993-4fb7-8215-bac6ccfe031f','32d65641-d33b-4487-bdf3-9068f5378371');
/*!40000 ALTER TABLE `FitnessClass_Trainer` ENABLE KEYS */;
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
INSERT INTO `HealthInsuranceProvider` VALUES ('83005d03-a927-4684-b6e7-6edb892ffded','Blue Cross Blue Shield'),('8b32ad9f-4492-4dba-82c6-a36dad3da35e','Green Cross Green Shield'),('a06420f0-e7fa-4094-8643-00878590dfae','United HealthCare'),('ab5662eb-2c5f-4e56-a64b-919d50bc1fb5','US4UB6VU588HCUOO76');
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
INSERT INTO `Manager` VALUES ('684154a6-b704-4ea1-afd6-aa9cc67cbc2b','itrjllManager','87e075f5-503e-4966-b496-b5ddb8faefb5'),('7e1bfe77-2a02-43f7-b8a5-017ec837ac27','itrjllManager','0faa5e0a-de8e-4419-b64c-416fbc68c5a6'),('fdcca4b3-45b9-4ebc-a9cb-b30c7f279339','testAcct','f158e613-eb53-48a1-9e0a-c5e89e1ab68f');
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
INSERT INTO `Phone` VALUES ('18076f56-1ecc-44ff-8103-edd5c0af60f2','555-555-5555','mobile'),('1e7c5f4c-cf2b-43ed-b2a9-9bb72715382a','555-555-5555',''),('49c95943-5ccf-4c26-b3c7-645df422e397','555-555-4444','mobile'),('4cb78cca-10b2-4706-873f-dff46ba2f4d7','555-555-5555','mobile'),('c154384e-0a10-47ba-860e-27c3b2612c8a','5555555555',''),('f001ab7c-d298-45a6-bfe9-221d5d0bff78','555-555-5555','mobile'),('f47002c5-84d3-49ae-a7c3-ed3e1e7cd2fa','555-555-5555','mobile');
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
INSERT INTO `Trainer` VALUES ('32d65641-d33b-4487-bdf3-9068f5378371','','','itrjllTrainer','e436fae0-f25f-4e6d-b0e2-125e7836d869');
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
INSERT INTO `UserAccount` VALUES ('DWG9VQL02PENDR2W2G','ea8b442b-68a1-423d-a965-8d6159cedeea','Â@\rhÎ´)¡ƒ‡ÜCŸ©>mÕa»ÚK’Ëy×—','Ir	ÜyrÁT<:òÆhJÁ5›'),('itrjllManager','6a2b0888-2ec8-4200-88c1-4f99d69d1d6f','ĞéÿXMë4åŞ‹mVòf•Ébø0…>H×\"*Ö™Â','Ñ«ó|C……¼PƒàüÇv`†X~'),('itrjllTrainer','a9433520-6c20-4ffc-be05-fe8e127b221a','C\"—¡R6*\rºÔ±u¨©ÔorÇs5(¹d7mk','D„¯2»l—Æ‡­e×Øû'),('jane','e9ece08c-65f6-4597-94c2-85e2e038fd23','Ÿ¨(İ0\nÄŒf,`põ_}ó˜F4HöÔ<›È',' ybu¬®‘¸1µL3ª€úô'),('john','f95e35ca-8f62-47cc-9662-d6027dfb3a15','É-àÎäÛçú±»ß=,\0}G•Œõ)t6§ªOj´(','ŒEe G\n†`HoÖ]Ö·|Õa…ô'),('testAcct','c8f8e809-11cf-4080-bf47-616a32b4c5aa','‡{÷m&sÛ4qı˜A×è³o\'×qĞúïö£bêØeş','\rß \\‘wûfñæS:ÁÜóó\Z¶');
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
INSERT INTO `UserInformation` VALUES ('0faa5e0a-de8e-4419-b64c-416fbc68c5a6','Isaac','Trujillo','3bfd50e3-6943-4c76-950a-17e56de142d2',NULL,'dfd2e295-9be7-4016-a68c-03a2a65cae31','83005d03-a927-4684-b6e7-6edb892ffded',NULL,'f47002c5-84d3-49ae-a7c3-ed3e1e7cd2fa',NULL),('5edad9d1-4242-442e-b69c-c74ec6f16725','John','Doe','6a169f86-1a55-4962-9e5a-4b12d15553d0',NULL,'53afeb33-6819-40df-be9c-268f98c659b2','8b32ad9f-4492-4dba-82c6-a36dad3da35e',NULL,'c154384e-0a10-47ba-860e-27c3b2612c8a',NULL),('7e66a7cc-f4cb-4f7d-8726-0ab23a207ff1','Janet','Smith','7e26562a-caa7-4d6e-aaba-375b99308dc5',NULL,'5a1c87be-790e-46fa-9dcd-5211a7fb3140','ab5662eb-2c5f-4e56-a64b-919d50bc1fb5',NULL,'49c95943-5ccf-4c26-b3c7-645df422e397',NULL),('87e075f5-503e-4966-b496-b5ddb8faefb5','Isaac','Trujillo','751cf914-793c-4de8-b617-2b05f5f7fc25',NULL,'1d6c49c7-1ac1-44b3-9dcc-5eaa347c20e3','a06420f0-e7fa-4094-8643-00878590dfae',NULL,'4cb78cca-10b2-4706-873f-dff46ba2f4d7',NULL),('d4b58776-f2de-41f9-aa04-4123a8cd30db','Jane','Doe','677a7500-d7d6-43f1-8ec9-b06955c660cc',NULL,'b52d1b52-bc08-45dc-8ce1-369823661ebb','a06420f0-e7fa-4094-8643-00878590dfae',NULL,'1e7c5f4c-cf2b-43ed-b2a9-9bb72715382a',NULL),('e436fae0-f25f-4e6d-b0e2-125e7836d869','Isaac','Trujillo','d615a615-3721-4be9-9868-c91feca7dc75',NULL,'b550d61b-e964-4490-ac23-10e44e7406cf','8b32ad9f-4492-4dba-82c6-a36dad3da35e',NULL,'f001ab7c-d298-45a6-bfe9-221d5d0bff78',NULL),('f158e613-eb53-48a1-9e0a-c5e89e1ab68f','Isaac','Trujillo','283627e6-5732-4808-830a-d87297476749',NULL,'b932108a-04e1-46e1-82ce-22431d5d9a59','83005d03-a927-4684-b6e7-6edb892ffded',NULL,'18076f56-1ecc-44ff-8103-edd5c0af60f2',NULL);
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

-- Dump completed on 2017-12-06 20:54:22
