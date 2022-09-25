-- -----------------------------------------------------
-- Schema cravo_canela
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cravo_canela` DEFAULT CHARACTER SET utf8 ;
USE `cravo_canela` ;

-- -----------------------------------------------------
-- Table `cravo_canela`.`perfil_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cravo_canela`.`perfil_cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `telefone` VARCHAR(20) NULL DEFAULT NULL,
  `nome_usuario` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `status_conta` VARCHAR(10) NOT NULL,
  `data_login` VARCHAR(10) NOT NULL,
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
  `titulo` TEXT NOT NULL,
  `descricao` TEXT NOT NULL,
  `video` TEXT NOT NULL,
  `total_acessos` INT NULL DEFAULT NULL,
  `nota_video` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cravo_canela`.`historico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cravo_canela`.`historico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_visualizacao` VARCHAR(10) NOT NULL,
  `cliente_id` INT NOT NULL,
  `video_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_has_video_video1_idx` (`video_id` ASC) VISIBLE,
  INDEX `fk_cliente_has_video_cliente_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_has_video_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `cravo_canela`.`perfil_cliente` (`id`),
  CONSTRAINT `fk_cliente_has_video_video1`
    FOREIGN KEY (`video_id`)
    REFERENCES `cravo_canela`.`video` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
