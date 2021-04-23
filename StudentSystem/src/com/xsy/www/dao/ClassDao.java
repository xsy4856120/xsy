package com.xsy.www.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.xsy.www.po.StudentClass;
import com.xsy.www.service.BaseDao;


//�༶��Ϣ�����ݿ�Ĳ���
public class ClassDao extends BaseDao {
	//��ʦ��ӿα�
	public String addClass(StudentClass sc1) {
		String resultStr = "���ʧ��";
		String sql1 = "select count(*) from s_class where id like '"+ sc1.getId() + "%'";
		String sql2 = "select * from s_class where id = ?";
		String sql3 = "insert into s_class values(?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement preparableStatement = con.prepareStatement(sql3); //������д�����ݿ�
			preparableStatement.setString(1, sc1.getId());
			preparableStatement.setString(2, sc1.getName());
			preparableStatement.setString(3, sc1.getSecondary());
			preparableStatement.setString(4, sc1.getMajor());
			preparableStatement.setString(5, sc1.getInfo());
			preparableStatement.setString(6, sc1.getRequireCourse());
			preparableStatement.setString(7, sc1.getGrade());
			
			if (preparableStatement.executeUpdate() > 0) {
				resultStr = "��ӳɹ���";

			preparableStatement = this.con.prepareStatement(sql2);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			this.closeDao();
		}
		return resultStr;
		
	}
	
		
	}
