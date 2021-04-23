package com.xsy.www.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.xsy.www.po.Admin;
import com.xsy.www.service.BaseDao;


//教师登陆
public class TeacherDao  extends BaseDao{
	private int executeQuery;
//教师端登录功能的实现
	public Admin login (Admin admin) {
		String sql = "select * from teacher where name = ? and password = ?";    //将MySQL语句传给数据库
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



	public String editPassword(Admin admin,String newPassword) {		//修改密码
		String sql = "select * from teacher where id=? and password=?";  
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1,admin.getId());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (!executeQuery.next()) {
				String retString = "旧密码错误";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		String retString = "修改失败";
		String sql1 = "update teacher set password = ? where id = ?";
		try {			//将新密码写入MySQL
			PreparedStatement prst1;
			prst1 = con.prepareStatement(sql1);
			prst1.setString(1, newPassword);
			prst1.setInt(2, id);
			int rst = prst1.executeUpdate();
			if (rst > 0) {
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return retString;
	}
}
