package com.xsy.www.service;
//�����ݿ�������,��������ϵͳ�����ݿ�Ľ���

import java.sql.Connection;
import java.sql.SQLException;

import com.xsy.www.util.DbUtil;

public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
