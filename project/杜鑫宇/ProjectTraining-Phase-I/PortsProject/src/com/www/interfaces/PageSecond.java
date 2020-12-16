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
@WebServlet("/page2")
public class PageSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageSecond() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		JSONObject info = new JSONObject();
		info.put("code", "200");
		info.put("message", "success");
		String result = info.toString();

		System.out.println("验证result：" + result);// /s2?methodname=get&urlname=123&textparam=123321
		// 1.参数位于URL中
		String get_url0 = (String) request.getAttribute("url");
		if (get_url0.length() == 0) {
			response.sendError(404);
		} else if (!get_url0.contains("?") &&request.getAttribute("content") == "") {
//			request.setAttribute("input_text", request.getAttribute("content"));
//			不带参数
			request.setAttribute("url_params", get_url0);
			request.setAttribute("res_result", result);
			request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
		} else if (!get_url0.contains("?") && !(request.getAttribute("content") == "")) {
			// 2.参数位于文本框中
			String content = request.getAttribute("content").toString();
			System.out.println("验证Content内容：" + content);
			// 获取输入的参数，转化为json格式
			String[] paramm = content.split("\\r\\n");
			
			JSONObject para = new JSONObject();
			for (int i = 0; i < paramm.length; i++) {
				System.out.println(i + "：" + paramm[i]);
				String[] item = paramm[i].split("=");
				String key = item[0];
				String value = item[1];
				para.put(key, value);
			}

			String para_toString = para.toString();

			System.out.println("para_toString" + para_toString);
			// 对请求参数进行断言判断
			String para_name = para.getString("name");
			String para_pwd = para.getString("password");
			if (para_name.equals("admin") && para_pwd.equals("123456")) {
//				request.setAttribute("url_params", para_toString);
				
				request.setAttribute("url_params", get_url0);
//				request.setAttribute("input_text", request.getAttribute("content"));
				request.setAttribute("input_text",para_toString);
				request.setAttribute("res_result", result);
				
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			} else {
				response.sendError(404);
				System.out.println("请求参数有误！");
			}
		} else {
			String[] url_parts = get_url0.split("[?]");
			String get_url = url_parts[1];
			System.out.println("get_url：" + get_url);
			// params[i] : textparam = 123321
			String[] params = get_url.split("&");
			JSONObject obj = new JSONObject();
			for (int i = 0; i < params.length; i++) {
				// param : textparam,12321
				String[] param = params[i].split("=");
				if (param.length >= 2) {
					String key = param[0];
					String value = param[1];
					for (int j = 2; param.length > j; j++) {
						value += "=" + param[j];
					}
					obj.put(key, value);
				}
			}
			String url_param = obj.toString();
			// 断言进行参数的判断
			String in_name = obj.getString("name");
			String in_pwd = obj.getString("password");
			System.out.println(in_name);
			System.out.println(in_pwd);
			if (in_name.equals("admin") && in_pwd.equals("123456")) {
//				request.setAttribute("url_params", url_param);
				request.setAttribute("url_params", get_url0);
//				request.setAttribute("input_text", request.getAttribute("content"));
				request.setAttribute("input_text",url_param);
				request.setAttribute("res_result", result);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			} else {
				response.sendError(404);
				System.out.println("请求参数有误！");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=UTF-8");
		System.out.println("post运行");

		String getInter = null;
//		String req = request.getParameter("req");
		String get_url0 = (String) request.getAttribute("url");
		String req = (String) request.getAttribute("content");
		if (req != null) {
			JSONObject json = JSONObject.parseObject(req);
			int age = json.getIntValue("age");
			String name = json.getString("name");
//			
			if (age == 20 && name.equals("吉晓瑜")) {
				System.out.println(age);
				System.out.println(name);
				JSONObject obj = new JSONObject();
				obj.put("message", "成功");
				getInter = obj.toString();

				System.out.println(getInter);
				System.out.println("成功");
				
				request.setAttribute("url_params", get_url0);
				request.setAttribute("input_text", req);
				request.setAttribute("res_result", getInter);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			} else {
				JSONObject obj = new JSONObject();
				obj.put("message", "失败");
				obj.put("code", 400);

				getInter = obj.toString();
				System.out.println(getInter);
				System.out.println("失败");
				request.setAttribute("res_result", getInter);
				request.setAttribute("url_params", get_url0);
				request.setAttribute("input_text", req);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}
		} else {
			getInter = "该post请求未带参数";
			System.out.println(getInter);
			request.setAttribute("res_result", getInter);
			
			request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
		}

	}

}
