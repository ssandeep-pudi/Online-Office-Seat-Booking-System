package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.AdminService;
import com.model.FloorDetails;
import com.model.Location;
import com.model.Office_Info;
import com.model.User_org;

@RestController
public class AdminController
{
	@Autowired
	AdminService adminService;
	
	@DeleteMapping("Admin/Delete")
	@ResponseBody
	public ResponseEntity<?> deleteUser(@RequestBody int AdminId, String Apass, int UserId) throws Exception
	{
		//List<User_org> userList=adminService.userList();
		//adminService.deleteuser(AdminId, Apass, UserId);
		return new ResponseEntity(adminService.deleteuser(AdminId, Apass, UserId), HttpStatus.OK);
	}
	@PostMapping("Admin/postuser")
	@ResponseBody
	public User_org postUser(@RequestBody User_org user)
	{
		System.out.println(user+" cont");
		return adminService.saveUser(user);
	}
	@GetMapping("Admin/getuser")
	@ResponseBody
	public ResponseEntity<?> getUser()
	{
		List<User_org> userList=adminService.userList();
		return new ResponseEntity(userList, HttpStatus.OK);
	}
	@PostMapping("Admin/update")
	@ResponseBody
	public void updateemail(@RequestBody int id,String parameter, String mail)
	{
		System.out.println(mail+" cont");
		adminService.updateMail(id,parameter, mail);
		//return new service.updateemail(email);
	}
	
	@PostMapping("Admin/addlocation")
	@ResponseBody
	public void addloc(@RequestBody Location location)
	{
		adminService.addLocation(location);
	}
	
	@PostMapping("Admin/addOffc")
	@ResponseBody
	public void addoffc(@RequestBody Office_Info offc)
	{
		adminService.addOffc(offc);
	}
	
	@GetMapping("Admin/getOffc")
	@ResponseBody
	public List<Office_Info> getoffice()
	{
		return adminService.offcList();
	}
	
	@PostMapping("Admin/addFloor")
	@ResponseBody
	public void addFloor(@RequestBody FloorDetails fl)
	{
		adminService.addFloors(fl);
	}
	@GetMapping("Admin/getFloor")
	@ResponseBody
	public List<FloorDetails> getFloor()
	{
		return adminService.getFloor();
	}
	
	
	@PostMapping("Admin/InitData")
	@ResponseBody
	public boolean initData()
	{
		return adminService.InitData();
	}
	
	@PostMapping("Admin/addSeats")
	@ResponseBody
	public void addSeats(@RequestBody int fid)
	{
		adminService.addSeats(fid);
	}
	
	@GetMapping("Admin/getSeats")
	@ResponseBody
	public int getSeats(int fid)
	{
		return adminService.getSeats(fid);
	}
	
	@GetMapping("Admin/ApproveSeats")
	@ResponseBody
	public boolean approveSeats(int bid)
	{
		return adminService.seatApprove(bid);
	}
	
	
}
