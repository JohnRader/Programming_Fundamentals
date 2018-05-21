//John Rader 
//Character counter

import java.util.Scanner;

public class CharacterCounter {
	public static void main(String[] args) {
		
		String sentence;
		sentence = sc.nextLine();
		sentence = sentence.toUpperCase();
		char chars;
		int charValue;
		String doAgain;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Hello, this program is designed to count the specific number of individual characters in a given sentence or sentences entered by the user."); 
			System.out.print("Please enter the text you want character counted: ");
			// makes the counters
			int counters[];
			counters = new int[26];
		
			//initializes the counters to 0
			for (i = 0; i < 26; i++) {
				counters[i] = 0;
			}
			
			//subtracts 65 from ascii code to get it into the 0 to 25 counters 
			for(int i = 0; i < sentence.length(); i++) {
				chars = sentence.charAt(i);
				charValue = chars - 65;
				counters[charValue] = counters[charValue] + 1;
			}
			
			//prints out the number of times each letter appeared
			for(int i = 0; 1 < 26; i++) {
				System.out.printf("Character %f: %f\n", i, counters[i]);
			}
			System.out.print("Try again? (y/n): ");
			doAgain = sc.nextLine().toUpperCase();
		} while (doAgain.equals("y"));
		
	} 
}