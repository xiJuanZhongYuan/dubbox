package com.tydic.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * 字符串转换工具类
 * 
 * @ClassName: StringTransformTool 
 * @author zhangpeng 
 * @date 2017年3月14日 上午10:05:11 
 * @version V1.0
 */
public class StringTransformTool {
	
	/**
	 * 转换为长整型(long)
	 * 字符串为空返回 -1
	 * @Description：转换为长整型
	 * @param obj
	 * @return long
	 */
	public static long parseLong(String s) {
		if (!ObjectIsNull.check(s)) {
			return Long.valueOf(s);
		}
		return -1L;
	}

	/**
	 * 转换为整型(int)
	 * 字符串为空返回 -1
	 * 
	 * @Description：转换为整型
	 * @param s
	 * @return int
	 */
	public static int parseInt(String s) {
		if (!ObjectIsNull.check(s)) {
			return Integer.valueOf(s);
		}
		return -1;
	}

	/**
	 * 转换为short
	 * 字符串为空返回 -1
	 * 
	 * @Description：转换为short
	 * @param s
	 * @return
	 */
	public static short parseShort(String s) {
		if (!ObjectIsNull.check(s)) {
			return Short.parseShort(s);
		}
		return -1;
	}
	
	/**
	 * 将数字字符串转换为大写金额形式
	 * 
	 * 如：输入"-12345.23"，返回为“负壹万贰仟叁佰肆拾伍元贰角叁分”
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param ls
	 * @return String
	 * @exception
	 */
	public static String backBigMoney(String ls) {
		String fu = "";
		if (!ObjectIsNull.check(ls) && ls.charAt(0) == '-') {
			fu = "负";
		}
		ls = ls.replaceAll("-", "");
		StringTokenizer tokens = new StringTokenizer(ls, ".");
		while (tokens.hasMoreTokens()) {
			// TODO:modifier.songfq.010112 : String 组装修改
			StringBuffer eles = new StringBuffer();
			String t1 = tokens.nextToken();
			if (tokens.hasMoreTokens()) {
				String t2 = tokens.nextToken();
				if (t2.length() == 1)
					eles.append(t2).append("0");
				if (t2.length() >= 2) {
					for (int e1 = 0; e1 < t2.length(); e1++) {
						if (e1 >= 2) {
							// eles = eles; //FindBugs zhaiph 20081215
						} else {
							eles.append(t2.charAt(e1));
						}
					}
				}
				if (t2.length() < 1)
					eles.append("00");
				ls = t1 + eles.toString();
			} else {
				ls = t1 + "00";
			}
		}
		// TODO:modifier.songfq.010113 : 大写转换错误问题
		String name = "";
		String lan = "";
		int n = ls.length();
		for (int l = ls.length() - 1; l > -1; l--) {
			if ("0".equals(ls.charAt(l) + "")) {
				name = "零";
			} else if ("1".equals(ls.charAt(l) + "")) {
				name = "壹";
			} else if ("2".equals(ls.charAt(l) + "")) {
				name = "贰";
			} else if ("3".equals(ls.charAt(l) + "")) {
				name = "叁";
			} else if ("4".equals(ls.charAt(l) + "")) {
				name = "肆";
			} else if ("5".equals(ls.charAt(l) + "")) {
				name = "伍";
			} else if ("6".equals(ls.charAt(l) + "")) {
				name = "陆";
			} else if ("7".equals(ls.charAt(l) + "")) {
				name = "柒";
			} else if ("8".equals(ls.charAt(l) + "")) {
				name = "捌";
			} else if ("9".equals(ls.charAt(l) + "")) {
				name = "玖";
			} else {
				name = "";
			}
			if (!"零".equals(name) || name != "零") {
				if (l == (n - 1) && n <= ls.length())
					name = name + "分";
				if (l == (n - 2) && n <= ls.length())
					name = name + "角";
				if (l == (n - 3) && n <= ls.length())
					name = name + "元";
				if (l == (n - 4) && n <= ls.length())
					name = name + "拾";
				if (l == (n - 5) && n <= ls.length())
					name = name + "佰";
				if (l == (n - 6) && n <= ls.length())
					name = name + "仟";
				if (l == (n - 7) && n <= ls.length())
					name = name + "万";
				if (l == (n - 8) && n <= ls.length())
					name = (lan.indexOf("万") == -1) ? name + "拾万" : name + "拾";
				if (l == (n - 9) && n <= ls.length())
					name = (lan.indexOf("万") == -1) ? name + "佰万" : name + "佰";
				if (l == (n - 10) && n <= ls.length())
					name = (lan.indexOf("万") == -1) ? name + "仟万" : name + "仟";
				if (l == (n - 11) && n <= ls.length())
					name = name + "亿";
				if (l == (n - 12) && n <= ls.length())
					name = (lan.indexOf("万") == -1) ? name + "拾亿" : name + "拾";
				if (l == (n - 13) && n <= ls.length())
					name = (lan.indexOf("万") == -1) ? name + "佰亿" : name + "佰";
			}
			lan = name + lan;

		}
		String back = "";
		for (int s = 0; s < lan.length(); s++) {
			if ("零".equals(lan.charAt(0) + ""))
				back = back + "";
			if (s + 1 == lan.length()) {
				if ("零".equals(lan.charAt(s) + ""))
					back = back + "";
				else
					back = back + lan.charAt(s);
			} else {
				if ("零".equals(lan.charAt(s) + "") && "零".equals(lan.charAt(s + 1) + ""))
					back = back + "";
				else
					back = back + lan.charAt(s);
			}
		}
		if ("".equals(back) || "" == back)
			back = "零元整";
		else {
			if (!back.endsWith("分") && !back.endsWith("角") && !back.endsWith("元"))
				back = back + "元整";
			if (back.endsWith("元"))
				back = back + "整";
			if (back.startsWith("零"))
				// back = back.toString().substring(1,
				// back.toString().length()); //FindBugs zhaiph 20081215
				back = back.substring(1, back.length()); // zhaiph 20081215
		}
		// //System.out.println(back);
		return fu + back;
	}
	
