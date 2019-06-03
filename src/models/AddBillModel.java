package models;

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

}
