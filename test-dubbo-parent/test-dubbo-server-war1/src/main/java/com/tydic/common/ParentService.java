/*
* @author Administrator   
* @date 2017年2月8日 上午3:06:56 
* @Description: 此处添加文件描述……
*/
package com.tydic.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.tydic.fm.mybatis.dao.SqlSessionDaoImpl;

/**
 * 
 * @Package com.tydic.calcdemo.dao
 * @ClassName ParentService.java
 * @author xiangsl
 * @date 2016年2月26日 上午11:48:38
 * @Description: 此处添加类描述……
 * @version V1.0
 */
public abstract class ParentService {
	@Autowired
	private SqlSessionDaoImpl sqlSessionDaoSupport;

	/**
	 * 查询方法(无参数+返回单行)
	 * 
	 * @param routeObject
	 * @param statement
	 * @return
	 */
	protected <T> T selectOne(Object routeObject, String statement) {
		return this.sqlSessionDaoSupport.getSqlSession().selectOne(routeObject, statement);
	}

	/**
	 * 查询参数(参数+返回单行)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @return
	 */
	protected <T> T selectOne(Object routeObject, String statement, Object parameter) {
		return this.sqlSessionDaoSupport.getSqlSession().selectOne(routeObject, statement, parameter);
	}

	/**
	 * 查询方法(参数+返回List)
	 * 
	 * @param routeObject
	 * @param statement
	 * @return
	 */
	protected <E> List<E> selectList(Object routeObject, String statement) {
		return this.sqlSessionDaoSupport.getSqlSession().selectList(routeObject, statement);
	}

	/**
	 * 查询方法(参数+返回List)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @return
	 */
	protected <E> List<E> selectList(Object routeObject, String statement, Object parameter) {
		return this.sqlSessionDaoSupport.getSqlSession().selectList(routeObject, statement, parameter);
	}

	/**
	 * 查询方法(参数+返回List+逻辑分页) 该分页方法不建议使用
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @param rowBounds
	 * @return
	 */
	protected <E> List<E> selectList(Object routeObject, String statement, Object parameter, RowBounds rowBounds) {
		return this.sqlSessionDaoSupport.getSqlSession().selectList(routeObject, statement, parameter, rowBounds);
	}

	/**
	 * 查询方法(无参数+返回List+指定mapKey)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param mapKey
	 * @return
	 */
	protected <K, V> Map<K, V> selectMap(Object routeObject, String statement, String mapKey) {
		return this.sqlSessionDaoSupport.getSqlSession().selectMap(routeObject, statement, mapKey);
	}

	/**
	 * 查询方法(参数+返回List+指定mapKey)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @param mapKey
	 * @return
	 */
	protected <K, V> Map<K, V> selectMap(Object routeObject, String statement, Object parameter, String mapKey) {
		return this.sqlSessionDaoSupport.getSqlSession().selectMap(routeObject, statement, parameter, mapKey);
	}

	/**
	 * 查询方法(参数+返回List+指定mapKey+逻辑分页) 该分页方法不建议使用
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @param mapKey
	 * @param rowBounds
	 * @return
	 */
	protected <K, V> Map<K, V> selectMap(Object routeObject, String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		return this.sqlSessionDaoSupport.getSqlSession().selectMap(routeObject, statement, parameter, mapKey, rowBounds);
	}

	/**
	 * 查询方法(无参数+回调)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param handler
	 */
	protected void select(Object routeObject, String statement, ResultHandler handler) {
		this.sqlSessionDaoSupport.getSqlSession().select(routeObject, statement, handler);
	}

	/**
	 * 查询方法(参数+回调)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @param handler
	 */
	protected void select(Object routeObject, String statement, Object parameter, ResultHandler handler) {
		this.sqlSessionDaoSupport.getSqlSession().select(routeObject, statement, parameter, handler);
	}

	/**
	 * 查询方法(参数+分页+回调)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @param rowBounds
	 * @param handler
	 */
	protected void select(Object routeObject, String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
		this.sqlSessionDaoSupport.getSqlSession().select(routeObject, statement, parameter, rowBounds, handler);
	}

	/**
	 * 插入(无参数)
	 * 
	 * @param routeObject
	 * @param statement
	 * @return
	 */
	protected int insert(Object routeObject, String statement) {
		return this.sqlSessionDaoSupport.getSqlSession().insert(routeObject, statement);
	}

	/**
	 * 插入(带参数)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @return
	 */
	protected int insert(Object routeObject, String statement, Object parameter) {
		return this.sqlSessionDaoSupport.getSqlSession().insert(routeObject, statement, parameter);
	}

	/**
	 * 更新(无参数)
	 * 
	 * @param routeObject
	 * @param statement
	 * @return
	 */
	protected int update(Object routeObject, String statement) {
		return this.sqlSessionDaoSupport.getSqlSession().update(routeObject, statement);
	}

	/**
	 * 更新(带参数)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @return
	 */
	protected int update(Object routeObject, String statement, Object parameter) {
		return this.sqlSessionDaoSupport.getSqlSession().update(routeObject, statement, parameter);
	}

	/**
	 * 删除(无参数)
	 * 
	 * @param routeObject
	 * @param statement
	 * @return
	 */
	protected int delete(Object routeObject, String statement) {
		// return this.delete(routeObject, statement);
		return this.sqlSessionDaoSupport.getSqlSession().delete(routeObject, statement);
	}

	/**
	 * 删除(带参数)
	 * 
	 * @param routeObject
	 * @param statement
	 * @param parameter
	 * @return
	 */
	protected int delete(Object routeObject, String statement, Object parameter) {
		return this.sqlSessionDaoSupport.getSqlSession().delete(routeObject, statement, parameter);
	}
}