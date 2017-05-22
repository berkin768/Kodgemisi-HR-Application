package kodgemisi.hr.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodgemisi.hr.domain.Job;
import kodgemisi.hr.repository.JobRepository;

@Service
@Transactional
public class JobService {

	@Autowired
	private JobRepository jobRepo;

	@PersistenceContext
	protected EntityManager entityManager;


	public Job create(Job newJob){
		return jobRepo.save(newJob);
	}

	public Iterable<Job> findAll(){		
		return jobRepo.findAll();
	}

	public String deleteById(Integer id) {
		Job job = jobRepo.findOne(id);	
		String jobTitle = job.getJobTitle();
		jobRepo.delete(job);  
		return jobTitle;
	}
	
	public Job findID(Integer id){
		return jobRepo.findOne(id);
	}
}
