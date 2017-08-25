/*
* @author Administrator   
* @date 2017年2月8日 上午2:47:18 
* @Description: 此处添加文件描述……
*/
package com.tydic.vo;

import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * @Package com.tydic.boot.dubbo.server.service
 * @ClassName AutoConfig.java
 * @author Administrator
 * @date 2017年2月8日 上午2:47:18
 * @Description: 这里的配置 文件会自动更新……
 * @version V1.0
 */
@Service
@DisconfFile(filename = "basicconfig.properties")
public class BasicConfig {
	private String userName;

	@DisconfFileItem(name = "basicconfig.username", associateField = "userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
}
