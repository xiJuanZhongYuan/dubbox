package com.tydic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/test")
public class Test {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	//@RequestMapping(value="/testAjax", produces="text/html;charset=UTF-8")
	@RequestMapping(value="/testAjax")
	@ResponseBody
	private String testAjax(String inputStr) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET,OPTIONS,DELETE");
		 response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		return "我进来了" + inputStr;
	}

}
