package repositories;

import java.util.List;

import domain.UserModel;

public interface UserRepository {

	UserModel getRegistrationByEmailAddress(String email);
	
	UserModel getUserByLogin(String login);
	
	List<UserModel> getAllUsers();
	void add(UserModel user);

	int count();

}
