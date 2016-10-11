// Annie Lukas Thorburn
// lthorburn@brandeis.edu

// Represents a Node, to be used in a Linked List
public class Node {
	// Data for this node (can be any type)
	Object data;
	// Reference to next node
	Node next;
	// Reference to previous node
	Node prev;
	
	// Constructs a new node with data input by the client program
	public Node(Object newData) {
		data = newData;
		next = null;
		prev = null;
	}

}
