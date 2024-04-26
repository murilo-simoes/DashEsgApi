package DashEsgApi.DashEsgApi.model;


public class UserEmployee extends User {

	@Override
	public User identifyUser(User user) {
		user.setUser_type(2);
		user.setUser_desc("Funcionário");
		return user;
	}
	
}
