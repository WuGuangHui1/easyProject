package com.webtest.dataprovider;

import java.io.FileInputStream;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MysqlDataProvider {
	private static Properties dbProps = new Properties();

	/**
	 * 读取配置文件，加载数据库驱动
	 */
	static {
		try {
//			InputStream is = DBUtil.class.getResourceAsStream("conf/config.properties");
			FileInputStream is = new FileInputStream("conf/config.properties");
			dbProps.load(is);
			Class.forName(dbProps.getProperty("db.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object[][] getTestDataByMysql(String sql) throws ClassNotFoundException {
//		String url = "jdbc:mysql://localhost:3306/demo001";
		List<Object[]> records = new ArrayList<Object[]>();
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");//仅适用于mysql8、phpStudy对应的是mysql5版本，不用加.cj
			//获取数据库连接
			Connection conn = DriverManager.getConnection(dbProps.getProperty("db.connectUrl"),
					dbProps.getProperty("db.user"), dbProps.getProperty("db.pwd"));
			if (!conn.isClosed()) {
				System.out.println("连接数据库成功");
			}
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// 得到数据集的结构
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int cols = rsMetaData.getColumnCount();
			System.out.println("列数：" + cols);//要对应属性去看，2列代表了2个属性
			while (rs.next()) {
				String fields[] = new String[cols];

				int col = 0;
				for (int i = 0; i < cols; i++) {
					fields[col] = rs.getString(i + 1);// 读取当前行指定的列
					col++;
				}
				records.add(fields);

			}
			rs.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object[][] results = new Object[records.size()][];
		for(int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		return results;
	}

}
