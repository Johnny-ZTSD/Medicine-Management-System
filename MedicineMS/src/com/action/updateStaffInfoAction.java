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
		if(UserService.updateStaffInfo(request, response))//������³ɹ�
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("OK","��ܰ��ʾ����Ϣ���³ɹ���")));
		else{
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("NO","����ܰ��ʾ����Ϣ����ʧ�ܣ���\n[����ԭ�����£�]\n1.����ǰû�е�¼���������¼״̬��\n2.������Ϣû���޸�.\n3.����Ƿ���Ϣ.\n4.�������ڲ�����.")));
		}
	}

}
