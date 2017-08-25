package com.tydic.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Copyrights @ 2009，Tianyuan DIC Computer<br>
 *            CRM项目组<br>
 *            All rights reserved.<br>
 *            <br>
 *            Filename： DealJtOrder.java<br>
 *            Description： xml解析对象<br>
 *            Version： V1.0<br>
 *            Author: 向书龙<br>
 *            Finished： 04, 8, 2009<br>
 */
public class XMLBufferParser {
	/**
	 * 获取有指定路径的xml节点值
	 * 
	 * @param xml
	 * @param head
	 * @param name
	 * @return
	 */
	public static String getXmlValue(String xml, String filePath) {
		String rtnMsg = "";
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return rtnMsg;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = "(.*?)";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "<" + path.trim() + ">" + xmlRes + "</" + path.trim() + ">";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			rtnMsg = matcher.group(1);
			return rtnMsg;
		}
		return rtnMsg;
	}

	/**
	 * 获取有指定路径的xml节点值,同时包含了该结点
	 * 
	 * @param xml
	 * @param head
	 * @param name
	 * @return
	 */
	public static String getXmlNodeValue(String xml, String filePath) {
		String rtnMsg = "";
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return rtnMsg;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = ".*?";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "(<" + path.trim() + ">" + xmlRes + "</" + path.trim() + ">)";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			rtnMsg = matcher.group(1);
			return rtnMsg;
		}
		return rtnMsg;
	}

	/**
	 * 获取指定路径的xml值
	 * 
	 * @param xml
	 * @param filePath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List getXmlList(String xml, String filePath) {
		List list = new ArrayList();
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return list;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = "(.*?)";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "<" + path.trim() + ">" + xmlRes + "</" + path.trim() + ">";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}

	/**
	 * 获取指定路径的xml值
	 * 
	 * @param xml
	 * @param filePath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List getXmlNodeList(String xml, String filePath) {
		List list = new ArrayList();
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return list;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = ".*?";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "(<" + path.trim() + ">" + xmlRes + "</" + path.trim() + ">)";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}

	/**
	 * 获取有指定正则表达式的xml节点值 主要用于特殊值的获取
	 * 
	 * @param xml
	 * @param filePath
	 * @param inString
	 * @return
	 */
	public static String getSpecialXmlValue(String xml, String xmlRes) {
		String rtnMsg = "";
		if (null == xml || null == xmlRes || "".equals(xml) || "".equals(xmlRes)) {
			return rtnMsg;
		}
		xmlRes = xmlRes.replace("\r\n", "");
		xmlRes = xmlRes.replace("\t", "");
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			rtnMsg = matcher.group(1);
		}
		return rtnMsg;
	}

	/**
	 * 获取有指定正则表达式的xml节点值 主要用于特殊值的获取
	 * 
	 * @param xml
	 * @param filePath
	 * @param inString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List getSpecialList(String xml, String xmlRes) {
		List list = new ArrayList();
		if (null == xml || null == xmlRes || "".equals(xml) || "".equals(xmlRes)) {
			return list;
		}
		xmlRes = xmlRes.replace("\r\n", "");
		xmlRes = xmlRes.replace("\t", "");
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}

	/**
	 * 通过指定路径添回xml文,xmlPath以符号|隔开
	 * 
	 * @param xml
	 * @param xmlPath
	 * @param xmlNode
	 * @param xmlValue
	 * @return
	 */
	public static String addXmlByPath(String xml, String xmlPath, String xmlNode, String xmlValue) {
		String rtnXml = "<" + xmlNode + ">" + xmlValue + "</" + xmlNode + ">";
		String[] paths = xmlPath.split("\\|");
		int start = 0;
		for (String path : paths) {
			start = xml.indexOf(path, start);
			start = start + path.length();
		}
		rtnXml = xml.substring(0, start) + rtnXml + xml.substring(start);
		return rtnXml;
	}

	/**
	 * 通过指定路径添回xml文,xmlPath以符号|隔开
	 * 
	 * @param xml
	 * @param xmlPath
	 * @param xmlNode
	 * @param xmlValue
	 * @return
	 */
	public static String addXmlByLastTag(String xml, String xmlPath, String xmlValue) {
		String rtnXml = xmlValue;
		int start = 0;
		start = xml.indexOf(xmlPath, start);
		start = start + xmlPath.length();
		rtnXml = xml.substring(0, start) + " " + rtnXml + xml.substring(start);
		return rtnXml;
	}

	/**
	 * 通过所包含的字符串来查找所属于的父节点
	 * 
	 * @param xml
	 * @param filePath
	 * @param subString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getXmlValueBySubString(String xml, String filePath, String subString) {
		String rtnMsg = "";
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return rtnMsg;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = ".*?";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "(<" + path.trim() + ">" + xmlRes + "</" + path.trim() + ">)";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		XMLBufferParser.getXmlNodeList(xml, filePath);
		while (matcher.find()) {
			if (matcher.group(1).contains(subString)) {
				rtnMsg = matcher.group(1);
				return rtnMsg;
			}
		}
		return rtnMsg;
	}

	/**
	 * 在字符串name:xiangsl,password:19860202查找name的值:xiangsl
	 * 
	 * @param params
	 * @param split
	 * @param key
	 * @return
	 */
	public static String getParamBySplit(String params, String split, String splitSub, String key) {
		if (null == params || "".equals(params) || null == split || "".equals(split) || null == key || "".equals(key)
				|| null == splitSub || "".equals(splitSub)) {
			return null;
		}
		split = split.replace("\r\n", "");
		split = split.replace("\t", "");
		splitSub = splitSub.replace("\r\n", "");
		splitSub = splitSub.replace("\t", "");
		key = key.replace("\r\n", "");
		key = key.replace("\t", "");
		key = key.replace(" ", "");
		String[] keyValues = params.split(split.trim());
		String[] keyValue;
		for (int i = 0; i < keyValues.length; i++) {
			keyValue = keyValues[i].split(splitSub.trim(),-1);
			if (keyValue[0].contains(key)) {
				return keyValue[1];
			}
		}
		return null;
	}

	/**
	 * 判断一个字符串是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 将目标字符串中的特殊符号去掉  add by liuyi 20100825
	 * @param goalString 特处理的字符串
	 * @param regString 要去除的符号，以"，"分割，正则表达式形式
	 * @return
	 */
	public static String replaceAll(String goalString, String regString) {
		String result = goalString;
		if (regString != null && !regString.equals("")) {
			String[] arr = regString.split(",");
			for (int i = 0; i < arr.length; i++) {
				try {
					result = result.replaceAll(arr[i], "");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return result;
	}

	/**
	 * 在给定的元素中获取指定属性的值.该元素应该从getElementsByTag方法中获取
	 * @param xml String
	 * @param attributeName String
	 * @return String
	 */
	public static String getAttribute(String xml, String attributeName) {
		//HashMap hm = new HashMap<String, String>();
		Pattern p = Pattern.compile("<[^>]+>");
		Matcher m = p.matcher(xml);
		String tmp = m.find() ? m.group() : "";
		p = Pattern.compile("(\\w+)\\s*=\\s*\"([^\"]+)\"");
		m = p.matcher(tmp);
		while (m.find()) {
			if (m.group(1).trim().equals(attributeName))
				return m.group(2).trim();
		}
		return "";
	}



	/**
	 * 通过所包含的字符串来查找所属于的父节点 add by liuyi 2011-07-15
	 * 
	 * @param xml
	 * @param filePath
	 * @param subString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getParentXmlBySubStr(String xml, String filePath, String subString) {
		String rtnMsg = "";
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return rtnMsg;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		//		String[] paths = filePath.split("/");
		String xmlRes = ".*?";
		//		String path;
		//		for (int i = paths.length - 1; i >= 0; i--) {
		//			path = paths[i];
		//			if (i == paths.length - 1) {
		//				xmlRes = "(<" + path.trim() + ">" + xmlRes + "</" + path.trim()
		//						+ ">)";
		//			} else {
		//				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</"
		//						+ path.trim() + ">";
		//			}
		//		}
		//  正则表达式形如 (<cust.*?</cust>)
		xmlRes = "(<" + filePath.trim() + xmlRes + "</" + filePath.trim() + ">)";
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		//		List list = XMLBufferParser.getXmlNodeList(xml, filePath);
		while (matcher.find()) {
			if (matcher.group(1).contains(subString)) {
				rtnMsg = matcher.group(1);
				return rtnMsg;
			}
		}
		return rtnMsg;
	}
	
	/**
	 * 获得指定节点名称的节点字符串
	 * @param xml 源xml
	 * @param filePath 节点名称 只能是cust式格式，不能为cust/name含/的格式
	 * @param subString 节点中包含该子串
	 * @return
	 */
	public static List<String> getParentXmlListBySubStr(String xml, String filePath,String subString) {
		List<String> list = null;
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return list;
		}
		list = new ArrayList<String>();
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		//		String[] paths = filePath.split("/");
		String xmlRes = ".*?";
		//		String path;
		//		for (int i = paths.length - 1; i >= 0; i--) {
		//			path = paths[i];
		//			if (i == paths.length - 1) {
		//				xmlRes = "(<" + path.trim() + ">" + xmlRes + "</" + path.trim()
		//						+ ">)";
		//			} else {
		//				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</"
		//						+ path.trim() + ">";
		//			}
		//		}
		//  正则表达式形如 (<cust.*?</cust>)
		xmlRes = "(<" + filePath.trim() + xmlRes + "</" + filePath.trim() + ">)";
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		//		List list = XMLBufferParser.getXmlNodeList(xml, filePath);
		while (matcher.find()) {
			if (matcher.group(1).contains(subString)) {
				list.add(matcher.group(1));
			}
		}
		return list;
	}
	
	/**
	 * 获得指定节点名称的节点字符串  该节点可能有属性<SOO type="ADD_ORDER_ITEM_GROUP_REQ_TYPE"></SOO>
	 * @param xml 源xml
	 * @param filePath 节点名称 只能是cust式格式，不能为cust/name含/的格式  
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List getXmlNodeListHavAttr(String xml, String filePath) {
		List list = new ArrayList();
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return list;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String xmlRes = ".*?";
		xmlRes = "(<" + filePath.trim()  + xmlRes + "</" + filePath.trim() + ">)";
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}
	
	public static boolean isLocalId(String id){
		boolean flag = false;
		if(null != id && !"".equals(id)){
			Pattern pattern = Pattern.compile("^[a-zA-Z]\\d+$");
			Matcher matcher = pattern.matcher(id);
			if(matcher.find()){
				flag = true;
			}
		}
		return flag;
	}
	
	public static String getHasAttrXmlValue(String xml, String filePath) {
		String rtnMsg = "";
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return rtnMsg;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = "(.*?)";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "<" + path.trim() + ".*?>" + xmlRes + "</" + path.trim() + ">";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			rtnMsg = matcher.group(1);
			return rtnMsg;
		}
		return rtnMsg;
	}
	
	public static List<String> getHasAttrXmlValueList(String xml, String filePath) {
		List<String> list = new ArrayList<String>();
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return list;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = "(.*?)";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "<" + path.trim() + ".*?>" + xmlRes + "</" + path.trim() + ">";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		String rtnMsg = null;
		while (matcher.find()) {
			rtnMsg = matcher.group(1);
			list.add(rtnMsg);
		}
		return list;
	}
	
	
	/**
	 * 获取有指定路径的xml节点值,同时包含了该结点
	 * 
	 * @param xml
	 * @param head
	 * @param name
	 * @return
	 */
	public static String getHasAttrXmlNode(String xml, String filePath) {
		String rtnMsg = "";
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return rtnMsg;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = ".*?";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "(<" + path.trim() + ".*?>" + xmlRes + "</" + path.trim() + ">)";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			rtnMsg = matcher.group(1);
			return rtnMsg;
		}
		return rtnMsg;
	}
	
	
	public static List getHasAttrXmlNodeList(String xml, String filePath) {
		List list = new ArrayList();
		if (null == xml || null == filePath || "".equals(xml) || "".equals(filePath)) {
			return list;
		}
		filePath = filePath.replace("\r\n", "");
		filePath = filePath.replace("\t", "");
		String[] paths = filePath.split("/");
		String xmlRes = ".*?";
		String path;
		for (int i = paths.length - 1; i >= 0; i--) {
			path = paths[i];
			if (i == paths.length - 1) {
				xmlRes = "(<" + path.trim() + ".*?>" + xmlRes + "</" + path.trim() + ">)";
			} else {
				xmlRes = "<" + path.trim() + ">.*?" + xmlRes + ".*?</" + path.trim() + ">";
			}
		}
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}
	
	//解析具体属性值 add by wujinxing 2014.04.23
	public static String getxmlAttrCd(String xml,String id){
		String xmlRes = "ATTR.*?"+id+".*?VAL.*?\"(.*?)\"";
//		System.out.println(xmlRes);//luwei 注释  2014/8/15
//		xmlRes = "(<" + filePath.trim()  + xmlRes + "</" + filePath.trim() + ">)";
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			return matcher.group(1)+"";
		}
		return null;
	}
	
	/**
	 * add by luwei
	 * @param xml   xml报文
	 * @param id  属性名称
	 * @param filePath  获取属性值的xml范围  通过该路径进行限制
	 * @return
	 */
	public static String getxmlAttrCdByPath(String xml,String id,String filePath){
		String xml1 = getXmlNodeValue(xml, filePath) ;
		String xmlRes = "ATTR.*?"+id+".*?VAL.*?\"(.*?)\"";
		Pattern pattern = Pattern.compile(xmlRes, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(xml1);
		while (matcher.find()) {
			return matcher.group(1)+"";
		}
		return null;
	}
	
	public static String addJsonByLastTag(String xml, String xmlPath,
			String xmlValue) {
		String rtnXml = xmlValue;
		int start = 0;
		start = xml.indexOf(xmlPath, start);
		start = start + xmlPath.length();
		rtnXml = xml.substring(0, start) + "," + rtnXml + xml.substring(start);
		return rtnXml;
	}
	
	
	public static void main(String[] args) {
		// String xml = "<SrcSysID>1000000200</SrcSysID><SrcSysSign>123</SrcSysSign>";
//		boolean flag = XMLBufferParser.isLocalId(xml);
//		System.out.println(flag);
		
		List<String> list = new ArrayList<String>();
		list.add("<FIELD>PROD_OFFER_INST_ID</FIELD>");
		
		String xmlStr = 
			"<SOO type=\"QRY_PROD_OFFER_INST_REQ_TYPE\">\n" +
			"      <PUB_REQ>\n" + 
			"        <SOO_ID>9</SOO_ID>\n" + 
			"      </PUB_REQ>\n" + 
			"      <PROD_INST_ID>3505075005</PROD_INST_ID>\n" + 
			"      <LAN_ID>8341100</LAN_ID>\n" + 
			"      <FIELD>PROD_OFFER_INST_ID</FIELD>\n" + 
			"      <FIELD>PARENT_OFFER_PROD_INST_ID</FIELD>\n" + 
			"      <FIELD>EXT_PROD_OFFER_INST_ID</FIELD>\n" + 
			"      <FIELD>CUST_ID</FIELD>\n" + 
			"      <FIELD>EXT_CUST_ID</FIELD>\n" + 
			"      <FIELD>CHANNEL_ID</FIELD>\n" + 
			"      <FIELD>PROD_OFFER_ID</FIELD>\n" + 
			"      <FIELD>PROD_OFFER_NAME</FIELD>\n" + 
			"      <FIELD>EXT_PROD_OFFER_ID</FIELD>\n" + 
			"      <FIELD>OFFER_NBR</FIELD>\n" + 
			"      <FIELD>OFFER_TYPE</FIELD>\n" + 
			"      <FIELD>PROD_OFFER_EFFECTIVE_TYPE</FIELD>\n" + 
			"      <FIELD>EFF_DATE</FIELD>\n" + 
			"      <FIELD>EXP_DATE</FIELD>\n" + 
			"      <FIELD>LAN_ID</FIELD>\n" + 
			"      <FIELD>STATUS_CD</FIELD>\n" + 
			"      <FIELD>STATUS_DATE</FIELD>\n" + 
			"      <FIELD>CREATE_DATE</FIELD>\n" + 
			"    </SOO>";

//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "", "ContractRoot", "");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "<ContractRoot>", "TransactionID", "1000000200201409181500460812");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</TransactionID>", "BusCode", "BUS80001");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</BusCode>", "ServiceCode", "SVC80009");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</ServiceCode>", "SrcSysID", "1000000200");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</SrcSysID>", "DstSysID", "600301");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</DstSysID>", "PackageGroup", "1000000200201409180000000219");
//		
//		
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</PackageGroup>", "WorkOrder", "");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "<WorkOrder>", "CustOrderId", "20140818102001");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</CustOrderId>", "OrderItemGroupId", "2012121271244131");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</OrderItemGroupId>", "ChannelId", "100000001");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</ChannelId>", "ChannelName", "dls");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</ChannelName>", "AccNbr", "18908181020");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</AccNbr>", "LanId", "550");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</LanId>", "ProdInstId", "2012113070725568");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</ProdInstId>", "DistributorId", "2012113070725568");
//		
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</WorkOrder>", "Page", "");
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "<Page>", "PageIndex", String.valueOf(1l));
//		xmlStr = XMLBufferParser.addXmlByPath(xmlStr, "</PageIndex>", "PageSize", String.valueOf(3l));
		
		String type = XMLBufferParser.getAttribute(xmlStr, "type");
		String id = XMLBufferParser.getXmlValue(xmlStr, "SOO_ID");
		System.out.println(type);
		System.out.println(id);
	}


}
