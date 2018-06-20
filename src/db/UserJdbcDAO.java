package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bean.UserInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class UserJdbcDAO {
	private PreparedStatement ptmt = null;  
	
	public UserJdbcDAO() {  
    }  
  
	public String findAllUser(Connection conn) throws SQLException  
    {  
		
		JSONArray jsoa = null ;	 
		 try {           
	            String sql = "select * from UserInfo";  
	            // 获取Statement  
	            Statement statement = conn.createStatement();  	  
	            ResultSet resultSet = statement.executeQuery(sql);  

	            while (resultSet.next()) {  
	            	UserInfo user = new UserInfo();  
	            	user.setId(resultSet.getInt("id"));
	                user.setCustomID(resultSet.getString("customID"));
	                user.setSapUsername(resultSet.getString("sapUsername"));
	                user.setSapPassword(resultSet.getString("sapPassword"));  
	                
	                JsonConfig jsonConfig = new JsonConfig();
	                jsonConfig.setExcludes(new String[]{ "sapPw" }); // 设置json过滤的值
	                JSONObject jso = JSONObject.fromObject(user,jsonConfig);
	                if(jsoa == null) {
	                	jsoa = JSONArray.fromObject(jso);
	                }else {
	                	 jsoa.add(jso);
	                }
	                              
	            }  
	            System.out.println(jsoa.toString());
	            
	            resultSet.close();  
	            statement.close();  
	            
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  
	        return jsoa.toString() ; 
	        
    } 
	
	public boolean checkLogin(Connection conn , String username , String password) {
		try {
			String sql = "select * from adminUser where userid = '"+username+"'";
//			String sql = "select * from UserInfo";
			 // 获取Statement  
			Statement statement = conn.createStatement();  	  
	        ResultSet resultSet = statement.executeQuery(sql);  
	        if(resultSet.next()) {
	        	boolean rtv = resultSet.getString("password").equals(password)?true:false;
	        	resultSet.close();  
	        	statement.close();
	        	return rtv ; 
	        }else {  
	        	resultSet.close();  
	        	statement.close();  
	        	return false ;
	        }
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false ; 
	}
	
	public int  InsertNew(Connection conn , String customID , String sapUserName , String sapPassWord) {
		try {  
            
            // 添加SAP账户信息的SQL语句  
            String sql = "insert into UserInfo(customID,sapUsername,sapPassword) values(?,?,?)";  
            // 获取PreparedStatement  
            ptmt = conn.prepareStatement(sql);  
            // 对SQL语句中的第1个参数赋值  
            ptmt.setString(1, customID);  
            // 对SQL语句中的第2个参数赋值  
            ptmt.setString(2, sapUserName);  
            // 对SQL语句中的第3个参数赋值  
            ptmt.setString(3, sapPassWord);    
            	
            // 执行更新操作，返回所影响的行数  
            int row = ptmt.executeUpdate();  
            // 关闭PreparedStatement，释放资源  
            ptmt.close();  
            // 关闭Connection，释放资源  
            conn.close();  
            
            return row ; 
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return 0 ; 
		
	}
	  
	public void delete(Connection conn, int id) throws SQLException  
	{  
	    String sql = "delete from UserInfo where id=?";  
	    try{  
	        ptmt = conn.prepareStatement(sql);  
	        // 对SQL语句中的第一个占位符赋值  
	        ptmt.setInt(1, id);  
	        // 执行更新操作  
	        ptmt.executeUpdate();  
	          
	    }finally{  
	        if (null!=ptmt) {  
	            ptmt.close();  
	        }  
	          
	        if (null!=conn) {  
	            conn.close();  
	        }  
	          
	    }  
	      
	}  
	  
	public void updateUserInfo(Connection conn, int id ,String sapPassword) throws SQLException  
	{  
		try {
			 // 更新SQL语句  
	        String sql = "update UserInfo set SapPassWord=? where id=?";  
	        // 获取PreparedStatement  
	        ptmt = conn.prepareStatement(sql);  
	        // 对SQL语句中的第一个参数赋值  
	        ptmt.setString(1, sapPassword);  
	        // 对SQL语句中的第二个参数赋值  
	        ptmt.setInt(2, id);  
	        // 执行更新操作  
	        ptmt.executeUpdate();  
		}finally {	
			if (null!=ptmt) {  
	            ptmt.close();  
	        }  
	          
	        if (null!=conn) {  
	            conn.close();  
	        }  
		}
		
	       
	}  

	
	public void updateUserInfo(Connection conn, int id ,String customID , String sapUsername , String sapPassword ) throws SQLException  
	{  
		try {
			 // 更新SQL语句  
	        String sql = "update UserInfo set customID=? ,SapUsername=? ,SapPassWord=?  where id=?";  
	        // 获取PreparedStatement  
	        ptmt = conn.prepareStatement(sql);  
	        // 对SQL语句中的第一个参数赋值  
	        ptmt.setString(1, customID);  
	        ptmt.setString(2, sapUsername);  
	        ptmt.setString(3, sapPassword);  
	        // 对SQL语句中的第二个参数赋值  
	        ptmt.setInt(4, id);  
	        // 执行更新操作  
	        ptmt.executeUpdate();  
		}finally {	
			if (null!=ptmt) {  
	            ptmt.close();  
	        }  
	          
	        if (null!=conn) {  
	            conn.close();  
	        }  
		}
		
	       
	}  
	

}
