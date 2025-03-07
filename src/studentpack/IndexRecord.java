/**
 * This class is the object class for records inside of the IndexArrays.
 * @author David Dooley
 * @version (9/21/2024)
 */
package studentpack;

public class IndexRecord {
    private String key;
    private int where;
    
    //Constructor
    public IndexRecord(String k, int w) {
        key = new String(k);
        where = w;
    }
    
    //Compare to method to keep the array ordered by key for insertion into IndexArray
    public int compareTo (IndexRecord r) {
        return (key.compareTo(r.key));
    }
    
    public int getWhere() {
        return where;
    }
    public String getKey() {
        return key;
    }
}
