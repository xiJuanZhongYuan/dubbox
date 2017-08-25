package com.tydic.common.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tydic.utils.TeaUtil;

import io.codis.jodis.JedisResourcePool;
import io.codis.jodis.RoundRobinJedisPool;
import redis.clients.jedis.Jedis;

/**
 * 
 * @Package com.tydic.calcdemo.redis
 * @ClassName JodisPoolClient.java
 * @author xiangsl
 * @date 2016年3月26日 上午10:41:51
 * @Description: 此处添加类描述……
 * @version V1.0
 */
public class JodisPoolClient {
	private static final Logger logger = Logger.getLogger(JodisPoolClient.class);
	private String zkServers;
	private String proxyDir;
	private String redisPwd;
	private JedisResourcePool jedisPool;

	public JodisPoolClient(String zkServers, String redisPwd, String proxyDir) {
		this.zkServers = zkServers;
		this.proxyDir = proxyDir;
		this.redisPwd = TeaUtil.Decrypt(redisPwd);
		jedisPool = RoundRobinJedisPool.create().curatorClient(this.zkServers, 30000).password(this.redisPwd).zkProxyDir(this.proxyDir).build();
	}

	public JedisResourcePool getJedisPool() {
		return jedisPool;
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
	 * Description:单字符串set……
	 * 
	 * @param key
	 * @param value
	 * @param seconds 缓存超时时间
	 * @return
	 */
	public String setex(String key, int seconds, String value) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.setex(key, seconds, value);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.setex error:", e);
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
	
	/**
	 * 
	 * Description:将hashmap放入缓存中
	 * @param key hashmap对应的缓存key
	 * @param map 
	 * @return
	 */
	public String hmset(String key, Map<String, String> map) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hmset(key, map);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.hmset error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}
	
	/**
	 * 
	 * Description:从缓存中取出hashmap对应的key-val
	 * @param key  hashmap对应的缓存key
	 * @param member hashmap里的属性对应的key
	 * @return
	 */
	public List<String> hmget(String key, String member) {
		Jedis jedis = null;
		List<String> result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hmget(key, member);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.hmget error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}
	
	/**
	 * 
	 * Description:hashmap中放入对应的属性
	 * @param key hashmap对应的缓存key
	 * @param member 属性key
	 * @param value 属性值
	 * @return
	 */
	public Long hset(String key, String member, String value) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hset(key, member, value);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.hmset error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}
	
	
	/**
	 * 
	 * Description:判断hashmap里是否有对应的键值对
	 * @param key  hashmap对应的缓存key
	 * @param member hashmap里的属性对应的key
	 * @return
	 */
	public Boolean sismember(String key, String member) {
		Jedis jedis = null;
		Boolean result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.sismember(key, member);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.sismember error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}
	
	/**
	 * Description:获取整个缓存key对应的hashmap
	 * @param key
	 * @return
	 */
	public Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		Map<String, String> result = new HashMap<String, String>();
		try {
			jedis = jedisPool.getResource();
			result = jedis.hgetAll(key);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.hgetAll error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}
	
	/**
	 * 
	 * Description:设置hash key的缓存超时时间
	 * @param key hashmap对应的缓存key
	 * @param map 
	 * @param seconds 超时时间
	 * @return
	 */
	public Long expireHmset(String key, Map<String, String> map, int seconds) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hmset(key, map);
			result = jedis.expire(key, seconds);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.expireHmset error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}
	
	/**
	 * 
	 * Description:删除hash 中对应的key 
	 * @param keyMap hash 的key
	 * @param key  hash结构中的key 
	 * @return
	 */
	public Long hdel(String keyMap, String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hdel(keyMap, key);
		} catch (Exception e) {
			logger.error("RedisClientTemplate.hdel error:", e);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}
	
}