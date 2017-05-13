package reboot.controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import reboot.model.Post;
import reboot.model.PostSub;
import reboot.model.Users;
import reboot.repository.PostRepository;
import reboot.repository.SubPostRepository;
import reboot.repository.UserRepository;

@Controller
public class MessageController {

	// instance of GuestBookRepository
	private PostRepository messages;
	private SubPostRepository subPostRepo;
	private UserRepository userRepo;
	
	// autowire the repository to the controller
	@Autowired
	public MessageController(PostRepository messages, SubPostRepository subPostRepo
			,UserRepository userRepo) {
		this.messages = messages;
		this.userRepo = userRepo;
		this.subPostRepo = subPostRepo;
	}
	
	// add all entires to message.html
    @RequestMapping("/message")
	public String listAllMsg(Model model) {
		List<Post> messageList = messages.findAll();
		if (messageList != null) {
			model.addAttribute("messages", messageList);
		}	
		return "message-board/message";
	}
    
    @RequestMapping("/view-message")
    public String viewMessage(Model model, @RequestParam Long id) {
    	Post messageList = messages.findById(id);
    	List<PostSub> subList = subPostRepo.findAll();
    	List<PostSub> realSubList = new ArrayList<>();
    	for (int i = 0; i < subList.size(); i++){
    		if (subList.get(i).getMasterId() == id) {
    			realSubList.add(subList.get(i));
    		}
    	}
    	if (messageList != null) {
    		model.addAttribute("messages", messageList);
    		model.addAttribute("subposts", realSubList);
    	}
		return "message-board/message-view";
    }
		
	// returns all of the messages in the database
	@GetMapping("/allmessages")
	public String readersMessages() {
		return "redirect:/message";
	}
	
	@GetMapping(path="/addMessage")
	// request params to save
	public String addNewMessage (Model model, @RequestParam String message, 
			@RequestParam Long masterId,
			@RequestParam String userName) {
		Users user = userRepo.findByUsername(userName);
		Long userId = user.getId();
		Calendar date = Calendar.getInstance();
		Date curDate = date.getTime();
		String current = curDate.toString();
		// new instance of message
		PostSub n = new PostSub();
		n.setMessage(message);
		n.setDate(current);
		n.setUserId(userId);
		n.setMasterId(masterId);
		n.setUsername(userName);
		subPostRepo.save(n);
		model.addAttribute("subPost", n);
		return "redirect:/view-message?id=" + masterId;
	}
	
	@RequestMapping("/message-add")
	public String messageAddPage() {
		return "/message-add";
	}
	
	@GetMapping(path="/addPost")
	// request params to save
	public String addNewPost (Model model, @RequestParam String name
			, @RequestParam String message,
			@RequestParam String userName) {
		Users user = userRepo.findByUsername(userName);
		Long userId = user.getId();
		Calendar date = Calendar.getInstance();
		Date curDate = date.getTime();
		String current = curDate.toString();
		// new instance of message
		Post n = new Post();
		n.setName(name);
		n.setMessage(message);
		n.setDate(current);
		n.setUserId(userId);
		n.setUsername(userName);
		messages.save(n);
		List<Post> messageList = messages.findAll();
		if (messageList != null) {
			model.addAttribute("messages", messageList);
		}
		return "redirect:/allmessages";
	}

}
