package be.dragon.language.users;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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


    @Test
    public void removeUser() {
        Date date = new Date();

        User user = new User("benoit", "password", date, date, date, null);

        userRepository.save(user);
        Optional<User> userRet = userRepository.findByUserName("benoit");
        assertEquals(user.getUserName(), userRet.get().getUserName());
        userRepository.delete(userRet.get());

        assertThat(userRepository.findByUserName("benoit"), is(Optional.empty()));

    }


    @Test
    public void userExist() {
        Date date = new Date();

        User user = new User("benoit", "password", date, date, date, null);

        userRepository.save(user);
        Optional<User> userRet = userRepository.findByUserName("benoit");
        assertEquals(user.getUserName(), userRet.get().getUserName());


        assertThat(userRepository.exists(userRet.get().getId()), is(true));

    }


    @Test
    public void updateUser() {
        Date date = new Date();

        User user = new User("benoit", "password", date, date, date, null);

        userRepository.save(user);
        Optional<User> userRet = userRepository.findByUserName("benoit");

        userRet.get().setUserName("benoitke");
        userRet.get().setPassword("ikke");
        userRepository.save(userRet.get());

        assertEquals("benoitke", userRepository.findByUserName("benoitke").get().getUserName());


        assertThat(userRepository.findByUserName("benoitke").get().getPassword(), is("ikke"));

    }


    @Test
    public void getAllUser() {
        Date date = new Date();

        for (int i = 0; i < 20; i++) {
            userRepository.save(new User("benoit" + i, "password", date, date, date, null));
        }
        assertEquals(20, userRepository.findAll().spliterator().getExactSizeIfKnown());
    }


    @After
    public void tearTown() {
        userRepository.deleteAll();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme