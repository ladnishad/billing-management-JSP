package models;

import java.sql.SQLException;

import data.BillsDAO;

public class BillsModel {
	String BillID;
	String BillItem;
	String HarshitCost;
	String HarishCost;
	String DeepCost;
	String NishadCost;
	String TotalCost;
	String HarshitTotal;
	String HarishTotal;
	String DeepTotal;
	String NishadTotal;
	String Total;
	String TotalQty;
	
	public BillsModel(String BillID){
		super();
		
		this.BillID = BillID;
	}
	
	public BillsModel(String BillID, String BillItem, String HarshitCost, String HarishCost, String DeepCost, String NishadCost, String TotalCost, 
			String HarshitTotal,
			String HarishTotal,
			String DeepTotal,
			String NishadTotal,
			String Total,
			String TotalQty){
		super();
		this.BillID = BillID;
		this.BillItem = BillItem;
		this.HarshitCost = HarshitCost;
		this.HarishCost = HarishCost;
		this.DeepCost = DeepCost;
		this.NishadCost = NishadCost;
		this.TotalCost = TotalCost;
		this.HarshitTotal = HarshitTotal;
		this.HarishTotal = HarishTotal;
		this.DeepTotal = DeepTotal;
		this.NishadTotal = NishadTotal;
		this.Total = Total;
		this.TotalQty = TotalQty;
	}
	
	public BillsModel(String BillID, String BillItem, String HarshitCost, String HarishCost, String DeepCost, String NishadCost, String TotalCost, 
			String TotalQty){
		super();
		this.BillID = BillID;
		this.BillItem = BillItem;
		this.HarshitCost = HarshitCost;
		this.HarishCost = HarishCost;
		this.DeepCost = DeepCost;
		this.NishadCost = NishadCost;
		this.TotalCost = TotalCost;
		this.TotalQty = TotalQty;
	}
	
	public BillsModel( 
			String HarshitTotal,
			String HarishTotal,
			String DeepTotal,
			String NishadTotal,
			String Total){
		super();
		this.HarshitTotal = HarshitTotal;
		this.HarishTotal = HarishTotal;
		this.DeepTotal = DeepTotal;
		this.NishadTotal = NishadTotal;
		this.Total = Total;
		}
	
	public BillsModel(){}
	
	public String getBillID(){
		return BillID;
	}
	
	public void setBillID(String BillID){
		this.BillID = BillID;
	}
	
	public String getTotalQty(){
		return TotalQty;
	}
	
	public void setTotalQty(String TotalQty){
		this.TotalQty = TotalQty;
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
	
	public String getTotalCost(){
		return TotalCost;
	}
	
	public void setTotalCost(String TotalCost){
		this.TotalCost = TotalCost;
	}
	
	public String getHarshitTotal(){
		return HarshitTotal;
	}
	
	public void setHarshitTotal(String HarshitTotal){
		this.HarshitTotal = HarshitTotal;
	}
	
	public String getHarishTotal(){
		return HarishTotal;
	}
	
	public void setHarishTotal(String HarishTotal){
		this.HarishTotal = HarishTotal;
	}
	
	public String getDeepTotal(){
		return DeepTotal;
	}
	
	public void setDeepTotal(String DeepTotal){
		this.DeepTotal = DeepTotal;
	}
	
	public String getNishadTotal(){
		return NishadTotal;
	}
	
	public void setNishadTotal(String NishadTotal){
		this.NishadTotal = NishadTotal;
	}
	
	public String getTotal(){
		return Total;
	}
	
	public void setTotal(String Total){
		this.Total = Total;
	}
	
	
	public void validatePastBill(BillsModel billModel,BillsErrMsgs errMsgs,String isBill){
		errMsgs.setPastBillErrMsg(validateInput(billModel.getBillID()));
		String PastBillErrMsg = errMsgs.getPastBillErrMsg();
		
		if(!PastBillErrMsg.equals("")){
			errMsgs.setErrorMsg("Please correct the following errors");
		}
		
	}
	
	public String validateInput(String billID){
		String result = "";
		if(billID.equals("")){
			result = "Please enter the Bill ID.";
		}
		
		else if(specialCharPresent(billID)){
			result = "No special character or alphabets allowed. Valid input ex: 08041923123";
		} else
			try {
				if(!BillsDAO.verifyBillPresent(billID)){
					result = "Bill does not exist.";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	public boolean specialCharPresent(String billid){
		boolean isPresent = false;
		String lowBillID = billid.toLowerCase();
		char[] array = lowBillID.toCharArray();
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
