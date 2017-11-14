package be.dragon.language.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersApplication {

	private static final Logger log = LoggerFactory.getLogger(UsersApplication.class);

	public static void main(String[] args) {



		SpringApplication.run(UsersApplication.class, args);
	}
/*
    @Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			Date date=new Date();

			for (int i = 0; i < 20; i++) {
				repository.save(new User("benoit"+i,"password", date,date,date, null ));
			}


		};
	}
	*/
}
