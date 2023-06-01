package sopt.org.ThirdAdvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ThirdAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdAdvancedApplication.class, args);
	}

}
