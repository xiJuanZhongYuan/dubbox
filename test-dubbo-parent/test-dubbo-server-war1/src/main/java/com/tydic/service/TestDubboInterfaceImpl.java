package com.tydic.service;

import org.springframework.stereotype.Service;

@Service("testDubboInterfaceImpl")
public class TestDubboInterfaceImpl implements TestDubboInterface {

	@Override
	public String testDubbo(String reqContent) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "我是dubbo协议接口，接口入参是" + reqContent;
	}

}
