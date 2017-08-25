package com.tydic.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



/**
 * 此类为时间处理工具类
 * 
 * @author 15943 
 * @date 2017年3月9日 下午5:13:08 
 * @version V1.0
 */
public class DateTool {
	/**
	 * 给指定时间值为精确到分
	 */
	public static final String DATE_TOOL_ADD_MINUTES = "0"; 
	/**
	 * 给指定时间值为精确到秒 
	 */
	public static final String DATE_TOOL_ADD_SECOND = "1";

	/**
	 * 获得下个月最后一天的日期 "yyyyMMdd"的字符串格式
	 * 
	 * @return String
	 * 
	 */
	public static String getNextMonthEnd(){   
	       String str = "";   
	      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");       
	 
	      Calendar lastDate = Calendar.getInstance();   
	     lastDate.add(Calendar.MONTH,1);//加一个月   
	     lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天    
	     lastDate.roll(Calendar.DATE, -1);//日期回滚一天，也就是本月最后一天    
	      str=sdf.format(lastDate.getTime());   
	      return str;     
	  }   
	   
	/**
	 * 获得下个月第一天的日期 "yyyyMMdd"的字符串格式
	 * 
	 * @return String
	 */
	 public static String getNextMonthFirst(){   
	       String str = "";   
	      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");       
	 
	      Calendar lastDate = Calendar.getInstance();   
	     lastDate.add(Calendar.MONTH,1);//减一个月   
	     lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天    
	      str=sdf.format(lastDate.getTime());   
	      return str;     
	   }   
	   
	 /**
	  * 获得当前时间的前一分钟时间 "yyyyMMddHHmm"的字符串格式
	  * 
	  * @return String
	  */
	   public static String getPreviousTime(){
		   String prevousTime = "";
		   Calendar gc = GregorianCalendar.getInstance();
		   gc.add(Calendar.MINUTE, -1);
		   prevousTime = new SimpleDateFormat("yyyyMMddHHmm").format(gc.getTime());
		   return prevousTime;
	   }
	   
	   /**
	    * 获取当前时间(精确到分) "yyyyMMddHHmm"的字符串格式
	    * 
	    * @return String
	    */
	   public static String getCurrentTime(){
		   String currentTime = "";
		   currentTime =  new SimpleDateFormat("yyyyMMddHHmm").format( new Date());
		   return currentTime;
	   }
	   
	   /**
	    * 获取当前时间(精确到秒) "yyyyMMddHHmmss"的字符串格式
	    * 
	    * @return String
	    */
	   public static String getCurrentSecTime(){
		   String currentTime = "";
		   currentTime =  new SimpleDateFormat("yyyyMMddHHmmss").format( new Date());
		   return currentTime;
	   }
	   
	   /**
	    * 获取当前时间(精确到分) "yyyyMMddHHmmssSSS"的字符串格式
	    * 
	    * @return String
	    */
	   public static String getCurrentTimeHasMillisecond() {
		   return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	   }
	   
