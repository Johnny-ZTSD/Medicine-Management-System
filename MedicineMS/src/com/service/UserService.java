package com.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import javax.swing.JOptionPane;

import com.dao.RegisterDao;
import com.dao.UserDao;
import com.entity.Customer;
import com.entity.Staff;

import jdk.nashorn.internal.ir.Flags;
/* *
 * ������룺00X��staff_login
 * ������룺06X:staff_logout
 * ������룺05X:registerService
 * ������룺10X:search_Staff
 * ������룺11X��search_Customer
 * */
public class UserService {

	private static Staff staff = null;
	private static Customer customer = null;

	//�û���¼
	public static Staff staff_login(HttpServletRequest request,HttpServletResponse response){
		String accountNo = null;
		String password = null;
		String login_message = "��ܰ��ʾ����¼ʧ��[������룺δ֪]";
		String login_status = "NO";
		String url = "/login.jsp?error=yes"; //��ʼ����¼��Ŀ��ҳ��
		try{
			accountNo = request.getParameter("accountNo");
			password = request.getParameter("password");
		}catch(Exception e){
			login_message = "��ܰ��ʾ����¼ʧ�ܣ��벻Ҫ�������ϵͳ��Ϣ�ͳ���[������룺001]";
			login_status = "NO";
			System.out.println("**********[UserService:staff_login] ��¼����ȡ����ʧ�ܣ�����[������룺001] **********");
			e.printStackTrace();
		}
		//�����ȡ�����ɹ������ݿ��ѯ�û�
		if (accountNo!=null&&password!=null) {
			String sql = "select staf_accountId_PK as accountName,staf_password as password,staf_userType as userType,staf_realName as realName,staf_sex as sex,staf_accountState as accountState,staf_telephone as telephone from staff where staf_accountId_PK = ? and staf_password = ?";
			Object params[] = {accountNo,password};
			Staff staff = null;
			
			try {
				staff = UserDao.findStaffByConditions(sql, params);
			} catch (SQLException e) {
				login_message = "�𾴵��û����Բ��𣬷����������ڲ��쳣����ʱֹͣ��¼����.[������룺002]";
				login_status = "NO";
				System.out.println("**********[UserService:staff_login] ���ݿ��ѯ�û������쳣[������룺002] **********");
				e.printStackTrace();
			}
			if(staff!=null){
				//���ݿ��ѯ��Ľ�������Ὣ��ѯ���������Գ�ʼ�������׺��ԡ�
				staff.setAccountNo(accountNo);
				staff.setPassword(password);
				
				//�ж��û�����
				if(staff.getUserType()==2){//ӪҵԱ
					url = "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp";
				}else if(staff.getUserType()==1){  //����Ա
					url = "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp";
				}else if(staff.getUserType()==3){//����Ա
					url = "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp";
				}else if(staff.getUserType()==4){//�ɹ�Ա
					url = "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp";
				}
				//װ���û���Ϣ��session��
				request.getSession().setAttribute("staff", staff);
				request.getSession().setAttribute("login_message", "�û�����.");
				request.getSession().setAttribute("login_status", "OK"); //��֮Ϊ��NO
				//ת����Ŀ��ҳ��
				try {
					//������������������ʱ��ת���û���¼ҳ��
					//����̨��ӡ���û���Ϣ
					System.out.println("********** ��½�ɹ� **********");
					System.out.println("�û���Ϣ��"+staff.toString());
					//ת���������������У��ͻ��˵�Ŀ��URLû�иı�
//					request.getRequestDispatcher(url).forward(request, response);
					
					//�ض��򣺿ͻ�����Ϊ���ͻ��˵�Ŀ��URL�ı�
					//   �ң����¿�ʼ������Ǿ���·����Ҫ����Ŀ������·����
					url = request.getContextPath()+url;
//					JOptionPane.showMessageDialog(null, "�ض����¼ҳ����...��");//test
					response.sendRedirect(url);
//					JOptionPane.showMessageDialog(null, "�ض����¼ҳ��ɹ���");//test
					return staff; //���ظ����ò��û���Ϣ
				} catch (Exception e) {
					//װ�ص�¼��Ϣ��session��
					login_message = "��ܰ��ʾ���������ڲ����ϣ���¼ʧ��[������룺003]";
					login_status =  "NO"; //��֮Ϊ��OK
					System.out.println("**********[UserService:staff_login] ��¼ת��ʧ��[������룺003]**********");
				}
			}else{//���ݿ���û�в鵽���û�
				//���õ�¼ʧ�ܵ���Ϣ�����session
				login_message  = "��ܰ��ʾ���û��˺Ų����ڻ����������[������룺004]";
				login_status =  "NO"; //��֮Ϊ��NO
				System.out.println("**********[UserService:staff_login] �û��˻������ڻ���������󣬵�¼ʧ��[������룺004] **********");
			}
		}
		
		//û�гɹ�ת����Ŀ���¼ҳ��ʱ��װ�ص�¼ʧ�ܵ���Ϣ
		request.getSession().setAttribute("login_message", login_message);
		request.getSession().setAttribute("login_status", login_status);
		//ת����¼��ʼ����
		try {
			response.sendRedirect(request.getContextPath()+"/login.jsp?error=yes");
		} catch (Exception e) {
			System.out.println("**********[UserService:staff_login] ��¼ʧ��[������룺δ֪��] **********");
			e.printStackTrace();
		}
		return null;
	}
	
