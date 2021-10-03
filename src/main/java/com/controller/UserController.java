package com.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.BookingDetails;
import com.model.Seats;
import com.model.User_org;
import com.model.UserService;
import com.model.User_Seat;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
//	@PostMapping("postuser")
//	@ResponseBody
//	public ResponseEntity<?> postUser(User_org user)
//	{
//		System.out.println(user+" cont");
//		service.saveUser(user);
//		return ResponseEntity.ok(user);
//	}
	
	
//	@RequestMapping("postuser")
////	@ResponseBody
//	public User_org postUser(@RequestBody User_org user)
//	{
//		System.out.println(user+" cont");
//		return service.saveUser(user);
//	}
	
	@PostMapping("User/login") 
	@ResponseBody
	public ResponseEntity<?> userValidation(@RequestBody int id, String pass) throws IncorrectLoginCredentialsException, UserNotFoundException
	{
		return new ResponseEntity(service.userValid(id, pass) ,HttpStatus.OK);
	}
	
	@PostMapping("User/postUser")
	@ResponseBody
	public User_org postUser(@RequestBody User_org user)
	{
		System.out.println(user+" cont");
		return service.saveUser(user);
	}
	
//	@GetMapping("getuser")
//	@ResponseBody
//	public ResponseEntity<?> getUser()
//	{
//		List<User_org> userList=service.getUsers();
//		return new ResponseEntity(userList, HttpStatus.OK);
//	}
	@GetMapping("user/getuser")
	@ResponseBody
	public ResponseEntity<?> getUser()
	{
		List<User_org> userList=service.userList();
		return new ResponseEntity(userList, HttpStatus.OK);
	}
	@GetMapping("user/getuserDashboard")
	@ResponseBody
	public ResponseEntity<?> getUserdashboard(int id)
	{
		User_org userList=service.dash(id);
		return new ResponseEntity(userList, HttpStatus.OK);
	}
	
//	@PostMapping("updatemail")
//	@ResponseBody
//	public ResponseEntity<?> updateMail(int Id, String mail)
//	{
//		List<Integer> userList=Arrays.asList(service.updateMail(Id, mail));
//		service.updateMail(Id, mail);
//		System.out.println("updated");
//		return new ResponseEntity("Updated", HttpStatus.OK);
//	}
	
//	@GetMapping("getseats")
//	@ResponseBody
//	public ResponseEntity<?> getAllSeats()
//	{
//		List<Seats> itemlist=service.getSeats();
//		return new ResponseEntity(itemlist,HttpStatus.OK);
//	}
	@PostMapping("User/update")
	@ResponseBody
	public void updateemail(@RequestBody int id,String parameter, String updateToBe)
	{
//		System.out.println(mail+" cont");
		service.updateMail(id,parameter, updateToBe);
		//return new service.updateemail(email);
	}
	
	@PostMapping("User/SwapReq")
	@ResponseBody
	public User_Seat SwapReq(@RequestBody int muid, int msid, int sid)
	{
		return service.SwapReq(muid, msid,  sid);
		//return new service.updateemail(email);
	}
	
	@GetMapping("User/checkAvailableSeats")
	@ResponseBody
	public List<Integer> getAvailSeats(int fid) 
	{
		return service.availabeSeat(fid);
	}
	
	
	@PostMapping("User/bookingReq")
	@ResponseBody
	public String reqForSeat(int uid, int fid, int sid)
	{
		return service.reqSeat(uid, fid, sid) ;
	}
	@GetMapping("User/checkStatus")
	@ResponseBody
	public String checkForSeats(int bid)
	{
		return service.checkStatus(bid);
	}
	
	@GetMapping("User/getHistory")
	@ResponseBody
	public List<BookingDetails> getHist(int uid)
	{
		return service.history(uid);
	}
	
	
	@GetMapping("User/getBookingId")
	@ResponseBody
	public ResponseEntity<?> getbookingId(int uid)
	{
		return new ResponseEntity(service.getBid(uid), HttpStatus.OK);
	}
	
	@GetMapping("User/checkSwapReq")
	@ResponseBody
	public String checkSwap(int sid)
	{
		return service.checkSwapReq(sid);
	}
}


