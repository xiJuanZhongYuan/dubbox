package com.tydic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
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
//@ServletComponentScan 通过注解自动注册servlet，但是只能识别通过 @WebServlet、@WebFilter、@WebListener 注解的servlet
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@ImportResource(locations = { "classpath:spring-config/*.xml","classpath:bus-config/*.xml","classpath:redis-config/*.xml"})
public class DubboServerApplication extends SpringBootServletInitializer{
	
	/**
	 * 外置容器启动
	 * 继承SpringBootServletInitializer并重写configure方法
	 */
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		/* ApplicationListener bootListener = (ApplicationListener) new BootstrapListener();
		 springApplicationBuilder.listeners(bootListener);*/
		 return springApplicationBuilder.sources(DubboServerApplication.class);  
    }
	
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
	 * 使用代码注册Servlet（不需要@ServletComponentScan注解）
	 * 代码注册通过ServletRegistrationBean、 FilterRegistrationBean 和 ServletListenerRegistrationBean 获得控制。 
	 * 分别注册servlet  filter  lintener
	 * @return
	 */
	@Bean
	public ServletRegistrationBean DispatcherServletRegistration() {
		//com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet()  本来是注册在web.xml里面的servlet
		//这里也可以注测  自己自定义的一个servlet，
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
