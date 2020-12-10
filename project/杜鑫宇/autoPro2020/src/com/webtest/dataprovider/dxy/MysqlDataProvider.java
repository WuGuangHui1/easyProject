package com.webtest.dataprovider.dxy;

import java.io.FileInputStream;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MysqlDataProvider {
	private static Properties dbProps = new Properties();

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
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbProps.getProperty("db.connectUrl"),
					dbProps.getProperty("db.user"), dbProps.getProperty("db.pwd"));
			if (!conn.isClosed()) {
				System.out.println("Connect——Succeed");
			}
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int cols = rsMetaData.getColumnCount();
			System.out.println("colsNumber" + cols);
			while (rs.next()) {
				String fields[] = new String[cols];

				int col = 0;
				for (int i = 0; i < cols; i++) {
					fields[col] = rs.getString(i + 1);
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
