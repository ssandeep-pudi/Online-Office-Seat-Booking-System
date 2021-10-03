package com.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Seats {
	@Id
	@GeneratedValue
	private int seat_id;
	private int floor_id;
	private boolean isVacant=true;
	@ManyToOne
	FloorDetails floor;
	@OneToOne
	BookingDetails booking;
	
	public Seats() {
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}


	public int getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}
	public boolean isVacant() {
		return isVacant;
	}
	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}
//	List<Seats> seatslist= new ArrayList<Seats>(20);
//	for(Seats i:seatslist )
//	{
//		i.setVacant(true);
//	}
}
