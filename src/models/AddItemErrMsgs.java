package models;

public class AddItemErrMsgs {
	private String ItemNameErrMsg;
	private String ItemCostErrMsg;
	private String ItemCommErrMsg;
	private String errorMsg;
	
	
	public AddItemErrMsgs(String ItemNameErrMsg, String ItemCostErrMsg, String ItemCommErrMsg, String errorMsg) {
		super();
		
		this.ItemNameErrMsg = ItemNameErrMsg;
		this.errorMsg = errorMsg;
		this.ItemCostErrMsg = ItemCostErrMsg;
		this.ItemCommErrMsg = ItemCommErrMsg;
		
	}
	
	public AddItemErrMsgs() {
		super();
		
		this.ItemNameErrMsg = "";
		this.errorMsg = "";
		this.ItemCostErrMsg = "";
		this.ItemCommErrMsg = "";
		
			}
	
		public String getItemNameErrMsg() {
			return ItemNameErrMsg;
		}
		public void setItemNameErrMsg(String ItemNameErrMsg) {
			this.ItemNameErrMsg = ItemNameErrMsg;
		}
		
		public String getItemCostErrMsg() {
			return ItemCostErrMsg;
		}
		public void setItemCostErrMsg(String ItemCostErrMsg) {
			this.ItemCostErrMsg = ItemCostErrMsg;
		}
		
		public String getItemCommErrMsg() {
			return ItemCommErrMsg;
		}
		public void setItemCommErrMsg(String ItemCommErrMsg) {
			this.ItemCommErrMsg = ItemCommErrMsg;
		}
		
		public String getErrorMsg() {
			return errorMsg;
		}
		
		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
			
		}
		
}
	

