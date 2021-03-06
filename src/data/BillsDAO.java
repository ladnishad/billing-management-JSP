package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.BillsModel;
import util.SQLConnection;

public class BillsDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    static SQLConnection sqlconnection = SQLConnection.getInstance();
    
    public BillsDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    
    public List<BillsModel> listBill(String billid) throws SQLException {
    	List<BillsModel> listbill = new ArrayList<>();
    	String sql = "SELECT BillsID,BillItem, HarshitCost, HarishCost, DeepCost, NishadCost,TotalQty,TotalCost FROM billslist where BillsID = "+billid;
    	
    	connect();
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while (resultSet.next()) {
    		String BillID = resultSet.getString("BillsID");
    		String BillItem = resultSet.getString("BillItem");
    		String HarshitCost = resultSet.getString("HarshitCost");
    		String HarishCost = resultSet.getString("HarishCost");
    		String DeepCost = resultSet.getString("DeepCost");
    		String NishadCost = resultSet.getString("NishadCost");
    		String TotalQty = resultSet.getString("TotalQty");
    		String TotalCost = resultSet.getString("TotalCost");
    		
    		BillsModel billsModel = new BillsModel(BillID, BillItem, HarshitCost, HarishCost, DeepCost, NishadCost,TotalCost,TotalQty);
    		listbill.add(billsModel);
    		}
    	
    	resultSet.close();
    	statement.close();
    	disconnect();
    	return listbill;
    	}
    
    public List<BillsModel> listBillTotal(String billid) throws SQLException {
    	List<BillsModel> listbillTotal = new ArrayList<>();
    	String sql = "SELECT SUM(HarshitCost) as HarshitTotal, SUM(HarishCost) as HarishTotal, SUM(DeepCost) as DeepTotal, SUM(NishadCost) as NishadTotal, SUM(TotalCost) as Total FROM billslist where BillsID = "+billid;
    	
    	connect();
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while (resultSet.next()) {
    		String HarshitTotal = resultSet.getString("HarshitTotal");
    		String HarishTotal = resultSet.getString("HarishTotal");
    		String DeepTotal = resultSet.getString("DeepTotal");
    		String NishadTotal = resultSet.getString("NishadTotal");
    		String Total = resultSet.getString("Total");
    		
    		BillsModel billsModel = new BillsModel(HarshitTotal,HarishTotal,DeepTotal,NishadTotal,Total);
    		listbillTotal.add(billsModel);
    		}
    	
    	resultSet.close();
    	statement.close();
    	disconnect();
    	return listbillTotal;
    	}
    
    public static boolean verifyBillPresent(String billID) throws SQLException
	{
    	Connection conn = null;
		Statement stmt = null;
		conn = SQLConnection.getDBConnection();
    	boolean billPresent = false;
    	try {
			stmt = conn.createStatement();
			String queryString = "select BillsID from `bills_management`.`billslist` where BillsID ='"+billID+"'";
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				String k = (String) rs.getObject(1);
				billPresent = true;
				break;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
			try {				
				if(conn!=null)
					conn.close();
				if(stmt!=null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	return billPresent;
	}
}
