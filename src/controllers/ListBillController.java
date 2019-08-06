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
import data.BillsDAO;
import models.AddItemModel;
import models.BillsErrMsgs;
import models.BillsModel;

/**
 * Servlet implementation class ListBillController
 */
@WebServlet("/ListBillController")
public class ListBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillsDAO billsdao;
	String url = "";
	 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        billsdao = new BillsDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBillController() {
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
            case "listbill":
            	listBill(request, response);
                break;
            default:
            	response.sendRedirect("ViewBills.jsp");
                break;
            }
        } catch (SQLException ex) {
           // throw new ServletException(ex);
        	System.out.println(ex.getStackTrace());
        }
	}
	
	private void listBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String ItemID = request.getParameter("BillIDinput");
		url = "/ViewBills.jsp";
		BillsErrMsgs searchBillErrMsgs = new BillsErrMsgs();
		BillsModel billsModel = new BillsModel(ItemID);
		billsModel.validatePastBill(billsModel, searchBillErrMsgs, "");
		
		if(!searchBillErrMsgs.getErrorMsg().equals("")){
			request.setAttribute("SearchBillErrMsg",searchBillErrMsgs.getPastBillErrMsg());
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		
		else{
			List<BillsModel> listbill = billsdao.listBill(ItemID);
	        List<BillsModel> listbillTotal = billsdao.listBillTotal(ItemID);
	        request.setAttribute("listbill", listbill);
	        request.setAttribute("listbillTotal", listbillTotal);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBills.jsp");
	        dispatcher.forward(request, response);
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
