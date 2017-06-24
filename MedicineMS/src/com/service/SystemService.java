package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeedBackDao;
import com.dao.RegisterDao;
import com.entity.FeedBack;
import com.entity.Register;

/* *
 * 错误代码：11X:FeedBack_ApplyAccountService
 * */
public class SystemService {
		
	public static boolean FeedBack_ApplyAccountService(HttpServletRequest request, HttpServletResponse response){
		List<FeedBack> list_fb = null;
		try {
			list_fb = FeedBackDao.findAll();
		
		} catch (SQLException e) {
			System.out.println("**********[SystemService:FeedBack_ApplyAccountService][错误代码：111 查询用户反馈信息异常！]**********");
			e.printStackTrace();
		} 
		List<Register> list_reg = RegisterDao.findAll();

		request.getSession().setAttribute("list_fb", list_fb);
		request.getSession().setAttribute("list_reg", list_reg);
		
		//转发
		try {
			request.getRequestDispatcher("/MedicineMS/SYS/admin/FB_AT.jsp").forward(request, response);
			return true;
		} catch (ServletException e) {
			System.out.println("**********[SystemService:FeedBack_ApplyAccountService][错误代码：112 转发之Servlet异常！]**********");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("**********[SystemService:FeedBack_ApplyAccountService][错误代码：113 转发之IO异常！]**********");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
