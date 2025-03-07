/**
 * This class is an array class that will only hold IndexRecords
 * @author David Dooley
 * @version (9/21/2024)
 */
package studentpack;

public class IndexList {
	private IndexRecord itr;
    private IndexRecord front;
    private IndexRecord back;
    
    //Constructor
    public IndexList() {
        itr = null;
        front = null;
        back = null;
    }
    
    /**
     *  insert(IndexRecord ir): Inserts a new IndexRecord (ir) into the Doubly Linked List. 
     *  Automatically puts new elements in its sorted spot.
    */
    public void insert(IndexRecord newRecord) {
        if (front == null) { // if the doubly linked list is empty
            front = newRecord;
            back = newRecord;
        } else {
            itr = front;
            IndexRecord prev = null;
            while (itr != null && newRecord.compareTo(itr) > 0) {
                prev = itr;
                itr = itr.getNext(); // loop runs until it finds node greater than newRecord
            } 
            if (prev == null) {
                newRecord.setNext(front);
                front.setPrev(newRecord);
                front = newRecord; // Insertion at the front if it must
            } else { 
                prev.setNext(newRecord);
                newRecord.setPrev(prev);
                newRecord.setNext(itr); // reassign pointers
                if (itr != null) itr.setPrev(newRecord); // if it isnt at the end of the list
                else back = newRecord; // if it's at the end of the list
            }
        }
    }
    
    /**
     * delete(int where): This method will set the iterator to front, run through the Doubly Linked List, 
     * and check at the index if the where in the IndexRecord equals the where parameter. If the intended
     * node for deletion is found, it removes the node and reassigns the links to their proper place.
     * Checks all cases (0 nodes, 1 node) and ensures front and back are pointed properly
    */
    public IndexRecord delete(int where) {
        if (front == null) {
            return null; // case: if list is empty
        } else {
            itr = front;
            IndexRecord prev = null;
            IndexRecord next = null; // Reference nodes for before and after iterator
            while (itr != null) {
                if (itr.getWhere() == where) { // If the node for deletion is found
                    next = itr.getNext();
                    if (prev == null) { // if user is deleting first node
                        front = next;
                        if (front != null) front.setPrev(null); // If the next node exists set its previous to null(its now front)
                        else back=null; // otherwise there was only one node, set back to null
                        return itr;
                    } else {
                        prev.setNext(next);
                        if (next == null) back = prev; // if last node is deleted, set back to the previous node
                        else next.setPrev(prev); // otherwise set the previous pointer of next node to previous node
                        itr.setNext(null);
                        itr.setPrev(null); // clear links
                        return itr;
                    }
                } else {
                    prev = itr;
                    itr = itr.getNext(); // if node for deletion isnt found, set itr to next node
                }
            }
            return null; // if nothing is found to delete
        }
    }
    
    /**
     * find(String key): This method takes the String key parameter and compares it to the key of the
     * IndexRecord in the doubly linked list. If the two keys are the same, return the where index,
     * else return -1.
    */
    public int find (String key) {
        itr = front;
        while (itr != null) {
            int compVal = key.compareTo(itr.getKey());
            if (compVal == 0) {
                return itr.getWhere();
            } else itr = itr.getNext();
        }
        return -1;
    }
       
    //Sets iterator to first node
    public void iteratorInitFront() {
        itr = front;
    }
    
    //Sets iterator to last node of IndexArray
    public void iteratorInitBack() {
        itr = back;
    }
    
    //Checks if IndexArray has a next element
    public boolean hasNext() {
        if (itr.getNext() != null) return true;
        return false;
    }
    
    //Checks if IndexArray has a previous element
    public boolean hasPrevious() {
        if (itr.getPrev() != null) return true;
        return false;
    }
    
    //Returns the where of the next IndexRecord
    public int getNext() {
        int ir = itr.getNext().getWhere();
        itr = itr.getNext();
        return ir;
    }
    
    //Returns the where of the previous IndexRecord
    public int getPrevious() {
        int ir = itr.getPrev().getWhere();
        itr = itr.getPrev();
        return ir;
    }
    
    // Returns iterator, used for listing forward & backward in database
    public IndexRecord getItr() {
        return itr;
    }

}

