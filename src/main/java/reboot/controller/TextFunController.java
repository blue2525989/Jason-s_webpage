package reboot.controller;

import org.springframework.web.bind.annotation.*;

import reboot.model.Greeting;
import reboot.model.TextFunction;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TextFunController extends PermissionController{
	
	TextFunction text = new TextFunction();

	// text-fun view with Greeting model added
	@GetMapping("/textfun")
	public String textFun(Model model, HttpSession session) {
		model.addAttribute("greeting", new Greeting());
		
		boolean hasUserRole = hasUserRole();
		boolean hasAdminRole = hasAdminRole();		
		if (hasUserRole) {
			session.setAttribute("userrole", hasUserRole);
		}
		else if (hasAdminRole) {
			session.setAttribute("adminrole", hasAdminRole);
		}
		return "misc/textfun";
	}
	
	// send message to array
	@PostMapping(path="/toArray")
	public String toArray(@ModelAttribute Greeting greeting) {
		greeting.setContent2(text.toArray(greeting.getContent()));
		greeting.setContent("");
		return "misc/textfun";
	}
	
	// find specific element
	@PostMapping(path="/toArrayFindElement")
	public String toArrayFind(@ModelAttribute Greeting greeting) {
		greeting.setContent3(text.toArrayFindElement(greeting.getContent(), (int) greeting.getId2()));
		greeting.setContent("");
		return "misc/textfun";
	}
	
	// reverse string and breaks down to array
	@PostMapping(path="/toArrayReverse")
	public String toArrayReverse(@ModelAttribute Greeting greeting) {
		greeting.setContent4(text.toArrayReverse(greeting.getContent()));
		greeting.setContent("");
		return "misc/textfun";
	}
	
	// replace chars in a string
	@PostMapping(path="/replace")
	public String replace(@ModelAttribute Greeting greeting) {
		greeting.setContent5(text.replaceChars(greeting.getContent(), greeting.getContent98(),
				greeting.getContent99()));
		greeting.setContent("");
		greeting.setContent98("");
		greeting.setContent99("");
		return "misc/textfun";
	}
	
	// reverse a string
	@PostMapping(path="/reverseString")
	public String reverseString(@ModelAttribute Greeting greeting) {
		greeting.setContent6(text.reverse(greeting.getContent()));
		greeting.setContent("");
		return "misc/textfun";
	}
	
	// checks to see if palidrome or not
	@PostMapping(path="/isPalidrome")
	public String isPalidrome(@ModelAttribute Greeting greeting) {
		greeting.setContent7(text.isPalidrome(greeting.getContent()));
		greeting.setContent("");
		return "misc/textfun";
	}
	
	// repeat a message
	@PostMapping(path="/repeatMessage")
	public String repeat(@ModelAttribute Greeting greeting) {
		greeting.setContent8(text.repeatMessage(greeting.getContent(), (int) greeting.getId3()));
		greeting.setContent("");
		return "misc/textfun";
	}

}
