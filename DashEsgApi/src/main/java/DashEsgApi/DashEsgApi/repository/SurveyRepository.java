package DashEsgApi.DashEsgApi.repository;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DashEsgApi.DashEsgApi.model.Survey;
import DashEsgApi.DashEsgApi.model.User;

public interface SurveyRepository extends JpaRepository<Survey, Integer>{

	Survey save(Survey survey);
	
	Optional<Survey> findById(Integer id);
	
	@Query("select s FROM Survey s WHERE s.id_company = ?1")
	Optional<Survey> findByIdCompany(Integer id_company);
	
	@Query("delete FROM Survey s WHERE s.id_company = ?1")
	void deleteByIdCompany(Integer id_company);
}
