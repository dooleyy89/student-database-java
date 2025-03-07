/**
 * @author David Dooley
 * @version (9/21/2024)
 */
package studentpack;

public class DataBaseRecord {
    private String first, last, ID;
    
    public DataBaseRecord(String f, String l, String id) {
        first = new String(f);
        last = new String(l);
        ID = new String(id);
    }
    
    public String toString() {
        return ID+" "+first+" "+last;
    }
    // Getter
    public String getID() {
        return ID;
    }
}
