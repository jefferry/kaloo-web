package com.kaloo.util;

import java.util.Collection;

public class StringUtil {
	/**
	 * 判断两个字符串是否相等
	 * @return
	 */
	public static boolean isEqual(String strA, String strB) {
		if(strA == null && strB == null) {
			return true;
		} else if(strA == null || strB == null){
			return false;
		} else {
			return strA.equals(strB);
		}
	}
	
	/**
	 * 判断字符串是否为null或""
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str == null || str.length() > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为null或""
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * 去空格
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		return str == null ? null : str.trim();
	}
	
	/**
	 * 判断字符串是否为纯数字
	 * @return
	 */
	public static boolean isDigit(String str) {
		if(isEmpty(str)) {
			return false;
		} 
		
		char[] charArraay = str.toCharArray();
		for(char i : charArraay) {
			if(!Character.isDigit(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 把字符串数组依次合成一个字符串
	 * @param str
	 * @return
	 */
	public static String join(String[] str) {
		if(str == null) {
			return null;
		} else if(str.length == 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			for(String s : str) {
				sb.append(s);
			}
			return sb.toString();
		}
	}
	
	/**
	 * 把字符串数组按照指定的连接符号依次合成一个字符串
	 * @param str
	 * @return
	 */
	public static String join(String[] str, String split) {
		if(str == null) {
			return null;
		} else if(str.length == 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			for(String s : str) {
				sb.append(s).append(split);
			}
			if(sb.length() > 0) {
				sb.delete(sb.length() - split.length(), sb.length());
			}
			return sb.toString();
		}
	}
	
	/**
	 * 把集合中过的字符串元素按照指定的连接符号依次合成一个字符串
	 * @param coll
	 * @param split
	 * @return
	 */
	public static String join(Collection<String> coll, String split) {
		if(coll == null) {
			return null;
		} else if(coll.size() == 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			for(String s : coll) {
				sb.append(s).append(split);
			}
			if(sb.length() > 0) {
				sb.delete(sb.length() - split.length(), sb.length());
			}
			return sb.toString();
		}
	}
	
	/**
	 * 判断是否包含whitespace字符
	 * @param str
	 * @return
	 */
	public static boolean containsWhitespace(String str) {
		if (isEmpty(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 除去字符串中两端的whitespace
	 * @param str
	 * @return
	 */
	public static String trimWhitespace(String str) {
		if (isEmpty(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	/**
	 * 除去字符串中左边的whitespace
	 * @param str
	 * @return
	 */
	public static String trimLeftWhitespace(String str) {
		if (isEmpty(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	/**
	 * 除去字符串中右边的whitespace
	 * @param str
	 * @return
	 */
	public static String trimRightWhitespace(String str) {
		if (isEmpty(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	/**
	 * 除去字符串中所有的whitespace
	 * @param str
	 * @return
	 */
	public static String trimAllWhitespace(String str) {
		if (isEmpty(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		int index = 0;
		while (sb.length() > index) {
			if (Character.isWhitespace(sb.charAt(index))) {
				sb.deleteCharAt(index);
			}
			else {
				index++;
			}
		}
		return sb.toString();
	}
	
}
