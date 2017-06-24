package com.test;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.dao.MedicineStorageDao;
import com.entity.MedicineStorage;
import com.service.MStorageService;

public class MStorageDaoTest {
	@Test
	public void search_MSaleRecord(){
		String sql = "select msto_id_PK as id,msto_cmpn_FK as cmpn,msto_name as name,msto_batchNum as batchNum,msto_manufcName as manufcName,msto_recomdPrice as recomdPrice,msto_productTele as productTele,msto_productFax as productFax,msto_productAddr as productAddr,msto_elecMonitCode as elecMonitCode,msto_productDate as productDate,msto_expireDate as expireDate,msto_sotorageNum as sotorageNum from MedicineStorage ";
		Object params[] = {};
		JOptionPane.showMessageDialog(null, MedicineStorageDao.findByCondition(sql, params).get(0));
	}
}
