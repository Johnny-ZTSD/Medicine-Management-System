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
 * ������룺01X + 02X
 * */
public class MSaleService {
	/* ��ֵ */
	private static String cmpn = null;
	private static String batchNum = null;
	private static String medicineName = null;
	private static double salePrice = 0.00;
	private static int medicineAmount = 0;// ҩƷ��Ŀ
	private static double payAmountMoney = 0.00;// ֧�����
	private static String customerAccountNo = null;
	/* ����ֵ */
	private static String id = null;
	private static Date saleDate = null;
	/* VOʵ����Ҫ */
	private static double FactPayMoney = 0.00; // Ӧ�����
	/* sessionֵ */
	private static Staff staff = null; // ����Ա-ʵ��
	
	/*
	 * * ���û��������ۼ�¼��Ϣ
	 */
	private static MSaleRecord_FeedBack createMedicineSaleRecord_FeedBack() {
		// Ҫ���˿ͷ�����Ϣ
		MSaleRecord_FeedBack msfb = new MSaleRecord_FeedBack();
		msfb.setAmountPayable(FactPayMoney);// Ӧ�����
		msfb.setBatchNum(batchNum);
		msfb.setCmpn(cmpn);
		msfb.setCustomerAccountNo(customerAccountNo);
		msfb.setId(id);
		msfb.setMedicineName(medicineName);
		msfb.setOddChange(payAmountMoney-FactPayMoney);// ����
		msfb.setPayAmountMoney(payAmountMoney);
		msfb.setSaleDate(saleDate);
		msfb.setSaleNum(medicineAmount);
		msfb.setSalePrice(salePrice);
		msfb.setSalerId(staff.getAccountNo());
		msfb.setSalerName(staff.getRealName());
		return msfb;
	}

	
	public static boolean createMedicineSaleRecord(HttpServletRequest request, HttpServletResponse response) {
		String createMedicineSaleRecord_status = "010"; // Ĭ�ϣ��������׼�¼�ɹ�
		String createMedicineSaleRecord_message = "����ҩƷ���ۼ�¼�ɹ���";
		int isSuccess = -1; // Ĭ�ϣ��������ɹ�
		try {
			// ���λ�ȡ���Ĳ���ֵ
			cmpn = request.getParameter("cmpn").replaceAll(" ", "");// ȥ�����пո�
			batchNum = request.getParameter("batchNum").replaceAll(" ", "");// ȥ�����пո�
			medicineName = new String(request.getParameter("medicineName").getBytes("ISO-8859-1"), "UTF-8");

			// JOptionPane.showMessageDialog(null,
			// "medicineName:"+medicineName);//����

			salePrice = Double.parseDouble(request.getParameter("salePrice").replaceAll(" ", ""));
			medicineAmount = Integer.parseInt(request.getParameter("medicineAmount").replaceAll(" ", ""));
			payAmountMoney = Double.parseDouble(request.getParameter("payAmountMoney").replaceAll(" ", ""));// ֧�����
			
			customerAccountNo = request.getParameter("coustomerAccountName").replaceAll(" ", "");
			/* ��ȡ����ֵ */
			id = UUID.randomUUID().toString().replaceAll("-", "");
			saleDate = new Date();
			
			
			try {
				staff = (Staff) (request.getSession().getAttribute("staff"));
				
			} catch (Exception e) {
				createMedicineSaleRecord_status = "011";
				createMedicineSaleRecord_message = "��ܰ��ʾ���û���δ��¼������ʧ�ܣ�[������룺011]";
				System.out.println("**********[MSaleRecord:createMedicineSaleRecord]�û���δ��¼������ʧ�ܣ�[������룺011]**********");
				e.printStackTrace();
				// TODO: handle exception
			}

			/* �������ۼ�¼���� */
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

			/* �ж�֧������Ƿ�����Ӧ����� */
			FactPayMoney = msrcd.getSaleNum() * msrcd.getSalePrice();
			if (FactPayMoney > payAmountMoney) {// ������
				isSuccess = -12;
				createMedicineSaleRecord_status = "012";
				createMedicineSaleRecord_message = "��ܰ��ʾ������ʧ�ܣ�[֧�����С��Ӧ����� ��][������룺012]";
				System.out.println(
						"**********[MSaleRecord:createMedicineSaleRecord] [����ʧ�ܣ�֧�����С��Ӧ����� ��][������룺012]**********");
			} else {
				// �������֧������ִ�����ݿ�
				try {
//					JOptionPane.showMessageDialog(null,"�����������ۼ�¼��Ϣ��"+ msrcd.toString());//����
					isSuccess = MSaleRecordDao.createMedicineSaleRecord(msrcd);
					if(isSuccess==0){//���������¼�ɹ�������¹˿͵����ѽ��
						UserDao.addCustomerConsumpTotal(customerAccountNo, FactPayMoney);
					}
				} catch (Exception e) {
					createMedicineSaleRecord_status = "013";
					createMedicineSaleRecord_message = "��ܰ��ʾ��������¼�쳣[���ݿ�����쳣]��[������룺013]";
					System.out.println(
							"**********[MSaleRecord:createMedicineSaleRecord] ������¼�쳣[���ݿ�����쳣]��[������룺013]**********");
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			createMedicineSaleRecord_status = "014";
			createMedicineSaleRecord_message = "��ܰ��ʾ����������ȡ�쳣��[������룺014]";
			System.out.println("**********[MSaleRecord:createMedicineSaleRecord] ��������ȡ�쳣��[������룺014]**********");
			e.printStackTrace();
		}

		// �����������������н��

		if (isSuccess == 0) {// �����¼�����ɹ�
			// Ҫ���˿ͷ�����Ϣ
			MSaleRecord_FeedBack msfb = createMedicineSaleRecord_FeedBack();
			request.setAttribute("MSaleRecord_FeedBack", msfb);

			createMedicineSaleRecord_status = "010"; // һ��ҩƷ���ۼ�¼�����ɹ�
			String msg[] = { "<div><b>����ҩƷ���ۼ�¼�ɹ���<b></div>", "" };
			createMedicineSaleRecord_message = "����ҩƷ���ۼ�¼�ɹ���";
//			JOptionPane.showMessageDialog(null, "�������ۼ�¼�ɹ���");
			// response.getWriter().println();
//			 return true;
		
		} else {// ������¼ʧ��
			createMedicineSaleRecord_status = "015"; // �������쳣�����Ǵ���ҩƷ���ۼ�¼ʧ�ܡ����ܴ��ڲ���(Eg������)��ͻ����������ԭ��
			createMedicineSaleRecord_message = "<span style=\"color:red;\">��ܰ��ʾ������ʧ�ܣ�������¼ʧ��!</span><br>����ԭ��<br>&nbsp;&nbsp;&nbsp;&nbsp;1.��ҩ׼�ֺ���ϵͳ�в����ڣ�<br>&nbsp;&nbsp;&nbsp;&nbsp;2.�������κ����ҩ׼�ֺŲ�����<br>&nbsp;&nbsp;&nbsp;&nbsp;3.�˿��˻������ڣ�<br>&nbsp;&nbsp;&nbsp;&nbsp;4.֧�����С��Ӧ֧���Ľ�<br>&nbsp;&nbsp;&nbsp;&nbsp;5.�û���δ��¼<br>&nbsp;&nbsp;&nbsp;&nbsp;6.����ԭ��<br>";
			System.out.println(
					"**********[MSaleRecord:createMedicineSaleRecord] �������쳣�����Ǵ���ҩƷ���ۼ�¼ʧ�ܡ����ܴ��ڲ���(Eg������)��ͻ����������ԭ��[������룺015] **********");
			System.out.println((new Date().toString())
					+ "\n��ܰ��ʾ������ʧ�ܣ�������¼ʧ��!\n����ԭ��\n  1.��ҩ׼�ֺ���ϵͳ�в����ڣ�\n  2.�������κ����ҩ׼�ֺŲ�����\n  3.�˿��˻������ڣ�\n  4.֧�����С��Ӧ֧���Ľ�\n  5.�û���δ��¼\n  6.����ԭ��");
		}
		// ���������Ĵ���
		//
		// װ����Ϣ��request��
		request.setAttribute("createMedicineSaleRecord_status", createMedicineSaleRecord_status);
		request.setAttribute("createMedicineSaleRecord_message", createMedicineSaleRecord_message);
		// ͳһת�����������ҳ��
		try {
			request.getRequestDispatcher("/MedicineMS/sell/MSaleRecord/add/Result_addMedicineSaleRecord.jsp").forward(request,
					response);
//			JOptionPane.showMessageDialog(null, "ת���ɹ� To �������....");
			return true;
		} catch (ServletException e) {
			try {
				response.getWriter().print("�𾴵��û����Բ��𣬷������ڲ����й���[������룺016]");// [Servlet
																			// Exception]//���û�͸��
				System.out.println("**********[MSaleRecord : createMedicineSaleRecord] �������ڲ����й���[ ������룺016 ][Servlet Exception] **********");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;
			e.printStackTrace();
		} catch (IOException e) {
			try {
				response.getWriter().print("�𾴵��û����Բ��𣬱��ν��׳ɹ������������ڲ����й��ϣ��޷�������ʾ[������룺017]");// [IO
																							// Exception��Out���ʧ��]���û�͸��
				System.out.println(
						"**********[MSaleRecord : createMedicineSaleRecord] ���׳ɹ������������ڲ����й���[ ������룺017][IO Exception��Out���ʧ��] **********");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		;

		// ����һ������ֵ���Ƿ����ݿ�����ɹ�
		if (isSuccess == 0) {
			return true;
		} else {
//			JOptionPane.showMessageDialog(null, "�������ۼ�¼ʧ�ܣ�");
			return false;
		}

	}


	/*�������ۼ�¼*/
	/*װ�ص�request�У�Ȼ��ת��*/
	/*����boolean��Ŀǰ��ʵ������*/
	public static boolean search_MSaleRecord(HttpServletRequest request, HttpServletResponse response){
		
		try {
			List<MSaleRecord> list = MSaleRecordDao.findAll();
//			JOptionPane.showMessageDialog(null, "���ۼ�¼����[1]����"+list.get(0).toString());
			request.setAttribute("MedicineSaleRecord_List", list);
			request.getSession().setAttribute("search_MSaleRecord_message", "��ܰ��ʾ����ѯ���ۼ�¼�ɹ�.");
			try {//�ض���Ŀ��ҳ��
//				JOptionPane.showMessageDialog(null, "׼��ת����");
				try {
					request.getRequestDispatcher("/MedicineMS/sell/MSaleRecord/search/search_MsaleRecord.jsp").forward(request, response);
				} catch (ServletException e) {
					System.out.println("**********[MSaleRecord:createMedicineSaleRecord] ת��Ŀ��ҳ��ʧ��  [������룺021]");
					e.printStackTrace();
				} 
//				JOptionPane.showMessageDialog(null, "�Ѿ�ת����"+request.getRequestURL());	 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} catch (SQLException e) {
			request.setAttribute("search_MSaleRecord_message", "<b style=\"color:red;\">�𾴵��û���</b>�������ڲ����ϣ����Ժ����Ա�����.[������룺022]");
			System.out.println("**********[MSaleRecord:createMedicineSaleRecord] ���ݿ��ѯҩƷ���ۼ�¼�����쳣  [������룺022]");
			e.printStackTrace();
			return false;
		}
		
	}
	
}
