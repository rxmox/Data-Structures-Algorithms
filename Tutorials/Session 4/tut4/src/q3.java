public class q3 {

    public static void main(String[] args){

        System.out.println(summation(-10));
        System.out.println(summation(0));
        System.out.println(summation(1));
        System.out.println(summation(5));
        System.out.println(summation(1000000));

    }
    public static long summation(long n){
        long sum = 0;
        //for loop
        for (long i = n; i >= 0; i--){
            if (i % 2 == 1)
                sum += i;
        }
        return sum;
    }
}
