/* John Rader
This is the reunion assignment.
*/

import java.util.Scanner;
import java.io.*;

public class Rader_reunion{
	private static String[] firstNames;
	private static String[] lastNames;
	private static int[] years;
	private static int count;
	private static int capacity; 
	// This reads the file 
	public static boolean readFile(String database) {
		try {
			File f = new File(database);
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			String firstName;
			String lastName;
			int year;
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				firstName = parts[0];
				lastName = parts[1];
				year = Integer.parseInt(parts[2]);
				firstNames[count] = firstName;
				lastNames[count] = lastName;
				years[count] = year;
				count = count + 1;
			}
			fsc.close();
			return true;
		} catch (Exception ex){
			return false;
		}
	}


/*
This is a simple function that calls the welcome screen. 
*/
	public static void welcome(){
		System.out.println("Welcome to Reunion Planner. This program will help you organize a reunion for your high school.");
		System.out.println("Graduates can be grouped by decade. Graduates of specific years can also be identified so that"); 
		System.out.println("you can include them in a special way.");
		System.out.println(" ");
	}

	// this function is the menu function.
	public static void showMenu(){
		
		System.out.println("What would you like to do?");
		System.out.println("1. See full list of alumini sorted by last name");
		System.out.println("2. See list of alumini by decade");
		System.out.println("3. See 10-year reunion alumini");
		System.out.println("4. See 25-year reunion alumini");
		System.out.println("5. See 40-year reunion alumini");
		System.out.println("6. Find alumnus by last name");
		System.out.println("7. Find alumnus by range of last names");
		System.out.println("8. Add alumnus");
		System.out.println("9. Remove alumnus");
		System.out.println("10. Quit");
		System.out.println("Please enter your choice:");
			
		}
	// This function sorts the list by last name.
	public static void sortByLastName() {
		String minLastname;
		int minPos;
		String tempLastName;
		String tempFirstName;
		int tempYear;
		for (int i = 0; i < count; i++) {
			minLastname = lastNames[i];
			minPos = i;
			for (int j = i + 1; j < count; j++){
				if (lastNames[j].compareTo(minLastname) < 0){
					minLastname = lastNames[j];
					minPos = j;
				}
			}
			tempLastName = lastNames[i];
			lastNames[i] = lastNames[minPos];
			lastNames[minPos] = tempLastName; 
			tempFirstName = firstNames[i];
			firstNames[i] = firstNames[minPos];
			firstNames[minPos] = tempFirstName;
			tempYear = years[i];
			years[i] = years[minPos];
			years[minPos] = tempYear;
			
		}
	}

	

// This is a function that prints the file.
	public static void printLastNameFirst() {
        for (int i = 0; i < count; i++) {
            System.out.printf("%s, %s %d\n", lastNames[i], firstNames[i], years[i]);
        }
    }
// This sorts the file by year. Not realy necessary I left it in here anyways.
 	public static void sortByDecade() {
       int minYear;
       int minPos;
       int temp;
       String tempFirstName;
       String tempLastName;
       for (int i = 0; i < count; i++) {
          minYear = years[i];
           minPos = i;
           for (int j = i+1; j < count; j++) {
               if (years[j] < minYear) {
                   minYear = years[j];
                   minPos = j;
                }
            }
            temp = years[i];
            years[i] = years[minPos];
            years[minPos] = temp;
            tempFirstName = firstNames[i];
            tempLastName = lastNames[i];
            firstNames[i] = firstNames[minPos];
            lastNames[i] = lastNames[minPos];
            firstNames[minPos] = tempFirstName;
            lastNames[minPos] = tempLastName;
            	
            
        }
    }
    // This prints it by the decade they were in
    public static void printByDecade() {
		System.out.println("-- 1950 to 1959 -- ");
		for (int i = 0; i < count; i++) {
			if (years[i] >= 1950 && years[i] <= 1959) {
				System.out.printf("%s, %s %d\n",lastNames[i], firstNames[i], years[i]);
				}
			}
		System.out.println("-- 1960 to 1969 -- ");
		for (int i = 0; i < count; i++) {
			if (years[i] >= 1960 && years[i] <= 1969) {
				System.out.printf("%s, %s %d\n",lastNames[i], firstNames[i], years[i]);
				}
			}
		System.out.println("-- 1970 to 1979 -- ");
		for (int i = 0; i < count; i++) {
			if (years[i] >= 1970 && years[i] <= 1979) {
				System.out.printf("%s, %s %d\n",lastNames[i], firstNames[i], years[i]);
				}
			}
		System.out.println("-- 1980 to 1989 -- ");
		for (int i = 0; i < count; i++) {
			if (years[i] >= 1980 && years[i] <= 1989) {
				System.out.printf("%s, %s %d\n",lastNames[i], firstNames[i], years[i]);
				}
			}
		System.out.println("-- 1990 to 1999 -- ");
		for (int i = 0; i < count; i++) {
			if (years[i] >= 1990 && years[i] <= 1999) {
				System.out.printf("%s, %s %d\n",lastNames[i], firstNames[i], years[i]);
				}
			}
		System.out.println("-- 2000 to 2009 -- ");
		for (int i = 0; i < count; i++) {
			if (years[i] >= 2000 && years[i] <= 2009) {
				System.out.printf("%s, %s %d\n",lastNames[i], firstNames[i], years[i]);
				}
			}
		System.out.println("-- 2010 to 2019 -- ");
		for (int i = 0; i < count; i++) {
			if (years[i] >= 2010 && years[i] <= 2019) {
				System.out.printf("%s, %s %d\n",lastNames[i], firstNames[i], years[i]);
				}
			}
		}
