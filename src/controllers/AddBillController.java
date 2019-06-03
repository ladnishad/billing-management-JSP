package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.AddBillDAO;
import data.AddItemDAO;
import data.BillsDAO;
import models.AddBillModel;
import models.AddItemModel;
import models.BillsModel;


@WebServlet("/AddBillController")
public class AddBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddItemDAO itemsDAO;
	private AddBillDAO billsDAO;
	String url = "";
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        itemsDAO = new AddItemDAO(jdbcURL, jdbcUsername, jdbcPassword);
        billsDAO = new AddBillDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
 
	public AddBillController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		}
		
		
        
	
	
	private void listItemNames(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		List<AddItemModel> listAllItemNames;
		try {
			url = "/Homepage.jsp";
			listAllItemNames = itemsDAO.listAllItemNames();
			request.setAttribute("listAllItemNames", listAllItemNames);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void listCurrBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
        
    }
	
	private void insertCommon(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		String ItemName = request.getParameter("CommitemlistText");
        String ItemQty = request.getParameter("CommitemQty");
        String BillID = constructBillId();
        
        billsDAO.insertCommon(ItemName,ItemQty,BillID);
        
        List<AddBillModel> listCurrItems = billsDAO.listCurrItems();
        List<AddBillModel> listCurrTotal = billsDAO.listCurrTotal();
        request.setAttribute("listCurrItems", listCurrItems);
        request.setAttribute("listCurrTotal", listCurrTotal);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
        dispatcher.forward(request, response);
    }
	
	private String constructBillId(){
		LocalDateTime localdatetime = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yy HH");
		String formattedDate = localdatetime.format(myFormatObj).toString();
		String cleanDate = formattedDate.replace("-","").replace(" ","");
		return cleanDate;
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch(action){
		case "populate":
			try {
				listItemNames(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            break;
		case "addCommon":
			try{
				insertCommon(request,response);
			}catch(SQLException e){
				e.printStackTrace();
			}
        default:
        	//response.sendRedirect("Homepage.jsp");
            break;
        }
	}

}
