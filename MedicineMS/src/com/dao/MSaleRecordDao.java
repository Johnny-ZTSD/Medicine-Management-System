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
			con.setAutoCommit(false);// 开启事务

			// 查询该药品库存
			MedicineStorage ms = MedicineStorageDao.find(msalerecord.getCmpn(), msalerecord.getBatchNum());
			if (ms == null) {
				con.commit();
				con.setAutoCommit(true); //关闭事务
				DBUtil.close();
				return -1; // 查询不到此药品的库存
			}

			// 如果查询到，则：将待创建的记录中的药品数量与数据库中药品余量比较
			int now_SotorageNum = ms.getSotorageNum() - msalerecord.getSaleNum();
			if (now_SotorageNum < 0) {// 库存不足
				con.commit();
				con.setAutoCommit(true); //关闭事务
				DBUtil.close();
				return -2;
			}

			// 反之：可以正常执行该行为
			// 1.创建销售记录
			// 2.更新库存

			// 1.创建药品销售记录
			boolean isSuccesss_insertMSaleRecord = insert(con, msalerecord);
			// 2. 更新库存
			String sql2 = "update medicinestorage set msto_sotorageNum = ? where msto_cmpn_FK = ? and  msto_batchNum = ?";
			Object ontherPramas[] = { now_SotorageNum,msalerecord.getCmpn(),msalerecord.getBatchNum()};
			int effectNum_updateStorageNum = MedicineStorageDao.update(con, sql2, ontherPramas);
			if(isSuccesss_insertMSaleRecord==true && effectNum_updateStorageNum>=0){//如果两件事都做成功了：提交事务
				con.commit();
				con.setAutoCommit(true);//关闭事务
				
				System.out.println("**********[MedicineStorageDao ：createMedicineSaleRecord] 事务执行成功！！！ **********");
				return 0;//成功完成事务
				
			}else{
				con.rollback();
				con.setAutoCommit(true);//关闭事务
				return -3; //事务正常，但两件事没有做成
			}
		} catch (SQLException e) {
			try {
				con.rollback();
				con.setAutoCommit(true); //关闭事务
				DBUtil.close();
				return -4; //回滚事务成功
			} catch (SQLException e1) {
				System.out.println("**********[MedicineStorageDao ：createMedicineSaleRecord] 数据库事务执行异常[事务回滚失败]  **********");
				e.printStackTrace();
				e1.printStackTrace();
			} //事务回滚
			System.out.println("**********[MedicineStorageDao ：createMedicineSaleRecord] 数据库事务执行异常[事务回滚成功]  **********");
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean insert(Connection connection, MSaleRecord msalerecord) throws SQLException {
		// 获得数据库连接器
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
			return true; // 创建成功
		}
		return false;

	}

	
	public static List<MSaleRecord> findAll() throws SQLException{
		List<MSaleRecord> list = null;
		//按照时间降序查询
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
		msalerecord.setName("复方仙鹤草肠炎片");
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
