package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ConnectionFactory;
import db.UserJdbcDAO;

/**
 * Servlet implementation class EditUserInfoServlet
 */
@WebServlet("/EditUserInfoServlet")
public class EditUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oper = request.getParameter("oper") ;
		String sapPassword , customID,sapUsername ; 
		int id ; 
		
		switch (oper) {
		case "add":
			sapPassword = request.getParameter("sapPassword");  
			customID = request.getParameter("customID"); 
			sapUsername = request.getParameter("sapUsername"); 
			try {  
	            UserJdbcDAO userInfoDao=new UserJdbcDAO();  
	            Connection conn=ConnectionFactory.getInstance().getConnection();  
	            int row = userInfoDao.InsertNew(conn, customID, sapUsername, sapPassword);  
	            // 判断是否更新成功  
                if (row > 0) {  
                    // 更新成输出信息  
                	 response.sendRedirect("FindUserServlet"); 
                }   
	        } catch (Exception e) { 
	            e.printStackTrace();  
	        }  
			
			break;
			
		case "del":
			id = Integer.valueOf(request.getParameter("id"));   
	        try {  
	            UserJdbcDAO userInfoDao=new UserJdbcDAO();  
	            Connection conn=ConnectionFactory.getInstance().getConnection();  
	            userInfoDao.delete(conn,id);  
	              
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        // 重定向到FindServlet  
	        response.sendRedirect("FindUserServlet");  
	        
			break;
			
		case "edit":
			
			id = Integer.valueOf(request.getParameter("id"));  
			sapPassword = request.getParameter("sapPassword");  
			customID = request.getParameter("customID"); 
			sapUsername = request.getParameter("sapUsername"); 
	        try {          	
	        	 UserJdbcDAO userInfoDao=new UserJdbcDAO();  
		         Connection conn=ConnectionFactory.getInstance().getConnection();  
		         userInfoDao.updateUserInfo(conn, id, customID, sapUsername, sapPassword);	            
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        // 重定向到FindServlet  
	        response.sendRedirect("FindUserServlet");  
	        
			break ; 

		default:
			break;
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
