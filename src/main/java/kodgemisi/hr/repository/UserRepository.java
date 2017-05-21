package kodgemisi.hr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import kodgemisi.hr.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
}