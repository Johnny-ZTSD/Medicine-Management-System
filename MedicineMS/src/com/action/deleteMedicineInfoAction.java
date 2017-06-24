package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.alibaba.fastjson.JSON;
import com.entity.ViewObject.MsgObj_FeedBack;
import com.service.MedicineService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.test.testbean;

/**
 * Servlet implementation class deleteMedicineRecord
 */
public class deleteMedicineInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMedicineInfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		JOptionPane.showMessageDialog(null, "test1："+request.getParameter("test1")+"\ntest2:"+request.getParameter("test2"));
		//设置编码
//		JOptionPane.showMessageDialog(null, "pk："+request.getParameter("pk"));
		response.setContentType("text/plain;charset=UTF-8");
		
		if(MedicineService.deleteMedicineInfo(request, response))//如果删除成功
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("OK","温馨提示：删除成功！")));
		else{
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("NO","【温馨提示：删除失败！】\n[可能原因如下：]\n1.该药品信息不存在。\n2.该药品信息存在于其他数据紧密联系，无法删除。\n如果删除，会造成系统破坏！\n3.用户未登录。\n4.违法操作。")));
		}
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
