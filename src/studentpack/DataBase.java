/**
 * This class is the entire student database.
 * @author David Dooley
 * @version (9/21/2024)
 */

package studentpack;
import java.util.*;
public class DataBase {
	private DataBaseArray DB;
	private IndexList first, last, ID;
	
	//constructor
	public DataBase() {
		DB = new DataBaseArray(100);
		first = new IndexList();
		last = new IndexList();
		ID = new IndexList();
	}
	
    /**
     * addIt(): Prompts user to enter record in certain format, then calls method addToArrays() which
     * will add the record to the database.
     */
    public void addIt() {
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
    public void deleteIt() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type student ID of record you'd like to delete: ");
        String idnum = scnr.nextLine();
        int where = ID.find(idnum); // finds the where of the ID the user deletes
        if (where != -1) { // if the ID is found
            ID.delete(where); 
            last.delete(where);
            first.delete(where); 
            System.out.println("Deleted");
        } else 
            System.out.println("ID not Found");
    }
    
    
    /**
     * findIt(): This method prompts user to type ID of record they'd like to find. If the ID of the 
     * record is found, it finds the where element of the IndexRecord and uses it to grab the record
     * from the DataBase
     */
    public void findIt() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type student ID of record you'd like to find: ");
        String idnum = scnr.nextLine();
        int where = ID.find(idnum); // Finds the where element of the record in the ID IndexArray
        if (where != -1) { 
            DB.grab(where); // grab the Database record based on where it is
            System.out.println();
        } else 
               System.out.println("ID not Found"); 
    }
    
    
    /**
     * These methods will either list an indexArray forward or backward.
     */
    public void ListByIDAscending() {
        listForward(ID);
    }
    public void ListByFirstAscending() {
        listForward(first);
    }
    public void ListByLastAscending() {
        listForward(last);
    }
    public void ListByIDDescending() {
        listBackward(ID);
    }
    public void ListByFirstDescending() {
        listBackward(first);
    }
    public void ListByLastDescending() {
        listBackward(last);
    }
    
    
    /**
     * addToArrays(String f, String l, String id): This method will take the parameters as strings for
     * new records to be made and inserted into their respective arrays. Used for the AddIt() method and
     * implementing the data from the text file.
     */
    public void addToArrays(String f, String l, String id) {
        DataBaseRecord newRecord = new DataBaseRecord(f, l, id); 
        if (DB.findID(newRecord.getID()) == -1){ // if the ID hasn't been used previously
            DB.addRecord(newRecord); // add newRecord to database
            
            //these three lines create new indexRecords for the firstname, lastname & ID
            IndexRecord fname = new IndexRecord(f, DB.findID(newRecord.getID()));
            IndexRecord lname = new IndexRecord(l, DB.findID(newRecord.getID()));
            IndexRecord IDindex = new IndexRecord(id, DB.findID(newRecord.getID()));//fills the WHERE
            
            first.insert(fname);
            last.insert(lname);
            ID.insert(IDindex);
        }   
        else
            System.out.println("\nWARNING: ID already used in different record. Try again.\n");
    }
    
    
    /**
     * listForward(IndexArray i): This method takes parameter i, which will be an IndexArray, and prints
     * list in ascending order.
     */
    public void listForward(IndexList ir) {
        ir.iteratorInitFront();
        int firstIndex = ir.getItr().getWhere();
        DB.grab(firstIndex); // Prints first element
        while (ir.hasNext()) { // while the array has a next element
            int next = ir.getNext();
            DB.grab(next);// Grab the next element in database based on the indexArray
        }
        System.out.println();
    }
    
    
    /**
     * listBackward(IndexArray i): Similar to listForward, this method takes parameter i, which will be 
     * an IndexArray, and prints list in descending order.
     */
    public void listBackward(IndexList ir) {
        ir.iteratorInitBack();
        int lastIndex = ir.getItr().getWhere();
        DB.grab(lastIndex); // Prints first element
        while (ir.hasPrevious()) { // while the array has a previous element
            int next = ir.getPrevious(); 
            DB.grab(next); // Grab the previous element in database based on the indexArray
        }
        System.out.println();
    }
}
