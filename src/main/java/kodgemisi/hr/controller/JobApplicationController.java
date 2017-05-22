package kodgemisi.hr.controller;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kodgemisi.hr.domain.Job;
import kodgemisi.hr.domain.JobApplication;
import kodgemisi.hr.service.JobApplicationService;
import kodgemisi.hr.service.JobService;

@Controller
@RequestMapping(path="/app")
public class JobApplicationController {
	
	@Autowired
	private JobApplicationService jobApplicationService;
	
	@Autowired
	private JobService jobService;

	@RequestMapping(path="/{id}/application")
	public ModelAndView index(@PathVariable String id){
		
		ModelAndView mav = new ModelAndView("jobapplication");
		mav.addObject("job", jobService.findID(Integer.parseInt(id)));
		return mav;
	}

	@RequestMapping(path="/set", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String addJobApplication(@RequestParam String name, @RequestParam String email,@RequestParam String phone, @RequestParam String address, @RequestParam String thoughts, @RequestParam String jobID) {
		
		Job job = new Job();
		job = jobService.findID(Integer.parseInt(jobID));
		job.setNumberOfPersonToHire(job.getNumberOfPersonToHire() -1);
		JobApplication newJobApplication = new JobApplication();
		
		newJobApplication.setName(name);
		newJobApplication.setAddress(address);
		newJobApplication.setEmail(email);
		newJobApplication.setPhone(phone);
		newJobApplication.setThoughts(thoughts);
		newJobApplication.setJob(job);
		
		jobApplicationService.create(newJobApplication);
		
		JsonObject result = Json.createObjectBuilder()
				.add("isCreated", true)
				.add("jobTitle", newJobApplication.getJob().getJobTitle())
				.build();

		return result.toString();
	}
}
