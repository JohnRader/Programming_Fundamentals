/* John Rader
This code creates a gradebook out of a given text of grades.
*/

import java.util.Scanner;
import java.io.*;

public class RaderEncryption{
/*
This is a simple heading function.
*/
	public static void heading(){
		System.out.println("**************************************************");
		System.out.println("        WELCOME TO THE ENCRYPTOR");
		System.out.println("**************************************************");

	}

	public static String rfEncrypt(String line){
		String encrypted = "";
		char chEven;
		char chOdd;
		String evenChars = "";
		String oddChars = "";
		for (int i = 0; i < line.length(); i = i + 2){
			chEven = line.charAt(i);
			evenChars = evenChars + chEven;
		}
		for (int i = 1; i < line.length(); i = i + 2){
			chOdd = line.charAt(i);
			oddChars = oddChars + chOdd;
		}
		encrypted = encrypted + evenChars + oddChars;
		return encrypted;
		}
		
	

	public static boolean rfFile(String originalFile, String encrypted){
		try{
			File inFile = new File(originalFile);
			Scanner filesc = new Scanner(inFile);
			PrintWriter pw = new PrintWriter(new BufferedWriter(
				new FileWriter(new File(encrypted))));
			String line;
			String encryptedLine;
			while (filesc.hasNextLine()){
				line = filesc.nextLine();
				encryptedLine = rfEncrypt(line);
				pw.println(encryptedLine);
			}
			System.out.println(encrypted);
			filesc.close();
			pw.close();
			
			return true;
			} catch (Exception ex){
				return false;
			}

		}
	



	public static void main(String[] args) {
		heading();
		int answer;
		answer = 0;
		Scanner sc = new Scanner(System.in);
		String originalFile;
		System.out.print("Enter the name of the file you wish you encrypt:");
		originalFile = sc.nextLine();
		while (answer < 4){
			System.out.println("Choose your encryption technique:");
			System.out.println("1. Railfence");
			System.out.println("2. Row Shuffle");
			System.out.println("3. One-Time Pad");
			System.out.println("4. Quit"); 
			answer = sc.nextInt();
			if (answer == 1){
				String rfEncryptedFile;
				rfEncryptedFile = "";
				sc.nextLine();
				boolean successful;
				successful = rfFile(originalFile, rfEncryptedFile);

			}
			if (answer == 2){
				
			}
			if (answer == 3){
				
			}
			if (answer > 4){
				System.out.println("Enter an actual option.");
			}
		}
     
		
	
	

	}
}