# JPA_TUI_TEST
for Text User Interface


## mySQL
### 1. use mydb;

### 2. CREATE TABLE `car` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAKE` varchar(20) NOT NULL,
  `MODEL` varchar(35) NOT NULL,
  `YEAR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

### 3. INSERT INTO `car` VALUES (3,'Tesla','X',2019),(4,'Toyota','Camry',1988);
