import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add")
public class Add extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8"); //stream (out)�� ��� ����� utf-8
		response.setContentType("text/html; charset=UTF-8"); // ������ html���� utf-8�� ������! �������� ���ν�����~�ϴ�(�������� ������ ����� utf-8)
		
		
		PrintWriter out = response.getWriter();
		int x = 0;
		int y = 0;
		int sum = 0;
		
		String sum_ = request.getParameter("s");
		if(sum_!=null)
			sum = Integer.parseInt(sum_);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp"); //add.jsp�� root(WebContent)�� �����ϱ� ����� ����~ �� �����ݾ�~ 
	    request.setAttribute("sum", sum);
	    dispatcher.forward(request,response);
		
		/*out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action =\"add\" method=\"post\">");
		out.write("		<table border=\"1\">");
		out.write("			<tr>");
		out.write("				<td>");
		out.write("					����� �� �Է��ϼ���. ");
		out.write("				</td>");
		out.write("			</tr>	");
		out.write("			<tr>");
		out.write("				<td>");
		out.write("					<input type=\"text\" name=\"x\" value=\""+x+"\" />");
		out.write("					<input type=\"text\" name=\"y\" value=\""+y+"\" />");
		out.write("				</td>");
		out.write("				<td>");
		out.write("					<input type=\"submit\"/>");
		out.write("				</td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td>");
		out.printf("				<label>sum : %d</label>", sum);
		out.write("				</td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("	</form>");
		out.write("	<a href=\"mypage.jsp\">����������</a>");
		out.write("</body>");
		out.write("</html>");*/
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����� ���� ���� 
		response.setCharacterEncoding("UTF-8"); //stream (out)�� ��� ����� utf-8
		response.setContentType("text/html; charset=UTF-8"); // ������ html���� utf-8�� ������! �������� ���ν�����~�ϴ�(�������� ������ ����� utf-8)
		
		//�Է��� ���� ���� 
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		int x = 0;
		int y = 0;
		int sum = 0;
		
		String cmd = request.getParameter("cmd");
		
		switch(cmd) {
		case "����":

			String tmp_x = request.getParameter("x");
			String tmp_y = request.getParameter("y");
		
			if(tmp_x!=null&&!tmp_x.equals(""))
				x = Integer.parseInt(tmp_x);
			
			if(tmp_y!=null&&!tmp_y.equals(""))
				y = Integer.parseInt(tmp_y);
			
			sum = x+y;
			break;
			
		case "session":
			String sum1 = request.getParameter("sum");
			HttpSession session = request.getSession();
			session.setAttribute("sum", sum1);
			break;
		
		case "application":
			String sum2 = request.getParameter("sum");
			ServletContext application = request.getServletContext();
			application.setAttribute("sum", sum2);
			break;
		
		}
	/*	RequestDispatcher dispatcher = request.getRequestDispatcher("/add");
		request.setAttribute("sum",	sum);
		//���� ���� ��ü�� �ʿ��ϴ�..(����..)
		dispatcher.forward(request, response);
		//post ó�� forward -> �ٽ� post�� ��û�ϰ� �ȴ�. 
		*/
		
		response.sendRedirect("add?s="+sum); // GET ��û�� ���� 
		
		/*out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action =\"add\" method=\"post\">");
		out.write("		<table border=\"1\">");
		out.write("			<tr>");
		out.write("				<td>");
		out.write("					����� �� �Է��ϼ���. ");
		out.write("				</td>");
		out.write("			</tr>	");
		out.write("			<tr>");
		out.write("				<td>");
		out.write("					<input type=\"text\" name=\"x\" value=\""+x+"\" />");
		out.write("					<input type=\"text\" name=\"y\" value=\""+y+"\" />");
		out.write("				</td>");
		out.write("				<td>");
		out.write("					<input type=\"submit\"/>");
		out.write("				</td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td>");
		out.printf("				<label>sum : %d</label>", sum);
		out.write("				</td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");*/
	}
	
	
	/*public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//OutputStream os = response.getOutputStream();
		//PrintStream out = new PrintStream(os,true);
		response.setCharacterEncoding("UTF-8"); //stream (out)�� ��� ����� utf-8
		response.setContentType("text/html; charset=UTF-8"); // ������ html���� utf-8�� ������! �������� ���ν�����~�ϴ�(�������� ������ ����� utf-8)
		
		PrintWriter out = response.getWriter();
		
		
		int x = 0;
		int y = 0;
		int sum = 0;
		
		if(request.getMethod().equals("POST")) {
			String tmp_x = request.getParameter("x");
			String tmp_y = request.getParameter("y");
		
			if(tmp_x!=null&&!tmp_x.equals(""))
				x = Integer.parseInt(tmp_x);
			
			if(tmp_y!=null&&!tmp_y.equals(""))
				y = Integer.parseInt(tmp_y);
			
			sum = x+y;
		}
		//out.println("�������: "+sum);
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action =\"add\" method=\"post\">");
		out.write("		<table border=\"1\">");
		out.write("			<tr>");
		out.write("				<td>");
		out.write("					����� �� �Է��ϼ���. ");
		out.write("				</td>");
		out.write("			</tr>	");
		out.write("			<tr>");
		out.write("				<td>");
		out.write("					<input type=\"text\" name=\"x\" value=\""+x+"\" />");
		out.write("					<input type=\"text\" name=\"y\" value=\""+y+"\" />");
		out.write("				</td>");
		out.write("				<td>");
		out.write("					<input type=\"submit\"/>");
		out.write("				</td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td>");
		out.printf("				<label>sum : %d</label>", sum);
		out.write("				</td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
		
	}*/
}