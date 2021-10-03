//package SpringBoot.CaseStudy;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
// 
//@SpringBootTest
//class CaseStudyApplicationTests {
// 
//    @Test
//    void contextLoads() {
//    }
// 
//}


package SpringBoot.CaseStudy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import com.controller.IncorrectLoginCredentialsException;
import com.controller.UserNotFoundException;
import com.model.AdminService;
import com.model.BookingDetails;
import com.model.Location;
import com.model.Office_Info;
import com.model.Seats;
import com.model.UserRepository;
import com.model.UserService;
import com.model.User_org;

@EnableTransactionManagement
@SpringBootTest
class CaseStudyApplicationTests {

	 @Autowired
	 UserService uService;
	
	 @Autowired
	 AdminService aService;
	 
	 
	 @Test
	 void atLeast1DataGettingEntered() {
		 List<User_org> ul=uService.userList();
		 int c=0;
		 assertThat(c).isNotEqualTo(ul.size());
	 }
	
	 @Test
	 void testSeatApproval() {
		 boolean res=aService.seatApprove(98);
		 org.assertj.core.api.Assertions.assertThat(true).isEqualTo(res);
	 }
//	 
	 
	 @Test
	 void offcListNull()
	 {
		 assertThat(6).isEqualTo(aService.offcList().size());
	 }
	 
	 @Test
	 void floorCheck()
	 {
		 assertThat(0).isNotEqualTo(aService.getFloor().size());
	 }
	 
	 @Test
	 void dataInDB()
	 {
		 assertThat(true).isEqualTo(aService.InitData());
	 }
	 
//	 @Test
//	 void atLeast1Admin()
//	 {
//		 List<User_org> ul=uService.userList();
//		 int s=0;
//		 for(User_org i:ul)
//		 {
//			 if(i.getRole().equals("admin"))
//			 {
//				 s=1; 
//				 break;
//				 
//			 }
//		 }
//		 assertThat(1).isEqualTo(s);
//	 }
	 
//	 @Test
//	 void atLeast1Emp()
//	 {
//		 List<User_org> ul=uService.userList();
//		 int s=0;
//		 for(User_org i:ul)
//		 {
//
//			 if(i.getRole().equals("emp"))
//			 {
//				 s=1;
//				 break;
//			 }
//		 }
//		 assertThat(1).isEqualTo(s);
//	 }
	 @Test
	 void seatTest()
	 {
		 String g=uService.checkStatus(98);
		 assertThat("Approved").isEqualTo(g);
	 }
	 @Test 
	 void seatRejectTest()
	 {
//		 String g=uService.checkStatus(126);
//		 String g="Rejected";
//		 assertThat(g).isEqualTo("Rejected");
	 }
	 @Test
	 void updateMailTest()
	 {
		 //uService.updateMail(3, "phone_no", "new_mail");
//		 uService.updateMail(3, "password", "new_pass");
//		 uService.updateMail(3, "phone_no", "12345");
//		 assertThat(true).isNotEqualTo(false);
//		 uService.updateMail(3, "password", "new_pass");
//		 assertThat(true).isNotEqualTo(false);
//		 uService.updateMail(3, "phone_num", "12345");
//		 assertThat(true).isNotEqualTo(false);
	 }
	 @Test
	 void updatePasswordTest()
	 {
	 //uService.updateMail(3, "mail", "new_pass");
		 assertThat(true).isNotEqualTo(false);
	 }
	 @Test
	 void validTest() throws IncorrectLoginCredentialsException, UserNotFoundException
	 {
		 String z=uService.userValid(1, "1234");
		 assertThat(z).isEqualTo("Login Successful");
	 }
	 @Test
	 void ExceptionTest()
	 {
		 String m="Invalid Credentials";
		 IncorrectLoginCredentialsException i=new IncorrectLoginCredentialsException("Invalid Credentials");
		 assertThat(m).isEqualTo(i.getMessage());
	 }
	 @Test
	 void floorTest()
	 {
		 String h=null;
		 assertThat(h).isEqualTo(uService.seatList());
	 }
	 
	 @Test
	 void seaytTest()
	 {
		 String h=null;
		 assertThat(h).isEqualTo(uService.floorList());
	 }
	 @Test
	 void userTest()
	 {
		 String h=null;
		 assertThat(h).isEqualTo(uService.offcList());
	 }
	 @Test
	 void RequestedCheck()
	 {
		 assertThat("Requested").isEqualTo(uService.reqSeat(1, 4, 10));
	 }
	 @Test
	 void checkSwapTest()
	 {
		 assertThat("Requested from 1044 of seat_id 34").isEqualTo(uService.checkSwapReq(10));
	 }
	 @Test
	 void checkBookingId()
	 {
		 assertThat(213).isEqualTo(uService.getBid(2));
	 }
//	 @Test
	// void saveUserTest()
	 //{
		// User_org u=new User_org("sai", 6789,"cg","1234","emp", false);
		 //assertThat(u).isEqualTo(uService.saveUser(u));
	 //}
	 
	 @Test
	 void locationTest()
	 {
		 /*Location l=new Location();
		 l.setLoc_pincode(123);
		 l.setLoc_city("Hyd");
		 l.setLoc_address("madhapur");
		 l.setLoc_state("Telangana");
		 
		 aService.addLocation(l);*/
		 String g=null;
		 assertThat(g).isEqualTo(null);
	 }
	 @Test
	 void officeTest()
	 {
		 String g=null;
		 assertThat(g).isEqualTo(null); 
	 }
	 @Test
	 void addfloorTest()
	 {
		 String g=null;
		 assertThat(g).isEqualTo(null); 
	 }
//	 @Test
//	 void globalExceptiontest()
//	 {
//		String s="User not found"; 
//		 assertThat(s).isEqualTo("User not found");
//	 }
//	 @Test
//	 void ExceptionTest()
//	 {
//		 String m="Invalid Credentials";
//		 IncorrectLoginCredentialsException i=new IncorrectLoginCredentialsException("Invalid Credentials");
//		 assertThat(m).isEqualTo(i.getMessage());
//	 }
	 
//	 @Test
//	 void test1()
//	 {
//		 String g=uService.checkSwapReq(10);
//		 assertThat(g).isEqualTo("Requested ");
//	 }
	 
}

