import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/hello")
public class Nana extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//OutputStream os = response.getOutputStream();
		//PrintStream out = new PrintStream(os,true);
		response.setCharacterEncoding("UTF-8"); //stream (out)에 담는 방식이 utf-8
		response.setContentType("text/html; charset=UTF-8"); // 나지금 html문서 utf-8로 보낸다! 브라우저야 잘인식해줘~하는(브라우저에 보내는 방식을 utf-8)
		
		PrintWriter out = response.getWriter();
		//int x=3/0;
	/*	for(int i=0; i<100; i++) {
			out.println((i+1)+"안녕 Servlet!!<br />");
		}*/
	
		//System.out.println("hello Servlet");
		
		//int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		String cnt_ = request.getParameter("cnt");
		int cnt = 0;
		if(cnt_!=null&&!cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		
		for(int i=0; i<cnt; i++) {
			out.println("안녕 Servlet<br />");
		}
		
		/*String tmp_x = request.getParameter("x");
		String tmp_y = request.getParameter("y");
		int x = 0;
		int y = 0;
		
		if(tmp_x!=null&&!tmp_x.equals(""))
			x = Integer.parseInt(tmp_x);
		
		if(tmp_y!=null&&!tmp_y.equals(""))
			y = Integer.parseInt(tmp_y);
		
		out.println("덧셈결과: "+(x+y));*/
	}
}