package DashEsgApi.DashEsgApi.service;

import org.springframework.stereotype.Service;

import DashEsgApi.DashEsgApi.model.Company;
import DashEsgApi.DashEsgApi.model.User;
import DashEsgApi.DashEsgApi.repository.CompanyRepository;
import DashEsgApi.DashEsgApi.repository.UserRepository;

@Service
public class CompanyService {

	private final CompanyRepository companyRepository;
	private final UserRepository userRepository;
	
	
	public CompanyService(CompanyRepository company, UserRepository userRepo) {
	    this.companyRepository = company;
	    this.userRepository = userRepo;
	}
	
	
	//CRUD
	public Company createCompany(Company company) throws Exception {
		Company c = companyRepository.save(company);
		
		User user = this.userRepository.findById(company.getUser_id_creator()).get();
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
}
