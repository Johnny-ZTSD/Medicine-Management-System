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
		//通过侧栏搜索框搜索[get]
		try{
			String search_statement = new String (request.getParameter("q").getBytes("ISO-8859-1"),"UTF-8");//需要转码
//			JOptionPane.showMessageDialog(null, "serach_statement:"+search_statement);
			if(search_statement.length()<1){//长度小于1
				MStorageService.search_MSaleStorage(request, response,null, null);	
			}else{ //长度不小于1[正常情况]
				MStorageService.search_MSaleStorage(request, response,new String[]{search_statement},null);
				
			}
		}catch(Exception e){//假如没有成功获取到参数：采用查询全部库存的方式[普通方法查询]
			System.out.println("**********[search_MStorageAction:doGet 提示代码：031 没有成功获取到查询参数]");
			MStorageService.search_MSaleStorage(request, response,null, null);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拖过侧栏搜索
		
		doGet(request, response);
	}

}
