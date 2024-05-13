package DashEsgApi.DashEsgApi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DashEsgApi.DashEsgApi.dto.Login;
import DashEsgApi.DashEsgApi.model.User;
import DashEsgApi.DashEsgApi.service.TokenService;
import DashEsgApi.DashEsgApi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/user/add")
	public User insertUser(@RequestBody User user) throws Exception {
		return userService.createUser(user);
	}
	
	@PostMapping("/user/find/")
	public User findUser(@RequestParam int id){
		return userService.findUser(id);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Login login) throws Exception{
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
				new UsernamePasswordAuthenticationToken(login.email, login.password);

		try {
			
			Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			User usuario = (User) authenticate.getPrincipal();
			return tokenService.gerarToken(usuario);
		}catch(Exception err) {
			throw new Exception("Email ou senha inválidos");
		}
		
		
		
	}
	
	@GetMapping("/user/get")
	public List<User> findAllUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("/user/delete/")
	public String deleteUser(@RequestParam int id) {
		userService.deleteUser(id);
		return "Usuário deletado com sucesso!";
	}
	
	@PostMapping("/user/findEmployees")
	public List<User> findEmployees(@RequestParam int id_company){
		return userService.listUserByCompany(id_company);
	}
	
}
