import java.io.PrintStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
public class BST implements WordCounter {
	
	private class TreeNode {
		TreeNode parent;
		WordFreq item;
		TreeNode left; // pointer to left subtree
		TreeNode right; // pointer to right subtree
		int size; //number of nodes in subtree starting at this node 
		int height;
		TreeNode(WordFreq item){
			this.item= item;
			//subtreeSize++;
			height = 0;
//			this.left = null;
//			this.right = null;
//			this.subtreeSize = 0;
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
//		public int getSize() {
//			return subtreeSize;
//		}
		
		public TreeNode getParent() {
			// TODO Auto-generated method stub
			return this.parent;
		}
		public void setParent(TreeNode parent2) {
			// TODO Auto-generated method stub
			this.parent = parent;

		}
		
	}
	/*End of TreeNode*/
	
	
	private TreeNode root;
	private int size = 0;
	
	private TreeNode rootInsert(TreeNode root, WordFreq element, TreeNode parent) {
		if (root == null) {
        	//the BST specified by root is empty (it has 0 elements) -
        	//initialize node with element and insert it at the BST
        	//(do not make any rotations)
            TreeNode node = new TreeNode(element);
            node.setParent(parent);
            ++size;
            return node;
        }
        
        //BST not empty
        //find subtree where we're going to insert element
        //int result = cmp.compare(element, root.getData());
		int result = element.key().compareTo(root.getItem().key());
        //int result = ((Comparable<String>) element).compareTo(root.getItem().key());
        
        
        if (result == 0) {
        	//element equal to root
        	//do not insert element in the BST
        	return root;
        }
        
        if (result < 0) {
        	//element smaller than root
        	//(1) insert element at the left subtree of root (recursively)
        	TreeNode leftSubtreeRoot = this.rootInsert(root.getLeft(), element, root);
        	//(2) update root's left subtree
            root.setLeft(leftSubtreeRoot);
            //(3) perform a rotation at the opposite (right)
            root = this.rotateRight(root);
            
        } 
        else {
        	//element bigger than root
        	//(1) insert element at the right subtree of root (recursively)
        	TreeNode rightSubtreeRoot = this.rootInsert(root.getRight(), element, root);
        	//(2) update root's right subtree
        	root.setRight(rightSubtreeRoot);
        	//(3) perform a rotation at the opposite (left)
        	root = this.rotateLeft(root);
        }
        
        //after each rotation, return the updated BST
        return root;
	}

	@Override
	public void insert(String w) {
		// TODO Auto-generated method stub
		WordFreq data = new WordFreq(w, size);
		root = rootInsert(root, data, null);
	}

	@Override
	public WordFreq search(String w) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String w) {
		// TODO Auto-generated method stub
		
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

	@Override
	public double getMeanFrequency() {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public void PrintStach() {
		// TODO Auto-generated method stub
		traverseLevelOrder();
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
    
    public void traverseLevelOrder() {
	    if (root == null) {
	        return;
	    }

	    Queue<TreeNode> nodes = new LinkedList<>();
	    nodes.add(root);
	    System.out.println(root.item.key());
	    while (!nodes.isEmpty()) {
	    	
	        TreeNode node = nodes.remove();

	        System.out.print(" " + node.item.key());

	        if (node.left != null) {
	            nodes.add(node.left);
	        }

	        if (node.right != null) {
	            nodes.add(node.right);
	        }
	    }
	}
    
    private String toStringR(TreeNode h){
	    if (h == null) return "";
	    String s = toStringR(h.getLeft());
	    s += h.getItem().toString() + " ";
	    s += toStringR(h.getRight());
	    return s;
    }
    
    public String toString(){
    	return toStringR(root);
    }



}
