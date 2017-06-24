package com.test;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import static org.junit.Assert.assertEquals;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/* Target:����ͨ����Դ����c3p0 ��ȡ�������ӣ��أ�
 * 
 * Description:
 * �����������ݿ��Ҫ�Ĳ����⣬�ṩ����������Ĳ���������Ϣ�����γ����ݿ����ӳ�
 *	1��    acquireIncrement  ÿ��������������
 *	2��    initalPoolSize ��ʼ������
 *	3��    maxPoolSize   ���������
 *	4��    maxIdleTime   ��������
 *	5��    minPoolSize   ����������С����
 * */

public class ConnectionTest {

	/*
	 * 1.0��ȡ����Դ���ֶ��� ʹ��c3p0�������ӳأ��������ݿ����Ӳ���
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
		cpds.setMaxStatements(100); // ���������
		Connection conn = cpds.getConnection();
		System.out.println("1.0 ���ݿ����ӳɹ���");
	}

	/*
	 * 2.0 ��ȡ����Դ����ȡ����Դ,ʹ������Դ������DataSources
	 */
	@Test
	public void test2() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/medicinems";
		String user = "root";
		String password = "123456";
		DataSource ds = DataSources.unpooledDataSource(jdbcURL, user, password);
		DataSource pooledDateSource = DataSources.pooledDataSource(ds);
		System.out.println(pooledDateSource.getConnection());
		System.out.println("2.0 ���ݿ����ӳɹ���");
	}

	/*
	 * 3.0 ��ȡ����Դ:ʹ�������ļ�c3p0-config.xml ʹ��c3p0�������ӳأ��������ݿ����Ӳ���
	 */
	// @Test
	public void test3() throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource("Project_MedicineMS");
		Connection conn = cpds.getConnection();
		System.out.println("3.0 ���ݿ����ӳɹ���");

	}
}