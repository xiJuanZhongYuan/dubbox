package com.tydic.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串判断工具类
 * 
 * 判断字符串内容进行判断
 * 
 * @ClassName: StringCheckTool 
 * @author zhangpeng 
 * @date 2017年3月14日 上午9:14:47 
 * @version V1.0
 */
public class StringCheckTool {
	
	/**
	 * 判断字符串是否为数字数据 
	 * 
	 * 字符串为数字，返回true，否则返回false
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNumber(String str) {
		boolean isN = false;
		if (str != null && !str.equals("")) {
			Pattern pattern = Pattern.compile("\\d+");
			Matcher m = pattern.matcher(str);
			isN = m.matches();
		}
		return isN;
	}

	/**
	 * 判断是否是虚值
	 * 
	 * 字符串不为空，且开头和结尾都为“$”，返回true
	 * 否则返回false
	 * 
	 * @Title: isVentValue
	 * @Description: 判断是否是虚值
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isVentValue(String str) {
		if (str != null && !"".equals(str) && str.startsWith("$") && str.endsWith("$")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否是辅助函数
	 * 
	 * @Title: isFunction
	 * @Description: 判断是否是辅助函数
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isFunction(String str) {
		//为空判断不是辅助函数
		if (str == null || "".equals(str)) {
			return false;
		}
		boolean isFun = str.startsWith(":get");
		return isFun;
	}

	/**
	 * 判断是否是字母
	 * 是字母返回true，否则返回false
	 * 
	 * @Title: isLetter
	 * @Description: 判断是否是字母
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isLetter(String str) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher m = pattern.matcher(str);
		return m.matches();
	}
	
	/**
	 * 判断该字符是否是小数 or 负数 or 整数
	 * 是，返回true，否则返回false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]*.?[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 判断key是否合法 形式如 A.B 才是合法的key
	 * 合法返回true，否则返回false
	 * 
	 * @param key
	 * @return boolean
	 */
	public static boolean keyIsLegal(String key) {
		boolean isH = false;
		if (key != null && key.contains(".")) {
			String[] array = key.split("\\.");
			if (array != null && array.length == 2) {
				return true;
			}
		}
		return isH;
	}
	
	/**
	 * 
	 * 判断字符串是否相等（可传入空）
	 * 
	 * 1、若val和defaultVal均为空，返回true；
	 * 2、若val和defaultVal仅有一个为空，返回false；
	 * 3、判断val和defaultVal是否相等，相等返回true，否则返回false；
	 *
	 * @version 1.0 
	 * @param val
	 * @param defaultVal
	 * @return boolean
	 * @exception
	 */
	public static boolean isEquals(String val, String defaultVal) {
		if (val == null) {
			if (defaultVal == null) {
				return true;
			}
			return false;
		}
		if (val.equals(defaultVal)) {
			return true;
		}
		return false;
	}

	 
	/**
	 * 判断字符串是否为日期(日期格式为"yyyy-MM-dd")
	 * 
	 * 1、字符串为空,返回false；
	 * 2、不能以"yyyy-MM-dd"格式解析字符串，返回false；
	 * 3、是日期格式为"yyyy-MM-dd"的字符串，返回true
	 *
	 * @version 1.0 
	 * @author zhangpeng
	 * @param str
	 * @return boolean
	 * @exception
	 */
	public static boolean isDate(String str) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (null == str || "null".equalsIgnoreCase(str.trim()) || "".equals(str.trim()))
			return false;
		try {
			dateFormat.parse(str);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
}
