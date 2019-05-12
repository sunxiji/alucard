/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : design_pattern

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-12 18:05:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for payment_channel
-- ----------------------------
DROP TABLE IF EXISTS `payment_channel`;
CREATE TABLE `payment_channel` (
  `id` int(11) NOT NULL,
  `channel_name` varchar(255) DEFAULT NULL,
  `channel_id` varchar(255) DEFAULT NULL,
  `strategy_bean_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of payment_channel
-- ----------------------------
INSERT INTO `payment_channel` VALUES ('1', '支付宝渠道', 'ali_pay', 'aliPayStrategy');
INSERT INTO `payment_channel` VALUES ('2', '小米支付渠道', 'xiaomi_pay', 'xiaoMiPayStrategy');
INSERT INTO `payment_channel` VALUES ('3', '银联支付渠道', 'union_pay', 'unionPayStrategy');
INSERT INTO `payment_channel` VALUES ('4', '微信支付渠道', 'wechat_pay', 'wechatPayStrategy');
