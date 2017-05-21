package kodgemisi.hr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodgemisi.hr.domain.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer>{
	
}
