package com.newlecture.web.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/index")
public class IndexController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	    String sql = "select role_id from member_role where member_id=? and default_role=1";
	   
	    String defaultRoleId ="";
	    
	    /*switch(defaultRoleId) {
	    case "ROLE_ADMIN":
	    	response.sendRedirect("../admin/index");
	    	break;
	    case "ROLE_STUDENT":
	    	response.sendRedirect("../student/index");
	    	break;
	    default:
	    	response.sendRedirect("../index");
	    	break;
	    	
	    }*/
	    
	    
	}

}
