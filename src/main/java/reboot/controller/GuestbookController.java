package reboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import reboot.model.Guest;
import reboot.repository.GuestbookRepository;

@Controller
public class GuestbookController {

	private GuestbookRepository guestbook;
	
	@Autowired
	public GuestbookController(GuestbookRepository guestbook) {
		this.guestbook = guestbook;
	}
	
	@GetMapping(path="/add")
	public String addNewUser (@RequestParam Long ID, @RequestParam String name
			, @RequestParam String gender, @RequestParam Long age, 
			@RequestParam String description, @RequestParam String occupation,
			@RequestParam String hobbies) {

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
		
	@RequestMapping("/listallgb")
	public String listAllGb(Model model) {
		List<Guest> guestList = guestbook.findAll();
		if (guestList != null) {
			model.addAttribute("guests", guestList);
		}	
		return "listallgb";
	}
	
	@GetMapping("/all")
	public String readersBooks(Model model) {
		return "redirect:/listallgb";
	}
	
	@RequestMapping("/find")
	public String findOneGb(Model model, @RequestParam Long id) {
		List<Guest> guestList = guestbook.findById(id);
		if (guestList != null) {
			model.addAttribute("guests", guestList);
		}	
		return "findonegb";
	}

}
