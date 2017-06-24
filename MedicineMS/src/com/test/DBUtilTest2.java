package com.test;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.dao.DBUtil;
import com.dao.UserDao;
import com.entity.MSaleRecord;
import com.entity.Staff;

public class DBUtilTest2 {
	@Test
	public void test1(){
		
//		String  sql  = "select msrd_id_PK as id,msrd_cmpn_FK as cmpn,msrd_batchNum as batchNum,msrd_saleDate as saleDate,msrd_name as name,msrd_saleNum as saleNum,msrd_salePrice as salePrice,msrd_customerId_FK as customerId,msrd_salerId_FK as salerId from MSaleRecord";
		try {
			String sql = "select staf_accountId_PK as accountName,staf_password as password,staf_userType as userType,staf_realName as realName,staf_sex as sex,staf_accountState as accountState,staf_telephone as telephone from staff where staf_accountId_PK = ? and staf_password = ?";
			Object params[] = {"staff002","1234567"};
			Staff staff = UserDao.findStaffByConditions(sql, params);
			if(staff!=null){
				JOptionPane.showMessageDialog(null, staff.toString());
			}else{
				JOptionPane.showMessageDialog(null, "查无此人。");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
