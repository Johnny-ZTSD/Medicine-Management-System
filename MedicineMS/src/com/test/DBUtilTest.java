package com.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.dao.DBUtil;
import com.entity.Customer;
import com.entity.MSaleRecord;
import com.entity.Medicine;
import com.entity.MedicineStorage;
import com.entity.PurchaseProject;
import com.entity.PurchaseRecord;
import com.entity.Staff;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.util.BaseDao;

/*
 * Target:测试DBUtil方法
 * */
public class DBUtilTest {
	//@Test
	public void getConnection() {
		DBUtil.getConnection();
		System.out.print("数据库连接成功！");
	}
	
	/* *
	 * 测试Staff Bean能否传值成功
	 * 一定需要使用 A as B（将数据库列名A as Bean中的属性名，否则，属性值将无法赋值成功）
	 * */
	@Test
	public void testStaff(){
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
			List<Staff> list =  qRunner.query(DBUtil.getConnection(), "select staf_accountId_PK as accountName,staf_password as password,staf_userType as userType,staf_realName as realName,staf_sex as sex,staf_accountState as accountState,staf_telephone as telephone from staff",new BeanListHandler<>(Staff.class));
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			System.out.println("执行成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("数据库连接成功！");
	}
	
	/* *
	 * 测试Customer Bean能否传值成功
	 * 一定需要使用 A as B（将数据库列名A as Bean中的属性名，否则，属性值将无法赋值成功）
	 * */
	//@Test
	public void testCustomer1(){
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
			List<Customer> list =  qRunner.query(DBUtil.getConnection(), "select cstm_accountId_PK as accountNo,cstm_password as password,cstm_userType as userType,cstm_userType as userType,cstm_sex as sex,cstm_accountState as accountState,cstm_telephone as telephone,cstm_age as age,cstm_consumpTotal as consumpTotal from Customer",new BeanListHandler<>(Customer.class));
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			System.out.println("执行成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("数据库连接成功！");
	}

	/* *
	 * 测试Medicine Bean能否传值成功
	 * 一定需要使用 A as B（将数据库列名A as Bean中的属性名，否则，属性值将无法赋值成功）
	 * */
	//@Test
	public void testMedicine(){
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
//			List<Medicine> list =  qRunner.query(DBUtil.getConnection(), "select mdcn_cmpn_PK as cmpk,mdcn_name as name,mdcn_isPrescription as isPrescription,mdcn_component as component ,mdcn_property as property,mdcn_useType as useType,mdcn_mainFun as mainFun,mdcn_standard as standard,mdcn_forbid as forbid,mdcn_badEffect as badEffect,mdcn_attention as attention,mdcn_wrap as wrap,mdcn_storageWay as storageWay from Medicine",new BeanListHandler<>(Medicine.class));
			List<Medicine> list =  qRunner.query(DBUtil.getConnection(), "select mdcn_usage as usageX from Medicine",new BeanListHandler<>(Medicine.class));
			
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			System.out.println("执行成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("数据库连接成功！");
	}

	/* *
	 * 测试Customer Bean能否传值成功
	 * 一定需要使用 A as B（将数据库列名A as Bean中的属性名，否则，属性值将无法赋值成功）
	 * */
	//@Test
	public void testCustomer(){
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
			List<Customer> list =  qRunner.query(DBUtil.getConnection(), "select cstm_accountId_PK as accountNo,cstm_password as password,cstm_userType as userType,cstm_userType as userType,cstm_sex as sex,cstm_accountState as accountState,cstm_telephone as telephone,cstm_age as age,cstm_consumpTotal as consumpTotal from Customer",new BeanListHandler<>(Customer.class));
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			System.out.println("执行成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("数据库连接成功！");
	}

	/* *
	 * 测试MedicineStorage Bean能否传值成功
	 * 一定需要使用 A as B（将数据库列名A as Bean中的属性名，否则，属性值将无法赋值成功）
	 * */
	//@Test
	public void testMedicineStorage(){
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
			List<MedicineStorage> list =  qRunner.query(DBUtil.getConnection(), "select msto_id_PK as id,msto_cmpn_FK as cmpn,msto_name as name,msto_batchNum as batchNum,msto_manufcName as manufcName,msto_recomdPrice as recomdPrice,msto_productTele as productTele,msto_productFax as productFax,msto_productAddr as productAddr,msto_elecMonitCode as elecMonitCode,msto_productDate as productDate,msto_expireDate as expireDate,msto_sotorageNum as sotorageNum from MedicineStorage",new BeanListHandler<>(MedicineStorage.class));
//			List<MedicineStorage> list =  qRunner.query(DBUtil.getConnection(), "select msto_name as name  from MedicineStorage",new BeanListHandler<>(MedicineStorage.class));
			
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			System.out.println("执行成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("数据库连接成功！");
	}
	
	/* *
	 * 测试MSaleRecord Bean能否传值成功
	 * 一定需要使用 A as B（将数据库列名A as Bean中的属性名，否则，属性值将无法赋值成功）
	 * */
	@Test
	public void testMSaleRecord(){
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
			List<MSaleRecord> list =  qRunner.query(DBUtil.getConnection(), "select msrd_id_PK as id,msrd_cmpn_FK as cmpn,msrd_batchNum as batchNum,msrd_saleDate as saleDate,msrd_name as name,msrd_saleNum as saleNum,msrd_salePrice as salePrice,msrd_customerId_FK as customerId,msrd_salerId_FK as salerId from MSaleRecord",new BeanListHandler<>(MSaleRecord.class));
//			List<MSaleRecord> list =  qRunner.query(DBUtil.getConnection(), "select msrd_id_PK as id from MSaleRecord",new BeanListHandler<>(MSaleRecord.class));
			
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			System.out.println("执行成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("数据库连接成功！");
	}
	
	
	/* *
	 * 测试PurchaseProject Bean能否传值成功
	 * 一定需要使用 A as B（将数据库列名A as Bean中的属性名，否则，属性值将无法赋值成功）
	 * */
	@Test
	public void testPurchaseProject(){
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
			List<PurchaseProject> list =  qRunner.query(DBUtil.getConnection(), "select ppro_id_PK as id,ppro_name as name,ppro_desc as descX,ppro_sponsorId_FK as sponsorId_FK,ppro_startTime as startTime,ppro_endTime as endTime,ppro_seek as seek,ppro_state as state from PurchaseProject",new BeanListHandler<>(PurchaseProject.class));
//			List<PurchaseProject> list =  qRunner.query(DBUtil.getConnection(), "select ppro_id_PK as id from PurchaseProject",new BeanListHandler<>(PurchaseProject.class));
			
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			System.out.println("执行成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("数据库连接成功！");
	}
	
	
	/* PurchaseRecord Bean能否传值成功
	 * 一定需要使用 A as B（将数据库列名A as Bean中的属性名，否则，属性值将无法赋值成功）
	 * */
	@Test
	public void testPurchaseRecord(){
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
			List<PurchaseRecord> list =  qRunner.query(DBUtil.getConnection(), "select prcd_id_PK as id,prcd_purchaserId_FK as purchaserId,prcd_finishTime as finishTime,prcd_isFinish as isFinish,prcd_cmpn_FK as cmpn,prcd_productNum as prcd_productNum,prcd_medicineName as medicineName,prcd_type as type,prcd_price as price,prcd_productDate as productDate, prcd_expireDate as expireDate,prcd_medicineNum as medicineNum from PurchaseRecord",new BeanListHandler<>(PurchaseRecord.class));
//			List<PurchaseRecord> list =  qRunner.query(DBUtil.getConnection(), "select prcd_id_PK as id from PurchaseRecord",new BeanListHandler<>(PurchaseRecord.class));
			
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
			}
			System.out.println("执行成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("数据库连接成功！");
	}
	
	@Test
	public void test2() {
		testbean Testbean = new testbean("admin129","456654","李奎","M");

		BaseDao<testbean> baseDao = new BaseDao<testbean>("testbean", Testbean.getClass(), new String[] { "bean_id"});
		baseDao.addObject(Testbean);
	}

	@Test
	public void test3() {
		System.out.println("开始执行");
		QueryRunner qr= new QueryRunner(new ComboPooledDataSource("Project_Test"));
		String sql  ="update testbean set bean_password=?";
		Object params[] ={"7654321"};
		try {
			System.out.println("xxxx");
			System.out.println("更新操作结果："+qr.update(sql, params));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* *
	 * 利用DBUtil进行查 
	 * */
	@Test
	public void select(){
		String sql = "select * from testbean";
		List<testbean> list = null;
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		try {
			
			 //获取所有人的数据，使用BeanListHandler<>(Bean.class)，以Bean封装得到的字段信息，
			list =  qRunner.query(sql, new BeanListHandler<>(testbean.class));	
			for(int i = 0;i<list.size();i++){
				System.out.println(list.get(i).toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
	}

	/* *
	 * 利用DBUtil进行update
	 * */
	@Test
	public void update(){
		String sql = "update testbean set bean_password = ?";
		DBUtil.setDataSource("Project_Test");
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource()); 
		Object params[] = {"123456"};
		try {
			System.out.println(qRunner.update(sql,params));
			qRunner.query("select * from testbean",new BeanListHandler<>(testbean.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* *
	 * Customer
	 * */
	@Test
	public void getCustomer(){
		String sql = "select * from customer;";
		Object params[] = {"罗雪"};
		QueryRunner qRunner = new QueryRunner(DBUtil.getDataSource());
		List<Customer> list = null; 
		try {
			list =  qRunner.query(sql,new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null){
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).toString());
			}
		}
	}
}


