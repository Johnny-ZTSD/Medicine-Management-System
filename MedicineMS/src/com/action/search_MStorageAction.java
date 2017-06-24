package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.dao.MSaleRecordDao;
import com.service.MStorageService;

/**
 * Servlet implementation class search_MStorageAction
 */
public class search_MStorageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search_MStorageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ͨ����������������[get]
		try{
			String search_statement = new String (request.getParameter("q").getBytes("ISO-8859-1"),"UTF-8");//��Ҫת��
//			JOptionPane.showMessageDialog(null, "serach_statement:"+search_statement);
			if(search_statement.length()<1){//����С��1
				MStorageService.search_MSaleStorage(request, response,null, null);	
			}else{ //���Ȳ�С��1[�������]
				MStorageService.search_MSaleStorage(request, response,new String[]{search_statement},null);
				
			}
		}catch(Exception e){//����û�гɹ���ȡ�����������ò�ѯȫ�����ķ�ʽ[��ͨ������ѯ]
			System.out.println("**********[search_MStorageAction:doGet ��ʾ���룺031 û�гɹ���ȡ����ѯ����]");
			MStorageService.search_MSaleStorage(request, response,null, null);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ϲ���������
		
		doGet(request, response);
	}

}
