/*
Navicat MySQL Data Transfer

Source Server         : locacao-automoveis
Source Server Version : 50141
Source Host           : localhost:3306
Source Database       : locacaoautomoveis

Target Server Type    : MYSQL
Target Server Version : 50141
File Encoding         : 65001

Date: 2011-10-12 04:49:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `TB_AUTOMOVEL`
-- ----------------------------
DROP TABLE IF EXISTS `TB_AUTOMOVEL`;
CREATE TABLE `TB_AUTOMOVEL` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(11) DEFAULT NULL,
  `cor` varchar(255) DEFAULT NULL,
  `disponivel` bit(1) DEFAULT NULL,
  `placa` varchar(7) NOT NULL,
  `renavam` varchar(9) NOT NULL,
  `CATEGORIA_FK` int(11) DEFAULT NULL,
  `MODELO_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `placa` (`placa`),
  UNIQUE KEY `renavam` (`renavam`),
  KEY `FK9A61F9BB48798C2D` (`CATEGORIA_FK`),
  KEY `FK9A61F9BB62B32861` (`MODELO_FK`),
  CONSTRAINT `FK9A61F9BB62B32861` FOREIGN KEY (`MODELO_FK`) REFERENCES `TB_MODELO_AUTOMOVEL` (`id`),
  CONSTRAINT `FK9A61F9BB48798C2D` FOREIGN KEY (`CATEGORIA_FK`) REFERENCES `TB_CATEGORIA_AUTOMOVEL` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TB_AUTOMOVEL
-- ----------------------------
INSERT INTO `TB_AUTOMOVEL` VALUES ('1', '2011', null, '', 'ABC0000', '000000000', '1', '1');
INSERT INTO `TB_AUTOMOVEL` VALUES ('2', '2011', null, '', 'ABC0001', '000000001', '1', '2');
INSERT INTO `TB_AUTOMOVEL` VALUES ('3', '2011', null, '', 'ABC0002', '000000002', '1', '3');
INSERT INTO `TB_AUTOMOVEL` VALUES ('4', '2011', null, '', 'ABC0003', '000000003', '1', '4');
INSERT INTO `TB_AUTOMOVEL` VALUES ('5', '2011', null, '', 'ABC0004', '000000004', '1', '5');
INSERT INTO `TB_AUTOMOVEL` VALUES ('6', '2011', null, '', 'ABC0005', '000000005', '5', '6');
INSERT INTO `TB_AUTOMOVEL` VALUES ('7', '2011', null, '', 'ABC0007', '000000007', '5', '8');
INSERT INTO `TB_AUTOMOVEL` VALUES ('8', '2011', null, '', 'ABC0008', '000000008', '5', '9');
INSERT INTO `TB_AUTOMOVEL` VALUES ('9', '2011', null, '', 'ABC0009', '000000009', '1', '10');
INSERT INTO `TB_AUTOMOVEL` VALUES ('10', '2011', null, '', 'ABC0010', '000000010', '1', '11');
INSERT INTO `TB_AUTOMOVEL` VALUES ('11', '2011', null, '', 'ABC0011', '000000011', '6', '12');

-- ----------------------------
-- Table structure for `TB_CATEGORIA_AUTOMOVEL`
-- ----------------------------
DROP TABLE IF EXISTS `TB_CATEGORIA_AUTOMOVEL`;
CREATE TABLE `TB_CATEGORIA_AUTOMOVEL` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `valorDiario` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descricao` (`descricao`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TB_CATEGORIA_AUTOMOVEL
-- ----------------------------
INSERT INTO `TB_CATEGORIA_AUTOMOVEL` VALUES ('1', 'Básico', '80');
INSERT INTO `TB_CATEGORIA_AUTOMOVEL` VALUES ('2', 'Esportivo', '100');
INSERT INTO `TB_CATEGORIA_AUTOMOVEL` VALUES ('3', 'Familiar', '90');
INSERT INTO `TB_CATEGORIA_AUTOMOVEL` VALUES ('4', 'Luxo', '110');
INSERT INTO `TB_CATEGORIA_AUTOMOVEL` VALUES ('5', 'Utilitário', '90');
INSERT INTO `TB_CATEGORIA_AUTOMOVEL` VALUES ('6', 'Van', '80');

-- ----------------------------
-- Table structure for `TB_CLIENTE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_CLIENTE`;
CREATE TABLE `TB_CLIENTE` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpfcnpj` varchar(14) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TB_CLIENTE
-- ----------------------------
INSERT INTO `TB_CLIENTE` VALUES ('1', '17526159304', 'mario.bandeiras@email.com.br', null, 'Mario João Bandeiras', null);
INSERT INTO `TB_CLIENTE` VALUES ('2', '22023987679', 'antonio.moura@email.com.br', null, 'Antônio Carlos Moura', null);
INSERT INTO `TB_CLIENTE` VALUES ('3', '01882241819', 'gustavo.ferreira@email.com.br', null, 'Gustavo Gomes Ferreira', null);
INSERT INTO `TB_CLIENTE` VALUES ('4', '51633018000161', 'construtorabandeiras@construtorabandeiras.com.br', null, 'Construtora Bandeiras', null);
INSERT INTO `TB_CLIENTE` VALUES ('5', '36041411000172', 'nexus@nexus.com.br', null, 'Nexus Ltda', null);
INSERT INTO `TB_CLIENTE` VALUES ('6', '80373496000188', 'jardelautocentro@jardelautocentro.com.br', null, 'Jardel AutoCentro', null);

-- ----------------------------
-- Table structure for `TB_LOCACAO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_LOCACAO`;
CREATE TABLE `TB_LOCACAO` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataHoraLocacao` datetime DEFAULT NULL,
  `dataHoraLocacaoFinalizada` datetime DEFAULT NULL,
  `dataPrevistaDevolucao` date DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `AUTOMOVEL_FK` int(11) DEFAULT NULL,
  `CLIENTE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2D448A1FFF7528A1` (`CLIENTE_FK`),
  KEY `FK2D448A1FEF889021` (`AUTOMOVEL_FK`),
  CONSTRAINT `FK2D448A1FEF889021` FOREIGN KEY (`AUTOMOVEL_FK`) REFERENCES `TB_AUTOMOVEL` (`id`),
  CONSTRAINT `FK2D448A1FFF7528A1` FOREIGN KEY (`CLIENTE_FK`) REFERENCES `TB_CLIENTE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TB_LOCACAO
-- ----------------------------
INSERT INTO `TB_LOCACAO` VALUES ('1', '2011-10-12 04:17:34', null, null, null, '0', '0', '1', '3');
INSERT INTO `TB_LOCACAO` VALUES ('2', '2011-10-12 04:17:34', null, null, null, '0', '0', '2', '4');
INSERT INTO `TB_LOCACAO` VALUES ('3', '2011-10-12 04:17:34', null, null, null, '0', '0', '3', '2');

-- ----------------------------
-- Table structure for `TB_MARCA_AUTOMOVEL`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MARCA_AUTOMOVEL`;
CREATE TABLE `TB_MARCA_AUTOMOVEL` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descricao` (`descricao`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TB_MARCA_AUTOMOVEL
-- ----------------------------
INSERT INTO `TB_MARCA_AUTOMOVEL` VALUES ('1', 'FIAT');
INSERT INTO `TB_MARCA_AUTOMOVEL` VALUES ('2', 'FORD');
INSERT INTO `TB_MARCA_AUTOMOVEL` VALUES ('3', 'GM-Chevrolet');
INSERT INTO `TB_MARCA_AUTOMOVEL` VALUES ('4', 'RENAULT');
INSERT INTO `TB_MARCA_AUTOMOVEL` VALUES ('5', 'TOYOTA');
INSERT INTO `TB_MARCA_AUTOMOVEL` VALUES ('6', 'VW-Volkswagen');

-- ----------------------------
-- Table structure for `TB_MODELO_AUTOMOVEL`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MODELO_AUTOMOVEL`;
CREATE TABLE `TB_MODELO_AUTOMOVEL` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `MARCA_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descricao` (`descricao`),
  KEY `FKE0CF7964FC92E51B` (`MARCA_FK`),
  CONSTRAINT `FKE0CF7964FC92E51B` FOREIGN KEY (`MARCA_FK`) REFERENCES `TB_MARCA_AUTOMOVEL` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TB_MODELO_AUTOMOVEL
-- ----------------------------
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('1', 'Siena EX 1.0 mpi Fire 16v 4p', '1');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('2', 'Palio ELX 1.0 mpi Fire/ Fire Flex 8V 4p', '1');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('3', 'Uno Mille 1.0 Fire/ F.Flex/ ECONOMY 4p', '1');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('4', 'Fiesta 1.0 8V Flex 5p', '2');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('5', 'KA Black 1.0 MPI 8v 65cv', '2');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('6', 'Ranger XLT 2.8 8v 135cv 4x4 CE TB Diesel', '2');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('7', 'Celta Life 1.0 MPFI VHC 8V 5p', '3');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('8', 'MONTANA 1.4 8V Conquest ECONOFLEX  2p', '3');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('9', 'S10 Pick-Up Exec. 2.8 4x4 CD TB Int.Diesel', '3');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('10', 'Fox 1.0 Mi Total Flex 8V 5p', '6');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('11', 'Gol 1.0 Plus 8v 4p', '6');
INSERT INTO `TB_MODELO_AUTOMOVEL` VALUES ('12', 'Kombi Lotação 1.4 Mi Total Flex 8V', '6');

-- ----------------------------
-- Table structure for `TB_USUARIO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USUARIO`;
CREATE TABLE `TB_USUARIO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomeLogin` varchar(20) NOT NULL,
  `senha` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nomeLogin` (`nomeLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TB_USUARIO
-- ----------------------------
INSERT INTO `TB_USUARIO` VALUES ('1', 'joao', 'ed2befb11499489e2570cb053f774b8ed93e89eddab3f78867a2a5f32c58845e');
INSERT INTO `TB_USUARIO` VALUES ('2', 'joana', '3c6efb268bde2923e4f7cbc086995f6158a606e66df45e307829e6b28f7aaf0e');
INSERT INTO `TB_USUARIO` VALUES ('3', 'julio', '901be86d450c504e8555ffeeeab1e06b926c8785fd99ef382c1310b7c66bc167');
