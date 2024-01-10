package com.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entity.User;
import com.flight_reservation_app.repository.UserRepository;


//38:52

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
	
		return "login/login";                                  //to display login page  -->verifylogin to match email and password
	}
	
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";                                //to display registration for new users
	}
	

	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
		
	}
	
//	@RequestMapping("/verifyLogin")
//	public String verifyLogin() {
//		return "login/login";
//	}
	
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelmap) {  //from login.jsp
	
		User user = userRepo.findByEmail(email);                 //can be find,getByEmail,readByEmail & change it in repository as well
		                                                        //if email id not matched then from findbyemail will return "null" and can be saved in user as null so to avoid this last else condition is used
		
//		System.out.println(user.getEmail());;
//		System.out.println(user.getPassword());
		
//		Uuser uuser = ur.findByfirstName(firstName);      //can do findbyfirstname also
//		System.out.println(uuser.getFirstName());
		
		if(user!=null) {
		if(user.getEmail().equals(email) && user.getPassword().equals(password)) {    //it will verify mail-id and password
			return "findFlights";
		}else {
			modelmap.addAttribute("error","invalid username/password");
			return "login/login";
		}
		}else {
			modelmap.addAttribute("error","please enter username/password");
			return "login/login";	
	}
		
		
		
	}
	
	}
	
	// to start from 1 again query :-alter table yourTableName AUTO_INCREMENT=1; -------------------------------------------
	// by default page:- http://localhost:8095/flights/
    //**modelattribute is used only if all variables matches with entity class  //full form matches with entity class
    //in RequestParam we are reading email attribute from the form and initialising it in email variable ,same to all
    // whenever to deal with database we use repository layer
   
   //4 modules in project :- user,flight,passenger,reservation

