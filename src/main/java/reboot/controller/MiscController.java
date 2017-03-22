package reboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MiscController {
	
	@RequestMapping("/index")
	String index() {
		return "index2";
	}

	@RequestMapping("/th-math")
	String math() {
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
}
