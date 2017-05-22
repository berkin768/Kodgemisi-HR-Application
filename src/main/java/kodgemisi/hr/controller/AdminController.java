package kodgemisi.hr.controller;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kodgemisi.hr.domain.Job;
import kodgemisi.hr.service.JobService;

@Controller
@RequestMapping(path="/admin")
public class AdminController {

	@Autowired
	private JobService jobService;

	@RequestMapping(path="")
	public String index(){
		return "admin";
	}


	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(){
		return "create";
	}

	@RequestMapping(path="/done", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String addJob(@RequestParam String title, @RequestParam String description,@RequestParam int person, @RequestParam String date) {

		Job newJob = new Job();
		newJob.setJobTitle(title);
		newJob.setJobDescription(description);
		newJob.setNumberOfPersonToHire(person);
		newJob.setLastApplicationDate(date);

		jobService.create(newJob);

		JsonObject result = Json.createObjectBuilder()
				.add("isCreated", true)
				.add("jobTitle", newJob.getJobTitle())
				.build();

		return result.toString();
	}

	@RequestMapping(path="/list")
	public ModelAndView list(Model model){
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("job", jobService.findAll());  
		return mav;
	}

	@RequestMapping(path = "/{id}/delete", method = RequestMethod.GET)
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id){
		String title = jobService.deleteById(id);

		redirectAttributes.addFlashAttribute("message", title + " is deleted.");
		return "redirect:/admin/list";
	}
	
	@RequestMapping(path="/job/{id}/details", method = RequestMethod.GET)
	public ModelAndView jobDetails(@PathVariable Integer id){				
		ModelAndView mav = new ModelAndView("details");
		mav.addObject("job", jobService.findID(id));
		return mav;
	}
}
