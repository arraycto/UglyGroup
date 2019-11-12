package com.yc.uglygroup.util;

public class StringUtil {
	/**
	 * 如果为空返回true，否则返回false
	 * @param strings
	 * @return
	 */
	public static boolean checkNull(String ... strings){
		if (strings == null || strings.length <=0) {
			return true;
		}
		
		for(String string : strings){
			if (string == null || "".equals(string)) {
				return true;
			}
		}
		return false;
	}
}
