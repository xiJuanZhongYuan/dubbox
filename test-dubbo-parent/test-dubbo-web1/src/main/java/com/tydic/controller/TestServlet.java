package com.tydic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tydic.service.TestDubboInterface;


@WebServlet("/TestServlet.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public TestServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "private");
		response.setHeader("Pragma", "no-cache");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		//TestDubboInterface testDubboInterface =(TestDubboInterface)context.getBean("testDubboInterfaceImpl");
		//String test=testDubboInterface.testDubbo("我是测试");
		String test = "11";
		response.getWriter().append("test--success:\n"+test);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
