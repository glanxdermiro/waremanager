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

 Date: 31/07/2024 21:03:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for p_stock
-- ----------------------------
DROP TABLE IF EXISTS `p_stock`;
CREATE TABLE `p_stock`  (
  `psID` int(20) NOT NULL,
  `pspID` int(20) NOT NULL,
  `pssID` int(20) NOT NULL,
  `inputDate` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`psID`, `pspID`, `pssID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
