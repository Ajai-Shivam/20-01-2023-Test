import java.util.Scanner;

//Java Program to find the given two strings are palindrome
public class
Question95 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        method1(s, s1);
        method2(s1, s1);
    }

    public static void method1(String s, String s1) {
        System.out.println("method 1 : ");
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String pals = sb.toString();
        if (s.equals(pals)) {
            System.out.println("String 1 : Is A Palindrome");
        } else {
            System.out.println("String 1 : Is Not A Palindrome");
        }
        StringBuilder sb1 = new StringBuilder(s1);
        sb1.reverse();
        String pals1 = sb1.toString();
        if (s1.equals(pals1)) {
            System.out.println("String 2 : Is A Palindrome");
        } else {
            System.out.println("String 2 : Is Not A Palindrome");
        }
    }

    public static void method2(String s, String s1) {
        System.out.println("Method 2 : ");
        int string1start = 0;
        int String1end = s.length()-1;
        boolean ans = true;
        while (string1start < String1end) {
            if (s.charAt(string1start) != s.charAt(String1end)) {
                ans = false;
                break;
            }
            string1start++;
            String1end--;
        }
        if (ans) {
            System.out.println("String 1 : Is A Palindrome");
        } else {
            System.out.println("String 1 : Is not A Palindrome");
        }

        int string2start = 0;
        int String2end = s1.length()-1;
        boolean ans2 = true;
        while (string2start < String2end) {
            if (s.charAt(string2start) != s.charAt(String2end)) {
                ans2 = false;
                break;

            }
            string2start++;
            String2end--;
        }
        if (ans2) {
            System.out.println("String 2 : Is A Palindrome");
        } else {
            System.out.println("String 2 : is not A Palindrome");
        }
    }
}
