package com.xsy.www.view;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import com.xsy.www.po.Student;
import com.xsy.www.po.UserType;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuMainScreen extends JFrame {
	static UserType userType;
	static Object userObject;
	private JDesktopPane desktopPane;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StuMainScreen frame = new StuMainScreen(userType, userObject);
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

	public StuMainScreen(UserType uerType1, Object object1) {
		setTitle("\u5E7F\u4E1C\u5DE5\u4E1A\u5927\u5B66\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF");
		// TODO 自动生成的构造函数存根
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userType = uerType1;
		this.userObject = object1;
		
		setBounds(100, 100, 858, 580);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 629, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 403, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuEditPassword(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u8D26\u53F7");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valuex = JOptionPane.showConfirmDialog(null,"你确认要退出程序吗？", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (valuex == 0) {
				System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u67E5\u8BE2\u8BFE\u7A0B");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u8BFE\u8868\u67E5\u8BE2");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentList(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

//查询学生列表，弹出窗口
	protected void StudentList(ActionEvent e) {
		// TODO 自动生成的方法存根
		ClassListScreen classListScreen = new ClassListScreen();
		desktopPane.add(classListScreen);
		classListScreen.setVisible(true);
	}
//弹出修改密码窗口
	protected void StuEditPassword(ActionEvent e) {
		// TODO 自动生成的方法存根
		StuEditPassword stuEditPassword = new StuEditPassword();
		stuEditPassword.setVisible(true);
		desktopPane.add(stuEditPassword);
	}
}
