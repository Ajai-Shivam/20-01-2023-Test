import java.util.Scanner;

//.Java Program to print the print the equivalent Capital letter of a given small letter
//        in Alphabets
public class Question98 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        method1(ch);
        method2(ch);
    }
    public static void method1(char ch){
        System.out.println("Method 1 :");
        ch -= 32;
        System.out.println(ch);
    }
    public static void method2(char ch){
        System.out.println("Method 2 : ");
        System.out.println(Character.toUpperCase(ch));
    }
}
