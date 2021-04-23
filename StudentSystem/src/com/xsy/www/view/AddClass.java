package com.xsy.www.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JTextPane;

import com.xsy.www.dao.ClassDao;
import com.xsy.www.po.StudentClass;
import com.xsy.www.util.CollegeStructure;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ComboBoxModel;
//教师班级添加的界面
public class AddClass extends JInternalFrame {
	private JTextField classNametextField;
	private JComboBox classSeconarycomboBox;
	private JComboBox classMajorcomboBox_1;
	private JTextArea classInfotextPane;
	private JComboBox gradecomboBox_1_1;
	private JComboBox SubjectNameclassMajorcomboBox_1_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddClass frame = new AddClass();
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
	public AddClass() {
		this.setClosable(true);
		this.setIconifiable(true);
		setTitle("\u6DFB\u52A0\u73ED\u7EA7\u8BFE\u7A0B");
		setBounds(100, 100, 594, 413);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(69, 68, 78, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u5B66\u9662\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(288, 68, 85, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u6240\u5C5E\u4E13\u4E1A\uFF1A");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(69, 126, 85, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(288, 182, 85, 15);
		getContentPane().add(lblNewLabel_1_2);
		
		classInfotextPane = new JTextArea();
		classInfotextPane.setBounds(367, 179, 156, 139);
		classInfotextPane.setLineWrap(true);
		getContentPane().add(classInfotextPane);
		
		
		classNametextField = new JTextField();
		classNametextField.setBounds(136, 67, 108, 21);
		getContentPane().add(classNametextField);
		classNametextField.setColumns(10);
		
		classSeconarycomboBox = new JComboBox(new DefaultComboBoxModel(CollegeStructure.secondaryStr));  //学院选项
		classSeconarycomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClass.this.classMajorcomboBox_1.setModel(new DefaultComboBoxModel(CollegeStructure.major
						[AddClass.this.classSeconarycomboBox.getSelectedIndex()]));//学院跳动时，相应的专业随着变化
			}
		});
		
		
		
		classSeconarycomboBox.setBounds(368, 66, 108, 23);
		getContentPane().add(classSeconarycomboBox);
		
		classMajorcomboBox_1 = new JComboBox(new DefaultComboBoxModel(CollegeStructure.major[0]));  //专业选项
		classMajorcomboBox_1.setBounds(136, 124, 108, 23);
		getContentPane().add(classMajorcomboBox_1);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClass(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(242, 345, 97, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u5E74\u7EA7\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(288, 128, 85, 15);
		getContentPane().add(lblNewLabel_1_1_1);
		
		SubjectNameclassMajorcomboBox_1_1 = new JComboBox(new DefaultComboBoxModel(CollegeStructure.requireCourse));
		SubjectNameclassMajorcomboBox_1_1.setBounds(136, 180, 108, 23);//必修课选项（选修没有时间补上了）
		getContentPane().add(SubjectNameclassMajorcomboBox_1_1);
		
		gradecomboBox_1_1 = new JComboBox(new DefaultComboBoxModel(CollegeStructure.gradeStr));
		gradecomboBox_1_1.setBounds(368, 124, 108, 23);//年级选项
		getContentPane().add(gradecomboBox_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u79D1\u76EE\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(69, 184, 78, 15);
		getContentPane().add(lblNewLabel_2);
		

	}
//确认修改动作--添加班级信息
	protected void AddClass(ActionEvent e) {
		// TODO 自动生成的方法存根
		String name = this.classNametextField.getText();  //获取所填入的信息
		String secondary = this.classSeconarycomboBox.getSelectedItem().toString();
		String major = this.classMajorcomboBox_1.getSelectedItem().toString();
		String info = this.classInfotextPane.getText();
		String grade = this.gradecomboBox_1_1.getSelectedItem().toString();
		String requirecourse = this.SubjectNameclassMajorcomboBox_1_1.getSelectedItem().toString();
		
		String id = String.valueOf(Integer.parseInt(grade)%2000+292) 
				+ CollegeStructure.majorNum[classSeconarycomboBox.getSelectedIndex()][classMajorcomboBox_1.getSelectedIndex()] ;
		
		StudentClass tempClass = new StudentClass(id, name, secondary, major, info,requirecourse,grade);
		ClassDao classDao = new ClassDao();
		JOptionPane.showMessageDialog(this, classDao.addClass(tempClass));
	}
}
