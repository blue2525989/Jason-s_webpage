package reboot.model;

public class CalcFunctions {
	/**
	 * 	
	 * By: Jason Bierbrauer
	 */
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	public double divide(double num1, double num2)  {
		return num1 / num2;
	} 
	
	public double addThree(double num1, double num2, double num3) {
		return (num1 + num2) + num3;
	}
	
	public double square(double num1) {
		return Math.pow(num1, 2);
	}
	
	public double squareRoot(double num1) {
		return Math.sqrt(num1);
	}
	
	public double pow(double num1, double num2) {
		return Math.pow(num1,  num2);
	}
	
	public String isTriangle(double num1, double num2, double num3) {
		String msg = "";
		double tri1 = num1 + num2;
		double tri2 = num1 + num3;
		double tri3 = num2 + num3;
		if (tri1 < num3) {
			msg = "Number three is too large,";
		}
		else if (tri2 < num2) {
			msg = "Number two is too large,";
		}
		else if (tri3 < num1) {
			msg = "Number one is too large,";
		}
		else {
			msg = "This is a Triangle!";
		}
		return msg;
			
	}
	
	public double percent(double num1) {
		return (num1 / 100);
	}
	
}