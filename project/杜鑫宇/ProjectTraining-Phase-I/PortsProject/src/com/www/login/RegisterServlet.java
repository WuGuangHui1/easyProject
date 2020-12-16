package com.www.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 杜鑫宇
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		String name=request.getParameter("user");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		boolean b = new UserService().isExistUser(user);
		if(b) {
             response.sendRedirect("registerfalse.jsp");
		}
		else {
			System.out.println("用户不存在，可以注册");
			boolean a=new UserService().registerUser(user);
			if(a) {
				response.sendRedirect("login.jsp");
			}
		}
	}

}
