package kodgemisi.hr.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodgemisi.hr.domain.User;
import kodgemisi.hr.repository.UserRepository;

<<<<<<< HEAD
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@PersistenceContext
	protected EntityManager entityManager;

	public User create(User newUser){
		return userRepo.save(newUser);
	}

=======

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public User create(User newUser){
		return userRepo.save(newUser);
	}
	
>>>>>>> origin/master
	public Iterable<User> findAll(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> Users = criteriaQuery.from(User.class);
		criteriaQuery.select(Users);
		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}
<<<<<<< HEAD
	
	public User findByID(Integer id){
		return userRepo.findOne(id);
	}

	
	/*public Iterable<User> findByUsernameAndPassword(String username, String pw){
		return userRepo.findByUsernameAndPassword(username, pw);
	}*/
=======
>>>>>>> origin/master

}
