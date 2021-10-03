package com.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Office_Info {
	@Id
	@GeneratedValue
	private int offc_id;
	private String offc_address;
	@OneToMany(mappedBy="office")
	List<User_org> user=new ArrayList<User_org>();
	@OneToMany
	List<FloorDetails> floor=new ArrayList<FloorDetails>();
	@ManyToOne
	Location location;
	
	public Office_Info() {
	}
	public int getOffc_id() {
		return offc_id;
	}
	public void setOffc_id(int offc_id) {
		this.offc_id = offc_id;
	}
	public String getOffc_address() {
		return offc_address;
	}
	public void setOffc_address(String offc_address) {
		this.offc_address = offc_address;
	}
}
