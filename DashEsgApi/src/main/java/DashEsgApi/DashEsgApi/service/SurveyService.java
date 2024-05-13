package DashEsgApi.DashEsgApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import DashEsgApi.DashEsgApi.model.Survey;
import DashEsgApi.DashEsgApi.repository.SurveyRepository;

@Service
public class SurveyService {

	private final SurveyRepository surveyRepository;
	
	public SurveyService(SurveyRepository surveyRepository) {
		this.surveyRepository = surveyRepository;
	}
	
	//CRUD
	
	public Survey createSurvey(Survey survey) {
		return surveyRepository.save(survey);
	}
	
	public Survey findSurvey(Integer id_company) throws Exception{
		Survey s = surveyRepository.findByIdCompany(id_company).get();
		
		if(s == null) {			
			throw new Exception("Relatório não encontrado!");
		}
		
		return s;
		
	}
	
	public String updateSurvey(Integer id, String name) throws Exception{
		if(name.isEmpty() || id == null) {
			throw new Exception("O id ou o nome não foi encontrado!");
		}
			
		Survey s = surveyRepository.findById(id).get();
		
		
		s.setName(name);
		
		this.surveyRepository.save(s);
		
		return "Nome editado com sucesso!";
	}
	
}
