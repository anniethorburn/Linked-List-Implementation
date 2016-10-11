// Annie Lukas Thorburn
// lthorburn@brandeis.edu


// Implementation of a queue using an array
public class Queue {
	private Object[] A;
	// Variable for the index of the first element of the queue
	private int front;
	// Variable for the index of the next available array cell in the queue
	private int rear;
	
	// Construct an empty queue of length n
	public Queue(int n) {
		A = new Object[n];
		front = 0;
		rear = 0;
	}
	
	// Add an element to the queue
	public void enqueue(Object element){
		// Do not add the element if the queue is already full
		if (isFull()) {
			return;
		}
		else {	
			A[rear] = element;
			if (rear == A.length - 1) {
					rear = 0;
			}
			else {
				rear += 1;
			}
		}
	}
	
	// Remove the first element from the queue
	public Object dequeue(){
		Object element = A[front];
		if (front == A.length - 1) {
			front = 1;
		}
		else {
			front += 1;
		}
		return element;
	}
	
	// Return the first element of the queue without removing it
	public Object getFront() {
		return A[front];
	}
	
	// Return the index of the front of the queue
	public int frontIndex() {
		return front;
	}
	
	// Return the index of the rear of the queue
	public int rearIndex() {
		return rear;
	}
	
	// Determine whether the queue is empty
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Determine whether the queue is full
	public boolean isFull() {
		if (rear == A.length - 1){
			if (front == 0){
				return true;
			}
			else {
				return false;
			}
		}
		else if (rear == front - 1){
			return true;
		}
		else {
			return false;
		}
	}
	

}
