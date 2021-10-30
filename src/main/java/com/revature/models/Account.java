package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountID;
	
	private String firstName;
	
	private String lastName;
	
	private String accountType;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId")
	private List<Request> requests;

	
	
	
	public Account(int accountID, String firstName, String lastName, String accountType, List<Request> requests) {
		super();
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountType = accountType;
		this.requests = requests;
	}

	public Account(String firstName, String lastName, String accountType, List<Request> requests) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountType = accountType;
		this.requests = requests;
	}

	public Account() {
		super();
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((requests == null) ? 0 : requests.hashCode());
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
		Account other = (Account) obj;
		if (accountID != other.accountID)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (requests == null) {
			if (other.requests != null)
				return false;
		} else if (!requests.equals(other.requests))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accountType=" + accountType + ", requests=" + requests + "]";
	}

	
	
	
	

}
