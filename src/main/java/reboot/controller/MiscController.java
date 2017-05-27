package reboot.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import reboot.model.UpdateMessages;
import reboot.repository.UpdateRepository;

@Controller
public class MiscController extends PermissionController{

	// instance of UpdateRepsoitory
		private UpdateRepository updatelog;
		
	//autowire the repository to the controller
	@Autowired
	public MiscController(UpdateRepository updatelog) {
		this.updatelog = updatelog;
	}
	
	// view for template 2 for testing
	@RequestMapping("/temp2")
	public String template2() {
		return "template2";
	}
	
	// index view
	@RequestMapping("/")
	String index(HttpSession session, Model model) {
		
		// add model for updates
		List<UpdateMessages> updateList = updatelog.findAll();
		List<UpdateMessages> reversedList = new ArrayList<>();
		for (int i = updateList.size()-1; i >= 0; i--) {
			reversedList.add(updateList.get(i));
		}
		if (reversedList != null) {
			model.addAttribute("updates", reversedList);
		}	
		
		// this adds current date and time to a session attribute
		Calendar date = Calendar.getInstance();
		date.setTimeZone(TimeZone.getTimeZone("CDT"));
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
		return "misc/hobbies";
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
		return "projects/blueDB";
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
		return "projects/poker";
	}
	
	// text encrypter view
	@RequestMapping("/encrypter")
	String encypter(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "projects/encrypter";
	}
	
	// returns create a new user view
	@RequestMapping("/createlogin")
	String createlogin() {
		return "createlogin";
	}			
	
}
