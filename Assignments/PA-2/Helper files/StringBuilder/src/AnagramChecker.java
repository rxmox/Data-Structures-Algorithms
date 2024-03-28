
import java.util.Arrays;
import java.util.Scanner;
public class AnagramChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String st_1 = sc.nextLine();
		String st_2 = sc.nextLine();
		
		st_1 = st_1.toLowerCase();
		st_2 = st_2.toLowerCase();
		
		st_1 = st_1.replaceAll("\\p{Punct}",""); 
		
		System.out.println(st_1+"-"+st_2);
		
		if(st_1.length()!=st_2.length()) {
			System.out.println("Not Anagram");
		}
		
		char[] s_1 = st_1.toCharArray();
		char[] s_2 = st_2.toCharArray();
		
		Arrays.sort(s_1);
		Arrays.sort(s_2);
		

		if(Arrays.equals(s_1, s_2)) {
			System.out.println("Anagram");
		}else {
			System.out.println("Not Anagram");
		}
		
	}
}
