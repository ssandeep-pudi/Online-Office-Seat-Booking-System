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

import com.controller.AdminNotFoundException;
import com.controller.UserNotFoundException;



@Service
public class AdminService {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	AdminRepository adminRepository;
	
	public List<Seats> seatList() {
	// TODO Auto-generated method stub
		return null;
	}

	
	public void addLocation(Location location)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(location);
		session.flush();
		tx.commit();
	}
	
	public List<User_org> userList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select u from User_org u");
		tx.commit();
		return query.list();
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
				 u.setEmail(update);
				 session.update(u);
				 break;
				 }
				 if(parameter.equalsIgnoreCase("password"))
				 {	 
				 u.setEmail(update);
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
	public String deleteuser(int Adminid, String Apass, int UserId) throws Exception
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		User_org adminuser=session.find(User_org.class, Adminid);
		String p="";
		p+=adminuser.getRole();
		String g="p";
		if(!(p.equals("emp")))
		{
			g+="emp";
		}
		try
		{
			if(g.equals("p")) {
				
				throw new AdminNotFoundException("Admin not found with this ID");
			}
		}
		catch(AdminNotFoundException e)
		{
			session.flush();
			tx.commit();
			return e.getMessage();
		}
		if(adminuser.getPassword().equals(Apass) && adminuser.getRole().equals("admin"))
		{
			User_org L =session.find(User_org.class, UserId);
			try
			{
				if(L==null)
				{
					throw new UserNotFoundException("User not found with this ID");
				}
			}
			catch(UserNotFoundException e)
			{
				return e.getMessage();
			}
			session.remove(L);
		}
		session.flush();
		tx.commit();
		return "Deleted";
	}

	public void addOffc(Office_Info offc) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(offc);
		session.flush();
		tx.commit();
	}
	
	public List<Office_Info> offcList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select u from Office_Info u");
		session.flush();
		tx.commit();
		return query.list();
	}
	
	
	public void addFloors(FloorDetails floor) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(floor);
		session.flush();
		tx.commit();
	}
	public List<FloorDetails> getFloor() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select u from FloorDetails u");
		session.flush();
		tx.commit();
		return query.list();
	}	
	
	public void addSeats(int fid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		FloorDetails f=session.find(FloorDetails.class, fid);
		
		for(int i=0;i< f.getTotal_seats();i++)
			
		{
			Seats s=new Seats();
			s.setFloor_id(fid);
			s.setVacant(true);
			session.save(s);
			//session.flush();
			//tx.commit();
		}
		session.flush();
		tx.commit();
	}
	
	public int getSeats(int fid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		FloorDetails f=session.find(FloorDetails.class, fid);
		int o=0;
		int  sl=f.getTotal_seats();
		Query query=session.createQuery("select u from Seats u");
		List<Seats> y=new ArrayList<Seats>();
		y=query.list();
		
		
		for(Seats n:y)
		{
			if(n.getFloor_id()==fid && n.isVacant())
			{
				o++;
			}
		}
		session.flush();

		tx.commit();
		return o;
	}
	
	public boolean seatApprove(int bid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		BookingDetails p=session.find(BookingDetails.class, bid);
		if(p.getBookingstatus().equals("Requested"))
		{
			if(p.seats.isVacant())
			{
				p.seats.setVacant(false);
				p.setBookingstatus("Approved");
				session.update(p);
				session.flush();
				session.close();
				tx.commit();
				return true;
			}
			else
			{
				p.setBookingstatus("Rejected");
				session.update(p);
				session.flush();
				session.close();
				tx.commit();
				return false;
			}
		}
		return true;
	}
	
	public boolean InitData()
	{
		User_org u1=new User_org("sai",6789, "cg", "1234", "emp", false);
		User_org u2=new User_org("joe",3456, "ac", "1234", "emp", false);
		User_org u3=new User_org("nik",4567, "tc", "1234", "admin", false);
		
		FloorDetails f1=new FloorDetails(10);
		FloorDetails f2=new FloorDetails(5);
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(u1);
		session.save(u2);
		session.save(u3);
		session.save(f1);
		session.save(f2);
		session.flush();
		session.close();
		tx.commit();
		return true;
	}
}