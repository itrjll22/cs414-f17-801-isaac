package edu.colostate.cs.cs414.project.models;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import edu.colostate.cs.cs414.project.utilities.SecurityUtility;

@Entity
public class UserAccount {

	
	private String id;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "userAccount", cascade = CascadeType.ALL, optional = true)
	private Trainer trainer;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "userAccount", cascade = CascadeType.ALL, optional = true)
	private Manager manager;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "userAccount", cascade = CascadeType.ALL, optional = true)
	private Customer customer;
	
	@Id
	@Column(unique = true)
	private String username;
	private byte[] salt;
	private byte[] passwordHash;
	
	@Transient
	private Set<Enum_Role> roles;
	
	public UserAccount(){
	
		this.fillEnumRoles();
		
	}
	
	public UserAccount(String username, String password){
		this.id = java.util.UUID.randomUUID().toString();
		
		this.username = username;
		
		this.salt = SecurityUtility.getSalt();
		
		this.passwordHash = SecurityUtility.hashPassword(password.toCharArray(), this.salt, 256, 256);
		
		this.fillEnumRoles();
		
	}
	
	public UserAccount(String username, String password, Set<Enum_Role> roles){
		this.id = java.util.UUID.randomUUID().toString();
		
		this.username = username;
		
		this.roles = roles;
		
		this.salt = SecurityUtility.getSalt();
		
		this.passwordHash = SecurityUtility.hashPassword(password.toCharArray(), this.salt, 256, 256);
		
		this.fillEnumRoles();
		
	}
	
	public void setPassword(String password){
		
		this.salt = SecurityUtility.getSalt();
		
		this.passwordHash = SecurityUtility.hashPassword(password.toCharArray(), this.salt, 256, 256);
	}
	
	protected void fillEnumRoles(){
		
		this.roles = new HashSet<Enum_Role>();
		
		if(this.manager != null){
			this.roles.add(Enum_Role.Manager);
		}
		
		if(this.trainer != null){
			this.roles.add(Enum_Role.Trainer);
		}
		
		if(this.customer != null){
			this.roles.add(Enum_Role.Customer);
		}
		
	}
	
	public UserSecurityContext toSecurityContext(){
		
		this.fillEnumRoles();
		
		return new UserSecurityContext(this.roles, this.username);
	
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public byte[] getSalt() {
		return salt;
	}


	public void setSalt(byte[] salt) {
		this.salt = salt;
	}


	public byte[] getPasswordHash() {
		return passwordHash;
	}


	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(passwordHash);
		result = prime * result + Arrays.hashCode(salt);
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		
		if (!Arrays.equals(passwordHash, other.passwordHash))
			return false;
		
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!Arrays.equals(salt,other.salt))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
