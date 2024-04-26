package DashEsgApi.DashEsgApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import DashEsgApi.DashEsgApi.model.User;
public interface UserRepository extends JpaRepository<User, Integer>{
	

	User findById(int id);
	
	User findByEmail(String email);
	
	User save(User user);
	
	List<User> findAll();
	
	void deleteById(int id);
}
