package edu.colostate.cs.cs414.project.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserSecurityContext {

	private Set<Enum_Role> roles;
	private String username;
	private UserInformation userInformation;
	
	public UserSecurityContext(){
		
	}
	
	public UserSecurityContext(Set<Enum_Role> roles, String username){
		this.roles = roles;
		this.username = username;
		this.userInformation  = null;
	}
	
	public UserSecurityContext(Set<Enum_Role> roles, String username, UserInformation userInformation){
			this.roles = roles;
			this.username = username;
			this.userInformation  = userInformation;
	}
	
	public boolean hasRole(Enum_Role role){
		if(this.roles.contains(role)){
			return true;
		}else{
			return false;
		}
	}
	
}
