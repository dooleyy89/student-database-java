/**
 * This is the main class that handles user interaction.
 * @author David Dooley
 * @version (9/21/2024)
 */

package studentpack;
import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) {
		DataBase db = new DataBase();
		int response;
		Scanner input = new Scanner(System.in);
		
		try {
			File file = new File("studentData.txt");
			Scanner scnr = new Scanner(file);
			while (scnr.hasNextLine()) { // reads first name, last name, and ID in order from file.
				String f = scnr.next(), l = scnr.next(), id = scnr.next(); 
				db.addToArrays(f, l, id); // add information to the database
			}
			scnr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		do {
			System.out.println("\n 1: Add a new student");
            System.out.println(" 2: Delete a student");
            System.out.println(" 3: Find a student by ID");
            System.out.println(" 4: List students by ID increasing");
            System.out.println(" 5: List students by first name increasing");
            System.out.println(" 6: List students by last name increasing");
            System.out.println(" 7: List students by ID decreasing");
            System.out.println(" 8: List students by first name decreasing");
            System.out.println(" 9: List students by last name decreasing");
            System.out.println(" ");
            System.out.println(" 0: End\n");
            
            response = input.nextInt();
            
            switch (response) {
            case 1: 
            	db.addIt();
            	break;
		    case 2: 
		    	db.deleteIt();
		        break;
		    case 3: 
		    	db.findIt();
		        break;
		    case 4: 
		    	db.ListByIDAscending();        
		        break;
		    case 5: 
		    	db.ListByFirstAscending();    
		        break;
		    case 6: 
		    	db.ListByLastAscending();
		        break;
		    case 7: 
		    	db.ListByIDDescending();
		        break;
		    case 8: 
		    	db.ListByFirstDescending();
		        break;
		    case 9: 
		    	db.ListByLastDescending();
		        break;
		    case 0:
		    	System.out.println("\nEnding program..");
		    	break;
		    default:
		    	System.out.println("Invalid option. Please select 1-9 (0 to quit): ");
            }
		} while (response != 0);
		input.close();
	}
}
