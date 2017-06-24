package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.action.createMedicineSaleRecordAction;
import com.dao.MSaleRecordDao;
import com.dao.UserDao;
import com.entity.MSaleRecord;
import com.entity.Staff;
import com.entity.ViewObject.MSaleRecord_FeedBack;

/* *
 * 错误代码：01X + 02X
 * */
public class MSaleService {
	/* 表单值 */
	private static String cmpn = null;
	private static String batchNum = null;
	private static String medicineName = null;
	private static double salePrice = 0.00;
	private static int medicineAmount = 0;// 药品数目
	private static double payAmountMoney = 0.00;// 支付金额
	private static String customerAccountNo = null;
	/* 其他值 */
	private static String id = null;
	private static Date saleDate = null;
	/* VO实体需要 */
	private static double FactPayMoney = 0.00; // 应付金额
	/* session值 */
	private static Staff staff = null; // 销售员-实体
	
	/*
	 * * 给用户反馈销售记录信息
	 */
	private static MSaleRecord_FeedBack createMedicineSaleRecord_FeedBack() {
		// 要给顾客反馈信息
		MSaleRecord_FeedBack msfb = new MSaleRecord_FeedBack();
		msfb.setAmountPayable(FactPayMoney);// 应付金额
		msfb.setBatchNum(batchNum);
		msfb.setCmpn(cmpn);
		msfb.setCustomerAccountNo(customerAccountNo);
		msfb.setId(id);
		msfb.setMedicineName(medicineName);
		msfb.setOddChange(payAmountMoney-FactPayMoney);// 找零
		msfb.setPayAmountMoney(payAmountMoney);
		msfb.setSaleDate(saleDate);
		msfb.setSaleNum(medicineAmount);
		msfb.setSalePrice(salePrice);
		msfb.setSalerId(staff.getAccountNo());
		msfb.setSalerName(staff.getRealName());
		return msfb;
	}

	
	public static boolean createMedicineSaleRecord(HttpServletRequest request, HttpServletResponse response) {
		String createMedicineSaleRecord_status = "010"; // 默认：创建交易记录成功
		String createMedicineSaleRecord_message = "创建药品销售记录成功！";
		int isSuccess = -1; // 默认：创建不成功
		try {
			// 依次获取表单的参数值
			cmpn = request.getParameter("cmpn").replaceAll(" ", "");// 去掉所有空格
			batchNum = request.getParameter("batchNum").replaceAll(" ", "");// 去掉所有空格
			medicineName = new String(request.getParameter("medicineName").getBytes("ISO-8859-1"), "UTF-8");

			// JOptionPane.showMessageDialog(null,
			// "medicineName:"+medicineName);//测试

			salePrice = Double.parseDouble(request.getParameter("salePrice").replaceAll(" ", ""));
			medicineAmount = Integer.parseInt(request.getParameter("medicineAmount").replaceAll(" ", ""));
			payAmountMoney = Double.parseDouble(request.getParameter("payAmountMoney").replaceAll(" ", ""));// 支付金额
			
			customerAccountNo = request.getParameter("coustomerAccountName").replaceAll(" ", "");
			/* 获取其他值 */
			id = UUID.randomUUID().toString().replaceAll("-", "");
			saleDate = new Date();
			
			
			try {
				staff = (Staff) (request.getSession().getAttribute("staff"));
				
			} catch (Exception e) {
				createMedicineSaleRecord_status = "011";
				createMedicineSaleRecord_message = "温馨提示：用户尚未登录，交易失败！[错误代码：011]";
				System.out.println("**********[MSaleRecord:createMedicineSaleRecord]用户尚未登录，交易失败！[错误代码：011]**********");
				e.printStackTrace();
				// TODO: handle exception
			}

			/* 创建销售记录对象 */
			MSaleRecord msrcd = new MSaleRecord();
			msrcd.setBatchNum(batchNum);
			msrcd.setCmpn(cmpn);
			msrcd.setId(id);
			msrcd.setCustomerId(customerAccountNo);
			msrcd.setName(medicineName);
			msrcd.setSaleDate(saleDate);
			msrcd.setSaleNum(medicineAmount);
			msrcd.setSalePrice(salePrice);
			msrcd.setSalerId(staff.getAccountNo());

			/* 判断支付金额是否满足应付金额 */
			FactPayMoney = msrcd.getSaleNum() * msrcd.getSalePrice();
			if (FactPayMoney > payAmountMoney) {// 不满足
				isSuccess = -12;
				createMedicineSaleRecord_status = "012";
				createMedicineSaleRecord_message = "温馨提示：交易失败！[支付金额小于应付金额 ！][错误代码：012]";
				System.out.println(
						"**********[MSaleRecord:createMedicineSaleRecord] [交易失败：支付金额小于应付金额 ！][错误代码：012]**********");
			} else {
				// 如果满足支付金额，则执行数据库
				try {
//					JOptionPane.showMessageDialog(null,"待创建的销售记录信息："+ msrcd.toString());//测试
					isSuccess = MSaleRecordDao.createMedicineSaleRecord(msrcd);
					if(isSuccess==0){//如果创建记录成功，则更新顾客的消费金额
						UserDao.addCustomerConsumpTotal(customerAccountNo, FactPayMoney);
					}
				} catch (Exception e) {
					createMedicineSaleRecord_status = "013";
					createMedicineSaleRecord_message = "温馨提示：创建记录异常[数据库操作异常]！[错误代码：013]";
					System.out.println(
							"**********[MSaleRecord:createMedicineSaleRecord] 创建记录异常[数据库操作异常]！[错误代码：013]**********");
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			createMedicineSaleRecord_status = "014";
			createMedicineSaleRecord_message = "温馨提示：表单参数获取异常！[错误代码：014]";
			System.out.println("**********[MSaleRecord:createMedicineSaleRecord] 表单参数获取异常！[错误代码：014]**********");
			e.printStackTrace();
		}

		// 处理上述操作的所有结果

		if (isSuccess == 0) {// 如果记录创建成功
			// 要给顾客反馈信息
			MSaleRecord_FeedBack msfb = createMedicineSaleRecord_FeedBack();
			request.setAttribute("MSaleRecord_FeedBack", msfb);

			createMedicineSaleRecord_status = "010"; // 一条药品销售记录创建成功
			String msg[] = { "<div><b>创建药品销售记录成功！<b></div>", "" };
			createMedicineSaleRecord_message = "创建药品销售记录成功！";
//			JOptionPane.showMessageDialog(null, "创建销售记录成功！");
			// response.getWriter().println();
//			 return true;
		
		} else {// 创建记录失败
			createMedicineSaleRecord_status = "015"; // 无其他异常，但是创建药品销售记录失败【可能存在参数(Eg：主键)冲突，或者其他原因】
			createMedicineSaleRecord_message = "<span style=\"color:red;\">温馨提示：交易失败，创建记录失败!</span><br>可能原因：<br>&nbsp;&nbsp;&nbsp;&nbsp;1.国药准字号在系统中不存在；<br>&nbsp;&nbsp;&nbsp;&nbsp;2.生产批次号与国药准字号不符；<br>&nbsp;&nbsp;&nbsp;&nbsp;3.顾客账户不存在；<br>&nbsp;&nbsp;&nbsp;&nbsp;4.支付金额小于应支付的金额；<br>&nbsp;&nbsp;&nbsp;&nbsp;5.用户尚未登录<br>&nbsp;&nbsp;&nbsp;&nbsp;6.其他原因<br>";
			System.out.println(
					"**********[MSaleRecord:createMedicineSaleRecord] 无其他异常，但是创建药品销售记录失败【可能存在参数(Eg：主键)冲突，或者其他原因】[错误代码：015] **********");
			System.out.println((new Date().toString())
					+ "\n温馨提示：交易失败，创建记录失败!\n可能原因：\n  1.国药准字号在系统中不存在；\n  2.生产批次号与国药准字号不符；\n  3.顾客账户不存在；\n  4.支付金额小于应支付的金额；\n  5.用户尚未登录\n  6.其他原因");
		}
		// 其他操作的处理
		//
		// 装载信息到request中
		request.setAttribute("createMedicineSaleRecord_status", createMedicineSaleRecord_status);
		request.setAttribute("createMedicineSaleRecord_message", createMedicineSaleRecord_message);
		// 统一转发到结果处理页面
		try {
			request.getRequestDispatcher("/MedicineMS/sell/MSaleRecord/add/Result_addMedicineSaleRecord.jsp").forward(request,
					response);
//			JOptionPane.showMessageDialog(null, "转发成功 To 结果界面....");
			return true;
		} catch (ServletException e) {
			try {
				response.getWriter().print("尊敬的用户：对不起，服务器内部运行故障[错误代码：016]");// [Servlet
																			// Exception]//对用户透明
				System.out.println("**********[MSaleRecord : createMedicineSaleRecord] 服务器内部运行故障[ 错误代码：016 ][Servlet Exception] **********");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;
			e.printStackTrace();
		} catch (IOException e) {
			try {
				response.getWriter().print("尊敬的用户：对不起，本次交易成功，但服务器内部运行故障，无法正常显示[错误代码：017]");// [IO
																							// Exception：Out输出失败]对用户透明
				System.out.println(
						"**********[MSaleRecord : createMedicineSaleRecord] 交易成功，但服务器内部运行故障[ 错误代码：017][IO Exception：Out输出失败] **********");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		;

		// 返回一个操作值：是否数据库操作成功
		if (isSuccess == 0) {
			return true;
		} else {
//			JOptionPane.showMessageDialog(null, "创建销售记录失败！");
			return false;
		}

	}


	/*查找销售记录*/
	/*装载到request中，然后转发*/
	/*返回boolean：目前无实际意义*/
	public static boolean search_MSaleRecord(HttpServletRequest request, HttpServletResponse response){
		
		try {
			List<MSaleRecord> list = MSaleRecordDao.findAll();
//			JOptionPane.showMessageDialog(null, "销售记录数据[1]条："+list.get(0).toString());
			request.setAttribute("MedicineSaleRecord_List", list);
			request.getSession().setAttribute("search_MSaleRecord_message", "温馨提示：查询销售记录成功.");
			try {//重定向到目标页面
//				JOptionPane.showMessageDialog(null, "准备转发！");
				try {
					request.getRequestDispatcher("/MedicineMS/sell/MSaleRecord/search/search_MsaleRecord.jsp").forward(request, response);
				} catch (ServletException e) {
					System.out.println("**********[MSaleRecord:createMedicineSaleRecord] 转发目标页面失败  [错误代码：021]");
					e.printStackTrace();
				} 
//				JOptionPane.showMessageDialog(null, "已经转发！"+request.getRequestURL());	 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} catch (SQLException e) {
			request.setAttribute("search_MSaleRecord_message", "<b style=\"color:red;\">尊敬的用户：</b>服务器内部故障，请稍后再试本功能.[错误代码：022]");
			System.out.println("**********[MSaleRecord:createMedicineSaleRecord] 数据库查询药品销售记录出现异常  [错误代码：022]");
			e.printStackTrace();
			return false;
		}
		
	}
	
}
