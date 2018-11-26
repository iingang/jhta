package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/list")
public class NoticeListController extends HttpServlet {

	//컨트롤러 통해서 list.jsp 를 열겠다!
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// jdbc 코드
		String page_ = request.getParameter("p");
		
		int page = 1;
		if(page_!=null&&!page_.equals(""))
			page=Integer.parseInt(page_);
		
		String sql = "SELECT * FROM " + 
	            "(" + 
	            "    SELECT ROWNUM NUM, N.* " + 
	            "    FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC)N" + 
	            ")" + 
	            "WHERE NUM BETWEEN ? AND ?";
		
		//String sql = "SELECT * FROM NOTICE";
		
		try {
			
			int start = 10*(page-1)+1;
			int end = page*10;
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, start);
			st.setInt(2, end);
			//ResultSet rs = st.executeQuery(sql);
			ResultSet rs = st.executeQuery();
		

			List<Notice> list = new ArrayList<>();
			
			while(rs.next()) {
				Notice n = new Notice(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer_id"),
						rs.getDate("regDate"),
						rs.getInt("hit")
						);
				//n.setId(rs.getString("id"));
				//n.setTitle(rs.getString("title"));
				
				list.add(n);
				
			}
			
			rs.close();
			st.close();
			con.close();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/list.jsp");
		    request.setAttribute("list", list);
		    dispatcher.forward(request,response);
			

			/* rs.next(); */

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
