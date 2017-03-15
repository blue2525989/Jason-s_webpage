package reboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller  
@RequestMapping("/createLogin")
public class CreateLoginController {
	
    //Useful for obtaining connection if no DB is selected
    String SQL = "SELECT * FROM "; 
    Connection con;
    Statement stmt1;
    ResultSet rs;
    
    /**
     * save button saves all data from
     * textAreas in to user selected table
     */
    @GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String username
			, @RequestParam String password, @RequestParam boolean enabled, @RequestParam Long ID) {       
            //Try to insert new entrie into table
            try {
            	String MySQL = "jdbc:mysql://jasonspage.cfqhitdy3uy2.us-west-2.rds.amazonaws.com/jasonsPage?user=blue&password=jason987&useSSL=true";
                String SQL = "insert into users (username, password, enabled) values ('"+ username +"', '"+ password +"', true)";
                //Opens connection to the new selection
                con = DriverManager.getConnection(MySQL);
                if (con != null) {
                	System.out.println("Debug: connection is not null");
                }
                //Opens a ResultSet of selected db
                stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs = stmt1.executeQuery(SQL);
                stmt1.execute(SQL);
                
        } catch (SQLException err) {
        	//error
    }
        return "Saved!";
	
    }
}
