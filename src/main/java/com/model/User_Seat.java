package com.model;

import javax.persistence.*;

@Entity
public class User_Seat {
	@Id
	@GeneratedValue
	private int usid;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@OneToOne
	User_org uid;
	@OneToOne
	Seats sid;
	
	public int getUsid() {
		return usid;
	}


	public void setUsid(int usid) {
		this.usid = usid;
	}


	public User_org getUid() {
		return uid;
	}


	public void setUid(User_org uid) {
		this.uid = uid;
	}


	public Seats getSid() {
		return sid;
	}


	public void setSid(Seats sid) {
		this.sid = sid;
	}


	@Override
	public String toString() {
		return "User_Seat [usid=" + usid + ", uid=" + uid + ", sid=" + sid + "]";
	}

	
}	
