package reboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reboot.model.Greeting;
import reboot.model.Numbers;

@Controller
public class MiscController {
	
	@RequestMapping("/index")
	String index() {
		return "index2";
	}

	@GetMapping("/th-math")
	public String math(Model model) {
        model.addAttribute("numbers", new Numbers());
		return "th-math";
	}
	
	@RequestMapping("/hobbies")
	String hobbies() {
		return "hobbies";
	}
	
	@GetMapping("/guestbook")
	public String guestbook() {
		return "guestbook";
	}
	
	@GetMapping("/textfun")
	public String textFun(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "textfun";
	}
	
	@RequestMapping("/blueDB")
	String blueDB() {
		return "blueDB";
	}
}