	/**
	 * 将日期转换为指定格式的字符串
	 * 
	 * 例：format = “yyyy-MM-dd HH:mm:ss” ,返回的字符串为：“2017-03-14 10:52:23”
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param date
	 * @param format
	 * @return String
	 * @exception
	 */
	public static String formatDate(Date date, String format) {
		if (date == null || format == null || "".equals(format.trim())) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		if (df.format(date) == null) {
			return "";
		} else {
			return df.format(date);
		}
	}
	
	/**
	 * 将字符串以指定格式解析为日期
	 * 
	 * 例：传入的字符串date为：2017-03-14 10:52:23 ,解析格式为“yyyy-MM-dd HH:mm:ss”
	 *    则返回该字符串对应的日期
	 * 若解析格式不正确或传入的字符串不为日期，则返回null
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param date
	 * @param format
	 * @return Date
	 * @exception
	 */
	public static Date formatStringDate(String date, String format) {
		if (date == null || format == null || "".equals(format.trim())) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 将字符串以"yyyyMMddHHmmss"格式解析为日期
	 * 
	 * 例：传入的字符串date为：20170314105223
	 *    则返回该字符串对应的日期
	 * 若传入的字符串不为日期字符串或不为解析格式的字符串，则返回null
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param date
	 * @return Date
	 * @exception
	 */
	public static Date formatStringDate(String date) {
		if ((date == null ||  "".equals(date)) || date.length()<14) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return df.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	

	/**
	 * 输入流转换成字符串
	 * 
	 * @param is  输入流
	 * @param characterEncoding 字符集
	 * @return String
	 * @throws IOException
	 */
	public static String convertToString(InputStream is, String characterEncoding) throws IOException {
//		if (is == null)
//			return null;
//		BufferedReader in = new BufferedReader(new InputStreamReader(is));
//		StringBuffer buffer = new StringBuffer();
//		String line = "";
//		while ((line = in.readLine()) != null) {
//			buffer.append(line.trim());
//		}
//		String str = buffer.toString();
//		if (ObjectIsNull.check(str)) {
//			return null;
//		}
//		return new String(str.getBytes(), characterEncoding);
		
		/*之所以修改为以下写法 是因为上面的写法如果报文中有中文且中文的位数为奇数位，则中文乱码  故修改    mod by luwei 2014/09/23*/
		if(is == null) return null;
//	    logger.info("get info in xxx.convertToString(InputStream is, String characterEncoding).characterEncoding=[" + characterEncoding + "]");
//	    logger.info("get info in xxx.convertToString(InputStream is, String characterEncoding).is.available()=[" + is.available() + "]");
		String strResult="";    
		byte[] b = new byte[is.available()];    
		int i = 0;    
		while ((i = is.read(b)) != -1) {    
		    strResult+=new String(b,characterEncoding);    
		    b = new byte[1024];    
//		    logger.info("get info in xxx.convertToString(InputStream is, String characterEncoding).i=[" + i + "]");
//		    logger.info("get info in xxx.convertToString(InputStream is, String characterEncoding).strResult=[" + strResult + "]");
		}   
//	    logger.info("get info in xxx.convertToString(InputStream is, String characterEncoding).strResult=[" + strResult + "]");
		return strResult ;

	}

	/**
	 * 输入流转换成字符串,指定读取字节长度
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param is 输入流
	 * @param characterEncoding 字符集
	 * @param contentLen 字节长度
	 * @return String
	 * @throws IOException 
	 * @exception
	 */
	public static String convertToString(InputStream is, String characterEncoding, int contentLen) throws IOException {
		byte[] b = readBytes(is, contentLen);
		String s = new String(b, characterEncoding);
		return s;
	}

	/**
	 * 输入流转中读取数据都byte数组，指定数组大小
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param is   输入流 
	 * @param contentLen byte数组长度
	 * @return byte[]
	 * @throws IOException 
	 * @exception
	 */
	public static byte[] readBytes(InputStream is, int contentLen) throws IOException {
		if (contentLen > 0) {
			int readLen = 0;
			int readLengthThisTime = 0;
			byte[] message = new byte[contentLen];
			while (readLen != contentLen) {
				readLengthThisTime = is.read(message, readLen, contentLen - readLen);
				if (readLengthThisTime == -1) {
					break;
				}
				readLen += readLengthThisTime;
			}
			return message;
		}
		return new byte[] {};
	}

	/**
	 * 
	 * 将sql中&lt;替换为< &gt;替换为>
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param sql 
	 * @return String
	 * @exception
	 */
	public static String converExecSqlSepcial(String sql) {
		if (sql != null && !sql.equals("")) {
			sql = sql.replace("&lt;", "<");
			sql = sql.replace("&gt;", ">");
		}
		return sql;
	}
	
	/**
	 * 获取GBK字符集字符串
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param str
	 * @return String
	 * @exception
	 */
	public static String getGBKCharacter(String str) {
		if (ObjectIsNull.check(str)) {
			return str;
		}
		String obj = "";
		try {
			obj = new String(str.getBytes("GBK"), "GBK");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
		return obj;
	}
	
	/**
	 * 从WML页面读取中文后需要通过本函数进行转换
	 * 
	 * @param str
	 *            String 需要转换的字符
	 * @return String 转化以后的字符
	 */
	public static String convertWmlPageZhStr(String str) {
		try {
			// 按照ISO8859-1取得字符串
			byte b1[] = str.getBytes("ISO8859-1");
			// 向UTF-8转换
			String utfs = new String(b1, "UTF-8");
			// 向GBK转化
			byte b2[] = utfs.getBytes("GBK");
			String GBs = new String(b2, "GBK");
			str = GBs;
		} catch (Exception ex2) {
			ex2.printStackTrace();
		}
		return str;
	}

	/**
	 * 将Long数据转换为String
	 * 若Long为null，返回null
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param l
	 * @return String
	 * @exception
	 */
	public static String getStrFromLong(Long l) {
		if (l == null) {
			return null;
		} else {
			return l.toString();
		}
	}
	
	/**
	 * 将Object转换为Long，若Object为null，返回null
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param obj
	 * @return Long
	 * @exception
	 */
	public static Long parseLongObj(Object obj) {
		if (obj == null) {
			return null;
		}
		return Long.valueOf(obj.toString());
	}
	
	/**
	 * 将String数组转换为Map
	 * 例：keys:"service,lantId,accNbr"
	 * 	  values:["test","551","1234567"]
	 *  则转换为map为：
	 *   map   	key   		value
	 *         	service		test
	 * 			lantId		551
	 * 			accNbr		1234567
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * 
	 * @param keys 所有的key拼接的字符串
	 * @param values 所有的values字符串数组
	 * @return Map<String,String>
	 * @exception
	 */
	public static Map<String, String> stringArrayToMap(String keys, String[] values) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		String[] key = keys.split(",");
		if (key.length != values.length) {
			return null;
		}
		for (int i = 0; i < key.length; i++) {
			map.put(key[i], values[i]);
		}
		return map;
	}
	
	/**
	 * 将String数组转换为List
	 * 
	 * @version 1.0 
	 * @author zhangpeng
	 * @param values
	 * @return List<String>
	 * @exception
	 */
	public static List<String> stringArrayToList(String[] values){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
		return list;
	}
	
}
