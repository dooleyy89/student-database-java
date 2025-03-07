/**
 * This class is an array class that will only hold IndexRecords
 * @author David Dooley
 * @version (9/21/2024)
 */
package studentpack;

public class IndexArray {
    private int nElems, itr;
    private IndexRecord[] arr;
    
    //Constructor: takes the size of OrderedArray as parameter
    public IndexArray(int sz) {
        nElems = 0;
        itr = 0;
        arr = new IndexRecord[sz];
    }
    
    
    /**
     *  insert(IndexRecord ir): Inserts a new IndexRecord (ir) into the OrderedArray. Automatically puts 
     *  new elements in its sorted spot.
     */
    public void insert(IndexRecord ir)  {
        int i;
        for (i = nElems-1; i>=0; i--) { // Starts at the top
            if (ir.compareTo(arr[i])>0) break; //If the record is bigger than the previous record
            arr[i+1] = arr[i];
        }
        arr[i+1] = ir;
        nElems++;
    }
    
    
    /**
     * delete(int where): This method will set the iterator to 0, run through the OrderedArray, and check at the
     * index if the where in the IndexRecord equals the where parameter. If the where in the IndexRecord
     * equals the where referenced for deletion, the array at that index will be deleted and the array
     * will shift over, and decrements nElems.
     */
    public void delete(int where) {
        if (nElems != 0) { // important: if the array is NOT empty
            itr = 0; 
            while (itr<=nElems-1) {
                if (arr[itr].getWhere() == where) { // if the where index matches with what the user prompted
                    for (int i=itr; i<nElems-1; ++i) {
                        arr[i] = arr[i+1]; // Shifts all of the elements over and deletes the element at itr
                    }
                    nElems--;
                }
                itr++;
            }
        }
    }
    
    
    /**
     * find(String key): This method takes the String key parameter and compares it to the key of the
     * IndexRecord in the IndexArray. If the two keys are the same, return the where index, else return -1.
     */
    public int find (String key) {
        for (int i=0; i<nElems; i++) {
            int compVal = key.compareTo(arr[i].getKey()); // compares the key in array to the key parameter
            if (compVal == 0) {
                return arr[i].getWhere();
            }
        }
        return -1; // if the keys don't match return -1;
    }
    
    
    //Sets iterator to 0
    public void iteratorInitFront() {
        itr = 0;
    }
    
    //Sets iterator to last element of IndexArray
    public void iteratorInitBack() {
        itr = nElems - 1;
    }
    
    //Checks if IndexArray has a next element
    public boolean hasNext() {
        int current = nElems-1;
        if (itr<=current) return true;
        return false;
    }
    
    //Checks if IndexArray has a previous element
    public boolean hasPrevious() {
        if (itr>=0) return true;
        return false;
    }
    
    //Returns the where of the next IndexRecord
    public int getNext() {
        int ir = arr[itr++].getWhere();
        return ir;
    }
    
    //Returns the where of the previous IndexRecord
    public int getPrevious() {
        int ir = arr[itr--].getWhere();
        return ir;
    }
}

