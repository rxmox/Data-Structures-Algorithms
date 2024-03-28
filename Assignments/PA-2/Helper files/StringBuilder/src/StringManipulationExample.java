
public class StringManipulationExample {
	public static void main(String[] args){
        // aaaBaaa -> aaaAaaa

        /////////////////////////////////////////////////////////////////

//        System.out.println("First way:");
//
//        String s1 = "aaaBaaa";
//        String s2 = s1.substring(0, 3) + "A" + s1.substring(4, 7);
//     
//        System.out.println(s2);
//        System.out.println(s1);

        /////////////////////////////////////////////////////////////////

//        System.out.println("Second way:");
//
//        String s3 = "aaaBaaa";
//        StringBuilder sb1 = new StringBuilder(s3);
//
//        System.out.println(sb1.toString());
//
//        sb1.deleteCharAt(3);
//        sb1.insert(3, 'A');
//
//        String s4 = sb1.toString();
//
//        System.out.println(s4);
//        System.out.println();
//
//        /////////////////////////////////////////////////////////////////
//
//        System.out.println("Third way:");
//
//        String s5 = "aaaBaaa";
//        StringBuilder sb2 = new StringBuilder(s5);
//
//        sb2.setCharAt(3, 'A');
//
//        System.out.println(sb2.toString());
//        System.out.println();

//        /////////////////////////////////////////////////////////////////
//
//        System.out.println("Fourth way:");
//
//        String s6 = "aaaBaaa";
//        StringBuilder sb3 = new StringBuilder(s6);
//
//        char[] ca = sb3.toString().toCharArray();
//
//        System.out.println(ca.length);
//
//        ca[3] = 'A';
//
//        sb3.setLength(0);
//
//        sb3.append(ca);
//
//        System.out.println(sb3.toString());
//        System.out.println();
//
//        /////////////////////////////////////////////////////////////////

    }
}
