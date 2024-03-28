public class ArrayExample {
    public static void main(String[] args){
        // // Declaration of an integer array
        // int[] myFirstArray;

        // // Creating an array with a size of 3 (default value for int is 0)
        // myFirstArray = new int[3];

        // // Displaying the initial values of myFirstArray
        // System.out.println("myFirstArray: " + myFirstArray[0] + ", " + myFirstArray[1] + ", " + myFirstArray[2]);

        // // Assigning new values to the elements of myFirstArray
        // myFirstArray[0] = 3;
        // myFirstArray[1] = 5;
        // myFirstArray[2] = 7;

        // // Displaying the updated values of myFirstArray
        // System.out.println("myFirstArray: " + myFirstArray[0] + ", " + myFirstArray[1] + ", " + myFirstArray[2]);
        // System.out.println();


        // Declaration and initialization of a 2D array
        int[][] mySecondArray = {{1, 2, 3}, {4, 5, 6}};

        // Displaying the number of rows in mySecondArray
        System.out.println("Number of rows in mySecondArray: " + mySecondArray.length);

        // Displaying the number of columns in mySecondArray (assuming all rows have the same length)
        System.out.println("Number of columns in mySecondArray: " + mySecondArray[0].length);
        System.out.println("Number at row 0 and column 1 is " + mySecondArray[0][1]);
        System.out.println();
    }
}
