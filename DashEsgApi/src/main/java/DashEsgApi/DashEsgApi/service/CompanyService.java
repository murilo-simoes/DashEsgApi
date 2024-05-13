package DashEsgApi.DashEsgApi.service;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

import DashEsgApi.DashEsgApi.model.Company;
import DashEsgApi.DashEsgApi.model.Survey;
import DashEsgApi.DashEsgApi.model.User;
import DashEsgApi.DashEsgApi.repository.CompanyRepository;
import DashEsgApi.DashEsgApi.repository.SurveyRepository;
import DashEsgApi.DashEsgApi.repository.UserRepository;
import javassist.expr.Instanceof;

@Service
public class CompanyService {

	private final CompanyRepository companyRepository;
	private final UserRepository userRepository;
	private final SurveyRepository surveyRepository;
	
	
	public CompanyService(CompanyRepository company, UserRepository userRepo, SurveyRepository surveyRepo) {
	    this.companyRepository = company;
	    this.userRepository = userRepo;
	    this.surveyRepository = surveyRepo;
	}
	
	
	//CRUD
	public Company createCompany(Company company) throws Exception {
		
		Company existeCompany = companyRepository.findByUserIdCreator(company.getUser_id_creator());
	
		if(existeCompany != null) {
			throw new Exception("Esse usuário ja tem uma empresa cadastrada!");
		}
		
		Company procuraCNPJ = companyRepository.findByCnpj(company.getCnpj());
		
		if(procuraCNPJ != null) {
			throw new Exception("Esse CNPJ já está cadastrado!");
		}

		
		User user = this.userRepository.findById(company.getUser_id_creator()).get();
		
		if(user.getUser_type() == 2) {
			throw new Exception("Esse usuário não tem permissão para adicionar uma empresa!");
		}
		
		Company c = companyRepository.save(company);
		

		user.setId_company(company.getId());
		this.userRepository.save(user);
		
		return c;
	}
	
	public String addEmployee(String email, Integer id_company) throws Exception{
		if(email == null) {
			throw new Exception("Preencha o campo de email corretamente!");
		}
		
		User user = this.userRepository.findByEmail(email);
		
		if(user == null) {
			throw new Exception("Email não encontrado!");
		}
		
		if(user.getUser_type() != 2) {
			throw new Exception("Este usuário não é um funcionário, você não pode adicionar ele na sua empresa!");
		}
		
		Company company = this.companyRepository.findById(id_company).get();
		user.setId_company(company.getId());
		company.setEmployee_qty(company.getEmployee_qty() + 1);
		
		this.userRepository.save(user);
		this.companyRepository.save(company);
		
		return "Usuário adicionado com sucesso!";
		
	}
	
	
	public Company findCompany(Integer id) {
		return companyRepository.findById(id).get();
	}
	
	public String deleteEmployee(Integer id_employee) throws Exception {
		
		if(id_employee == null) {
			throw new Exception("Esse funcionário não foi encontrado!");
		}
		
		User u = userRepository.findById(id_employee).get();
		
		u.setId_company(null);
		
		this.userRepository.save(u);
		
		return "Funcionário removido com sucesso!";
		
	}
	
	public String deleteCompany(Integer id) throws Exception {
		if(id == null) {
			throw new Exception("Insira um id da empresa para exluir!");
		}

		List<User> u = userRepository.findAllByIdCompany(id);
		
		for (User user : u) {
			user.setId_company(null);
			userRepository.save(user);
		}
		Survey s = surveyRepository.findByIdCompany(id).get();
		surveyRepository.deleteById(s.getId());
		companyRepository.deleteById(id);
		
		return "Empresa e relatório deletados com sucesso!";
		
	}
	
	public Integer existeEmpresa(String cnpj) {
		Company c = companyRepository.findByCnpj(cnpj);
		
		if(c != null) {
			return 1;
		}else {
			return 0;
		}
	}
	

}









