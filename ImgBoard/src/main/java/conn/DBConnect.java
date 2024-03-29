package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static DBConnect db = new DBConnect();
	private Connection conn = null;

	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@db202110262237_high?TNS_ADMIN=/Users/imhyojin/Wallet_DB202110262237";

	private DBConnect() {
		// TODO Auto-generated constructor stub

	}

	public static DBConnect getInstance() {
		return db;
	}

	public Connection getConnection() {

		try {
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url, "ADMIN", "Dkfdktek36270113");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}
