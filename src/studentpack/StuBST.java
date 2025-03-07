package studentpack;

public class StuBST {
	private StuNode root;
	
	public StuBST() {
		root = null;
	}
	
	public void insert(StuNode newRecord) {
		String key = newRecord.key;
		
		if (root == null) root = newRecord; // case: tree is empty
		else {
			StuNode current = root;
			StuNode parent; // current starts at root, parent will be prev node
			while (true) {
				parent = current; // parent begins at current
				
				//first, check to see if it goes left
				if (key.compareTo(current.key) < 0) {
					current = current.left;
					if (current == null) {
						parent.left = newRecord;
						return;
					}
				}
				//then check to see if it goes right
				else {
					current = current.right;
					if (current == null) {
						parent.right = newRecord;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int where) {
		StuNode current = root;
		StuNode parent = null;
		
		//find node to delete
		while(current != null && current.where != where){
            parent = current;
            if (where < current.where){
                current = current.left;
            } else {
                current = current.right;
            }
        }
		
		//node not found
		if (current == null) return false;
		
		//node has no children
		if (current.left == null && current.right == null) {
			if (current == root) root = null;
			else if(parent.left == current) parent.left = null;
			else parent.right = null;
		}
		//if only left child
        else if(current.right==null){
            if(current == root)root = current.left;
            else if(parent.left == current) parent.left = current.left;
            else parent.right = current.left;
        }
        // if only right child
        else if(current.left == null) {
            if (current == root) root = current.right;
            else if(parent.left == current) parent.left = current.right;
            else parent.right = current.right;
        }
        // else two children, replace with successor
        else {
            StuNode successor = getSuccessor(current);
            if (current == root) root = successor;
            else if(parent.left == current) parent.left = successor;
            else parent.right = successor;
            successor.left = current.left;
        }
		return true;
	}
	
	private StuNode getSuccessor(StuNode delRecord) {
		StuNode successorParent = delRecord;
		StuNode successor = delRecord;
		StuNode current = delRecord.right; // go to the right first
		
		//traverse to leftmost node in right subtree
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left; // then go all the way to left (next in order node)
        }
        
        //if successor is not right child of node to delete
        if (successor != delRecord.right) { // if successor not to the right
            successorParent.left = successor.right;
            successor.right = delRecord.right;
        }
        return successor;
    }
	
	public StuNode find(String key) {
		StuNode current = root; // Begin from top
		
		while (current != null) { // while keys dont match
			if (key.compareTo(current.key) == 0)
				return current;
			else if (key.compareTo(current.key) < 0) // if key in parameter less than key in current
				current = current.left; // move to the  left
			else
				current = current.right; //otherwise, move current to right
		}
		return null;
	}
	
	public StuNode getRoot() {
		return root;
	}
	

}
