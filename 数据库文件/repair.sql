/*
 Navicat Premium Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : propertyservicerequestsystem

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 27/08/2024 22:28:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `worker_id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '维修工人openid',
  `student_id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '报修人openid',
  `type` enum('normal','emergency') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单类型 normal为普通 emergency为紧急',
  `repair_Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '报修时间',
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '报修地址',
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '故障描述',
  `applicant_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申请人姓名',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申请人联系电话',
  `finish_Time` datetime NULL DEFAULT NULL COMMENT '维修完成时间',
  `repair_Cancel_Reason` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '报修取消原因',
  `repair_Cancel_Date` datetime NULL DEFAULT NULL COMMENT '报修取消时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 1为删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (6, NULL, '222', 'normal', '2024-08-27 20:15:44', '12栋6层666号', '描述报修问题', '邱帅哥', '11111111111', NULL, NULL, NULL, 0);
INSERT INTO `repair` VALUES (7, NULL, '222', 'emergency', '2024-08-27 21:46:49', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', NULL, NULL, NULL, 0);
INSERT INTO `repair` VALUES (8, NULL, '222', 'emergency', '2024-08-27 21:48:14', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', NULL, NULL, NULL, 0);
INSERT INTO `repair` VALUES (9, NULL, '222', 'emergency', '2024-08-27 21:48:46', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', NULL, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
