package reboot.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import reboot.model.Guest;
import reboot.repository.GuestbookRepository;

@Controller
@RequestMapping("/person")
public class GuestbookController {

	private GuestbookRepository guestbook;
	
	@Autowired
	public GuestbookController(GuestbookRepository guestbook) {
		this.guestbook = guestbook;
	}
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam Long ID, @RequestParam String name
			, @RequestParam String gender, @RequestParam Long age, @RequestParam String description, @RequestParam String occupation,
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
		return "Saved";
	}

	@GetMapping(path="/delete")
	public @ResponseBody void deleteSingleUsers(Long ID) {
		guestbook.delete(ID);
	}
	@GetMapping(path="/deleteAll")
	public @ResponseBody void deleteAllUsers() {
		guestbook.deleteAll();
	}
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Guest> getAllUsers() {
		// This returns a JSON or XML with the users
		return guestbook.findAll();
	}
	@GetMapping(path="/toString")
	public @ResponseBody String toStringAllUsers() {
		return guestbook.toString();
	}
	@GetMapping(path="/count")
	public @ResponseBody long countAllUsers() {
		return guestbook.count();
	}
	@GetMapping(path="/find")
	public @ResponseBody Guest findID(Long ID) {
		return guestbook.findOne(ID);
	}
}
