import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SinglyLinkedListApp {

	public static void main(String[] args) {

		SinglyLinkedList list_1 = new SinglyLinkedList();
		SinglyLinkedList list_2 = new SinglyLinkedList();

		list_1.addFirst(20);
		list_1.addLast(50);
		list_1.addLast(100);
		list_1.remFirst();
		list_1.addLast(234);
		list_1.addLast(514);
		list_1.remLast();
		list_1.addFirst(32);
		
		list_1.show();
	
		list_2.addFirst(20);
		list_2.addLast(50);
		list_2.addLast(100);
		list_2.show();
		
//		System.out.println("The size of the list is: " + myList.size());
//		
		ArrayList<SinglyLinkedList> list_of_list = new ArrayList<SinglyLinkedList>();
		list_of_list.add(list_1);
	
		for (SinglyLinkedList list : list_of_list) {
		    System.out.println("Contents of SinglyLinkedList:");
		    Node node = list.getHead();
		    while (node != null) {
		        System.out.print(node.getId()+" ");
		        node = node.getNext();
		    }		   
		    System.out.println();
		}

	}
	
	

}

