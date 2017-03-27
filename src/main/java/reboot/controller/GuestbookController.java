package reboot.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
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
	
	@GetMapping(path="/person/add") // Map ONLY GET Requests
	public String addNewUser (@RequestParam Long ID, @RequestParam String name
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
		return "guestbook";
	}

	@GetMapping(path="/person/delete")
	public @ResponseBody void deleteSingleUsers(Long ID) {
		guestbook.delete(ID);
	}
	@GetMapping(path="/person/deleteAll")
	public @ResponseBody void deleteAllUsers() {
		guestbook.deleteAll();
	}
	@GetMapping(path="/person/all")
	public @ResponseBody Iterable<Guest> getAllUsers() {
		// This returns a JSON or XML with the users
		return guestbook.findAll();
	}
	@GetMapping(path="/person/toString")
	public @ResponseBody String toStringAllUsers() {
		return guestbook.toString();
	}
	@GetMapping(path="/person/count")
	public @ResponseBody long countAllUsers() {
		return guestbook.count();
	}
	
	// non working. as well as html form non working
	@GetMapping(path="/find")
	public @ResponseBody Guest findID(@RequestParam Long id) {
		return guestbook.findOne(id);
		
		/*
		guest.setId(n.getId());
		guest.setName(n.getName());
		guest.setAge(n.getAge());
		guest.setGender(n.getGender());
		guest.setOccupation(n.getOccupation());
		guest.setHobbies(n.getHobbies());
		guest.setDescription(n.getDescription());
		*/
	}
}
