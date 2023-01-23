import java.util.Scanner;

// Find if a String2 is substring of String1. If it is, return the index of the first
//        occurrence. else return -1.
//        Eg 1: Input: String 1: test123string
//        String 2: 123
//        Output: 4
//        Eg 2:  Input: String 1: testing12
//        String 2: 1234
//        Output: -1
public class Question59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s2 = sc.next();
        if(s.contains(s2)){
            System.out.println(s.indexOf(s2.charAt(0)));
        }else{
            System.out.println(-1);
        }
    }
}
