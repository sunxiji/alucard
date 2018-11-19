/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-11-19 14:07:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', '1', '123');
INSERT INTO `t_user` VALUES ('3', '2', '1234');
INSERT INTO `t_user` VALUES ('4', '3', '12345');
INSERT INTO `t_user` VALUES ('5', '4', '123');
INSERT INTO `t_user` VALUES ('6', '5', '5');
INSERT INTO `t_user` VALUES ('7', '5', '5');
INSERT INTO `t_user` VALUES ('8', '5', '5');
INSERT INTO `t_user` VALUES ('9', '44', '4');
INSERT INTO `t_user` VALUES ('10', '44', '4');
INSERT INTO `t_user` VALUES ('11', '55', '5');
INSERT INTO `t_user` VALUES ('12', '6', '5');
INSERT INTO `t_user` VALUES ('13', '7', '6');
INSERT INTO `t_user` VALUES ('14', '54', '7');
INSERT INTO `t_user` VALUES ('15', '45', '8');
INSERT INTO `t_user` VALUES ('16', '54', '2');
INSERT INTO `t_user` VALUES ('17', '入3', '3');
INSERT INTO `t_user` VALUES ('18', '34', '4');
INSERT INTO `t_user` VALUES ('19', '3', '5');
INSERT INTO `t_user` VALUES ('20', '3', '6');
INSERT INTO `t_user` VALUES ('21', '3', '2');
