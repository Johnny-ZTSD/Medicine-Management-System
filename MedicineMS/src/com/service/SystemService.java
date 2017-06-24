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
 * ������룺11X:FeedBack_ApplyAccountService
 * */
public class SystemService {
		
	public static boolean FeedBack_ApplyAccountService(HttpServletRequest request, HttpServletResponse response){
		List<FeedBack> list_fb = null;
		try {
			list_fb = FeedBackDao.findAll();
		
		} catch (SQLException e) {
			System.out.println("**********[SystemService:FeedBack_ApplyAccountService][������룺111 ��ѯ�û�������Ϣ�쳣��]**********");
			e.printStackTrace();
		} 
		List<Register> list_reg = RegisterDao.findAll();

		request.getSession().setAttribute("list_fb", list_fb);
		request.getSession().setAttribute("list_reg", list_reg);
		
		//ת��
		try {
			request.getRequestDispatcher("/MedicineMS/SYS/admin/FB_AT.jsp").forward(request, response);
			return true;
		} catch (ServletException e) {
			System.out.println("**********[SystemService:FeedBack_ApplyAccountService][������룺112 ת��֮Servlet�쳣��]**********");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("**********[SystemService:FeedBack_ApplyAccountService][������룺113 ת��֮IO�쳣��]**********");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
