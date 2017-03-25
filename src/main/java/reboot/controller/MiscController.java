package reboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@RequestMapping("/guestbook")
	String guestbook() {
		return "guestbook";
	}
	
	@RequestMapping("/textfun")
	String textFun() {
		return "textfun";
	}
	
	@RequestMapping("/blueDB")
	String blueDB() {
		return "blueDB";
	}
	
    @GetMapping("/test")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "test";
    }

    @PostMapping("/test")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "test";
    }

}
