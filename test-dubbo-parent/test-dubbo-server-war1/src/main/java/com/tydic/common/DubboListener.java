package com.tydic.common;

import java.io.File;
import java.util.Iterator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;


public class DubboListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent event) {
		//System.setProperty("dubbo.properties.file", configPath);
		//HttpServletRequest request = (HttpServletRequest) RpcContext.getContext().getRequest();
		System.out.println("配置文件中配置的端口号是："+System.getProperty("dubbo.protocol.rest.port"));
		//ApplicationContext applicationContext  = (ApplicationContext) event.getServletContext();
		//applicationContext.get
		event.getServletContext();
		System.setProperty("dubbo.protocol.rest.port", "8081");
	}
	
}
