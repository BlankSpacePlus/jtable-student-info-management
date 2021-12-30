# 简单信息管理功能

![](src/main/resources/images/UI.png)

## 开发技术

|  技术名称   | 技术用途  |
|:-------:|:-----:|
|  Swing  | 前端GUI |
|  JDBC   | 数据库访问 |
| MyBatis | 数据库访问 |

## 包结构划分
- dao 数据访问
- pojo 实体类
- service 业务逻辑接口
  - impl 业务逻辑实现类
- controller 前端控制器
- view 前端GUI实现

## JTable的一些基本信息
- [Java 11 API](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JTable.html)
- [JTable的一些基本用法](https://blog.csdn.net/Mrchai521/article/details/84502481)
- JTable页面基于JScrollPane，JScrollPane基于JFrame
- 前端界面的搭建可以使用Eclipse插件window-builder

## MyBatis的一些内容
- [在MyBatis中写SQL语句的一些体会](https://www.bbsmax.com/A/QV5Z88aVzy/)
- [MyBatis中文文档](https://mybatis.org/mybatis-3/zh/index.html)
- [mybatis-generator的generatorConfig.xml配置详解](https://www.cnblogs.com/f-society/p/11402847.html)
- MySQL高版本的话在写URL时需要加上TimeZone，靠&连接；可惜在配置文件中不允许用&，应该用&amp;来替换！<br/>
报错内容就是：<code>The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one time zone.</code>

## 图片来源
- [Iconfont-阿里云官网Logo](https://www.iconfont.cn/collections/detail?spm=a313x.7781069.1998910419.de12df413&cid=16472)
- ![](src/main/resources/images/lock.png) ![](src/main/resources/images/unlock.png) ![](src/main/resources/images/refresh.png)

## 更新日志
- 2020-07-24 将JDBC升级为MyBatis
- 2021-12-31 重构工程结构+CheckStyle+补充运行截图+调整细节
