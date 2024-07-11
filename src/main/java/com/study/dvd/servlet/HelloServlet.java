package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	// tomcat�� doGet �޼ҵ带 ȣ���ϴµ�, req, resp�� �����Ͽ� ȣ����
	// req�� ��û�� ���� ��� ������ ��� ����
	// resp�� ���信 ���� ��� ������ ��� ����
	// �ּ�â�� ��û�޼����� �־� ������ ���� 'Get' ��û
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// Ŭ���̾�Ʈ���� ����� �����͸� ��������
//		String name = "������";
//		
//		// default ������ �ѱ� ���ڵ��� ������ �ȵǼ� ���� �������־�� ��.
//		// ���� ���� encoding ������ �ؾ���.
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("utf-8");
//		
//		resp.getWriter().println(""
//				+ "<html>"
//				+ "<header>"
//				+ "<title> hello </title>"
//				+ "<body>"
//				+ "<h1>Hello Servlet!!!</h1>"
//				+ "<h2>" + name + "</h2>"
//				+ "</body>"
//				+ "</html>");
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �Ķ���ʹ� ������ ���ڿ��� �����
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		// servlet -> jsp -> servlet
		
		System.out.println(name);
		System.out.println(age);
		
		req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
	}
}
