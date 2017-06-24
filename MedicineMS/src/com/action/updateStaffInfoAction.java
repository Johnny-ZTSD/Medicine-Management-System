package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.entity.ViewObject.MsgObj_FeedBack;
import com.service.MedicineService;
import com.service.UserService;

/**
 * Servlet implementation class updateStaffInfoAction
 */
public class updateStaffInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStaffInfoAction() {
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
		response.setContentType("text/plain;charset=UTF-8");
		if(UserService.updateStaffInfo(request, response))//如果更新成功
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("OK","温馨提示：信息更新成功！")));
		else{
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("NO","【温馨提示：信息更新失败！】\n[可能原因如下：]\n1.您当前没有登录或者脱离登录状态！\n2.您的信息没有修改.\n3.输入非法信息.\n4.服务器内部故障.")));
		}
	}

}
