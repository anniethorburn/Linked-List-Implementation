// Annie Lukas Thorburn
// lthorburn@brandeis.edu

// Implementation of a stack using a linked list
public class Stack {
	// Linked list containing the stack elements
	private LinkedList stackList;
	
	// Constructs an empty stack
	public Stack() {
		stackList = new LinkedList();
	}
	
	// Push an element onto the stack
	public void push(Object element){
		stackList.addFirst(new Node(element));
	}
	
	// Pop an element from the stack
	// Throws an exception if the stack is empty
	public Object pop() throws Exception{
		Object element = stackList.getHead().data;
		stackList.removeFirst();
		return element;
	}
	
	// Returns the top element of the stack without removing it
	public Object top() {
		return stackList.getHead().data;
	}
	
	// Returns size of stack (i.e., number of elements stored)
	public int size() {
		return stackList.getSize();
	}
	
	// Checks whether the stack is empty
	public boolean isEmpty() {
		return stackList.isEmpty();
	}
	
	// Displays the stack
	public void displayStack(){
		// Displays the list in reverse so that the contents
		// of the stack are displayed from left to right
		stackList.displayListReverse();
	}

}
