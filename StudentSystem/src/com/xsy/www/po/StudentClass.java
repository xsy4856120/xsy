package com.xsy.www.po;
/*
 * 班级信息管理
 * 
 * 
 * */
public class StudentClass {
	private String id;
	private String name;
	private String secondary;
	private String major;
	private String info;
	private String grade;
	private String requireCourse;

	public StudentClass() {
		
		// TODO 自动生成的构造函数存根
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	public String toString() {
		return name;
	}
	public String getRequireCourse() {
		return requireCourse;
	}
	
	public void setRequireCourse(String requireCourse) {
		this.requireCourse = requireCourse;
	}

	public StudentClass(String id2, String name, String secondary, String major, String info, String grade,String requirecourse) {
		super();
		this.id = id2;
		this.name = name;
		this.secondary = secondary;
		this.major = major;
		this.info = info;
		this.grade = grade;
		this.requireCourse =requirecourse;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
