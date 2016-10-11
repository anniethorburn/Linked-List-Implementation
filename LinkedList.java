/**
 * This class implements a linked list
 * @author Annie Lukas Thorburn
 *
 */
public class LinkedList {
	// Variables for the head, tail, and current node
	private Node head;
	private Node tail;
	private Node curr;
	// Variable for the size
	private int size;
	
	/**
	 * This method is the constructor for the class LinkedList
	 */
	public LinkedList() {
		head = null;
		tail = null;
		curr = null;
		size = 0;
	}
	
	/**
	 * This method adds a node at the start of the list
	 * <p>
	 * This method runs in constant time
	 * @param newNode the node that is being added
	 */
	public void addFirst(Node newNode) {
		newNode.next = head;
		// Special case for when list was empty before this node was added
		if (isEmpty()){
			tail = newNode;
		}
		else {
			head.prev = newNode;
		}
		head = newNode;
		size += 1;
	}
	
	/**
	 * This method adds a node at the end of the list
	 * <p>
	 * This method runs in constant time
	 * @param newNode the node that is being added
	 */
	public void addLast(Node newNode) {

		// Special case for when list was empty before this node was added
		if (isEmpty()){
			head = newNode;
			tail = newNode;
			size += 1;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size += 1;
		}
	}
	/**
	 * This method adds a node immediately after the current node
	 * <p>
	 * This method runs in constant time
	 * @param newNode
	 */
	public void addBetween(Node newNode) {
		newNode.next = curr.next;
		curr.next = newNode;
		newNode.prev = curr;
		// Special case for when the current node is the last node in the list
		if (curr == tail){
			tail = curr.next;
		}
		else {
			(newNode.next).prev = newNode;
		}
		size += 1;
	}
	
	/**
	 *  This method sets the current node to the beginning of the list
	 *  This method runs in constant time
	 */
	public void reset() {
		curr = head;
	}
	
	/**
	 * This method advances the current node by 1
	 * <p>
	 * This method runs in constant time
	 */
	public void advance() {
		curr = curr.next;
	}
	
	/**
	 * This method advances the current node backwards by 1
	 * <p>
	 * This method runs in constant time
	 */
	public void advanceBack() {
		curr = curr.prev;
	}
	
	/**
	 * This method advances the current node by a specified number of nodes, 
	 * either positive or negative
	 * <p>
	 * This method runs in constant time
	 * @param n The number of nodes by which to advance the current node
	 */
	public void advanceByN(int n) {
		if (n >= 0) {
			for (int i=1; i<=n; i++){
				advance();
			}
		}
		else {
			for (int i = -1; i>=n; i--){
				advanceBack();
			}
		}
	}
	
	/** 
	 * This method deletes the first node
	 * <p>
	 * This method runs in constant time
	 */
	public void removeFirst() throws Exception {
		if (head == null) {
			throw new Exception();
		}
		else {
			head = head.next;
			reset();
			size -= 1;
		}
		
	}
	
	/**
	 * This method returns the current node
	 * <p>
	 * This method runs in current time
	 * @return The current node
	 */
	public Node getCurr(){
		return curr;
	}
	/**
	 * This method returns the first node
	 * <p>
	 * This method runs in constant time
	 * @return The first node
	 */
	public Node getHead(){
		return head;
	}
	
	// Returns the last node
	public Node getTail(){
		return tail;
	}
	
	// Returns the size of the list
	public int getSize(){
		return size;
	}
	
	// Checks whether the list is empty
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Advances curr to a specified node (i.e., finds a node)
	public void findNode(Node query) throws Exception {
		reset();
		while (curr != query) {
			if (curr == tail) {
				throw new Exception();
			}
			else {
				advance();
			}
		}
	}
	
	// Prints all the nodes in the list, starting from the head
	public void displayList() {
		reset();
		System.out.print("[");
		for(int i=1; i<=size; i++){
			System.out.print(curr.data);
			if (i < size) {
				System.out.print(", ");
			}
			advance();
		}
		System.out.print("]\n");
	}
	
	// Prints all the nodes in the list in reverse order, starting from the tail
	public void displayListReverse() {
		curr = tail;
		System.out.print("[");
		for(int i=1; i<=size; i++){
			System.out.print(curr.data);
			if (i < size) {
				System.out.print(", ");
			}
			advanceBack();
		}
		System.out.print("]\n");
	}
	
	// Prints the nodes in the list, starting from the current node
	public void displayListCurr() {
		System.out.print("[");
		for(int i=1; i<=size; i++){
			System.out.print(curr.data);
			if (i < size) {
				System.out.print(", ");
			}
			advance();
		}
		System.out.print("]\n");
	}
	
	// Turns a linear list into a circular list
	public void makeCircular() {
		tail.next = head;
		head.prev = tail;
	}
	
	// Turns a circular list into a linear list
	public void makeLinear() {
		tail.next = null;
		head.prev = null;
	}

}
