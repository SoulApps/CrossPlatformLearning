-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema esqui
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `esqui` ;

-- -----------------------------------------------------
-- Schema esqui
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `esqui` DEFAULT CHARACTER SET utf8 ;
USE `esqui` ;

-- -----------------------------------------------------
-- Table `esqui`.`federacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`federacion` ;

CREATE TABLE IF NOT EXISTS `esqui`.`federacion` (
  `COD_FED` INT(3) NOT NULL,
  `NOM_FED` VARCHAR(30) NULL DEFAULT NULL,
  `COM_FED` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`COD_FED`),
  UNIQUE INDEX `NOM_FED_UNIQUE` (`NOM_FED` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`esquiador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`esquiador` ;

CREATE TABLE IF NOT EXISTS `esqui`.`esquiador` (
  `DNI` VARCHAR(9) NOT NULL,
  `NOM_ESQ` VARCHAR(30) NOT NULL,
  `F_NAC` DATE NOT NULL,
  `COD_EQU` INT(5) NULL DEFAULT NULL,
  `COD_FED` INT(3) NOT NULL,
  PRIMARY KEY (`DNI`),
  INDEX `FK_ESQUIADOR_EQUIPO_idx` (`COD_EQU` ASC),
  INDEX `FK_ESQUIADOR_FEDER_idx` (`COD_FED` ASC),
  CONSTRAINT `FK_ESQUIADOR_EQUIPO`
    FOREIGN KEY (`COD_EQU`)
    REFERENCES `esqui`.`equipo` (`COD_EQU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ESQUIADOR_FEDER`
    FOREIGN KEY (`COD_FED`)
    REFERENCES `esqui`.`federacion` (`COD_FED`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`equipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`equipo` ;

CREATE TABLE IF NOT EXISTS `esqui`.`equipo` (
  `COD_EQU` INT(5) NOT NULL,
  `NOM_EQU` VARCHAR(30) NOT NULL,
  `COD_ENTR` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`COD_EQU`),
  UNIQUE INDEX `NOM_EQU_UNIQUE` (`NOM_EQU` ASC),
  INDEX `FK_EQUIPO_ESQUIADOR_idx` (`COD_ENTR` ASC),
  CONSTRAINT `FK_EQUIPO_ESQUIADOR`
    FOREIGN KEY (`COD_ENTR`)
    REFERENCES `esqui`.`esquiador` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`estacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`estacion` ;

CREATE TABLE IF NOT EXISTS `esqui`.`estacion` (
  `COD_EST` INT(5) NOT NULL,
  `NOM_EST` VARCHAR(30) NOT NULL,
  `PERS_CONT` VARCHAR(30) NOT NULL,
  `LOC` VARCHAR(20) NOT NULL,
  `TLFNO` INT(9) NOT NULL,
  `COD_FED` INT(3) NOT NULL,
  PRIMARY KEY (`COD_EST`),
  UNIQUE INDEX `NOM_EST_UNIQUE` (`NOM_EST` ASC),
  INDEX `FK_ESTACION_FEDERACION_idx` (`COD_FED` ASC),
  CONSTRAINT `FK_ESTACION_FEDERACION`
    FOREIGN KEY (`COD_FED`)
    REFERENCES `esqui`.`federacion` (`COD_FED`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`pista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`pista` ;

CREATE TABLE IF NOT EXISTS `esqui`.`pista` (
  `COD_EST` INT(5) NOT NULL,
  `N_PISTA` INT(2) NOT NULL,
  `KMS` INT(3) NOT NULL,
  `DIFIC` CHAR(1) NOT NULL,
  PRIMARY KEY (`COD_EST`, `N_PISTA`),
  CONSTRAINT `FK_PISTA_ESTACION`
    FOREIGN KEY (`COD_EST`)
    REFERENCES `esqui`.`estacion` (`COD_EST`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`tipoprueba`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`tipoprueba` ;

CREATE TABLE IF NOT EXISTS `esqui`.`tipoprueba` (
  `COD_TIPO` INT(2) NOT NULL,
  `DEN` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`COD_TIPO`),
  UNIQUE INDEX `DEN_UNIQUE` (`DEN` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
