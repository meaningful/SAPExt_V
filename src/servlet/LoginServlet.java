package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ConnectionFactory;
import db.UserJdbcDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sUsername = request.getParameter("userid");
		String sPassWord = request.getParameter("password");
		if(sUsername.equals("") || sUsername.isEmpty()) {
			return ; 
		}
		
		// 校验用户名和密码
		  try {  
	            UserJdbcDAO userInfoDao=new UserJdbcDAO();  
	            Connection conn=ConnectionFactory.getInstance().getConnection();  
	            boolean bRtv = userInfoDao.checkLogin(conn, sUsername, sPassWord) ;
	            if(!bRtv) {
	            	response.sendRedirect("Login.jsp");
	            	return ; 
	            }
	              
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		
		//记录session
		
		HttpSession session = request.getSession();
		session.setAttribute("AdminUsername", URLEncoder.encode(sUsername,"UTF-8"));
		session.setAttribute("AdminUserpassword", URLEncoder.encode(sPassWord,"UTF-8"));
		response.sendRedirect("mainFrame.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
