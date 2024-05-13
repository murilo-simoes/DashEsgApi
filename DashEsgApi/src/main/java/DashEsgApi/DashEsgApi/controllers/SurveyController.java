package DashEsgApi.DashEsgApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import DashEsgApi.DashEsgApi.model.Survey;
import DashEsgApi.DashEsgApi.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	
	@PostMapping("/survey/add")
	public Survey addSurvey(@RequestBody Survey survey){
		return surveyService.createSurvey(survey);
	}
	
	@PostMapping("/survey/find")
	public Survey findSurveys(@RequestParam Integer id_company) throws Exception{
		return surveyService.findSurvey(id_company);
	}
	
	@PostMapping("/survey/editName")
	public String editSurveyName(@RequestBody ObjectNode json) throws Exception {
		return surveyService.updateSurvey(json.get("id").asInt(), json.get("name").asText());
	}
	
}
