package studentpack;

public class StudentRecord {
	//Student record will include first & last name, ID, course & grade.
	private String first;
	private String last;
	private String ID; 
	
	public StudentRecord(String f, String l, String id) {
		first = new String(f);
		last = new String(l);
		ID = new String(id);
	}
	
	public String toString() {
		return ID+" "+first+" "+last;
	}
	
	// getID(): gets ID from record
	public String getID() {
		return ID;
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getLast() {
		return last;
	}
}