	   /**
	    * 给指定时间值增加时间量(分钟)
	    * 
	    * 计算为：pushDatabaseTime+minutes(分钟)，
	    * 返回结果为指定yyyyMMddHHmm格式的字符串
	    * 
	    * @param pushDatabaseTime 指定时间值
	    * @param minutes 增加时间量(分钟)
	    * @return String
	    */
	   public static String addMinutes(String pushDatabaseTime,int minutes) {
		   GregorianCalendar gc = new GregorianCalendar();
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		   Date date = null;
		   try {
				date = sdf.parse(pushDatabaseTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		   if (date == null) {
			   return null;
		   } else {
			   gc.setTime(date);
			   gc.add(Calendar.MINUTE, minutes);
			   return sdf.format(gc.getTime());
		   }
	   }
	   
	   /**
	    * 给指定时间值增加时间量(秒)
	    * 
	    * 计算为：time+secodes，
	    * 返回结果为指定yyyyMMddHHmmss格式的字符串
	    * 
	    * @param time 指定时间值
	    * @param secodes 增加时间量(秒)
	    * @return String
	    */
	   public static String addSeconds(String time,int secodes) {
		   GregorianCalendar gc = new GregorianCalendar();
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		   Date date = null;
		   try {
				date = sdf.parse(time);
			} catch (Exception e) {
				e.printStackTrace();
			}
		   if (date == null) {
			   return null;
		   } else {
			   gc.setTime(date);
			   gc.add(Calendar.SECOND, secodes);
			   return sdf.format(gc.getTime());
		   }
	   }
	   
	   /**
	    * 给指定时间值增加时间量(秒)
	    * 
	    * 计算为：time+secodes，
	    * 返回结果为指定type格式的字符串
	    * 
	    * @param pushDatabaseTime 指定时间值
	    * @param second 增加时间量(秒)
	    * @param type 指定时间值的格式  "1"为"yyyyMMddHHmmss","0"为"yyyyMMddHHmm"
	    * @return String
	    */
	   public static String addMinutesOrSecond(String pushDatabaseTime,int second,String type) {
		   GregorianCalendar gc = new GregorianCalendar();
		   SimpleDateFormat sdf = null;
		   if(DATE_TOOL_ADD_SECOND.equals(type)){
			   sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		   }else {
			   sdf = new SimpleDateFormat("yyyyMMddHHmm");
		   }
		   Date date = null;
		   try {
				date = sdf.parse(pushDatabaseTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		   if (date == null) {
			   return null;
		   } else {
			   gc.setTime(date);
			   gc.add(Calendar.SECOND, second);
			   return sdf.format(gc.getTime());
		   }
	   }
	   
	   
	   /**
	    * 计算当前时间前多少秒前的时间
	    * 
	    * 计算为：time-secodes，
	    * 返回结果为指定type格式的字符串
	    * 
	    * @param time 指定时间值
	    * @param secodes 向前时间量(秒)
	    * @param type 指定时间值的格式  "1"为"yyyyMMddHHmmss","0"为"yyyyMMddHHmm"
	    * @return String
	    */
	   public static String subtractSeconds(String time,int secodes,String type) {
		   GregorianCalendar gc = new GregorianCalendar();
		   SimpleDateFormat sdf = null;
		   if(DATE_TOOL_ADD_SECOND.equals(type)){
			   sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		   }else{
			   sdf = new SimpleDateFormat("yyyyMMddHHmm");
		   }
		   Date date = null;
		   try {
				date = sdf.parse(time);
			} catch (Exception e) {
				e.printStackTrace();
			}
		   if (date == null) {
			   return null;
		   } else {
			   gc.setTime(date);
			   gc.add(Calendar.SECOND, -secodes);
			   return sdf.format(gc.getTime());
		   }
	   }
	   
	   /**
	    * 时间差值计算
	    * 
	    * 计算为：curentTime-ReqTime，
	    * 返回的为秒数（long）
	    * 
	    * @param curentTime 比较时间(减数) 
	    * @param reqTime 被比较时间(被减数)
	    * @param pattern 时间格式 例："yyyyMMddHHmmss"
	    * @return long
	    */
	   public static long getTimeDifference(String curentTime,String reqTime,String pattern){
		   long difference = 0L;
		   if(!ObjectIsNull.check(curentTime) && !ObjectIsNull.check(reqTime) && !ObjectIsNull.check(pattern)){
			   SimpleDateFormat sd = new SimpleDateFormat(pattern);
			   try {
				   difference = Math.abs(sd.parse(curentTime).getTime() - sd.parse(reqTime).getTime());
			   } catch (ParseException e) {
				   e.printStackTrace();
			   }
			   if(!ObjectIsNull.check(difference)){
				   difference = difference/1000L; // 获得秒数
			   }
		   }
		   return difference;
	   }
	   
	   /**
		 * 比较两个日期大小
		 * 
		 * 	1、param0(日期1) > param1(日期2),返回true，否则返回false
		 * 	2、param0 == null，返回false；
		 * 	3、param1 == null，返回true；
		 * 
		 * @Description：
		 * @param param0 Date 日期1
		 * @param param1 Date 日期2
		 * @return boolean 
		 */
		public static boolean compareToDate(Date param0, Date param1) {
			if (param0 == null)
				return false;
			if (param1 == null)
				return true;
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			return Integer.parseInt(df.format(param0)) > Integer.parseInt(df.format(param1));
		}

		/**
		 * 判断两个日期年月是否相等
		 * 
		 * beginDate与endDate相等，返回true，否则返回false
		 * 
		 * @Description：
		 * @param beginDate Date 日期1
		 * @param endDate   Date 日期1
		 * @return boolean
		 */
		public static boolean isMonthEquals(Date beginDate, Date endDate) {
			if (beginDate == null || endDate == null) {
				return false;
			}
			DateFormat df = new SimpleDateFormat("yyyyMM");
			return Integer.parseInt(df.format(beginDate)) == Integer.parseInt(df.format(endDate));
		}

		/**
		 * 比较两个日期是否同一天
		 * 
		 * 同一天返回true，否则返回false
		 * 
		 * @Description：
		 * @param param0 Date
		 * @param param1 Date
		 * @return boolean
		 */
		public static boolean equalsToDate(Date param0, Date param1) {
			if (param0 == null)
				return false;
			if (param1 == null)
				return true;
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			return Integer.parseInt(df.format(param0)) == Integer.parseInt(df.format(param1));
		}
		
		/**
		 * 获取当天最小日期值，如传入日期为2017-3-14 4:09:13 ，返回2017-3-14 00:00:00 
		 * 
		 * @version 1.0 
		 * @author zhangpeng
		 * @param date
		 * @return Date
		 * @exception
		 */
		public static Date setDateMinTime(Date date) {
			if (date == null) {
				return null;
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 00);
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);
			return cal.getTime();
		}

		/**
		 * 获取当天最大日期值，如传入日期为2017-3-14 4:09:13 ，返回2017-3-14 23:59:59 
		 * 
		 * @version 1.0 
		 * @author zhangpeng
		 * @param date
		 * @return Date
		 * @exception
		 */
		public static Date setDateMaxTime(Date date) {
			if (date == null) {
				return null;
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			return cal.getTime();
		}

	   
}
