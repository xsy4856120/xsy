package com.xsy.www.po;

public class Student {
	private String id;
	private String name;
	private String password;
	private String grade;
	private String classname;
	private String secondary;
	private String major;
	private String Info;

	public Student() {
		
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		this.Info = info;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
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

	public Student(String id, String name, String password, String grade, String classname, String secondary,
			String major,String info) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.grade = grade;
		this.classname = classname;
		this.secondary = secondary;
		this.major = major;
		this.Info = info;
	}
	
	}


