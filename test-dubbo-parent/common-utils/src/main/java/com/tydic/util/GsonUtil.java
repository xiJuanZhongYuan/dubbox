package com.tydic.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import vo.ProdInstVO;

public class GsonUtil {

	/**
	 * 将JSON对象序列化成JSON字符串
	 * 
	 * @param <T>
	 * @param obj
	 * @return
	 */
	public static <T> String toJsonStr(Object obj) {
		/*GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting()
				.serializeNulls().registerTypeAdapter(String.class, new ConvertNull<T>())
				.registerTypeAdapter(Long.class, new ConvertNull<T>())
				.registerTypeAdapter(Date.class, new ConvertNull<T>());
		Gson gson = gsonBuilder.create();*/
		Gson gson = new Gson();
		return ObjectIsNull.check(obj) ? "" : gson.toJson(obj);
	}

	/**
	 * 将json字符串序列化成具体的javaBean
	 * 
	 * @param jsonStr
	 * @param beanClass
	 * @return
	 */
	public static <T> Object strToJavaBean(String jsonStr, Class<T> beanClass) {
		Gson gson = new Gson();
		return ObjectIsNull.check(jsonStr) ? null : gson.fromJson(jsonStr, beanClass);
	}

	/**
	 * 将json字符串转化成jsonObject对象
	 * 
	 * @param jsonStr
	 * @param beanClass
	 * @return
	 */
	public static <T> Object strToJsonObject(String jsonStr) {
		Gson gson = new Gson();
		Type type = new TypeToken<JsonObject>() {
		}.getType();
		JsonObject jsonObj = gson.fromJson(jsonStr, type);
		return ObjectIsNull.check(jsonStr) ? null : jsonObj;
	}

	/**
	 * 将list格式的json字符串转化成listJavaBean
	 * 
	 * @param listJsonStr
	 * @param clazz
	 * @return
	 */
	private static <T> List<T> toListJavaBean(String listJsonStr, Class<T> clazz) {
		if (ObjectIsNull.check(listJsonStr)) {
			return null;
		} else {
			Type type = new TypeToken<ArrayList<JsonObject>>() {
			}.getType();
			ArrayList<JsonObject> jsonObjs = new Gson().fromJson(listJsonStr, type);
			ArrayList<T> listOfT = new ArrayList<T>();
			for (JsonObject jsonObj : jsonObjs) {
				listOfT.add(new Gson().fromJson(jsonObj, clazz));
			}
			return listOfT;
		}
	}

	public static void main(String[] args) {
		String prodInstStr = "{\"prodInstId\":11,\"prodInstName\":\"\"}";
		ProdInstVO prodInstVO = (ProdInstVO) strToJavaBean(prodInstStr, ProdInstVO.class);
		prodInstVO.setProdInstName("123");
		prodInstVO.setData2("2017041511");
		prodInstVO.setDate1(new Date());
		System.out.println(toJsonStr(prodInstVO));
		System.out.println(prodInstVO.getProdInstId());
		/*
		 * List<ProdInstVO> prodInstVOs = new ArrayList<ProdInstVO>();
		 * prodInstVOs.add(prodInstVO); prodInstVOs.add(prodInstVO);
		 * System.out.println(toJsonStr(prodInstVOs));
		 */
		String listJsonStr = "[{\"prodInstId\":11,\"prodInstName\":\"姓名1\"},"
				+ "{\"prodInstId\":22,\"prodInstName\":\"姓名2\"}]";

		List<ProdInstVO> prodInstVOs = toListJavaBean(listJsonStr, ProdInstVO.class);
		System.out.println(prodInstVOs.get(0).getProdInstName());

		JsonObject jsonObject = (JsonObject) strToJsonObject(prodInstStr);
		System.out.println(jsonObject.get("prodInstId"));
	}
}
