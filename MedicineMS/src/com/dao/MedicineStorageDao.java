package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.entity.MedicineStorage;

public class MedicineStorageDao {

	public static int update(Connection connection,String sql,Object params[]) throws SQLException{
	//������ݿ�������
	Connection con = null;
	if(connection==null){
		con = DBUtil.getConnection();
	}else {
		con = connection; 
	}
	
	QueryRunner queryRunner = new QueryRunner();
	
	return queryRunner.update(con, sql, params);//������Ӱ��ļ�¼��Ŀ	
	}

	// ͨ����ҩ׼�ֺ�+�������κŲ�ѯҩƷ�����Ϣ
	public static MedicineStorage find(String msto_cmpn_FK, String msto_batchNum) {
		QueryRunner qRunner = new QueryRunner();
		String sql = "select msto_id_PK as id,msto_cmpn_FK as cmpn,msto_name as name,msto_batchNum as batchNum,msto_manufcName as manufcName,msto_recomdPrice as recomdPrice,msto_productTele as productTele,msto_productFax as productFax,msto_productAddr as productAddr,msto_elecMonitCode as elecMonitCode,msto_productDate as productDate,msto_expireDate as expireDate,msto_sotorageNum as sotorageNum from MedicineStorage where msto_cmpn_FK = ? and msto_batchNum = ?";
		Object params[] = { msto_cmpn_FK, msto_batchNum };
		try {
			List<MedicineStorage> list = qRunner.query(DBUtil.getConnection(), sql,
					new BeanListHandler<>(MedicineStorage.class), params);

			if (!list.isEmpty()) {
				return list.get(0);
			}
		} catch (SQLException e) {
			System.out.print("**********[MedicineStorageDao:find] ���ݿ��ѯִ���쳣 **********");
			e.printStackTrace();
		}
		return null;
	}

	public static MedicineStorage find(String msto_cmpn_FK) {
		return null;
	}
	
	public static List<MedicineStorage> findByCondition(String sql,Object params[]){
		QueryRunner qRunner = new QueryRunner();
		try {
			List<MedicineStorage> list = qRunner.query(DBUtil.getConnection(), sql,
					new BeanListHandler<>(MedicineStorage.class), params);

			if (!list.isEmpty()) {
				return list;
			}
		} catch (SQLException e) {
			System.out.print("**********[MedicineStorageDao:findByCondition] ���ݿ��ѯִ���쳣 **********");
			e.printStackTrace();
		}
		return null;
	} 
	
	public static void main(String args[]) {
		MedicineStorage medicineStorage = MedicineStorageDao.find("Z44021906", "4140022");
		if (medicineStorage != null) {
			System.out.println(medicineStorage.toString());
		} else {
			System.out.println("��ѯ������ҩƷ");
		}
	}
	
	@Test
	public void test1() throws SQLException{
		String sql = "update medicinestorage set msto_sotorageNum = ? where msto_cmpn_FK = ? and  msto_batchNum = ?";
		Object params[] = {203,"Z44021906","4140022"};
		if(MedicineStorageDao.update(DBUtil.getConnection(), sql, params)>0){
			System.out.println("���ݸ��³ɹ���");
		}else{
			System.out.println("���ݸ���ʧ�ܣ�");
		}
		
	}
}
