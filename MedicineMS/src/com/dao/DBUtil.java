package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/* *
 * Name:���ݿ⹤����
 * 
 * */
public class DBUtil{
    
	private static String datasource = "Project_MedicineMS";
	private static ComboPooledDataSource ds = null;
	private static Connection connection = null; 
	private static ResultSet rSet = null;
	private static PreparedStatement ptmt = null;
	
	/* *
	 * ��̬������
	 * */
	static{
		try {
			ds = new ComboPooledDataSource(datasource);//��̬(only one)���������õ����ӳ�
			connection =  ds.getConnection();
		} catch (SQLException e) {
			System.out.println("**********��ȡ���ݿ�����ʧ�ܣ�**********");
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
		close(connection, rSet, ptmt);//�ر�֮ǰ�����ӳ�
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			System.out.println("**********��ȡ���ݿ����ú�����ʧ�ܣ�**********");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static ComboPooledDataSource getDataSource(){
		return ds;
	}
	
	/* *
	 * ˽�й��캯��
	 * �����࣬һ�㲻Ҫʵ��������ʱ���Բ��õ������ģʽ�����߽����췽��˽�л�
	 * */
	private DBUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/* *
	 * ��ȡ���ݿ�����
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
					System.out.println("**********Ԥ�������ִ���쳣**********");
					e.printStackTrace();
				}
			}catch (Exception e) {
				System.out.println("**********Ԥ�������װ�ز����쳣**********");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("**********Ԥ��������ȡ�쳣**********");
			e.printStackTrace();
		}
		return null;
	}                  
	
	/* *
	 * �ر����ݿ�������
	 * @param conn
	 * @param rset
	 * @param ptmt   
	 * */
	public static void close(Connection conn,ResultSet rset,PreparedStatement ptmt) {
		if(rset!=null){
			try{
				rset.close();
			}catch (SQLException e) {
				System.out.println("**********������ر��쳣**********");
				e.printStackTrace();
			}
		}
		if(ptmt!=null){
			try{
				ptmt.close();
			}catch (SQLException e) {
				System.out.println("**********Ԥ�������ر��쳣**********");
				e.printStackTrace();
			}
		}
		if(ptmt!=null){
			try{
				ptmt.close();
			}catch (SQLException e) {
				System.out.println("**********���ݿ�����(��)�ر��쳣**********");
				e.printStackTrace();
			}
		}
	}
	
	
}
