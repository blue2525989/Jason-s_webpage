package reboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	/*
	 *Build Spring Boot application
	 *
	 */
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
	
	/**
	 * Main method 
	 * @param args
	 */
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
