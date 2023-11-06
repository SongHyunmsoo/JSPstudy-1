package com.momo.DBConnectionMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionSelf {

	public static void main(String[] args) {
		

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "test";
		String pw = "1234";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		

		
		try {
			//1 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 커넥션 생성
			con = DriverManager.getConnection(url,id,pw);
			// 3. 쿼리 문장 준비
			String sql = "select * from job";
			// 4. 쿼리 문장 실행
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				 System.out.println(rs.getString("job_code")+ "  ");
		         System.out.println(rs.getString("job_name") + " ");
		         
		         }
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 - 라이브러리가 등록되었는지 확인해주세요.");
	         e.printStackTrace();
		}  catch (SQLException e) {
	         System.out.println("Connection 객체 생성 실패");
	         e.printStackTrace();
		} finally {
	    	  try {
	    		  if(rs !=null) rs.close();
	    		  if(stmt !=null) stmt.close();
	    		  if(con !=null) con.close();
	    	  }  catch (Exception e) {
	    			  System.out.println(
	    			  "자원 해제 중 예외사항이 발생하였습니다.");
				e.printStackTrace();
	    		  
	    	  }
	      }
	   }
	}
