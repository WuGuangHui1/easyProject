package com.www.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 杜鑫宇
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("登录界面调用了post方法");
		String name = request.getParameter("user");
		System.out.println(name);
		String password = request.getParameter("password");
		if (name!=null && password!=null) {
			// 根据请求参数构造User对象
			User user = new User();
			user.setName(name);
			user.setPassword(password);
            System.out.println("进来了");
			// 调用服务层接口查询用户是否存在
			boolean b = new UserService().isExist(user);
			if (b) {
				System.out.println("登录-----用户存在");				
				response.sendRedirect("resInfo.jsp");
			} else {
				response.sendRedirect("loginfalse.jsp");
			}
		}
	}

}

