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
   `COD_FED` INT(3) NOT NULL,
  PRIMARY KEY (`COD_EQU`),
  UNIQUE INDEX `NOM_EQU_UNIQUE` (`NOM_EQU` ASC),
  INDEX `FK_EQUIPO_ESQUIADOR_idx` (`COD_ENTR` ASC),
  CONSTRAINT `FK_ESQUIADOR_FEDER2`
    FOREIGN KEY (`COD_FED`)
    REFERENCES `esqui`.`federacion` (`COD_FED`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
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
-- Table `esqui`.`prueba`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`prueba` ;

CREATE TABLE IF NOT EXISTS `esqui`.`prueba` (
  `COD_PRUEBA` INT(3) NOT NULL,
  `NOM_PRUEBA` VARCHAR(30) NOT NULL,
  `FEC_PRUEBA` DATE NOT NULL,
  `MODALIDAD` INT(1) NOT NULL,
  `COD_EST` INT(5) NOT NULL,
  `COD_PISTA` INT(3) NOT NULL,
  PRIMARY KEY (`COD_PRUEBA`),
  UNIQUE INDEX `NOM_PRUEBA_UNIQUE` (`NOM_PRUEBA` ASC),
  UNIQUE INDEX `COD_EST_UNIQUE` (`COD_EST` ASC),
  INDEX `FK_PRUEBA_PISTA_idx` (`COD_EST` ASC, `COD_PISTA` ASC),
  CONSTRAINT `FK_PRUEBA_PISTA`
    FOREIGN KEY (`COD_EST` , `COD_PISTA`)
    REFERENCES `esqui`.`pista` (`COD_EST` , `N_PISTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) 
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`part_prueba_equ`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`part_prueba_equ` ;

CREATE TABLE IF NOT EXISTS `esqui`.`part_prueba_equ` (
  `COD_EQU` INT(5) NOT NULL,
  `COD_PRUEBA` INT(3) NOT NULL,
  `TIEMPO` TIME NOT NULL,
  `POSICION` INT(3) NOT NULL,
  PRIMARY KEY (`COD_EQU`, `COD_PRUEBA`),
  INDEX `FK_PPE_PRUEBA_idx` (`COD_PRUEBA` ASC),
  CONSTRAINT `FK_PPE_EQUIPO`
    FOREIGN KEY (`COD_EQU`)
    REFERENCES `esqui`.`equipo` (`COD_EQU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PPE_PRUEBA`
    FOREIGN KEY (`COD_PRUEBA`)
    REFERENCES `esqui`.`prueba` (`COD_PRUEBA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`part_prueba_indi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`part_prueba_indi` ;

CREATE TABLE IF NOT EXISTS `esqui`.`part_prueba_indi` (
  `DNI` VARCHAR(9) NOT NULL,
  `COD_PRUEBA` INT(3) NOT NULL,
  `TIEMPO` TIME NOT NULL,
  `POSICION` INT(3) NOT NULL,
  PRIMARY KEY (`DNI`, `COD_PRUEBA`),
  INDEX `FK_PPI_PRUEBA_idx` (`COD_PRUEBA` ASC),
  CONSTRAINT `FK_PPI_ESQUIADOR`
    FOREIGN KEY (`DNI`)
    REFERENCES `esqui`.`esquiador` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PPI_PRUEBA`
    FOREIGN KEY (`COD_PRUEBA`)
    REFERENCES `esqui`.`prueba` (`COD_PRUEBA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`pista_compuesta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`pista_compuesta` ;

CREATE TABLE IF NOT EXISTS `esqui`.`pista_compuesta` (
  `COD_EST_COMP` INT(5) NOT NULL,
  `N_PISTA_COMP` INT(2) NOT NULL,
  `COD_EST` INT(5) NOT NULL,
  `N_PISTA` INT(2) NOT NULL,
  PRIMARY KEY (`COD_EST_COMP`, `N_PISTA_COMP`, `COD_EST`, `N_PISTA`),
  INDEX `FK_PC_PISTA_idx` (`COD_EST` ASC, `N_PISTA` ASC),
  CONSTRAINT `FK_PC_PISTA`
    FOREIGN KEY (`COD_EST` , `N_PISTA`)
    REFERENCES `esqui`.`pista` (`COD_EST` , `N_PISTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PC_PISTAC`
    FOREIGN KEY (`COD_EST_COMP` , `N_PISTA_COMP`)
    REFERENCES `esqui`.`pista` (`COD_EST` , `N_PISTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`prueba_individual`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`prueba_individual` ;

CREATE TABLE IF NOT EXISTS `esqui`.`prueba_individual` (
  `COD_PRUEBA` INT(3) NOT NULL,
  `MAX_PART` INT(3) NOT NULL,
  PRIMARY KEY (`COD_PRUEBA`),
  CONSTRAINT `FK_PINDI_PRUEBA`
    FOREIGN KEY (`COD_PRUEBA`)
    REFERENCES `esqui`.`prueba` (`COD_PRUEBA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esqui`.`prueba_equipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `esqui`.`prueba_equipo` ;

CREATE TABLE IF NOT EXISTS `esqui`.`prueba_equipo` (
  `COD_PRUEBA` INT(3) NOT NULL,
  `MAX_EQU` INT(3) NOT NULL,
  PRIMARY KEY (`COD_PRUEBA`),
  CONSTRAINT `FK_PEQUI_PRUEBA`
    FOREIGN KEY (`COD_PRUEBA`)
    REFERENCES `esqui`.`prueba` (`COD_PRUEBA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
