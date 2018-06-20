package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import db.ConnectionFactory;
import db.UserJdbcDAO;

/**
 * Servlet implementation class FindUserServlet
 */
@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {  			 
	            UserJdbcDAO userInfoDao=new UserJdbcDAO();  
	            Connection conn=ConnectionFactory.getInstance().getConnection();  
	            String data_user = userInfoDao.findAllUser(conn);  
	            request.setAttribute("data_user", data_user);  
	            conn.close();  
	  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  
	        request.getRequestDispatcher("UserInfo.jsp").forward(request, response);  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
