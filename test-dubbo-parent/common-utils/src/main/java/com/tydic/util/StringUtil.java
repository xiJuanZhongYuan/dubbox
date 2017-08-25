package com.tydic.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * 字符串处理工具类
 * 
 * @ClassName: StringUtil 
 * @author zhangpeng 
 * @date 2017年3月14日 上午10:33:54 
 * @version V1.0
 */
public class StringUtil {

		/**
		 * 取得字符串的长度
		 * 
		 * @version 1.0 
		 * @author zhangpeng
		 * @param str
		 * @return int
		 * @exception
		 */
		public static int length(String str) {
			if (ObjectIsNull.check(str))
				return 0;
			return str.trim().length();
		}

		
		/**
		 * 将数据库字段转换为驼峰式
		 * 例 ： PROD_INST_ID 转换为 prodInstId
		 * 
		 * @version 1.0 
		 * @author zhangpeng
		 * @param columnName
		 * @return String
		 * @exception
		 */
		public static String getPropertyWithColumn(String columnName) {
			String[] columnSplits = null;
			// TODO:modifier.songfq.010112 : String 组装修改
			StringBuffer returnString = new StringBuffer("get");
			if (columnName != null && columnName.indexOf('_') > 0) {
				columnSplits = columnName.trim().split("_");
				for (String varS : columnSplits) {
					returnString.append(varS.substring(0, 1).toUpperCase()).append(varS.substring(1).toLowerCase());
				}
				return returnString.toString();
			} else {
				if (columnName != null && columnName.trim().length() > 0) {
					returnString.append(columnName.substring(0, 1).toUpperCase()).append(
							columnName.substring(1).toLowerCase());
					return returnString.toString();
				} else {
					return null;
				}
			}
		}
		
		
		
		/**
		 * @Description：解析目录树标志
		 * @param identifier
		 *            目录唯一值
		 * @return
		 */
		@SuppressWarnings("unused")
		public static String[] split(final String identifier, final String delim) {
			if (ObjectIsNull.check(identifier) || ObjectIsNull.check(delim)) {
				return null;
			}
			StringTokenizer toKen = new StringTokenizer(identifier, delim);
			String[] returnObj = new String[toKen.countTokens()];
			int i = 0;
			while (toKen.hasMoreTokens()) {
				returnObj[i] = toKen.nextToken();
				i++;
			}
			return returnObj;
		}

		

