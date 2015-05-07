package uebung05;

public class MyLinkedList implements LinkedList {

	ListNode first;
	
	static public LinkedList empty() {
		LinkedList list = new MyLinkedList();
		return list;
	}

	@Override
	public int size() {
		
		if(this.isEmpty())
			return 0;
		
		ListNode current = this.first;
		
		int size = 1;
		
		while(current.getNext() != null) {
			current = current.getNext();
			size++;
		}
		
		return size;
	}
	
	@Override
	public void addFirst(ListNode node) {  
		node.setNext(this.first);
		this.first = node;
	}
	
	@Override
	public int add(int index, ListNode node) {
		
		ListNode current = this.first;
		if(this.isEmpty() || index <= 0) {		//If index is too low to be reached
			addFirst(node);
			return 0;
		}
		
		int i;
		for(i = 1; i < index; i++) {
			
			if(current.getNext() == null) {		//If index is too high to be reached
				current.setNext(node);
				return i;
			}
			
			current = current.getNext();
		}
		
		ListNode next = current.getNext();		//Insert node between two nodes
		current.setNext(node);
		node.setNext(next);
		return i;
	}

	@Override
	public int addLast(ListNode node) {
		this.add(this.size(), node);
		return 0;
	}

	@Override
	public ListNode getFirst() {
		return this.first;
	}
	
	@Override
	public ListNode getAt(int index) {
		
		//If index is bigger or smaller or list is empty...
		if(this.isEmpty())
			return null;
		if(index <= 0)
			this.getFirst();
		if(index >= this.size())
			this.getLast();
		
		ListNode current = this.first;
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	@Override
	public ListNode getLast() {
		
		if(this.isEmpty())
			return null;
		
		ListNode current = this.first;

		while(current.getNext() != null)
			current = current.getNext();
		
		return current;
	}
	

	@Override
	public void remove(ListNode node) {
		
		if(this.isEmpty())
			return;
		if(this.first == node)
			this.removeFirst();
		
		ListNode current = first;
		while(current.getNext() != node) {
			if(current.getNext() == null)
				return;
			current = current.getNext();
		}
		
		current.setNext(current.getNext().getNext());
	}
	
	@Override
	public void removeByVal(int value) {
		
		if(this.isEmpty())
			return;
		if(this.first.getValue() == value)
			this.removeFirst();
		
		ListNode current = first;
		while(current.getNext().getValue() != value) {
			if(current.getNext() == null)
				return;
			current = current.getNext();
		}
		
		current.setNext(current.getNext().getNext());
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty())
			return;
		
		this.first = first.getNext();
	}
	
	@Override
	public void removeAt(int index) {
		if(this.getAt(index) != null)
			this.remove(getAt(index));
	}

	@Override
	public void removeLast() {
		this.remove(getLast());
	}

	@Override
	public void removeAll() {
		this.first = null;		//If the list has no first element, it is empty... #mindblown
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public boolean contains(int value) {
		
		if(this.isEmpty())
			return false;
		
		ListNode current = first;
		
		while(current.getValue() != value) {
			if(current.getNext() == null)
				return false;
			current = current.getNext();
		}
		
		return true;
	}

	@Override
	public int[] toArray() {
		
		int[] values = new int[this.size()];
		if(this.isEmpty())
			return values;
		
		ListNode current = this.first;
		for(int i = 0; i < this.size(); i++) {
			values[i] = current.getValue();
			current = current.getNext();
		}
		
		return values;
	}
	
	@Override
	public String toString() {
		
		if(this.isEmpty())
			return "Contained values of LinkedList: {}";
		
		ListNode current = this.first;
		String values = "Contained values of LinkedList: {" + current.getValue();
		current = current.getNext();
		while(current != null) {
			values = values +  ", " + current.getValue();
			current = current.getNext();
		}
		
		return values + "}";
	}

	@Override
	public LinkedList cloneDeep() {
		
		LinkedList clonedList = new MyLinkedList();
		if(this.isEmpty())
			return clonedList;
		
		clonedList.addAll(this);
		
		return clonedList;
		
	}

	@Override
	public void addAll(LinkedList otherList) {
		
		if(otherList.isEmpty())
			return;
		
		ListNode current = otherList.getFirst();
		while(current != null) {
			ListNode clone = new ListNode(current.getValue(),null);
			this.addLast(clone);
			current = current.getNext();
		}
	}

	@Override
	public LinkedList concat(LinkedList otherList) {
	
		LinkedList clone = this.cloneDeep();
		clone.addAll(otherList);
		return clone;
	}

}
