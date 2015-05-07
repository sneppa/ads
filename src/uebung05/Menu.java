package uebung05;

import static gdi.MakeItSimple.*;


public class Menu {
	
	static LinkedList lists[] = new LinkedList[3];  // array with 3 linked lists

	public static void main(String[] args) {
		
		for (int i = 0; i < lists.length; i++)
			lists[i] = new MyLinkedList();
		

		while (true) {
			makeMenu();
		}

	}

	public static void makeMenu() {
	

		int currentList = 0; // working list per default
		
		println("------------------- Men� -------------------");
		println("1: Print List");  // calls method toString
		println("2: Print size of the list");
		println("3: add(index, element)");
		println("4: addFirst(element)");
		println("5: addLast(element)");
		println("6: addAll(LinkedList)");
		println("7: getAt(index)");
		println("8: getFirst()");
		println("9: getLast()");
		println("10: removeFirst()");
		println("11: removeLast()");
		println("12: removeAll()");  // calls method clear
		println("13: remove(element)");
		println("14: toArray()");
		println("15: isempty()");
		println("16: contains(element)");
		println("17: delete(index)");  // delete element at index
		println("18: cloneDeep()");
		println("20: empty()");  // returns a new (empty) list, has to be implemented as a static method
		println("30: change working list");  // sets another list as working list
		
		

		int selection = readInt();
		int value, index;

		switch (selection) {
		case 1:
			println(lists[currentList].toString());
			break;
			
		case 2:
			println("Size of list: " + lists[currentList].size());
			break;
			
		case 3:
			println("value to add= ");
			value = readInt();
			println("position where to add= ");
			index = readInt();
			lists[currentList].add(index,new ListNode(value,null));
			break;
			
		case 4:
			println("value to add= ");
			value = readInt();
			lists[currentList].addFirst(new ListNode(value,null));
			break;
			
		case 5:
			println("value to add= ");
			value = readInt();
			lists[currentList].addLast(new ListNode(value,null));
			break;
			
		case 6:
			println("Choose list (1-3) to add to current working list: ");
			value = readInt();
			if(value > 3 || value < 1)
				println("Invalid list number.");
			else
				lists[currentList].addAll(lists[value-1]);
			break;
			
		case 7:
			println("index to look up= ");
			value = readInt();
			if(lists[currentList].isEmpty())
				println("List is empty.");
			else
				println(lists[currentList].getAt(value));
			break;
			
		case 8:
			if(lists[currentList].isEmpty())
				println("List is empty.");
			else
			println(lists[currentList].getFirst());
			break;
			
		case 9:
			if(lists[currentList].isEmpty())
				println("List is empty.");
			else
			println(lists[currentList].getLast());
			break;
			
		case 10:
			lists[currentList].removeFirst();
			break;
			
		case 11:
			lists[currentList].removeLast();
			break;
			
		case 12:
			lists[currentList].removeAll();
			break;		
			
		case 13:
			println("value which has to be deleted (first node with value will be deleted)= ");
			value = readInt();
			lists[currentList].removeByVal(value);
			break;
			
		case 14:
                        for (int i : lists[currentList].toArray())
                        {
                            print(i + " ");
                        }
			println();
                        break;
			
		case 15:
			println(lists[currentList].isEmpty());
			break;
			
		case 16:
			println("value to look after= ");
			value = readInt();
			println(lists[currentList].contains(value));
			break;
			
		case 17:
			println("index to delete= ");
			value = readInt();
			lists[currentList].removeAt(value);
			break;
			
		case 18:
			LinkedList clone = lists[currentList].cloneDeep();
			if(currentList == 0) {
				lists[1] = clone;
				println("List cloned into list slot 2.");
			}
			if(currentList == 1){
				lists[2] = clone;
				println("List cloned into list slot 3.");
			}
			if(currentList == 2){
				lists[0] = clone;
				println("List cloned into list slot 1.");
			}
			break;
			
		case 20:
			lists[currentList] = new MyLinkedList();
			break;
			
		case 30:
			println("Choose list (1-3) to work with: ");
			value = readInt();
			if(value > 3 || value < 1)
				println("Invalid list number (" + value + ")");
			else
				currentList = value-1;
			break;
			
		default:
			break;
		}
		;

		readLine();

	}
}

