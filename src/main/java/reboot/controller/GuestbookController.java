package reboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import reboot.model.Guest;
import reboot.repository.GuestbookRepository;

@Controller
public class GuestbookController extends PermissionController{

	// instance of GuestBookRepository
	private GuestbookRepository guestbook;
	
	// autowire the repository to the controller
	@Autowired
	public GuestbookController(GuestbookRepository guestbook) {
		this.guestbook = guestbook;
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
		return "guestbook/guestbook";
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
		return "sys-views/saved";
	}	
	
	// saves the guest to the repositry
	@GetMapping(path="/add")
	// request params to save
	public String addNewUser (@RequestParam Long ID, @RequestParam String name
			, @RequestParam String gender, @RequestParam Long age, 
			@RequestParam String description, @RequestParam String occupation,
			@RequestParam String hobbies) {
		// new instance of guest
		Guest n = new Guest();
		n.setId(ID);
		n.setName(name);
		n.setGender(gender);
		n.setAge(age);
		n.setDescription(description);
		n.setOccupation(occupation);;
		n.setHobbies(hobbies);
		guestbook.save(n);
		return "redirect:/saved";
	}
		
	// add all entires to listallgb.html
	@RequestMapping("/listallgb")
	public String listAllGb(Model model) {
		List<Guest> guestList = guestbook.findAll();
		if (guestList != null) {
			model.addAttribute("guests", guestList);
		}	
		return "guestbook/listallgb";
	}
	
	// returns all of the guests in database
	@GetMapping("/all")
	public String readersBooks(Model model) {
		return "redirect:/listallgb";
	}
	
	// finds a specific person based on ID
	@RequestMapping("/find")
	public String findOneGb(Model model, @RequestParam Long id) {
		List<Guest> guestList = guestbook.findById(id);
		if (guestList != null) {
			model.addAttribute("guests", guestList);
		}	
		return "guestbook/findonegb";
	}

}
