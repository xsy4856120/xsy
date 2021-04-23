package com.xsy.www.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.xsy.www.dao.TeacherDao;
import com.xsy.www.dao.StudentDao;
import com.xsy.www.po.Admin;
import com.xsy.www.po.Student;
import com.xsy.www.po.UserType;
import com.xsy.www.util.StringUtil;

import java.awt.Window.Type;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JComboBox userTypeComboBox;
	private JDesktopPane desktopPane;
	private JButton logonButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {//登陆界面
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		setTitle("\u5E7F\u4E1C\u5DE5\u4E1A\u5927\u5B66\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel label = new JLabel("\u5B66\u751F\u7CFB\u7EDF\u9009\u8BFE\u767B\u9646\u754C\u9762");
		label.setFont(new Font("华文行楷", Font.BOLD, 40));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6   \u7801\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		userTypeComboBox = new JComboBox();//选择用户类型
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.TEACHER,UserType.STUDENGT}));
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		logonButton = new JButton("\u6CE8\u518A");
		logonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogon(e);
			}
		});
		

		logonButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(117)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(passwordTextField))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
									.addGap(215)))))
					.addGap(283))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(166)
					.addComponent(loginButton)
					.addGap(79)
					.addComponent(logonButton)
					.addContainerGap(309, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(label)
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(logonButton))
					.addGap(82))
		);
		contentPane.setLayout(gl_contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}
//学生注册
	
	protected void StudentLogon(ActionEvent e) {
		// TODO 自动生成的方法存根
		//studengLogonScreen.setBounds(getBounds());
		StudengLogonScreen studentlogon = new StudengLogonScreen();
		studentlogon.setVisible(true);
		setContentPane(studentlogon);
		
	}
	
//登录功能实现
	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		if(StringUtil.isNull(userName)){//判断输入是否为空
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isNull(password)){
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		Admin admin = null;
		//教师登录
		if("教师".equals(selectedItem.getNameString())){//判断账户名称或者密码是否正确
			TeacherDao adminDao = new TeacherDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();
			if(admin == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getNameString()+"】："+admin.getName()+"登录本系统！");
			this.dispose();
			new TeaMainScreen(selectedItem, admin).setVisible(true);
			
			
		//学生登录
		}if("学生".equals(selectedItem.getNameString())) {
			Student student = null; 
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student(null, null, null, null, null, null,null,null);
			studentTmp.setName(userName);
			studentTmp.setPassword(password);
			student = studentDao.login(studentTmp);
			studentDao.closeDao();
			if(student == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getNameString()+"】："+student.getName()+"登录本系统！");
			this.dispose();
			new StuMainScreen(selectedItem, student).setVisible(true);
		}
	
	}
}	
			
			
	

		// TODO Auto-generated method stub
		
		
		


