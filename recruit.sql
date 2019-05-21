/*
 Navicat Premium Data Transfer

 Source Server         : 上海
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 101.132.164.250:3306
 Source Schema         : recruit

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 21/05/2019 19:45:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for TBL_EDU_EXP
-- ----------------------------
DROP TABLE IF EXISTS `TBL_EDU_EXP`;
CREATE TABLE `TBL_EDU_EXP`  (
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `START_TIME` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '入学时间',
  `END_TIME` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '毕业时间',
  `DEGREE` varchar(10) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '学历',
  `PROFESSION` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '专业',
  `RESERVED1` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED2` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED3` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of TBL_EDU_EXP
-- ----------------------------
INSERT INTO `TBL_EDU_EXP` VALUES (1, '20190406000000', '20190408000000', '硕士', '自动', NULL, NULL, NULL);
INSERT INTO `TBL_EDU_EXP` VALUES (2, '20190412000000', '20190420000000', '本科', 'shit', NULL, NULL, NULL);
INSERT INTO `TBL_EDU_EXP` VALUES (3, '20190403000000', '20190427000000', '本科', '计算机', NULL, NULL, NULL);
INSERT INTO `TBL_EDU_EXP` VALUES (6, '20190403000000', '20190412000000', '大学', '计算机科学与技术', NULL, NULL, NULL);
INSERT INTO `TBL_EDU_EXP` VALUES (9, '20190409000000', '20190417000000', '大专', '保安', NULL, NULL, NULL);
INSERT INTO `TBL_EDU_EXP` VALUES (10, '20190420000000', '20190430000000', '大学', '计算机', NULL, NULL, NULL);
INSERT INTO `TBL_EDU_EXP` VALUES (11, '20190507000000', '20190516000000', '大', '打算', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for TBL_POSITION
-- ----------------------------
DROP TABLE IF EXISTS `TBL_POSITION`;
CREATE TABLE `TBL_POSITION`  (
  `POSITION_ID` int(255) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `POSITION_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '职位名称',
  `WORK_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '职位类型(全职/兼职/实习)',
  `SALARY` decimal(10, 2) NOT NULL COMMENT '薪资',
  `SALARY_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '薪资类型',
  `EDU_REQUIREMENT` varchar(20) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '学历要求',
  `WORK_REQUIREMENT` varchar(20) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '工作经验要求',
  `WORK_AREA` varchar(20) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '工作地点',
  `WORK_DESCRIPTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '工作描述',
  PRIMARY KEY (`POSITION_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of TBL_POSITION
-- ----------------------------
INSERT INTO `TBL_POSITION` VALUES (1, 'IT工程师', '00', 8000.00, '00', '本科', '无', '上海', '当IT工程师，要修电脑，还要干杂活，工资也不高');
INSERT INTO `TBL_POSITION` VALUES (2, 'JAVA工程师', '00', 15000.00, '00', '本科', '1年工作经验', '上海', 'JAVA工程师天天加班，但是工资还行。');
INSERT INTO `TBL_POSITION` VALUES (3, '.net工程师', '01', 300.00, '01', '本科', '无', '上海', '在你开发项目前，首先要帮公司寻找其他.net工程师，因为这个项目组里的.net工程师目前加你就2个人');
INSERT INTO `TBL_POSITION` VALUES (5, '扫地阿姨', '00', 5000.00, '00', '无', '无', '上海', '打扫卫生');
INSERT INTO `TBL_POSITION` VALUES (10, '护士小姐', '00', 12000.00, '00', '本科', '无', '上海', '照顾病人');

-- ----------------------------
-- Table structure for TBL_POSITION_APP
-- ----------------------------
DROP TABLE IF EXISTS `TBL_POSITION_APP`;
CREATE TABLE `TBL_POSITION_APP`  (
  `USER_ID` int(11) NOT NULL,
  `POSITION_ID` int(11) NOT NULL,
  `RESUME_ID` int(11) NOT NULL,
  `STATUS` varchar(4) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `APP_TIME` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `PROCESS_TIME` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED1` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED2` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED3` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`, `POSITION_ID`, `RESUME_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of TBL_POSITION_APP
-- ----------------------------
INSERT INTO `TBL_POSITION_APP` VALUES (1, 1, 1, '01', '20190429161312', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (1, 2, 1, '00', '20190429161310', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (1, 3, 1, '01', '20190429161309', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (1, 5, 1, '01', '20190429161156', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (1, 10, 1, '00', '20190429165712', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (9, 2, 5, '00', '20190429162349', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (10, 5, 6, '01', '20190429165425', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (11, 1, 7, '99', '20190507105514', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (11, 2, 7, '99', '20190507105554', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (11, 5, 7, '99', '20190509114056', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (11, 10, 7, '99', '20190508111924', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (18, 1, 10, '99', '20190515125857', NULL, NULL, NULL, NULL);
INSERT INTO `TBL_POSITION_APP` VALUES (20, 1, 11, '99', '20190515130331', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for TBL_RESUME
-- ----------------------------
DROP TABLE IF EXISTS `TBL_RESUME`;
CREATE TABLE `TBL_RESUME`  (
  `RESUME_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '简历表ID',
  `USER_ID` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `REAL_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `SEX` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `BIRTHDAY` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `USER_PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `ADDRESS` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '地址',
  `MARRIAGE` varchar(2) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '婚姻状况',
  `AREA` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '求职意向地点',
  `POSITION` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '求职岗位',
  `SALARY_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '薪资类型(日薪/月薪)',
  `TARGET_SALARY` decimal(10, 0) NULL DEFAULT NULL COMMENT '期望薪资',
  `WORK_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '工作类型(全职/兼职/实习)',
  `ARRIVAL_TIME` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '到岗时间',
  `RESERVED1` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED2` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED3` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`RESUME_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of TBL_RESUME
-- ----------------------------
INSERT INTO `TBL_RESUME` VALUES (1, 1, '张二', '00', '19910315000000', '13313313333', '上海市黄浦区', '00', '上海', '.net工程师', '00', 1200, '00', '20190427000000', '998811717@qq.com', '00', NULL);
INSERT INTO `TBL_RESUME` VALUES (2, 2, '李四', '01', '19920502000000', '13613613666', '上海市青浦区', '01', '浙江', 'IT工程师', '01', 300, '02', '20190509000000', '899986432@qq.com', '00', NULL);
INSERT INTO `TBL_RESUME` VALUES (3, 3, '王毅', '00', '20190413000000', '1231411111', '上海市浦东新区', '01', '杭州', 'java工程师', '00', 1000000, '01', '20190404000000', 'qwe@qq.com', '00', NULL);
INSERT INTO `TBL_RESUME` VALUES (4, 6, '孔雀', '00', '20190403000000', '13413444466', '上海', '00', '上海', '工程师', '00', 12000, '00', '20190418000000', '6459163@qq.com', '00', NULL);
INSERT INTO `TBL_RESUME` VALUES (5, 9, '毛六', '00', '20190408000000', '5437681349', '上海', '00', '上海', '保安', '00', 8000, '00', '20190415000000', '84848484@qq.com', '00', NULL);
INSERT INTO `TBL_RESUME` VALUES (6, 10, '天五', '01', '20190401000000', '1381316183', '上海', '01', '上海', '护士', NULL, 6400, NULL, '20190410000000', '586689@qq.com', '00', NULL);
INSERT INTO `TBL_RESUME` VALUES (7, 11, 'fds', '00', '20190507000000', '12345678912', '郑州市高新区', '01', '郑州市', '安卓', NULL, 100, NULL, '20190508000000', '1234567@qq.com', NULL, NULL);
INSERT INTO `TBL_RESUME` VALUES (8, 12, '黄家鑫', '00', '20190514000000', '123', '1', '01', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL);
INSERT INTO `TBL_RESUME` VALUES (9, 17, '黄家鑫', '00', '20190515000000', '18862283897', '常熟', '00', NULL, NULL, NULL, NULL, NULL, NULL, '106388@qq.com', NULL, NULL);
INSERT INTO `TBL_RESUME` VALUES (10, 18, '黄家鑫', '00', '20190515000000', '18862283897', '常熟', '00', '南京', 'Java', NULL, 3000, NULL, '20190501000000', '106388@qq.com', NULL, NULL);
INSERT INTO `TBL_RESUME` VALUES (11, 20, '黄家鑫', '00', '20190515000000', '18862283897', '常熟', '00', NULL, NULL, NULL, NULL, NULL, NULL, '1063882767@qq.com', NULL, NULL);
INSERT INTO `TBL_RESUME` VALUES (12, 21, '黄家鑫', '00', '20190514000000', '18862283897', '常熟', '00', NULL, NULL, NULL, NULL, NULL, NULL, '1063882768@qq.com', NULL, NULL);

-- ----------------------------
-- Table structure for TBL_SYS_CODE
-- ----------------------------
DROP TABLE IF EXISTS `TBL_SYS_CODE`;
CREATE TABLE `TBL_SYS_CODE`  (
  `TYPE_CODE` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `TYPE_CN` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `TYPE_EN` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `DISPLAY1` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `DISPLAY2` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `STATUS` varchar(2) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `SHOW_ID` int(11) NULL DEFAULT NULL,
  `RESERVED1` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED2` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`TYPE_CODE`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of TBL_SYS_CODE
-- ----------------------------
INSERT INTO `TBL_SYS_CODE` VALUES ('POSITION_APP_STATUS:FAIL', '未通过', NULL, '01', NULL, '00', 1, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('POSITION_APP_STATUS:PASS', '已通过', NULL, '00', NULL, '00', 2, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('POSITION_APP_STATUS:PENDING', '待处理', NULL, '99', NULL, '00', 3, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('SYS_CODE_STATUS:ENABLE', '启用', NULL, '00', NULL, '00', 1, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('SYS_CODE_STATUS:STOP', '停用', NULL, '01', NULL, '00', 2, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_MARRIAGE:FALSE', '未婚', NULL, '00', NULL, '00', 1, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_MARRIAGE:TRUE', '已婚', NULL, '01', NULL, '00', 2, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_SALARY:DAILY', '日薪', NULL, '01', NULL, '00', 3, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_SALARY:MONTHLY', '月薪', NULL, '00', NULL, '00', 4, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_SEX:FEMALE', '女', NULL, '01', NULL, '00', 1, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_SEX:MALE', '男', NULL, '00', NULL, '00', 2, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_STATUS:ABNORMAL', '冻结', NULL, '01', NULL, '00', 2, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_STATUS:NORMAL', '正常', NULL, '00', NULL, '00', 1, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_TYPE:NORMAL_USER', '普通用户', NULL, '00', NULL, '00', 1, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('USER_TYPE:VIP_USER', 'VIP用户', NULL, '01', NULL, '00', 2, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('WORK_TYPE:FULL', '全职', NULL, '00', NULL, '00', 1, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('WORK_TYPE:PART', '兼职', NULL, '01', NULL, '00', 2, NULL, NULL);
INSERT INTO `TBL_SYS_CODE` VALUES ('WORK_TYPE:PRACITCE', '实习', NULL, '02', NULL, '00', 3, NULL, NULL);

-- ----------------------------
-- Table structure for TBL_USER
-- ----------------------------
DROP TABLE IF EXISTS `TBL_USER`;
CREATE TABLE `TBL_USER`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `USER_PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `PASSWORD` varchar(64) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `USER_STATUS` varchar(2) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL DEFAULT '00' COMMENT '00未激活；01正常；02冻结；03注销，04：预冻结',
  `USER_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `RESERVED1` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED2` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED3` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of TBL_USER
-- ----------------------------
INSERT INTO `TBL_USER` VALUES (1, 'admn', '123111111', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (2, 'shit', '123111111', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (3, 'king', '123111', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (4, 'admin', '111', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (5, 'test57', '13813864413', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (6, 'test99', '13813844466', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (8, 'test88', '13813844466', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (9, 'test77', '13403461545', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (10, 'test66', '138138644444', '111', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (11, '123456', '18739955104', '123456', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (12, '1', '123', '1', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (13, '092615203', '18862283897', '092615203', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (14, '123', '123456', '123', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (15, '2', '12', '12', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (16, '1236', '123456', '123456', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (17, '123456789', '123456789', '123456789', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (18, '0926152', '123456', '987654', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (19, '2580', '123456', '123456', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (20, '1063882767', '123456', '123456', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (21, '12345678', '13', '1234', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (22, '12345', '1234', '1234', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (23, '12', 'q23', '123', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (24, '12344', '123', '123', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (25, '456', '123', '123', '00', '00', NULL, NULL, NULL);
INSERT INTO `TBL_USER` VALUES (26, '092615204', '18862283897', '092615204', '00', '00', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for TBL_WORK_EXP
-- ----------------------------
DROP TABLE IF EXISTS `TBL_WORK_EXP`;
CREATE TABLE `TBL_WORK_EXP`  (
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `START_TIME` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '开始时间',
  `END_TIME` varchar(14) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '结束时间',
  `COMPANY` varchar(40) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '公司名称',
  `POSITION` varchar(10) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '职位',
  `DESCRIPTION` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL COMMENT '描述',
  `RESERVED1` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED2` varchar(200) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `RESERVED3` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of TBL_WORK_EXP
-- ----------------------------
INSERT INTO `TBL_WORK_EXP` VALUES (1, '20190407000000', '20190409000000', 'qq', 'itt', 'do it', NULL, NULL, NULL);
INSERT INTO `TBL_WORK_EXP` VALUES (2, '20190406000000', '20190409000000', 'hh', '.net', 'do .net', NULL, NULL, NULL);
INSERT INTO `TBL_WORK_EXP` VALUES (3, '20190405000000', '20190413000000', 'jiuyv', 'java', 'do java', NULL, NULL, NULL);
INSERT INTO `TBL_WORK_EXP` VALUES (6, '20190403000000', '20190405000000', 'aajk', '保安', '当保安', NULL, NULL, NULL);
INSERT INTO `TBL_WORK_EXP` VALUES (9, '20190409000000', '20190419000000', '建安街', '保安', '当保安', NULL, NULL, NULL);
INSERT INTO `TBL_WORK_EXP` VALUES (10, '20190401000000', '20190417000000', 'll', 'aa', 'zz', NULL, NULL, NULL);
INSERT INTO `TBL_WORK_EXP` VALUES (11, '20190507000000', '20190508000000', '记得哈萨克觉得', '安卓', '大声道撒多撒', NULL, NULL, NULL);
INSERT INTO `TBL_WORK_EXP` VALUES (20, '20190508000000', '20190516000000', '常熟理工', 'It', '计算机', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;