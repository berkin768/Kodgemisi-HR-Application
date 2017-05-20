package kodgemisi.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kodgemisi.hr.domain.User;
import kodgemisi.hr.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(path="/login")
	public String create(Model model){
		model.addAttribute("user", new User("Berkin","ASd"));
		
		User newUser = new User("berkin768","password");
		userService.create(newUser);

		return "index";
	}
	
	@RequestMapping(path="/list")
	public String findAll(){
		User user2 = userService.findAll().iterator().next();
		user2.getUsername();
		return "index";
	}
}
