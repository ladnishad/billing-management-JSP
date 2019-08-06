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
import models.AddBillErrMsgs;
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
			
			List<AddBillModel> listCurrItems = billsDAO.listCurrItems();
            List<AddBillModel> listCurrTotal = billsDAO.listCurrTotal();
            request.setAttribute("listCurrItems", listCurrItems);
            request.setAttribute("listCurrTotal", listCurrTotal);
            
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
        
        AddBillErrMsgs addBillErrMsgs = new AddBillErrMsgs();
        AddBillModel addBill = new AddBillModel(ItemName,ItemQty);
        addBill.validateCommonItem(addBill, addBillErrMsgs, "");
        
        if(!addBillErrMsgs.getErrorMsg().equals("")){
        	request.setAttribute("CItemErrMsg",addBillErrMsgs.getCommItemNameErrMsg());
        	request.setAttribute("CQtyErrMsg",addBillErrMsgs.getCommItemQtyErrMsg());
        	request.setAttribute("CerrMsgs",addBillErrMsgs.getErrorMsg());
        	//response.sendRedirect(url);
        	getServletContext().getRequestDispatcher("/Homepage.jsp").forward(request, response);
        }
        else{
        	billsDAO.insertCommon(ItemName,ItemQty,BillID);
            
            List<AddBillModel> listCurrItems = billsDAO.listCurrItems();
            List<AddBillModel> listCurrTotal = billsDAO.listCurrTotal();
            request.setAttribute("listCurrItems", listCurrItems);
            request.setAttribute("listCurrTotal", listCurrTotal);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
            dispatcher.forward(request, response);	
        }
        
    }
	
	private void insertPrivate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		String ItemName = request.getParameter("itemlistText");
        String ItemQty = request.getParameter("PersitemQty");
        String numOfUsers = request.getParameter("PersitemUsers");
        int num = Integer.parseInt(numOfUsers);
        
        AddBillErrMsgs addBillErrMsgs = new AddBillErrMsgs();
        AddBillModel addBill = new AddBillModel(ItemName,ItemQty,numOfUsers);
        
        
        if(num == 4){
        	String User1 = request.getParameter("mySelect0");
        	String User2 = request.getParameter("mySelect1");
        	String User3 = request.getParameter("mySelect2");
        	String User4 = request.getParameter("mySelect3");
        	
        	String qty1 = request.getParameter("qtyText0");
        	String qty2 = request.getParameter("qtyText1");
        	String qty3 = request.getParameter("qtyText2");
        	String qty4 = request.getParameter("qtyText3");
        	
        	AddBillModel addBillVer4 = new AddBillModel(User1,User2,User3,User4);
        	AddBillModel addBillVer4qty = new AddBillModel(qty1,qty2,qty3,qty4,ItemQty,ItemName);
        	
        	
        	addBill.validatePersonalItem(addBill, addBillErrMsgs, "");
        	addBillVer4.validate4Users(addBillVer4, addBillErrMsgs, "");
        	addBillVer4qty.validateQty4(addBillVer4qty, addBillErrMsgs, "");
        	
        	if(!addBillErrMsgs.getErrorMsg().equals("")){
            	request.setAttribute("PItemErrMsg",addBillErrMsgs.getPerItemNameErrMsg());
            	request.setAttribute("PQtyErrMsg",addBillErrMsgs.getPerItemQtyErrMsg());
            	request.setAttribute("PNumUsersErrMsg",addBillErrMsgs.getPerNumUsersErrMsg());
            	request.setAttribute("PSpecialUsrErrMsg",addBillErrMsgs.getPerSpecialUsrErrMsg());
        		request.setAttribute("PSpecialQtyErrMsg",addBillErrMsgs.getPerSpecialQtyErrMsg());
        		//response.sendRedirect(url);
            	getServletContext().getRequestDispatcher("/Homepage.jsp").forward(request, response);
            }
        	
        	else{
        		String BillID = constructBillId();
        		
        		billsDAO.insertPersonalFour(ItemName,ItemQty,numOfUsers,User1,User2,User3,User4,qty1,qty2,qty3,qty4,BillID);
                
                List<AddBillModel> listCurrItems = billsDAO.listCurrItems();
                List<AddBillModel> listCurrTotal = billsDAO.listCurrTotal();
                request.setAttribute("listCurrItems", listCurrItems);
                request.setAttribute("listCurrTotal", listCurrTotal);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
                dispatcher.forward(request, response);
        	}
        	
        }
        
        else if(num == 3){
            	String User1 = request.getParameter("mySelect0");
            	String User2 = request.getParameter("mySelect1");
            	String User3 = request.getParameter("mySelect2");
            	
            	String qty1 = request.getParameter("qtyText0");
            	String qty2 = request.getParameter("qtyText1");
            	String qty3 = request.getParameter("qtyText2");
            	
            	AddBillModel addBillVer3 = new AddBillModel(User1,User2,User3,2);
            	AddBillModel addBillVer3qty = new AddBillModel(qty1,qty2,qty3,ItemQty,2);
            	
            	addBill.validatePersonalItem(addBill, addBillErrMsgs, "");
            	addBillVer3.validate3Users(addBillVer3, addBillErrMsgs, "");
            	addBillVer3qty.validateQty3(addBillVer3qty, addBillErrMsgs, "");
            	
            	if(!addBillErrMsgs.getErrorMsg().equals("")){
                	request.setAttribute("PItemErrMsg",addBillErrMsgs.getPerItemNameErrMsg());
                	request.setAttribute("PQtyErrMsg",addBillErrMsgs.getPerItemQtyErrMsg());
                	request.setAttribute("PNumUsersErrMsg",addBillErrMsgs.getPerNumUsersErrMsg());
                	request.setAttribute("PSpecialUsrErrMsg",addBillErrMsgs.getPerSpecialUsrErrMsg());
            		request.setAttribute("PSpecialQtyErrMsg",addBillErrMsgs.getPerSpecialQtyErrMsg());
            		//response.sendRedirect(url);
                	getServletContext().getRequestDispatcher("/Homepage.jsp").forward(request, response);
                }
            	
            	else{
            		String BillID = constructBillId();
                	
                	billsDAO.insertPersonalThree(ItemName,ItemQty,numOfUsers,User1,User2,User3,qty1,qty2,qty3,BillID);
                        
                    List<AddBillModel> listCurrItems = billsDAO.listCurrItems();
                    List<AddBillModel> listCurrTotal = billsDAO.listCurrTotal();
                    request.setAttribute("listCurrItems", listCurrItems);
                    request.setAttribute("listCurrTotal", listCurrTotal);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
                    dispatcher.forward(request, response);
            	}
            	
            }
            
            else if(num == 2){
            	String User1 = request.getParameter("mySelect0");
            	String User2 = request.getParameter("mySelect1");
            	
            	String qty1 = request.getParameter("qtyText0");
            	String qty2 = request.getParameter("qtyText1");
            	
            	//AddBillModel addBillVer2 = new AddBillModel(User1,User2,qty1,qty2,ItemQty);
            	
            	AddBillModel addBillVer2 = new AddBillModel(User1,User2,2);
            	AddBillModel addBillVer2qty = new AddBillModel(qty1,qty2,ItemQty,2.5);
            	
            	addBill.validatePersonalItem(addBill, addBillErrMsgs, "");
            	addBillVer2.validate2Users(addBillVer2, addBillErrMsgs, "");
            	addBillVer2qty.validateQty2(addBillVer2qty, addBillErrMsgs, "");
            	
            	if(!addBillErrMsgs.getErrorMsg().equals("")){
                	request.setAttribute("PItemErrMsg",addBillErrMsgs.getPerItemNameErrMsg());
                	request.setAttribute("PQtyErrMsg",addBillErrMsgs.getPerItemQtyErrMsg());
                	request.setAttribute("PNumUsersErrMsg",addBillErrMsgs.getPerNumUsersErrMsg());
                	request.setAttribute("PSpecialUsrErrMsg",addBillErrMsgs.getPerSpecialUsrErrMsg());
            		request.setAttribute("PSpecialQtyErrMsg",addBillErrMsgs.getPerSpecialQtyErrMsg());
            		//response.sendRedirect(url);
                	getServletContext().getRequestDispatcher("/Homepage.jsp").forward(request, response);
                }
            	
            	else{
            		String BillID = constructBillId();
            		billsDAO.insertPersonalTwo(ItemName,ItemQty,numOfUsers,User1,User2,qty1,qty2,BillID);
                	
                	//System.out.println(ItemName+","+ItemQty+","+numOfUsers+","+User1+","+User2+","+qty1+","+qty2+","+BillID);
                    
                    List<AddBillModel> listCurrItems = billsDAO.listCurrItems();
                    List<AddBillModel> listCurrTotal = billsDAO.listCurrTotal();
                    request.setAttribute("listCurrItems", listCurrItems);
                    request.setAttribute("listCurrTotal", listCurrTotal);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
                    dispatcher.forward(request, response);
            	}
            }
            
            else if(num == 1){
            	String User1 = request.getParameter("mySelect0");
            	
            	String qty1 = request.getParameter("qtyText0");
            	
            	AddBillModel addBillVer1 = new AddBillModel(User1,2);
            	AddBillModel addBillVer1qty = new AddBillModel(qty1,ItemQty,2.5);
            	
            	addBill.validatePersonalItem(addBill, addBillErrMsgs, "");
            	addBillVer1qty.validateQty1(addBillVer1qty, addBillErrMsgs, "");
            	
            	if(!addBillErrMsgs.getErrorMsg().equals("")){
                	request.setAttribute("PItemErrMsg",addBillErrMsgs.getPerItemNameErrMsg());
                	request.setAttribute("PQtyErrMsg",addBillErrMsgs.getPerItemQtyErrMsg());
                	request.setAttribute("PNumUsersErrMsg",addBillErrMsgs.getPerNumUsersErrMsg());
                	request.setAttribute("PSpecialUsrErrMsg",addBillErrMsgs.getPerSpecialUsrErrMsg());
            		request.setAttribute("PSpecialQtyErrMsg",addBillErrMsgs.getPerSpecialQtyErrMsg());
            		//response.sendRedirect(url);
                	getServletContext().getRequestDispatcher("/Homepage.jsp").forward(request, response);
                }
            	
            	else{
            		String BillID = constructBillId();
                	billsDAO.insertPersonalOne(ItemName,ItemQty,numOfUsers,User1,qty1,BillID);
                        
                    List<AddBillModel> listCurrItems = billsDAO.listCurrItems();
                    List<AddBillModel> listCurrTotal = billsDAO.listCurrTotal();
                    request.setAttribute("listCurrItems", listCurrItems);
                    request.setAttribute("listCurrTotal", listCurrTotal);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
                    dispatcher.forward(request, response);
            	}
            	
            	
            }
            	
        	
        }
     
	
	private void deleteBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		billsDAO.deleteBill();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
        dispatcher.forward(request, response);
    }
	
	private void submitBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		billsDAO.submitBill();
        
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
			break;
		case "addPersonal":
			try{
				insertPrivate(request,response);
			}catch(SQLException e){
				e.printStackTrace();
			}
			break;
		case "deleteBill":
			try{
				deleteBill(request,response);
			}catch(SQLException e){
				e.printStackTrace();
			}
			break;
		case "submitBill":
			try{
				submitBill(request,response);
			}catch(SQLException e){
				e.printStackTrace();
			}
			break;
			
        default:
        	//response.sendRedirect("Homepage.jsp");
            break;
        }
	}

}
