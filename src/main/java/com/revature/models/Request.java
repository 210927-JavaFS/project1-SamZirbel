package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestID;
	
	@Column(name = "accountNumber")
	private int accountNumber;
	
	private String status;
	
	private int amount;
	
	private String type;
	
	
	private String submittedDate;
	
	private String answeredDate;
	
	private String description;

	public Request(int requestID, int accountNumber, String status, int amount, String type, String submittedDate,
			String answeredDate, String description) {
		super();
		this.requestID = requestID;
		this.accountNumber = accountNumber;
		this.status = status;
		this.amount = amount;
		this.type = type;
		this.submittedDate = submittedDate;
		this.answeredDate = answeredDate;
		this.description = description;
	}

	public Request(int accountNumber, String status, int amount, String type, String submittedDate, String answeredDate,
			String description) {
		super();
		this.accountNumber = accountNumber;
		this.status = status;
		this.amount = amount;
		this.type = type;
		this.submittedDate = submittedDate;
		this.answeredDate = answeredDate;
		this.description = description;
	}
	
	

	public Request() {
		super();
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getAnsweredDate() {
		return answeredDate;
	}

	public void setAnsweredDate(String answeredDate) {
		this.answeredDate = answeredDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + amount;
		result = prime * result + ((answeredDate == null) ? 0 : answeredDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + requestID;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submittedDate == null) ? 0 : submittedDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Request other = (Request) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (amount != other.amount)
			return false;
		if (answeredDate == null) {
			if (other.answeredDate != null)
				return false;
		} else if (!answeredDate.equals(other.answeredDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (requestID != other.requestID)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submittedDate == null) {
			if (other.submittedDate != null)
				return false;
		} else if (!submittedDate.equals(other.submittedDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", accountNumber=" + accountNumber + ", status=" + status
				+ ", amount=" + amount + ", type=" + type + ", submittedDate=" + submittedDate + ", answeredDate="
				+ answeredDate + ", description=" + description + "]";
	}
	
	
	
	

}
