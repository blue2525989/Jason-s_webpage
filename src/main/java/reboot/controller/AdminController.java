package reboot.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reboot.model.UpdateMessages;
import reboot.repository.GuestbookRepository;
import reboot.repository.MessageRepository;
import reboot.repository.UpdateRepository;

@Controller
public class AdminController {
	
	// these are methods for the admin to use on the guestbook.
	// instance of GuestBookRepository
	private GuestbookRepository guestbook;
	
	// instance of MessageRepository
	private MessageRepository messages;
	
	// instance of UpdateRepsoitory
	private UpdateRepository updatelog;
	
	//autowire the repository to the controller
	@Autowired
	public AdminController(GuestbookRepository guestbook, MessageRepository messages,
			UpdateRepository updatelog) {
		this.guestbook = guestbook;
		this.messages = messages;
		this.updatelog = updatelog;
	}
		
	/**
	 * 
	 * Use session attributes. They seem to be easier to work 
	 * with than adding on parameters to the end of the 
	 * redirect.
	 * 
	 */
	
	/**
	 * 
	 * These methods are for the guestbook 
	 * 
	 */
	
	@GetMapping(path="/delete")
	public String deleteSingleUsers(Long ID, HttpSession session) {
		guestbook.delete(ID);
		String saved = "The user with ID " + ID + " has been deleted.";
		session.setAttribute("saved", saved);
		return "redirect:/saved3";
	}
	@GetMapping(path="/deleteAll")
	public String deleteAllUsers(HttpSession session) {
		guestbook.deleteAll();
		String saved = "All entries have been deleted.";
		session.setAttribute("saved", saved);
		return "redirect:/saved3";
	}
	
	@GetMapping(path="/count")
	public String countAllUsers(HttpSession session) {
		Long count = guestbook.count();
		String saved = "There are " + count + " entries in the guestbook.";
		session.setAttribute("saved", saved);
		return "redirect:/saved3";
	}
	
	/**
	 * 
	 * These methods are for the message board
	 * 
	 */
	
	@GetMapping(path="/deleteMessage")
	// request params to delete
	public String deleteMessage (@RequestParam Long ID, HttpSession session) {
		messages.delete(ID);
		String saved = "Message with ID " + ID + " has been deleted from the message board.";
		session.setAttribute("saved", saved);
		return "redirect:/saved3";
	}
	
	/**
	 * 
	 * These methods are for the updates
	 * 
	 */
	
	
	
		// saves the update to the repositry
		@GetMapping(path="/addUpdate")
		// request params to save
		public String addUpdate (@RequestParam String message, HttpSession session, 
				@ModelAttribute UpdateMessages updates) {
				
			// this adds current date and time to a session attribute
			Calendar date = Calendar.getInstance();
			TimeZone timezone = date.getTimeZone();
			Calendar date2 = Calendar.getInstance(timezone);
			Date curDate = date2.getTime();
			String current = curDate.toString();
			
			UpdateMessages update = new UpdateMessages();
			update.setDate(current);
			update.setContent(message);
			updatelog.save(update);
					
			String saved = "The update has been added to the main page.";
			session.setAttribute("saved", saved);
				
			return "redirect:/saved3";
		}

		@GetMapping(path="/deleteUpdate")
		// request params to delete
		public String deleteUpdate (@RequestParam Long ID, HttpSession session) {
			messages.delete(ID);
			String saved = "Update with ID " + ID + " has been deleted from the main page.";
			session.setAttribute("saved", saved);
			return "redirect:/saved3";
		}
		
		// add all entires to listallgb.html
		@RequestMapping("/listallupdates")
		public String listAllUpdates(Model model) {
			List<UpdateMessages> updateList = updatelog.findAll();
			if (updateList != null) {
				model.addAttribute("updates", updateList);
			}	
			return "listallupdates";
		}
		
		// returns all of the guests in database
		@GetMapping("/allUpdates")
		public String updates(Model model) {
			return "redirect:/listallupdates";
		}

}
