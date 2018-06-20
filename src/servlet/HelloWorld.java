package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("处理get 请求");
		PrintWriter out = response.getWriter();
//		out.println("hello servlet asdf asfas  ");
		
		 String username = request.getParameter("username") ;    // 假设参数名称为info
		 String password = request.getParameter("passwd") ;    // 假设参数名称为info
//	     PrintWriter out = resp.getWriter() ;
	     out.println("<html>") ;
	     out.println("<head><title>MLDNJAVA</title></head> <br> \n" + 
	     		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">") ;
	     out.println("<body>") ;
	     out.println("<h1>  用户名：" + username+" 密码："+password + "</h1>") ;
	     out.println("</body>") ;
	     out.println("</html>") ;
	     out.close() ;
	        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
