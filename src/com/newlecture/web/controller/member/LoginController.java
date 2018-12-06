package com.newlecture.web.controller.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Member;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp"); //홈 디렉토리 /서부터 시작하면 WebContent다!! 
	    dispatcher.forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uid = request.getParameter("uid"); //꼭 넘겨야하는 값이므로 임시변수만들어서 null값 검사할 필요가 없다!! 
		String pwd = request.getParameter("pwd");
		
		String sql = "select * from MEMBER where id=?";
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		
		Member member = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uid);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				 member = new Member(
					rs.getString("id"),
					rs.getString("pwd"),
					rs.getString("name"),
					rs.getString("gender"),
					rs.getInt("age"),
					rs.getString("birthday"),
					rs.getString("phone"),
					rs.getDate("regdate"),
					rs.getString("boss")
					
					);
					
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//1. 아이디가 없다면 ?
		if(member==null) {
			response.sendRedirect("?er=1"); // jsp에서 <c:if test="${param.er==1}"> 이렇게받아야
			
			
			// jsp에서 <c:if test="${er==1}"> 이렇게받아야
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
			request.setAttribute("er", 1);
			dispatcher.forward(request,response);*/
		}
		
		else if(!pwd.equals(member.getPwd())){
			response.sendRedirect("?er=1");
		}
		
		else{
			//인증되었다는 상태를 저장해야 한다.
			request.getSession().setAttribute("uid", uid);
			//index		//student/index, admin/index
			String returnURL = request.getParameter("return-url");
			System.out.println(returnURL);
			
			if(returnURL!=null)
				response.sendRedirect(returnURL);
			else
				response.sendRedirect("../index");
		}
		
	}
	
	
}
