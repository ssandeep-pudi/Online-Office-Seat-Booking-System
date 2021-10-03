package com.model;

//import java.util.*;
//import javax.persistence.*;
//
//import javax.persistence.EntityManager;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
////import org.springframework.boot.web.servlet.server.Session;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User_org, Integer> {}

