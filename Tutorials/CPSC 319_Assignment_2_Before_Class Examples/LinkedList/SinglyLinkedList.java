public class SinglyLinkedList {

    private Node head = null;
    private Node tail = null;

    private int size = 0;

    public int size() {
        return size;
    }

    public SinglyLinkedList() {
        // Create an empty Linked List
    }

    public boolean isEmpty() {
        return size == 0;
    }
    //getter and setter methods 
  	public Node getHead() 
  	{
  		return head;
  	}
  	
    public int first() {
        if (isEmpty())
            return -1;

        return head.getId();
    }

    // Add id to the front of the list
    public void addFirst(int n) {
    	
    	Node new_node = new Node(n,null); // Create an empty node 
    	new_node.setNext(head); // Force it to connect with head node 
    	
    	head = new_node; // Make the new_node as head 

        if (size == 0)
            tail = head;

        size++;
    }

    public void addLast(int n) {
        Node newest = new Node(n, null);

        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;

        size++;
    }

    public int remFirst() {
        if (isEmpty())
            return -1;

        int answer = head.getId();
        head = head.getNext();
        size--;

        if (size == 0)
            tail = null;

        return answer;
    }

    public int remLast() {
        if (isEmpty())
            return -1;

        int answer;
        if (size == 1) {
            answer = head.getId();
            head = tail = null;
        } else {
            Node secondToLast = head;
            while (secondToLast.getNext() != tail) {
                secondToLast = secondToLast.getNext();
            }
            answer = tail.getId();
            secondToLast.setNext(null);
            tail = secondToLast;
        }

        size--;

        return answer;
    }

    public void show() {
        Node node = head;

        while (node != null) {
            System.out.println(node.getId());
            node = node.getNext();
        }
    }
}
