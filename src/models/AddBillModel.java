package models;

import java.sql.SQLException;

import data.AddItemDAO;

public class AddBillModel {
	String BillsID;
	String BillItem;
	String HarshitCost;
	String HarshitCostTotal;
	String HarishCost;
	String HarishCostTotal;
	String DeepCost;
	String DeepCostTotal;
	String NishadCost;
	String NishadCostTotal;
	String TotalQty;
	String TotalCost;
	String Total;
	String user1;
	String user2;
	String user3;
	String user4;
	String user1qty;
	String user2qty;
	String user3qty;
	String user4qty;
	
	public AddBillModel(String BillItem,String TotalQty,String Total,String user1,String user2,String user3, String user4,
			String user1qty,String user2qty,String user3qty,String user4qty){
		super();
		this.BillItem = BillItem;
		this.TotalQty = TotalQty;
		this.Total = Total;
		this.user1 = user1;
		this.user2 = user2;
		this.user3 = user3;
		this.user4 = user4;
		this.user1qty = user1qty;
		this.user2qty = user2qty;
		this.user3qty = user3qty;
		this.user4qty = user4qty;
	}
	
	public AddBillModel(String user1,String user2,String user3,String user4){
		super();
		
		this.user1 = user1;
		this.user2 = user2;
		this.user3 = user3;
		this.user4 = user4;
	}
	
	public AddBillModel(String user1,String user2,String user3,int user4){
		super();
		
		this.user1 = user1;
		this.user2 = user2;
		this.user3 = user3;
	}
	
	public AddBillModel(String user1,String user2,int user4){
		super();
		
		this.user1 = user1;
		this.user2 = user2;
	}
	
	public AddBillModel(String user1,int user4){
		super();
		
		this.user1 = user1;
	}
	
	public AddBillModel(String user1qty,String user2qty,String user3qty,String user4qty,String TotalQty,String BillItem){
		this.user1qty = user1qty;
		this.user2qty = user2qty;
		this.user3qty = user3qty;
		this.user4qty = user4qty;
		this.TotalQty = TotalQty;
		this.BillItem = BillItem;
	}
	
	public AddBillModel(String user1qty,String user2qty,String user3qty,String TotalQty, int num){
		this.user1qty = user1qty;
		this.user2qty = user2qty;
		this.user3qty = user3qty;
		this.TotalQty = TotalQty;
	}
	
	public AddBillModel(String user1qty,String user2qty,String TotalQty, double num){
		this.user1qty = user1qty;
		this.user2qty = user2qty;
		this.TotalQty = TotalQty;
	}
	
	public AddBillModel(String user1qty,String TotalQty, double num){
		this.user1qty = user1qty;
		this.TotalQty = TotalQty;
	}
	
	
	public AddBillModel(String BillItem,String TotalQty,String Total,String user1,String user2,String user3,
			String user1qty,String user2qty,String user3qty){
		super();
		this.BillItem = BillItem;
		this.TotalQty = TotalQty;
		this.Total = Total;
		this.user1 = user1;
		this.user2 = user2;
		this.user3 = user3;
		this.user1qty = user1qty;
		this.user2qty = user2qty;
		this.user3qty = user3qty;
	}
	
	public AddBillModel(String BillItem,String TotalQty,String Total,String user1,String user2,
			String user1qty,String user2qty){
		super();
		this.BillItem = BillItem;
		this.TotalQty = TotalQty;
		this.Total = Total;
		this.user1 = user1;
		this.user2 = user2;
		this.user1qty = user1qty;
		this.user2qty = user2qty;
	}
	
	
	public AddBillModel(String BillsID, String BillItem, String HarshitCost, String HarishCost, String DeepCost, 
	String NishadCost, String TotalQty, String TotalCost){
		super();
		this.BillsID = BillsID;
		this.BillItem = BillItem;
		this.HarshitCost = HarshitCost;
		this.HarishCost = HarishCost;
		this.DeepCost = DeepCost;
		this.NishadCost = NishadCost;
		this.TotalQty = TotalQty;
		this.TotalCost = TotalCost;
	}
	
	public AddBillModel(String HarshitCostTotal, String HarishCostTotal, String DeepCostTotal, 
			String NishadCostTotal, String Total){
				super();
				this.HarshitCostTotal = HarshitCostTotal;
				this.HarishCostTotal = HarishCostTotal;
				this.DeepCostTotal = DeepCostTotal;
				this.NishadCostTotal = NishadCostTotal;
				this.Total = Total;
			}
	
