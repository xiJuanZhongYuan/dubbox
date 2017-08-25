/*
* @author Administrator   
* @date 2017年2月8日 上午3:03:08 
* @Description: 此处添加文件描述……
*/
package com.tydic.utils;

import org.springframework.context.ApplicationContext;

/**
 * 
 * @Package com.tydic.boot.dubbo.server.utils
 * @ClassName SpringContextUtil.java
 * @author Administrator
 * @date 2017年2月8日 上午3:03:46
 * @Description: 这里用于获取spring的上下文……
 * @version V1.0
 */
public class SpringContextUtil {

	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public static Object getBean(Class<?> requiredType) {
		return applicationContext.getBean(requiredType);
	}
}