package be.dragon.language.users;


import java.util.List;
import java.util.Optional;


public interface UserService {
	
	User findById(long id);
	
	Optional<User> findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers();
	
	void deleteAllUsers();
	
	boolean isUserExist(User user);
	
}