	public AddBillModel(String BillItem,String TotalQty,String Total){
		super();
		this.BillItem = BillItem;
		this.TotalQty = TotalQty;
		this.Total = Total;
	}
	
	public AddBillModel(String TotalQty){
		super();
		this.TotalQty = TotalQty;
	}
	
	public AddBillModel(String BillItem,String TotalQty){
		super();
		this.BillItem = BillItem;
		this.TotalQty = TotalQty;
	}
	
	public AddBillModel(){}
	
	public String getUser1(){
		return user1;
	}
	
	public void setUser1(String user1){
		this.user1 = user1;
	}
	
	public String getUser2(){
		return user2;
	}
	
	public void setUser2(String user2){
		this.user2 = user2;
	}
	
	public String getUser3(){
		return user3;
	}
	
	public void setUser3(String user3){
		this.user3 = user3;
	}
	
	public String getUser4(){
		return user4;
	}
	
	public void setUser4(String user4){
		this.user4 = user4;
	}
	
	public String getUser1qty(){
		return user1qty;
	}
	
	public void setUser1qty(String user1qty){
		this.user1qty = user1qty;
	}
	
	public String getUser2qty(){
		return user2qty;
	}
	
	public void setUser2qty(String user2qty){
		this.user2qty = user2qty;
	}
	
	public String getUser3qty(){
		return user3qty;
	}
	
	public void setUser3qty(String user3qty){
		this.user3qty = user3qty;
	}
	
	public String getUser4qty(){
		return user4qty;
	}
	
	public void setUser4qty(String user4qty){
		this.user4qty = user4qty;
	}
	
	public String getBillsID(){
		return BillsID;
	}
	
	public void setBillsID(String BillsID){
		this.BillsID = BillsID;
	}
	public String getBillItem(){
		return BillItem;
	}
	
	public void setBillItem(String BillItem){
		this.BillItem = BillItem;
	}
	public String getHarshitCost(){
		return HarshitCost;
	}
	
	public void setHarshitCost(String HarshitCost){
		this.HarshitCost = HarshitCost;
	}
	public String getHarishCost(){
		return HarishCost;
	}
	
	public void setHarishCost(String HarishCost){
		this.HarishCost = HarishCost;
	}
	public String getDeepCost(){
		return DeepCost;
	}
	
	public void setDeepCost(String DeepCost){
		this.DeepCost = DeepCost;
	}
	public String getNishadCost(){
		return NishadCost;
	}
	
	public void setNishadCost(String NishadCost){
		this.NishadCost = NishadCost;
	}
	public String getTotalQty(){
		return TotalQty;
	}
	
	public void setTotalQty(String TotalQty){
		this.TotalQty = TotalQty;
	}
	public String getTotalCost(){
		return TotalCost;
	}
	
	public void setTotalCost(String TotalCost){
		this.TotalCost = TotalCost;
	}
	
	public String getHarshitCostTotal(){
		return HarshitCostTotal;
	}
	
	public void setHarshitCostTotal(String HarshitCostTotal){
		this.HarshitCostTotal = HarshitCostTotal;
	}
	
	public String getHarishCostTotal(){
		return HarishCostTotal;
	}
	
	public void setHarishCostTotal(String HarishCostTotal){
		this.HarishCostTotal = HarishCostTotal;
	}
	
	public String getDeepCostTotal(){
		return DeepCostTotal;
	}
	
	public void setDeepCostTotal(String DeepCostTotal){
		this.DeepCostTotal = DeepCostTotal;
	}
	
	public String getNishadCostTotal(){
		return NishadCostTotal;
	}
	
	public void setNishadCostTotal(String NishadCostTotal){
		this.NishadCostTotal = NishadCostTotal;
	}
	
	public String getTotal(){
		return Total;
	}
	
	public void setTotal(String Total){
		this.Total = Total;
	}
	
