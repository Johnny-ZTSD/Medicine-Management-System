package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.entity.Medicine;

public class MedicineDao {
	
	public static List<Medicine> findByConditions(String sql,Object params[]) throws SQLException{
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(DBUtil.getConnection(), sql, params, new BeanListHandler<>(Medicine.class));
	}
	
	public static boolean delete(String cmpk) throws SQLException{
		QueryRunner queryRunner = new QueryRunner();
		String sql  ="delete from medicine where mdcn_cmpn_PK = ?";
//		JOptionPane.showMessageDialog(null, "sql:"+sql+"|cmpk:"+cmpk);
		return queryRunner.update(DBUtil.getConnection(), sql, new Object[]{cmpk})>0?true:false;//可能存在外键引用约束
	}
	
	public static int update(String sql,Object params[]) throws SQLException{
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.update(DBUtil.getConnection(), sql,params);//可能存在外键引用约束
	}
}
