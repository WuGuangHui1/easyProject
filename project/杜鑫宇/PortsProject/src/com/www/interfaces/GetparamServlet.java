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
@WebServlet("/GetparamServlet")
public class GetparamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetparamServlet() {
        super();
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
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");

		JSONObject info = new JSONObject();
		info.put("code", "200");
		info.put("message", "success");
		String result = info.toString();

		System.out.println("验证result：" + result);
		String get_url0 = (String) request.getAttribute("url");
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
//			request.setAttribute("url_params", url_param);
			request.setAttribute("url_params", get_url0);
//			request.setAttribute("input_text", request.getAttribute("content"));
			request.setAttribute("input_text",url_param);
			request.setAttribute("res_result", result);
			request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
		} else {
			response.sendError(404);
			System.out.println("请求参数有误！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
