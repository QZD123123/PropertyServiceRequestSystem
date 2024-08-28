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

 Date: 28/08/2024 18:39:10
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (7, '444', '222', 'emergency', '2024-08-27 21:46:49', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', NULL);
INSERT INTO `repair` VALUES (8, '111', '222', 'emergency', '2024-08-27 21:48:14', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', '2024-08-28 17:07:09');
INSERT INTO `repair` VALUES (9, '444', '222', 'emergency', '2024-08-27 21:48:46', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `student_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  UNIQUE INDEX `idx_student_number`(`student_number` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '2130502141', '邱帅哥');
INSERT INTO `student` VALUES (2, '1231231231', '学生登录测试员');
INSERT INTO `student` VALUES (3, '2814229904', '田睿');
INSERT INTO `student` VALUES (4, '100590555', '胡宇宁');
INSERT INTO `student` VALUES (5, '76997887126', '郑嘉伦');
INSERT INTO `student` VALUES (6, '75570990618', '林子韬');
INSERT INTO `student` VALUES (7, '207401191', '侯子韬');
INSERT INTO `student` VALUES (8, '2866606201', '罗睿');
INSERT INTO `student` VALUES (9, '15611204009', '夏晓明');
INSERT INTO `student` VALUES (10, '14539976206', '萧子异');
INSERT INTO `student` VALUES (11, '7554517653', '雷秀英');
INSERT INTO `student` VALUES (12, '15123008195', '段宇宁');

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `worker_id` int NOT NULL AUTO_INCREMENT,
  `worker_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `worker_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`worker_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES (1, '12312312312', '卡拉米');
INSERT INTO `worker` VALUES (2, '11111111111', '工人登录测试员');

-- ----------------------------
-- Table structure for wxuser
-- ----------------------------
DROP TABLE IF EXISTS `wxuser`;
CREATE TABLE `wxuser`  (
  `wxUser_id` int NOT NULL AUTO_INCREMENT,
  `wxUser_openid` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `wxUser_sessionkey` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` enum('worker','student','xxxx') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'xxxx',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学号或者手机号码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`wxUser_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wxuser
-- ----------------------------
INSERT INTO `wxuser` VALUES (1, 'openid', 'sessionKey', 'student', NULL, NULL, 0, '2024-08-22 22:50:11');
INSERT INTO `wxuser` VALUES (2, 'openid', 'sessionKey', 'student', NULL, NULL, 0, '2024-08-22 22:50:38');
INSERT INTO `wxuser` VALUES (3, 'openid', 'sessionKey', 'student', NULL, NULL, 0, '2024-08-22 22:53:40');
INSERT INTO `wxuser` VALUES (4, 'openid', 'sessionKey', 'xxxx', NULL, NULL, 0, '2024-08-22 23:06:17');
INSERT INTO `wxuser` VALUES (5, 'openid', 'sessionKey', 'xxxx', NULL, NULL, 0, '2024-08-22 23:07:05');
INSERT INTO `wxuser` VALUES (6, 'openid', 'sessionKey', 'xxxx', NULL, NULL, 0, '2024-08-23 15:37:16');
INSERT INTO `wxuser` VALUES (7, '222', 'sessionKey', 'student', '2130502141', '邱帅哥', 0, '2024-08-23 15:39:48');
INSERT INTO `wxuser` VALUES (8, '111', 'sessionKey', 'worker', '12312312312', '卡拉米', 0, '2024-08-25 16:53:41');
INSERT INTO `wxuser` VALUES (10, '333', 'sessionKey', 'student', '1231231231', '学生登录测试员', 0, '2024-08-28 14:47:28');
INSERT INTO `wxuser` VALUES (11, '444', 'sessionKey', 'worker', '11111111111', '工人登录测试员', 0, '2024-08-28 15:36:55');
INSERT INTO `wxuser` VALUES (12, '209', 'sessionKey', 'student', '100590555', '胡宇宁', 0, '2023-12-25 12:25:45');
INSERT INTO `wxuser` VALUES (13, '370', 'sessionKey', 'student', '2814229904', '田睿', 0, '2017-02-28 02:27:40');
INSERT INTO `wxuser` VALUES (14, '777', 'sessionKey', 'xxxx', NULL, NULL, 0, '2011-04-18 15:45:26');
INSERT INTO `wxuser` VALUES (15, '797', 'sessionKey', 'xxxx', NULL, NULL, 0, '2013-03-03 02:12:42');
INSERT INTO `wxuser` VALUES (16, '292', 'sessionKey', 'xxxx', NULL, NULL, 0, '2013-06-10 04:20:29');
INSERT INTO `wxuser` VALUES (17, '436', 'sessionKey', 'xxxx', NULL, NULL, 0, '2023-05-01 18:30:41');
INSERT INTO `wxuser` VALUES (18, '939', 'sessionKey', 'xxxx', NULL, NULL, 0, '2015-10-15 15:54:36');
INSERT INTO `wxuser` VALUES (19, '428', 'sessionKey', 'xxxx', NULL, NULL, 0, '2016-12-11 17:06:29');
INSERT INTO `wxuser` VALUES (20, '96', 'sessionKey', 'xxxx', NULL, NULL, 0, '2023-02-22 22:25:45');
INSERT INTO `wxuser` VALUES (21, '73', 'sessionKey', 'xxxx', NULL, NULL, 0, '2008-01-23 03:29:23');

SET FOREIGN_KEY_CHECKS = 1;
