package com.xsy.www.util;
//ѧԺ����Ŀ��רҵ��ǩ
public enum CollegeStructure {
	JISUANJI("�����ѧԺ",0),
	ZIDONGHUA("�Զ���ѧԺ",1),
	WAIGUOYU("�����ѧԺ",2);
	
	private String name;
	private int index;
	
	private CollegeStructure(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public static final String [][] major = {
			{"�������","�������ѧ�뼼��","���簲ȫ"},
			{"�Զ�����","�������̼����Զ���","������","������"},
			{"����Ӣ��","����"}
		};
	
	public static final String [][] majorNum = {
			{"001","002","003"},
			{"004","005","006","007"},
			{"008","009"}
};
	public static final String [] gradeStr = {"2017","2018","2019","2020"};
	
	public static final String[] requireCourse = {"�ߵ���ѧ","��ѧӢ��","��ѧ����","���Դ���","C����"};
	
//	public static final String[][] studentclass = {
//			{"���1��","���2��","���3��"},
//			{"�ƿ�1��","�ƿ�2��"},
//			{"����1��","����2��","����3��"},
//			{"�Զ���1��","�Զ���2��","�Զ���3��"},
//			{"����1��","����2��"},
//			{"������1��"},
//			{"������1��"},
//			{"��Ӣ1��","��Ӣ2��"},
//			{"����1��","����2��"},
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

	
	
