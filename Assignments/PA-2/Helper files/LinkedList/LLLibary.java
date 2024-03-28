import java.util.LinkedList;

public class LLLibary {
	public static void main(String[] args) {
		 LinkedList<Integer> my_linkedlist = new LinkedList<Integer>();

	        System.out.println("Add:");

	        for(int i = 1; i <= 10; i++){
	            if(i % 2 == 0){
	                my_linkedlist.addFirst(i);
	            }else{
	                my_linkedlist.addLast(i);
	            }
		        

	        }
	        for(int i = 0; i < my_linkedlist.size(); i++){
	            System.out.print(my_linkedlist.get(i) + " ");
	        }

//	        System.out.println();
//	        System.out.println("Get:");
//

//	        System.out.println();
//
//	        System.out.println();
//	        System.out.println("Peek:");
	        System.out.println();
	        System.out.println(my_linkedlist.peekFirst());
	        System.out.println(my_linkedlist.peekLast());
//
//	        System.out.println();
//	        System.out.println("Poll:");
//
	        while(my_linkedlist.size() > 0){
	            if(my_linkedlist.size() % 2 == 0){
	                System.out.print(my_linkedlist.pollFirst() + " ");
	            }else{
	                System.out.print(my_linkedlist.pollLast() + " ");
	            }
	        }
//	        System.out.println();
	}
}