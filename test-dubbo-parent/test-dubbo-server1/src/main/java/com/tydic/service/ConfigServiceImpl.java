/*
* @author Administrator   
* @date 2017年2月8日 上午3:49:58 
* @Description: 此处添加文件描述……
*/
package com.tydic.service;

import org.springframework.stereotype.Service;

import com.tydic.utils.SpringContextUtil;
import com.tydic.vo.BasicConfig;
import com.tydic.vo.ConfigVO;
import com.tydic.vo.StaticConfig;

/**   
* @Package com.tydic.boot.dubbo.server.service 
* @ClassName ConfigServiceImpl.java
* @author Administrator   
* @date 2017年2月8日 上午3:49:58 
* @Description: 此处添加类描述……
* @version V1.0   
*/
@Service
public class ConfigServiceImpl implements ConfigService{
	@Override
	public String getConfig(String id) {
		BasicConfig basicConfig=(BasicConfig)SpringContextUtil.getBean("basicConfig");
		String userName=basicConfig.getUserName();
		ConfigVO configVO=(ConfigVO)SpringContextUtil.getBean("configVO");
		String rtn="basicConfig.userName[自动加载]:"+userName+"\n";
		rtn=rtn+"configVO.auto[自动加载]:"+configVO.getAuto()+"\n";
		rtn=rtn+"configVO.noAuto[非自动加载]:"+configVO.getNoAuto()+"\n";
		rtn=rtn+"StaticConfig.name[静态类]:"+StaticConfig.getName()+"\n";
		return "结果:\n"+rtn;
	}
}
