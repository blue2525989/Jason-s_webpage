package reboot.model;

public class TextFunction {
	/**
	 * 
	 * Jason Bierbrauer
	 * 
	 */
	
	
	/**
	 * 
	 * Using a for loop to send a String to an Array.
	 * @param s1 string to pass for breaking down
	 * @return a formated String containing the Array
	 * 
	 */
	
	public String toArray(String s1) {
		String[] chars = new String[s1.length()-1];
		String newString = "";
		for (int i = 0;i < s1.length()-1;i++) {
			chars[i] = s1.substring(i, i+1);
		}
		for (int i = 0; i < s1.length()-1;i++) {
			newString += "\n char[" + i + "] " + chars[i];
		}
		return "Your String has been broken down to chars,\n" + newString + "\n char[" +
		(s1.length()-1) + "] " + s1.charAt(s1.length()-1);
	}
	
	/**
	 * 
	 * Using a for loop to send a String to an Array and find an element.
	 * @param s1 string to pass for breaking down
	 * @return a formated String containing the Array and Element chosen
	 * 
	 */
	
	public String toArrayFindElement(String s1, int ele) {
		String[] chars = new String[s1.length()-1];
		String newString = "";
		for (int i = 0;i < s1.length()-1;i++) {
			chars[i] = s1.substring(i, i+1);
		}
		for (int i = 0; i < s1.length()-1;i++) {
			newString += "\n char[" + i + "] " + chars[i];
		}
		return "The element you chose was, " + chars[ele] + " " +
				"\nHere is the full Array,\n " + newString + "\n char[" +
		(s1.length()-1) + "] " + s1.charAt(s1.length()-1);
	}
	
	/**
	 *  Using a for loop to send a String to an Array
	 *  @param s1 string to pass for breaking down
	 *  @return a formated String containing the Array
	 */
	public String toArrayReverse(String s1) {
		String[] chars = new String[s1.length()];
		String newString = "";
		int base = s1.length()-1;
		int x = 0;
		for (int i = base; i != -1; i--) {
			chars[x] = s1.substring(i, i+1);
			x += 1;
		}
		for (int i = 0; i < chars.length; i++) {
			newString += "\n char[" + i + "] " + chars[i];
		}
		return "Your String has been reversed down to chars,\n" + newString ;
	}
	
	/**
	 * Using a for loop to reverse a String
	 * @param s1 String to reverse
	 * @return the reversed String
	 */
	public String reverse(String s1) {
		int base = s1.length() - 1;
		String newString = "";
		for (int i = base; i != -1; i--) {
			newString += s1.substring(i,  i + 1);
		}
		return newString;
	}
	
	/**
	 * Check to see if String is Palidrome
	 * @param s1 a String to check
	 * @return true/false result
	 */
	public boolean isPalidrome(String s1) {
		String rev = reverse(s1);
		if (s1.equalsIgnoreCase(rev)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Replace characters in a String
	 * @param s1 a String to reformat
	 * @param newChar is a char to use in String form
	 * @param oldChar is the one to remove in String form
	 * @return a modified String
	 */
	public String replaceChars(String s1, String oldChar, String newChar) {
		s1 = s1.replaceAll(oldChar, newChar);
		return s1;
	}
	
	/**
	 * Use a for loop to print a message a number of times
	 * @param s1 a message to repeat
	 * @param number of times to repeat
	 * @return message printed number of times
	 */
	public String repeatMessage(String s1, int numTimes) {
		String newString = "";
		for (int i = 0; i < numTimes; i++) {
			newString += "\n" + s1;
		}
		return newString;
	}

}
