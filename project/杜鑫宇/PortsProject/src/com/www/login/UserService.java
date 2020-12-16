package com.www.login;

/**
 * @author ������
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
			// ��ѯ�����û�
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
	 * �ж��û��Ƿ����
	 * 
	 * @param user ���жϵ��û�
	 * @return �����򷵻�true�����򷵻�false
	 */
	public boolean isExistUser(User user) {
		// ��ȡ���жϵ��û���Ϣ
		String name = user.getName();
		String password = user.getPassword();
		// �����û���Ϣƴ��sql���
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
		// ��ȡ���жϵ��û���Ϣ
		String name = user.getName();
		String password = user.getPassword();
		// �����û���Ϣƴ��sql���
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
	 * ע���û�
	 * 
	 * @param user ��ע����û�
	 * @return ע���Ƿ�ɹ����ɹ�����true�����򷵻�false
	 */
	public boolean registerUser(User user) {
		// ��ȡ�û���Ϣ
		
		String name = user.getName();
		String password = user.getPassword();
		String email=user.getEmail();
		String phone = user.getPhone();
		// ƴ�Ӳ����û���sql���
		String sql = "insert into user(name,password,email,phone) values('" + name + "', '" + password + "', '" + email
				+ "', '" + phone + "')";
		// ���û�����Ϣ�����û�����
		int n = -1;// �洢����ļ�¼��
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;

	}
}

