/**
 * 
 */
package com.tydic.util;

import java.util.Date;
import java.util.List;

/**
 * 对象为空判断类
 * 
 * @ClassName: ObjectIsNull 
 * @author lufushi 
 * @date 2010年8月25日 下午5:34:10 
 * @version V1.0
 */
public class ObjectIsNull {

	public ObjectIsNull() {
	}

	/**
	 * 
	 * Description:
	 * 判断对象是否为空
	 * @version 1.0 
	 * @param obj 
	 * @return boolean
	 */
	public static boolean check(Object obj) {
		if (obj == null)
			return true;
		if (obj instanceof String)
			return checkString((String) obj);
		if (obj instanceof Integer)
			return checkInteger((Integer) obj);
		if (obj instanceof Long)
			return checkLong((Long) obj);
		if (obj instanceof Double)
			return checkDouble((Double) obj);
		if (obj instanceof Date)
			return checkDate((Date) obj);
		if (obj instanceof List)
			return checkList((List) obj);
		if (obj instanceof String[])
			return checkDate((String[]) obj);
		else
			return false;
	}

	/**
	 * 
	 * Description:
	 * 判断字符串数组是否为空
	 * @version 1.0 
	 * @param strings
	 * @return boolean
	 */
	private static boolean checkDate(String strings[]) {
		return strings.length <= 0;
	}

	/**
	 * 
	 * Description:
	 * 判断List是否为空
	 * @version 1.0 
	 * @param list
	 * @return boolean
	 */
	private static boolean checkList(List list) {
		return list.size() <= 0;
	}
	
	/**
	 * 
	 * Description:
	 *	判断Date是否为空
	 * @version 1.0 
	 * @param date
	 * @return boolean
	 */
	private static boolean checkDate(Date date) {
		return date == null;
	}

	/**
	 * 
	 * Description:
	 *	判断Double类型对象是否为0.0D
	 * @version 1.0 
	 * @param double1
	 * @return boolean
	 */
	private static boolean checkDouble(Double double1) {
		return double1.doubleValue() == 0.0D;
	}
	
	/**
	 * 
	 * Description:
	 *	判断Long类型对象是否为 0L或-1L
	 * @version 1.0 
	 * @param long1
	 * @return boolean
	 */
	private static boolean checkLong(Long long1) {
		return long1.longValue() == 0L || long1.longValue() == -1L;
	}
	/**
	 * 
	 * Description:
	 *	判断Integer类型对象是否为 0或-1
	 * @version 1.0 
	 * @param integer
	 * @return boolean
	 */
	private static boolean checkInteger(Integer integer) {
		return integer.intValue() == 0 || integer.intValue() == -1;
	}
	
	/**
	 * 
	 * Description:
	 *	检查字符串是否为空或“null”
	 * @version 1.0 
	 * @param string
	 * @return boolean
	 */
	private static boolean checkString(String string) {
		return string.trim().length() <= 0 || "null".equalsIgnoreCase(string);
	}
}
