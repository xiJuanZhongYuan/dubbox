package com.tydic.service;

import org.springframework.stereotype.Service;

@Service
public class TestDubboInterfaceImpl implements TestDubboInterface {

	@Override
	public String testDubbo(String reqContent) {
		return "我是dubbo协议接口，一般都是在web工程引用我的，接口请求入参是" + reqContent;
	}

}
