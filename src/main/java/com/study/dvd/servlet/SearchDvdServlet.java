package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dvd.dao.DvdDao;

@WebServlet("/search")
public class SearchDvdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("utf-8"); 
//		
//		resp.getWriter().println(DvdDao.searchDvdByTitle("¹Ú"));
		
		req.getRequestDispatcher("/WEB-INF/views/search_dvd.jsp").forward(req, resp);
	}
}
