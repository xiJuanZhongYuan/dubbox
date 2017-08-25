package com.tydic.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tydic.dao.TestRestInterfaceDAO;

@Service("testRestInterfaceImpl")
public class TestRestInterfaceImpl implements TestRestInterface{
	
	/*@Resource(name="testRestInterfaceDAO")
	private TestRestInterfaceDAO testRestInterfaceDAO;*/
	@Override
	public String testRest(String reqContent) {
		/*Map<String, Object> selectMap = new HashMap<String, Object>();
		selectMap.put("custId", 55042529279L);
		selectMap.put("latnId", 550);
		Map<String,Object> resultMap = testRestInterfaceDAO.getCustInfo(selectMap);
		Gson gson = new Gson();
		System.out.println("返回数据是" + gson.toJson(resultMap));
		List<Double> longList = new ArrayList<Double>();
		longList.add(1.0);
		longList.add(2.0);
		longList.add(3.0);
		System.out.println(gson.toJson(longList));  //[1.0,2.0,3.0] 这种没有问题
		
		String jsonString = "{\"name\":\"怪盗kidou\",\"age\":24}";
		Type type = new  com.google.gson.reflect.TypeToken<Map<String, Object>>(){}.getType();
		Map<String, Object> jsonMap = gson.fromJson(jsonString, type);
		System.out.println(gson.toJson(jsonMap));//{"name":"怪盗kidou","age":24.0}  24变成了24.0
*/		//return "我是rest接口，入参是" + reqContent + "返回数据是" + gson.toJson(resultMap);
		try {
			Thread.sleep(6000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "我是rest接口，入参是" + reqContent;
	}

	@Override
	public String getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
