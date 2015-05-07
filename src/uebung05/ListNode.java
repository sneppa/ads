package uebung05;

public class ListNode {

	private int value;
	private ListNode next = null;
	
	public ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ListNode getNext() {
		return this.next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}
