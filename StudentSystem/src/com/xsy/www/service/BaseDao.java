package com.xsy.www.service;
//与数据库获得连接,负责整个系统与数据库的交互

import java.sql.Connection;
import java.sql.SQLException;

import com.xsy.www.util.DbUtil;

public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
