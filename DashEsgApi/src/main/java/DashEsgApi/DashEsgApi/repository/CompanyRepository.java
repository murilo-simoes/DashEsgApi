package DashEsgApi.DashEsgApi.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import DashEsgApi.DashEsgApi.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Optional<Company> findById(Integer id);
	
	Company save(Company company);
	
}
