package DashEsgApi.DashEsgApi.model;


public class UserAdmin extends User {

	@Override
	public User identifyUser(User user) {
		user.setUser_type(4);
		user.setUser_desc("Admin");
		return user;
	}
	
}
