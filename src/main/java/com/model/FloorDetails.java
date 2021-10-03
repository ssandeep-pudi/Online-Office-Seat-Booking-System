package com.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class FloorDetails {
	@Id
	@GeneratedValue
	private int floor_id;
	private int total_seats;
	@OneToMany
	List<Seats> seats=new ArrayList<Seats>();
	@ManyToOne
	Office_Info office;
	@OneToMany(mappedBy="floor")
	List<User_org> user=new ArrayList<User_org>();
	public FloorDetails()
	{
		
	}
	
	public FloorDetails(int total_seats) {
		this.total_seats = total_seats;
	}

	public int getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	
}
