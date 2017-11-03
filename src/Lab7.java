import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) throws FileNotFoundException, IndexOutOfBoundsException {

		File myFile = new File("classinfo.txt");

		Scanner userInput = new Scanner(System.in);

		Scanner input = new Scanner(myFile);

		ArrayList<String> fill = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> home = new ArrayList<String>();
		ArrayList<String> food = new ArrayList<String>();
		String choice = "yes";

		// Create a while loop to fill the file input into an ArrayList
		while (input.hasNextLine()) {
			String lines = input.nextLine();
			fill.add(lines);
		}
		// Create a loop to fill an ArrayList with just the names of the people in my
		// ArrayList
		for (int i = 0; i < fill.size(); i = i + 3) {
			names.add(fill.get(i));
		}
		// Create a loop to fill an ArrayList with just the hometowns of the people in
		// the list
		for (int i = 1; i < fill.size(); i = i + 3) {
			home.add(fill.get(i));
		}
		// Create a loop to fill an ArrayList with just the favorite foods of the people
		// in the list
		for (int i = 2; i < fill.size(); i = i + 3) {
			food.add(fill.get(i));
		}

		boolean foundUser = true;
		// Prompt the user to enter a name of a student in the class
		while (choice.equalsIgnoreCase("yes")) {
			System.out.println("Here is a list of all the students in your class" + names + '\n'
					+ "Please enter the name of the student you would like to look up ");
			String student = userInput.nextLine();
			foundUser = true;
			int j = 0;
			// Create a loop to compare and confirm if the user input is valid and works.
			while (foundUser || j < names.size()) {
				if (student.equalsIgnoreCase(names.get(j))) {
					System.out.println(
							names.get(j) + "'s hometown is " + home.get(j) + " and favorite food is " + food.get(j));
					foundUser = false;
				}
				j++;
			}
			System.out.println("Would you like to search for another student Yes or No");
			choice = userInput.nextLine();
		}
		System.out.println("Program terminated");
		userInput.close();
		input.close();
	}

}
