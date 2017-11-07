package edu.colostate.cs.cs414.project.models;

public class Response {
	
	public boolean isSuccess;
	
	public String StatusText;
	
	public Object data;
	
	public Response(){
		this.isSuccess = false;
		this.StatusText = "";
		this.data = null;
	}
	
	public boolean isSuccss(){return isSuccess;}

}
