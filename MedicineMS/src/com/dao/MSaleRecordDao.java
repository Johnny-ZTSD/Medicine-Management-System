package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.entity.MSaleRecord;
import com.entity.MedicineStorage;

public class MSaleRecordDao {

	public static int createMedicineSaleRecord(MSaleRecord msalerecord) {
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);// ��������

			// ��ѯ��ҩƷ���
			MedicineStorage ms = MedicineStorageDao.find(msalerecord.getCmpn(), msalerecord.getBatchNum());
			if (ms == null) {
				con.commit();
				con.setAutoCommit(true); //�ر�����
				DBUtil.close();
				return -1; // ��ѯ������ҩƷ�Ŀ��
			}

			// �����ѯ�����򣺽��������ļ�¼�е�ҩƷ���������ݿ���ҩƷ�����Ƚ�
			int now_SotorageNum = ms.getSotorageNum() - msalerecord.getSaleNum();
			if (now_SotorageNum < 0) {// ��治��
				con.commit();
				con.setAutoCommit(true); //�ر�����
				DBUtil.close();
				return -2;
			}

			// ��֮����������ִ�и���Ϊ
			// 1.�������ۼ�¼
			// 2.���¿��

			// 1.����ҩƷ���ۼ�¼
			boolean isSuccesss_insertMSaleRecord = insert(con, msalerecord);
			// 2. ���¿��
			String sql2 = "update medicinestorage set msto_sotorageNum = ? where msto_cmpn_FK = ? and  msto_batchNum = ?";
			Object ontherPramas[] = { now_SotorageNum,msalerecord.getCmpn(),msalerecord.getBatchNum()};
			int effectNum_updateStorageNum = MedicineStorageDao.update(con, sql2, ontherPramas);
			if(isSuccesss_insertMSaleRecord==true && effectNum_updateStorageNum>=0){//��������¶����ɹ��ˣ��ύ����
				con.commit();
				con.setAutoCommit(true);//�ر�����
				
				System.out.println("**********[MedicineStorageDao ��createMedicineSaleRecord] ����ִ�гɹ������� **********");
				return 0;//�ɹ��������
				
			}else{
				con.rollback();
				con.setAutoCommit(true);//�ر�����
				return -3; //������������������û������
			}
		} catch (SQLException e) {
			try {
				con.rollback();
				con.setAutoCommit(true); //�ر�����
				DBUtil.close();
				return -4; //�ع�����ɹ�
			} catch (SQLException e1) {
				System.out.println("**********[MedicineStorageDao ��createMedicineSaleRecord] ���ݿ�����ִ���쳣[����ع�ʧ��]  **********");
				e.printStackTrace();
				e1.printStackTrace();
			} //����ع�
			System.out.println("**********[MedicineStorageDao ��createMedicineSaleRecord] ���ݿ�����ִ���쳣[����ع��ɹ�]  **********");
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean insert(Connection connection, MSaleRecord msalerecord) throws SQLException {
		// ������ݿ�������
		Connection con = null;
		if (connection == null) {
			con = DBUtil.getConnection();
		} else {
			con = connection;
		}
		// String sql = "select msrd_id_PK as id,msrd_cmpn_FK as
		// cmpn,msrd_batchNum as batchNum,msrd_saleDate as saleDate,msrd_name as
		// name,msrd_saleNum as saleNum,msrd_salePrice as
		// salePrice,msrd_customerId_FK as customerId,msrd_salerId_FK as salerId
		// from MSaleRecord";
		String sql = "insert into MSaleRecord values(?,?,?,?,?,?,?,?,?);";
		Object params[] = { msalerecord.getId(), msalerecord.getCmpn(), msalerecord.getBatchNum(),
				msalerecord.getSaleDate(), msalerecord.getName(), msalerecord.getSaleNum(), msalerecord.getSalePrice(),
				msalerecord.getCustomerId(), msalerecord.getSalerId() };
		QueryRunner qRunner = new QueryRunner();
		// List<MSaleRecord> list = qRunner.query(DBUtil.getConnection(), sql,
		// params, new BeanListHandler<>(MSaleRecord.class));
		int num = qRunner.update(con, sql, params);
		if (num > 0) {
			return true; // �����ɹ�
		}
		return false;

	}

	
	public static List<MSaleRecord> findAll() throws SQLException{
		List<MSaleRecord> list = null;
		//����ʱ�併���ѯ
		String sql = "select msrd_id_PK as id,msrd_cmpn_FK as cmpn,msrd_batchNum as batchNum,msrd_saleDate as saleDate,msrd_name as name,msrd_saleNum as saleNum,msrd_salePrice as salePrice,msrd_customerId_FK as customerId,msrd_salerId_FK as salerId from MSaleRecord order by msrd_saleDate DESC";
		QueryRunner qRunner = new QueryRunner();
		list = qRunner.query(DBUtil.getConnection(),sql,new BeanListHandler<>(MSaleRecord.class));
		return list;
	}
	
	@Test
	public void test1(){
		try {
			System.out.println(MSaleRecordDao.findAll().get(0).toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		MSaleRecord msalerecord = new MSaleRecord();
		msalerecord.setBatchNum("201602003");
		msalerecord.setCmpn("Z20080195");
		msalerecord.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		msalerecord.setSaleDate(new Date());
		msalerecord.setSalePrice(18.23);
		msalerecord.setName("�����ɺײݳ���Ƭ");
		msalerecord.setCustomerId("cust001");
		msalerecord.setSaleNum(4);
		msalerecord.setSalerId("staff002");
		try {
			System.out.print(MSaleRecordDao.createMedicineSaleRecord(msalerecord));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
