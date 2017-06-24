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
//		JOptionPane.showMessageDialog(null, "updateMedicineInfoAction��λ�ɹ���doPost:update_cmpk��"+request.getParameter("update_cmpk"));
		response.setContentType("text/plain;charset=UTF-8");
		
		
		if(MedicineService.updateMedicineInfoService(request, response))//���ɾ���ɹ�
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("OK","��ܰ��ʾ�����³ɹ���")));
		else{
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("NO","����ܰ��ʾ������ʧ�ܣ���\n[����ԭ�����£�]\n1.ҩƷ��ҩ׼�ֺ��Ѿ����ڣ������ͻ��\n2.�û�δ��¼��\n3.�������ڲ�����\n4.Υ��������")));
		}
	}

}
