package com.tydic.util;

import java.util.Date;

/**
 * 工具类：对象比较工具类
 * 
 * @author QianMin
 * @date 2015-11-25
 * */
public class ObjectCompUtil {

	private static Boolean checkCommon(Object compRelObj, Object compObj) {
		if (null == compRelObj || null == compObj) {
			return Boolean.FALSE;
		}
		if (compRelObj instanceof Date && compObj instanceof Date) {
			return Boolean.TRUE;
		}
		if (compRelObj instanceof Double && compObj instanceof Double) {
			return Boolean.TRUE;
		}
		if (compRelObj instanceof String && compObj instanceof String) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * 比较对象值：等于
	 * 
	 * @param compRelObj
	 *            比较参考对象
	 * @param compObj
	 *            待比较对象
	 * @return Boolean
	 * */
	public static Boolean checkEquals(Object compRelObj, Object compObj) {
		if (ObjectCompUtil.checkCommon(compRelObj, compObj)) {
			return compRelObj.equals(compObj);
		}
		return Boolean.FALSE;
	}

	/**
	 * 比较对象值：不等于
	 * 
	 * @param compRelObj
	 *            比较参考对象
	 * @param compObj
	 *            待比较对象
	 * @return Boolean
	 * */
	public static Boolean checkNotEquals(Object compRelObj, Object compObj) {
		return !(checkEquals(compRelObj, compObj));
	}

	/**
	 * 比较对象值：大于
	 * 
	 * @param compRelObj
	 *            比较参考对象
	 * @param compObj
	 *            待比较对象
	 * @return Boolean
	 * */
	public static Boolean checkMoreThan(Object compRelObj, Object compObj) {
		if (ObjectCompUtil.checkCommon(compRelObj, compObj)) {
			if (compRelObj instanceof Date) {
				return ((Date) compObj).after((Date) compRelObj);
			}
			if (compRelObj instanceof Double) {
				return ((Double) compObj).compareTo((Double) compRelObj) > 0;
			}
			if (compRelObj instanceof String) {
				return ((String) compObj).compareTo((String) compRelObj) > 0;
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * 比较对象值：小于
	 * 
	 * @param compRelObj
	 *            比较参考对象
	 * @param compObj
	 *            待比较对象
	 * @return Boolean
	 * */
	public static Boolean checkLessThan(Object compRelObj, Object compObj) {
		if (ObjectCompUtil.checkCommon(compRelObj, compObj)) {
			if (compRelObj instanceof Date) {
				return ((Date) compObj).before((Date) compRelObj);
			}
			if (compRelObj instanceof Double) {
				return ((Double) compObj).compareTo((Double) compRelObj) < 0;
			}
			if (compRelObj instanceof String) {
				return ((String) compObj).compareTo((String) compRelObj) < 0;
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * 比较对象值：大于等于
	 * 
	 * @param compRelObj
	 *            比较参考对象
	 * @param compObj
	 *            待比较对象
	 * @return Boolean
	 * */
	public static Boolean checkMoreThanOrEquals(Object compRelObj, Object compObj) {
		return !(checkLessThan(compRelObj, compObj));
	}

	/**
	 * 比较对象值：小于等于
	 * 
	 * @param compRelObj
	 *            比较参考对象
	 * @param compObj
	 *            待比较对象
	 * @return Boolean
	 * */
	public static Boolean checkLessThanOrEquals(Object compRelObj, Object compObj) {
		return !(checkMoreThan(compRelObj, compObj));
	}
}
