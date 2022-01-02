SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `age` int(11) NOT NULL,
  `birthday` date NOT NULL DEFAULT '2000-01-01',
  `email` varchar(20) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES ('1', 'Sam', '21', '1999-05-04', '123456789@qq.com', 'China');
INSERT INTO `stu_info` VALUES ('2', 'Bob', '35', '1985-12-03', 'bobbob@gmail.com', 'USA');
INSERT INTO `stu_info` VALUES ('3', 'Steven', '25', '1995-03-03', 'steven521@gmail.com', 'UK');
INSERT INTO `stu_info` VALUES ('4', 'Amy', '20', '2000-01-01', 'amy20205205@163.com', 'China');
INSERT INTO `stu_info` VALUES ('5', 'Eleven', '19', '2001-07-02', '11more11@163.com', 'China');
INSERT INTO `stu_info` VALUES ('6', 'Miffy', '20', '2000-08-10', 'miffy521@126.com', 'Japan');
INSERT INTO `stu_info` VALUES ('7', 'HHH', '1', '2020-07-25', 'hhhhhh@hhh.com', 'China');

-- ----------------------------
-- Procedure structure for insert_new_student
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_new_student`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_student`(IN studentName VARCHAR(255), IN studentAge INT, IN studentBirthday DATETIME, IN studentEmail VARCHAR(255), IN studentCountry VARCHAR(255))
BEGIN
    # 定义变量 插入前最大ID
    DECLARE maxId INT;
    # 定义变量 插入后最大ID 用于比较
    DECLARE newId INT;
    # 定义变量 执行后的结果
    DECLARE state VARCHAR(255);
    # 这里的一个细节是：可以对Age和Birthday的关系进行一个judge，我觉得太麻烦不想写……
    # 获取插入信息前的最大ID（ID为主键且自增1）
    SELECT MAX(id) INTO maxId FROM stu_info;
    # 插入新的一条学生信息
    INSERT INTO stu_info VALUES (NULL, studentName, studentAge, studentBirthday, studentEmail, studentCountry);
    # 获取插入信息后的最大ID
    SELECT MAX(id) INTO newId FROM stu_info;
    # 通过ID判断是否插入成功
    IF maxId+1 = newId THEN
        SET state = '新增学生信息成功';
    ELSE
        SET state = '新增学生信息失败';
    # END IF必须有
    END IF;
# 存储过程结束
END
;;
DELIMITER ;
