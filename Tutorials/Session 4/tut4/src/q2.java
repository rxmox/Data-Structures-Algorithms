public class q2 {

    public static void main(String[] args){

        System.out.println(isEven(4));
        System.out.println(isEven(1));
        System.out.println(isEven(0));
        System.out.println(isEven(-1));
        System.out.println(isEven(-4));
    }
    public static boolean isEven(int i){
        int firstBit = i & 1; // bitwise AND with 1, if first bit is zero then it is even
        return firstBit == 0;
    }
}
