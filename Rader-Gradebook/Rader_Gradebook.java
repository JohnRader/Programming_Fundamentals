/* John Rader
This code creates a gradebook out of a given text of grades.
*/

import java.util.Scanner;
import java.io.*;

public class Rader_Gradebook {
/*
This is a simple heading function.
*/
	public static void heading(){
		System.out.println("**************************************************");
		System.out.println("        WELCOME TO GRADEBOOK VERSION 1.0");
		System.out.println("**************************************************");
		System.out.println("This application reads a set of grades");
		System.out.println("  from a text file and then prints a");
		System.out.println("report that shows the average and letter");
		System.out.println("        grade for each student.");
		System.out.println("**************************************************");
	}

/*
This function takes in the grade values and averages them out with 
the total calculated in the Main funtion.
*/
	public static double averageGrades(String line, Double total) {
		double score = 0;
		double average = 0;
		String[] parts;
		parts = line.split(" ");

		for (int i = 2; i < parts.length; i++) {
			if (parts[i].equals("x")) {
				score = score + 0;
			} else {
				score = score + Double.parseDouble(parts[i]);
		}
		average = score / total;
		average = average * 100;	
		}
		return average;
	}

/*
This function converts the output from the average grade function and 
converts it into a letter grade.
*/
	public static String grade(Double avg) {
		String grade;
		if (avg > 96){
			grade = ("A+");
		} else if (avg > 92) {
			grade = ("A");
		} else if (avg > 89) {
			grade = ("A-");
		} else if (avg > 86) {
			grade = ("B+");
		} else if (avg > 82) {
			grade = ("B");
		} else if (avg > 79) {
			grade = ("B-");
		} else if (avg > 76) {
			grade = ("C+");
		} else if (avg > 72) {
			grade = ("C");
		} else if (avg > 69) {
			grade = ("C-");
		} else if (avg > 59) {
			grade = ("D");
		} else {
			grade = ("F");
		}

		return grade;
	}
	public static void main(String[] args) {
		heading();
		Scanner sc = new Scanner(System.in);
		String originalFile;
		System.out.print("Enter the name of the file with the grades:");

		originalFile = sc.nextLine();
		String firstName;
		String lastName;
		String line;
		String letterGrade;
		double avg;
		double total = 0;
		try {
		System.out.println("First Name     Last Name     Average     Grade");
		System.out.println("----------------------------------------------------");
			File f = new File(originalFile);
			Scanner filesc = new Scanner(f);
			line = filesc.nextLine();
			line = line.trim();
			String[] parts;
			parts = line.split(" ");
			for (String part : parts) {
				total = total + Double.parseDouble(part);
			}
			
			while (filesc.hasNextLine()) {
				line = filesc.nextLine();
				line = line.trim();	
				parts = line.split(" ");
				if (line.length() > 0){
					firstName = parts[0];
				    lastName = parts[1];
					avg = averageGrades(line,total);
					letterGrade = grade(avg);
					System.out.printf("%-13s  %-12s   %-5.2f        %s\n", firstName, lastName, avg, letterGrade);
				}
			}
				filesc.close();
				System.out.print("----------------------------------------------------");
		} catch(Exception ex){
			System.out.println("There was an error.");
			ex.printStackTrace();
		}


	}
}
