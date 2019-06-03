package models;

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
}
