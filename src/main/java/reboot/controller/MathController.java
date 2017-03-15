package reboot.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import reboot.model.CalcFunctions;

@Controller
@RequestMapping("/calc")
public class MathController {
	

	

		private Double sum;
		
		private CalcFunctions calc = new CalcFunctions();
		
		@GetMapping(path="/add")
		public @ResponseBody String addNums(@RequestParam double num1, @RequestParam double num2) {
			sum = calc.add(num1, num2);
			return "Sum = " + sum.toString();
		}
		
		@GetMapping(path="/subtract")
		public @ResponseBody String subtractNums(@RequestParam double num1, @RequestParam double num2) {
			sum = calc.subtract(num1, num2);
			return "Sum = " + sum.toString();
		}
		
		@GetMapping(path="/multiply")
		public @ResponseBody String multiplyNums(@RequestParam double num1, @RequestParam double num2) {
			sum = calc.multiply(num1, num2);
			return "Sum = " + sum.toString();
		}
		
		@GetMapping(path="/divide")
		public @ResponseBody String divideNums(@RequestParam double num1, @RequestParam double num2) {
			sum = calc.divide(num1, num2);
			return "Sum = " + sum.toString();
		}
		
		@GetMapping(path="/addThree")
		public @ResponseBody String addThree(@RequestParam double num1, @RequestParam double num2, @RequestParam double num3) {
			sum = calc.addThree(num1, num2, num3);
			return "Sum = " + sum.toString();
		}

		@GetMapping(path="/square")
		public @ResponseBody String square(@RequestParam double num1) {
			sum = calc.square(num1);
			return "Square of " + num1 + " = " + sum.toString();
		}

		@GetMapping(path="/squareRoot")
		public @ResponseBody String squareRoot(@RequestParam double num1) {
			sum = calc.squareRoot(num1);
			return "The square root of " + num1 + " = " + sum.toString();
		}

		@GetMapping(path="/pow")
		public @ResponseBody String pow(@RequestParam double num1, @RequestParam double num2) {
			sum = calc.pow(num1, num2);
			return "Sum = " + sum.toString();
		}

		@GetMapping(path="/isTriangle")
		public @ResponseBody String isTriangle(@RequestParam double num1, @RequestParam double num2, @RequestParam double num3) {
			return calc.isTriangle(num1, num2, num3);
		}
		
		@GetMapping(path="/percent")
		public @ResponseBody String percent(@RequestParam double num1) {
			sum = calc.percent(num1);
			return sum.toString() + "%";
		}

	}
