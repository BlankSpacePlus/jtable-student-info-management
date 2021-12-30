package com.blankspace.stuinfo.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.blankspace.stuinfo.controller.StudentInfoController;

public class StudentInfoTable extends JFrame {

	private static final long serialVersionUID = 1L;

	private final StudentInfoController controller =
            StudentInfoController.getController();

	// 定义二维数据作为列表内容
    private Object[][] tableInfo;

    // 定义一维数据作为列标题
    private static final Object[] columnTitle =
            {"学生ID", "学生姓名", "学生年龄", "学生生日", "学生Email", "学生家庭住址"};

	public StudentInfoTable() {
		setTitle("学生信息首页");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1266, 725);
        JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(59, 98, 1124, 534);
		contentPane.add(scrollPane);

        tableInfo = controller.getAllStudentInfo();
        DefaultTableModel model = new DefaultTableModel(tableInfo, columnTitle);
        JTable table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton button_refresh = new JButton("刷新");
		button_refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                tableInfo = controller.getAllStudentInfo();
                // 充分利用Swing的MVC模式
                model.setDataVector(tableInfo, columnTitle);
			}
		});
        button_refresh.setBounds(59, 30, 153, 39);
		button_refresh.setIcon(new ImageIcon(Objects.requireNonNull(
                StudentInfoTable.class.getResource("/images/refresh.png"))));
		button_refresh.setFont(new Font("楷体", Font.BOLD, 25));
		contentPane.add(button_refresh);
		
		JButton button_lock = new JButton("锁定");
		button_lock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    // 设置表格内容不可编辑
                table.setEnabled(false);
			}
		});
        button_lock.setBounds(285, 30, 153, 39);
		button_lock.setIcon(new ImageIcon(Objects.requireNonNull(
                StudentInfoTable.class.getResource("/images/lock.png"))));
		button_lock.setFont(new Font("楷体", Font.BOLD, 25));
		contentPane.add(button_lock);
		
		JButton button_unlock = new JButton("解锁");
		button_unlock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                // 设置表格内容可编辑
			    table.setEnabled(true);
			}
		});
        button_unlock.setBounds(505, 30, 153, 39);
		button_unlock.setIcon(new ImageIcon(Objects.requireNonNull(
                StudentInfoTable.class.getResource("/images/unlock.png"))));
		button_unlock.setFont(new Font("楷体", Font.BOLD, 25));
		contentPane.add(button_unlock);
	}

}
