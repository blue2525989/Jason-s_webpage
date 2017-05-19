package reboot.controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

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
public class MessageController extends PermissionController{

	// instance of Repositories
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
	
	/**
	 * main message board view
	 * @param model add's all post topics as links
	 * @return main meassge.html view
	 */
	
    @RequestMapping("/message")
	public String listAllMsg(Model model, HttpSession session) {
		List<Post> messageList = messages.findAll();
		// reverse the list so newest post is first
		List<Post> reversedList = new ArrayList<>();
		for (int i = messageList.size()-1; i >= 0; i--) {
			reversedList.add(messageList.get(i));
		}
		if (messageList != null) {
			model.addAttribute("messages", reversedList);
		}	
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "message-board/message";
	}
    
    /**
     * view a specific post
     * @param model add's main post and sub posts to view
     * @param id of main post
     * @return message-view.html with main post and subposts
     */ 
    
    @RequestMapping("/view-message")
    public String viewMessage(Model model, @RequestParam Long id, HttpSession session) {
    	Post messageList = messages.findById(id);
    	// find all subposts with matching masterId from main post
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
    	boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "message-board/message-view";
    }
		
	/**
	 * redirects to message.html
	 * @return redirect to message.html
	 */
    
	@GetMapping("/allmessages")
	public String readersMessages() {
		return "redirect:/message";
	}
		
	/**
	 * add a new post view
	 * Has to be GetMapping, RequestMapping doesn't work on live server.
	 * @return message-add.html
	 */
	
	@GetMapping("/message-add")
	public String messageAddPage(HttpSession session) {
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "message-board/message-add";
	}
	
	/**
	 * add a new post
	 * @param model adds attributes
	 * @param name title of the post
	 * @param message the post content
	 * @param userName name of user who posted
	 * @return the main message board view message.html
	 */
	
	@PostMapping(path="/addPost")
	// request params to save
	public String addNewPost (Model model, @RequestParam String name
			, @RequestParam String message,
			@RequestParam String userName) {
		// if no message was entered
		if (name == null) {
			String error = "You must enter a message.";
			model.addAttribute("error", error);
			return "redirect:/message-add";
		}
		// find user's info by checking username
		Users user = userRepo.findByUsername(userName);
		// get user's id
		Long userId = user.getId();
		// get date time // need to add time zone or soemthing
		Calendar date = Calendar.getInstance();
		date.setTimeZone(TimeZone.getTimeZone("CDT"));
		TimeZone timezone = date.getTimeZone();
		Calendar date2 = Calendar.getInstance(timezone);
		Date curDate = date2.getTime();
		String current = curDate.toString();
		// new instance of message
		Post post = new Post();
		post.setName(name);
		post.setMessage(message);
		post.setDate(current);
		post.setUserId(userId);
		post.setUsername(userName);
		messages.save(post);
		Post post2 = messages.findByName(name);
		Long id = post2.getId();
		// get the list of posts
		List<Post> messageList = messages.findAll();
		List<Post> reversedList = new ArrayList<>();
		// reverse the list so the newest shows up first
		for (int i = messageList.size() -1; i >= 0; i--) { 
			reversedList.add(messageList.get(i));
		}
		if (messageList != null) {
			model.addAttribute("messages", reversedList);
		}
		return "redirect:/view-message?id=" + id;
	}
	
	/**
	 * adds a sub post
	 * @param model add attributes to view
	 * @param message content of sub post
	 * @param masterId id of the master post
	 * @param userName for getting the id of the user who posted
	 * @return the masterPost view
	 */
	
	@PostMapping(path="/addMessage")
	public String addNewMessage (Model model, @RequestParam String message, 
			@RequestParam Long masterId,
			@RequestParam String userName) {
		if (message == null) {
			String error = "Please enter a message.";
			model.addAttribute("error", error);
			return "redirect:/view-message?id=" + masterId;
		}
		// get user's info by checking username
		Users user = userRepo.findByUsername(userName);
		// get user's id
		Long userId = user.getId();
		// get current date time // need to add time zone to this one too
		Calendar date = Calendar.getInstance();
		date.setTimeZone(TimeZone.getTimeZone("CDT"));
		TimeZone timezone = date.getTimeZone();
		Calendar date2 = Calendar.getInstance(timezone);
		Date curDate = date2.getTime();
		String current = curDate.toString();
		// new instance of message
		PostSub sub = new PostSub();
		sub.setMessage(message);
		sub.setDate(current);
		sub.setUserId(userId);
		sub.setMasterId(masterId);
		sub.setUsername(userName);
		subPostRepo.save(sub);
		return "redirect:/view-message?id=" + masterId;
	}

}
