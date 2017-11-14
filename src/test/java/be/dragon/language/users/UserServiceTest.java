package be.dragon.language.users;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void shouldReturnAUserByName() throws Exception {

        Date date = new Date();

        User user = new User("benoit", "password", date, date, date, null);

        given(userRepository.findByUserName("benoit")).willReturn(Optional.of(user));

        Optional<User> ret = userService.findByName("benoit");

        assertThat(ret.get(), is(user));


    }

    @Test
    public void shouldReturnList() throws Exception {
        Date date = new Date();

        for (int i = 0; i < 20; i++) {
            final User user = new User("benoit" + i, "password", date, date, date, null);
            userRepository.save(user);
            given(userRepository.findByUserName("benoit" + i)).willReturn(Optional.of(user));

            Optional<User> ret = userService.findByName("benoit" + i);

            assertThat(ret.get(), is(user));
        }
        given(userRepository.findAll()).willReturn(new ArrayList<User>());
        assertThat(userService.findAllUsers(), isA(List.class));

    }


    @Test
    public void schouldGetUserById() {
        Date date = new Date();

        User user = new User("benoit", "password", date, date, date, null);

        given(userRepository.findOne(Long.valueOf(1))).willReturn((user));

        User ret = userService.findById(1);

        assertThat(ret, is(user));

    }





}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme