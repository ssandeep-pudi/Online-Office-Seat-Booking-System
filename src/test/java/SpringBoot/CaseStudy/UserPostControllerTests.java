package SpringBoot.CaseStudy;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;

import com.controller.AdminController;
import com.controller.UserController;
import com.model.AdminService;
import com.model.BookingDetails;
import com.model.Location;
import com.model.Office_Info;
import com.model.Seats;
import com.model.UserService;
import com.model.User_org;

//@WebMvcTest(controllers=AdminController.class)
//@ActiveProfiles("test")
@EnableTransactionManagement
@SpringBootTest
@AutoConfigureMockMvc
public class UserPostControllerTests  {

	@Autowired
	private MockMvc mockmvc;
	@Mock
	Model model;
	
	@MockBean
	AdminService adminsService;
	
	@MockBean
	AdminController adminController;
	
	@Test
	public void testUserController()
	{
		User_org uo=new User_org("sai", 7894, "cg", "1234", "emp", false);


		try {
			this.mockmvc.perform(post("User/postUser")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{'email':"+uo.getEmail()+",'password':"+"1234"+",")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdminoffice()
	{
		Office_Info oi=new Office_Info();


		try {
			this.mockmvc.perform(post("Admin/addOffc")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{'offc':"+oi.getOffc_id()+",")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testOfficeLocation()
	{
		Location l= new Location();
		try 
		{
			this.mockmvc.perform(post("Admin/addlocation")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{'loc_address':"+l.getLoc_address()+",'loc_city':"+l.getLoc_city()+",")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testApproveSeats()
	{
		BookingDetails bd= new BookingDetails();
		try
		{
			this.mockmvc.perform(post("Admin/ApproveSeats")
			.contentType(MediaType.APPLICATION_JSON)
			.content("'booking_id':"+bd.getBooking_id()+",")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdminAddSeats()
	{
		Seats s=new Seats();
	
		try {
		this.mockmvc.perform(post("Admin/addSeats")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{'floor_id':"+s.getFloor_id()+"}")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testdeleteUser()
	{
//		User_org uo=new User_org();
//		User_org uo1=new User_org();
	
		try {
			this.mockmvc.perform(post("Admin/Delete")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{'Admin Id':"+",'password':"+"1234"+",'User Id':"+"}")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testgetUser()
	{
		try {
			this.mockmvc.perform(get("Admin/getuser")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{'Admin Id':"+1+",'password':"+"1234"+",'User Id':"+"2"+"}")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@MockBean
	UserController userController;
	
	@MockBean
	UserService userService;
//	@Before(value = "j")
//	public void setUp() throws Exception
//	{
//		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//	}
	@Test
	public void testMockMVC() throws Exception{
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
		User_org uo=new User_org("sai", 7894, "cg", "1234", "emp", false);
		List<User_org> u1=new ArrayList<User_org>();
		u1.add(uo);
		Mockito.when(userService.userList()).thenReturn(u1);
		
		String url="/user/getuser";
		mockMvc.perform(get(url)).andExpect(status().isNotFound());
		
	 }
}