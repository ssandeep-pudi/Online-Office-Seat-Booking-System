package com.model;

import java.util.*;

import javax.persistence.*;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.controller.IncorrectLoginCredentialsException;
import com.controller.UserNotFoundException;



@Service
public class UserService {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AdminService adminService;
	public List<Seats> seatList() {
	// TODO Auto-generated method stub
		
		return null;
	}

	public List<FloorDetails> floorList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Office_Info> offcList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<User_org> userList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select u.name, u.id, u.phone_num, u.role from User_org u");
		session.flush();
		tx.commit();
		return query.list();
	}
	
	public User_org dash(int id)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		User_org u=session.find(User_org.class, id);
		return u;
	}
	public User_org saveUser(User_org user) {
	//	System.out.println(user+" i");
	//	em.getTransaction().begin();
	//	em.persist(user);
	//	em.getTransaction().commit();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		session.flush();
		tx.commit();
		return user;
	}
	public void updateMail(int id, String parameter, String update)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		//System.out.print(mail);
		 List<User_org> userList = userList();
		 for(User_org i: userList)
		 {
			 User_org u= i;
			 if(u.getId()==id)
			 {
				 if(parameter.equalsIgnoreCase("mail"))
				 {	 
					 u.setEmail(update);
					 session.update(u);
					 break;
				 }
				 if(parameter.equalsIgnoreCase("phone_no"))
				 {	 
					 u.setPhone_num(Integer.parseInt(update));
					 session.update(u);
					 break;
				 }
				 if(parameter.equalsIgnoreCase("password"))
				 {	 
					 u.setPassword(update);
					 session.update(u);
					 break;
				 }
			 }
		 }
		//session.update(mail, id);
		//session.update(tx);
		session.flush();
		tx.commit();
		//return id;
	}
	
	public List<Integer> availabeSeat(int fid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
//		FloorDetails f=session.find(FloorDetails.class, fid);
//		int g= adminService.getSeats(fid);
		Query query=session.createQuery("select s from Seats s");
		List<Seats> q=query.list();
		List<Integer> avail=new ArrayList<Integer>();
		for(Seats s:q)
		{
			Seats r=s;
			if(r.getFloor_id()==fid && r.isVacant())
			{
				avail.add(r.getSeat_id());
			}
		}
		session.flush();
		tx.commit();
		return avail;
	}
	
	public String userValid(int id, String pass) throws IncorrectLoginCredentialsException, UserNotFoundException
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select i from User_org i");
		List<User_org> l1=query.list();
		List<Integer> l=new ArrayList<Integer>();
		for(User_org i:l1)
		{
			l.add(i.getId());
		}
		try
		{
			if(!(l.contains(id)))
			{
				throw new UserNotFoundException("Cannot find user with the given ID, please retry");
			}
		}
		catch(UserNotFoundException j)
		{
			return j.getMessage();
		}
		User_org u=session.find(User_org.class, id);
		try{
			if(!(u.getPassword().equals(pass)))
			{
				throw new IncorrectLoginCredentialsException("Wrong Password, please try again");
			}
			else
				{
					return "Login Successful";	
				}
		}
		catch(IncorrectLoginCredentialsException e)
		{
			return e.getMessage();
		}
//		return "Login Successfull";	
	}
	public String reqSeat(int uid, int fid, int sid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		BookingDetails b=new BookingDetails();
		b.setUser_id(uid);
		b.setFloor_id(fid);
		Seats y=session.find(Seats.class, sid);
		b.setSeats(y);
		b.setBookingstatus("Requested");
		session.save(b);
		session.flush();
		session.close();
		tx.commit();
		String g="Requested";
		return g;
	}
	
	public String checkStatus(int bid)
	{
		if(adminService.seatApprove(bid))
		{
			return "Approved";
		}
		else
		{
			return "Rejected";
		}
	}
	
	public List<BookingDetails> history(int uid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("select t from BookingDetails t");
		List<BookingDetails> l=q.list();
		List<BookingDetails> al=new ArrayList<BookingDetails>();

		for(BookingDetails i:l)
		{
			if(i.getUser_id()==uid)
			{
				al.add(i);
			}
		}
		session.flush(); 		
		session.close();
		tx.commit();
		return al;
	}
	
	public User_Seat SwapReq(int myuid, int mysid, int sid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		User_Seat us=new User_Seat();
		User_org u1=session.find(User_org.class, myuid);
		
		Seats s1=session.find(Seats.class, sid);
		
		us.setUid(u1);
		us.setSid(s1);
		us.setStatus("Requested from "+myuid+" of seat_id "+mysid);
		u1.setSwap_req(true);
		session.save(u1);
		session.save(us);
		session.flush();
		session.close();
		tx.commit();
		return us;
	}
	
	public int getBid(int uid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("select t1 from BookingDetails t1");
		List<BookingDetails> t=q.list();
//		System.out.print(t.get(0));
		int y=0,y1=0;
		for(BookingDetails u:t)
		{
			if(u.getUser_id()==uid)
			{
				y=u.getBooking_id();
				y1=u.getFloor_id();
				break;
			}
		}
		session.flush();
		tx.commit();
		session.close();
//		Session session1=sessionFactory.openSession();
//		Transaction tx1=session1.beginTransaction();
//		User_org h=session1.find(User_org.class, uid);
//		BookingDetails z=new BookingDetails();
//		FloorDetails x=new FloorDetails();
//		x.setFloor_id(y1);
//		z.setBooking_id(y);                           
//		h.setBooking(z);
//		h.setFloor(x);
//		session1.update(h);
//		session1.flush();
//		tx1.commit();
		return y;
	}
	
	public String checkSwapReq(int sid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("select t1 from User_Seat t1");
		List<User_Seat> t=q.list();
		User_Seat u=new User_Seat();
		for(User_Seat i:t)
		{
			Seats s=i.getSid();
			if(s.getSeat_id()==sid)
			{
				u=i;
			}
		}
		return u.getStatus();
	}
}