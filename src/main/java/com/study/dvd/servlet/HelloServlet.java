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
	

	// tomcat이 doGet 메소드를 호출하는데, req, resp를 생성하여 호출함
	// req는 요청에 대한 모든 정보를 담고 있음
	// resp는 응답에 대한 모든 정보를 담고 있음
	// 주소창에 요청메세지를 넣어 보내는 것은 'Get' 요청
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// 클라이언트에게 응답될 데이터를 전달해줌
//		String name = "김준일";
//		
//		// default 값으로 한글 인코딩이 지원이 안되서 직접 세팅해주어야 함.
//		// 응답 전에 encoding 세팅을 해야함.
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
		// 파라미터는 무조건 문자열로 날라옴
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		// servlet -> jsp -> servlet
		
		System.out.println(name);
		System.out.println(age);
		
		req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
	}
}
