package be.dragon.language.users;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserController.class)
@WebAppConfiguration
public class UserControllerTest {
}
//https://thepracticaldeveloper.com/2017/07/31/guide-spring-boot-controller-tests/