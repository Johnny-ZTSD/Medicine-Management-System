package com.util;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class WelcomeUser extends TagSupport {
	private String name;// �����Ӧ��ǩ������
	/**
	 * ͨ��set������ҳ����name������ֵ
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ����doEndTag����
	 */
	public int doEndTag() throws JspException {
		try {
			// ͨ��pageContext�������������������out����ͻ���������
			pageContext.getOut().println("Welcome " + name);
		} catch (IOException e) {
			e.printStackTrace();
			new JspException("IO Error" + e.getMessage());
		}
		return EVAL_PAGE;
	}
}
