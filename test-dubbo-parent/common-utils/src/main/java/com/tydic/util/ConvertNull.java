package com.tydic.util;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * 
* @Package com.tydic.boot.ppmService.server.utils 
* @ClassName ConvertNull.java
* @author 吴培顺   
* @date 2017年3月30日 下午7:00:02 
* @Description: 自定义TypeAdapter，将null字段替换为""
* @version V1.0
 */
public class ConvertNull<T> extends TypeAdapter<T>{
	@SuppressWarnings("unchecked")
	public T read(JsonReader reader) throws IOException {
		try {
			if (reader.peek() == JsonToken.NULL) {
				reader.nextNull();
				return (T) "";
			}
			return (T) reader.nextString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) "";
	}
	public void write(JsonWriter writer, T value) throws IOException {
		try {
			if (value == null) {
				writer.value("");
				return;
			}
			writer.value(value.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
