/*
Navicat MySQL Data Transfer

Source Server         : 192.168.2.214
Source Server Version : 50644
Source Host           : 192.168.2.214:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2020-01-06 19:44:18
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `_id`         bigint(20) NOT NULL,
    `name`        varchar(255)    DEFAULT NULL,
    `url`         varchar(255)    DEFAULT NULL,
    `level`       int(2)          DEFAULT NULL,
    `memo`        varchar(255)    DEFAULT NULL,
    `create_time` timestamp  NULL DEFAULT NULL,
    `update_time` timestamp  NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu`
VALUES ('1', 'zhikai', 'localhost:8080', '0', null, null, null);
INSERT INTO `sys_menu`
VALUES ('2', 'zhikai', 'localhost:8080', '0', null, null, null);
