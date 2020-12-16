package com.www.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ������
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
			System.out.println("ѡ����get����");
			doGet(request, response);
		} else if (request.getAttribute("method").equals("post")) {
			System.out.println("ѡ����post����");
			if (request.getAttribute("content") == "") {
				getInter = "��post����δ������,�������������";
				System.out.println(getInter);
				request.setAttribute("res_result", getInter);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			} else {
				doPost(request, response);
			}
		} else {
			response.getWriter().println("����ѡ�����󷽷���");
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
		System.out.println("post����");

		String getInter = null;
//		String req = request.getParameter("req");
		String get_url0 = (String) request.getAttribute("url");
		String req = (String) request.getAttribute("content");
		if (req != null) {
			JSONObject json = JSONObject.parseObject(req);
			int age = json.getIntValue("age");
			String name = json.getString("name");
//			
			if (age == 20 && name.equals("�����")) {
				System.out.println(age);
				System.out.println(name);
				JSONObject obj = new JSONObject();
				obj.put("message", "�ɹ�");
				getInter = obj.toString();

				System.out.println(getInter);
				System.out.println("�ɹ�");
				
				request.setAttribute("url_params", get_url0);
				request.setAttribute("input_text", req);
				request.setAttribute("res_result", getInter);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			} else {
				JSONObject obj = new JSONObject();
				obj.put("message", "ʧ��");
				obj.put("code", 400);

				getInter = obj.toString();
				System.out.println(getInter);
				System.out.println("ʧ��");
				request.setAttribute("res_result", getInter);
				request.setAttribute("url_params", get_url0);
				request.setAttribute("input_text", req);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}
		} else {
			getInter = "��post����δ������";
			System.out.println(getInter);
			request.setAttribute("res_result", getInter);
			
			request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
		}

	}

}
