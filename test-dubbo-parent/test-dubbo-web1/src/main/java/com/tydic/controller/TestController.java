package com.tydic.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tydic.service.TestDubboInterface;

@Controller
@RequestMapping(value = "/testController")
public class TestController {
	@Resource(name="testDubboInterfaceImpl111")
	private TestDubboInterface testDubboInterface;
	
	@RequestMapping(value= "/testDubbo",method=RequestMethod.POST)
	@ResponseBody
	private String testDubbo(String reqContent) {
		String aString = testDubboInterface.testDubbo("我是测试"+reqContent);
		Type type = new  com.google.gson.reflect.TypeToken<Map<String, Object>>(){}.getType();
		Gson gson = new Gson();
		//Map<String, Object> jsonMap = gson.fromJson(aString, type);
		List<Double> longList = new ArrayList<Double>();
		longList.add(1.0);
		longList.add(2.0);
		longList.add(3.0);
		return gson.toJson(gson.toJson(longList));
	}

}
