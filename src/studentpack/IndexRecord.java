/**
 * This class is the object class for records inside of the IndexArrays.
 * @author David Dooley
 * @version (9/21/2024)
 */
package studentpack;

public class IndexRecord {
    private String key;
    private int where;
    private IndexRecord next;
    private IndexRecord prev;
    
    //Constructor (IndexRecord is now a node)
    public IndexRecord(String k, int w) {
        key = new String(k);
        where = w;
        next = null;
        prev = null;
    }
    
    //Compare to method to keep the list ordered by key for insertion into IndexArray
    public int compareTo (IndexRecord r) {
        return (key.compareTo(r.key));
    }
    
    // Getter and setter methods
    public int getWhere() {
        return where;
    }
    public String getKey() {
        return key;
    }
    public IndexRecord getNext() {
         return next;
    }
    public IndexRecord getPrev() {
        return prev;
    }
    public void setNext(IndexRecord ir) {
        next = ir;
    }
    public void setPrev(IndexRecord ir) {
        prev = ir;
    }

}
