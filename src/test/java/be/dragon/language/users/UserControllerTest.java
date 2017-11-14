package be.dragon.language.users;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    // shortened for clarity

    @Test
    public void shouldReturnFullName() throws Exception {
        Date date = new Date();

        User user = new User("benoit", "password", date, date, date, null);


        given(userService.findByName("benoit")).willReturn(Optional.of(user));

        //  Optional<User> ret=userService.findByName("benoit");

        //    assertThat(ret.get(),is(user));

        mockMvc.perform(get("/users/1"))

                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void shouldReturnUser() throws Exception {
        Date date = new Date();

        User user = new User("benoit", "password", date, date, date, null);


        given(userService.findByName("benoit")).willReturn(Optional.of(user));

        //  Optional<User> ret=userService.findByName("benoit");

        //    assertThat(ret.get(),is(user));

        mockMvc.perform(get("/users/user/"))

                .andExpect(status().is2xxSuccessful());
    }

}
//https://thepracticaldeveloper.com/2017/07/31/guide-spring-boot-controller-tests/