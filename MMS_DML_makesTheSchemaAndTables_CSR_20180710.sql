-- MySQL Workbench Forward Engineering

SET @OLD_INDEX_CHECKS=@@INDEX_CHECKS, INDEX_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema MakeMyStay
-- -----------------------------------------------------
-- This is the schema that stores data used in CMSC 495 6380 Group 5's final project.
-- 
-- Team members --
-- Deepak Galami 
-- Chris Kearney
-- Chris Ruark
-- Josh Seaton
-- 
-- The "Make My Stay" Product concept and software design is exclusively the work of this team and may not be reused/reformulated/refactored without unanimous consent of Group 5 in hardcopy writing. 

-- -----------------------------------------------------
-- Schema MakeMyStay
--
-- This is the schema that stores data used in CMSC 495 6380 Group 5's final project.
-- 
-- Team members --
-- Deepak Galami 
-- Chris Kearney
-- Chris Ruark
-- Josh Seaton
-- 
-- The "Make My Stay" Product concept and software design is exclusively the work of this team and may not be reused/reformulated/refactored without unanimous consent of Group 5 in hardcopy writing. 
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MakeMyStay` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
USE `MakeMyStay` ;


CREATE TABLE IF NOT EXISTS `MakeMyStay`.`UserType` (
  `idUserType` INT AUTO_INCREMENT NOT NULL,
  `UserDescription` VARCHAR(15) NOT NULL,
  INDEX `idUserType_INDEX` (`idUserType` ASC),
  PRIMARY KEY (`idUserType`),
  INDEX `UserDescription_INDEX` (`UserDescription` ASC))
ENGINE = InnoDB
COMMENT = 'Stores unique roles assignable to MMS users.';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`User` (
  `IdUser` INT AUTO_INCREMENT NOT NULL,
  `IdUserType` INT NOT NULL,
  `UserName` VARCHAR(16) NOT NULL,
  `Password` VARCHAR(32) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `CreatedTimeStamp` DATETIME NOT NULL,
  `Inactive` TINYINT NULL,
  PRIMARY KEY (`IdUser`),
  INDEX `idUser_INDEX` (`IdUser` ASC),
  INDEX `Email_INDEX` (`Email` ASC),
  INDEX `UserName_INDEX` (`UserName` ASC),
  INDEX `LastName_INDEX` (`LastName` ASC),
  INDEX `idUserType_INDEX` (`IdUserType` ASC),
  CONSTRAINT `idUserType_FK`
    FOREIGN KEY (`IdUserType`)
    REFERENCES `MakeMyStay`.`UserType` (`idUserType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Stores the name, login, contact information and other particulars for each MMS user.';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`QualityDescriptor` (
  `idQualityDescriptor` INT AUTO_INCREMENT NOT NULL,
  `Descriptor` VARCHAR(500) NOT NULL,
  `Suggested` VARCHAR(45) NOT NULL,
  `Ordinal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idQualityDescriptor`),
  INDEX `idQualityDescriptor_INDEX` (`idQualityDescriptor` ASC),
  INDEX `Descriptor_INDEX` (`Descriptor` ASC),
  INDEX `Suggested_INDEX` (`Suggested` ASC))
ENGINE = InnoDB
COMMENT = 'Stores the quality of room descriptor for each room. In future versions, teh QoR may be assigned as a range to a block of rooms.';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`ReservationStatus` (
  `idReservationStatus` INT AUTO_INCREMENT NOT NULL,
  `Description` VARCHAR(500) NOT NULL,
  `Ordinal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idReservationStatus`),
  INDEX `idResvervationStatus_INDEX` (`idReservationStatus` ASC),
  INDEX `Description_INDEX` (`Description` ASC),
  INDEX `Ordinal_INDEX` (`Ordinal` ASC))
