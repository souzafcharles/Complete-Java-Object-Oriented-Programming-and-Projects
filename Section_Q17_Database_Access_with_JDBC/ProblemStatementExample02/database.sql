CREATE TABLE department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
);

INSERT INTO department (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Balthazar de Bigode','balthazar@mail.com','2020-03-10 00:00:00',1000,1),
  ('Ophelia Birrenta','ophelia@mail.com','2020-11-10 00:00:00',3500,2),
  ('Ludovico Crispim','ludovico@mail.com','1989-10-30 00:00:00',2200,1),
  ('Sebastiana Frederica','sebastiana@mail.com','1993-11-30 00:00:00',3000,4),
  ('Belizario Epaminondas','belizario@mail.com','2000-01-09 00:00:00',4000,3),
  ('Gumercindo Abigail','gumercindo@mail.com','1997-03-04 00:00:00',3000,2);
