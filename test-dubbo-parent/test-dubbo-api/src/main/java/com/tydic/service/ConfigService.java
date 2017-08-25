/*
* @author Administrator   
* @date 2017年2月8日 上午3:49:15 
* @Description: 此处添加文件描述……
*/
package com.tydic.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

/**   
* @Package com.tyidic.dubbo.api.inter 
* @ClassName ConfigService.java
* @author Administrator   
* @date 2017年2月8日 上午3:49:15 
* @Description: 此处添加类描述……
* @version V1.0   
*/
@Path("config")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public interface ConfigService {
	@GET
	@Path("{id : \\d+}")
	String getConfig(@PathParam("id") String id);
}
