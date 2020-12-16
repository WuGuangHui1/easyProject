package com.www.login;

/**
 * @author 杜鑫宇
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserService {
	private List<User> users;
	private DBUtil dbUtil;
	private User user;

	public UserService() {
		try {
			users = new ArrayList<User>();
			dbUtil = DBUtil.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<User> getUsers() {
		try {
			// 查询所有用户
			ResultSet rs = dbUtil.queryDate("select * from user");
			while (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String password = rs.getString("password");
				User user = createUser(name, phone,password);
				System.out.println(user);
				users.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	private User createUser(String name, String phone,String password) {
		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		user.setPassword(password);
		return user;
	}

	/**
	 * 判断用户是否存在
	 * 
	 * @param user 待判断的用户
	 * @return 存在则返回true，否则返回false
	 */
	public boolean isExistUser(User user) {
		// 获取待判断的用户信息
		String name = user.getName();
		String password = user.getPassword();
		// 根据用户信息拼接sql语句
		String sql = "select * from user where name = '"+name+"'";
		boolean b = false;
		try {
			b = dbUtil.isExist(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	public boolean isExist(User user) {
		// 获取待判断的用户信息
		String name = user.getName();
		String password = user.getPassword();
		// 根据用户信息拼接sql语句
		String sql = "select * from user where name = '"+name+"'and password= '"+password+"' ";
		System.out.println(sql);
		boolean b = false;
		try {
			b = dbUtil.isExist(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 注册用户
	 * 
	 * @param user 待注册的用户
	 * @return 注册是否成功，成功返回true，否则返回false
	 */
	public boolean registerUser(User user) {
		// 获取用户信息
		
		String name = user.getName();
		String password = user.getPassword();
		String email=user.getEmail();
		String phone = user.getPhone();
		// 拼接插入用户的sql语句
		String sql = "insert into user(name,password,email,phone) values('" + name + "', '" + password + "', '" + email
				+ "', '" + phone + "')";
		// 将用户的信息插入用户表中
		int n = -1;// 存储插入的记录数
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;

	}
}

