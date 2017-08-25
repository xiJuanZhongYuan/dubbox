package com.tydic.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class DataSourceUtil {

	public  DruidDataSource dataSource = null;
	
	
	public   Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return conn;
    } 
	
	public DruidDataSource initDataSource(){
		dataSource = new DruidDataSource();
		try {
			InputStream in = this.getClass().getResourceAsStream("/druid11.properties");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));  
			Properties properties = new Properties();
			properties.load(bufferedReader);
			
			dataSource = new DruidDataSource();
			dataSource.setUrl(properties.getProperty("druid.dataBaseUrl"));
			dataSource.setUsername(properties.getProperty("druid.dataBaseName"));
	        dataSource.setPassword(properties.getProperty("druid.dataBasePwd"));
	        dataSource.setMaxActive(Integer.valueOf(properties.getProperty("druid.maxActive")));
	        dataSource.setInitialSize(Integer.valueOf(properties.getProperty("druid.initialSize")));
	        dataSource.setMinIdle(Integer.valueOf(properties.getProperty("druid.minIdle")));
	        dataSource.setValidationQuery(properties.getProperty("druid.validationQuery"));
		} catch (IOException e) {
			e.printStackTrace();
		}
 		return dataSource;
	}
	/**
	 * 获得序列
	 * @param sql
	 * @return
	 */
	public  Long getSequence() {
		initDataSource();
		Long sequence = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			if (ObjectIsNull.check(conn)) {
				conn = getConnection();
			}
			
			stmt = conn.prepareStatement(dataSource.getValidationQuery());
			rs = stmt.executeQuery();
			ResultSetMetaData rsMeta = rs.getMetaData();

            while (rs.next()) {
               /* Map<String, Object> row = new LinkedHashMap<String, Object>();

                for (int i = 0, size = rsMeta.getColumnCount(); i < size; ++i) {
                    String columName = rsMeta.getColumnLabel(i + 1);
                    Object value = rs.getObject(i + 1);
                    row.put(columName, value);
                }*/
            	sequence = rs.getLong(1);
               // rows.add(row);
            }
		} catch (Exception e) {
			e.printStackTrace();;
		} finally {
			if (!ObjectIsNull.check(conn)){
				try {
					conn.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			try {
				stmt.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return sequence;
	}
	
}
