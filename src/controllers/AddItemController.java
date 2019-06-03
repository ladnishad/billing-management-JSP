package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.AddItemDAO;
import models.AddItemModel;

/**
 * Servlet implementation class AddItemController
 */
@WebServlet("/AddItemController")
public class AddItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddItemDAO addItemdao;
	 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        addItemdao = new AddItemDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		try {
            switch (action) {
            case "additem":
                addItem(request, response);
                listItems(request, response);
                break;
            case "list":
            	listItems(request, response);
                break;
            default:
                listItems(request, response);
                break;
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
	}
	
	private void listItems(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<AddItemModel> listItems = addItemdao.listAllItems();
        request.setAttribute("listItems", listItems);
        getServletContext().getRequestDispatcher("/AddItem.jsp").forward(request, response);
    }
	
	private void addItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String ItemName = request.getParameter("itemnameinput");
        String ItemCost = request.getParameter("itemcostinput");
        String ItemComm = request.getParameter("itemcominput");
 
        AddItemModel addItemModel = new AddItemModel(ItemName, ItemCost, ItemComm);
        addItemdao.insertItem(addItemModel);
        //response.sendRedirect("list");
        
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
