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
//		String url = request2.getRequestURI(); //获取URI
//		if(url.length()<22){//如果长度都不足22，则通过
//			chain.doFilter(request, response);
//			return;
//		}
//		if (url.substring(0, 21).equalsIgnoreCase("/MedicineMS/MedicineMS")) {
//			try {
//				Staff staff = (Staff) request2.getSession().getAttribute("Staff");
//				String login_status = (String) request2.getSession().getAttribute("login_status");
//				// 如果用户存在且登录状态为OK
//				if (staff != null && login_status.endsWith("OK")) {
//					chain.doFilter(request, response);
//					return;
//				} else {
//					request2.getSession().setAttribute("login_message", "温馨提示：请重新登录.");
//					response2.sendRedirect(request2.getContextPath() + "/login.jsp?error=yes");
//					return;
//				}
//			} catch (Exception e) {
//				request2.getSession().setAttribute(request2.getContextPath() + "login_message", "温馨提示：请重新登录.");
//				response2.sendRedirect(request2.getContextPath() + "/login.jsp?error=yes");
//				return;
//			}
//		}
//		else{
//			request2.getSession().setAttribute(request2.getContextPath() + "login_message", "温馨提示：请重新登录.[错误代号:004]");
//			response2.sendRedirect(request2.getContextPath() + "/login.jsp?error=yes004");//越权
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
