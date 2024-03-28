import java.util.Arrays;

public class anagram {
	public static void main(String args[]) {
		String text_a ="Hello ? ! . ";
		String text_b = "olleh :./::";

		text_a = text_a.replaceAll("\\p{Punct}", "-");
		text_a = text_a.replaceAll(" ", "-");
		System.out.println(text_a);
		
		
		
//        char[] charArray1 = text_a.toCharArray();
//        char[] charArray2 = text_b.toCharArray();
//
//
//        Arrays.sort(charArray1);
//        Arrays.sort(charArray2);
//        
//   
//        if (Arrays.equals(charArray1, charArray2)) {
//        	System.out.println("Anagram");
//        }else {
//        	System.out.println("Not Anagram");
//        }
		
			
	}
}
