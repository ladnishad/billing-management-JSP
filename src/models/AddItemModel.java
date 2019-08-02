package models;

import java.sql.SQLException;

import data.AddItemDAO;
import models.AddItemErrMsgs;

public class AddItemModel {
	String ItemID;
	String ItemName;
	String ItemCost;
	String ItemComm;
	
	public AddItemModel(String ItemID, String ItemName, String ItemCost,String ItemComm){
		super();
		this.ItemID = ItemID;
		this.ItemName = ItemName;
		this.ItemCost = ItemCost;
		this.ItemComm = ItemComm;
	}
	
	public AddItemModel(String ItemName, String ItemCost,String ItemComm){
		super();
		this.ItemName = ItemName;
		this.ItemCost = ItemCost;
		this.ItemComm = ItemComm;
	}
	
	public AddItemModel(String ItemID,String ItemName){
		super();
		this.ItemID = ItemID;
		this.ItemName = ItemName;
	}
	
	public AddItemModel(){}
	
	public String getItemID(){
		return ItemID;
	}
	
	public void setItemID(String ItemID){
		this.ItemID = ItemID;
	}
	
	public String getItemName(){
		return ItemName;
	}
	
	public void setItemName(String ItemName){
		this.ItemName = ItemName;
	}
	
	public String getItemCost(){
		return ItemCost;
	}
	
	public void setItemCost(String ItemCost){
		this.ItemCost = ItemCost;
	}
	
	public String getItemComm(){
		return ItemComm;
	}
	
	public void setItemComm(String ItemComm){
		this.ItemComm = ItemComm;
	}
	
	public void validateItem(AddItemModel addItem, AddItemErrMsgs errMsgs,String isItem){
		errMsgs.setItemNameErrMsg(validateItemName(addItem.getItemName()));
		String ItemNameErrMsg = errMsgs.getItemNameErrMsg();
		errMsgs.setItemCostErrMsg(validateItemCost(addItem.getItemCost()));
		String ItemCostErrMsg = errMsgs.getItemCostErrMsg();
		errMsgs.setItemCommErrMsg(validateItemComm(addItem.getItemComm()));
		String ItemCommErrMsg = errMsgs.getItemCommErrMsg();
		
		if (!ItemNameErrMsg.equals("") || !ItemCostErrMsg.equals("") || !ItemCommErrMsg.equals("") || 
				!ItemNameErrMsg.equals("") && !ItemCostErrMsg.equals("") || 
				!ItemNameErrMsg.equals("") && !ItemCommErrMsg.equals("") || 
				!ItemCostErrMsg.equals("") && !ItemCommErrMsg.equals("") || 
				!ItemNameErrMsg.equals("") && !ItemCostErrMsg.equals("") && !ItemCommErrMsg.equals(""))
		{
			errMsgs.setErrorMsg("Please correct the following errors");
		}
		else{
			errMsgs.setErrorMsg("");
			
		}
		//System.out.println(validateItemName(addItem.getItemName()));
	}
		

	
	public String validateItemName(String ItemName) {
		String result = "";
		
		if(ItemName.equals(""))
		{
			result = "Please enter a name for the item.";
		}
		
		else if(validateApos(ItemName)){
			result = "Please remove the apostrophe.";	
		}
		
		else
			try {
				if (AddItemDAO.verifyItemName(ItemName))
				{
					result="Item is already present in the database.";
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
	} 
		
	
	public String validateItemCost(String ItemCost) {
		String result = "";
		if((ItemCost.equals("")))
		{
			result = "Please enter the cost of the item.";
		}
		
		else if(validateSpecChars(ItemCost)){
			result = "Please don't enter any special characters or text input. Valid input Ex: 2.45.";
		}
		return result;
	}
	
	public String validateItemComm(String ItemComm) {
		String result = "";
		if(validateApos(ItemComm))
		{
			result = "Please remove the apostrophe.";
		}
		return result;
	}
	
	public boolean validateApos(String ItemName){
		char[] array=ItemName.toCharArray();
		char[] characters = {'\''};
		boolean hasApos = false;
				
		char a = characters[0];
			for(char b: array) {
				if (a == b)
				{
					hasApos = true;
					break;
				}
			}
			return hasApos;
	}
	
	public boolean validateSpecChars(String ItemCost){
		String lowItemCost = ItemCost.toLowerCase();
		char[] array=lowItemCost.toCharArray();
		char[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','\'','~', '!', '@', '#','$','%','^','&','*','(',')','_','-','+','=','{','}','[',']',':',';','"','<','>','?','/','\\'};
		boolean hasChars = false;
		
		for(int i=0;i<characters.length;i++) {
			char a = characters[i];
			for(char b: array) {
				if (a == b){
					hasChars = true;
					break;
				}
			}
		}
		return hasChars;
	}

}
