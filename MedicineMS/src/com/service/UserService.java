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
 * 错误代码：00X：staff_login
 * 错误代码：06X:staff_logout
 * 错误代码：05X:registerService
 * 错误代码：10X:search_Staff
 * 错误代码：11X：search_Customer
 * */
public class UserService {

	private static Staff staff = null;
	private static Customer customer = null;

	//用户登录
	public static Staff staff_login(HttpServletRequest request,HttpServletResponse response){
		String accountNo = null;
		String password = null;
		String login_message = "温馨提示：登录失败[错误代码：未知]";
		String login_status = "NO";
		String url = "/login.jsp?error=yes"; //初始化登录的目标页面
		try{
			accountNo = request.getParameter("accountNo");
			password = request.getParameter("password");
		}catch(Exception e){
			login_message = "温馨提示：登录失败，请不要随意更改系统信息和程序！[错误代码：001]";
			login_status = "NO";
			System.out.println("**********[UserService:staff_login] 登录表单获取参数失败！！！[错误代码：001] **********");
			e.printStackTrace();
		}
		//如果获取参数成功：数据库查询用户
		if (accountNo!=null&&password!=null) {
			String sql = "select staf_accountId_PK as accountName,staf_password as password,staf_userType as userType,staf_realName as realName,staf_sex as sex,staf_accountState as accountState,staf_telephone as telephone from staff where staf_accountId_PK = ? and staf_password = ?";
			Object params[] = {accountNo,password};
			Staff staff = null;
			
			try {
				staff = UserDao.findStaffByConditions(sql, params);
			} catch (SQLException e) {
				login_message = "尊敬的用户：对不起，服务器出现内部异常，暂时停止登录服务.[错误代码：002]";
				login_status = "NO";
				System.out.println("**********[UserService:staff_login] 数据库查询用户出现异常[错误代码：002] **********");
				e.printStackTrace();
			}
			if(staff!=null){
				//数据库查询后的结果，不会将查询条件的属性初始化【容易忽略】
				staff.setAccountNo(accountNo);
				staff.setPassword(password);
				
				//判断用户类型
				if(staff.getUserType()==2){//营业员
					url = "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp";
				}else if(staff.getUserType()==1){  //管理员
					url = "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp";
				}else if(staff.getUserType()==3){//保管员
					url = "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp";
				}else if(staff.getUserType()==4){//采购员
					url = "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp";
				}
				//装载用户信息到session中
				request.getSession().setAttribute("staff", staff);
				request.getSession().setAttribute("login_message", "用户在线.");
				request.getSession().setAttribute("login_status", "OK"); //反之为：NO
				//转发到目标页面
				try {
					//仅当所有条件均满足时，转发用户登录页面
					//控制台打印：用户信息
					System.out.println("********** 登陆成功 **********");
					System.out.println("用户信息："+staff.toString());
					//转发：服务器端运行，客户端的目标URL没有改变
//					request.getRequestDispatcher(url).forward(request, response);
					
					//重定向：客户端行为，客户端的目标URL改变
					//   且：重新开始（如果是绝对路径，要加项目上下文路径）
					url = request.getContextPath()+url;
//					JOptionPane.showMessageDialog(null, "重定向登录页面中...！");//test
					response.sendRedirect(url);
//					JOptionPane.showMessageDialog(null, "重定向登录页面成功！");//test
					return staff; //返回给调用层用户信息
				} catch (Exception e) {
					//装载登录信息到session中
					login_message = "温馨提示：服务器内部故障，登录失败[错误代码：003]";
					login_status =  "NO"; //反之为：OK
					System.out.println("**********[UserService:staff_login] 登录转发失败[错误代码：003]**********");
				}
			}else{//数据库中没有查到该用户
				//设置登录失败的信息，存放session
				login_message  = "温馨提示：用户账号不存在或者密码错误！[错误代码：004]";
				login_status =  "NO"; //反之为：NO
				System.out.println("**********[UserService:staff_login] 用户账户不存在或者密码错误，登录失败[错误代码：004] **********");
			}
		}
		
		//没有成功转发到目标登录页面时，装载登录失败的信息
		request.getSession().setAttribute("login_message", login_message);
		request.getSession().setAttribute("login_status", login_status);
		//转发登录初始界面
		try {
			response.sendRedirect(request.getContextPath()+"/login.jsp?error=yes");
		} catch (Exception e) {
			System.out.println("**********[UserService:staff_login] 登录失败[错误代码：未知！] **********");
			e.printStackTrace();
		}
		return null;
	}
	
	//用户退出
	public static boolean staff_logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().setAttribute("login_message", "温馨提示：退出成功...");
		request.getSession().setAttribute("login_status", "NO");
		request.getSession().invalidate();
		
