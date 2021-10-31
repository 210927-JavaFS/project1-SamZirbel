package com.revature.models;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//@Entity
public class Login {
	
	@Id
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "accountId")
	private List<Account> accounts;

	
	
	public Login(String username, String password, List<Account> accounts) {
		super();
		this.username = username;
		this.password = password;
		
		//if (accounts != null) { this.accounts = accounts; }
		//else { 
			/*
			List<Account> emptyList = null; 
			Account account = null;
			emptyList.add(account);
			accounts = emptyList;
			*/
			
			List<Account> list = Arrays.asList(new Account("Filler", "Filler", "Filler", null));
			accounts = list;
		
		//}
		
	}
	

	public Login() {
		super();
	}

	public Login(String password, List<Account> accounts) {
		super();
		this.password = password;
		
		//if (accounts != null) { this.accounts = accounts; }
		//else { 
			/*
			List<Account> emptyList = null; 
			Account account = null;
			emptyList.add(account);
			accounts = emptyList;
			*/
			
			List<Account> list = Arrays.asList(new Account("Filler", "Filler", "Filler", null));
			accounts = list;
		
		//}
		
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Login other = (Login) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", accounts=" + accounts + "]";
	}
	
	
	

}
