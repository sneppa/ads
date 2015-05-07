package uebung05;

public interface Queue {
	
	/**
	 * Enters an integer into the queue.
	 * @param value Value.
	 */
	void enter(int value);
	
	/**
	 * Returns and removes the first integer that has entered the queue.
	 * @return Integer.
	 */
	int leave();
	
	/**
	 * Returns but not removes the first integer that has entered the queue.
	 * @return Integer.
	 */
	int front();
	
	/**
	 * Returns weather the queue is empty or not.
	 * @return True if empty.
	 */
	boolean isEmpty();
	
	/**
	 * Chooses which LinkedList object has to be used as a queue.
	 * @param list LinkedList which all actions are performed on.
	 */
	void setList(LinkedList list);
	
	/**
	 * Returns the contents of the queue as a string.
	 * @return String.
	 */
	String toString();
	
	/**
	 * Returns size of queue.
	 * @return Amount of nodes.
	 */
	int size();
}