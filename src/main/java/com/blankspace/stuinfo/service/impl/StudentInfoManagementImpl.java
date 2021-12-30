package com.blankspace.stuinfo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.blankspace.stuinfo.dao.StudentInfoDao;
import com.blankspace.stuinfo.dao.StudentInfoMapper;
import com.blankspace.stuinfo.pojo.StudentInfo;
import com.blankspace.stuinfo.pojo.StudentInfoExample;
import com.blankspace.stuinfo.service.StudentInfoManagement;

public class StudentInfoManagementImpl implements StudentInfoManagement {

    private final StudentInfoDao dao = StudentInfoDao.getDaoObj();

    private SqlSessionFactory sqlSessionFactory;

    private StudentInfoManagementImpl() {
        // 加载配置文件
        String resource = "mybatisConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 根据mybatis的配置创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            System.err.println("加载MyBatis配置文件失败");
        }
    }

    private static StudentInfoManagementImpl management;

    public static StudentInfoManagementImpl getManagementObj() {
        if (management == null) {
            management = new StudentInfoManagementImpl();
        }
        return management;
    }

    @Override
    public List<StudentInfo> getAllStudentInfo() {
        // 使用JDBC普通方法
        // return dao.queryAllStudentInfo();

        // 使用MyBatis
        SqlSession session = sqlSessionFactory.openSession();
        StudentInfoMapper mapper = session.getMapper(StudentInfoMapper.class);

        // 执行查询
        StudentInfoExample example = new StudentInfoExample();
        StudentInfoExample.Criteria criteria = example.createCriteria();
        List<StudentInfo> list = mapper.selectByExample(example);

        session.close();
        return list;
    }

}
