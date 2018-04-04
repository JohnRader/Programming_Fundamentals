/* John Rader
*/

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class RaderEncryption{
/*
This is a simple heading function.
*/
	public static void heading(){
		System.out.println("**************************************************");
		System.out.println("        WELCOME TO THE ENCRYPTOR");
		System.out.println("**************************************************");

	}
/*
This function encrypts the file using the railfence method
*/
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
		
	
/* 
This writes the file as a railfence encrypted version
*/
	public static boolean rfFile(String originalFile){
		try{
			System.out.println("Here is the file encrypted using Railfence:");
			System.out.println("---------------------------------------------------------------");
			File inFile = new File(originalFile);
			Scanner filesc = new Scanner(inFile);
			String line;
			String encryptedLine;
			while (filesc.hasNextLine()){
				line = filesc.nextLine();
				encryptedLine = rfEncrypt(line);
				System.out.println(encryptedLine);
			}	
			filesc.close();
			
			return true;
			} catch (Exception ex){
				ex.printStackTrace();
				return false;
			}

		}
/*
This reads the file into an array in preparation to be shuffled
*/
	public static String[] readPreshuffledFile(String originalFile){
		try{
			System.out.println("Here is there file encrypted using the row shuffling technique:");
			System.out.println("---------------------------------------------------------------");
			File inFile = new File(originalFile);
			Scanner filesc = new Scanner(inFile);
			String[] preShuffled;
			int lineCount = 0;
			String line;
			
			while (filesc.hasNextLine()) {
                lineCount = lineCount + 1;
                filesc.nextLine();
            }           
            filesc.close();
            preShuffled = new String[lineCount];
            filesc = new Scanner(inFile);
            for (int i = 0; i < lineCount; i++) {
                preShuffled[i] = filesc.nextLine();
            }
            filesc.close();
            return preShuffled;

		} catch (Exception ex) {
            return null;
		}
	}

/*
This shuffles the array created by the previous function
*/
 public static String[] fileShuffler(String[] preShuffle) {
        String[] shuffled;
        boolean[] used;
        int lineCount;
        int index;
        Random rnd = new Random();
        if (preShuffle == null) {
            return null;
        } else {
            lineCount = preShuffle.length;
            shuffled = new String[lineCount];
            used = new boolean[lineCount];
            for (int i = 0; i < lineCount; i++) {
                used[i] = false;  
            }
            for (int i = 0; i < lineCount; i++) {

                index = rnd.nextInt(lineCount);
                while (used[index] == true) {

                    index = rnd.nextInt(lineCount);
                }
                shuffled[i] = preShuffle[index];
                used[index] = true;
            }
        }
        return shuffled;
    }

/*
This function takes in the file, and feeds each line into the OTP encryption
function to be encrypted
*/
    public static boolean otpEncrypted(String originalFile){
    	try {
			System.out.println("Here is there file encrypted using the OTP:");
			System.out.println("---------------------------------------------------------------");
    		String line;
    		String encryptedLine;
    		File inFile = new File(originalFile);
			Scanner filesc = new Scanner(inFile);
			while (filesc.hasNextLine()){
				line = filesc.nextLine();
				encryptedLine = otpThing(line);
				System.out.println(encryptedLine);

		}
			filesc.close();
			return true;
			
			} catch (Exception ex){
				ex.printStackTrace();
				return false;
		}

	}
	
/*
This is the function that does the OTP encryption to the line fed in from the previous function
*/
    public static String otpThing(String line){
    		Random rnd = new Random();
			int key;
			key = rnd.nextInt(128);
			char plainCh;
			char keyCh;
			char encCh;
			String encrypted = "";
			String encryptedLine;
			for (int i = 0; i < line.length(); i++){
				plainCh = line.charAt(i);
				keyCh = (char)((line.charAt(i) + key) % 128);
				encCh = (char)(plainCh ^ keyCh);
				encrypted = encrypted + encCh;
			}
			return encrypted; 
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
			System.out.print("Enter the number of your choice:");
			answer = sc.nextInt();
			if (answer == 1){
				System.out.println("");
				sc.nextLine();
				boolean successful;
				successful = rfFile(originalFile);
				System.out.println("---------------------------------------------------------------");
				System.out.println("");
			}
			if (answer == 2){
				System.out.println("");
				String[] preShuffledFile;
				String[] shuffledFile;
				preShuffledFile = readPreshuffledFile(originalFile);
				shuffledFile = fileShuffler(preShuffledFile);
				 for (String str : shuffledFile) {
                System.out.println(str);
            	}
            	System.out.println("---------------------------------------------------------------");
            	System.out.println("");
				
			}
			if (answer == 3){
				System.out.println("");
				sc.nextLine();
				boolean successful;
				successful = otpEncrypted(originalFile);
				System.out.println("---------------------------------------------------------------");
				System.out.println("");
				
			}
			if (answer > 4){
				System.out.println("Enter an actual option.");
			}
		}
		System.out.println("Bye Bye");
     
	}
}