package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Request {
	
	@Id
	// VV removed unique True
	//@Column(unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// VV Added To Try
	//@MapKey()
	//@ManyToOne(mappedBy = "Account")
	
	//@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	//@JoinColumn(name = "accountId")
	//@JsonIgnore
	private int requestId;
	
	// VV Pending Approved Declined
	private String status;
	
	private int amount;
	
	// VV Lodging Travel Food Other
	private String type;
	
	private String submitted;
	
	private String answered;
	
	private String description;

	public Request(int requestId, String status, int amount, String type, String submitted, String answered,
			String description) {
		super();
		this.requestId = requestId;
		this.status = status;
		this.amount = amount;
		this.type = type;
		this.submitted = submitted;
		this.answered = answered;
		this.description = description;
	}

	public Request(String status, int amount, String type, String submitted, String answered, String description) {
		super();
		this.status = status;
		this.amount = amount;
		this.type = type;
		this.submitted = submitted;
		this.answered = answered;
		this.description = description;
	}

	public Request() {
		super();
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
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

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getAnswered() {
		return answered;
	}

	public void setAnswered(String answered) {
		this.answered = answered;
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
		result = prime * result + amount;
		result = prime * result + ((answered == null) ? 0 : answered.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + requestId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
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
		if (amount != other.amount)
			return false;
		if (answered == null) {
			if (other.answered != null)
				return false;
		} else if (!answered.equals(other.answered))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (requestId != other.requestId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
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
		return "Request [requestId=" + requestId + ", status=" + status + ", amount=" + amount + ", type=" + type
				+ ", submitted=" + submitted + ", answered=" + answered + ", description=" + description + "]";
	}

	
	
}
