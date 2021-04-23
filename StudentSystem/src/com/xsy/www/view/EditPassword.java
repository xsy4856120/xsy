package com.xsy.www.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.xsy.www.dao.TeacherDao;
import com.xsy.www.dao.StudentDao;
import com.xsy.www.po.Admin;
import com.xsy.www.po.Student;
import com.xsy.www.util.StringUtil;

public class EditPassword extends JInternalFrame {

	private JPanel contentPane;
	private JPasswordField oldPasswordTextField;
	private JPasswordField newPasswordTextField;
	private JPasswordField confirmPasswordTextField;
	private JLabel currentUserLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditPasswordFrm frame = new EditPasswordFrm();
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
	public EditPassword() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 504, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		oldPasswordTextField = new JPasswordField();
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		newPasswordTextField = new JPasswordField();
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				submitEdit(e);
			}
		});
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		currentUserLabel = new JLabel("");
		currentUserLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		currentUserLabel.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(86)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(submitButton)
							.addGap(61)
							.addComponent(resetButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(newPasswordTextField)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(confirmPasswordTextField, 167, 167, 167)
										.addPreferredGap(ComponentPlacement.RELATED))))))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		if("教师".equals(TeaMainScreen.userType.getNameString())){
			Admin admin = (Admin)TeaMainScreen.userObject;
			currentUserLabel.setText("【教师】" + admin.getName());
			return;}
		if("学生".equals(TeaMainScreen.userType.getNameString())){
			Student student = (Student)TeaMainScreen.userObject;
			currentUserLabel.setText("【学生】" + student.getName());
			return;
		
	}}
//修改密码
	protected void submitEdit(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String conformPassword = confirmPasswordTextField.getText().toString();
		if (StringUtil.isNull(oldPassword)) {//判断学生输入是否为空以及两次密码是否完全一致
			JOptionPane.showMessageDialog(this, "请填写旧密码！");
			return;
		}
		if (StringUtil.isNull(newPassword)) {
			JOptionPane.showMessageDialog(this, "请填写新密码！");
			return;
		}
		if (StringUtil.isNull(conformPassword)) {
			JOptionPane.showMessageDialog(this, "请确认新密码！");
			return;
		}
		if (!newPassword.equals(conformPassword)) {
			JOptionPane.showMessageDialog(this, "两次密码输入不一致！");
			return;
		}
		if ("教师".equals(TeaMainScreen.userType.getNameString())) {
			TeacherDao adminDao = new TeacherDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin) TeaMainScreen.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setId(admin.getId());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			adminDao.closeDao();
			return;
		}
		else if ("学生".equals(TeaMainScreen.userType.getNameString())) {//提交修改密码
			StudentDao studentDao = new StudentDao();
			Student studentTemp = new Student(null, null, null, null, null, null, null,null);
			Admin admin = (Admin) TeaMainScreen.userObject;
			studentTemp.setName(admin.getName());
			studentTemp.setId(admin.getId());
			studentTemp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, studentDao.editPassword(studentTemp, newPassword));
			studentDao.closeDao();
			return;
		}
		
	}

	protected void resetValue(ActionEvent ae) { //重置清空所填信息
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
