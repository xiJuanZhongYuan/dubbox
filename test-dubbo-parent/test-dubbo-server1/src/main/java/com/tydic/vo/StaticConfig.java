/*
* @author Administrator   
* @date 2017年2月8日 上午3:20:50 
* @Description: 此处添加文件描述……
*/
package com.tydic.vo;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**   
* @Package com.tydic.boot.dubbo.server.vo 
* @ClassName Test.java
* @author Administrator   
* @date 2017年2月8日 上午3:20:50 
* @Description: 静态类加载配置……
* @version V1.0   
*/
@DisconfFile(filename = "static.properties")
public class StaticConfig {
	private static String name;
	@DisconfFileItem(name = "static.name", associateField = "name")
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		StaticConfig.name = name;
	}
}
