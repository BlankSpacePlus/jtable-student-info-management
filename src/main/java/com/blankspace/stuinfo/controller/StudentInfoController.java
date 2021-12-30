package com.blankspace.stuinfo.controller;

import java.util.List;

import com.blankspace.stuinfo.pojo.StudentInfo;
import com.blankspace.stuinfo.service.StudentInfoManagement;
import com.blankspace.stuinfo.service.impl.StudentInfoManagementImpl;

public class StudentInfoController {

    private final StudentInfoManagement management = StudentInfoManagementImpl.getManagementObj();

    private static StudentInfoController controller;

    private StudentInfoController() {}

    public static StudentInfoController getController() {
        if (controller == null) {
            controller = new StudentInfoController();
        }
        return controller;
    }

    public Object[][] getAllStudentInfo() {
        List<StudentInfo> list = management.getAllStudentInfo();
        int length = list.size();
        Object[][] data = new Object[length][6];
        for (int i = 0; i < length; i++) {
            StudentInfo info = list.get(i);
            data[i][0] = info.getId();
            data[i][1] = info.getName();
            data[i][2] = info.getAge();
            data[i][3] = info.getBirthday();
            data[i][4] = info.getEmail();
            data[i][5] = info.getCountry();
        }
        return data;
    }

}
