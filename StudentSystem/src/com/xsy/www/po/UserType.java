package com.xsy.www.po;

public enum UserType {
	STUDENGT("ѧ��",0), TEACHER("��ʦ",1);
	private String nameString;
	private int index;
	private UserType(String nameString,int index) {
		this.index = index;
		this.nameString = nameString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String toString() {
		return this.nameString;
	}
}