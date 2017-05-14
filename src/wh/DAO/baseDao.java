package wh.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class baseDao {
	//数据库基础连接
	Connection conn=null;
	PreparedStatement ps;
	ResultSet rs;
	public void start() throws SQLException{
		try {
			//add database driver
			Class.forName("com.mysql.jdbc.Driver");
			 System.out.print("success forname");
			//connect database
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wh","root","123456");
			System.out.print("success connection");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		public void close() throws SQLException {
			if(conn!=null){
				conn.close();
			}if(ps!=null){
				ps.close();
			}if(rs!=null){
				rs.close();
			}
		}
	  
}

