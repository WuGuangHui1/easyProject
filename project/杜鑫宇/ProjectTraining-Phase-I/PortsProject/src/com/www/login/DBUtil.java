package com.www.login;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtil {
	// �������ڴ洢�����ļ��е���Ϣ������
	private static String driver;
	private static String conn_str;
	private static String user;
	private static String pwd;
	// ���Ӷ���
	private static Connection conn;

	// ���嵱ǰ��Ķ�����Ϊ���ԣ�����ģʽ����Ҫ��
	private static DBUtil dbUtil;

	// ��̬�����
	static {
		try {
			loadProperties("/dbinfo.properties");
			getConnection();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private DBUtil() throws ClassNotFoundException, SQLException {

	}

	// �ṩ��ȡ��ǰ��Ķ���Ľӿ�
	public static DBUtil getInstance() throws ClassNotFoundException, SQLException {
		if (null == dbUtil) {
			dbUtil = new DBUtil();
		}
		return dbUtil;
	}

	// ���������ļ�,�Ի�ȡ���ݿ�������صĳ���
	private static void loadProperties(String pFile) throws IOException {
		// ����Properties����
		Properties prop = new Properties();
		// ��ȡ�����ļ���Ӧ��������
		InputStream pIn = DBUtil.class.getClassLoader().getResourceAsStream(pFile);
		// ���������ļ�
		prop.load(pIn);
		// �����ݿ����Ӳ�����ص����Ը�ֵ
		driver = prop.getProperty("db.driver");
		conn_str = prop.getProperty("db.connUrl");
		user = prop.getProperty("db.user");
		pwd = prop.getProperty("db.pwd");
		System.out.println("�����ļ����سɹ�");
	}

	// ��ȡ���ݿ�����
	private static void getConnection() throws SQLException, ClassNotFoundException {
		if (null == conn) {
			// ��������
			Class.forName(driver);
			// ��ȡ���ݿ����Ӷ���
			conn = DriverManager.getConnection(conn_str, user, pwd);
		}
	}

	// �ر����ݿ�����
	public static void close(ResultSet rs, PreparedStatement pstm, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeDB() throws SQLException {
		// ������Ӷ���Ϊ�ղ������Ӷ���û�йر�ʱ
		if (null != conn && !conn.isClosed()) {
			conn.close();
		}
	}

	/**
	 * �ж������Ƿ����
	 * 
	 * @param sql ��ѯ��sql���
	 * @return �����򷵻�true�����򷵻�false
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean isExist(String sql) throws ClassNotFoundException, SQLException {
		// ���ӵ����ݿ�
		getConnection();
		Statement stmt = conn.createStatement();
		// ִ�в�ѯ
		ResultSet rs = stmt.executeQuery(sql);
		return rs.next();
	}

	/**
	 * ��������
	 * 
	 * @param sql ִ�в����sql���
	 * @return �����¼������
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int addDataToTable(String sql) throws ClassNotFoundException, SQLException {
		// ���ӵ����ݿ�
		getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
	}

	/**
	 * �޸Ļ�ɾ������
	 * 
	 * @param sql ��������SQL���
	 * @return �޸Ļ�ɾ���ļ�¼����
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateData(String sql) throws ClassNotFoundException, SQLException {
		// ���ӵ����ݿ�
		getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);

	}
	
	
	/**
	 * ��ѯ����
	 * 
	 * @param sql ��ѯ���ݵ�sql���
	 * @return ��ѯ�������ݼ�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet queryDate(String sql) throws ClassNotFoundException, SQLException {
		// ���ӵ����ݿ�
		getConnection();
		Statement stmt = conn.createStatement();
		// ִ�в�ѯ
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}

	public static List<Map<String, Object>> findAll(String sql) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub
		try {
			getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new LinkedHashMap<String, Object>(metaData.getColumnCount());
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnLabel(i + 1), rs.getObject(i + 1));
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, pstm, conn);
		}
	}

}
