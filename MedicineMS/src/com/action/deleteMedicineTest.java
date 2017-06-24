package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.alibaba.fastjson.JSON;
import com.service.MedicineService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.test.testbean;

/**
 * Servlet implementation class deleteMedicineRecord
 */
public class deleteMedicineTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMedicineTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JOptionPane.showMessageDialog(null, "test1："+request.getParameter("test1")+"\ntest2:"+request.getParameter("test2"));
//		response.setCharacterEncoding("UTF-8");
//		String json_str = "{\"name\":\"fly\",\"type\":\"虫子\"}"; 
		String  json_str2 = JSON.toJSONString(new testbean());
		response.setContentType("text/plain;charset=UTF-8");
		
		if(MedicineService.deleteMedicineInfo(request, response))//如果删除成功
			response.getWriter().println(json_str2);
		else{
			response.getWriter().println(json_str2);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
