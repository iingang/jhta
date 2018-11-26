package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/customer/notice/reg")
@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*10, //10�ް� 
		maxRequestSize = 1024*1024*10*5 //10�ް� 5������ 
		)
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/notice/reg.jsp");
		// ���� ���� ��ü
		dispatcher.forward(req, resp); //����ڰ� ó�� ���� ���� �Ϸ� ���� 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ����� ���� ����
		resp.setCharacterEncoding("UTF-8"); // stream (out)�� ��� ����� utf-8
		resp.setContentType("text/html; charset=UTF-8"); // ������ html���� utf-8�� ������! �������� ���ν�����~�ϴ�(�������� ������ ����� utf-8)

		String path = req.getServletContext().getRealPath("/upload");
		System.out.println(path);
		
		//String filePath = path+"/a.jpg";
		String filePath = path +File.separator+"a.jpg";
		
		// �Է��� ���� ����
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title"); //�ʼ��Է��̴ϱ� null�������ص��� �׻���ϱ�. 
		String content = req.getParameter("content");
		Part part = req.getPart("file");
		InputStream fis = part.getInputStream();
		//OutputStream fos = new FileOutputStream("/Users/ingyung/Downloads/a.jpg"); //windows ��� ("d:\\a.jpg");
		OutputStream fos = new FileOutputStream(filePath);
		
		byte [] buf = new byte[1024];
		int size = 1024;
		
		while((size = fis.read(buf)) >= 0) { //1024, 1024, 24, -1, -1, -1 ..
			//size = fis.read(buf);
			fos.write(buf, 0, size);
		}
		System.out.println(title);
		
		String sql = "insert into Notice(ID, TITLE, WRITER_ID, CONTENT) "
				+ "VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, "newlec");
			st.setString(3, content);
			//ResultSet rs = st.executeQuery(sql);
			//ResultSet rs = st.executeQuery();
			
			int affected = st.executeUpdate();

			resp.sendRedirect("list");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	
	
}
