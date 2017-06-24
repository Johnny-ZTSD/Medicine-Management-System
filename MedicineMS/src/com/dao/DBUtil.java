package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/* *
 * Name:数据库工具类
 * 
 * */
public class DBUtil{
    
	private static String datasource = "Project_MedicineMS";
	private static ComboPooledDataSource ds = null;
	private static Connection connection = null; 
	private static ResultSet rSet = null;
	private static PreparedStatement ptmt = null;
	
	/* *
	 * 静态运行区
	 * */
	static{
		try {
			ds = new ComboPooledDataSource(datasource);//静态(only one)：连接配置的连接池
			connection =  ds.getConnection();
		} catch (SQLException e) {
			System.out.println("**********获取数据库连接失败！**********");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static  void close() {
		close(connection, rSet, ptmt);
	}
	
	public static void setDataSource(String newDataSource){
		datasource = newDataSource;
		ds = new ComboPooledDataSource(newDataSource);
		close(connection, rSet, ptmt);//关闭之前的连接池
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			System.out.println("**********获取数据库重置后，连接失败！**********");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static ComboPooledDataSource getDataSource(){
		return ds;
	}
	
	/* *
	 * 私有构造函数
	 * 工具类，一般不要实例化，此时可以采用单例设计模式，或者将构造方法私有化
	 * */
	private DBUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/* *
	 * 获取数据库连接
	 * @return connection
	 * */
	public static Connection getConnection() {
		return connection;
	}
	
	public static ResultSet getResultSet(String sql,Object params[]){
		connection = getConnection();
		try {
			ptmt = connection.prepareStatement(sql);
			try{
				for(int i=0;i<params.length;i++){
					ptmt.setString(i,(String)params[i]);
				}
				try{
					rSet = ptmt.executeQuery();
					return rSet;
				}catch (Exception e) {
					System.out.println("**********预处理语句执行异常**********");
					e.printStackTrace();
				}
			}catch (Exception e) {
				System.out.println("**********预处理语句装载参数异常**********");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("**********预处理语句获取异常**********");
			e.printStackTrace();
		}
		return null;
	}                  
	
	/* *
	 * 关闭数据库里连接
	 * @param conn
	 * @param rset
	 * @param ptmt   
	 * */
	public static void close(Connection conn,ResultSet rset,PreparedStatement ptmt) {
		if(rset!=null){
			try{
				rset.close();
			}catch (SQLException e) {
				System.out.println("**********结果集关闭异常**********");
				e.printStackTrace();
			}
		}
		if(ptmt!=null){
			try{
				ptmt.close();
			}catch (SQLException e) {
				System.out.println("**********预处理语句关闭异常**********");
				e.printStackTrace();
			}
		}
		if(ptmt!=null){
			try{
				ptmt.close();
			}catch (SQLException e) {
				System.out.println("**********数据库连接(池)关闭异常**********");
				e.printStackTrace();
			}
		}
	}
	
	
}
