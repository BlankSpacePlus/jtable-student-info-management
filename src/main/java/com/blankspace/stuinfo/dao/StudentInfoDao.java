package com.blankspace.stuinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blankspace.stuinfo.pojo.StudentInfo;

/**
 * JDBC访问数据库
 */
public class StudentInfoDao {

    private static StudentInfoDao dao;

    private StudentInfoDao() {}

    /**
     * 获取该类单例对象
     * @return 单例对象
     */
    public static StudentInfoDao getDaoObj() {
        if (dao == null) {
            dao = new StudentInfoDao();
        }
        return dao;
    }

    /**
     * 查询所有的学生信息
     * @return 所有的学生信息
     */
    public List<StudentInfo> queryAllStudentInfo() {
        MySQLConnector connector = new MySQLConnector();
        Connection connection = connector.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM stu_info";
        List<StudentInfo> list = new ArrayList<>();
        StudentInfo tempResult;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tempResult = new StudentInfo();
                tempResult.setId(resultSet.getInt(1));
                tempResult.setName(resultSet.getString(2));
                tempResult.setAge(resultSet.getInt(3));
                tempResult.setBirthday(resultSet.getDate(4));
                tempResult.setEmail(resultSet.getString(5));
                tempResult.setCountry(resultSet.getString(6));
                list.add(tempResult);
            }
        } catch (SQLException e) {
            System.err.println("SQL查询异常");
        } finally {
            connector.closeConnection(resultSet, statement, connection);
        }
        return list;
    }

    /**
     * 加载数据库驱动的内部类
     */
    private static class MySQLConnector {
        Connection getConnection() {
            String driverName="com.mysql.cj.jdbc.Driver";
            String dbURL="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
            String userName="root";
            String userPassword="123456";
            try{
                Class.forName(driverName);
            } catch(ClassNotFoundException e) {
                System.err.println("加载MySQL驱动失败");
            }
            Connection dbConnection = null;
            try {
                dbConnection = DriverManager.getConnection(dbURL, userName, userPassword);
            } catch(SQLException e) {
                System.err.println("数据库连接失败");
                e.printStackTrace();
            }
            return dbConnection;
        }
        void closeConnection(ResultSet resultSet, Statement statement, Connection dbConnection){
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("关闭通道失败");
                }
            }
            if(dbConnection!=null){
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    System.err.println("关闭数据库连接失败");
                }
            }
        }
    }

}
