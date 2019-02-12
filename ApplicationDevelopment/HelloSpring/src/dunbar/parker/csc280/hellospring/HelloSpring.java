package dunbar.parker.csc280.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan("dunbar.parker.csc280.hellospring")
public class HelloSpring extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpring.class, args);
	}

}