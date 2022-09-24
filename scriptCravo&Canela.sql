-- -----------------------------------------------------
-- Schema cravo_canela
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cravo_canela` DEFAULT CHARACTER SET utf8 ;
USE `cravo_canela` ;

-- -----------------------------------------------------
-- Table `cravo_canela`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cravo_canela`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `telefone` VARCHAR(20) NULL DEFAULT NULL,
  `nome_usuario` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `status_conta` VARCHAR(10) NOT NULL,
  `data_login` VARCHAR(10) NOT NULL,
  `certificado` LONGBLOB NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cravo_canela`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cravo_canela`.`video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `descricao` TEXT NOT NULL,
  `video` TEXT NOT NULL,
  `total_acessos` INT NULL DEFAULT NULL,
  `nota_video` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cravo_canela`.`visualizacao_video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cravo_canela`.`visualizacao_video` (
  `id_acesso` INT NOT NULL AUTO_INCREMENT,
  `data_visualizacao` VARCHAR(10) NOT NULL,
  `cliente_id` INT NOT NULL,
  `video_id` INT NOT NULL,
  INDEX `fk_cliente_has_video_video1_idx` (`video_id` ASC) VISIBLE,
  INDEX `fk_cliente_has_video_cliente_idx` (`cliente_id` ASC) VISIBLE,
  PRIMARY KEY (`id_acesso`),
  CONSTRAINT `fk_cliente_has_video_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `cravo_canela`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_video_video1`
    FOREIGN KEY (`video_id`)
    REFERENCES `cravo_canela`.`video` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