// the 10 year reunion group
	public static void tenYearReunion() {
		int time = 0;
		System.out.println("-- 10-Year Reunion --");
		for (int i = 0; i < count; i++) {
			time = 2017 - years[i];
			if (time == 10) {
				System.out.printf("%s, %s %d\n", lastNames[i], firstNames[i], years[i]);
			}
		}
		System.out.println("");
	}
// the 25 year reunion group
	public static void twentyfiveYearReunion() {
		int time = 0;
		System.out.println("-- 25-Year Reunion --");
		for (int i = 0; i < count; i++) {
			time = 2017 - years[i];
			if (time == 25) {
				System.out.printf("%s, %s %d\n", lastNames[i], firstNames[i], years[i]);
			}
		}
		System.out.println("");
	}
// the 40 year reunion group
	public static void fortyYearReunion() {
		int time = 0;
		System.out.println("-- 40-Year Reunion --");
		for (int i = 0; i < count; i++) {
			time = 2017 - years[i];
			if (time == 40) {
				System.out.printf("%s, %s %d\n", lastNames[i], firstNames[i], years[i]);
			}
		}
		System.out.println("");
	}
// this find a specific person searching by their last name
	public static void findByLastName() {
		String person;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the last name of you who are trying to find:");
		person = sc.nextLine();
		for (int i = 0; i < count; i++) {
			if (lastNames[i].equals(person)) {
				System.out.printf("%s, %s %d\n", lastNames[i], firstNames[i], years[i]);
				System.out.println("");
			}

			
		}
	}
// this is supposed to report the alumni within a certain range
	public static void printAlumniWithinRange(String min, String max) {
		int location1 = findPerson2(min);
		int location2 = findPerson2(max);
		for (int i = location1; i < location2; i++) {
				System.out.printf("%s, %s %d\n",lastNames[i], firstNames[i], years[i]);
			}
		}
// resizes the array if it hits it's cap
	public static void resize(int newCap) {
		String[] resizedFirstNames = new String[newCap];
		String[] resizedLastNames = new String[newCap];
		int[] resizedYears = new int[newCap];
		for (int i = 0; i < count; i++) {
			resizedFirstNames[i] = firstNames[i];
			resizedLastNames[i] = lastNames[i];
			resizedYears[i] = years[i];
		}
		capacity = newCap;
		firstNames = resizedFirstNames;
		lastNames = resizedLastNames;
		years = resizedYears;
	}
// checks to see if the array is full
	public static boolean isFull() {
		if (count == capacity) {
			return true;
		} else {
			return false;
		}
	}
// adds a person to the list
	public static void appendPerson(String firstName, String lastName, int year) {
		if (isFull() == true) {
			resize(2*capacity);
		}
			firstNames[count] = firstName;
			lastNames[count] = lastName;
			years[count] = year;
			count = count + 1;
	}
// finds the last names spot in the array, supposed to help the range function work
	public static int findPerson2(String lastName){
		for (int i = 0; i < count; i++) {
			if (lastNames[i].equals(lastName)) {
				return i;
				}
			}
				return -1;
			}
	

// this locates a persons place in the array
	public static int findPerson(String firstName, String lastName) {
		for (int i = 0; i < count; i++) {
			if (lastNames[i].equals(lastName) && firstNames[i].equals(firstName)) {
				return i;
			}
		}
		return -1;
	}
// removes a person from the list
	public static void removePerson(String personFirstName, String personLastName) {
		int location = findPerson(personFirstName, personLastName);
		if (location >= 0) {  
			for (int i = location; i < count-1; i++) {
				firstNames[i] = firstNames[i+1];
				lastNames[i] = lastNames[i+1];
				years[i] = years[i+1];
			}
			count = count - 1;  
		}
	}
// main program code
	public static void main(String[] args) {
		welcome();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the alumini database:");
		String database;
		database = sc.nextLine();

		capacity = 100;
		count = 0;
		firstNames = new String[capacity];
		lastNames = new String[capacity];
		years = new int[capacity];
		
		int choice = 0;
		readFile(database);
		

		while(choice < 10){
			showMenu();
			choice = sc.nextInt();
			if(choice == 1){
				System.out.println("Here is the full list of alumni, sorted by last name:");
				sortByLastName();
				printLastNameFirst();

			}
			if(choice == 2){
				sortByLastName();
				printByDecade();
		
			}
			if(choice == 3){
				tenYearReunion();

			}
			if(choice == 4){
				twentyfiveYearReunion();

			}
			if(choice == 5){
				fortyYearReunion();

			}
			if(choice == 6){
				findByLastName();

			}
			if(choice == 7){
				System.out.print("Enter starting last name and ending last name of the range: ");
				String minName;
				String maxName;
				minName = sc.next();
				maxName = sc.next();
				sc.nextLine();

				printAlumniWithinRange(minName,maxName);
				

			}
			if(choice == 8){
				System.out.print("Enter the new person by first name, last name, and year(ex. John Rader 2017): ");
				String newFirstName;
				String newLastName;
				int newYear;
				newFirstName = sc.next();
				newLastName = sc.next();
				newYear = sc.nextInt();
				sc.nextLine();
				appendPerson(newFirstName,newLastName,newYear);
				sortByLastName();
				printLastNameFirst();

			}
			if(choice == 9){
				System.out.print("Enter the first and last name of the person you wish to remove from the list: ");
				String firstNameToRemove;
				String lastNameToRemove;
				sortByLastName();
				firstNameToRemove = sc.next();
				lastNameToRemove = sc.next();
				sc.nextLine();
				removePerson(firstNameToRemove, lastNameToRemove);
				System.out.println("The Alumnus was removed.");


			}

		}
		System.out.println("");
		System.out.println("Thank you for using this program.");
		System.out.println("Have fun at the reunion.");

		
	}

}

