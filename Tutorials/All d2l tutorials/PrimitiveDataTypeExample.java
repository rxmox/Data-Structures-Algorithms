public class PrimitiveDataTypeExample {
    public static void main(String[] args){
        // boolean
        boolean booleanVariable = true;
        System.out.println("Boolean Variable: " + booleanVariable);
        System.out.println();

        // byte
        byte byteVariable = 127;
        System.out.println("Byte Variable: " + byteVariable);
        System.out.println();

        // char
        char charVariable = 'A';
        System.out.println("Char Variable: " + charVariable);
        System.out.println();

        // short
        short shortVariable = 32767;
        System.out.println("Short Variable: " + shortVariable);
        System.out.println();

        // int
        int intVariable = 2147483647;
        System.out.println("Int Variable: " + intVariable);
        // Handling overflow for byte
        intVariable = intVariable + 1; // Overflow will occur
        System.out.println("Int Variable (Overflow): " + intVariable);
        System.out.println();

        // long
        long longVariable = 9223372036854775807L; // Note the 'L' at the end for a long literal
        System.out.println("Long Variable: " + longVariable);
        System.out.println();

        // float
        float floatVariable = 3.14f; // Note the 'f' at the end for a float literal
        System.out.println("Float Variable: " + floatVariable);
        System.out.println();

        // double
        double doubleVariable = 3.141592653589793;
        System.out.println("Double Variable: " + doubleVariable);
        System.out.println();
    }
}
