package DashEsgApi.DashEsgApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import DashEsgApi.DashEsgApi.model.Users;
public interface UserRepository extends JpaRepository<Users, Integer>{
	

	Users findById(int id);
	
	Users findByEmail(String email);
	
	Users save(Users user);
	
	List<Users> findAll();
	
	void deleteById(int id);
}
