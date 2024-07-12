package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* �ּ�â�� �����Ͱ� ����Ǹ� �� �Ǵ� ��� 'post'��û�� ����Ѵ� */
	/* �α��� ȸ������ �� */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET ��û ����!!!");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// checkbox�� ������ �������� �迭 ���·� �޾ƿ� �� �־�� ��.
		String[] chks = req.getParameterValues("chk");
		String rdo = req.getParameter("rdo");
		System.out.println(username);
		System.out.println(password);
		for(String chk : chks) {
			System.out.println(chk);
		}
		System.out.println(rdo);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("���䵥�����Դϴ�.");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST ��û ����!!!");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// checkbox�� ������ �������� �迭 ���·� �޾ƿ� �� �־�� ��.
		String[] chks = req.getParameterValues("chk");
		String rdo = req.getParameter("rdo");
		System.out.println(username);
		System.out.println(password);
		for(String chk : chks) {
			System.out.println(chk);
		}
		System.out.println(rdo);
	}
}
