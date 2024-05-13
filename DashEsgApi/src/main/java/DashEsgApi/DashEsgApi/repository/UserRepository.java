package DashEsgApi.DashEsgApi.repository;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DashEsgApi.DashEsgApi.model.User;
public interface UserRepository extends JpaRepository<User, Integer>{
	

	Optional<User> findById(Integer id);
	
	User findByEmail(String email);
	
	User save(User user);
	
	List<User> findAll();
	
	
	void deleteById(int id);

	@Query("SELECT u FROM User u WHERE u.id_company = ?1")
	List<User> findAllByIdCompany(Integer id_company);
}