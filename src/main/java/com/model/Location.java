package com.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private int loc_pincode;
	private String loc_address;
	private String loc_city;
	private String loc_state;
	@OneToMany
	List<Office_Info> office=new ArrayList<Office_Info>();
	@OneToMany(mappedBy="location")
	List<User_org> user=new ArrayList<User_org>();
	
	public Location() {
	}
	public int getLoc_pincode() {
		return loc_pincode;
	}
	public void setLoc_pincode(int loc_pincode) {
		this.loc_pincode = loc_pincode;
	}
	public String getLoc_address() {
		return loc_address;
	}
	public void setLoc_address(String loc_address) {
		this.loc_address = loc_address;
	}
	public String getLoc_city() {
		return loc_city;
	}
	public void setLoc_city(String loc_city) {
		this.loc_city = loc_city;
	}
	public String getLoc_state() {
		return loc_state;
	}
	public void setLoc_state(String loc_state) {
		this.loc_state = loc_state;
	}
	
}
