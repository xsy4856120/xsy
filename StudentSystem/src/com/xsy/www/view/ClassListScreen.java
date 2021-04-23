package com.xsy.www.view;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.xsy.www.dao.ClassDao;
import com.xsy.www.dao.StudentDao;
import com.xsy.www.po.Student;
import com.xsy.www.po.StudentClass;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class ClassListScreen extends JInternalFrame {
	private JTextField GradetextField;
	private JTextField StudentSecondarytextField_1;
	private JTextField StudentMajortextField_2;
	private JTextField StudentClasstextField_3;
	private DefaultTableModel dtm = null;
	private JButton InquirebtnNewButton;
	private JTable ClassList;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClassListScreen frame = new ClassListScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ClassListScreen() {
		setTitle("\u67E5\u8BE2\u8BFE\u8868");
		this.setClosable(true);
		this.setIconifiable(true);;
		setBounds(100, 100, 759, 516);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6240\u5C5E\u5E74\u7EA7\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(53, 365, 76, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u5B66\u9662\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(53, 420, 76, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5C5E\u4E13\u4E1A\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(267, 367, 76, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(267, 422, 76, 15);
		getContentPane().add(lblNewLabel_3);
		
		GradetextField = new JTextField();
		GradetextField.setBounds(123, 364, 120, 21);
		getContentPane().add(GradetextField);
		GradetextField.setColumns(10);
		
		StudentSecondarytextField_1 = new JTextField();
		StudentSecondarytextField_1.setColumns(10);
		StudentSecondarytextField_1.setBounds(123, 419, 120, 21);
		getContentPane().add(StudentSecondarytextField_1);
		
		StudentMajortextField_2 = new JTextField();
		StudentMajortextField_2.setColumns(10);
		StudentMajortextField_2.setBounds(340, 364, 120, 21);
		getContentPane().add(StudentMajortextField_2);
		
		StudentClasstextField_3 = new JTextField();
		StudentClasstextField_3.setColumns(10);
		StudentClasstextField_3.setBounds(340, 419, 120, 21);
		getContentPane().add(StudentClasstextField_3);
		
		InquirebtnNewButton = new JButton("\u67E5\u8BE2");
		InquirebtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquire(e);
			}
		});
		InquirebtnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		InquirebtnNewButton.setBounds(541, 395, 97, 23);
		getContentPane().add(InquirebtnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 727, 329);
		getContentPane().add(scrollPane);
		
		ClassList = new JTable();
		ClassList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u79D1\u76EE", "\u79D1\u76EE\u4FE1\u606F", "\u6559\u5E08\u59D3\u540D", "\u4E13\u4E1A", "\u5B66\u9662", "\u5E74\u7EA7"
			}
		));
		ClassList.getColumnModel().getColumn(1).setPreferredWidth(120);
		scrollPane.setViewportView(ClassList);
		
		dtm = (DefaultTableModel) this.ClassList.getModel();}

	//学生选课查询（模糊查询）
	protected void Inquire(ActionEvent e) {
		
		
		// TODO 自动生成的方法存根
		StudentClass tempStudent = new StudentClass();  //获取学生输入的信息
		tempStudent.setGrade(GradetextField.getText());
		tempStudent.setSecondary(StudentSecondarytextField_1.getText());
		tempStudent.setMajor(StudentMajortextField_2.getText());
		tempStudent.setName(StudentClasstextField_3.getText());
		
		ArrayList<StudentClass> arrayList = new StudentDao().queryAllStudent();
		
		dtm.setRowCount(0);
		List<StudentClass> allStudent = new StudentDao().queryAllStudent();//将从数据库获取的信息填入表格
		for(StudentClass studentClass : arrayList) {
			Vector vector = new Vector();
			vector.add(studentClass.getRequireCourse());
			vector.add(studentClass.getInfo());
			vector.add(studentClass.getName());
			vector.add(studentClass.getMajor());
			vector.add(studentClass.getSecondary());
			vector.add(studentClass.getGrade());
			dtm.addRow(vector);
	}
	}
}
