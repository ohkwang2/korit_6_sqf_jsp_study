package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dvd.dao.ProducerDao;
import com.study.dvd.entity.Producer;

@WebServlet("/producer/add")
public class AddProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/add_producer.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 요청시에는 기본적으로 한글이 다 깨져서 들어감
		req.setCharacterEncoding("UTF-8");
		String producerName = req.getParameter("producer");
		Producer producer = Producer.builder()
				.producerName(producerName)
				.build();
		boolean isSuccess = ProducerDao.save(producer) > 0;
		// key, value 값으로 req의 attribute 값을 넣어줌
		// 여기서 value 값은 Object타입으로 업캐스팅 되어서 들어감
		req.setAttribute("isSuccess", isSuccess);
		// 데이터 insert된 후 해당 페이지로 넘겨주겠다
		req.getRequestDispatcher("/WEB-INF/views/add_producer_result.jsp").forward(req, resp);
	}
}
