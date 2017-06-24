package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.entity.ViewObject.MsgObj_FeedBack;
import com.service.FeddBackService;

/**
 * Servlet implementation class FeedBack_createAction
 */
public class FeedBack_createAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBack_createAction() {
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
		if(FeddBackService.add(request, response)){//�����ӳɹ�
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("OK","��ܰ��ʾ���ύ�����ɹ�����ֿ�ظ�л�������ǵ�ÿһ�����ġ�")));
		}else{
			response.getWriter().println(JSON.toJSONString(new MsgObj_FeedBack("NO","��ܰ��ʾ�����ź���ϵͳ���ϣ��޷������ύ���ķ��������Ժ����ԡ�")));
		}
	}

}