	public void validateCommonItem(AddBillModel addBill,AddBillErrMsgs errMsgs, String isCom){
		errMsgs.setCommItemNameErrMsg(validateComItemName(addBill.getBillItem()));
		String CommItemNameErrMsg = errMsgs.getCommItemNameErrMsg();
		errMsgs.setCommItemQtyErrMsg(validateComItemQty(addBill.getTotalQty()));
		String CommItemQtyErrMsg = errMsgs.getCommItemQtyErrMsg();
		
		if(!CommItemNameErrMsg.equals("")||!CommItemQtyErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public void validatePersonalItem(AddBillModel addBill, AddBillErrMsgs errMsgs, String isPer){
		errMsgs.setPerItemNameErrMsg(validateComItemName(addBill.getBillItem()));
		String PerItemNameErrMsg = errMsgs.getPerItemNameErrMsg();
		
		errMsgs.setPerItemQtyErrMsg(validateComItemQty(addBill.getTotalQty()));
		String PerItemQtyErrMsg = errMsgs.getPerItemQtyErrMsg();
		
		errMsgs.setPerNumUsersErrMsg(validatePerNumUsers(addBill.getTotal()));
		String PerNumUsersErrMsg = errMsgs.getPerNumUsersErrMsg();
		
		if(!PerItemNameErrMsg.equals("")||!PerItemQtyErrMsg.equals("")||!PerNumUsersErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public void validate4Users(AddBillModel addBill,AddBillErrMsgs errMsgs, String isName){
		errMsgs.setPerSpecialUsrErrMsg(validate4UserNames(addBill.getUser1(),addBill.getUser2(),addBill.getUser3(),addBill.getUser4()));
		String PerSpecial4ErrMsg = errMsgs.getPerSpecialUsrErrMsg();
		
		if(!PerSpecial4ErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public void validate3Users(AddBillModel addBill,AddBillErrMsgs errMsgs, String isName){
		errMsgs.setPerSpecialUsrErrMsg(validate3UserNames(addBill.getUser1(),addBill.getUser2(),addBill.getUser3()));
		String PerSpecial3ErrMsg = errMsgs.getPerSpecialUsrErrMsg();
		
		if(!PerSpecial3ErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public void validate2Users(AddBillModel addBill,AddBillErrMsgs errMsgs, String isName){
		errMsgs.setPerSpecialUsrErrMsg(validate2UserNames(addBill.getUser1(),addBill.getUser2()));
		String PerSpecial2ErrMsg = errMsgs.getPerSpecialUsrErrMsg();
		
		if(!PerSpecial2ErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public void validateQty4(AddBillModel addBill,AddBillErrMsgs errMsgs, String isQty){
		errMsgs.setPerSpecialQtyErrMsg(validate4qty(addBill.getUser1qty(),addBill.getUser2qty(),addBill.getUser3qty(),addBill.getUser4qty(),addBill.getTotalQty(),"abc"));
		String PerSpecial4QtyErrMsg = errMsgs.getPerSpecialQtyErrMsg();
		
		System.out.println(PerSpecial4QtyErrMsg);
		
		if(!PerSpecial4QtyErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public void validateQty3(AddBillModel addBill,AddBillErrMsgs errMsgs, String isQty){
		errMsgs.setPerSpecialQtyErrMsg(validate3qty(addBill.getUser1qty(),addBill.getUser2qty(),addBill.getUser3qty(),addBill.getTotalQty(),3));
		String PerSpecial3QtyErrMsg = errMsgs.getPerSpecialQtyErrMsg();
		
		if(!PerSpecial3QtyErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public void validateQty2(AddBillModel addBill,AddBillErrMsgs errMsgs, String isQty){
		errMsgs.setPerSpecialQtyErrMsg(validate2qty(addBill.getUser1qty(),addBill.getUser2qty(),addBill.getTotalQty(),2.5));
		String PerSpecial2QtyErrMsg = errMsgs.getPerSpecialQtyErrMsg();
		
		if(!PerSpecial2QtyErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public void validateQty1(AddBillModel addBill,AddBillErrMsgs errMsgs, String isQty){
		errMsgs.setPerSpecialQtyErrMsg(validate1qty(addBill.getUser1qty(),addBill.getTotalQty(),2.5));
		String PerSpecial1QtyErrMsg = errMsgs.getPerSpecialQtyErrMsg();
		
		if(!PerSpecial1QtyErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the above errors.");
		}
		else{
			errMsgs.setErrorMsg("");
		}
	}
	
	public String validate4UserNames(String User1,String User2,String User3,String User4){
		String result = "";
		
		if(User1.equals(User2)||User1.equals(User3)||User1.equals(User4)){
			result = "Usernames should be different.";
		}
		else if(User2.equals(User3)||User2.equals(User4)){
			result = "Usernames should be different.";
		}
		else if(User3.equals(User4)){
			result = "Usernames should be different.";
		}
		
		else{
			result = "";
		}
		
		return result;
	}
	
	public String validate3UserNames(String User1,String User2,String User3){
		String result = "";
		
		if(User1.equals(User2)||User1.equals(User3)){
			result = "Usernames should be different.";
		}
		else if(User2.equals(User3)){
			result = "Usernames should be different.";
		}
		else{
			result = "";
		}
		
		return result;
	}
	
	public String validate2UserNames(String User1,String User2){
		String result = "";
		
		if(User1.equals(User2)){
			result = "Usernames should be different.";
		}
		else{
			result = "";
		}
		
		return result;
	}
	
	public String validate4qty(String User1qty,String User2qty,String User3qty,String User4qty,String TotalQty,String abc){
		String result = "";
		
		if(User1qty.equals("") || User2qty.equals("") || User3qty.equals("") || User4qty.equals("")){
			result = "Personal quantity cannot be null.";
		}
		
		else if((Integer.parseInt(User1qty)+Integer.parseInt(User2qty)+Integer.parseInt(User3qty)+Integer.parseInt(User4qty)) != (Integer.parseInt(TotalQty))){
			result = "Sum of quantities should be equal to TotalQty.";	
		}
		else{
			result = "";
		}
		
		return result;
	}
	
	public String validate3qty(String User1qty,String User2qty,String User3qty,String TotalQty,int num){
		String result = "";
		if(User1qty.equals("") || User2qty.equals("") || User3qty.equals("")){
			result = "Personal quantity cannot be null.";
		}
		else if((Integer.parseInt(User1qty)+Integer.parseInt(User2qty)+Integer.parseInt(User3qty)) != (Integer.parseInt(TotalQty))){
			result = "Sum of quantities should be equal to TotalQty.";
		}
		else{
			result = "";
		}
		
		return result;
	}
	
	public String validate2qty(String User1qty,String User2qty,String TotalQty,double num){
		String result = "";
		if(User1qty.equals("") || User2qty.equals("")){
			result = "Personal quantity cannot be null.";
		}
		else if((Integer.parseInt(User1qty)+Integer.parseInt(User2qty)) != (Integer.parseInt(TotalQty))){
			result = "Sum of quantities should be equal to TotalQty.";
		}
		else{
			result = "";
		}
		
		return result;
	}
	
	public String validate1qty(String User1qty,String TotalQty,double num){
		String result = "";
		if(User1qty.equals("")){
			result = "Personal quantity cannot be null.";
		}
		else if((Integer.parseInt(User1qty)) != (Integer.parseInt(TotalQty))){
			result = "Sum of quantities should be equal to TotalQty.";
		}
		else{
			result = "";
		}
		
		return result;
	}
	
	public String validatePerNumUsers(String numUsers){
		String result = "";
		
		if(numUsers.equals("")){
			result = "Please enter number of users and click add users.";
		}
		
		else if(isCharPresent(numUsers)){
			result = "Invalid input. Valid input ranges from 1 to 4.";
		}
		else if(Integer.parseInt(numUsers)>4){
			result = "Input cannot be 0 or greater than 4.";
		}
		
		return result;
	}
	
	public String validateComItemName(String CommItemName){
		String result = "";
		
		
		if(CommItemName.equals("")){
			result = "Please select an item.";
		} else
			try {
				if(!AddItemDAO.verifyItemName(CommItemName)){
					result = "Item not found in database.";
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	public String validateComItemQty(String CommItemQty){
		String result = "";
		if(CommItemQty.equals("")){
			result = "Please enter the quantity.";
		}
		
		else if(isCharPresent(CommItemQty)){
			result = "Invalid input. Valid input ex: 2.";
		}
		return result;
	}
	
	public boolean isCharPresent(String CommItemQty){
		boolean isPresent = false;
		String lowQty = CommItemQty.toLowerCase();
		
		char[] array = lowQty.toCharArray();
		char[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','\'','~', '!', '@', '#','$','%','^','&','*','(',')','_','-','+','=','{','}','[',']',':',';','"','<','>','?','/','\\'};
		
		for(int i=0;i<characters.length;i++) {
			char a = characters[i];
			for(char b: array) {
				if (a == b){
					isPresent = true;
					break;
				}
			}
		}
	return isPresent;
	}
}
