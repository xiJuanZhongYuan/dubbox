package com.tydic.common.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @Package com.tydic.calcdemo.redis
 * @ClassName JedisPoolClient.java
 * @author xiangsl
 * @date 2016年3月26日 上午10:41:31
 * @Description: redis模板类 redis支持丰富的数据类型操作，包括String,list,hash,set,sorted set
 *               模板仅包装了String和byte类的操作，大家可以通过getJedisPool自己再封装，切记要回收资源……
 * @version V1.0
 */
public class JedisPoolClient {
	private static Logger logger = LoggerFactory.getLogger(JedisPoolClient.class);

	private JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	/**
	 * 
	 * Description:单字符串set……
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(String key, String value) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.set(key, value);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.set error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}

	/**
	 * 
	 * Description:序列化操作……
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(byte[] key, byte[] value) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.set(key, value);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.set error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}

	/**
	 * 
	 * Description:单字符串get……
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.get(key);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.get error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}

	/**
	 * 
	 * Description:序列化get……
	 * 
	 * @param key
	 * @return
	 */
	public byte[] get(byte[] key) {
		Jedis jedis = null;
		byte[] result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.get(key);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.get error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}

	/**
	 * 
	 * Description:单字符串删除……
	 * 
	 * @param key
	 * @return
	 */
	public Long del(String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.del(key);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.del error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}

	/**
	 * 
	 * Description:序列化删除……
	 * 
	 * @param key
	 * @return
	 */
	public Long del(byte[] key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.del(key);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.del error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}
}