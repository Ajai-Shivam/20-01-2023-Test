import java.util.Scanner;

//Java Program to convert all small letter to capital letter without using special
//        functions
public class
Question99 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        method1(ch);
    }
    public static void method1(char ch){
        System.out.println("Method 1 :");
        ch -= 32;
        System.out.println(ch);
    }
}
