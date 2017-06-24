package com.util;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class WelcomeUser extends TagSupport {
	private String name;// 定义对应标签的属性
	/**
	 * 通过set方法从页面获得name的属性值
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 覆盖doEndTag方法
	 */
	public int doEndTag() throws JspException {
		try {
			// 通过pageContext对象获得隐含对象输出流out，向客户端输出结果
			pageContext.getOut().println("Welcome " + name);
		} catch (IOException e) {
			e.printStackTrace();
			new JspException("IO Error" + e.getMessage());
		}
		return EVAL_PAGE;
	}
}
