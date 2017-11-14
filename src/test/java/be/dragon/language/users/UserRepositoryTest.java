package be.dragon.language.users;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void addUser() {
        Date date = new Date();

        User user = new User("benoit", "password", date, date, date, null);

        userRepository.save(user);
        Optional<User> userRet = userRepository.findByUserName("benoit");
        assertEquals(user.getUserName(), userRet.get().getUserName());


    }


    public void tearTown() {
        userRepository.deleteAll();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme