package com.blankspace.stuinfo;

import java.awt.EventQueue;

import com.blankspace.stuinfo.view.StudentInfoTable;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new StudentInfoTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
