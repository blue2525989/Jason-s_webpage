package reboot.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import reboot.model.CalcFunctions;
import reboot.model.Numbers;

@Controller
public class MathController {

		private CalcFunctions calc = new CalcFunctions();
		
		@PostMapping(path="/th-math")
		public String addNums(
				@ModelAttribute Numbers numbers) {
			numbers.sum1 = 0;
			numbers.sum1 = calc.add(numbers.getNum1(), numbers.getNum2());
			numbers.setNum1(0);
			numbers.setNum2(0);
			return "th-math";
		}
		
		@PostMapping(path="/th-math2")
		public String subNums(
				@ModelAttribute Numbers numbers) {
			numbers.sum2 = 0;
			numbers.sum2 = calc.subtract(numbers.getNum1(), numbers.getNum2());
			numbers.setNum1(0);
			numbers.setNum2(0);
			return "th-math";
		}
		
		@PostMapping(path="/th-math3")
		public String multNums(
				@ModelAttribute Numbers numbers) {
			numbers.sum3 = 0;
			numbers.sum2 = calc.multiply(numbers.getNum1(), numbers.getNum2());
			numbers.setNum1(0);
			numbers.setNum2(0);
			return "th-math";
		}
		
		@PostMapping(path="/th-math4")
		public String divNums(
				@ModelAttribute Numbers numbers) {
			numbers.sum4 = 0;
			numbers.sum2 = calc.divide(numbers.getNum1(), numbers.getNum2());
			numbers.setNum1(0);
			numbers.setNum2(0);
			return "th-math";
		}
		
		@PostMapping(path="/th-math5")
		public String addThreeNums(
				@ModelAttribute Numbers numbers) {
			numbers.sum5 = 0;
			numbers.sum5 = calc.addThree(numbers.getNum1(), numbers.getNum2(), numbers.getNum3());
			numbers.setNum1(0);
			numbers.setNum2(0);
			numbers.setNum3(0);
			return "th-math";
		}
		
		@PostMapping(path="/th-math6")
		public String squareNums(
				@ModelAttribute Numbers numbers) {
			numbers.sum6 = 0;
			numbers.sum6 = calc.square(numbers.getNum1());
			numbers.setNum1(0);
			return "th-math";
		}
		
		@PostMapping(path="/th-math7")
		public String sqrtNums(
				@ModelAttribute Numbers numbers) {
			numbers.sum7 = 0;
			numbers.sum7 = calc.squareRoot(numbers.getNum1());
			numbers.setNum1(0);
			return "th-math";
		}
		
		@PostMapping(path="/th-math8")
		public String powNums(
				@ModelAttribute Numbers numbers) {
			numbers.sum8 = 0;
			numbers.sum8 = calc.pow(numbers.getNum1(), numbers.getNum2());
			numbers.setNum1(0);
			numbers.setNum2(0);
			return "th-math";
		}
	}
