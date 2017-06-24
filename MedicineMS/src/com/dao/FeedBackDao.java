package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.entity.FeedBack;

public class FeedBackDao {
	
	public static List<FeedBack> findAll() throws SQLException{
		String sql = "select fdbc_id_PK as id,fdbc_email as email,fdbc_realName as realName,fdbc_telephone as phone,fdbc_message as message,fdbc_readState as readState,fdbc_sendDate as sendDate from FeedBack;";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(DBUtil.getConnection(), sql, new BeanListHandler<>(FeedBack.class));
	} 
	
	public static int add(FeedBack fb) throws SQLException{
		String sql = "insert into feedback values(?,?,?,?,?,?,?);";
		Object params[] = {fb.getId(),fb.getEmail(),fb.getRealName(),fb.getPhone(),fb.getMessage(),fb.getReadState(),fb.getSendDate()};
		
		QueryRunner queryRunner = new QueryRunner();
		
		return queryRunner.update(DBUtil.getConnection(), sql, params);
	}
	
	public static List<FeedBack> findByConditions(String sql, Object params[]) throws SQLException{
			QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(DBUtil.getConnection(), sql, params,new BeanListHandler<>(FeedBack.class));
	}
	
	public static int update(String sql,Object params[]) throws SQLException{
		QueryRunner queryRunner = new QueryRunner();
		
		return queryRunner.update(DBUtil.getConnection(), sql, params);
	}
	
	//根据id更改反馈状态
	public static int update(FeedBack fb) throws SQLException{
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update feedback set fdbc_email = ?,fdbc_realName = ?,fdbc_telephone = ?,fdbc_message = ?,fdbc_readState = ?,fdbc_sendDate = ? where fdbc_id_PK = ?";
		Object params[] = {fb.getEmail(),fb.getRealName(),fb.getPhone(),fb.getMessage(),fb.getReadState(),fb.getSendDate(),fb.getId()}; 
		return queryRunner.update(DBUtil.getConnection(), sql, params);
	}
	
}
