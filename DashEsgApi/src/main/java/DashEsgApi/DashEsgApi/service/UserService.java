package DashEsgApi.DashEsgApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import DashEsgApi.DashEsgApi.model.User;
import DashEsgApi.DashEsgApi.model.UserDeveloper;
import DashEsgApi.DashEsgApi.model.UserEmployee;
import DashEsgApi.DashEsgApi.model.UserManager;
import DashEsgApi.DashEsgApi.repository.UserRepository;

@Service
public class UserService {

	
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepo) {
	    this.userRepository = userRepo;
	}
	
	
	
	public User createUser(User user) throws Exception {
		
		//VERIFICA SE O USUÁRIO PREENCHEU TODOS OS CAMPOS OBRIGATÓRIOS
		if(user.getName() == null || user.getEmail() == null || user.getPassword() == null || user.getUser_type() == null) {
			throw new Exception("Preencha todos os campos corretamente!");
		}

		//VERIFICA SE O USUÁRIO JA EXISTE
		User u = userRepository.findByEmail(user.getEmail());
		
		if(u != null) {
			throw new Exception("Esse e-mail já está cadastrado!");
		}
		
		//CRIPTOGRAFA A SENHA DO USUÁRIO
		BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
		String senhaCriptografada = criptografar.encode(user.getPassword());
		user.setPassword(senhaCriptografada);
		
		
		//IDENTIFICA QUE TIPO DE USUÁRIO VAMOS CADASTRAR
		
		User newUser;
		
		if(user.getUser_type() == 1) {
			UserManager supervisor = new UserManager();
			newUser = supervisor.identifyUser(user);
		}else if(user.getUser_type() == 2) {
			UserEmployee funcionario = new UserEmployee();
			newUser = funcionario.identifyUser(user);
		}else {
			UserDeveloper desenvolvedor = new UserDeveloper();
			newUser = desenvolvedor.identifyUser(user);
		}
		
		// CADASTRA O USUÁRIO
		return userRepository.save(newUser);
		
	}
	
	public User findUser(Integer id) {
		return userRepository.findById(id).get();
				
	}
	
	public User loginUser(String email, String pass) throws Exception {
		if(email == null || pass == null) {
			throw new Exception("Preencha todos os campos corretamente!");
		}
		
		User user = userRepository.findByEmail(email);
		
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
	
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public void deleteUser(int id) {
	
		// FAZER A VERIFICAÇÃO SE ESSE USUÁRIO É O CRIADOR DA EMPRESA, SE SIM, EXCLUIR ELE E A EMPRESA E TIRAR O ID DA EMPRESA DOS FUNCIONARIOS
		
		userRepository.deleteById(id);
	}
	

}
