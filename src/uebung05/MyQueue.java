package uebung05;

import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.readLine;

public class MyQueue implements Queue{
	
	static Queue workingQueue;
	
	private LinkedList list;
	
	public static void main(String[] args) {
		
		workingQueue = MyQueue.empty();
		
		while (true) {
			makeMenu();
		}
	}
	
	public static void makeMenu() {
		println("------------------- Menü -------------------");
		println("1: Print queue");
		println("2: Print size of the list");
		println("3: enter(element)");
		println("4: leave()");
		println("5: front()");
		println("6: isEmpty()");
		println("7: empty()"); 		//Overrides current workingQueue
		
		int selection = readInt();
		int value;

		switch (selection) {
		case 1:
			println(workingQueue.toString());
			break;
			
		case 2:
			println(workingQueue.size());
			break;
			
		case 3:
			println("value to add= ");
			value = readInt();
			workingQueue.enter(value);
			break;
			
		case 4:
			println("Value " + workingQueue.leave() + " has left the front of the queue.");
			break;
			
		case 5:
			println("The value next up is " + workingQueue.front());
			break;
			
		case 6:
			if(workingQueue.isEmpty())
				println("The queue is empty.");
			else
				println("The queue is not empty.");
			break;
			
		case 7:
			workingQueue = MyQueue.empty();
			println("Working queue has been overwritten with new, empty queue.");
			break;
		}
		;
		readLine();
	}

	static Queue empty() {
		Queue queue = new MyQueue();
		queue.setList(new MyLinkedList());
		return queue;
	}
	
	@Override
	public void enter(int value) {
		list.addLast(new ListNode(value,null));
	}

	@Override
	public int leave() {
		int value = list.getFirst().getValue();
		list.removeFirst();
		return value;
	}

	@Override
	public int front() {
		return list.getFirst().getValue();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override
	public void setList(LinkedList list) {
		this.list = list;
	}

	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
}