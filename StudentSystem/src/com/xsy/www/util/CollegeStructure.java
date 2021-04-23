package com.xsy.www.util;
//学院、科目、专业标签
public enum CollegeStructure {
	JISUANJI("计算机学院",0),
	ZIDONGHUA("自动化学院",1),
	WAIGUOYU("外国语学院",2);
	
	private String name;
	private int index;
	
	private CollegeStructure(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public static final String [][] major = {
			{"软件工程","计算机科学与技术","网络安全"},
			{"自动化类","电气工程及其自动化","大数据","互联网"},
			{"商务英语","日语"}
		};
	
	public static final String [][] majorNum = {
			{"001","002","003"},
			{"004","005","006","007"},
			{"008","009"}
};
	public static final String [] gradeStr = {"2017","2018","2019","2020"};
	
	public static final String[] requireCourse = {"高等数学","大学英语","大学物理","线性代数","C语言"};
	
//	public static final String[][] studentclass = {
//			{"软件1班","软件2班","软件3班"},
//			{"计科1班","计科2班"},
//			{"网安1班","网安2班","网安3班"},
//			{"自动化1班","自动化2班","自动化3班"},
//			{"电气1班","电气2班"},
//			{"大数据1班"},
//			{"互联网1班"},
//			{"商英1班","商英2班"},
//			{"日语1班","日语2班"},
//	};

	public static final String [] secondaryStr = {
			JISUANJI.getName(),
			ZIDONGHUA.getName(),
			WAIGUOYU.getName()
	};
	public static final String [] classStr = {
			JISUANJI.getName(),
			ZIDONGHUA.getName(),
			WAIGUOYU.getName()
	};
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static String[][] getMajor() {
		return major;
	}

	

//	public static String[][] getStudentclass() {
//		return studentclass;
//	}

	public static String[][] getMajornum() {
		return majorNum;
	}
}

	
	
