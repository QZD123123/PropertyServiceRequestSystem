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

 Date: 04/09/2024 21:54:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for finished_repair
-- ----------------------------
DROP TABLE IF EXISTS `finished_repair`;
CREATE TABLE `finished_repair`  (
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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of finished_repair
-- ----------------------------
INSERT INTO `finished_repair` VALUES (5, '444', '222', 'emergency', '2024-08-27 21:46:49', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', '2024-09-04 16:36:34');
INSERT INTO `finished_repair` VALUES (6, '111', '939', 'emergency', '2024-09-04 18:40:45', '这是报修地址', '紧急订单', '田田', '2814229904', '2024-09-04 18:49:16');
INSERT INTO `finished_repair` VALUES (7, '292', '939', 'normal', '2024-09-04 18:39:49', '这是报修地址', '描述报修问题', '田睿', '2814229904', '2024-09-04 18:49:35');
INSERT INTO `finished_repair` VALUES (8, '111', '939', 'normal', '2024-09-04 18:39:50', '这是报修地址', '描述报修问题', '田睿', '2814229904', '2024-09-04 18:49:38');
INSERT INTO `finished_repair` VALUES (9, '436', '939', 'emergency', '2024-09-04 19:48:28', '这是报修地址', '紧急订单', '田田', '2814229904', '2024-09-04 19:51:04');
INSERT INTO `finished_repair` VALUES (10, '436', '939', 'emergency', '2024-09-04 19:48:29', '这是报修地址', '紧急订单', '田田', '2814229904', '2024-09-04 19:51:10');
INSERT INTO `finished_repair` VALUES (11, '436', '939', 'emergency', '2024-09-04 19:48:30', '这是报修地址', '紧急订单', '田田', '2814229904', '2024-09-04 19:51:13');

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
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (8, '111', '222', 'emergency', '2024-08-27 21:48:14', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', '2024-08-28 17:07:09');
INSERT INTO `repair` VALUES (9, '436', '222', 'emergency', '2024-08-27 21:48:46', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', NULL);
INSERT INTO `repair` VALUES (10, '436', '222', 'normal', '2024-08-28 22:08:59', '12栋6层666号', '描述报修问题', '邱帅哥', '11111111111', NULL);
INSERT INTO `repair` VALUES (11, '292', '222', 'emergency', '2024-08-28 22:11:15', '12栋6层666号', '测试紧急报修', '邱帅哥', '11111111111', NULL);
INSERT INTO `repair` VALUES (12, '292', '333', 'normal', '2024-08-30 10:23:07', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (13, '111', '333', 'emergency', '2024-08-30 10:24:00', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (14, '111', '#{openid}', 'normal', '2024-08-30 11:17:25', '#{addRepairInfo.repairLocation}', '#{addRepairInfo.description}', '#{addRepairInfo.studentName}', '111', NULL);
INSERT INTO `repair` VALUES (15, '444', '#{openid}', 'normal', '2024-08-30 11:29:40', '#{addRepairInfo.repairLocation}', '#{addRepairInfo.description}', '#{addRepairInfo.studentName}', '22222222', NULL);
INSERT INTO `repair` VALUES (16, '436', '#{openid}', 'normal', '2024-08-30 11:29:52', '#{addRepairInfo.repairLocation}', '#{addRepairInfo.description}', '#{addRepairInfo.studentName}', '22222222', NULL);
INSERT INTO `repair` VALUES (17, '292', '#{openid}', 'normal', '2024-08-30 11:31:55', '#{addRepairInfo.repairLocation}', '#{addRepairInfo.description}', '#{addRepairInfo.studentName}', '22222222', NULL);
INSERT INTO `repair` VALUES (18, '111', '#{openid}', 'normal', '2024-08-30 11:32:07', '#{addRepairInfo.repairLocation}', '#{addRepairInfo.description}', '#{addRepairInfo.studentName}', '333333', NULL);
INSERT INTO `repair` VALUES (20, '444', '333', 'normal', '2024-08-30 11:53:36', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (21, '436', '333', 'normal', '2024-08-30 11:53:45', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (22, '111', '333', 'normal', '2024-08-30 11:53:52', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', '2024-08-30 19:50:00');
INSERT INTO `repair` VALUES (23, '292', '333', 'normal', '2024-08-30 11:56:39', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (24, '111', '333', 'normal', '2024-08-30 11:57:20', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (25, '444', '333', 'normal', '2024-08-30 11:57:37', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (26, '436', '333', 'normal', '2024-08-30 11:57:44', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (27, '292', '333', 'normal', '2024-08-30 11:57:47', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (29, '111', '333', 'normal', '2024-08-30 12:00:26', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (30, '444', '333', 'normal', '2024-08-30 12:18:35', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (31, '436', '333', 'normal', '2024-08-30 12:21:45', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (32, '292', '222', 'normal', '2024-08-30 12:28:52', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (33, '444', '333', 'emergency', '2024-08-30 12:29:12', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (34, '436', '333', 'emergency', '2024-08-30 12:29:18', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (35, '292', '333', 'emergency', '2024-08-30 12:29:25', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (36, '111', '222', 'normal', '2024-08-30 12:29:57', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (37, '444', '222', 'normal', '2024-08-30 12:30:06', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (38, '436', '222', 'normal', '2024-08-30 12:51:23', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (39, '292', '222', 'normal', '2024-08-30 12:53:50', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (40, '111', '222', 'normal', '2024-08-30 12:53:59', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (41, '111', '222', 'emergency', '2024-08-30 12:56:35', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (42, '444', '222', 'emergency', '2024-08-30 12:56:50', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (43, '436', '222', 'emergency', '2024-08-30 12:56:51', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (44, '292', '222', 'emergency', '2024-08-30 12:56:59', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (45, '111', '222', 'emergency', '2024-08-30 13:01:04', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', '2024-08-30 19:49:38');
INSERT INTO `repair` VALUES (46, '444', '333', 'normal', '2024-08-30 19:51:42', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (47, '436', '333', 'normal', '2024-08-30 19:51:54', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (48, '292', '333', 'normal', '2024-08-30 19:51:59', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (49, '111', '222', 'normal', '2024-08-31 17:42:17', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (50, '292', '222', 'normal', '2024-08-31 17:42:34', '这是报修地址', '描述报修问题', '田睿', '2814229904', '2024-08-31 18:19:25');
INSERT INTO `repair` VALUES (51, '444', '222', 'normal', '2024-08-31 17:42:35', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (52, '444', '222', 'normal', '2024-08-31 17:42:41', '这是报修地址', '描述报修问题', '田睿', '2814229904', '2024-09-04 16:27:13');
INSERT INTO `repair` VALUES (53, '436', '73', 'normal', '2024-08-31 17:43:32', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (54, '292', '73', 'normal', '2024-08-31 17:43:34', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (55, '111', '73', 'normal', '2024-08-31 17:43:36', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (56, '444', '73', 'normal', '2024-08-31 17:43:37', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (57, '96', '73', 'emergency', '2024-08-31 17:44:06', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', '2024-08-31 17:46:05');
INSERT INTO `repair` VALUES (58, '96', '73', 'emergency', '2024-08-31 17:44:09', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', '2024-08-31 17:53:30');
INSERT INTO `repair` VALUES (59, '96', '73', 'emergency', '2024-08-31 17:44:10', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', '2024-08-31 17:53:22');
INSERT INTO `repair` VALUES (61, '436', '222', 'normal', '2024-09-04 17:04:25', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (62, '292', '222', 'normal', '2024-09-04 17:04:27', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (63, '111', '222', 'normal', '2024-09-04 17:04:28', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (64, '444', '222', 'normal', '2024-09-04 17:04:29', '这是报修地址', '描述报修问题', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (65, '111', '222', 'emergency', '2024-09-04 17:04:47', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (66, '444', '222', 'emergency', '2024-09-04 17:04:49', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (67, '436', '222', 'emergency', '2024-09-04 17:04:50', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (68, '292', '222', 'emergency', '2024-09-04 17:04:51', '这是报修地址', '紧急订单', '学生登录测试员', '1231231231', NULL);
INSERT INTO `repair` VALUES (73, '436', '939', 'normal', '2024-09-04 18:39:48', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (81, '111', '939', 'emergency', '2024-09-04 18:40:47', '这是报修地址', '紧急订单', '田田', '2814229904', NULL);
INSERT INTO `repair` VALUES (82, '292', '939', 'normal', '2024-09-04 19:48:17', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (83, '111', '939', 'normal', '2024-09-04 19:48:18', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (84, '444', '939', 'normal', '2024-09-04 19:48:19', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (85, '436', '939', 'normal', '2024-09-04 19:48:20', '这是报修地址', '描述报修问题', '田睿', '2814229904', NULL);
INSERT INTO `repair` VALUES (86, '444', '939', 'emergency', '2024-09-04 19:48:27', '这是报修地址', '紧急订单', '田田', '2814229904', NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `student_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_used` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`student_id`) USING BTREE,
  UNIQUE INDEX `idx_student_number`(`student_number` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '2130502141', '邱帅哥', '1');
INSERT INTO `student` VALUES (2, '1231231231', '学生登录测试员', '1');
INSERT INTO `student` VALUES (3, '2814229904', '田睿', '1');
INSERT INTO `student` VALUES (4, '100590555', '胡宇宁', '0');
INSERT INTO `student` VALUES (5, '76997887126', '郑嘉伦', '0');
INSERT INTO `student` VALUES (6, '75570990618', '林子韬', '0');
INSERT INTO `student` VALUES (7, '207401191', '侯子韬', '0');
INSERT INTO `student` VALUES (8, '2866606201', '罗睿', '0');
INSERT INTO `student` VALUES (9, '15611204009', '夏晓明', '0');
INSERT INTO `student` VALUES (10, '14539976206', '萧子异', '0');
INSERT INTO `student` VALUES (11, '7554517653', '雷秀英', '0');
INSERT INTO `student` VALUES (12, '15123008195', '段宇宁', '0');
INSERT INTO `student` VALUES (13, '112344433', '学生a', '0');

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `worker_id` int NOT NULL AUTO_INCREMENT,
  `worker_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `worker_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_used` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `normal_last_assigned` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `emergency_last_assigned` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `can_work` enum('yes','no') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'no',
  PRIMARY KEY (`worker_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES (1, '12312312312', '卡拉米', '1', '2024-09-04 19:48:19', '2024-09-04 19:48:30', 'yes');
INSERT INTO `worker` VALUES (2, '11111111111', '工人登录测试员', '1', '2024-09-04 19:48:20', '2024-09-04 19:48:29', 'yes');
INSERT INTO `worker` VALUES (3, '123', 'aaa', '1', '2024-09-04 19:48:18', '2024-09-04 19:48:28', 'yes');
INSERT INTO `worker` VALUES (4, '12123', 'qqqqq', '0', '2024-08-31 17:48:10', '2024-08-31 17:48:10', 'no');
INSERT INTO `worker` VALUES (5, '3221123322', '撒大苏打', '1', '2024-09-04 19:47:41', '2024-09-04 19:47:41', 'yes');
INSERT INTO `worker` VALUES (6, '2323232322', '测试管理员', '1', '2024-09-04 21:23:41', '2024-09-04 21:23:41', 'no');
INSERT INTO `worker` VALUES (7, '112344433', '管理员a', '0', '2024-09-04 21:37:24', '2024-09-04 21:37:24', 'no');
INSERT INTO `worker` VALUES (8, '112344433', '管理员b', '0', '2024-09-04 21:37:46', '2024-09-04 21:37:46', 'no');
INSERT INTO `worker` VALUES (9, '112344433', '工人a', '0', '2024-09-04 21:40:26', '2024-09-04 21:40:26', 'no');
INSERT INTO `worker` VALUES (10, '112344433', '工人a', '0', '2024-09-04 21:40:31', '2024-09-04 21:40:31', 'no');

-- ----------------------------
-- Table structure for wxuser
-- ----------------------------
DROP TABLE IF EXISTS `wxuser`;
CREATE TABLE `wxuser`  (
  `wxUser_id` int NOT NULL AUTO_INCREMENT,
  `wxUser_openid` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `wxUser_sessionkey` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` enum('worker','student','xxxx','admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'xxxx',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学号或者手机号码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`wxUser_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wxuser
-- ----------------------------
INSERT INTO `wxuser` VALUES (1, 'openid', 'sessionKey', 'student', NULL, NULL, '2024-08-22 22:50:11');
INSERT INTO `wxuser` VALUES (2, 'openid', 'sessionKey', 'student', NULL, NULL, '2024-08-22 22:50:38');
INSERT INTO `wxuser` VALUES (3, 'openid', 'sessionKey', 'student', NULL, NULL, '2024-08-22 22:53:40');
INSERT INTO `wxuser` VALUES (4, 'openid', 'sessionKey', 'xxxx', NULL, NULL, '2024-08-22 23:06:17');
INSERT INTO `wxuser` VALUES (5, 'openid', 'sessionKey', 'xxxx', NULL, NULL, '2024-08-22 23:07:05');
INSERT INTO `wxuser` VALUES (6, 'openid', 'sessionKey', 'xxxx', NULL, NULL, '2024-08-23 15:37:16');
INSERT INTO `wxuser` VALUES (7, '222', 'sessionKey', 'student', '2130502141', '邱帅哥', '2024-08-23 15:39:48');
INSERT INTO `wxuser` VALUES (8, '111', 'sessionKey', 'worker', '12312312312', '卡拉米', '2024-08-25 16:53:41');
INSERT INTO `wxuser` VALUES (10, '333', 'sessionKey', 'student', '1231231231', '学生登录测试员', '2024-08-28 14:47:28');
INSERT INTO `wxuser` VALUES (11, '444', 'sessionKey', 'worker', '11111111111', '工人登录测试员', '2024-08-28 15:36:55');
INSERT INTO `wxuser` VALUES (16, '292', 'sessionKey', 'admin', '123', 'aaa', '2013-06-10 04:20:29');
INSERT INTO `wxuser` VALUES (17, '436', 'sessionKey', 'worker', '3221123322', '撒大苏打', '2023-05-01 18:30:41');
INSERT INTO `wxuser` VALUES (18, '939', 'sessionKey', 'student', '2814229904', '田睿', '2015-10-15 15:54:36');
INSERT INTO `wxuser` VALUES (22, '321', 'sessionKey', 'admin', '2323232322', '测试管理员', '2024-09-04 21:21:45');

SET FOREIGN_KEY_CHECKS = 1;
