package reboot.model;

public class CalcFunctions {
	
	/**
	 * 	
	 * By: Jason Bierbrauer
	 * 
	 */
	
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public int subtract(int num1, int num2) {
		return num1 - num2;
	}
	
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	public int divide(int num1, int num2)  {
		return num1 / num2;
	} 
	
	public int addThree(int num1, int num2, int num3) {
		return (num1 + num2) + num3;
	}
	
	public int square(int num1) {
		return (int) Math.pow(num1, 2);
	}
	
	public int squareRoot(int num1) {
		return (int) Math.sqrt(num1);
	}
	
	public int pow(int num1, int num2) {
		return (int) Math.pow(num1,  num2);
	}
	
	public String isTriangle(int num1, int num2, int num3) {
		String msg = "";
		int tri1 = num1 + num2;
		int tri2 = num1 + num3;
		int tri3 = num2 + num3;
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
	
	public int percent(int num1) {
		return (num1 / 100);
	}
	
}