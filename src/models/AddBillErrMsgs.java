package models;

public class AddBillErrMsgs {
	private String CommItemNameErrMsg;
	private String CommItemQtyErrMsg;
	private String PerItemNameErrMsg;
	private String PerItemQtyErrMsg;
	private String PerNumUsersErrMsg;
	private String PerSpecialUsrErrMsg;
	private String PerSpecialQtyErrMsg;
	private String errorMsg;
	
	public AddBillErrMsgs(String CommItemNameErrMsg, String CommItemQtyErrMsg, String errorMsg) {
		super();
		
		this.CommItemNameErrMsg = CommItemNameErrMsg;
		this.CommItemQtyErrMsg = CommItemQtyErrMsg;
		this.errorMsg = errorMsg;
	}
	
	public AddBillErrMsgs(String PerItemNameErrMsg, String PerItemQtyErrMsg, String PerNumUsersErrMsg,String errorMsg) {
		super();
		
		this.PerItemNameErrMsg = PerItemNameErrMsg;
		this.PerItemQtyErrMsg = PerItemQtyErrMsg;
		this.PerNumUsersErrMsg = PerNumUsersErrMsg;
		this.errorMsg = errorMsg;
	}
	
	
	public AddBillErrMsgs() {
		super();
		
		this.CommItemNameErrMsg = "";
		this.CommItemQtyErrMsg = "";
		this.errorMsg = "";
	}
	
	public String getCommItemNameErrMsg(){
		return CommItemNameErrMsg;
	}
	
	public void setCommItemNameErrMsg(String CommItemNameErrMsg){
		this.CommItemNameErrMsg = CommItemNameErrMsg;
	}
	
	public String getCommItemQtyErrMsg(){
		return CommItemQtyErrMsg;
	}
	
	public void setCommItemQtyErrMsg(String CommItemQtyErrMsg){
		this.CommItemQtyErrMsg = CommItemQtyErrMsg;
	}
	
	public String getPerItemNameErrMsg(){
		return PerItemNameErrMsg;
	}
	
	public void setPerItemNameErrMsg(String PerItemNameErrMsg){
		this.PerItemNameErrMsg = PerItemNameErrMsg;
	}
	
	public String getPerItemQtyErrMsg(){
		return PerItemQtyErrMsg;
	}
	
	public void setPerItemQtyErrMsg(String PerItemQtyErrMsg){
		this.PerItemQtyErrMsg = PerItemQtyErrMsg;
	}
	
	public String getPerNumUsersErrMsg(){
		return PerNumUsersErrMsg;
	}
	
	public void setPerNumUsersErrMsg(String PerNumUsersErrMsg){
		this.PerNumUsersErrMsg = PerNumUsersErrMsg;
	}
	
	public String getPerSpecialUsrErrMsg() {
		return PerSpecialUsrErrMsg;
	}
	
	public void setPerSpecialUsrErrMsg(String PerSpecialUsrErrMsg) {
		this.PerSpecialUsrErrMsg = PerSpecialUsrErrMsg;	
	}
	
	public String getPerSpecialQtyErrMsg() {
		return PerSpecialQtyErrMsg;
	}
	
	public void setPerSpecialQtyErrMsg(String PerSpecialQtyErrMsg) {
		this.PerSpecialQtyErrMsg = PerSpecialQtyErrMsg;	
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;	
	}
}
