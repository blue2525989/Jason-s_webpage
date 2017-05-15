package reboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	// these are the credentials to login to database
	@Bean(name = "dataSource")
	 public DriverManagerDataSource dataSource() {
		 DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		 driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 driverManagerDataSource.setUrl("jdbc:mysql://jasonspage.cfqhitdy3uy2.us-west-2.rds.amazonaws.com:3306/jasonsPage");
		 driverManagerDataSource.setUsername("blue");
		 driverManagerDataSource.setPassword("jason987");
		 return driverManagerDataSource;
	 }
	

	// add view controllers for pages that deal with spring security
    public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/home").setViewName("home");
	    registry.addViewController("/").setViewName("home");
	    registry.addViewController("/login").setViewName("login");
    }
    
    
}
