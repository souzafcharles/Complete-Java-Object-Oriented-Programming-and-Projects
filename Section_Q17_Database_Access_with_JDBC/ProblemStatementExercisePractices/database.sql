-- Create table 'department' if it does not exist
CREATE TABLE IF NOT EXISTS department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

-- Create table 'seller' if it does not exist
CREATE TABLE IF NOT EXISTS seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (Id)
);

-- Update or insert data into 'department' table
INSERT INTO department (Id, Name) VALUES 
  (1, 'Computers'),
  (2, 'Electronics'),
  (3, 'Fashion'),
  (4, 'Books'),
  (5, 'Beauty'),
  (6, 'Shoes')
ON DUPLICATE KEY UPDATE
  Name = VALUES(Name);

-- Update or insert data into 'seller' table
INSERT INTO seller (Id, Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  (1, 'Balthazar de Bigode','balthazar@mail.com','2020-03-10 00:00:00',1000,1),
  (2, 'Ophelia Birrenta','ophelia@mail.com','2020-11-10 00:00:00',3500,2),
  (3, 'Ludovico Crispim','ludovico@mail.com','1989-10-30 00:00:00',2200,1),
  (4, 'Sebastiana Frederica','sebastiana@mail.com','1993-11-30 00:00:00',3000,4),
  (5, 'Belizario Epaminondas','belizario@mail.com','2000-01-09 00:00:00',4000,3),
  (6, 'Gumercindo Abigail','gumercindo@mail.com','1997-03-04 00:00:00',3000,2),
  (7, 'Zuleica Serafina','zuleica@mail.com','1985-02-10 00:00:00',3000,4),
  (8, 'Vitalino Simplicio','vitalino@mail.com','1995-10-23 00:00:00',4000,3)
ON DUPLICATE KEY UPDATE
  Name = VALUES(Name),
  Email = VALUES(Email),
  BirthDate = VALUES(BirthDate),
  BaseSalary = VALUES(BaseSalary),
  DepartmentId = VALUES(DepartmentId);