package studentpack;

public class StuNode { // Individual record from student record (first/last/id)
	public String key;
	public int where;
	public StuNode right;
	public StuNode left;
	
	public StuNode(String k, int w) {
		key = new String(k);
		where = w;
		right = null;
		left = null;
	}
	
	//compareTo(IndividRecord r): Compares two keys for insertion into Individual Array
	public int compareTo(StuNode r) {
		return (key.compareTo(r.key));
	}
	
	
	/* from linked list!
	//Getters and setters
	public int getWhere() {
		return where;
	}
	public String getKey() {
		return key;
	}
	public IndiRecord getNext() {
		return right;
	}
	public IndiRecord getPrev() {
		return left;
	}
	public void setNext(IndiRecord r) {
		right = r;
	}
	public void setPrev(IndiRecord r) {
		left = r;
	}
	*/
}
