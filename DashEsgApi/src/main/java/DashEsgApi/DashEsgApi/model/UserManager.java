package DashEsgApi.DashEsgApi.model;

import java.sql.Timestamp;

public class UserManager extends User{

	@Override
	public User identifyUser(User user) {
		user.setUser_type(1);
		user.setUser_desc("Gerente");
		return user;
	}
	
}
