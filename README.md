# JPA_TUI_TEST
for Text User Interface

## mySQL
### 1. use mydb;

### 2. CREATE TABLE
```sqk
CREATE TABLE `car` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAKE` varchar(20) NOT NULL,
  `MODEL` varchar(35) NOT NULL,
  `YEAR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
```

### 3. INSERT
```sql
INSERT INTO `car` VALUES (3,'Tesla','X',2019),(4,'Toyota','Camry',1988);
```

## 3. convert to JPA project and setting persistence.xml
```
	<persistence-unit name="CarProject"
		transaction-type="RESOURCE_LOCAL">

		<class>car.Model.CarEntity</class>

		<properties>
			<property name="javax.persistence.jdbc.url"
				value="jdbc:mysql://localhost:3306/mydb" />
			<property name="javax.persistence.jdbc.user" value="root" />
			<property name="javax.persistence.jdbc.password"
				value="rootroot" />
			<property name="javax.persistence.jdbc.driver"
				value="com.mysql.jdbc.Driver" />
			<property name="eclipselink.logging.level" value="FINE" />
			<property name="eclipselink.ddl-generation"
				value="create-tables" />
		</properties>
	</persistence-unit>
  ```

## 4. start program
- StartProgram.java Ctrl+F11