		/**
		 * 为字符串替换新的分隔符
		 * 
		 * @param str
		 *            替换的字符串值
		 * @param oldSeparator
		 *            字符串中存在的分隔符
		 * @param newSeparator
		 *            字符串中新的分隔符
		 * @return
		 */
		public static String replaceAll(String str, char oldSeparator, char newSeparator) {
			// TODO:modifier.songfq.010112 : String 组装修改
			StringBuffer v = new StringBuffer();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				v = (c == oldSeparator) ? v.append(newSeparator) : v.append(c);
			}
			return v.toString();
		}
		
		/**
	     *  替换字符串函数
	     *  String strSource - 源字符串
	     *  String strFrom   - 要替换的子串
	     *  String strTo     - 替换为的字符串
	     */
	    public static String replace(String strSource, String strFrom, String strTo) {
	      // 如果要替换的子串为空，则直接返回源串
	      if(strFrom == null || strFrom.equals(""))
	          return strSource;
	      String strDest = "";
	      // 要替换的子串长度
	      int intFromLen = strFrom.length();
	      int intPos;
	      // 循环替换字符串
	      while((intPos = strSource.indexOf(strFrom)) != -1)
	      {
	          // 获取匹配字符串的左边子串
	          strDest = strDest + strSource.substring(0,intPos);
	          // 加上替换后的子串
	          strDest = strDest + strTo;
	          // 修改源串为匹配子串后的子串
	          strSource = strSource.substring(intPos + intFromLen);
	      }
	      // 加上没有匹配的子串
	      strDest = strDest + strSource;
	      // 返回
	      return strDest;
	    }
	    
	    /**
	     * 随机返回三位数值字符串
	     * @param input
	     * @param size
	     * @param symbol
	     * @return
	     */
	    public static String randomString(){
	    	
	    	 Random rnd = new Random();

	         int num = 100 + rnd.nextInt(900);
	         
	         return num+"";
	    }
	    
	    
	    /**
	     * 不足位数往前补齐函数
	     * @param input
	     * @param size
	     * @param symbol
	     * @return
	     */
	    public static String fill(String input, int size, String symbol) { 
	    	while (input.length() < size) { 
	    		input = symbol + input; 
	    	}
	    	return input; 
		}
	    
	    /**
		 * 时间戳长度
		 */
		private static int timeStampLength = 4;

		

		/**
		 * 字符串替换方法，使用新的字符串替换所有旧的字符串
		 * 
		 * @param srcStr
		 * @param oldStr
		 * @param newStr
		 * @return
		 */
		public static String replaceAll(String srcStr, String oldStr, String newStr) {
			// srcStr 不能为空,oldStr，newStr不能为空，并且srcStr与oldStr长度不能为0
			if (srcStr == null || srcStr.length() == 0 || oldStr == null || oldStr.length() == 0 || newStr == null) {
				return srcStr;
			}
			if (oldStr.equals(newStr)) {
				return srcStr;
			}
			StringBuffer sb = new StringBuffer(100);
			// 取第一个需要被替换的字符串所在位置
			int index = srcStr.indexOf(oldStr);
			if (index == -1) {
				return srcStr;
			}
			while (index >= 0) {
				sb.append(srcStr.substring(0, index) + newStr);
				// 取余下部分作为需要被替换的新字符串
				srcStr = srcStr.substring(index + oldStr.length());
				index = srcStr.indexOf(oldStr);
				if (index == -1) {
					sb.append(srcStr);
				}
			}
			return sb.toString();
		}


		/**
		 * 获取系统时间戳,返回字符串
		 * 
		 * @return String
		 */
		public static String getTimeStamp() {
			String starttime = String.valueOf(System.currentTimeMillis());
			String timeStamp = starttime.substring(starttime.length() - timeStampLength);
			return timeStamp;
		}

		/**
		 * 从源串截取不超过指定字节长度的字符串
		 * 
		 * @param inputString
		 *            String
		 * @param byteLen
		 *            int
		 * @return String
		 * @throws Exception
		 */
		public static String cutString(String inputString, int byteLen) throws Exception {
			//String tempString = "";
			StringBuilder tempString = new StringBuilder();
			String outputString = inputString;
			if (inputString.getBytes("GBK").length > byteLen) {
				for (int i = 0; i < inputString.length(); i++) {
					//tempString = tempString + inputString.substring(i, i + 1);
					tempString.append(inputString.substring(i, i + 1));
					if (tempString.toString().getBytes("GBK").length > byteLen) {
						outputString = inputString.substring(0, i);
						break;
					}
				}
			}

			return outputString;
		}

		/**
		 * 位数不够左补充，多余右结尾
		 * 
		 * @param totalLength
		 * @param fillChar
		 * @param srcStr
		 * @param chineseFlag
		 * @return
		 */
		public static String leftFill(int totalLength, char fillChar, String srcStr, boolean chineseFlag) {
			int byteLength = (srcStr == null ? 0 : srcStr.length());
			if (chineseFlag && (byteLength > 0)) {
				try {
					byteLength = srcStr.getBytes("GBK").length;
				} catch (Exception e) {
//					logger.error("leftFill() string.getBytes(GBK) exception-->", e);
					return leftFill(totalLength, fillChar, null, false);
				}
			}

			int length = totalLength - byteLength;
			if (length < 0) {
				return srcStr.substring(0, totalLength);
			} else if (length == 0) {
				return srcStr;
			} else {
				char[] arr = new char[length];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = fillChar;
				}
				String sFill = new String(arr);
				if (length == totalLength) {
					return sFill;
				} else {
					return sFill + srcStr;
				}
			}
		}

		/**
		 * 位数不够右补充，多余右结尾
		 * 
		 * @param totalLength
		 * @param fillChar
		 * @param srcStr
		 * @param chineseFlag
		 * @return
		 */
		public static String rightFill(int totalLength, char fillChar, String srcStr, boolean chineseFlag) {
			int byteLength = (srcStr == null ? 0 : srcStr.length());
			if (chineseFlag && (byteLength > 0)) {
				try {
					byteLength = srcStr.getBytes("GBK").length;
				} catch (Exception e) {
//					logger.error("rightFill() string.getBytes(GBK) exception-->", e);
					return rightFill(totalLength, fillChar, null, false);
				}
			}

			int length = totalLength - byteLength;
			if (length < 0) {
				return srcStr.substring(0, totalLength);
			} else if (length == 0) {
				return srcStr;
			} else {
				char[] arr = new char[length];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = fillChar;
				}
				String sFill = new String(arr);
				if (length == totalLength) {
					return sFill;
				} else {
					return srcStr + sFill;
				}
			}
		}

		/**
		 * 在IP列表中查找某个特定的IP
		 * 
		 * @param remoteIP
		 *            需要查找的IP
		 * @param list
		 *            IP列表
		 * @return
		 */
		public static boolean findIP(String remoteIP, String[] list) {
			String[] remoteIPList = remoteIP.split("\\.");
			if (remoteIPList == null || remoteIPList.length != 4) {
				return false;
			}

			if (list.length >= 1 && "ALL".equalsIgnoreCase(list[0])) {
				return true;
			}
			for (int i = 0; i < list.length; i++) {
				String ip = list[i];
				if (ObjectIsNull.check(ip)) {
					continue;
				}
				String[] tempArray = ip.split("\\.");
				if (remoteIPList[0].equals(tempArray[0])) {
					if (tempArray[1].equals("*")) {
						return true;
					} else {
						if (remoteIPList[1].equals(tempArray[1])) {
							if (tempArray[2].equals("*")) {
								return true;
							} else {
								if (remoteIPList[2].equals(tempArray[2])) {
									if (tempArray[3].equals("*") || remoteIPList[3].equals(tempArray[3])) {
										return true;
									}
									if (tempArray[3].indexOf("-") >= 0) {
										String[] temp = tempArray[3].split("-");
										if (temp.length != 2) {
											continue;
										}
										int start = Integer.parseInt(temp[0]);
										int end = Integer.parseInt(temp[1]);
										int remoteInt = Integer.parseInt(remoteIPList[3]);
										if (remoteInt >= start && remoteInt <= end || remoteInt <= start && remoteInt >= end) {
											return true;
										}
									}
								}
							}
						}
					}
				}

			}
			return false;
		}

		public static String cutString(String str, int beginIndex, int cutLeng) throws UnsupportedEncodingException {
			//String tmpStr = "";
			StringBuilder tmpStr = new StringBuilder();
			int tmpBeg = 0; //开始位置
			int tmpEnd = 0; //结束位置
			int haveBeg = 0;
			int haveEnd = 0;

			for (int i = 0; i < str.length(); i++) {
				//取得每一个字符串
				//tmpStr = tmpStr + str.substring(i,i+1);
				tmpStr.append(str.substring(i, i + 1));

				//取到第i个字符时的位数
				int byteLen = tmpStr.toString().getBytes("GBK").length;

				if (byteLen > beginIndex && haveBeg == 0) {
					tmpBeg = i;
					haveBeg = 1;
				}

				if (byteLen > cutLeng + beginIndex && haveEnd == 0) {
					tmpEnd = i;
					haveEnd = 1;
				}
			}
			if (tmpBeg > 0 && tmpEnd == 0) {
				tmpEnd = str.length();
			}

			return str.substring(tmpBeg, tmpEnd);

		}
		
		/****
		 * 解析全网资料查询字符串，该字符串里面即有函数又有主键，函数名称只能以get开头
		 * 
		 * @param queryString
		 *            解析字符串如：":ge(1101,010,18912345678,00101005101000000000),789,:getCustIdByAccNbr(1101,010,18912345678,00101005101000000000),123,456,:getCustIdByAccNbr2(1101,010,18912345678,00101005101000000000),10,11,12,:get(1101,010,18912345678,00101005101000000000)"
		 * @return
		 */
		public static List<String> stringParser(String queryString) {
			queryString = queryString.toUpperCase();
			List<String> list = new ArrayList<String>();
			if (queryString != null && !"".equals(queryString)) {
				queryString = queryString.replaceAll(":", "");//替换字符串里面的：
				String[] firSeps = queryString.split("\\)");//第一次以）分隔
				for (int i = 0; i < firSeps.length; i++) {
					String temp1 = null;
					if (firSeps[i].indexOf("(") != -1) {//子串中包含函数，函数缺少右括号，添加有括号")"
						temp1 = (firSeps[i] + ")");
					} else {//子串中不包含函数
						temp1 = firSeps[i];
					}
					//System.err.println("第一次分割：" + temp1);
					if (temp1.indexOf("G") != -1) {//子串包括函数
						String[] twoSeps = temp1.split("GE");//第二次以g分隔
						for (int j = 0; j < twoSeps.length; j++) {
							String temp2 = null;
							if (twoSeps[j].indexOf("T") != -1) {//子串包括函数，直接添加到结果集里面
								temp2 = "GE" + twoSeps[j];
								list.add(temp2);
							} else {//子串不包括函数，以逗号分隔的子串
								temp2 = twoSeps[j];
								String[] threeSeps = temp2.split(",");//第三次以逗号分隔
								for (int k = 0; k < threeSeps.length; k++) {
									if (threeSeps[k] != null && !"".equals(threeSeps[k])) {
										list.add(threeSeps[k]);
									}
								}
							}
						}
					} else {//子串不包括函数
						String[] twoSeps = temp1.split(",");//第一次子串中不包含函数再以逗号进行分割
						for (int k = 0; k < twoSeps.length; k++) {
							if (twoSeps[k] != null && !"".equals(twoSeps[k])) {
								list.add(twoSeps[k]);
							}
						}
					}
				}
			}
			/*
			 * for (String aString2 : list) { System.err.println("分隔后的字符：" +
			 * aString2); }
			 */
			return list;
		}

		

		/*****
		 * 如果实例ID存在，则转换成List，并且如果是辅助函数的话，去除辅助函数打头的冒号。
		 * 这种改动最直接的改变就是：不支持一个实例ID中存在多个的情况，只支持一个实例ID存在一个。
		 * 
		 * @author ShaoShuai
		 * @since 2015/04/09
		 * @param instId
		 * @return
		 */
		public static List<String> stringParser2(String instId) {
			List<String> list = new ArrayList<String>();
			if (instId != null && !"".equals(instId)) {
				instId = instId.replaceAll(":", "");//替换字符串里面的：
				list.add(instId);
			}
			return list;
		}
		
}
