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
 * ������룺 07X:add 
 * ������룺08X:update
 * ������룺09X:findUnRead
 * */
public class FeddBackService {
	
	public static boolean add(HttpServletRequest request,HttpServletResponse response) {
		boolean flag = false;
		try {
			//��ȡ����Ϣ
			String email = new String(request.getParameter("fb_email").getBytes("ISO-8859-1"),"UTF-8");
			String realName = new String(request.getParameter("fb_realName").getBytes("ISO-8859-1"),"UTF-8");
			String phone = new String(request.getParameter("fb_telephone").getBytes("ISO-8859-1"),"UTF-8");
			String message = new String(request.getParameter("fb_message").getBytes("ISO-8859-1"),"UTF-8");
			

			//����������Ҫ����Ϣ
			Date sendDate = new Date();
			String id = UUID.randomUUID().toString().replaceAll("-", ""); 
			String readState = "000"; //�Ķ�״̬
			try {
				flag = FeedBackDao.add(new FeedBack(id, email, realName, phone, message, readState, sendDate))>0?true:false;
			} catch (SQLException e1) {
				System.out.println("**********[FeddBackService:add][������룺071���ݿ�ִ��ʧ�ܣ�]**********");
				e1.printStackTrace();
				
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[FeddBackService:add][������룺072 ��ȡ����Ϣʧ�ܣ�]**********");
			e.printStackTrace();
		}
	
		return flag;//������Ϣ������һ����
	}
	
	//����id���ķ���״̬
	public static boolean update(HttpServletRequest request,HttpServletResponse response){
		boolean flag = false;
		//��ȡ����Ϣ
		try {
			//��ȡ������Ϣ
			String id 		= 	new String(request.getParameter("fb_id").getBytes("ISO-8859-1"),"UTF-8");
			String email 	=  	new String(request.getParameter("fb_email").getBytes("ISO-8859-1"),"UTF-8");
			String realName = 	new String(request.getParameter("fb_realName").getBytes("ISO-8859-1"),"UTF-8");
			String phone 	= 	new String(request.getParameter("fb_telephone").getBytes("ISO-8859-1"),"UTF-8");
			String message 	= 	new String(request.getParameter("fb_message").getBytes("ISO-8859-1"),"UTF-8");
			String readState =  new String(request.getParameter("fb_readState").getBytes("ISO-8859-1"),"UTF-8");
//			String sendDate =   new String(request.getParameter("fb_sendDate").getBytes("ISO-8859-1"),"UTF-8");//ʱ�䲻�ɸ���
			
			FeedBack fBack = new FeedBack(id, email, realName, phone, message, readState);//����ʱ�䲻�ɸ���
			try {
				flag = FeedBackDao.update(fBack)>0?true:false;
			} catch (SQLException e) {
				System.out.println("**********[FeddBackService:add][������룺081���ݿ�ִ��ʧ�ܣ�]**********");
				e.printStackTrace();
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[FeddBackService:add][������룺082 ��ȡ����Ϣʧ�ܣ�]**********");
			e.printStackTrace();
		}
		

		//ת��
		try {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
//			response.setHeader("", "");
		} catch (ServletException | IOException e) {
			System.out.println("**********[FeddBackService:add][������룺083 ת��ʧ�ܣ�]**********");
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static boolean findUnRead(HttpServletRequest request,HttpServletResponse response){
		String sql  ="select fdbc_id_PK as id,fdbc_email as email,fdbc_realName as realName,fdbc_telephone as phone,fdbc_message as message,fdbc_readState as readState,fdbc_sendDate as sendDate from FeedBack where fdbc_readState='000'";
		
		try {
			//���ݿ��ѯδ����¼
			List<FeedBack> list = FeedBackDao.findByConditions(sql, new Object[]{});
			//װ��
			
		} catch (SQLException e) {
			System.out.println("**********[FeddBackService:add][������룺091 ��ȡ����Ϣʧ�ܣ�]**********");
			e.printStackTrace();
		}
		
		return false;
	}
	
}
