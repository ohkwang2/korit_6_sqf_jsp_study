package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/producer/search")
// 해당 Mapping의 주소로 요청이 들어올 경우 무조건 req, resp생성
// but, doGet이 없을 경우 405 메세지 에러 생성
// 주소를 쳤는데, Mapping 주소가 없으면 404 메세지 생성
// Mapping 주소도 있고, req, resp를 매개변수로 활용하는 메소드가 있을 경우 200 메세지 출력
public class SearchProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * 1. 요청 URL = /search/producer
	 * 2. dao.ProducerDao	=> method : searchProducerByProducerName()
	 * 3. entity.Producer
	 * 4. search_Producer.jsp
	 * */
      
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("요청들어옴?");
		req.getRequestDispatcher("/WEB-INF/views/search_producer.jsp").forward(req, resp);
	}

}
