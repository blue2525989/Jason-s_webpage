package reboot.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import reboot.model.Tutorial;
import reboot.repository.TutorialRepository;

@Controller
public class TutorialController extends PermissionController{

	// instance of Repositories
	private TutorialRepository tutorials;
	
	// autowire the repository to the controller
	@Autowired
	public TutorialController(TutorialRepository tutorial) {
		this.tutorials = tutorial;
	}
	
	/**
	 * main tutorial view
	 * @param model add's all tutorials as links
	 * @return main tutorial.html view
	 */
	
    @RequestMapping("/tutorial")
	public String listAllTutorials(Model model, HttpSession session) {
		List<Tutorial> tutorialList = tutorials.findAll();
		// reverse the list so newest post is first
		List<Tutorial> reversedList = new ArrayList<>();
		for (int i = tutorialList.size()-1; i >= 0; i--) {
			reversedList.add(tutorialList.get(i));
		}
		if (reversedList != null) {
			model.addAttribute("tutorials", reversedList);
		}	
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "tutorials/tutorial";
	}
    
    /**
     * view a specific tutorial
     * @return tutorial-view.html 
     */ 
    
    @RequestMapping("/view-tutorial")
    public String viewTutorials(Model model, @RequestParam Long id, HttpSession session) {
    	Tutorial tutorialList = tutorials.findById(id);
    	if (tutorialList != null) {
    		model.addAttribute("tutorials", tutorialList);
    	}
    	boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "tutorials/tutorial-view";
    }
		
	/**
	 * redirects to tutorial.html
	 * @return redirect to tutorial.html
	 */
    
	@GetMapping("/alltutorials")
	public String redirectTutorials() {
		return "redirect:/tutorial";
	}
		
	/**
	 * add a new tutorial view
	 * Has to be GetMapping, RequestMapping doesn't work on live server.
	 * @return tutorial-add.html
	 */
	
	@GetMapping("/tutorial-add")
	public String tutorialAddPage(HttpSession session, Model model) {
		model.addAttribute("tutorial", new Tutorial());
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "tutorials/tutorial-add";
	}
	
	/**
	 * add a new tutorial
	 * @param
	 * @return
	 */
	
	@RequestMapping(value="/addTutorial", method=RequestMethod.POST)
	// request params to save
	public String addNewTutorial(Model model, @RequestParam String name
			, @RequestParam String block1, HttpSession session) {
		// if no message was entered
		if (name == null) {
			// need to add this part to html pages on all
			// instances of error
			String error = "You must enter a name for the tutorial.";
			session.setAttribute("error", error);
			return "redirect:/tutorial-add";
		}
		else if (block1 == null) {
			String error = "You must enter some content.";
			session.setAttribute("error", error);
			return "redirect:/tutorial-add";
		}
		// new instance of tutorial
		Tutorial tut = new Tutorial();
		tut.setName(name);
		tut.setBlock1(block1);
		tutorials.save(tut);
		// get the list of tutorials
		List<Tutorial> tutorialList = tutorials.findAll();
		List<Tutorial> reversedList = new ArrayList<>();
		// reverse the list so the newest shows up first
		for (int i = tutorialList.size() -1; i >= 0; i--) { 
			reversedList.add(tutorialList.get(i));
		}
		if (reversedList != null) {
			model.addAttribute("tutorials", reversedList);
		}
		return "redirect:/alltutorials";
	}
	
}
