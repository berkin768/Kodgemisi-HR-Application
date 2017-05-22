package kodgemisi.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kodgemisi.hr.domain.User;
import kodgemisi.hr.service.JobService;
import kodgemisi.hr.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private JobService jobService;
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		User newUser = new User();
		newUser.setUsername("berkin768");
		newUser.setPassword("password");

		userService.create(newUser);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("job", jobService.findAll());
		return mav;
	}	
}
