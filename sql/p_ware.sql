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

 Date: 31/07/2024 21:04:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for p_ware
-- ----------------------------
DROP TABLE IF EXISTS `p_ware`;
CREATE TABLE `p_ware`  (
  `pwID` int(20) NOT NULL,
  `pwpID` int(20) NOT NULL,
  `pwwID` int(20) NOT NULL,
  PRIMARY KEY (`pwID`, `pwpID`, `pwwID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