		try {
			response.sendRedirect("/login.jsp?error=no");
			return true;
		} catch (IOException e) {
			request.getSession().setAttribute("login_message", "温馨提示：服务器内部故障，退出失败.[错误代码：061]");
			System.out.println("**********[UserService:staff_logout] 用户退出失败 [错误代码：061]**********");
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
					if(staff.getUserType()!=1){//假如是员工操作
						//获取表单信息
						String password = new String(request.getParameter("ipt_pswd").getBytes("ISO-8859-1"),"UTF-8");
						String realName = new String(request.getParameter("ipt_realName").getBytes("ISO-8859-1"),"UTF-8");
						String sex = new String(request.getParameter("ipt_sex").getBytes("ISO-8859-1"),"UTF-8");
						String phone = new String(request.getParameter("ipt_phone").getBytes("ISO-8859-1"),"UTF-8");
						
						if(password.length()<1)//如果用户没有输入密码数据
							password = staff.getPassword(); 
						if(realName.length()<1)
							realName = staff.getRealName();
						if(sex.length()<1)
							sex = staff.getSex();
						if(phone.length()<1)
							phone = staff.getTelephone();
						
						
						
						//数据库执行
						String sql = "update staff set staf_password = ?,staf_realName = ?,staf_sex = ?,staf_telephone = ? where staf_accountId_PK = ?";
						Object params[] = {password,realName,sex,phone,staff_id};
						try {
							flag = UserDao.update(sql, params)>0?true:false;
							if(flag){//如果数据库更新成功：
								//更新session staff账户数据
								staff.setPassword(password);
								staff.setRealName(realName);
								staff.setSex(sex);
								staff.setTelephone(phone);
								request.getSession().setAttribute("staff", staff);
							}
						} catch (SQLException e) {
							System.out.println("**********[UserService:updateStaffInfo][错误代码：091 数据库执行错误！]**********");
							
							e.printStackTrace();
						}
						
					}
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[UserService:updateStaffInfo][错误代码：092 表单参数获取失败！]**********");
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
			
			if(email.length()>4&&realName.length()>1&&phone.length()>5){//如果长度符合规格
				String sql = "insert into register values(?,?,?,?,?,?);";  
				Object params[] ={UUID.randomUUID().toString().replaceAll("-", ""),email,realName,phone,"000","/"};//"000":未处理, "/":还没有创建账号
				boolean Flag = RegisterDao.update(sql, params)==0?false:true;
//				boolean Flag = true;
				if(Flag){//如果申请成功
					String url = request.getContextPath()+"/MedicineMS/user/reg/register.html";
					response.setHeader("Refresh", "5;url="+url);//5s后刷新到登录界面
					
					response.sendRedirect(request.getContextPath()+"/MedicineMS/user/reg/register_success.html");//响应到：申请成功界面
					
				}else{//申请失败
					response.sendRedirect(request.getContextPath()+"/MedicineMS/user/reg/register_fail.html");
				}
			}else{
				try {
					response.sendRedirect(request.getContextPath()+"/MedicineMS/user/reg/register_fail.html");
				} catch (IOException e) {
					
					e.printStackTrace();
				}//重新转发到注册页面
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[UserService:registerService][获取注册信息失败！错误代码：051]**********");
			try {
				response.sendRedirect(request.getContextPath()+"/MedicineMS/user/reg/register_fail.html");//重新转发到注册页面
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
			list = UserDao.findAllStaff();//查询所有员工
//			JOptionPane.showMessageDialog(null, list.get(0).getUserType());//test
		} catch (SQLException e) {
			System.out.println("**********[UserService:search_Staff][错误代码：101 数据库获取员工信息失败！]**********");
			e.printStackTrace();
		}	
		request.setAttribute("Staff_List", list);
		//转发
		try {
			request.getRequestDispatcher("/MedicineMS/user/staff/index_STAFadmin.jsp").forward(request, response);
			return true;
		} catch (ServletException e) {
			System.out.println("**********[UserService:search_Staff][错误代码：102 request之Servelt异常！]**********");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("**********[UserService:search_Staff][错误代码：103 IO异常！]**********");
			e.printStackTrace();
		}
		//如果没有转发成功
		try {
			response.sendRedirect(request.getContextPath()+"/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp");
		} catch (IOException e) {
			System.out.println("**********[UserService:search_Staff][错误代码：104 重定向异常！]**********");
			e.printStackTrace();
		}
		return false;
	}	
	
	public static boolean search_Customer(HttpServletRequest request,HttpServletResponse response){
		List<Customer> list = null;
		try {
			list = UserDao.findAllCustomer();//查询所有顾客
//			JOptionPane.showMessageDialog(null, list.get(0).getUserType());//test
		} catch (SQLException e) {
			System.out.println("**********[search_Customer][错误代码：111 数据库获取顾客信息失败！]**********");
			e.printStackTrace();
		}	
		request.setAttribute("Customer_List", list);
		//转发
		try {
			request.getRequestDispatcher("/MedicineMS/user/customer/index_CUSTadmin.jsp").forward(request, response);
			return true;
		} catch (ServletException e) {
			System.out.println("**********[UserService:search_Customer][错误代码：112 request之Servelt异常！]**********");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("**********[UserService:search_Customer][错误代码：113 IO异常！]**********");
			e.printStackTrace();
		}
		//如果没有转发成功
		try {
			response.sendRedirect(request.getContextPath()+"/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp");
		} catch (IOException e) {
			System.out.println("**********[UserService:search_Customer][错误代码：114 重定向异常！]**********");
			e.printStackTrace();
		}
		return false;
	}	
	
}
