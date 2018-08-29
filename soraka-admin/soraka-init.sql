/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : soraka

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-08-29 21:03:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  `parent_id` bigint(20) NOT NULL COMMENT '父部门ID',
  `status` int(10) NOT NULL DEFAULT '1' COMMENT '状态：0不可用1可用',
  `sequence` int(10) DEFAULT NULL COMMENT '排序',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
  `create_user` bigint(20) NOT NULL COMMENT '创建人ID',
  `modify_user` bigint(20) NOT NULL COMMENT '修改人ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '研发部', '0', '1', '1', '0', '1', '1', '2018-08-16 20:04:41', '2018-08-16 20:04:40');
INSERT INTO `sys_dept` VALUES ('2', '市场部', '0', '1', '2', '0', '1', '1', '2018-08-29 14:31:45', '2018-08-29 14:31:45');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '资源名称',
  `type` int(10) NOT NULL COMMENT '类型：1菜单2按钮',
  `url` varchar(255) DEFAULT NULL COMMENT '资源地址',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限字符串',
  `ico` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `level` int(10) DEFAULT NULL COMMENT '菜单等级',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点ID',
  `sequence` int(10) DEFAULT NULL COMMENT '排序',
  `status` int(10) NOT NULL DEFAULT '1' COMMENT '状态：0不可用1可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '1', '/admin', '', 'fa fa-desktop', '1', '0', '1', '1', '2018-08-16 16:53:22', '2018-08-16 16:53:22');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', '1', '/user', null, 'fa fa-paw', '1', '0', '0', '1', '2018-08-29 13:27:19', '2018-08-29 13:27:19');
INSERT INTO `sys_menu` VALUES ('3', '角色管理', '1', '/role', null, 'fa fa-user', '1', '0', '2', '1', '2018-08-29 13:27:59', '2018-08-29 13:27:59');
INSERT INTO `sys_menu` VALUES ('4', '菜单管理', '1', '/menu', null, 'fa fa-th-list', '1', '0', '3', '1', '2018-08-29 13:28:23', '2018-08-29 13:28:23');
INSERT INTO `sys_menu` VALUES ('5', '部门管理', '1', '/dept', null, null, '1', '0', '4', '1', '2018-08-29 13:30:47', '2018-08-29 13:30:47');
INSERT INTO `sys_menu` VALUES ('6', '内容管理', '1', '', null, null, '1', '0', '5', '1', '2018-08-29 13:34:33', '2018-08-29 13:34:33');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) NOT NULL COMMENT '角色Key',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(10) NOT NULL DEFAULT '1' COMMENT '状态：0不可用1可用',
  `create_user` bigint(20) NOT NULL COMMENT '创建人ID',
  `modify_user` bigint(20) NOT NULL COMMENT '修改人ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', '拥有系统所有权限', '1', '1', '1', '2018-08-15 13:35:36', '2018-08-15 13:35:36');
INSERT INTO `sys_role` VALUES ('2', 'tech', '研发', '拥有研发人员权限', '1', '1', '1', '2018-08-29 14:27:05', '2018-08-29 14:27:05');
INSERT INTO `sys_role` VALUES ('3', 'editor', '编辑', '拥有编辑人员权限', '1', '1', '1', '2018-08-29 14:27:30', '2018-08-29 14:27:30');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('5', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('6', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('7', '2', '1');
INSERT INTO `sys_role_menu` VALUES ('8', '2', '2');
INSERT INTO `sys_role_menu` VALUES ('9', '2', '3');
INSERT INTO `sys_role_menu` VALUES ('10', '2', '4');
INSERT INTO `sys_role_menu` VALUES ('11', '2', '5');
INSERT INTO `sys_role_menu` VALUES ('12', '3', '6');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '系统用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `mobilephone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(32) NOT NULL COMMENT '盐值',
  `gender` int(10) NOT NULL DEFAULT '0' COMMENT '性别：0未知1女2男',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `status` int(10) NOT NULL DEFAULT '1' COMMENT '状态：0不可用1可用',
  `create_user` bigint(20) NOT NULL COMMENT '创建人ID',
  `modify_user` bigint(20) NOT NULL COMMENT '修改人ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记：0未删除1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'soraka', '索拉卡', '13199998888', 'soraka@soraka.com', '108bc499f1892313a191e71f108ec8ea', 'pmoBuWgb', '0', '1', '1', '1', '1', '2018-08-15 17:58:07', '2018-08-15 17:58:07', '0');
INSERT INTO `sys_user` VALUES ('2', 'mayun', '马云', '13177778888', 'yun.ma@soraka.com', '108bc499f1892313a191e71f108ec8ea', 'pmoBuWgb', '0', '2', '1', '1', '1', '2018-08-29 14:31:13', '2018-08-29 14:31:13', '0');
INSERT INTO `sys_user` VALUES ('3', 'mahuateng', '马化腾', '13166668888', 'huateng.ma@soraka.com', '108bc499f1892313a191e71f108ec8ea', 'pmoBuWgb', '0', '1', '1', '1', '1', '2018-08-29 14:32:44', '2018-08-29 14:32:44', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '3');
INSERT INTO `sys_user_role` VALUES ('3', '3', '2');
