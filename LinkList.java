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

		 public void setData (String val) {
			 data = val;
		 }

		 public String getData () {
			 return data;
		 }

		 public Node getNext () {
			 return next;
		 }

		 public void setNext (Node n) {
			 next = n;
		 }
	} //λιστα μονής σύνδεσης
	
	private Node top = null;
	int size= 0;
	
	public boolean isEmpty() {
		return size == 0;
	}

	
	public void push(String item) {
		Node newNode = new Node(item,top);
		top = newNode;
		size++;
	}

	
	public String pop() throws NoSuchElementException {
		 String data = null;
		 if (isEmpty()) throw new NoSuchElementException();
		 else {
			 data = top.getData(); 
			 Node tmp = top; 
			 top = top.getNext(); 
			 tmp.setNext(null); 
			
			 size--;
		 }
		 return data;
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

	
	public String peek() throws NoSuchElementException {
		String data = null;
		 if (isEmpty()) throw new NoSuchElementException();
		 else data = top.getData(); 
		 return data;

	}

	
	public void printStack(PrintStream stream) {
		  Node current = top;    
	        if(top== null) {    
	            System.out.println("List is empty");    
	            return;    
	        }    
	        System.out.println("Nodes are : ");    
	        while(current != null) {        
	            System.out.println(current.data + " ");    
	            current = current.next;    
	        }    
	        System.out.println(); 
		
	}

	
	public int size() {
		return this.size;
	}
}
