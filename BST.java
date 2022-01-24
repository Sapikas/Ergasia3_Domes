import java.io.PrintStream;

public class BST implements WordCounter {
	
	class TreeNode {
		TreeNode parent;
		WordFreq item;
		TreeNode left; // pointer to left subtree
		TreeNode right; // pointer to right subtree
		int size; //number of nodes in subtree starting at this node 
		int height;
		TreeNode(WordFreq item){
			this.item= item;
			this.size = 0;
			height = 0;
		}
		
		public WordFreq getItem() {
			return item;
		}
		public void setItem(WordFreq item){
			this.item = item;
		}
		public TreeNode getLeft() {
			return this.left;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public TreeNode getRight() {
			return this.right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
		public int getSize() {
			return this.size;
		}
		
		public TreeNode getParent() {
			// TODO Auto-generated method stub
			return this.parent;
		}
		public void setParent(TreeNode parent2) {
			// TODO Auto-generated method stub
			this.parent = parent2;
		}
		
	}
	/*End of TreeNode*/
	
	private int height(TreeNode t)
    {
 
        return t == null ? -1 : t.height;
    }
	
	private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
	
	
	private TreeNode root;
	private int size = 0;
	
	private TreeNode addRecursive(TreeNode current, String w) {
		//WordFreq data = new WordFreq(w, 1);
		if (current == null) {
			WordFreq data = new WordFreq(w, 1);
	        return new TreeNode(data);
	    }
		size++;
		
	    if (w.compareTo(current.item.key()) < 0) {
	        current.left = addRecursive(current.left, w);
	        if (height(current.left) - height(current.right) == 2) {
	        	if (w.compareTo(current.item.key())<0) {
	        		current = rotateLeft(current);
	        	}else {
	        		current = doubleWithLeftChild(current);
	        	}
	        }
	    } else if (w.compareTo(current.item.key()) > 0) {
	        current.right = addRecursive(current.right, w);
	        if (height(current.right) - height(current.left) == 2) {
	        	if (w.compareTo(current.item.key())>0) {
	        		current = rotateRight(current);
	        	}else {
	        		current = doubleWithRightChild(current);
	        	}
	        }
	    } else {
	        // value already exists
	    	current.item.addFreq();
	        return current;
	    }

	    return current;
	}
	
	private TreeNode insert_at_rootRec(WordFreq item, TreeNode head) {
        if (head == null)
            return new TreeNode(item);
        int result = item.key().compareTo(head.item.key());
        if (result < 0) {
            head.left = insert_at_rootRec(item, head.left);
            head = rotateRight(head);
        } else {
            head.right = insert_at_rootRec(item, head.right);
            head = rotateLeft(head);
        }
        return head;

    }

	@Override
	public void insert(String w) {
		// TODO Auto-generated method stub
		//WordFreq data = new WordFreq(w, size);
		//root = rootInsert(root, data, null);
		root = addRecursive(root, w);
	}

	@Override
	public WordFreq search(String w) {
		// TODO Auto-generated method stub
		traverseInOrder(root, w);
		if (nume > getMeanFrequency()) {
			System.out.println("I am here");
			remove(w);
			WordFreq data = new WordFreq(w, nume);
			//rootInsert(root, data, null);
			TreeNode test = insert_at_rootRec(data, root);
			if (test != null) {
				return test.item;
			}
		}
		return null;
	}
	
	private TreeNode deleteRecursive(TreeNode current, String value) {
	    if (current == null) {
	        return null;
	    }

	    if (value == current.item.key()) {
	    	//System.out.println(current.item.getFreq());
	    	if (current.left == null && current.right == null) {
	    	    return null;
	    	}
	    	if (current.right == null) {
	    	    return current.left;
	    	}

	    	if (current.left == null) {
	    	    return current.right;
	    	}
	    	String smallestValue = findSmallestValue(current.right);
	    	current.item.setKey(smallestValue);
	    	current.right = deleteRecursive(current.right, smallestValue);
	    	return current;
	    } 
	    if (value.compareTo(current.item.key()) < 0) {
	        current.left = deleteRecursive(current.left, value);
	        return current;
	    }
	    current.right = deleteRecursive(current.right, value);
	    return current;
	}
	
	private String findSmallestValue(TreeNode root) {
	    return root.left == null ? root.item.key() : findSmallestValue(root.left);
	}

	@Override
	public void remove(String w) {
		// TODO Auto-generated method stub
		root = deleteRecursive(root, w);
	}

	@Override
	public void load(String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalWords() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDistinctWords() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFrequency(String w) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WordFreq getMaximumFrequency() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private double sum = 0;
    private double count = 0;
	@Override
	public double getMeanFrequency() {
		// TODO Auto-generated method stub
		toString();
		return sum/count;
	}

	@Override
	public void addStopWord(String w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStopWord(String w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printÔreeAlphabetically(PrintStream stream) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printÔreeByFrequency(PrintStream stream) {
		// TODO Auto-generated method stub
		
	}
	
	
	private TreeNode rotateLeft(TreeNode pivot) {
    	
        TreeNode parent = pivot.getParent();
        TreeNode child = pivot.getRight();
        
        //update pivot's parent's child with pivot's right child
        if (parent == null) {
            root = child;
        } 
        else if (parent.getLeft() == pivot) {
            parent.setLeft(child);
        } 
        else {
            parent.setRight(child);
        }
        
        //update pivot's right child's parent with pivot's parent
        child.setParent(pivot.getParent());
        //update pivot's parent with child
        pivot.setParent(child);
        //during update, child has 3 children (1 right, 1 initial left + 1 left (pivot))
        //BST spec violation
        //pivot takes child's initial left child as its right child
        pivot.setRight(child.getLeft());
        //if child's left child exists, update it with its new parent (pivot)
        if (child.getLeft() != null) {
        	child.getLeft().setParent(pivot);
        }
        //update child's new left child (pivot)
        child.setLeft(pivot);
        //return the new BST root after rotation
        return child;
    }
    
    /**
     * Performs a right rotation.
     * @param pivot The node to rotate.
     */
    private TreeNode rotateRight(TreeNode pivot) {
    	
        TreeNode parent = pivot.getParent();
        TreeNode child = pivot.getLeft();
        
        if (parent == null) {
            root = child;
        } 
        else if (parent.getLeft() == pivot) {
            parent.setLeft(child);
        } 
        else {
            parent.setRight(child);
        }
        
        child.setParent(pivot.getParent());
        pivot.setParent(child);
        pivot.setLeft(child.getRight());
        if (child.getRight() != null) {
        	child.getRight().setParent(pivot);
        }
        child.setRight(pivot);
        return child;
    }
    
    private TreeNode doubleWithLeftChild(TreeNode k3)
    {
        System.out.println("Left Rotation Performed");
        k3.left = rotateRight(k3.left);
        return rotateLeft(k3);
    }
 
    private TreeNode doubleWithRightChild(TreeNode k1)
    {
        System.out.println("Right Rotation Performed");
        k1.right = rotateLeft(k1.right);
        return rotateRight(k1);
    }
    
    /*HELPER METHODS*/
    
    private int nume = 1;
    public void traverseInOrder(TreeNode node, String w) {
	    if (node != null) {
	        traverseInOrder(node.left, w);
	        if (node.item.key() == w) {
	        	nume = node.item.getFreq();
	        }
	        traverseInOrder(node.right, w);
	    }
	}
    
    /*END HELPER METHODS*/
    
    
    /*OTHERS*/

    private String toStringR(TreeNode h){
	    if (h == null) return "";
	    String s = toStringR(h.getLeft());
	    s += h.getItem().toString() + " ";
	    sum += h.getItem().getFreq();
	    count++;
	    s += toStringR(h.getRight());
	    return s;
    }
    
    public String toString(){
    	System.out.println(root.item.key());
    	return toStringR(root);
    }

}
