package DashEsgApi.DashEsgApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import DashEsgApi.DashEsgApi.model.Books;
import DashEsgApi.DashEsgApi.model.Users;
import DashEsgApi.DashEsgApi.repository.UserRepository;

@Service
public class UserService {

	
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepo) {
	    this.userRepository = userRepo;
	}
	
	public Users createUser(Users user) throws Exception {
		if(user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
			throw new Exception("Preencha todos os campos corretamente!");
		}
		
		Users u = userRepository.findByEmail(user.getEmail());
		
		if(u != null) {
			throw new Exception("Esse e-mail já está cadastrado!");
		}
		
		BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
		String senhaCriptografada = criptografar.encode(user.getPassword());
		user.setPassword(senhaCriptografada);
		
		return userRepository.save(user);
		
	}
	
	public Users findUser(int id) {
		return userRepository.findById(id);
				
	}
	
	public Users loginUser(String email, String pass) throws Exception {
		if(email == null || pass == null) {
			throw new Exception("Preencha todos os campos corretamente!");
		}
		
		Users user = userRepository.findByEmail(email);
		
		BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
		
		if(user == null) {	
			throw new Exception("Email não encontrado!");
		}
		
		boolean senhaIgual = criptografar.matches(pass, user.getPassword());
				
		if(!senhaIgual) {
			throw new Exception("Senha incorreta!");
		}

		return user;
		
	}
	
	
	public List<Users> getUsers(){
		return userRepository.findAll();
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	

}
