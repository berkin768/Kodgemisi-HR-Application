package kodgemisi.hr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodgemisi.hr.domain.JobApplication;

@Repository
public interface JobApplicationRepository extends CrudRepository<JobApplication, Integer>{
	
}