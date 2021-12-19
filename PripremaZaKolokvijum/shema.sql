-- -----------------------------------------------------
-- Table `is2`.`Reziser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Reziser` (
  `idReziser` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NULL,
  `prezime` VARCHAR(45) NULL,
  PRIMARY KEY (`idReziser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Predstava`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Predstava` (
  `idPredstava` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NULL,
  `trajanje` INT NULL,
  `opis` VARCHAR(45) NULL,
  `idReziser` INT NOT NULL,
  PRIMARY KEY (`idPredstava`),
  INDEX `fk_Predstava_Reziser1_idx` (`idReziser` ASC),
  CONSTRAINT `fk_Predstava_Reziser1`
    FOREIGN KEY (`idReziser`)
    REFERENCES `is2`.`Reziser` (`idReziser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Zanr`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Zanr` (
  `idZanr` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NULL,
  PRIMARY KEY (`idZanr`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`ZanrPredstave`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`ZanrPredstave` (
  `idZanr` INT NOT NULL,
  `idPredstava` INT NOT NULL,
  `idZanrPredstave` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_Zanr_has_Predstava_Predstava1_idx` (`idPredstava` ASC),
  INDEX `fk_Zanr_has_Predstava_Zanr_idx` (`idZanr` ASC),
  PRIMARY KEY (`idZanrPredstave`),
  CONSTRAINT `fk_Zanr_has_Predstava_Zanr`
    FOREIGN KEY (`idZanr`)
    REFERENCES `is2`.`Zanr` (`idZanr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zanr_has_Predstava_Predstava1`
    FOREIGN KEY (`idPredstava`)
    REFERENCES `is2`.`Predstava` (`idPredstava`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Scena`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Scena` (
  `idScena` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NULL,
  PRIMARY KEY (`idScena`));


-- -----------------------------------------------------
-- Table `is2`.`Izvodjenje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Izvodjenje` (
  `idIzvodjenje` INT NOT NULL AUTO_INCREMENT,
  `datum` DATE NULL,
  `idScena` INT NOT NULL,
  `idPredstava` INT NOT NULL,
  PRIMARY KEY (`idIzvodjenje`),
  INDEX `fk_Izvodjenje_Scena1_idx` (`idScena` ASC),
  INDEX `fk_Izvodjenje_Predstava1_idx` (`idPredstava` ASC),
  CONSTRAINT `fk_Izvodjenje_Scena1`
    FOREIGN KEY (`idScena`)
    REFERENCES `is2`.`Scena` (`idScena`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Izvodjenje_Predstava1`
    FOREIGN KEY (`idPredstava`)
    REFERENCES `is2`.`Predstava` (`idPredstava`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Mesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Mesto` (
  `idMesto` INT NOT NULL AUTO_INCREMENT,
  `sekcija` VARCHAR(45) NULL,
  `red` INT NULL,
  `broj` INT NULL,
  `idScena` INT NOT NULL,
  PRIMARY KEY (`idMesto`),
  INDEX `fk_Mesto_Scena1_idx` (`idScena` ASC),
  CONSTRAINT `fk_Mesto_Scena1`
    FOREIGN KEY (`idScena`)
    REFERENCES `is2`.`Scena` (`idScena`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Posetilac`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Posetilac` (
  `idPosetilac` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NULL,
  `prezime` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(225) NULL,
  PRIMARY KEY (`idPosetilac`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Karta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Karta` (
  `idKarta` INT NOT NULL AUTO_INCREMENT,
  `cena` DOUBLE NULL,
  `datumRezervacije` DATE NULL,
  `datumPlacanja` DATE NULL,
  `idMesto` INT NOT NULL,
  `idIzvodjenje` INT NOT NULL,
  `idPosetilac` INT NOT NULL,
  PRIMARY KEY (`idKarta`),
  INDEX `fk_Karta_Mesto1_idx` (`idMesto` ASC),
  INDEX `fk_Karta_Izvodjenje1_idx` (`idIzvodjenje` ASC),
  INDEX `fk_Karta_Posetilac1_idx` (`idPosetilac` ASC),
  CONSTRAINT `fk_Karta_Mesto1`
    FOREIGN KEY (`idMesto`)
    REFERENCES `is2`.`Mesto` (`idMesto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Karta_Izvodjenje1`
    FOREIGN KEY (`idIzvodjenje`)
    REFERENCES `is2`.`Izvodjenje` (`idIzvodjenje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Karta_Posetilac1`
    FOREIGN KEY (`idPosetilac`)
    REFERENCES `is2`.`Posetilac` (`idPosetilac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Omiljene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Omiljene` (
  `idOmiljene` INT NOT NULL AUTO_INCREMENT,
  `idPosetilac` INT NOT NULL,
  `idPredstava` INT NOT NULL,
  PRIMARY KEY (`idOmiljene`),
  INDEX `fk_Omiljene_Posetilac1_idx` (`idPosetilac` ASC),
  INDEX `fk_Omiljene_Predstava1_idx` (`idPredstava` ASC),
  CONSTRAINT `fk_Omiljene_Posetilac1`
    FOREIGN KEY (`idPosetilac`)
    REFERENCES `is2`.`Posetilac` (`idPosetilac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Omiljene_Predstava1`
    FOREIGN KEY (`idPredstava`)
    REFERENCES `is2`.`Predstava` (`idPredstava`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Ocena`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Ocena` (
  `idOcena` INT NOT NULL AUTO_INCREMENT,
  `ocena` VARCHAR(45) NULL,
  `komentar` VARCHAR(45) NULL,
  `idIzvodjenje` INT NOT NULL,
  `idPosetilac` INT NOT NULL,
  PRIMARY KEY (`idOcena`),
  INDEX `fk_Ocena_Izvodjenje1_idx` (`idIzvodjenje` ASC),
  INDEX `fk_Ocena_Posetilac1_idx` (`idPosetilac` ASC),
  CONSTRAINT `fk_Ocena_Izvodjenje1`
    FOREIGN KEY (`idIzvodjenje`)
    REFERENCES `is2`.`Izvodjenje` (`idIzvodjenje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ocena_Posetilac1`
    FOREIGN KEY (`idPosetilac`)
    REFERENCES `is2`.`Posetilac` (`idPosetilac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Glumac`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Glumac` (
  `idGlumac` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NULL,
  `prezime` VARCHAR(45) NULL,
  PRIMARY KEY (`idGlumac`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Uloga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Uloga` (
  `idUloga` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NULL,
  `idPredstava` INT NOT NULL,
  PRIMARY KEY (`idUloga`),
  INDEX `fk_Uloga_Predstava1_idx` (`idPredstava` ASC),
  CONSTRAINT `fk_Uloga_Predstava1`
    FOREIGN KEY (`idPredstava`)
    REFERENCES `is2`.`Predstava` (`idPredstava`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`Glumi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`Glumi` (
  `idGlumi` INT NOT NULL AUTO_INCREMENT,
  `idUloga` INT NOT NULL,
  `idGlumac` INT NOT NULL,
  PRIMARY KEY (`idGlumi`),
  INDEX `fk_Glumi_Uloga1_idx` (`idUloga` ASC),
  INDEX `fk_Glumi_Glumac1_idx` (`idGlumac` ASC),
  CONSTRAINT `fk_Glumi_Uloga1`
    FOREIGN KEY (`idUloga`)
    REFERENCES `is2`.`Uloga` (`idUloga`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Glumi_Glumac1`
    FOREIGN KEY (`idGlumac`)
    REFERENCES `is2`.`Glumac` (`idGlumac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is2`.`GlumiUIzvodjenju`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is2`.`GlumiUIzvodjenju` (
  `idGlumiUIzvodjenju` INT NOT NULL AUTO_INCREMENT,
  `idGlumi` INT NOT NULL,
  `idIzvodjenje` INT NOT NULL,
  PRIMARY KEY (`idGlumiUIzvodjenju`),
  INDEX `fk_GlumiUIzvodjenju_Glumi1_idx` (`idGlumi` ASC),
  INDEX `fk_GlumiUIzvodjenju_Izvodjenje1_idx` (`idIzvodjenje` ASC),
  CONSTRAINT `fk_GlumiUIzvodjenju_Glumi1`
    FOREIGN KEY (`idGlumi`)
    REFERENCES `is2`.`Glumi` (`idGlumi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GlumiUIzvodjenju_Izvodjenje1`
    FOREIGN KEY (`idIzvodjenje`)
    REFERENCES `is2`.`Izvodjenje` (`idIzvodjenje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;