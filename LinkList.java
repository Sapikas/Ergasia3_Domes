import java.io.PrintStream;

import java.util.NoSuchElementException;

public class LinkList {
	private class Node {
		 String data;
		 Node next;

		 public Node (String item, Node n) {
			 data = item;
			 next = n;
		 }

	} //λιστα μονής σύνδεσης
	
	private Node top = null;
	int size= 0;
	
//	public boolean isEmpty() {
//		return size == 0;
//	}

	
	public void push(String item) {
		Node newNode = new Node(item,top);
		top = newNode;
		size++;
	}

	void deleteNode(String key)
    {
        // Store head node
        Node temp = top, prev = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            top = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
 
        // If key was not present in linked list
        if (temp == null)
            return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    }
	
	public boolean printStack(String w) {
		  Node current = top; 
	        if(top== null) {    
	            System.out.println("List is empty");    
	            return false;    
	        }    
	        System.out.println("Nodes are : ");    
	        while(current != null) {  
	        	String ww = current.data.toLowerCase();
	        	boolean areEqual = ww.equals(w);
	        	if (areEqual) {
	        		return true;
	        	}
	            current = current.next;    
	        }    
	        return false;
		
	}


}
