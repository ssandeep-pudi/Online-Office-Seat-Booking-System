package com.model;
import javax.persistence.*;

@Entity

public class User_org {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long phone_num;
	private String email;
	private String password;
	private String role;
	private boolean swap_req;
	@ManyToOne(cascade=CascadeType.ALL)
	FloorDetails floor;
	@ManyToOne(cascade=CascadeType.ALL)
	Office_Info office;
	@OneToOne(cascade=CascadeType.ALL)
	BookingDetails booking;
	@ManyToOne(cascade=CascadeType.ALL)
	Location location;
	public User_org()
	{
		
	}
	
	
	public User_org(String name, long phone_num, String email, String password, String role, boolean swap_req) {
		this.name = name;
		this.phone_num = phone_num;
		this.email = email;
		this.password = password;
		this.role = role;
		this.swap_req = swap_req;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(long phone_num) {
		this.phone_num = phone_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isSwap_req() {
		return swap_req;
	}
	public void setSwap_req(boolean swap_req) {
		this.swap_req = swap_req;
	}
	
	public FloorDetails getFloor() {
		return floor;
	}
	public void setFloor(FloorDetails floor) {
		this.floor = floor;
	}
	public Office_Info getOffice() {
		return office;
	}
	public void setOffice(Office_Info office) {
		this.office = office;
	}
	public BookingDetails getBooking() {
		return booking;
	}
	public void setBooking(BookingDetails booking) {
		this.booking = booking;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone_num=" + phone_num + ", email=" + email + ", password="
				+ password + ", role=" + role + ", swap_req=" + swap_req + "]";
	}
	
}
