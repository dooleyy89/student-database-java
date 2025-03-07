/**
 * @author David Dooley
 * @version (9/21/2024)
 */
package studentpack;

public class DataBaseArray {
	private int nElems;
	private int max;
	private DataBaseRecord [] dbArr;
	
    //Constructor
    public DataBaseArray(int sz) {
        nElems = 0;
        max = sz; 
        dbArr = new DataBaseRecord[max];
    }
    
    // full(): checks to see if the array is full.
    public boolean full() {
        return (nElems == max);
    }
    
    /** 
     * addRecord(DataBaseRecord r): This method takes the parameter as a DataBaseRecord and inserts
     * the record into the array, and increments nElems.
       */
    public void addRecord(DataBaseRecord r) {
        if (!full())
            dbArr[nElems++] = r; //if array isn't full insert record and increment nElems
        else
            System.out.println("Database full."); 
    }
    
    /**
     * findID(String key): This method takes the parameter as a String key, which will be an ID
     * that gets compared to another ID using compareTo. If the two IDs are the same, then it will 
     * return the index of the ID in the DataBase array.
     */
    public int findID(String key) {
        for (int i=0; i<nElems; i++) {
            int compVal = key.compareTo(dbArr[i].getID()); // compares the IDs
            if (compVal == 0){ 
                return i;
            }
        }
        return -1;
    }
    
    /**
     * grab(int where): This method will loop through the database and check if the where parameter
     * equals the index of the record. Method will be used for printing in ascending/descending order
     */
    public void grab(int where) {
        for (int i=0; i<nElems; i++) {
            if (where == i) {
                System.out.println(dbArr[i]);
            }
        }
    }
}
