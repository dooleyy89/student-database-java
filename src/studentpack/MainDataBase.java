package studentpack;

import java.util.*;
public class MainDataBase {
	private StudentArray DB; // DB = database
	private StuBST first, last, ID;
	
	public MainDataBase() {
		DB = new StudentArray(100);
        first = new StuBST();
        last = new StuBST();
        ID = new StuBST();
	}
	
	/**addIt(): Prompts user to enter record in certain format, then calls method addToArrays() which
	will add the record to the database. */
    public void addStudent() {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Insert record in this format: first_name last_name ID\n");
        String frst = scnr.next(), lst = scnr.next(), id = scnr.next();
        addToArrays(frst, lst, id);
        
    }
    
    /**
     * deleteIt(): Prompts user to enter record ID to delete. The ID entered will be checked in the ID
     * IndexArray and if there is an ID that corresponds to the input, it will be located and deleted
     * from all three IndexArrays.
     */
    public void deleteStudent() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type student ID of record you'd like to delete: ");
        String idnum = scnr.nextLine();
        StuNode idNode = ID.find(idnum); // finds the where of the ID the user deletes
        if (idNode != null) { // if the ID is found
            ID.delete(idNode.where); 
            last.delete(idNode.where);
            first.delete(idNode.where); 
            System.out.println("Deleted");
        } else System.out.println("ID not Found");
        
    }
    
    /**
     * findIt(): This method prompts user to type ID of record they'd like to find. If the ID of the 
     * record is found, it finds the where element of the IndexRecord and uses it to grab the record
     * from the DataBase
     */
    public void findStudent() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type student ID of record you'd like to find: ");
        String idnum = scnr.nextLine();
        StuNode idNode = ID.find(idnum); // Finds the where element of the record in the ID IndexArray
        if (idNode != null) { 
            DB.grab(idNode.where); // grab the Database record based on where it is
            System.out.println();
        } else System.out.println("ID not Found"); 
        
    }
    
    /**
     * These methods will either list an indexArray forward or backward.
     */
    public void ListByIDAscending() {
        inOrder(ID.getRoot());
    }
    public void ListByFirstAscending() {
    	inOrder(first.getRoot());
    }
    public void ListByLastAscending() {
    	inOrder(last.getRoot());
    }
    public void ListByIDDescending() {
    	revOrder(ID.getRoot());
    }
    public void ListByFirstDescending() {
    	revOrder(first.getRoot());
    }
    public void ListByLastDescending() {
    	revOrder(last.getRoot());
    }
    
    
    /**
     * addToArrays(String f, String l, String id): This method will take the parameters as strings for
     * new records to be made and inserted into their respective arrays. Used for the AddIt() method and
     * implementing the data from the text file.
     */
    public void addToArrays(String f, String l, String id) {
    	if (DB.findID(id) != -1) {
    		System.out.println("\nWARNING: ID already used in different record. Try again.\n");
    		return;
    	}
        StudentRecord newRecord = new StudentRecord(f, l, id); 
        if (ID.find(newRecord.getID()) == null){ // if the ID hasn't been used previously
            DB.addRecord(newRecord); // add newRecord to database
            
            //these three lines create new indexRecords for the firstname, lastname & ID
            StuNode fname = new StuNode(f, DB.findID(newRecord.getID()));
            StuNode lname = new StuNode(l, DB.findID(newRecord.getID()));
            StuNode IDindex = new StuNode(id, DB.findID(newRecord.getID()));//fills the WHERE
            
            first.insert(fname);
            last.insert(lname);
            ID.insert(IDindex);
        }   
        else
            System.out.println("\nWARNING: ID already used in different record. Try again.\n");
    }
    
    public void inOrder(StuNode node) {
    	if (node != null) {
    		inOrder(node.left);
    		DB.grab(node.where);
    		inOrder(node.right);
    	}
    }
    public void revOrder(StuNode node) {
    	if (node != null) {
    		revOrder(node.right);
    		DB.grab(node.where);
    		revOrder(node.left);
    	}
    }
}

