package com.action;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.entity.Staff;

/**
 * Servlet Filter implementation class PrivileageFilter
 */
public class PrivilegeFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public PrivilegeFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest request2 = (HttpServletRequest) request;
//		HttpServletResponse response2 = (HttpServletResponse) response;
//		String url = request2.getRequestURI(); //��ȡURI
//		if(url.length()<22){//������ȶ�����22����ͨ��
//			chain.doFilter(request, response);
//			return;
//		}
//		if (url.substring(0, 21).equalsIgnoreCase("/MedicineMS/MedicineMS")) {
//			try {
//				Staff staff = (Staff) request2.getSession().getAttribute("Staff");
//				String login_status = (String) request2.getSession().getAttribute("login_status");
//				// ����û������ҵ�¼״̬ΪOK
//				if (staff != null && login_status.endsWith("OK")) {
//					chain.doFilter(request, response);
//					return;
//				} else {
//					request2.getSession().setAttribute("login_message", "��ܰ��ʾ�������µ�¼.");
//					response2.sendRedirect(request2.getContextPath() + "/login.jsp?error=yes");
//					return;
//				}
//			} catch (Exception e) {
//				request2.getSession().setAttribute(request2.getContextPath() + "login_message", "��ܰ��ʾ�������µ�¼.");
//				response2.sendRedirect(request2.getContextPath() + "/login.jsp?error=yes");
//				return;
//			}
//		}
//		else{
//			request2.getSession().setAttribute(request2.getContextPath() + "login_message", "��ܰ��ʾ�������µ�¼.[�������:004]");
//			response2.sendRedirect(request2.getContextPath() + "/login.jsp?error=yes004");//ԽȨ
//			return;
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
