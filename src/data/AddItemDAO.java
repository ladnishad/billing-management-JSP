package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.AddItemModel;

public class AddItemDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public AddItemDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    
    
    public boolean insertItem(AddItemModel addItemModel) throws SQLException {
		String sql = "INSERT INTO `bills_management`.`items` (ItemName,ItemCost,ItemComm) VALUES(?,?,?)";
		//String sql = "INSERT INTO `bills_management`.`items` (ItemName,ItemCost,ItemComm) VALUES('"+addItemModel.getItemName()+"','"+addItemModel.getItemCost()+"','"+addItemModel.getItemComm()+"')";
		connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        //statement.setString(1, "");
        statement.setString(1, addItemModel.getItemName());
        statement.setString(2, addItemModel.getItemCost());
        statement.setString(3, addItemModel.getItemComm());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<AddItemModel> listAllItems() throws SQLException {
    	List<AddItemModel> listItems = new ArrayList<>();
    	String sql = "SELECT * FROM `bills_management`.`Items`";
    	
    	connect();
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while (resultSet.next()) {
    		String ItemID = resultSet.getString("ItemID");
    		String ItemName = resultSet.getString("ItemName");
    		String ItemCost = resultSet.getString("ItemCost");
    		String ItemComm = resultSet.getString("ItemComm");
    		
    		AddItemModel addItemModel = new AddItemModel(ItemID, ItemName, ItemCost, ItemComm);
    		listItems.add(addItemModel);
    		}
    	
    	resultSet.close();
    	statement.close();
    	disconnect();
    	return listItems;
    	}
    
    public List<AddItemModel> listAllItemNames() throws SQLException {
    	List<AddItemModel> listAllItemNames = new ArrayList<>();
    	String sql = "SELECT ItemID, ItemName FROM `bills_management`.`Items`";
    	
    	connect();
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while (resultSet.next()) {
    		String ItemID = resultSet.getString("ItemID");
    		String ItemName = resultSet.getString("ItemName");
    		
    		AddItemModel addItemModel = new AddItemModel(ItemID,ItemName);
    		listAllItemNames.add(addItemModel);
    		}
    	
    	resultSet.close();
    	statement.close();
    	disconnect();
    	return listAllItemNames;
    	}
}
