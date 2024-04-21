import java.util.ArrayList;

public class DynamicArrayExample {
    public static void main(String[] args) {
        // Creating a dynamic array using ArrayList
        ArrayList<Integer> dynamicArray = new ArrayList<>();

        // Adding elements to the dynamic array
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.add(30);

        // Displaying the elements
        System.out.println("Dynamic Array: " + dynamicArray);

        // Accessing elements by index
        int elementAtIndex = dynamicArray.get(1);
        System.out.println("Element at index 1: " + elementAtIndex);

        // Modifying elements
        dynamicArray.set(1, 25);
        System.out.println("Modified Dynamic Array: " + dynamicArray);

        // Removing an element
        dynamicArray.remove(0);
        System.out.println("Dynamic Array after removal: " + dynamicArray);

        // Checking the size of the dynamic array
        int size = dynamicArray.size();
        System.out.println("Size: " + size);
    }
}
