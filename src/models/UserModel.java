package models;

public class UserModel {
	String Username;
	
	public UserModel(String Username){
		super();
		this.Username = Username;
	}
			
	public UserModel(){}
			
	public String getUsername(){
		return Username;
	}
			
	public void setUsername(String Username){
		this.Username = Username;
	}
}
