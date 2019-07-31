/*
Navicat MySQL Data Transfer

Source Server         : xxx
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-07-31 17:48:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `guestbook`
-- ----------------------------
DROP TABLE IF EXISTS `guestbook`;
CREATE TABLE `guestbook` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`specialties`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`presentation`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=41

;

-- ----------------------------
-- Records of guestbook
-- ----------------------------
BEGIN;
INSERT INTO `guestbook` VALUES ('1', '123', '123', '123'), ('2', '456', '5+65', '4796'), ('3', '456', '5+65', '4796'), ('4', '456', '5+65', '4796'), ('5', '种树', null, null), ('27', '阿斯顿撒', '大神', '达到'), ('28', '撒大声地', '阿达', '打算的撒'), ('29', '撒大声地', '阿达', '打算的撒'), ('30', '达到', '大大', '大啊啊'), ('35', '种树', 'DAS', 'DAS'), ('36', '种树', '阿达', '大大'), ('37', '超数', '阿达', '啊啊啊啊'), ('38', '收到的', '啊实打实', '大傻傻的'), ('39', '绩效', '1234', '121'), ('40', '大傻傻的', '阿斯顿撒', '打算的撒');
COMMIT;

-- ----------------------------
-- Auto increment value for `guestbook`
-- ----------------------------
ALTER TABLE `guestbook` AUTO_INCREMENT=41;
