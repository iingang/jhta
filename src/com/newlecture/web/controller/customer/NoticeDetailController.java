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
		
		// 1. ����ڰ� ������ id ���� �о�´�.
		int id = Integer.parseInt(request.getParameter("id"));
		

		//if(������ ���� ���� ����ڶ��)
		if(request.getSession().getAttribute("uid")==null) {
			response.sendRedirect("../../member/login?return-url=../customer/notice/detail?id="+id);
			return; //���̻� ���� �����ϸ� �ȵǹǷ�!! 
			//���ϸ� �̿�����!! java.lang.IllegalStateException: Cannot forward after response has been committed
		}
		
		

		// 2. �����ͺ��̽����� id=?�� ���ڵ带 ������ JDBC �ڵ带 �ۼ��Ѵ�.
		// String sql = "SELECT * FROM NOTICE WHERE ID='"+id+"'"; //�̰� String �� �϶�
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

			request.setAttribute("n", n); //���⼭ n�� ���±⶧���� detail.jsp���� �� �� ���� 
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
