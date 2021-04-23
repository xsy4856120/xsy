package com.xsy.www.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.xsy.www.dao.ClassDao;
import com.xsy.www.dao.StudentDao;
import com.xsy.www.po.Student;
import com.xsy.www.po.StudentClass;
import com.xsy.www.util.CollegeStructure;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ComboBoxModel;

public class StudengLogonScreen extends JInternalFrame {
	private JTextField StudentNametextField;
	private JTextField PasswordtextField_1;
	private JComboBox gradecomboBox;
	private JComboBox StudentSecondarycomboBox_1;
	private JComboBox StudentMajorcomboBox_2;
	private JComboBox StudentClasscomboBox_3;
	private ArrayList<StudentClass> arrayList = null;
	private JComboBox StudentClasscomboBox_2_1;
	private JTextField studentCclasstextField;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudengLogonScreen frame = new StudengLogonScreen();
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
	public StudengLogonScreen() {
		this.setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u751F\u6CE8\u518C");
		setBounds(100, 100, 568, 368);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(87, 47, 88, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(87, 97, 88, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74\u7EA7\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(87, 152, 88, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u5B66\u9662\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(328, 47, 88, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6240\u5C5E\u4E13\u4E1A\uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(328, 97, 88, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(328, 154, 88, 15);
		getContentPane().add(lblNewLabel_5);
		
		StudentNametextField = new JTextField();
		StudentNametextField.setBounds(159, 46, 114, 21);
		getContentPane().add(StudentNametextField);
		StudentNametextField.setColumns(10);
		
		PasswordtextField_1 = new JTextField();
		PasswordtextField_1.setBounds(159, 96, 114, 21);
		getContentPane().add(PasswordtextField_1);
		PasswordtextField_1.setColumns(10);	

		gradecomboBox = new JComboBox(new DefaultComboBoxModel(CollegeStructure.gradeStr));//年级选项
//new JComboBox(CollegeStructure.gradeStr);
		gradecomboBox.setBounds(159, 150, 77, 23);
		getContentPane().add(gradecomboBox);
//		
		StudentSecondarycomboBox_1 = new JComboBox(new DefaultComboBoxModel(CollegeStructure.secondaryStr));
		StudentSecondarycomboBox_1.addActionListener(new ActionListener() {//学院选项
			public void actionPerformed(ActionEvent e) {
				StudengLogonScreen.this.StudentMajorcomboBox_2.setModel(new DefaultComboBoxModel(CollegeStructure.major
						[StudengLogonScreen.this.StudentSecondarycomboBox_1.getSelectedIndex()]));
			}
		});
		StudentSecondarycomboBox_1.setBounds(414, 45, 98, 23);
		getContentPane().add(StudentSecondarycomboBox_1);
		StudentMajorcomboBox_2 = new JComboBox(new DefaultComboBoxModel(CollegeStructure.major[0]));//专业选项
			
			StudentMajorcomboBox_2.setBounds(414, 95, 98, 23);
		getContentPane().add(StudentMajorcomboBox_2);
		
		JButton logonbtnNewButton = new JButton("\u6CE8\u518C");
		logonbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logonStudent(e);
			}
		});
		logonbtnNewButton.setBounds(232, 232, 97, 23);
		getContentPane().add(logonbtnNewButton);
		
		studentCclasstextField = new JTextField();
		studentCclasstextField.setBounds(414, 151, 98, 21);
		getContentPane().add(studentCclasstextField);
		studentCclasstextField.setColumns(10);
		

	}//注册学生信息
	protected void logonStudent(ActionEvent e) {
		// TODO 自动生成的方法存根
		String name = this.StudentNametextField.getText();
		String password = this.PasswordtextField_1.getText();
		String secondary = this.StudentSecondarycomboBox_1.getSelectedItem().toString();
		String major = this.StudentMajorcomboBox_2.getSelectedItem().toString();
		String grade = this.gradecomboBox.getSelectedItem().toString();
		String classString = this.studentCclasstextField.getText();
		 
		
		String id = String.valueOf(Integer.parseInt(grade)%2000+292) +  CollegeStructure.majorNum[StudentSecondarycomboBox_1.getSelectedIndex()][StudentMajorcomboBox_2.getSelectedIndex()] ;
		
		Student tempClass = new Student(id,name,password,secondary,major,grade,classString,null);
		StudentDao studentDao = new StudentDao();
		JOptionPane.showMessageDialog(this, studentDao.logon(tempClass));
	}
}