ENGINE = InnoDB
COMMENT = 'Stores reservation status flags.';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`Property` (
  `idProperty` INT AUTO_INCREMENT NOT NULL,
  `idUser` INT NOT NULL,
  `PropertyName` VARCHAR(60) NOT NULL,
  `PropertyDescription` VARCHAR(500) NOT NULL,
  `LocaleDescription` VARCHAR(100) NOT NULL,
  `StreetAddress` VARCHAR(100) NOT NULL,
  `City` VARCHAR(100) NOT NULL,
  `State` VARCHAR(2) NOT NULL,
  `PostCode` VARCHAR(5) NOT NULL,
  `Telephone` TEXT(15) NOT NULL,
  `Deleted` TINYINT NULL,
  INDEX `idUser_INDEX` (`idUser` ASC),
  INDEX `PropertyName_INDEX` (`PropertyName` ASC),
  INDEX `StreetAddress_INDEX` (`StreetAddress` ASC),
  INDEX `idProperty_INDEX` (`idProperty` ASC),
  PRIMARY KEY (`idProperty`),
  CONSTRAINT `idUser_FK`
    FOREIGN KEY (`idUser`)
    REFERENCES `MakeMyStay`.`User` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Stores records for MMS property records. Each record maps to a specific location.';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`Room` (
  `idRoom` INT NOT NULL,
  `IdProperty` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Description` MEDIUMTEXT NOT NULL,
  `Inactive` TINYINT NOT NULL,
  PRIMARY KEY (`idRoom`),
  INDEX `idProperty_INDEX` (`IdProperty` ASC),
  INDEX `idRoom_INDEX` (`idRoom` ASC),
  CONSTRAINT `idProperty_FK`
    FOREIGN KEY (`IdProperty`)
    REFERENCES `MakeMyStay`.`Property` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Stores an enumerated table of rooms available per property';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`Reservation` (
  `idReservation` INT AUTO_INCREMENT NOT NULL,
  `idUser` INT NOT NULL,
  `idRoom` INT NOT NULL,
  `idReservationStatus` INT NOT NULL,
  `StartDateTime` DATETIME NOT NULL,
  `EndDateTime` DATETIME NOT NULL,
  `Created` TIMESTAMP NOT NULL,
  `Inactive` TINYINT NULL,
  PRIMARY KEY (`idReservation`),
  INDEX `idReservation_INDEX` (`idReservation` ASC),
  INDEX `idUser_INDEX` (`idUser` ASC),
  INDEX `idRoom_INDEX` (`idRoom` ASC),
  INDEX `idStatus_INDEX` (`idReservationStatus` ASC),
  INDEX `StartDateTime_INDEX` (`StartDateTime` ASC),
  INDEX `EndDateTime_INDEX` (`EndDateTime` ASC),
  INDEX `CreatedDateTime_INDEX` (`Created` ASC),
  CONSTRAINT `idResvUser_FK`
    FOREIGN KEY (`idUser`)
    REFERENCES `MakeMyStay`.`User` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idRoom_FK`
    FOREIGN KEY (`idRoom`)
    REFERENCES `MakeMyStay`.`Room` (`idRoom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idReservationStatus_FK`
    FOREIGN KEY (`idReservationStatus`)
    REFERENCES `MakeMyStay`.`ReservationStatus` (`idReservationStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Stores a unique reservation mapping a user to a room on a specific property.';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`PerDiemRate` (
  `idPerDiemRate` INT AUTO_INCREMENT NOT NULL,
  `idProperty` INT NOT NULL,
  `idRoom` INT NOT NULL,
  `Year` VARCHAR(4) NOT NULL,
  `DateTime` DATETIME NOT NULL,
  `Rate` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`idPerDiemRate`),
  INDEX `idPerDiemRate_INDEX` (`idPerDiemRate` ASC),
  INDEX `idRoom_INDEX` (`idRoom` ASC),
  CONSTRAINT `idPDRoom_FK`
    FOREIGN KEY (`idRoom`)
    REFERENCES `MakeMyStay`.`Room` (`idRoom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPDProperty_FK`
    FOREIGN KEY (`idProperty`)
    REFERENCES `MakeMyStay`.`Property` (`idProperty`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)  
ENGINE = InnoDB
COMMENT = 'Stores the per-diem rate to charge for each room. In the prof concept system, each room will have one and only one rate. In future deployments rates may be assigned by range.';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`DescriptorSelection` (
  `idDescriptorSelection` INT AUTO_INCREMENT NOT NULL,
  `idProperty` INT NOT NULL,
  `idQualityDescriptor` INT NOT NULL,
  `InUse` TINYINT UNSIGNED NULL,
  PRIMARY KEY (`idDescriptorSelection`),
  INDEX `idProperty_INDEX` (`idProperty` ASC),
  INDEX `idDescriptorSelection_INDEX` (`idDescriptorSelection` ASC),
  INDEX `idQualityDescriptor_INDEX` (`idQualityDescriptor` ASC),
  CONSTRAINT `idDescProperty_FK`
    FOREIGN KEY (`idProperty`)
    REFERENCES `MakeMyStay`.`Property` (`idProperty`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Sets the overall quality rating of a property.';

CREATE TABLE IF NOT EXISTS `MakeMyStay`.`PropertyDelegationMap` (
  `idPropertyDelegate` INT NOT NULL,
  `idProperty` INT NOT NULL,
  `idUser` INT NOT NULL,
  `Inactive` TINYINT UNSIGNED NULL,
  `PropertyDelegationMapcol` VARCHAR(45) NULL,
  PRIMARY KEY (`idPropertyDelegate`),
  INDEX `idPropertyDelegatie_INDEX` (`idPropertyDelegate` ASC),
  INDEX `idUser_INDEX` (`idUser` ASC),
  CONSTRAINT `idDelProperty_FK`
    FOREIGN KEY (`idProperty`)
    REFERENCES `MakeMyStay`.`Property` (`idProperty`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDelUser_FK`
    FOREIGN KEY (`idUser`)
    REFERENCES `MakeMyStay`.`User` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Stores property records management delegations. May not be fully enabled.';
