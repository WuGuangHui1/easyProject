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
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
