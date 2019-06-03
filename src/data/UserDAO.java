package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.AddBillModel;
import models.UserModel;

public class UserDAO {

		private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection jdbcConnection;
	    
	    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	        this.jdbcURL = jdbcURL;
	        this.jdbcUsername = jdbcUsername;
	        this.jdbcPassword = jdbcPassword;
	    }
	    
	    protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            jdbcConnection = DriverManager.getConnection(
	                                        jdbcURL, jdbcUsername, jdbcPassword);
	        }
	    }
	    
	    protected void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }
	    
	    public List<UserModel> listUsers() throws SQLException {
	    	List<UserModel> listUsers = new ArrayList<>();
	    	String sql = "SELECT username from users";
	    	
	    	connect();
	    	Statement statement = jdbcConnection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(sql);
	    	while (resultSet.next()) {
	    		String UserName = resultSet.getString("username");
	    		
	    		UserModel user = new UserModel(UserName);
	    		listUsers.add(user);
	    		}
	    	
	    	resultSet.close();
	    	statement.close();
	    	disconnect();
	    	return listUsers;
	    	}
}
