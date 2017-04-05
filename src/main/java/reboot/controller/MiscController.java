package reboot.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reboot.model.Greeting;
import reboot.model.Numbers;

@Controller
public class MiscController {

	
	// index view
	@RequestMapping("/index")
	String index(HttpSession session) {
		
		// this adds current date and time to a session attribute
		Calendar date = Calendar.getInstance();
		TimeZone timezone = date.getTimeZone();
		Calendar date2 = Calendar.getInstance(timezone);
		Date curDate = date2.getTime();
		String current = curDate.toString();
		session.setAttribute("curdate", current);
		
		// this checks for user level
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
				
		return "index2";
	}
	
	@RequestMapping("/adminpage")
	String admin(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();
		if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		// this shouldn't be possible but just in case.
		else if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		return "admin";
	}

	// math view with Numbers model added
	@GetMapping("/th-math")
	public String math(Model model, HttpSession session) {
        model.addAttribute("numbers", new Numbers());
        boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "th-math";
	}
	
	// hobbies view
	@RequestMapping("/hobbies")
	String hobbies(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "hobbies";
	}

	// guestbook view
	@GetMapping("/guestbook")
	public String guestbook(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "guestbook";
	}
	
	// saved view
	@RequestMapping("/saved")
	public String savedGB(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "saved";
	}

	// text-fun view with Greeting model added
	@GetMapping("/textfun")
	public String textFun(Model model, HttpSession session) {
		model.addAttribute("greeting", new Greeting());
		
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "textfun";
	}
	
	// blueDB view
	@RequestMapping("/blueDB")
	String blueDB(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "blueDB";
	}
	
	// poker view
	@RequestMapping("/poker")
	String poker(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "poker";
	}
	
	@RequestMapping("/createlogin")
	String createlogin() {
		return "createlogin";
	}
	
	// saved view
	@RequestMapping("/saved2")
	public String saved2(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "saved2";
	}
	
	// saved view for admin
	@RequestMapping("/saved3")
	public String saved3(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "saved3";
	}
	
	/**
	 * This method checks the users authentication level
	 * @return true or false
	 */
	
	public boolean hasUserRole() {
		// this checks to see if a user has a user role
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		         .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
		return hasUserRole;
	}
	
	/**
	 * This method returns the users authentication level
	 * @return true or false
	 * 
	 */
	
	public boolean hasAdminRole() {
		// this checks to see if a user has a admin role.
		Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
		boolean hasAdminRole = authentication2.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		return hasAdminRole;
	}
			
	
}
