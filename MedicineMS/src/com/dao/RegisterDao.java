package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.entity.Register;

/* *
 * ������룺07X ��all��
 * */
public class RegisterDao {
	
	public static int update(String sql,Object params[]){
		try {
			QueryRunner queryRunner = new QueryRunner();
			return queryRunner.update(DBUtil.getConnection(), sql, params);
		} catch (SQLException e) {
			System.out.println("**********[RegisterDao:update][������룺071 ���ݿ����ʧ�ܣ�]");
			e.printStackTrace();
			return -1; //���ݿ�ִ��ʧ��
		}
	}
	
	public static List<Register> find(String sql,Object params[]){
		try {
			QueryRunner queryRunner = new QueryRunner();
			return queryRunner.query(DBUtil.getConnection(), sql,params,new BeanListHandler<>(Register.class));
		} catch (SQLException e) {
			System.out.println("**********[RegisterDao:find][������룺072 ���ݿ��ѯʧ�ܣ�]");
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Register> findAll(){
		String sql = "select rgst_id_PK as id,rgst_email as email,rgst_realName as realName,rgst_telephone as phone,rgst_state as state,rgst_accountId as accountId from register;";
		QueryRunner queryRunner = new QueryRunner();
		try {
			return queryRunner.query(DBUtil.getConnection(), sql,new BeanListHandler<>(Register.class));
		} catch (SQLException e) {
			System.out.println("**********[RegisterDao:findAll][������룺073 ���ݿ��ѯʧ�ܣ�]");
			e.printStackTrace();
		}
		return null;
	}
	
	
}
