package DashEsgApi.DashEsgApi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import DashEsgApi.DashEsgApi.model.Company;
import DashEsgApi.DashEsgApi.service.CompanyService;



@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	
	@PostMapping("/company/add")
	public Company insertCompany(@RequestBody Company company) throws Exception {
		return companyService.createCompany(company);
	}
	
	@PostMapping("/company/find")
	public Company searchCompany(@RequestParam int id){
		return companyService.findCompany(id);
	}
	
	@PostMapping("/company/addEmployee")
	public String addEmployee(@RequestBody ObjectNode json) throws Exception{
		return companyService.addEmployee(json.get("email").asText(), json.get("id_company").asInt());
	}
	
}
