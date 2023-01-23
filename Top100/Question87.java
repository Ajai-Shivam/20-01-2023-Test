import java.util.Scanner;

//Java Program to convert char array to string without using toString() method.
public class Question87 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        method1(arr);
        method2(arr);
    }
    public static void method1(char[] arr){
        System.out.println("Method 1 : ");
        String s = String.valueOf(arr);
        System.out.println(s);
    }
    public static void method2(char[] arr){
        System.out.println("Method 2 : ");
        String ans ="";
        for (char c : arr) {
            ans+=c;
        }
        System.out.println(ans);
    }
    public static void method3(char[] arr){

        System.out.println("Method 3 : ");
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
