package Usecase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Usecase.service.CaseServiceImpl;
import entity.Usecase;

/**
 * @author 杜鑫宇
 */
@WebServlet("/add")
public class CaseAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaseAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset='utf-8' /></head><body>");
		out.print(request.getAttribute("msg"));
		out.print("</body></html>");
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String seturl = request.getParameter("url2");

		String setmethod = new String(request.getParameter("method2").getBytes("ISO-8859-1"), "UTF-8");
		String setBody = new String(request.getParameter("body2").getBytes("ISO-8859-1"), "UTF-8");

		Usecase usecase = new Usecase();
		usecase.setUrl(seturl);
		usecase.setMethod(setmethod);
		usecase.setBody(setBody);

		System.out.println(seturl + setmethod + setBody);

		boolean isSaved = new CaseServiceImpl().addCase(usecase);
		if (isSaved) {
			response.sendRedirect("list");
		} else {
			request.setAttribute("msg", "用例新增失败");
			doGet(request, response);
		}
	}

}
