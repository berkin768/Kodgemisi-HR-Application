package kodgemisi.hr.service;

import java.awt.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Job> criteriaQuery = criteriaBuilder.createQuery(Job.class);
		Root<Job> Jobs = criteriaQuery.from(Job.class);
		criteriaQuery.select(Jobs);
		TypedQuery<Job> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}
	
	public String deleteById(Integer id) {
		Job job = jobRepo.findOne(id);	
		String jobTitle = job.getJobTitle();
        jobRepo.delete(job);  
        return jobTitle;
    }
}
