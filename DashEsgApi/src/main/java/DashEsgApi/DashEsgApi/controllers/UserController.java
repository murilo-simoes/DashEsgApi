package DashEsgApi.DashEsgApi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DashEsgApi.DashEsgApi.model.Books;
import DashEsgApi.DashEsgApi.model.Users;
import DashEsgApi.DashEsgApi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/add")
	public Users insertUser(@RequestBody Users user) throws Exception {
		return userService.createUser(user);
	}
	
	@PostMapping("/user/find/{id}")
	public Users searchBook(@RequestParam int id){
		return userService.findUser(id);
	}
	
	@PostMapping("/user/login")
	public Users searchBook(@RequestBody Map<String, String> json) throws Exception{
		return userService.loginUser(json.get("email"), json.get("password"));
	}
	
	@GetMapping("/user/get")
	public List<Users> findAllUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("/user/delete/{id}")
	public String deleteUser(@RequestParam int id) {
		userService.deleteUser(id);
		return "Usuário deletado com sucesso!";
	}
	
	
}
