package reboot.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	// autowire the database credentials to
	@Autowired
	public DataSource ds;
	
	// set access to pages before and after login
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
            .antMatchers("/", "/home", "/resources/**", "/static/**", "/createlogin", "/createUser/**",
            		"/saved2", "/findonegb", "/guestbook", "/view-message**",
            		"/message", "/listallgb", "/find**", "/allmessages", 
            		"/addGuestbook**", "/th-math**", "/hobbies", "/textfun", "/toArray**", "/toArrayFindElement**",
            		"/toArrayReverse**", "/replace**", "/reverseString**", "/repeatMessage**",
            		"/isPalidrome**", "/index", "/poker", "/blueDB", "/alltutorials", "/tutorial",
            		"/view-tutorial**").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login").permitAll().defaultSuccessUrl("/login", true)
                .and()
            .logout()
                .permitAll();
    	// did this to disable csrf error from post methods
    	http.csrf().disable();
    }

    // autowire the credentials
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
   
        // select username and password from database
        auth.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
    }
     
    // all access to these folders
    @Override
	public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "/images/**", "/resources/**", "/static/**");
    }
}