package com.xsy.www.util;
//判断用户名输入是否为空
public class StringUtil {
	public static boolean isNull(String str) {
		if ("".equals(str) || str == null) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
