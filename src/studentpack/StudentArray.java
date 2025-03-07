package studentpack;

public class StudentArray {
	private int nElems, max;
	private StudentRecord[] dbArr; // dbArr = Database Array
	
	public StudentArray(int sz) {
		nElems = 0;
		max = sz;
		dbArr = new StudentRecord[max];
	}
	
	// full(): Checks to see if array is full
	public boolean full() {
		return (nElems == max);
	}
	
	/** addRecord(StudentRecord sr): If not full, takes StudentRecord parameter and inserts 
	 record into the array, increments nElems */
	public void addRecord(StudentRecord sr) {
		if (!full()) dbArr[nElems++] = sr;
		else System.out.println("Database is full");
	}
	
	/** findID(String id): Takes parameter as a string "id", which will be an ID that gets
	 compared to another ID. If the two IDs match, returns index of the ID in StudentArray. */
	public int findID(String id) {
		for (int i=0; i<nElems; i++) {
			int compVal = id.compareTo(dbArr[i].getID());
			if (compVal == 0) return i;
		}
		return -1;
	}
	
	
	/** grab(int where): Loops through database and prints element when where parameter 
	 equals the index record in the array. Used for printing ascending/descending order. */
	public void grab(int where) {
		for (int i=0; i<nElems; i++) { //loop through array
			if (where == i) System.out.println(dbArr[i]); //if the index = where, print record
		}
	}
}