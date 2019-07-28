/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 28/07/2019 20:25:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_file
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file`;
CREATE TABLE `t_sys_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '显示名称',
  `suffix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后缀',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本信息id',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '版本号',
  `url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件存放url',
  `size` bigint(20) NOT NULL COMMENT '文件大小',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `state` bit(1) NULL DEFAULT b'1' COMMENT '逻辑删除用的标识',
  `key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对接OSS文件标识',
  `check_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对接OSS校验方式',
  `check_code` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对接OSS校验码',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统文件记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_file
-- ----------------------------
INSERT INTO `t_sys_file` VALUES (1, '11111111111111', 'JPG', NULL, 'f7cd975f85664684bae5773fb0a65281', 'C:\\Users\\X\\Desktop\\UP\\A\\DSC_0007.JPG', 4329813, '文件上传', b'1', NULL, NULL, NULL, '2019-03-27 15:53:26', '2019-07-18 22:35:39');
INSERT INTO `t_sys_file` VALUES (2, 'DSC_0007.JPG', 'JPG', NULL, '9a7c2ca266824757953370f8e49f3c3b', 'C:\\Users\\X\\Desktop\\UP\\A\\DSC_0007.JPG', 4329813, '文件上传', b'1', NULL, NULL, NULL, '2019-03-27 15:56:48', '2019-03-27 15:56:48');
INSERT INTO `t_sys_file` VALUES (3, 'DSC_0007.JPG', 'JPG', NULL, '40997c71f8c34acbbe61f9c182039b9a', 'C:\\Users\\X\\Desktop\\UP\\A\\15536735561936b0de16922f7489489e9511187ea366e_DSC_0007.JPG', 4329813, '文件上传', b'1', NULL, NULL, NULL, '2019-03-27 15:59:16', '2019-03-27 15:59:16');
INSERT INTO `t_sys_file` VALUES (21, '110525124534535435.JPG', 'JPG', NULL, 'fdsfsfsf', 'C:\\Users\\X\\Desktop\\UP\\A\\2222.JPG', 4329813, '文件上传', b'1', NULL, NULL, NULL, '2019-07-18 22:53:18', '2019-07-18 22:53:18');
INSERT INTO `t_sys_file` VALUES (22, '5555555555555555.JPG', 'JPG', NULL, 'fdsfsfsf', 'C:\\Users\\X\\Desktop\\UP\\A\\2222.JPG', 4329813, '文件上传', b'1', NULL, NULL, NULL, '2019-07-18 23:15:18', '2019-07-18 23:15:18');

SET FOREIGN_KEY_CHECKS = 1;
