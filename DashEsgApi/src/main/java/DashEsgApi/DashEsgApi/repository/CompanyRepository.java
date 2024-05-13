package DashEsgApi.DashEsgApi.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DashEsgApi.DashEsgApi.model.Company;
import DashEsgApi.DashEsgApi.model.User;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Optional<Company> findById(Integer id);
	
	Company save(Company company);
	
	void deleteById(Integer id);
	
	@Query("SELECT c FROM Company c WHERE c.cnpj = ?1")
	Company findByCnpj(String cnpj);
	
	@Query("SELECT c FROM Company c WHERE c.user_id_creator = ?1")
	Company findByUserIdCreator(Integer user_id_creator);

}
