package be.dragon.language.users;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	


	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public User findById(long id) {
		return userRepository.findOne(id);
	}
	
	public Optional<User> findByName(String name) {
		return userRepository.findByUserName(name);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public void deleteUserById(long id) {
		
		userRepository.delete(id);
	}

	public boolean isUserExist(User user) {
		return userRepository.exists(user.getId());
	}
	
	public void deleteAllUsers(){
		userRepository.deleteAll();
	}



}
