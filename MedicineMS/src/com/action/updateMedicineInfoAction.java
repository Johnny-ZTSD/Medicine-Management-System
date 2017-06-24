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

/**
 * Servlet implementation class updateMedicineInfoAction
 */
public class updateMedicineInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMedicineInfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		JOptionPane.showMessageDialog(null, "updateMedicineInfoAction定位成功：doPost:update_cmpk："+request.getParameter("update_cmpk"));
		response.setContentType("text/plain;charset=UTF-8");
		
		
		if(MedicineService.updateMedicineInfoService(request, response))//如果删除成功
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("OK","温馨提示：更新成功！")));
		else{
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("NO","【温馨提示：更新失败！】\n[可能原因如下：]\n1.药品国药准字号已经存在，引起冲突。\n2.用户未登录。\n3.服务器内部错误。\n4.违法操作。")));
		}
	}

}
