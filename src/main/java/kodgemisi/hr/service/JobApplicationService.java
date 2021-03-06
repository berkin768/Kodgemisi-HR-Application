package kodgemisi.hr.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodgemisi.hr.domain.JobApplication;
import kodgemisi.hr.repository.JobApplicationRepository;

@Service
@Transactional
public class JobApplicationService {
	
	@Autowired
	private JobApplicationRepository jobAppRepo;

	@PersistenceContext
	protected EntityManager entityManager;
	
	public JobApplication create(JobApplication newJobApplication){
		return jobAppRepo.save(newJobApplication);
	}
	
	public String deleteById(Integer id) {
		JobApplication jobApp = jobAppRepo.findOne(id);	
		String jobAppName = jobApp.getName();
		jobAppRepo.delete(jobApp);  
		return jobAppName;
	}
	
	public JobApplication findID(Integer id){
		return jobAppRepo.findOne(id);
	}
}