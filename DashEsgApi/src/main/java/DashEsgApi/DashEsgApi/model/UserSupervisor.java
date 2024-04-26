package DashEsgApi.DashEsgApi.model;

import java.sql.Timestamp;

public class UserSupervisor extends User{

	@Override
	public User identifyUser(User user) {
		user.setUser_type(1);
		user.setUser_desc("Supervisor");
		return user;
	}
	
}
