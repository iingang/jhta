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
import com.newlecture.web.entity.NoticeFile;

@WebServlet("/customer/notice/detail")
public class NoticeDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. 사용자가 전달한 id 값을 읽어온다.
		int id = Integer.parseInt(request.getParameter("id"));
		

		//if(인증을 하지 않은 사용자라면)
		if(request.getSession().getAttribute("uid")==null) {
			response.sendRedirect("../../member/login?return-url=../customer/notice/detail?id="+id);
			return; //더이상 밑을 진행하면 안되므로!! 
			//안하면 이오류뜸!! java.lang.IllegalStateException: Cannot forward after response has been committed
		}
		
		

		// 2. 데이터베이스에서 id=?인 레코드를 얻어오는 JDBC 코드를 작성한다.
		// String sql = "SELECT * FROM NOTICE WHERE ID='"+id+"'"; //이건 String 값 일때
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		String sqlPrev = "";
		String sqlFile = "SELECT * FROM NOTICE_FILE WHERE NOTICE_ID=?";

		try {
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			// Statement st = con.createStatement();

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			rs.next();

			/*
			 * String title = rs.getString("title"); String content =
			 * rs.getString("content"); String writerId = rs.getString("writer_id");
			 */
			Notice n = new Notice(rs.getInt("id"), 
						rs.getString("title"), 
						rs.getString("content"),
						rs.getString("writer_id"), 
						rs.getDate("regDate"),  
						rs.getInt("hit")
					);

			rs.close();
			st.close();

			PreparedStatement stFile = con.prepareStatement(sqlFile);
			stFile.setInt(1, id);

			ResultSet rsFile = stFile.executeQuery();
			List<NoticeFile> files = new ArrayList<>();

			while (rsFile.next()) {
				NoticeFile nf = new NoticeFile(
							rsFile.getInt("id"), 
							rsFile.getString("name"), 
							rsFile.getInt("notice_id")
						);
				files.add(nf);
			}

			stFile.close();
			con.close();

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp");
			/*
			 * request.setAttribute("title", title); request.setAttribute("content",
			 * content); request.setAttribute("writer_id", writerId);
			 */

			request.setAttribute("n", n); //여기서 n을 보냈기때문에 detail.jsp에서 쓸 수 있음 
			request.setAttribute("files", files);

			dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
