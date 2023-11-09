-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema energie
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `energie` ;

-- -----------------------------------------------------
-- Schema energie
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `energie` DEFAULT CHARACTER SET utf8 ;
USE `energie` ;

-- -----------------------------------------------------
-- Table `energie`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `energie`.`customer` ;

CREATE TABLE IF NOT EXISTS `energie`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reference` VARCHAR(45) NOT NULL DEFAULT 'EKL123456789',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `energie`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `energie`.`person` ;

CREATE TABLE IF NOT EXISTS `energie`.`person` (
  `customer_id` INT NOT NULL,
  `civility` VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  INDEX `fk_person_customer_idx` (`customer_id` ASC),
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `fk_person_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `energie`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `energie`.`business`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `energie`.`business` ;

CREATE TABLE IF NOT EXISTS `energie`.`business` (
  `customer_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `siret` VARCHAR(45) NULL,
  `capital` DECIMAL NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `fk_business_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `energie`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `energie`.`tariff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `energie`.`tariff` ;

CREATE TABLE IF NOT EXISTS `energie`.`tariff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `label` VARCHAR(45) NULL,
  `kwh_price` DECIMAL(3) NULL,
  `gaz_price` DECIMAL(3) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `energie`.`electricity_consumption_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `energie`.`electricity_consumption_detail` ;

CREATE TABLE IF NOT EXISTS `energie`.`electricity_consumption_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `consumption_date` DATE NULL,
  `consumption` INT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_electricity_consumption_detail_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_electricity_consumption_detail_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `energie`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `energie`.`gaz_consumption_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `energie`.`gaz_consumption_detail` ;

CREATE TABLE IF NOT EXISTS `energie`.`gaz_consumption_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `consumption_date` DATE NULL,
  `consumption` INT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_gaz_consumption_detail_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_gaz_consumption_detail_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `energie`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `energie`.`bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `energie`.`bill` ;

CREATE TABLE IF NOT EXISTS `energie`.`bill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `period` VARCHAR(45) NULL,
  `bill_date` DATE NULL,
  `comsumed_electricity_kwh` INT NULL,
  `electricity_price` DECIMAL(3) NULL,
  `total_electricity_amount` DECIMAL(3) NULL,
  `consumed_gaz_kwh` INT NULL,
  `gaz_price` DECIMAL(3) NULL,
  `total_gaz_amount` DECIMAL(3) NULL,
  `total_amount` DECIMAL(3) NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bill_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_bill_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `energie`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
