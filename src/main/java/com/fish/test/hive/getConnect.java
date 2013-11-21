package com.fish.test.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnect {

	private static Connection conn = null;
	private static Connection conntomysql = null;

	private getConnect() {

	}

	public static Connection getHiveConn() throws SQLException {

		if (conn == null)

		{

			try {
				Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
			conn = DriverManager.getConnection(
					"jdbc:hive://10.0.7.216:50032/default", "hive", "hive");
		}

		return conn;

	}

	public static Connection getMysqlConn() throws SQLException {

		if (conntomysql == null)

		{

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
			conntomysql = DriverManager
					.getConnection(
							"jdbc:mysql://192.168.1.12:3306/hadoop?useUnicode=true&characterEncoding=GBK",
							"hive", "123456");
			System.out.println(1111);
		}

		return conntomysql;

	}

	public static void closeHive() throws SQLException {
		if (conn != null)
			conn.close();
	}

	public static void closemysql() throws SQLException {
		if (conntomysql != null)
			conntomysql.close();
	}
}
