package com.xsy.www.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xsy.www.po.Admin;
import com.xsy.www.po.Student;
import com.xsy.www.po.StudentClass;
import com.xsy.www.service.BaseDao;

public class StudentDao  extends BaseDao{
	//ѧ��ע�� 
//	public boolean add(Student student) {
//		String sql = "insert into student1 values(null,?,?,?)";
//		try {
//			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setString(1,student.getName());
//			preparedStatement.setString(2, student.getClassName());
//			preparedStatement.setString(3, student.getStudentNumber());
//			preparedStatement.setString(4, student.getPassword());
//			if (preparedStatement.executeUpdate()>0) return true;
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return false;
//	}
	//ѧ���˵�½
	public Student login(Student student){
		String sql = "select * from s_student where name=? and password=?";
		Student studentRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//��sql��䴫�����ݿ��������
			prst.setString(1, student.getName());
			prst.setString(2, student.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				studentRst = new Student(null, null, null, null, null, null,null,null);
				studentRst.setId(executeQuery.getString("id"));
				studentRst.setName(executeQuery.getString("name"));
				studentRst.setPassword(executeQuery.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRst;
	}
	
	//ѧ��ע��
	public String logon(Student logonClass) {
		String resultStr = "���ʧ��";
		String sql2 = "select * from s_student where id = ?";
		String sql3 = "insert into s_student values(?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement preparableStatement = con.prepareStatement(sql3); //������д�����ݿ�
			preparableStatement.setString(1, logonClass.getId());
			preparableStatement.setString(2, logonClass.getName());
			preparableStatement.setString(3, logonClass.getPassword());
			preparableStatement.setString(4, logonClass.getGrade());
			preparableStatement.setString(5, logonClass.getClassname());
			preparableStatement.setString(6, logonClass.getSecondary());
			preparableStatement.setString(7, logonClass.getMajor());
			
			if (preparableStatement.executeUpdate() > 0) {
				resultStr = "��ӳɹ���";
				preparableStatement = this.con.prepareStatement(sql2);
	
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return resultStr;
	}
	
	//ѧ�����޸�����
	public String editPassword(Student student,String newPassword) {		
		String sql = "select * from s_student where id=? and password=?";  
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1,student.getId());
			prst.setString(2, student.getPassword());
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
		String sql1 = "update s_student set password = ? where id = ?";
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
	
	//�����ݴ�ӡ�������
	public ArrayList<StudentClass> queryAllStudent(){
		ArrayList<StudentClass> retList = new ArrayList<StudentClass>();
		String sqlString = "select * from s_class";//ѧ���α��ѯ
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				StudentClass sc = new StudentClass();
				sc.setGrade(executeQuery.getString("grade"));
				sc.setName(executeQuery.getString("name"));
				sc.setRequireCourse(executeQuery.getString("requirecourse"));
				sc.setMajor(executeQuery.getString("major"));
				sc.setSecondary(executeQuery.getString("secondary"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
		
		
		

	//ģ����ѯ���ܵ�ʵ��
	
	public ArrayList<StudentClass> queryStudent(StudentClass tempStudent2){
		ArrayList<StudentClass> arrayStudent = new ArrayList<StudentClass>();
		String sql = "select * from s_class where name like '%" 
		+ tempStudent2.getName() + "%' and secondary like '%"// and secondary like '% " + student.getSecondary() + "'% and ";
		+ tempStudent2.getSecondary() + "%' and major like '%"
		+ tempStudent2.getMajor() + "%' and requirecourse like '%"
		+ tempStudent2.getRequireCourse() + "%'";
		System.out.println(sql);
		
		PreparedStatement prep;

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				StudentClass sc = new StudentClass();
				sc.setGrade(executeQuery.getString("grade"));
				sc.setName(executeQuery.getString("name"));
				sc.setRequireCourse(executeQuery.getString("requirecourse"));
				sc.setMajor(executeQuery.getString("major"));
				sc.setSecondary(executeQuery.getString("secondary"));
				arrayStudent.add(sc);
			}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		return arrayStudent;
	}
}
