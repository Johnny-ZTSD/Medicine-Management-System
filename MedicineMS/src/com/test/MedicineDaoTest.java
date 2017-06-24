package com.test;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.dao.MedicineDao;
import com.entity.Medicine;

public class MedicineDaoTest {

	public void find() throws SQLException{
		String sql = "select mdcn_cmpn_PK as cmpk,mdcn_name as name,mdcn_isPrescription as isPrescription,mdcn_component as component ,mdcn_property as property,mdcn_useType as useType,mdcn_mainFun as mainFun,mdcn_standard as standard,mdcn_forbid as forbid,mdcn_badEffect as badEffect,mdcn_attention as attention,mdcn_wrap as wrap,mdcn_storageWay as storageWay from Medicine";
		Object params[] = {}; 
		JOptionPane.showMessageDialog(null, MedicineDao.findByConditions(sql, params).get(0).toString());;
	}
	
	
	public void findTest() throws SQLException{
		List<Medicine> list  = null;
		StringBuffer sql = new StringBuffer("select mdcn_cmpn_PK as cmpk,mdcn_name as name,mdcn_isPrescription as prescription,mdcn_component as component ,mdcn_property as property,mdcn_useType as useType,mdcn_mainFun as mainFun,mdcn_standard as standard,mdcn_forbid as forbid,mdcn_badEffect as badEffect,mdcn_attention as attention,mdcn_wrap as wrap,mdcn_storageWay as storageWay from Medicine");
		//分用户的查询输入情况作数据库分类查询
//		if(cmpn.length()<1 && cmpn.length()<1 && mainFunc.length()<1 && isPrescription_Flag==-1){//无任何条件时：全部查询
			Object params[] = {}; 
			list =  MedicineDao.findByConditions(sql.toString(), params);
			JOptionPane.showMessageDialog(null, list.get(0).toString());
	}
	
	
	//测试删除记录
	@Test
	public void TestDelete() throws HeadlessException, SQLException{
		String cmpk = "Z0000000";
		JOptionPane.showMessageDialog(null, MedicineDao.delete(cmpk));
	}
}
