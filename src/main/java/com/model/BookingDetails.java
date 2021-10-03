package com.model;
import java.util.*;
import javax.persistence.*;

@Entity
	public class BookingDetails {
		@Id
		@GeneratedValue
		private int booking_id;
		private int floor_id;
		private int user_id;
		private Date duration;
		private String bookingstatus;
		@OneToOne
		Seats seats;
		public BookingDetails()
		{
			
		}
		
		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public Seats getSeats() {
			return seats;
		}

		public void setSeats(Seats seats) {
			this.seats = seats;
		}

		public int getBooking_id() {
			return booking_id;
		}
		public void setBooking_id(int booking_id) {
			this.booking_id = booking_id;
		}
		public int getFloor_id() {
			return floor_id;
		}
		public void setFloor_id(int floor_id) {
			this.floor_id = floor_id;
		}
		public Date getDuration() {
			return duration;
		}
		public void setDuration(Date duration) {
			this.duration = duration;
		}
		public String getBookingstatus() {
			return bookingstatus;
		}
		public void setBookingstatus(String bookingstatus) {
			this.bookingstatus = bookingstatus;
		}

		@Override
		public String toString() {
			return "BookingDetails [booking_id=" + booking_id + ", floor_id=" + floor_id + ", user_id=" + user_id
					+ ", duration=" + duration + ", bookingstatus=" + bookingstatus + ", seats=" + seats + "]";
		}
		
}
