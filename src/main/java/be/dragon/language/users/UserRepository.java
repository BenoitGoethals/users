package be.dragon.language.users;



import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
        Optional<User> findByUserName(String username);

        }
