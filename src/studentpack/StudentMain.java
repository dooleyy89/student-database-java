package studentpack;
	

import java.util.Scanner;
import java.io.*;

public class StudentMain {
	
	public static void main(String[] args) {
		MainDataBase d = new MainDataBase();
        int response;
        Scanner key = new Scanner(System.in);
        
        try
        {
            File file = new File("studentData.txt");
            if (file.exists()) {
            	Scanner scn = new Scanner(file);
                while (scn.hasNextLine()) {
                    String f = scn.next(), l = scn.next(), id = scn.next();
                    d.addToArrays(f, l, id);
                }
                scn.close();
            } else System.out.println("File not found.");
        } catch(FileNotFoundException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        
        do {
        	System.out.println("_________________________\n");
        	System.out.println("STUDENT MANAGEMENT SYSTEM");
        	System.out.println("_________________________");
            System.out.println("\n1: Add new student");
            System.out.println("2: Delete student");
            System.out.println("3: Find student by ID");
            System.out.println("4: List students");
            //System.out.println("5: Add new course"); 	- these will be added next
            //System.out.println("6: Remove course");
            //System.out.println("7: Manage courses");
            System.out.println(" ");
            System.out.println("0 End\n");
            
            while (!key.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                key.next(); // Discard invalid input
            }
            response = key.nextInt();
            
            switch (response) {
                case 1: d.addStudent();
                        break;
                case 2: d.deleteStudent();
                        break;
                case 3: d.findStudent();
                        break;
                case 4: System.out.println("\nList by: \n1: First name\n2: Last name\n3: ID");
                	int reply = key.nextInt();
                	if (reply == 1) {
                		System.out.println("\nList order: \n1: Ascending\n2: Descending");
                		int reply2 = key.nextInt();
                		if (reply2 == 1) d.ListByFirstAscending(); 
                		else if (reply2 == 2) d.ListByFirstDescending();
                		else System.out.println("\nInvalid number.\n"); break;
                	} else if (reply == 2) {
                		System.out.println("\nList order: \n1: Ascending\n2: Descending");
                		int reply2 = key.nextInt();
                		if (reply2 == 1) d.ListByLastAscending(); 
                		else if (reply2 == 2) d.ListByLastDescending();
                		else System.out.println("\nInvalid number.\n"); break;
                	} else if (reply == 3) {
                		System.out.println("\nList order: \n1: Ascending\n2: Descending");
                		int reply2 = key.nextInt();
                		if (reply2 == 1) d.ListByIDAscending(); 
                		else if (reply2 == 2) d.ListByIDDescending();
                		else System.out.println("\nInvalid number.\n"); break;
                	} else System.out.println("\nInvalid number.\n");     
                        break;
                case 0: System.out.println("Ending program...");
                	break;
                default:
            }
        } while (response != 0);
        key.close();
	}
}
