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

import edu.colostate.cs.cs414.project.utilities.SecurityUtility;

@Entity
public class UserAccount {

	
	private String id;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "userAccount", cascade = CascadeType.ALL, optional = true)
	Trainer trainer;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "userAccount", cascade = CascadeType.ALL, optional = true)
	Manager manager;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "userAccount", cascade = CascadeType.ALL, optional = true)
	Customer customer;
	
	@Id
	@Column(unique = true)
	private String username;
	private byte[] salt;
	private byte[] passwordHash;
	
	@ManyToMany(
	        targetEntity=Role.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
	    )
	    @JoinTable(
	        name="UserAccount_Role",
	        joinColumns=@JoinColumn(name="userAccount_id"),
	        inverseJoinColumns=@JoinColumn(name="role_id")
	    )
	private Set<Role> roles;
	
	public UserAccount(){
		
	}
	
	public UserAccount(String username, String password){
		this.id = java.util.UUID.randomUUID().toString();
		
		this.username = username;
		
		this.salt = SecurityUtility.getSalt();
		
		this.passwordHash = SecurityUtility.hashPassword(password.toCharArray(), this.salt, 256, 256);
	}
	
	public UserAccount(String username, String password, Set<Role> roles){
		this.id = java.util.UUID.randomUUID().toString();
		
		this.username = username;
		
		this.roles = roles;
		
		this.salt = SecurityUtility.getSalt();
		
		this.passwordHash = SecurityUtility.hashPassword(password.toCharArray(), this.salt, 256, 256);
	}
	
	public UserSecurityContext toSecurityContext(){

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
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
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
		} else if (!salt.equals(other.salt))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
