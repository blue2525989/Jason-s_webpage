package reboot.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/createUser")
public class UserController {

	/**
	 * This creates a new user to access the main site.
	 * @param username
	 * @param password
	 * @return saved message	
	 */
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public String addNewUser (@RequestParam String username
			, @RequestParam String password, HttpSession session) {

        //Get connection
		String error = "";
		if (username.length() < 4 || username.length() > 16) {
			error = "Username must be between 4 and 16 characters.";
			session.setAttribute("error", error);
			return "redirect:/createlogin";
		}
		else if (password.length() < 4 || password.length() > 16) {
			error = "Password must be between 4 and 16 characters.";
			session.setAttribute("error", error);
			return "redirect:/createlogin";
		}
		
    	Connection con;
        Connection con2;
        Statement stmt = null;
                try{
                    String MySQL = "jdbc:mysql://jasonspage.cfqhitdy3uy2.us-west-2.rds.amazonaws.com:3306/jasonsPage?user=blue&password=jason987&useSSL=false";
                    String SQL = "insert into users (username, password, enabled, ID) values ('" + username + "', '" + password + "', true, 0)";
                    String SQL2 = "insert into user_roles (username, role) values ('" + username + "', 'ROLE_USER')";
                    //Opens connection to the new selection
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection(MySQL);
                    con2 = DriverManager.getConnection(MySQL);
                    //Creates database
                    stmt = con.createStatement();
                    stmt.execute(SQL);
                    stmt = con2.createStatement();
                    stmt.execute(SQL2);
                } catch (SQLException e) {
                	System.out.println(e.getMessage());
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                return "redirect:/saved2";
	}
	
}
