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

	/* 주소창에 데이터가 노출되면 안 되는 경우 'post'요청을 사용한다 */
	/* 로그인 회원가입 등 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET 요청 들어옴!!!");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// checkbox를 여러개 받으려면 배열 형태로 받아올 수 있어야 함.
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
		resp.getWriter().println("응답데이터입니다.");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 요청 들어옴!!!");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// checkbox를 여러개 받으려면 배열 형태로 받아올 수 있어야 함.
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
