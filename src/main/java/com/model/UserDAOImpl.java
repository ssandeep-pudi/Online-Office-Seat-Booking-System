package com.model;

import java.util.*;
import org.hibernate.usertype.UserType;
import javax.persistence.*;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;

//@Component
////public class UserDAOImpl implements UserDAO {
//	
//	@Autowired
//	SessionFactory sessionFactory;
//	
////	@PersistenceContext
////	private EntityManager em;
//	
//	public List<Seats> seatList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//	public List<FloorDetails> floorList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//	public List<Office_Info> offcList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	public List<User_org> userList()
//	{
//		Session session=sessionFactory.openSession();
//		Transaction tx=session.beginTransaction();
//		Query query=session.createQuery("select u from User_org u");
//		tx.commit();
//		return query.list();
//	}
//
//	
//	public User_org saveUser(User_org user) {
////		System.out.println(user+" i");
////		em.getTransaction().begin();
////		em.persist(user);
////		em.getTransaction().commit();
//		Session session=sessionFactory.openSession();
//		Transaction tx=session.beginTransaction();
//		session.save(user);
//		session.flush();
//		tx.commit();
//		return user;
//	}
//}
