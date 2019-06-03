package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.AddBillModel;
import models.AddItemModel;

public class AddBillDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public AddBillDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    
    
    public boolean insertCommon(String itemName,String totalQty,String billID) throws SQLException {
    	String getCost = "SELECT ItemCost FROM items where ItemName = "+"'"+itemName+"';";
    	String cost = null;
    	connect();
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(getCost);
    	while (resultSet.next()) {
    		 cost = resultSet.getString("ItemCost");
    	}
    	float itemcost = Float.parseFloat(cost);
    	resultSet.close();
    	statement.close();
    	disconnect();
    	
    	float totalCost = itemcost * (Float.parseFloat(totalQty));
    	float perCost = totalCost/4;
    	String sql = "INSERT INTO bills (`BillsID`, `BillItem`, `HarshitCost`, `HarishCost`, `DeepCost`, `NishadCost`, `TotalQty`, `TotalCost`) VALUES (?,?,?,?,?,?,?,?);";
		connect();
         
        PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sql);
        preparedStatement.setString(1, billID);
        preparedStatement.setString(2, itemName);
        preparedStatement.setFloat(3, perCost);
        preparedStatement.setFloat(4, perCost);
        preparedStatement.setFloat(5, perCost);
        preparedStatement.setFloat(6, perCost);
        preparedStatement.setString(7, totalQty);
        preparedStatement.setFloat(8, totalCost );
        
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<AddBillModel> listCurrItems() throws SQLException {
    	List<AddBillModel> listCurrItems = new ArrayList<>();
    	String sql = "SELECT BillsID, BillItem, HarshitCost, HarishCost, DeepCost, NishadCost,TotalQty,TotalCost FROM Bills";
    	
    	connect();
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while (resultSet.next()) {
    		String BillsID = resultSet.getString("BillsID");
    		String BillItem = resultSet.getString("BillItem");
    		String HarshitCost = resultSet.getString("HarshitCost");
    		String HarishCost = resultSet.getString("HarishCost");
    		String DeepCost = resultSet.getString("DeepCost");
    		String NishadCost = resultSet.getString("NishadCost");
    		String TotalQty = resultSet.getString("TotalQty");
    		String TotalCost = resultSet.getString("TotalCost");
    		
    		AddBillModel addBillModel = new AddBillModel(BillsID, BillItem, HarshitCost,HarishCost,DeepCost,NishadCost,TotalQty,TotalCost);
    		listCurrItems.add(addBillModel);
    		}
    	
    	resultSet.close();
    	statement.close();
    	disconnect();
    	return listCurrItems;
    	}
    
    public List<AddBillModel> listCurrTotal() throws SQLException {
    	List<AddBillModel> listCurrTotal = new ArrayList<>();
    	String sql = "SELECT SUM(HarshitCost) as HarshitTotal, SUM(HarishCost) as HarishTotal, SUM(DeepCost) as DeepTotal, SUM(NishadCost) as NishadTotal, SUM(TotalCost) as Total FROM Bills";
    	
    	connect();
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while (resultSet.next()) {
    		String HarshitCostTotal = resultSet.getString("HarshitTotal");
    		String HarishCostTotal = resultSet.getString("HarishTotal");
    		String DeepCostTotal = resultSet.getString("DeepTotal");
    		String NishadCostTotal = resultSet.getString("NishadTotal");
    		String Total = resultSet.getString("Total");
    		
    		AddBillModel addBillModel = new AddBillModel(HarshitCostTotal,HarishCostTotal,DeepCostTotal,NishadCostTotal,Total);
    		listCurrTotal.add(addBillModel);
    		}
    	
    	resultSet.close();
    	statement.close();
    	disconnect();
    	return listCurrTotal;
    	}
}


