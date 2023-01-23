import java.util.Scanner;

//Java program to find a character in a word string linear search
public class Question96 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);
        method1(s,c);
        method2(s,c);
    }
    public static void method1(String s,char c){
        System.out.println("Method 1 : ");
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==c){
                System.out.println(i);
                break;
            }
        }
    }
    public static void method2(String s,char c){
        System.out.println("Method 2 : ");
        System.out.println(s.indexOf(c));
    }
}
