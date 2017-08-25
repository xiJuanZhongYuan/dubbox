package com.tydic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.remoting.http.servlet.BootstrapListener;
import com.tydic.utils.SpringContextUtil;

/**
 * 
 * @Package com.tydic.boot.dubbo.server
 * @ClassName DubboServerApplication.java
 * @author Administrator
 * @date 2017年2月8日 上午1:53:03
 * @Description: 服务启动类……
 * @version V1.0
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@ImportResource(locations = { "classpath:spring-config/*.xml","classpath:bus-config/*.xml","classpath:redis-config/*.xml"})
public class DubboServerApplication {
	/**
	 * 
	 * Description:dubbo监听类……
	 * 
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean<BootstrapListener> ServletListenerRegistrationBean() {
		ServletListenerRegistrationBean<BootstrapListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<BootstrapListener>();
		servletListenerRegistrationBean.setListener(new BootstrapListener());
		servletListenerRegistrationBean.setOrder(1);
		return servletListenerRegistrationBean;
	}

	/**
	 * 
	 * Description:dubbo之servlet注入……
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean DispatcherServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet());
		registration.addUrlMappings("/*");
		return registration;
	}

	/**
	 * 
	 * Description:启动类……
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DubboServerApplication.class, args);
		SpringContextUtil.setApplicationContext(applicationContext);
	}
}
