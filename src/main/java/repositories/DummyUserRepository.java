package repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.UserModel;

//W tym projekcie jako bazê danych pos³u¿y nam lista w pamiêci aplikacji. W pakiecie
//repositories dodajmy implementacjê powy¿szego interfejsu.

public class DummyUserRepository implements UserRepository {

	private static List<UserModel> db = new ArrayList<UserModel>(Arrays.asList(
		new UserModel("admin", "pass", "a@a.com", UserModel.ADMIN)
	));

	@Override
	public UserModel getRegistrationByEmailAddress(String email) {
		for (UserModel user : db) {
			if (user.getEmail().equalsIgnoreCase(email))
				return user;
		}
		return null;
	}
	
	@Override
	public void add(UserModel user) {
		db.add(user);
	}

	@Override
	public int count() {
		return db.size();
	}

	@Override
	public UserModel getUserByLogin(String login) {
		System.err.println("getUserByLogin");
		for (UserModel user : db) {
			System.err.println("user:"+user.getUsername()+": login :"+login+":");
			if (user.getUsername().equalsIgnoreCase(login))
				return user;
		}
		return null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		return db;
	}

}
