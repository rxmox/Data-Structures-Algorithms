public class q1 {
    public static void main(String[] args) {

        System.out.println(isMultiple(10, 5));
        System.out.println(isMultiple(7, 3));
        System.out.println(isMultiple(-1, 1));
        System.out.println(isMultiple(4, 0));
        System.out.println(isMultiple(0, 0));
    }

    public static boolean isMultiple(long n, long m) {
        if (n == 0 && m == 0) {
            return true; // if both are zero return true
        }
        else if (m == 0) {
            return false; // Division by zero is not defined
        }
        return n % m == 0;
    }
}