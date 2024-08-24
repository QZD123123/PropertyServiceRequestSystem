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

 Date: 24/08/2024 18:17:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `worker_id` int NULL DEFAULT NULL COMMENT '维修工人id',
  `student_id` int NULL DEFAULT NULL COMMENT '报修人id',
  `type` tinyint NULL DEFAULT NULL COMMENT '订单类型 0为普通 1为紧急',
  `problem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '报修问题 水管破裂/漏水 无故停电/漏电 玻璃内裂',
  `repairDate` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '报修时间',
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '报修地址',
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '故障描述',
  `imageUrl` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '故障图片',
  `applicantName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请人姓名',
  `mobile` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请人联系电话',
  `star` tinyint NULL DEFAULT NULL COMMENT '几颗星',
  `evaluateDate` datetime NULL DEFAULT NULL COMMENT '评价时间',
  `openid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `finishTime` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '维修完成时间',
  `repairCancelReason` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '报修取消原因',
  `repairCancelDate` datetime NULL DEFAULT NULL COMMENT '报修取消时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `student_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `worker_id` int NOT NULL AUTO_INCREMENT,
  `worker_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `worker_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`worker_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worker
-- ----------------------------

-- ----------------------------
-- Table structure for wxuser
-- ----------------------------
DROP TABLE IF EXISTS `wxuser`;
CREATE TABLE `wxuser`  (
  `wxUser_id` int NOT NULL AUTO_INCREMENT,
  `wxUser_openid` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `wxUser_sessionkey` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stu_id` int NULL DEFAULT NULL,
  `worker_id` int NULL DEFAULT NULL,
  `role` enum('worker','student') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学号或者手机号码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`wxUser_id`) USING BTREE,
  INDEX `stu_id`(`stu_id` ASC) USING BTREE,
  INDEX `worker_id`(`worker_id` ASC) USING BTREE,
  CONSTRAINT `wxuser_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wxuser_ibfk_2` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`worker_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wxuser
-- ----------------------------
INSERT INTO `wxuser` VALUES (1, 'openid', 'sessionKey', NULL, NULL, 'student', NULL, NULL, 0, '2024-08-22 22:50:11');
INSERT INTO `wxuser` VALUES (2, 'openid', 'sessionKey', NULL, NULL, 'student', NULL, NULL, 0, '2024-08-22 22:50:38');
INSERT INTO `wxuser` VALUES (3, 'openid', 'sessionKey', NULL, NULL, 'student', NULL, NULL, 0, '2024-08-22 22:53:40');
INSERT INTO `wxuser` VALUES (4, 'openid', 'sessionKey', NULL, NULL, NULL, NULL, NULL, 0, '2024-08-22 23:06:17');
INSERT INTO `wxuser` VALUES (5, 'openid', 'sessionKey', NULL, NULL, NULL, NULL, NULL, 0, '2024-08-22 23:07:05');
INSERT INTO `wxuser` VALUES (6, 'openid', 'sessionKey', NULL, NULL, NULL, NULL, NULL, 0, '2024-08-23 15:37:16');
INSERT INTO `wxuser` VALUES (7, '222', 'sessionKey', NULL, NULL, NULL, NULL, NULL, 0, '2024-08-23 15:39:48');

SET FOREIGN_KEY_CHECKS = 1;
