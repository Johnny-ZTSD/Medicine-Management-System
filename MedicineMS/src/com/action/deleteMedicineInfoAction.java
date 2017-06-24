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
//		JOptionPane.showMessageDialog(null, "test1��"+request.getParameter("test1")+"\ntest2:"+request.getParameter("test2"));
		//���ñ���
//		JOptionPane.showMessageDialog(null, "pk��"+request.getParameter("pk"));
		response.setContentType("text/plain;charset=UTF-8");
		
		if(MedicineService.deleteMedicineInfo(request, response))//���ɾ���ɹ�
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("OK","��ܰ��ʾ��ɾ���ɹ���")));
		else{
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("NO","����ܰ��ʾ��ɾ��ʧ�ܣ���\n[����ԭ�����£�]\n1.��ҩƷ��Ϣ�����ڡ�\n2.��ҩƷ��Ϣ�������������ݽ�����ϵ���޷�ɾ����\n���ɾ���������ϵͳ�ƻ���\n3.�û�δ��¼��\n4.Υ��������")));
		}
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
