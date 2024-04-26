package DashEsgApi.DashEsgApi.model;

import java.sql.Timestamp;

public class UserDeveloper extends User {

	@Override
	public User identifyUser(User user) {
		user.setUser_type(3);
		user.setUser_desc("Desenvolvedor");
		return user;
	}
}
