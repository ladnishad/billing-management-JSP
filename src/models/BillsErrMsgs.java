package models;

public class BillsErrMsgs {
	private String PastBillErrMsg;
	private String errorMsg;
	
	public BillsErrMsgs(String PastBillErrMsg, String errorMsg) {
		super();
		
		this.PastBillErrMsg = PastBillErrMsg;
		this.errorMsg = errorMsg;
	}
	
	public BillsErrMsgs() {
		super();
		
		this.PastBillErrMsg = "";
		this.errorMsg = "";
	}
	
	
	public String getPastBillErrMsg() {
		return PastBillErrMsg;
	}
	public void setPastBillErrMsg(String PastBillErrMsg) {
		this.PastBillErrMsg = PastBillErrMsg;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;	
	}
}
