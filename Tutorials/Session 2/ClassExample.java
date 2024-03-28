// Class Definition
class Dog {
    // Class Member: Field
    int age;

    // Default Constructor
    Dog(){
        System.out.println("Creating dog object using the default constructor!");
    }

    // Custom Constructor
    Dog(int age){
        System.out.println("Creating dog object using the custom constructor!");
        this.age = age;
    }

    // Class Member: Method
    void bark(){
        System.out.println("Woof!");
    }
}

public class ClassExample {
    public static void main(String[] args){
        // Testing default constructor:
        System.out.println("Testing default constructor:");

        // Creating a Dog object using the default constructor
        Dog defaultConstructorDog = new Dog();

        // Invoking the 'bark' method on the Dog object
        defaultConstructorDog.bark();

        // Printing the 'age' field of the Dog object
        System.out.println(defaultConstructorDog.age);
        System.out.println();

        System.out.println();

        // Testing custom constructor:
        System.out.println("Testing custom constructor:");

        // Creating a Dog object using the custom constructor
        Dog customConstructorDog = new Dog(3);

        // Invoking the 'bark' method on the Dog object
        customConstructorDog.bark();

        // Printing the 'age' field of the Dog object
        System.out.println(customConstructorDog.age);
        System.out.println();
    }
}
