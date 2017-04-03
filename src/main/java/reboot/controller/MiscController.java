package reboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reboot.model.Greeting;
import reboot.model.Numbers;

@Controller
public class MiscController {
	
	// index view
	@RequestMapping("/index")
	String index() {
		return "index2";
	}

	// math view with Numbers model added
	@GetMapping("/th-math")
	public String math(Model model) {
        model.addAttribute("numbers", new Numbers());
		return "th-math";
	}
	
	// hobbies view
	@RequestMapping("/hobbies")
	String hobbies() {
		return "hobbies";
	}

	// guestbook view
	@GetMapping("/guestbook")
	public String guestbook() {
		return "guestbook";
	}
	
	// saved view
	@RequestMapping("/saved")
	public String savedGB() {
		return "saved";
	}

	// text-fun view with Greeting model added
	@GetMapping("/textfun")
	public String textFun(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "textfun";
	}
	
	// blueDB view
	@RequestMapping("/blueDB")
	String blueDB() {
		return "blueDB";
	}
	
	// poker view
	@RequestMapping("/poker")
	String poker() {
		return "poker";
	}
	
	@RequestMapping("/createlogin")
	String createlogin() {
		return "createlogin";
	}
	
	// saved view
	@RequestMapping("/saved2")
	public String saved2() {
		return "saved2";
	}
}
