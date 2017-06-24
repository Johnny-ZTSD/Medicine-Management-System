package com.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.dao.MSaleRecordDao;
import com.entity.MSaleRecord;
import com.entity.Staff;
import com.service.MSaleService;
import com.util.HashUtil;

/**
 * Servlet implementation class createMedicineSaleRecordService
 */
public class createMedicineSaleRecordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createMedicineSaleRecordAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("**********[action.createMedicineSaleRecord:doPost] 行为定位成功 **********");
//		JOptionPane.showMessageDialog(null, "**********[action.createMedicineSaleRecord:doPost] 行为定位成功 **********");
//		System.out.println("request.ServletPath:"+request.getServletPath());
//断点调试JOptionPane.showMessageDialog(null, "request.ServletPath:"+request.getServletPath());
		MSaleService.createMedicineSaleRecord(request, response);
		return;
	}

}
