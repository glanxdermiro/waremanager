/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : localhost:3308
 Source Schema         : warehousemanager

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 31/07/2024 21:04:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ware
-- ----------------------------
DROP TABLE IF EXISTS `ware`;
CREATE TABLE `ware`  (
  `wID` int(20) NOT NULL,
  `wno` int(20) NOT NULL,
  `wName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `wV` int(20) NOT NULL,
  `wAddress` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`wID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
