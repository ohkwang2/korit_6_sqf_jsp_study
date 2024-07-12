package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/producer/search")
// �ش� Mapping�� �ּҷ� ��û�� ���� ��� ������ req, resp����
// but, doGet�� ���� ��� 405 �޼��� ���� ����
// �ּҸ� �ƴµ�, Mapping �ּҰ� ������ 404 �޼��� ����
// Mapping �ּҵ� �ְ�, req, resp�� �Ű������� Ȱ���ϴ� �޼ҵ尡 ���� ��� 200 �޼��� ���
public class SearchProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * 1. ��û URL = /search/producer
	 * 2. dao.ProducerDao	=> method : searchProducerByProducerName()
	 * 3. entity.Producer
	 * 4. search_Producer.jsp
	 * */
      
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("��û����?");
		req.getRequestDispatcher("/WEB-INF/views/search_producer.jsp").forward(req, resp);
	}

}
