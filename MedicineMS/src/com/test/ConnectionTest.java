package com.test;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import static org.junit.Assert.assertEquals;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/* Target:测试通过开源工具c3p0 获取数据连接（池）
 * 
 * Description:
 * 除了连接数据库必要的参数外，提供以下最基本的参数配置信息才能形成数据库连接池
 *	1、    acquireIncrement  每次连接增加数量
 *	2、    initalPoolSize 初始连接数
 *	3、    maxPoolSize   最大连接数
 *	4、    maxIdleTime   最大空闲数
 *	5、    minPoolSize   池中连接最小数量
 * */

public class ConnectionTest {

	/*
	 * 1.0获取数据源：手动版 使用c3p0数据连接池，进行数据库连接测试
	 */
	// @Test
	public void test1() throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		String driverClass = "com.mysql.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/medicinems";
		String user = "johnny";
		String password = "123456";
		cpds.setDriverClass(driverClass);
		cpds.setJdbcUrl(jdbcURL);
		cpds.setUser(user);
		cpds.setPassword(password);
		cpds.setMaxStatements(100); // 最大连接数
		Connection conn = cpds.getConnection();
		System.out.println("1.0 数据库连接成功！");
	}

	/*
	 * 2.0 获取数据源：获取数据源,使用数据源工厂类DataSources
	 */
	@Test
	public void test2() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/medicinems";
		String user = "root";
		String password = "123456";
		DataSource ds = DataSources.unpooledDataSource(jdbcURL, user, password);
		DataSource pooledDateSource = DataSources.pooledDataSource(ds);
		System.out.println(pooledDateSource.getConnection());
		System.out.println("2.0 数据库连接成功！");
	}

	/*
	 * 3.0 获取数据源:使用配置文件c3p0-config.xml 使用c3p0数据连接池，进行数据库连接测试
	 */
	// @Test
	public void test3() throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource("Project_MedicineMS");
		Connection conn = cpds.getConnection();
		System.out.println("3.0 数据库连接成功！");

	}
}