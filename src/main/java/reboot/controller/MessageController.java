package reboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import reboot.model.Message;
import reboot.repository.MessageRepository;

@Controller
public class MessageController {

	// instance of GuestBookRepository
	private MessageRepository messages;
	
	// autowire the repository to the controller
	@Autowired
	public MessageController(MessageRepository messages) {
		this.messages = messages;
	}
	
	// add all entires to message.html
    @RequestMapping("/message")
	public String listAllGb(Model model) {
		List<Message> messageList = messages.findAll();
		if (messageList != null) {
			model.addAttribute("messages", messageList);
		}	
		return "message";
	}
		
	// returns all of the messages in the database
	@GetMapping("/allmessages")
	public String readersBooks() {
		return "redirect:/message";
	}
	
	@GetMapping(path="/addMessage")
	// request params to save
	public String addNewUser (@RequestParam String name
			, @RequestParam String message) {
		// new instance of guest
		Message n = new Message();
		n.setName(name);
		n.setMessage(message);
		messages.save(n);
		return "redirect:/allmessages";
	}

}
