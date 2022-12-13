/*
 Navicat Premium Data Transfer

 Source Server         : CSP584
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : csp584

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 30/11/2022 23:31:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `userid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `creditcard` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `street` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `orderquantity` int DEFAULT '0',
  `zipcode` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `createtime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `totalamount` double DEFAULT NULL,
  `productid` int DEFAULT NULL,
  `productname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (49, 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', '12345678888888', 'Illinois', 'Chicago', '2941 S Michigan Ave, 305', '3123949380', 30, '60616', '2022-11-28 08:07:58', 599.99, 14, 'biz2credit');
INSERT INTO `order` VALUES (50, 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave', '03123949380', 2, '60605', '2022-11-28 08:10:30', 349.99, 18, 'splash-financial-stu');
INSERT INTO `order` VALUES (52, 'binghan', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 12, '60616', '2022-11-29 05:14:07', 299.99, 11, 'Attribute');
INSERT INTO `order` VALUES (53, 'binghan', 'hannah@hawk.iit.edu', 'bgeng1@hawk.iit.edu', '12345678888888', 'Illinois', 'Chicago', '2941 S Michigan Ave, 305', '3123949380', 11, '60605', '2022-11-29 05:14:37', 1150.99, 20, 'Ladder-life');
INSERT INTO `order` VALUES (54, 'hannah', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '12345678888888', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 11, '60616', '2022-11-29 05:15:59', 1150.99, 20, 'Ladder-life');
INSERT INTO `order` VALUES (55, 'test', 'test1@hawk.iit.edu', 'test1@hawk.iit.edu', '12345678888888', 'Illinois', 'Chicago', '2941 S Michigan Ave, 305', '3123949380', 23, '60611', '2022-11-30 03:44:56', 299.99, 11, 'Attribute');
INSERT INTO `order` VALUES (56, 'gengbinghan@gmail.com', 'test1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', '11111', 'Illinois', 'Chicago', '2941 S Michigan Ave, 305', '3123949380', 11, '60615', '2022-11-30 07:50:19', 199.99, 17, 'credible-stu');
INSERT INTO `order` VALUES (57, 'gengbinghan@gmail.com', 'test1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', '11111', 'Illinois', 'Chicago', '2941 S Michigan Ave, 305', '3123949380', 11, '60606', '2022-11-30 07:50:19', 199.99, 17, 'credible-stu');
INSERT INTO `order` VALUES (58, 'tester1', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 2, '60616', '2022-11-21 08:23:58', 749, 28, 'JPMorgan');
INSERT INTO `order` VALUES (59, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 22, '60606', '2022-11-21 08:23:58', 749, 28, 'JPMorgan');
INSERT INTO `order` VALUES (60, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 11, '60616', '2022-11-21 08:23:58', 749, 29, 'JPMorgan');
INSERT INTO `order` VALUES (61, 'tester1', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 33, '60616', '2022-11-22 08:23:58', 749, 27, 'Merrill');
INSERT INTO `order` VALUES (62, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 22, '60606', '2022-11-22 08:23:58', 749, 27, 'Merrill');
INSERT INTO `order` VALUES (63, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 12, '60602', '2022-11-22 08:23:58', 749, 27, 'Merrill');
INSERT INTO `order` VALUES (64, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 11, '60601', '2022-11-24 08:23:58', 749, 26, 'FideLity');
INSERT INTO `order` VALUES (65, 'tester1', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 33, '60602', '2022-11-23 08:23:58', 749, 26, 'FideLity');
INSERT INTO `order` VALUES (66, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 22, '60616', '2022-11-23 08:23:58', 749, 26, 'FideLity');
INSERT INTO `order` VALUES (67, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 12, '60616', '2022-11-23 08:23:58', 749, 19, 'Mefa');
INSERT INTO `order` VALUES (68, 'tester1', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 33, '60601', '2022-11-25 08:23:58', 749, 19, 'Mefa');
INSERT INTO `order` VALUES (69, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 22, '60601', '2022-11-24 08:23:58', 749, 19, 'Mefa');
INSERT INTO `order` VALUES (70, 'gengbinghan@gmail.com', 'hannah@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave, 305', '03123949380', 12, '60601', '2022-11-24 08:23:58', 749, 19, 'Mefa');
COMMIT;

-- ----------------------------
-- Table structure for productcatalog
-- ----------------------------
DROP TABLE IF EXISTS `productcatalog`;
CREATE TABLE `productcatalog` (
  `productid` int NOT NULL,
  `name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `loanamount` double DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `manufacturer` varchar(45) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `creditscore` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of productcatalog
-- ----------------------------
BEGIN;
INSERT INTO `productcatalog` VALUES (11, 'Attribute', 299.99, 100000, 'imagesNew/11.jpg', 'PersonalLoans', 5, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (12, 'Marcus-per', 499.99, 40000, 'imagesNew/12.jpg', 'PersonalLoans', 4, 15, 'Loans', '580');
INSERT INTO `productcatalog` VALUES (13, 'lendingtree-per', 299.99, 50000, 'imagesNew/13.jpg', 'PersonalLoans', 5, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (14, 'biz2credit', 599.99, 6000000, 'imagesNew/14.jpg', 'BussinessLoans', 4, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (15, 'fundera', 499.99, 1000000, 'imagesNew/15.jpg', 'BussinessLoans', 5, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (16, 'lendio', 229.99, 2000000, 'imagesNew/16.jpg', 'BussinessLoans', 4.5, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (17, 'credible-stu', 199.99, 30000, 'imagesNew/17.jpg', 'StudentLoans', 3, 15, 'Loans', '580');
INSERT INTO `productcatalog` VALUES (18, 'splash-financial-stu', 349.99, 25000, 'imagesNew/18.jpg', 'StudentLoans', 3, 15, 'Loans', '590');
INSERT INTO `productcatalog` VALUES (19, 'mefa', 749, 35000, 'imagesNew/19.jpg', 'StudentLoans', 2, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (20, 'Ladder-life', 1150.99, NULL, 'imagesNew/20.jpg', 'LifeInsurance', 2, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (21, 'Lincole Financial', 1250, NULL, 'imagesNew/21.jpg', 'LifeInsurance', 10, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (22, 'Pacific Life', 499, NULL, 'imagesNew/22.jpg', 'LifeInsurance', 1, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (23, 'United Healthcare', 549, NULL, 'imagesNew/23.jpg', 'HealthInsurance', 1, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (24, 'Altrua', 749, NULL, 'imagesNew/24.jpg', 'HealthInsurance', 1, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (25, 'globe_life', 669, NULL, 'imagesNew/25.jpg', 'HealthInsurance', 3, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (26, 'Fidelity', 900, NULL, 'imagesNew/26.jpg', 'Stocks', 4, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (27, 'Merrill', 800, NULL, 'imagesNew/27.jpg', 'Stocks', 4, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (28, 'JPMorgan', 700, NULL, 'imagesNew/28.jpg', 'Stocks', 5, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (29, 'Bitcoin', 899.99, NULL, 'imagesNew/29.jpg', 'Cryptocurrency', 5, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (30, 'Ethereum', 1299.99, NULL, 'imagesNew/30.jpg', 'Cryptocurrency', 3, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (31, 'BUSD', 2099.99, NULL, 'imagesNew/31.jpg', 'Cryptocurrency', 2, 15, 'Investments', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mno` varchar(45) DEFAULT NULL,
  `preference` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('bgeng1@hawk.iit.edu', 'binghan', 'Binghan', 'Geng', 'bgeng1@hawk.iit.edu', '3123949380', 'loan', 0);
INSERT INTO `user` VALUES ('bgeng2@hawk.iit.edu', 'binghan', 'Binghan', 'Geng', 'bgeng2@hawk.iit.edu', '3123949380', 'insurance', 1);
INSERT INTO `user` VALUES ('hannah@hawk.iit.edu', 'binghan', 'Binghan', 'Geng', 'bgeng1@hawk.iit.edu', '8888888888', 'insurance', 1);
INSERT INTO `user` VALUES ('test1@hawk.iit.edu', 'binghan', 'Test1', 'Geng', 'test1@hawk.iit.edu', '3123949380', 'investment', 0);
INSERT INTO `user` VALUES ('test2@hawk.iit.edu', 'binghan', 'PM', 'Geng', 'test2@hawk.iit.edu', '3123949380', 'insurance', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
