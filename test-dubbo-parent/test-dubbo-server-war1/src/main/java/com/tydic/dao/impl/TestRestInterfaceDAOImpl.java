package com.tydic.dao.impl;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tydic.common.ParentService;
import com.tydic.common.redis.JodisPoolClient;
import com.tydic.dao.TestRestInterfaceDAO;
import com.tydic.fm.mybatis.pages.PageMap;
import com.tydic.utils.ObjectIsNull;

//@Service("testRestInterfaceDAO")
public class TestRestInterfaceDAOImpl extends ParentService implements TestRestInterfaceDAO{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="jodisPoolClient")
	private JodisPoolClient jodisPoolClient;
	
	@Override
	public Map<String, Object> getCustInfo(Map<String, Object> map) {
		//分页需要用到的参数
		/*PageMap pageMap=new PageMap();
		pageMap.setStartNum(1);
		pageMap.setPageSize(3);
		map.put("pageMap", pageMap);*/
		//根据项目需要设计所需要的缓存key
		String key = "custId:" + map.get("custId") + "_latnId:" + map.get("latnId"); 
		String jsonStr = jodisPoolClient.get(key);
		String timeOut = "1800";
		Map<String, Object> resultMap = null;
		Gson gson = new Gson();
		Type type = new  com.google.gson.reflect.TypeToken<Map<String, Object>>(){}.getType();
		if(ObjectIsNull.check(jsonStr)){
			resultMap = this.selectOne(null, "test.getCustInfo", map);
			if(!ObjectIsNull.check(resultMap)){
				jodisPoolClient.setex(key, Integer.valueOf(timeOut), gson.toJson(resultMap));
			}else{
				jodisPoolClient.setex(key, Integer.valueOf(timeOut), "ObjectIsNull");
			}
		}else if("ObjectIsNull".equals(jsonStr)){
			resultMap = null;
		}else{
			resultMap = gson.fromJson(jsonStr, type);
		}
		
		return resultMap;
	}

}
