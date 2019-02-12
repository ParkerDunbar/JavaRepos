package dunbar.parker.csc280.springcalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("dunbar.parker.csc280.springcalc")
@SpringBootApplication
public class SpringCalc {

	public static void main(String[] args) {
		SpringApplication.run(SpringCalc.class, args);

	}

}
