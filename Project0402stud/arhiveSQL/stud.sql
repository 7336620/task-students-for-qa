/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for library
CREATE DATABASE IF NOT EXISTS `studentsqa` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `studentsqa`;


-- Dumping structure for table library.persons
CREATE TABLE IF NOT EXISTS `persons` (
  `stud_id` int(11) NOT NULL AUTO_INCREMENT ,
  `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `profession` varchar(1) NOT NULL DEFAULT 'A',
  `weight` float(6.2) UNSIGNED NOT NULL DEFAULT '10',
  PRIMARY KEY (`stud_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- Dumping data for table studentsqa.persons: ~6 rows (approximately)
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` (`stud_id`, `last_name`, `name`, `profession`, `weight`) VALUES  (null, 'Petrov', 'Petr', 'Q', 82.50);
INSERT INTO `persons` (`stud_id`, `last_name`, `name`, `profession`, `weight`) VALUES  (null, 'Ivanov', 'Ivan', 'Q', 71.30);
INSERT INTO `persons` (`stud_id`, `last_name`, `name`, `profession`, `weight`) VALUES  (null, 'Sidorov', 'Sidor', 'T', 100.80);
INSERT INTO `persons` (`stud_id`, `last_name`, `name`, `profession`, `weight`) VALUES  (null, 'Poe', 'Edgar Allan', 'W', 91.25);
INSERT INTO `persons` (`stud_id`, `last_name`, `name`, `profession`, `weight`) VALUES  (null, 'Rowling', 'Joanne', 'W', 54.30);
INSERT INTO `persons` (`stud_id`, `last_name`, `name`, `profession`, `weight`) VALUES  (null, 'Dreiser', 'Theodore', 'W', 110.00);
INSERT INTO `persons` (`stud_id`, `last_name`, `name`, `profession`, `weight`) VALUES  (null, 'Semenov', 'Semen', 'W', 150.39);
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
