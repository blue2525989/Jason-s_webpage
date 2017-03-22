package reboot.controller;

import org.springframework.web.bind.annotation.*;

import reboot.model.TextFunction;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/text")
public class TextFunController {
	
	TextFunction text = new TextFunction();
	
	@GetMapping(path="/toArray")
	public @ResponseBody String toArray(String msg) {
		return text.toArray(msg);
	}
	
	@GetMapping(path="/toArrayFindElement")
	public @ResponseBody String toArrayFind(String msg, int ele) {
		return text.toArrayFindElement(msg, ele);
	}
	
	@GetMapping(path="/toArrayReverse")
	public @ResponseBody String toArrayReverse(String msg) {
		return text.toArrayReverse(msg);
	}
	
	@GetMapping(path="/replace")
	public @ResponseBody String toArray(String msg, String oldChar, String newChar) {
		return text.replaceChars(msg, oldChar, newChar);
	}
	
	@GetMapping(path="/reverseString")
	public @ResponseBody String reverseString(String msg) {
		return text.reverse(msg);
	}
	
	@GetMapping(path="/isPalidrome")
	public @ResponseBody boolean isPalidrome(String msg) {
		return text.isPalidrome(msg);
	}
	
	@GetMapping(path="/repeatMessage")
	public @ResponseBody String toArray(String msg, int numTimes) {
		return text.repeatMessage(msg, numTimes);
	}

}
