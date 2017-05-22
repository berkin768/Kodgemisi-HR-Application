package kodgemisi.hr.controller;

import javax.json.Json;
import javax.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kodgemisi.hr.domain.User;
import kodgemisi.hr.service.UserService;

@Controller
@RequestMapping(path="/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(path="")
	public String index(){
		return "login";
	}

	@RequestMapping(path="/continue", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String next(@RequestParam String username, @RequestParam String password){
		Iterable <User> query = userService.findAll();
		if(query != null){
			for(User user : query){
				if(user.getPassword().equals(password) && user.getUsername().equals(username)){
					JsonObject result = Json.createObjectBuilder()
							.add("isLogged", true)
							.add("username", user.getUsername())
							.build();				

					return result.toString();
				}					
			}
		}
		return "false";
	}
}