	//�û��˳�
	public static boolean staff_logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().setAttribute("login_message", "��ܰ��ʾ���˳��ɹ�...");
		request.getSession().setAttribute("login_status", "NO");
		request.getSession().invalidate();
		
		try {
			response.sendRedirect("/login.jsp?error=no");
			return true;
		} catch (IOException e) {
			request.getSession().setAttribute("login_message", "��ܰ��ʾ���������ڲ����ϣ��˳�ʧ��.[������룺061]");
			System.out.println("**********[UserService:staff_logout] �û��˳�ʧ�� [������룺061]**********");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean  updateStaffInfo(HttpServletRequest request,HttpServletResponse response){
		
		boolean flag = false;
		
		try {
//			String op = new String(request.getParameter("op").getBytes("ISO-8859-1"),"UTF-8");
					Staff staff = (Staff)request.getSession().getAttribute("staff");
					String staff_id = staff.getAccountNo();
					if(staff.getUserType()!=1){//������Ա������
						//��ȡ����Ϣ
						String password = new String(request.getParameter("ipt_pswd").getBytes("ISO-8859-1"),"UTF-8");
						String realName = new String(request.getParameter("ipt_realName").getBytes("ISO-8859-1"),"UTF-8");
						String sex = new String(request.getParameter("ipt_sex").getBytes("ISO-8859-1"),"UTF-8");
						String phone = new String(request.getParameter("ipt_phone").getBytes("ISO-8859-1"),"UTF-8");
						
						if(password.length()<1)//����û�û��������������
							password = staff.getPassword(); 
						if(realName.length()<1)
							realName = staff.getRealName();
						if(sex.length()<1)
							sex = staff.getSex();
						if(phone.length()<1)
							phone = staff.getTelephone();
						
						
						
						//���ݿ�ִ��
						String sql = "update staff set staf_password = ?,staf_realName = ?,staf_sex = ?,staf_telephone = ? where staf_accountId_PK = ?";
						Object params[] = {password,realName,sex,phone,staff_id};
						try {
							flag = UserDao.update(sql, params)>0?true:false;
							if(flag){//������ݿ���³ɹ���
								//����session staff�˻�����
								staff.setPassword(password);
								staff.setRealName(realName);
								staff.setSex(sex);
								staff.setTelephone(phone);
								request.getSession().setAttribute("staff", staff);
							}
						} catch (SQLException e) {
							System.out.println("**********[UserService:updateStaffInfo][������룺091 ���ݿ�ִ�д���]**********");
							
							e.printStackTrace();
						}
						
					}
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[UserService:updateStaffInfo][������룺092 ��������ȡʧ�ܣ�]**********");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public  static boolean register_apply_Service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		try {
			String email = new String(request.getParameter("reg_email").getBytes("ISO-8859-1"),"UTF-8");
			String realName = new String(request.getParameter("reg_realName").getBytes("ISO-8859-1"),"UTF-8");
			String phone = new String(request.getParameter("reg_telephone").getBytes("ISO-8859-1"),"UTF-8");
			
//			JOptionPane.showMessageDialog(null, "email:"+email+"|realName:"+realName+"|phone:"+phone);//test
			
			if(email.length()>4&&realName.length()>1&&phone.length()>5){//������ȷ��Ϲ��
				String sql = "insert into register values(?,?,?,?,?,?);";  
				Object params[] ={UUID.randomUUID().toString().replaceAll("-", ""),email,realName,phone,"000","/"};//"000":δ����, "/":��û�д����˺�
				boolean Flag = RegisterDao.update(sql, params)==0?false:true;
//				boolean Flag = true;
				if(Flag){//�������ɹ�
					String url = request.getContextPath()+"/MedicineMS/user/reg/register.html";
					response.setHeader("Refresh", "5;url="+url);//5s��ˢ�µ���¼����
					
					response.sendRedirect(request.getContextPath()+"/MedicineMS/user/reg/register_success.html");//��Ӧ��������ɹ�����
					
				}else{//����ʧ��
					response.sendRedirect(request.getContextPath()+"/MedicineMS/user/reg/register_fail.html");
				}
			}else{
				try {
					response.sendRedirect(request.getContextPath()+"/MedicineMS/user/reg/register_fail.html");
				} catch (IOException e) {
					
					e.printStackTrace();
				}//����ת����ע��ҳ��
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[UserService:registerService][��ȡע����Ϣʧ�ܣ�������룺051]**********");
			try {
				response.sendRedirect(request.getContextPath()+"/MedicineMS/user/reg/register_fail.html");//����ת����ע��ҳ��
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		return false;
	}   
	
	public static boolean search_Staff(HttpServletRequest request,HttpServletResponse response){
		List<Staff> list = null;
		try {
			list = UserDao.findAllStaff();//��ѯ����Ա��
//			JOptionPane.showMessageDialog(null, list.get(0).getUserType());//test
		} catch (SQLException e) {
			System.out.println("**********[UserService:search_Staff][������룺101 ���ݿ��ȡԱ����Ϣʧ�ܣ�]**********");
			e.printStackTrace();
		}	
		request.setAttribute("Staff_List", list);
		//ת��
		try {
			request.getRequestDispatcher("/MedicineMS/user/staff/index_STAFadmin.jsp").forward(request, response);
			return true;
		} catch (ServletException e) {
			System.out.println("**********[UserService:search_Staff][������룺102 request֮Servelt�쳣��]**********");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("**********[UserService:search_Staff][������룺103 IO�쳣��]**********");
			e.printStackTrace();
		}
		//���û��ת���ɹ�
		try {
			response.sendRedirect(request.getContextPath()+"/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp");
		} catch (IOException e) {
			System.out.println("**********[UserService:search_Staff][������룺104 �ض����쳣��]**********");
			e.printStackTrace();
		}
		return false;
	}	
	
	public static boolean search_Customer(HttpServletRequest request,HttpServletResponse response){
		List<Customer> list = null;
		try {
			list = UserDao.findAllCustomer();//��ѯ���й˿�
//			JOptionPane.showMessageDialog(null, list.get(0).getUserType());//test
		} catch (SQLException e) {
			System.out.println("**********[search_Customer][������룺111 ���ݿ��ȡ�˿���Ϣʧ�ܣ�]**********");
			e.printStackTrace();
		}	
		request.setAttribute("Customer_List", list);
		//ת��
		try {
			request.getRequestDispatcher("/MedicineMS/user/customer/index_CUSTadmin.jsp").forward(request, response);
			return true;
		} catch (ServletException e) {
			System.out.println("**********[UserService:search_Customer][������룺112 request֮Servelt�쳣��]**********");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("**********[UserService:search_Customer][������룺113 IO�쳣��]**********");
			e.printStackTrace();
		}
		//���û��ת���ɹ�
		try {
			response.sendRedirect(request.getContextPath()+"/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp");
		} catch (IOException e) {
			System.out.println("**********[UserService:search_Customer][������룺114 �ض����쳣��]**********");
			e.printStackTrace();
		}
		return false;
	}	
	
}
