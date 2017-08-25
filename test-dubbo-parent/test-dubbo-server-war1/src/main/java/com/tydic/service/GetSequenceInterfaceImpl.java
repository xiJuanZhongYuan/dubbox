package com.tydic.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSource;
import com.tydic.util.DataSourceUtil;
import com.tydic.utils.ObjectIsNull;

@Service
public class GetSequenceInterfaceImpl implements GetSequenceInterface {
	
	@Resource(name="druidDataSource")
	private DruidDataSource druidDataSource;
	@Override
	public String getSequence(String reqContent) {
		return "";
		//下面的代码请在使用 共通jar包之后才能使用
		/*if (true) {
			DataSourceUtil dataSourceUtil = new DataSourceUtil();
			return String.valueOf(dataSourceUtil.getSequence());
		}
		Long sequence = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			if (ObjectIsNull.check(conn)) {
				conn = getConnection();
			}
			if (ObjectIsNull.check(druidDataSource.getValidationQuery())) {
				return "请在druid.properties里面配置druid.validationQuery选项";
			}
			stmt = conn.prepareStatement(druidDataSource.getValidationQuery());
			rs = stmt.executeQuery();
			ResultSetMetaData rsMeta = rs.getMetaData();

            while (rs.next()) {
            	sequence = rs.getLong(1);
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
		return ObjectIsNull.check(sequence) ? "" : String.valueOf(sequence);*/
	}
	
	public  Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            conn = druidDataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return conn;
    } 

}
