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
	
		
	@Autowired
	public DataSource ds;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
            .antMatchers("/", "/home", "/resources/**", "/static/**", "/createlogin", "/createUser/**",
            		"/saved2").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login").permitAll().defaultSuccessUrl("/hello", true)
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
   
        
        auth.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
    }
     
    @Override
	public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "/images/**", "/resources/**", "/static/**");
    }
}