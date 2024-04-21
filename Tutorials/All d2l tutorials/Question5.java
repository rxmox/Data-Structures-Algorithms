import java.util.Scanner;

public class Question5 {

    static int numberOfVowels(String s){
        int numberOfVowels = 0;

        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case 'a':
                    numberOfVowels += 1;
                    break;
                case 'e':
                    numberOfVowels += 1;
                    break;
                case 'i':
                    numberOfVowels += 1;
                    break;
                case 'o':
                    numberOfVowels += 1;
                    break;
                case 'u':
                    numberOfVowels += 1;
                    break;
                default:
                    break;
            }
        }

        return numberOfVowels;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter s: ");
        String s = scanner.next();

        System.out.println(numberOfVowels(s));

        scanner.close();
    }
}
