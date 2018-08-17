/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : soraka

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-08-17 16:24:34
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(10) NOT NULL DEFAULT '1' COMMENT '状态：0不可用1可用',
  `create_user` bigint(20) NOT NULL COMMENT '创建人ID',
  `modify_user` bigint(20) NOT NULL COMMENT '修改人ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
