package com.www.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 杜鑫宇
 */
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String getInter = null;
		if (request.getAttribute("method").equals("get")) {
			System.out.println("选择了get方法");
			doGet(request, response);
		} else if (request.getAttribute("method").equals("post")) {
			System.out.println("选择了post方法");
			if (request.getAttribute("content") == "") {
				getInter = "该post请求未带参数,请重新输入参数";
				System.out.println(getInter);
				request.setAttribute("res_result", getInter);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			} else {
				doPost(request, response);
			}
		} else {
			response.getWriter().println("请先选择请求方法！");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		JSONObject info = new JSONObject();
		info.put("code", "200");
		info.put("message", "success");
		String result = info.toString();

		System.out.println("验证result：" + result);// /s2?methodname=get&urlname=123&textparam=123321
		// 1.参数位于URL中
		String get_url0 = (String) request.getAttribute("url");
		request.setAttribute("url_params", get_url0);
		request.setAttribute("res_result", result);
		request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
