package pl.pawelec97.pawApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.pawelec97.pawApplication.repositories.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class PawApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawApplication.class, args);
	}

}
