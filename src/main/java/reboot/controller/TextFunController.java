package reboot.controller;

import org.springframework.web.bind.annotation.*;

import reboot.model.Greeting;
import reboot.model.TextFunction;
import org.springframework.stereotype.Controller;

@Controller
public class TextFunController {
	
	TextFunction text = new TextFunction();
	
	@PostMapping(path="/toArray")
	public String toArray(@ModelAttribute Greeting greeting) {
		greeting.setContent2(text.toArray(greeting.getContent()));
		greeting.setContent("");
		return "textfun";
	}
	// work on this and below
	@PostMapping(path="/toArrayFindElement")
	public String toArrayFind(@ModelAttribute Greeting greeting) {
		greeting.setContent3(text.toArrayFindElement(greeting.getContent(), (int) greeting.getId2()));
		greeting.setContent("");
		return "textfun";
	}
	
	@PostMapping(path="/toArrayReverse")
	public String toArrayReverse(@ModelAttribute Greeting greeting) {
		greeting.setContent4(text.toArrayReverse(greeting.getContent()));
		greeting.setContent("");
		return "textfun";
	}
	
	@PostMapping(path="/replace")
	public String replace(@ModelAttribute Greeting greeting) {
		greeting.setContent5(text.replaceChars(greeting.getContent(), greeting.getContent98(),
				greeting.getContent99()));
		greeting.setContent("");
		greeting.setContent98("");
		greeting.setContent99("");
		return "textfun";
	}
	//---------------------
	@PostMapping(path="/reverseString")
	public String reverseString(@ModelAttribute Greeting greeting) {
		greeting.setContent6(text.reverse(greeting.getContent()));
		greeting.setContent("");
		return "textfun";
	}
	
	@PostMapping(path="/isPalidrome")
	public String isPalidrome(@ModelAttribute Greeting greeting) {
		greeting.setContent7(text.isPalidrome(greeting.getContent()));
		greeting.setContent("");
		return "textfun";
	}
	
	@PostMapping(path="/repeatMessage")
	public String repeat(@ModelAttribute Greeting greeting) {
		greeting.setContent8(text.repeatMessage(greeting.getContent(), (int) greeting.getId3()));
		greeting.setContent("");
		return "textfun";
	}

}
