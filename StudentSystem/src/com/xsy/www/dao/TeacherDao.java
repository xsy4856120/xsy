package com.xsy.www.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.xsy.www.po.Admin;
import com.xsy.www.service.BaseDao;


//��ʦ��½
public class TeacherDao  extends BaseDao{
	private int executeQuery;
//��ʦ�˵�¼���ܵ�ʵ��
	public Admin login (Admin admin) {
		String sql = "select * from teacher where name = ? and password = ?";    //��MySQL��䴫�����ݿ�
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1,admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (executeQuery.next()) {
				adminRst = new Admin();
				adminRst.setId(executeQuery.getString("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return adminRst;
		
	}



	public String editPassword(Admin admin,String newPassword) {		//�޸�����
		String sql = "select * from teacher where id=? and password=?";  
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1,admin.getId());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (!executeQuery.next()) {
				String retString = "���������";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		
		String retString = "�޸�ʧ��";
		String sql1 = "update teacher set password = ? where id = ?";
		try {			//��������д��MySQL
			PreparedStatement prst1;
			prst1 = con.prepareStatement(sql1);
			prst1.setString(1, newPassword);
			prst1.setInt(2, id);
			int rst = prst1.executeUpdate();
			if (rst > 0) {
				retString = "�����޸ĳɹ���";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return retString;
	}
}
