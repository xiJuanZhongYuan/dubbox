package com.tydic.service;

import org.springframework.stereotype.Service;

@Service
public class TestDubboInterfaceImpl implements TestDubboInterface {

	@Override
	public String testDubbo(String reqContent) {
		return "����dubboЭ��ӿڣ�һ�㶼����web���������ҵģ��ӿ����������" + reqContent;
	}

}
