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
INSERT INTO `EquipmentItem` VALUES ('1d42155e-b39e-4d27-83e0-30f7d54045f0','����\0JFIF\0\0\0\0\0\0��\0�\0	(!\Z%!2!%5+0..383,7(-.+\n\n\n\r\Z+ &+.7-70-/++//65+++7-7-7+02+.+--+-+-+--++++++7--/---��\0\0�\0�\"\0��\0\0\0\0\0\0\0\0\0\0\0\0\0\0��\0G\0		\0\0\0\0!1A\"Qaq��2BR�#br���3s����S���$Cc�����4��\0\0\0\0\0\0\0\0\0\0\0\0\0��\0\'\0\0\0\0\0\0\0\0\0!1q�a�\"#ACQ���\0\0\0?\0�b\"\" \"\"\" \"\"\" \"\"\" \"\"a��)��B�P�E����|�P4:�\r&K�JTޣ���Y��E���[kl6\"�\\EM\Z�c��\Z\"y\0ݼ�b��6�caQ�;�Fڙ�y���j0��������ƺ�g	\'�]	͕�=��N��%����49k�{e��w��^򶓰���?���{�EЛ�5kT�ː_�*�<\n� @���̗mI��QX]H#��Q9�*ro�����uhը)�R��A2�%�g���\0�A��z�I{>�D�DDD@DDD@DDD@DDD@DDD�����,�7�c�*��ax�R=�xn�|���g/�֧S�b�`+��ʦ����r4���ͪ*��o��I΢�@�-��6���Y��&��i�7Ы+\r�xuV��nW��e�8�����so.<��ߤ��,W�y�6,O,������ܺ���C�P����<&�Ce��:SU��6(/�����Jl9pE�W-�[�����k�)�5f��d�������nw󫿺)6��\\�5*�\0�(A� w���!X�=Q��X�-���\r/���>c�>>��>�_ە��3u?d���������=EȼQ���u&�0Ok*�?1<��j��H��.`7��$�wS\0)���f�z�0\r�Q�`o����:�/�8,RU��i�duWF�R<A����G�T�g���5}EJ�̴8^W�r�����r�\r[�lئv]z#��!�\r����U��;3jīj|m R�V�\\�園nIcsr���rOl�[a��,����.v�����߇Il��K�l�QaB\nO���̻���e��M\\N�}�2����Ўè�{r,I�k^�%L+�bT�A�.��y/G�r�cr��zq�3��f6}d�9h`�֪�~�w��=$����v8���~N���]<Uu���sCy6�(j.���r�Q��g>�<��+מּ]p�f?ǌ��?\r����+5T{YQU2mH;��u=�i���^�O.&d�h��(V�G[�d��N�\0�|��ج�t\"�;�������<��Y���y��q��Ռ���&r��v���{�G7\r;I��ΤL���kꏇ����n�b���Vazt-U�3��K�f��wp]���>���*h{3*�m�y���\"\"\" \"\"\" \"\"\" \'�`$�\0�\'@\0�I�f�Φ$��u\Zt�)!�\"�@{�+8�C�-�G��+�j�~tԁ�f�&4Ju�w�D_�|�)D�k���\\��2n`b��aq}�h�����=`o<�熵zMOG����B��cu�W%���U��g=\"SP��U���\Z�5�����P�֗�j��S,~SOd����Hro�������ҙp�ͬ\Zäe��}�[�	��S��X�1$��[�wM�JS[\\۲�&\\���Vͫ��Q��ݪ�Gf`�e�qb\0$�; QX`�@*��Z�a{\\��zM��;�D���Q�*�-`�d�iOg\rx�e���fT�AZ��T�ʮq5�Q�?�����MR+Ӫ�� �>P:�u\\�\08\r&�̬�T�Z���4b/��ɸݒi�%_���\0���$j�jy����1\Z�˗������T����(k�K��\0��v~��UM8�죴��M�0��ZT����}I>�����}!�вRx�B��}��ǌ �@sY���鷿\\\n�~��/���1�(l�s�o�<��$�����h�-D@DDD@DDD@DD���үLӭMjSoiC)������ظ\\8�=\Z_����\'�@M��MЫ�����@��Uu�q��/��M�A۸.�\rZ����\'�)��3(\'}�����l� ��mQ��Q�Yg��i���笺���ކ&��Q_ʢe�T>k��+`h#SUj�_�����g.�X����$k6y^s���W�i=TCW:�V��� �r($���x\\@�v�_ҫ\Zϐf���%-�\'>@3�{_�F��E�T_��ܶ76;F�PȔX^�]���s��f�y��.���k�*�AO�IށF��zl���)�V���8k\0����,�Z�aF�5l\ZiQ-t����/��΂UT�zGWFe+𺒬	�t\r����|UAF�\n�fw<�&�񽄾08QJ�R[�DT�dE����3X���l����<��ao e���k	�me�j�Q�s�+M�,^\\mZ|*Q\'�Su���`y���[i��jh�\0��}g�m�}���32����+��q͛[\n���.�P�֪�XhMU5��zNy�\Zݨ����@x�S����3��ϣX]e*#�>��*��� ���N���(>r��|����\Z�Un���P���H\Z�a�=1��x���|�NK!��)O���e����#�e ~�J�\0gc:\Z���\0wQ�8o�..0=&��7Ҫ�����e��r>e����bb�+��Xj�^�2~�A��y����	E��˴p�~:<�Tc�ߔ�%E��Xn�\n��R�?�����\ZV��hBTF,�⥎k�K1��ʃM\'�U�.8�)U����\'1=.S�I�)����>��NK�^���D��5�p�]6�ť��,�w��A�Y�\rN���{� ��w0 �c<s���kU�A,���� zS��gI����j�|�����eͧ/fa+�j5]��IM{��\\�����;W��s��S����&��>�by��V5H�:3�JV���D۶O=���r�E֧��[z���9��fي�\0�b)7�����6]�ˍ�����@�ܩzM~�ټ�!s���v>,u��\0��S�X��z+�lF}��=�S��5?�g�h��K癜Fm��U}H��\0�\r�\" \"\"\" \"\"\" \"\"\" \"$l~ХAsV��׵�(��`I���u0��(+�n��ӿ{0����F�<�c��+�	�LY����<V�.�n>��Z�S^�`�ԙ�m^s�n��vR]/����yC�v�f,��\\�7.O�o;�q�u�~&�:@�v�;8���p�tV�c��bX\0/�<�k��C���K33bm��$��y:�&�v=����G�	8\r�j���;�y>��B�\"`ڒ��\Z\"�>�nlñ�����ζ�Q�����@��u[������k�ԯx���)���Th@�����2b���`�V��z���5��}d�S�U��)�\Zd�Uԩ�����G:��\"�&7�NV��I��_��L�5�t�_��O�����r������,Ng�f�9��\rH�_BA��m}e�N��s��������­EU,�*�I$�\05$��@�O����h�k�e!u�f���y�mns1�n(�P^�m�\0|����IK�uE��*�34���n\n��,��|*y�p�\0�gjm2͟]���o\0.Hۦ>�1��N�\n8����\0o07��V:��,���n�o�lf��6�g-Z�Ts�SQ�q\'��mw-�ʅ���W�u�L���5��&�%ϲ���ss�?���O�Z��U�L���|��\Z�\0��p�L�x->^|&�\\�@�l�u�����o3\'��j5�6�0)�w\Zw��%ogu��\0o3$�U���a2�#=��t�]�@���;c#2位��m�n�׶��j�V���A3����stm�_��\0�W��n�	��q�(8�I���6N �����zz�I�^Mb�Jٷ�Rm��A6�B\" \"$��WI��Qr]�\0\0�&������qZ���>������6��,q��T}\r#�����+���B�\rm���U˨b>���>VU�����V������z�1�m��SK����b밧�	������=�ZW��w�_͎�)�(���ө�1�i�@�E,O�P8�\"V�Ui�;�=w���q�������\0O���:���]j�ǬI����8^|���g���>D�~M��*6�d[����Ύ��];N��fg\r�p�{Xh<��L�,!cmX���	Cex�=�A��<>\0\r\0�7�篬����H�#�B���7����ܧLZ��<O��}��v����v���my�}$|f!����j|�y�.��f�Ե���@�#p��!��l��\\3v8d_B5�&@�V�cj(mŻ<I�L���z�j��\n����tb�T�e�S�m��!�ż�b�V�0]����Ⱥ���`���wT= �`��[�]���q6ìnx��;�%�����ַIj)����h�~���� ��{���۬�\0���<�����̦�\'�u3�����ݾn���&�Zni�K\Z�ِHU�n;l5���T��+��x@��l���*���\"\"k����[ῐ �����jЩLhYA;� �x`��r�oar�K/��l8*��\0Ћi�Iar\'`��b:Zd�Wd�=��j|;t���\"�biڢu��������w@��zL�Q��p7^Q�O��e��j:�?�\'q�5j��53�%�	Ŕ�b,gb��h�;\Z��|�\0)�J������\\�/���:�m��e�=�|�3X=���P��p��h<5�Z�:c-!�����V?�\n:�v�\'��gpA�{L�\\.����|���v	E1ݡf>\n%FR�e]j�\Z��y��\"��BOU;M�E���կ2�#��V ��7F��?����O\'y��إ1���Y��;����ٜ��b�\\tH~ A�u1��֖\'���J�W�����]���g*�V�4�w ��u���Ǵ���V��y{�Z��\n�(roN�|��׾];//{N��A�AlNoqH8��]�T����K7�܎���L/i��Ŏ�m��Q�w��L>W����8��r�W/y#,�!�pJ�%sʾni�50�\0CSy��6?YF��<����Ġ\"�*l\'��J�ul������I��]2�����	�w��}fLn\'! �6���A]LmBهuȋ6K�M�m\ZFŉ����\0��y~�JH�O�	7I��l�����@<Oiv���[Z�I�7�!�cj�b� ,I6�X��SF�Sg��و�\ra�i�Ӓ&�E��E7����?Tp�:��J��=B��D?�s����6$��\\��6\Z��w��6*�$� E��U�$���8U\ZNq��#q\'V�,����@8�wv�M�����V�\0��=9Wx�e)�����U������;�m,�L�Yh%���1\Z��t��l�$��\nkj�V�1�T׽�j2�=.���\r���4�hl��)�\0m�h\0ʚbr\0	�\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\" ��','Treadmill',10),('6397f350-7182-4ce0-bd6d-35e74a83fd9d','����\0JFIF\0\0\0\0\0\0��\0�\0	\Z\Z( \Z&\Z\"1\"%)+... 383,7(-.+\n\n\n\r--..+-+---.----+------+-/--++---+----++-0+-+-----+8��\0\0�\0�\"\0��\0\0\0\0\0\0\0\0\0\0\0\0\0��\0M\0\n		\0\0\0\0!1AQ\"aq���#2BR���$%3br�����CSs������DETUct���\0\0\0\0\0\0\0\0\0\0\0\0\0\0��\0#\0	\0\0\0\0\0\0\0\0a!\"1AQRq����\0\0\0?\0��%kE���ܐ>��Ǉ��\r�zDDD@DDD@DDD@DDE��q�jF�T�ȁ�!�W[�Z<N>�PlQE����J��Q��FH��}i\0��(c�\0�:�9z���y�i%YOKcQ(\'3�Dm�n�����SZڦ��=���~���C�������-��cf������� �J�%T�\'�#�kl�\r\Z�e����̐:�GB����e{m��{��=�Q�\"0�!�A�C�oj�f�\Z/��r� ����{(�[w�x�A��@\"��^Ftp\Zgg����3�ܒ��8&������:E�#e\0�g����hA�AsH���XjM�/B���+i�~k�h�yc���T���\" \"\"\" \"\"\" �m��|��f ����w�o�n�N���<IU)}D��Y��i#�ƎV�E����6,U�t���������\ZwI!9A.q�j�؊`�GXrxl��َ_n�ʘ��o��	_#��m���?I���{�y�y�������5��o �\Z�8<1G�mN�����}j��V��sHs\\�A� ���,���n��I,NO�j\Z��Nq��y0�B=k�A�|z8�����y��f�\\Os���,���>#����@.$��{\\�h5����|1cԵ�7{�ӣ�6�T�/�s��Ih!��\0[�M�JG���d셒>X䉲ɖ���׷�\0����tSK�s���:B��a���K*#c�5k^��K	Оk>�k���>+�ZK��ɴݣ)�K[�sZZ�y�ေ�l@��$\0@����@����X�~\n^�m���s�\\��A�f-$�	������{n~�cN�\Z���:�㕲��4.\ZWN�ϰi�-��p��73���I����667�������brZ�\'���\r��su������6)>\"�%$Q��31�hdl��G�Á\r\'[�%j\n迵g�o�Q�gJ\0\r��\0\0����cM�\0���7�b��\Z��\0�g�o�AW�����j7c�5���M�\0��n݃:bU��b?��N��<��/�������W�S�	yv�;b5#�)�� ��_��v������W��|Ö)(�\0?�!���v�b���>���\0w�1s�\0�w�:-jv�u3\ZY�&��(��oc�ie\n���o�L��cb��$h�Y-��s%g�\\��Yq�T��I����F�vnn,��fQFTe�w�Ø���/�����Y\0��k\\���4�ב+\\�|A�߰�������>���\n�l��|0�G�.���X�pB5���Q*:q#KI ��T�dG1���&g7���k�6i�^��\0d\Z�j�\\�a{ZY����\Zs��^D�}t�6K54T���$1�ߤX3{��/����h|������w=�n��؞Ǳ_Z\\*����*�h,1���AikmoB���r���6���r��j�\0�DǺ��!s��ݙ\Z2����>�R�QDDDA����\0HQ�F>>�4�~p��/�\0[��DRԵԮs�\ZX��H�A�����]`����#�%����Ji	t�\\�I��X�I�۞��!�[Xiđ��;��y�0��w�:h��6�P�4��xɑ�ٯ���ʌ������]�[y�>��S kl���sO\"Z9^ĀO+ߝ�ϳ7U���g������#ݔE%��#G���l�f�8��k_��@f��8m��m����x�KM���T0��������G��on�M�.X)f�|�@	��,����k9B�^c�=zUE��-���Z�I-�������|�oS���W�OF�;FƓ�t���-Kv���\\O̖8�O�(k�� �Qiv?ԑT��.=��W4��_���=At����������S]�4��6SoٱZ����>������`\n�\0��u-݄�hk������\r.���8�èi1�sXy������$V\r����-���nm�k����	�9#tq�<.w��75�O.eh)K�v��n�J���i}����@V���Q��䫒CA�8�04��l\Z>�%�X5��(�dQ��r��a�rq#��������8x�o�8t=uԟ!���TFq=��gq{�Mˢ/��ܘ�۟J���B����ӵ����z!$z��h������P�ƹ�6��;�Aph\'�N�J#��qCiO�G�r��~o���X�ä�{�������0K�ǚ��iN]�ԫK�W�xc�3v8hH#�-:0Vb��ʎaM�ifh�:dys�t�I\'�Ʀ�K�b��\"����րMϝ��:�vfR�6���1��{ݠ�/m9�:��U[R\\\\�G)$�I=Os���֧i���<����_-��@�\r,���	9�����\07-ǃCn�}���\0K�_��s�=4�Û� ��cEH*_�ؒH�\0t���An1}�uC[�H�o�\"�Ρ��\0נh!~��g�R��֜�j38t�G�-��n�������[=�Z�� �:2�}c5����l:���#`�jOru.>d���2\"\"\" �o3eL��_i��[0���A!QA�4o�;36̔��p�`�t:�z�c��|�H�N�6�Hu���i�����t����X��dn.������=�?S��nqk\Z�J�k���Ԯ�����֫�`��2s�8���zN�-%,L��e��Z/�!X��������������9�n���ո��1����9���ZYs2�u�l����3ø�^��\0��J���&\\&w���V�3bp�jL�cy�ܚ�c���T���-��{�����nAFq��L��t�a�x�B�!�1sb``�׷[,\n���k+�2O�=,������j\ZC;��~�ڠ��*�%Kb�^e�;.����y�_��Z�ٌ	��\03^|�zw�Z���#�l�Wd��E���K�ĭ�aDDUD@Z���:jx�Rp�\\4s�q���M�>��Q-�l_��C��d������6���|�w胛6�d�URFNG�K#��]#�M���<��a)���=�\0�	��l����T\Z��O4��%�)d�<Xd�����PM���׷��8vd��Y����Y�\"e�`����2 ���\" \"\"\" \"\"\" \"/��m�a�}.p�#�$�Y#\\�Sa��\n9E��Ma���oN��s�W�C���y�-D�(�ĕ�6U��*$�[U����3�g������i�o�_��\\-� ��s;�J��$�4]�ѭ�;�����;���>z�\ZM47�n4��pcG`�wAk��\0ہa�Z@;yr��^ �+CGA�\0\n��AD@DD��Ͻ]_�\0j��w�u���R�����j$�]go�N}��Z���i<����ޥU舊������������]WQŃ0ǔ�\0�9�X�{��*����%<��Q��n���ָhdT\n���w�[,mX�t3�3 A�k�l�n$�K�8G����\'!�h�	>�[�}ʖ�x����\'��a���������ۋ�(�6������U4O��DY��V������q_Cn$.gA�ͧ��s�Q[�F�����\0?��cN��o{�����`�ʚ�\Z�>G\Z������\\[���i2�UY��ky�?>�����C��n-d���+>p�m\Z�~pp�s��`n��Cl�{0��qc\\�,>O��:�{Yh6���x�_�^�Ʀ���4� AwVC���./u�g:ٜmlζ�6��UDUD@DDDA����MQ�4���on�~1���\0�9�:�L{���qW>�G�(��%��BU]Ȉ�\"\"\" \"\"\" *{8UKk��K,����\"/����\r<��\r�u����ÝL�pύl�qp�3��|����{��$BI� |ѳ+�m�>L���\r\0�nc�[\"���VS��=�2Ṝ�.y⁠��:߫���M�Ћd��fx	B״���{�@Uf7��t�0И���XD���Iͣd��A��kdc�g��.-�A \\�:񨙌�y2��]���+�^8lĶ��#���e�f9_m5����j����$���s�@=\r�p��!��k��;|��\"���,ִ��I��8I\r{�\r�F��_*Z��2�ט���S��L.v�-T�5��Ǆ�_w\\r�-����{�M�|����cI���W۩���S�:a��%�滉|.�Ɨ���o�iY��~f��o�������� v�\0z���0�\\�U5��o}T��`d#�١��� ��^l>��5H�\nw$y�.cr��\0Xݬ\0�C�Xj@DEA\n\'�|��N���з�u��$��HU8׹����s��`�*3�?䢮�DUD@DDD@DD�����a�\0����:�(χ���go�C,����i����a�~-��F]yZ�WT�as�\rƠH�g���J�v@�{4k�����_��&I\r��2���<�M}˦�����7%$7\0΍�v�s8u�����\0�[�Tr�й�64�)-h��#��e]b/qϺ���I�j[H\nG9��hs%����OK+���_=MVV��㍒2F1�< �-�]�9�Q=������S��1�8f�=��m��};v�;������Z�*�OX�s��|��kf�.�����{�q��׷����e�����������\r��0xh��?�����[��?+���c�ב�n�A��%^<C����>3����6����7ۉ�9\"ζ�@���N\\��<^�1�GNǛ�+\'�`����^��1E9s�\'K�ő��� X�ϥQ�ݞ>�<樜6:��	/<62y]ĺ�==�J-���	)eo�:7~�j�p\r��j���Q�#��FYё\r�$�Ď#y{��-	�9��$m$��\'ǖ���+3�:�}Mtm6���\r_#\r�:7{.۷޳�����o�`H�9��đ��W/���|���$�M� k#�;�jߢ:΋���5I�5��?%���{6�-k��]�ۜ͡B/�Y0�8�#�[ܒJ:�1P�{a���H�>��z���ҹ�g���ɲ4�o��ؖy��l	�*������#�9���0}�w6��O)h�9xo�H�򜠘�t&ݹ���\Zeg�+�r��6cژ���.]�[��}nZ$���toi�����Z�btuͿEeV�\"*�\" \"\"\" \"\"\n{��������/�5KB^l1q=\Z�f>����������B�n��4�����_Q����������3��9�Ɵ_v��ab\r��+�����W9�$��lm�c�Գ�u\'�v������4x���Y��f{�����+C_��l7�Y�12dA�iF�l�?��#�\Z���sC�k^��v܂5\Z���(�wC���i��\0�P0j.4�A*���k�\Z��$�7�;��.Y�H9e �V�c��l5���d���s�_@,	�掂�J*q�X\r-$�e4\\&5�����q��q%�4�~F�O��*��#setR���Z���n��U4[v��K|���i��8X\0I[\\��~�h����T��+��7ܦ	��\r�����V�+���dqi\r$�Xt��uDXd66����n�_��s��o�\n7?_CRz\r�b�Z�|1��{��A���b��)�e��#�{�-.��H=�=V-plϚR�����.V�qvQ�/ky+܍C�f��.�6�Oy,[��>�0���g�@E�����۔�i���|�G)��68e���N\Z�J����\n��P����G��7b�R,6��I��G:B��-kl@\0Y�ޤ�ʿq�k�����2d�\'ޣ�ۂ�#�HA���}��D�W��E���yGKH��c�oz��{��i���F���.s��Z.\\KH\0k��TWl��\'RU������X�׵��Z4�ꃘ�\08zGڮ=��Q����&S��$�lZms���s��E$Ml\r��\rs�0\\Z]��� xyo�\'�WD\"������<O�O�#�Z�<.��28\0_@��	�5V�)D@DDD@DD&u��:}˙�����%L��ߑ��\r|��.�ǰ��+�h\0����\Z��kNWr�\r���ܥp�4�o;x/{�,���T��q��f=\\�}�U�C�K7�`|�/ox��+�\0��\r#Č���X:Ws�����R���?w���q�,�o��r�RnfwX�W}�q�OPs�>�s\"\"���?B�ʾy��<0z�`z�����c7����>�޷ȃ�\0\0\0\0r��D@DDD@DD������K�����-�[\\�B}�b�Y(�xs[�&U\"\nS�%[�\0+$P7��������)�wIF�q��s�\\1����iXH�Q��=�4�0���}w]���D@DDD@DDD@DDD@DDD@DDD@DDD@DDD@DDD@DDD@DD��','Bench Press',5),('69b79df8-a56f-45af-961b-8b176a6134ad','����\0JFIF\0\0\0\0\0\0��\0�\0	  4%$&1 %3$1+.000+583-74.0+\n\n\n\r	\r\Z\r+++++++++++++++++++++++++++++++++++++++++++++++++++��\0\0�\0�\"\0��\0\0\0\0\0\0\0\0\0\0\0\0\0��\0?\0\0\0\0\0\0!1AQ\"aq��2B���Rbr��#3�����4Scs��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��\0\0\0\0\0\0\0\0\0\0\0\0\0\0!��\0\0\0?\0�(����� v�����{�$\\���G���<ght��pC����P�����7�����&�7\r5\0�8���*��@f{AcZۑ�I�}B�ټE�Ù��\r��ȭJ\\I��7W�\\�G,�Of#�H��n$4�6�|[�eVVQk>�쮕��t���*�\0Hm��4ى�������خII��s�����$�M#���Aު�c�l���<5r����9�i� t.s�1���~b�M������KUU�\r{R4F��N�ks��r@ׇ�0������T)��f��mK��g�^\no��~�61�5�d�omĸ�*�����4RS�Ǵ�<h��c����8,��֞=Ta��N���r���V6H�$�ۜ�v���g��c�`��,\Z؟`=���}A�\rS�n�\'\0�qe`\"���\"����\" \"\"\" \"\"�c�OU3��G�8\rR�\\+Z �[W���b|�M�6�8ep�5#0�@�LٙP\Z\0c]�s����ݫ�4O���{KO�TZ��i����]rZ�[(������|��Ltͦ�o���?�����4��m��Ш��ڹ��LA��{6P.@����t�Z�J�����p曂���>7u��d�.x��|��U�����H��ITؖ+�\'?�ݲ��h�����;Ú�9�;]�RB�*#|�%Ź��2;�x��lb\n�İH�\"���N�X|-��ؘص�\0�w�8��TR�k0��8j�/�p������{\'��T���}��;�׻���qWDE�A��DD@DDD@DDD@B���T��`{K���nu��TP�`�`&����Ӹx���0wv�\0��\0�V�� ����\n}��Zz�f��x��>�?Qަ��6���Tot8�1������z���\0�^��\0d�B�(*�Y�t��1U@\ZJѯ�*���-n#i�&�`�ɇh����U��}S0�+�<���hk#�6����VʮI���t.=�������9����= \"\"\" \"\"\" \"\"�#�M%i�x�T�:YI��֋��s�����衉��E˝�o-]6s��- >M���k�d_:A�Y�ǭ�. �Hs�������A��.7FE��G4���9�<Cl��˃�ǋ����(q8\'�7���T%�;�ȭ���g����)�E�sD���>���v�ݧ���V3��hC��|~h%VW�/���b��i�u�(��s�en*��U���~��>�*[I����Ǭv��$y_�5�c�^,xtjZ�\\��Ӓ�Ű�Lӧk��\0���P\"���Rо7ڳ���aS���P���\0��w;O��8y6�4��y\r��~��ō�\\����oU��1�M {ec�^�:1}	�u�����E��t�ݣ���x �复���\0<Uͥ|۰؃�ĩC]�9ek\\=���Wv;G+M��!kK	k�7_�	ŕ��^���[��[��Ź<�U��p������x \"\"\" \"\"\" .U�X���S��5Ţ�xn��WK�)=��}��XD��i�A�\rI����)\nyd������5nR����A��rI,�;5���(���D�.aȩ<~���f�=���~j\Z���t<m�A���\0U�\"����$7���N���]uA���6��������\0Į=3T��(^Ӿ�2ly9ʳ�am�D:�ު��Z���-��[Ԡ��o�����g^p;.:u��\n��U��4�5�%���������}�ml��;~����`��27��i>���/�R\n;a�A��A�D@DDD@DDU1gc���G�\\{h\Zs�E�ֆ<~&�2�;y��gAw\\����Q�� �sҖ- ؂,A^�� �0���\"�s\n��к����i�@��������#�\r��(9�.�t�x/id^uP8��,x�:�833@$o�\'v.��]w����x��p:d�~�O�������\0X�-�ۇĪ,�M#��f$��R�B�N���U=��E%4�sg4�}�Z{��8e�M��F�b����O�j8��A^X�ݖD7���F�~��q�v���d��\0��&�1ۃ�\0U��q�+NS���5`�^�����Ǖ�m���XY@DDD@DDD@\\�h��b�g��L��WQ+����qf�x�#�\0���Ab�,;z��E���~J�G�*>7�}�^���N:��%l����q�U1]��T�k0��F�l7��T�9wke|��؄~���n�����P4>����{�\"m�������-����4�k���V���E��=��k��^LD��g�;�(*r�Iե�8-���bp�%e�\0�\Z̠����g_%��\0Tx+.��rR��l�:�}����A�-#��O�^/�V�\" \"\"\" \"\"\n�2�#�1��*�ǚ�W�؏� ~�崲奜�=tU����\0����>e�x��6F8\\��B]��a����T�-Cֲ�G�ݮ��M.v�E�.99;�p�d{�p \\���B����;0\"����xc��Zk�О�J�&9��ր�\r����6�S�K��N��h$;~���5,�H%m͈��Z0b�JLvoV�h4YL������\0��Or\rWB�\\�p���W(ꇛے�о.�\rL�Zǋ{-qЏ���k��6����c$�֛uyÃ~<Wp�,Z��7����C�[�����PO\"\"\" \"\"\" �ǩ��yZ�[�����V��M6.��\Z~*�W�9g5�y��v��eSaڹ[P�W������mÀ���K�m4�٣?��ͷA4���b�}����F�y����Q�]�k�s�^������ �ep�7X�W\\]@1�ǽib�`�t.�a~\0��!���.m��H���[�9��a�ml�1c��sv�Q��L�qk$iRm�M�Iy{�qq\'ĭ��c�n�L�ec38��\0�~x��;N�Nw�r��t������^�<4����V���gBީ��㸠���p��%���Ǚ%m�07W;^dY]z>ط�K�\\�c��dތ����4�&�w�a�t@�p�Ac�XRy�������������<�M�vQ��x�PE\'�\\y�_U�� jvf3�otn���6]�Ѳv��[3����o���i��`���H�Β�Cm�y�F!O,GV7�_@�}�B���ڈk�v~H>|���#X�˞�\0�.W_�͜��2r���fq�9�lD9�$n-��c��IӉ\Z� �lͼr�9�j|Pt1��}����!>�sx�𲂯W��o���G���ªh�dT&B�2܈o[{v��q]b�#�(jU �{�3����n�\"\" \"\"��','Stair Stepper',4);
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
INSERT INTO `UserAccount` VALUES ('DWG9VQL02PENDR2W2G','ea8b442b-68a1-423d-a965-8d6159cedeea','�@\rhδ)����C���>m�a��K��yח','Ir	�yr�T<:��hJ�5�'),('itrjllManager','6a2b0888-2ec8-4200-88c1-4f99d69d1d6f','���XM�4�ދmV�f��b�0�>H�\"*֙�','ѫ�|C���P����v`�X~'),('itrjllTrainer','a9433520-6c20-4ffc-be05-fe8e127b221a','C\"���R6*\r�Աu���orǏs5(�d7mk','�D��2�l�Ƈ�e���'),('jane','e9ece08c-65f6-4597-94c2-85e2e038fd23','��(�0\nČf,`p�_}���F4H�Ԑ<��',' ybu�����1�L3�����'),('john','f95e35ca-8f62-47cc-9662-d6027dfb3a15','��-���������=,\0}G����)t6��Oj�(','�Ee G\n�`Ho�]ַ|�a��'),('testAcct','c8f8e809-11cf-4080-bf47-616a32b4c5aa','�{�m&s�4q��A���o\'�q�����b��e�','\rߠ\\�w�f��S:����\Z�');
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
