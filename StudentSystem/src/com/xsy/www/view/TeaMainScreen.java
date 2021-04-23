package com.xsy.www.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;

import com.xsy.www.po.UserType;

import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//教师登录的主界面  windowbuilder
public class TeaMainScreen extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	static UserType userType;
	static Object userObject;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeaMainScreen frame = new TeaMainScreen(null, null);
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
	public TeaMainScreen(UserType userType,Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		setTitle("\u5E7F\u4E1C\u5DE5\u4E1A\u5927\u5B66\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 610);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			editPassword(e);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u8D26\u53F7");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valuex = JOptionPane.showConfirmDialog(null,"你确认要退出程序吗？", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (valuex == 0) {
				System.exit(0);
				}
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u8BFE\u7A0B\u8BBE\u7F6E");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentClass(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);

	}




//班级管理--添加班级
	protected void addStudentClass(ActionEvent e) {
		// TODO 自动生成的方法存根
		AddClass addClass = new AddClass();
		addClass.setVisible(true);
		desktopPane.add(addClass);
	}




//修改密码--教师
	protected void editPassword(ActionEvent e) {
		// TODO 自动生成的方法存根
		EditPassword editPassword = new EditPassword();
		editPassword.setVisible(true);
		desktopPane.add(editPassword);
	}

}
