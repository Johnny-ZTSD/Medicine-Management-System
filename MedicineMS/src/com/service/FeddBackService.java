package com.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeedBackDao;
import com.entity.FeedBack;


/* *
 * 错误代码： 07X:add 
 * 错误代码：08X:update
 * 错误代码：09X:findUnRead
 * */
public class FeddBackService {
	
	public static boolean add(HttpServletRequest request,HttpServletResponse response) {
		boolean flag = false;
		try {
			//获取表单信息
			String email = new String(request.getParameter("fb_email").getBytes("ISO-8859-1"),"UTF-8");
			String realName = new String(request.getParameter("fb_realName").getBytes("ISO-8859-1"),"UTF-8");
			String phone = new String(request.getParameter("fb_telephone").getBytes("ISO-8859-1"),"UTF-8");
			String message = new String(request.getParameter("fb_message").getBytes("ISO-8859-1"),"UTF-8");
			

			//补充其他必要的信息
			Date sendDate = new Date();
			String id = UUID.randomUUID().toString().replaceAll("-", ""); 
			String readState = "000"; //阅读状态
			try {
				flag = FeedBackDao.add(new FeedBack(id, email, realName, phone, message, readState, sendDate))>0?true:false;
			} catch (SQLException e1) {
				System.out.println("**********[FeddBackService:add][错误代码：071数据库执行失败！]**********");
				e1.printStackTrace();
				
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[FeddBackService:add][错误代码：072 获取表单信息失败！]**********");
			e.printStackTrace();
		}
	
		return flag;//传递信息交给上一层做
	}
	
	//根据id更改反馈状态
	public static boolean update(HttpServletRequest request,HttpServletResponse response){
		boolean flag = false;
		//获取表单信息
		try {
			//获取表单中信息
			String id 		= 	new String(request.getParameter("fb_id").getBytes("ISO-8859-1"),"UTF-8");
			String email 	=  	new String(request.getParameter("fb_email").getBytes("ISO-8859-1"),"UTF-8");
			String realName = 	new String(request.getParameter("fb_realName").getBytes("ISO-8859-1"),"UTF-8");
			String phone 	= 	new String(request.getParameter("fb_telephone").getBytes("ISO-8859-1"),"UTF-8");
			String message 	= 	new String(request.getParameter("fb_message").getBytes("ISO-8859-1"),"UTF-8");
			String readState =  new String(request.getParameter("fb_readState").getBytes("ISO-8859-1"),"UTF-8");
//			String sendDate =   new String(request.getParameter("fb_sendDate").getBytes("ISO-8859-1"),"UTF-8");//时间不可更改
			
			FeedBack fBack = new FeedBack(id, email, realName, phone, message, readState);//发送时间不可更改
			try {
				flag = FeedBackDao.update(fBack)>0?true:false;
			} catch (SQLException e) {
				System.out.println("**********[FeddBackService:add][错误代码：081数据库执行失败！]**********");
				e.printStackTrace();
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[FeddBackService:add][错误代码：082 获取表单信息失败！]**********");
			e.printStackTrace();
		}
		

		//转发
		try {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
//			response.setHeader("", "");
		} catch (ServletException | IOException e) {
			System.out.println("**********[FeddBackService:add][错误代码：083 转发失败！]**********");
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static boolean findUnRead(HttpServletRequest request,HttpServletResponse response){
		String sql  ="select fdbc_id_PK as id,fdbc_email as email,fdbc_realName as realName,fdbc_telephone as phone,fdbc_message as message,fdbc_readState as readState,fdbc_sendDate as sendDate from FeedBack where fdbc_readState='000'";
		
		try {
			//数据库查询未读记录
			List<FeedBack> list = FeedBackDao.findByConditions(sql, new Object[]{});
			//装载
			
		} catch (SQLException e) {
			System.out.println("**********[FeddBackService:add][错误代码：091 获取表单信息失败！]**********");
			e.printStackTrace();
		}
		
		return false;
	}
	
}
