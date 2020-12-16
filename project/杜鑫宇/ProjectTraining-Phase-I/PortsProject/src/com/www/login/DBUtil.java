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
	// 定义用于存储配置文件中的信息的属性
	private static String driver;
	private static String conn_str;
	private static String user;
	private static String pwd;
	// 连接对象
	private static Connection conn;

	// 定义当前类的对象作为属性（单例模式的需要）
	private static DBUtil dbUtil;

	// 静态代码块
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

	// 提供获取当前类的对象的接口
	public static DBUtil getInstance() throws ClassNotFoundException, SQLException {
		if (null == dbUtil) {
			dbUtil = new DBUtil();
		}
		return dbUtil;
	}

	// 加载配置文件,以获取数据库连接相关的常量
	private static void loadProperties(String pFile) throws IOException {
		// 定义Properties对象
		Properties prop = new Properties();
		// 获取配置文件对应的输入流
		InputStream pIn = DBUtil.class.getClassLoader().getResourceAsStream(pFile);
		// 加载配置文件
		prop.load(pIn);
		// 给数据库连接操作相关的属性赋值
		driver = prop.getProperty("db.driver");
		conn_str = prop.getProperty("db.connUrl");
		user = prop.getProperty("db.user");
		pwd = prop.getProperty("db.pwd");
		System.out.println("配置文件加载成功");
	}

	// 获取数据库连接
	private static void getConnection() throws SQLException, ClassNotFoundException {
		if (null == conn) {
			// 加载驱动
			Class.forName(driver);
			// 获取数据库连接对象
			conn = DriverManager.getConnection(conn_str, user, pwd);
		}
	}

	// 关闭数据库连接
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
		// 如果连接对象不为空并且连接对象没有关闭时
		if (null != conn && !conn.isClosed()) {
			conn.close();
		}
	}

	/**
	 * 判断数据是否存在
	 * 
	 * @param sql 查询的sql语句
	 * @return 存在则返回true，否则返回false
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean isExist(String sql) throws ClassNotFoundException, SQLException {
		// 连接到数据库
		getConnection();
		Statement stmt = conn.createStatement();
		// 执行查询
		ResultSet rs = stmt.executeQuery(sql);
		return rs.next();
	}

	/**
	 * 插入数据
	 * 
	 * @param sql 执行插入的sql语句
	 * @return 插入记录的行数
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int addDataToTable(String sql) throws ClassNotFoundException, SQLException {
		// 连接到数据库
		getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
	}

	/**
	 * 修改或删除数据
	 * 
	 * @param sql 待操作的SQL语句
	 * @return 修改或删除的记录行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateData(String sql) throws ClassNotFoundException, SQLException {
		// 连接到数据库
		getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);

	}
	
	
	/**
	 * 查询数据
	 * 
	 * @param sql 查询数据的sql语句
	 * @return 查询到的数据集
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet queryDate(String sql) throws ClassNotFoundException, SQLException {
		// 连接到数据库
		getConnection();
		Statement stmt = conn.createStatement();
		// 执行查询
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
