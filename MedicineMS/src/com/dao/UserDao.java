package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import com.entity.Customer;
import com.entity.Staff;

public class UserDao {
	private static Customer customer = null;
	private static Staff staff = null;
	
	public static boolean addStff(Staff staff){
		return false;
	}
	public static boolean addCustomer(Customer customer){
		return false;
	}
	
	public boolean deleteCustomer(String id){
		return false;
	}
	
	public boolean deleteStaff(String id){
		return false;
	}
	
	public static int update(String sql,Object params[]) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
		return queryRunner.update(DBUtil.getConnection(), sql, params);
	}
	
	public static Staff findStaffByPK(String pk) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
		Object params[] ={pk};
		StringBuffer sql = new StringBuffer("select staf_accountId_PK as accountName,staf_password as password,staf_userType as userType,staf_realName as realName,staf_sex as sex,staf_accountState as accountState,staf_telephone as telephone from staff where staf_accountId_PK = ?");
		List<Staff> list =  queryRunner.query(sql.toString(), params, new BeanListHandler<>(Staff.class));
		
		if(list.size()>0){
			return list.get(0);
		}
		else{
			return null;
		}
	}
	public static Staff findStaffByConditions(String sql,Object params[]) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
//		StringBuffer sql = new StringBuffer("select staf_accountId_PK as accountName,staf_password as password,staf_userType as userType,staf_realName as realName,staf_sex as sex,staf_accountState as accountState,staf_telephone as telephone from staff where staf_accountId_PK = ?");
		List<Staff> list =  queryRunner.query(sql, params, new BeanListHandler<>(Staff.class));
		
		if(list.size()>0){
			return list.get(0);
		}
		else{
			return null;
		}
	}
	
	public static Staff findCustomerByPK(String pk){
		return null;
	}
	
	public static List<Staff> findAllStaff() throws SQLException{
		String sql = "select staf_accountId_PK as accountNo,staf_password as password,staf_userType as userType,staf_realName as realName,staf_sex as sex,staf_accountState as accountState,staf_telephone as telephone from staff";
 		QueryRunner queryRunner = new QueryRunner();
 		return queryRunner.query(DBUtil.getConnection(), sql,new BeanListHandler<>(Staff.class));
	} 
	public static List<Customer> findAllCustomer() throws SQLException{
		String sql = "select cstm_accountId_PK as accountNo,cstm_password as password,cstm_userType as userType,cstm_userType as userType,cstm_sex as sex,cstm_accountState as accountState,cstm_telephone as telephone,cstm_age as age,cstm_consumpTotal as consumpTotal from Customer;";
 		QueryRunner queryRunner = new QueryRunner();
 		return queryRunner.query(DBUtil.getConnection(), sql,new BeanListHandler<>(Customer.class));
	
	} 
	
	public static int addCustomerConsumpTotal(String accountNO,double money) throws SQLException{
		String sql  ="update customer set cstm_consumpTotal = cstm_consumpTotal + ? where cstm_accountId_PK = ?";
		Object params[] = {money,accountNO};
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.update(DBUtil.getConnection(), sql, params);
	}
	
	public static void main(String args[]){
		
	}
}
