/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50559
 Source Host           : localhost:3306
 Source Schema         : example

 Target Server Type    : MySQL
 Target Server Version : 50559
 File Encoding         : 65001

 Date: 07/04/2020 21:15:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upd_tm` timestamp NULL DEFAULT NULL,
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '文章内容', '2020-03-28 15:28:13', 'admin', '2020-03-28 15:28:22', 'admin', '0');
INSERT INTO `article` VALUES (2, '莎士比亚', '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `article` VALUES (3, '亚里士多德', '2017-10-26 10:49:28', 'admin', '2017-11-18 09:54:15', 'admin', '1');
INSERT INTO `article` VALUES (10, '亚历山大', '2017-10-26 14:57:45', 'admin', '2017-11-08 13:28:52', 'admin', '1');
INSERT INTO `article` VALUES (11, '李白', '2017-10-26 15:23:42', 'admin', '2017-10-26 15:23:42', 'admin', '1');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) NULL DEFAULT NULL COMMENT '房屋id',
  `rent_id` bigint(20) NULL DEFAULT NULL COMMENT '租赁人id',
  `house_owner_id` bigint(20) NULL DEFAULT NULL COMMENT '出租者id',
  `rent_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租期',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '到期时间',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `upd_tm` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修订状态：1100.10 新建 1100.80 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋名称',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '街道',
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面积',
  `house_type` int(5) NULL DEFAULT NULL COMMENT '房屋类型',
  `orientation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '朝向',
  `payment` double(10, 0) NULL DEFAULT NULL COMMENT '租金',
  `subway` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地铁',
  `rent_type` int(5) NULL DEFAULT NULL COMMENT '租房类型（0整租，1合租）',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `upd_tm` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修订状态：1100.10 新建 1100.80 已删除',
  `isRent` bit(1) NULL DEFAULT NULL COMMENT '是否出租',
  `house_age` int(5) NULL DEFAULT NULL COMMENT '房龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) NULL DEFAULT NULL COMMENT '房屋id',
  `rent_id` bigint(20) NULL DEFAULT NULL COMMENT '租赁人id',
  `house_owner_id` bigint(20) NULL DEFAULT NULL COMMENT '出租人id',
  `money` double(20, 0) NULL DEFAULT NULL COMMENT '总金额',
  `is_pay` bit(5) NULL DEFAULT NULL COMMENT '是否支付',
  `deposit` double(20, 0) NULL DEFAULT NULL COMMENT '押金',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `upd_tm` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修订状态：1100.10 新建 1100.80 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for route
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '起点',
  `end` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终点',
  `look_points` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '途径点',
  `look_type` int(5) NULL DEFAULT NULL COMMENT '交通方式（0：公交，1：开车，2：骑行）',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `upd_tm` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修订状态：1100.10 新建 1100.80 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL DEFAULT 0 COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) NULL DEFAULT 2 COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是\"列表\"权限是必选',
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `upd_tm` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修订状态：1100.10 新建 1100.80 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (101, 'article', '文章管理', 'article:list', '列表', 1, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (102, 'article', '文章管理', 'article:add', '新增', 2, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (103, 'article', '文章管理', 'article:update', '修改', 2, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (601, 'user', '用户', 'user:list', '列表', 1, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (602, 'user', '用户', 'user:add', '新增', 2, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (603, 'user', '用户', 'user:update', '修改', 2, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (701, 'role', '角色权限', 'role:list', '列表', 1, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (702, 'role', '角色权限', 'role:add', '新增', 2, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (703, 'role', '角色权限', 'role:update', '修改', 2, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');
INSERT INTO `sys_permission` VALUES (704, 'role', '角色权限', 'role:delete', '删除', 2, '2017-10-25 09:08:45', 'admin', '2017-10-30 17:59:41', 'admin', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `upd_tm` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修订状态：1100.10 新建 1100.80 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', '2017-11-22 16:24:34', 'admin', '2017-11-22 16:24:52', 'admin', '1');
INSERT INTO `sys_role` VALUES (2, '出租者', '2017-11-22 16:24:34', 'admin', '2017-11-22 16:24:52', 'admin', '1');
INSERT INTO `sys_role` VALUES (3, '租赁者', '2017-11-22 16:28:47', 'admin', '2017-11-22 16:28:47', 'admin', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) NULL DEFAULT NULL COMMENT '权限id',
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `upd_tm` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修订状态：1100.10 新建 1100.80 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 2, 101, '2017-11-22 16:26:21', 'admin', '2017-11-22 16:26:32', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (2, 2, 102, '2017-11-22 16:26:21', 'admin', '2017-11-22 16:26:32', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (5, 2, 602, '2017-11-22 16:28:28', 'admin', '2017-11-22 16:28:28', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (6, 2, 601, '2017-11-22 16:28:28', 'admin', '2017-11-22 16:28:28', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (7, 2, 603, '2017-11-22 16:28:28', 'admin', '2017-11-22 16:28:28', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (8, 2, 703, '2017-11-22 16:28:28', 'admin', '2017-11-22 16:28:28', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (9, 2, 701, '2017-11-22 16:28:28', 'admin', '2017-11-22 16:28:28', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (10, 2, 702, '2017-11-22 16:28:28', 'admin', '2017-11-22 16:28:28', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (11, 2, 704, '2017-11-22 16:28:31', 'admin', '2017-11-22 16:28:31', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (12, 2, 103, '2017-11-22 16:28:31', 'admin', '2017-11-22 16:28:31', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (13, 3, 601, '2017-11-22 16:28:47', 'admin', '2017-11-22 16:28:47', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (14, 3, 701, '2017-11-22 16:28:47', 'admin', '2017-11-22 16:28:47', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (15, 3, 702, '2017-11-22 16:35:01', 'admin', '2017-11-22 16:35:01', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (16, 3, 704, '2017-11-22 16:35:01', 'admin', '2017-11-22 16:35:01', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (17, 3, 102, '2017-11-22 16:35:01', 'admin', '2017-11-22 16:35:01', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (18, 3, 101, '2017-11-22 16:35:01', 'admin', '2017-11-22 16:35:01', 'admin', '1');
INSERT INTO `sys_role_permission` VALUES (19, 3, 603, '2017-11-22 16:35:01', 'admin', '2017-11-22 16:35:01', 'admin', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `role_id` bigint(20) NULL DEFAULT 0 COMMENT '角色ID',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `crt_tm` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `crt_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `upd_tm` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `upd_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `edit_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修订状态：1100.10 新建 1100.80 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10008 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (10003, 'admin', '123456', '超级用户23', 1, '', '', '2017-10-30 11:52:38', 'admin', '2017-11-17 23:51:40', 'admin', '1');
INSERT INTO `sys_user` VALUES (10004, 'user', '123456', '莎士比亚', 2, '', '', '2017-10-30 16:13:02', 'admin', '2017-11-18 02:48:24', 'admin', '1');
INSERT INTO `sys_user` VALUES (10005, 'aaa', '123456', 'abba', 1, '', '', '2017-11-15 14:02:56', 'admin', '2017-11-17 23:51:42', 'admin', '1');
INSERT INTO `sys_user` VALUES (10007, 'test', '123456', '就看看列表', 3, '', '', '2017-11-22 16:29:41', 'admin', '2017-11-22 16:29:41', 'admin', '1');

SET FOREIGN_KEY_CHECKS = 1;
