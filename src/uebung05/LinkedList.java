package uebung05;

public interface LinkedList {
	
	/**
	 * Prints the contents of LinkedList in the console
	 * @return String in which the int values are listed.
	 */
	String toString();
	
	/**
	 * Prints the size of LinkedList;
	 * @return Size.
	 */
	int size();
	
	/**
	 * Adds a node to the beginning of the list.
	 * @param value node.
	 */
	void addFirst(ListNode node);
	
	/**
	 * Adds a node to the end of the list.
	 * @param value node.
	 * @return Index of the last item.
	 */
	int addLast(ListNode node);
	
	/**
	 * Returns the first node of the list.
	 * @return node.
	 */
	ListNode getFirst();
	
	/**
	 * Returns the last node of the list.
	 * @return node.
	 */
	ListNode getLast();
	
	/**
	 * Removes the first node of the list.
	 */
	void removeFirst();
	
	/**
	 * Removes the last node of the list.
	 */
	void removeLast();
	
	/**
	 * Clears the List.
	 */
	void removeAll();
	
	/**
	 * Checks if the LinkedList is empty.
	 * @return True if no nodes exist.
	 */
	boolean isEmpty();
	
	/**
	 * Checks if given value is in LinkedList
	 * @param value Value.
	 * @return True if LinkedList contains this value.
	 */
	boolean contains(int value);
	
	/**
	 * Removes a ListNode from the list.
	 * @param node Node.
	 */
	void remove(ListNode node);
	
	/**
	 * Removes a node at given index.
	 * @param index Index.
	 */
	void removeAt(int index);
	
	/**
	 * Removes the first node with the same value as param.
	 * @param value Value to delete.
	 */
	void removeByVal(int value);
	
	/**
	 * Inserts an integer into the list at given index.
	 * @param index Position of the integer that has to be added.
	 * @param node Node.
	 * @return Final index of the new value if param index is invalid.
	 */
	int add(int index, ListNode node);
	
	/**
	 * Returns a single value at given index. Returns the first value in list if index is smaller than smallest index
	 * in list, returns last value if index is bigger than highest available index.
	 * @param index Index of the value which has to be returned.
	 * @return Value of given index.
	 */
	ListNode getAt(int index);
	
	/**
	 * Returns an array which contains all elements of LinkedList.
	 * @return Array of all integers.
	 */
	int[] toArray();
	
	/**
	 * Returns a deep clone of this LinkedList (Copied contents but with new delimiters).
	 * @return A new LinkedList.
	 */
	LinkedList cloneDeep();
	
	/**
	 * Adds all values of otherList to this LinkedList.
	 * @param otherList Other List which has to be merged with this LinkedList.
	 */
	void addAll(LinkedList otherList);
	
	/**
	 * Merges this and otherList into a new LinkedList, the original Lists remain unchanged.
	 * @param otherList Other List which has to be merged with this LinkedList.
	 * @return New, merged LinkedList.
	 */
	LinkedList concat(LinkedList otherList);
	
	
}
