package models;


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

}
