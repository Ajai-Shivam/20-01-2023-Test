import java.util.Arrays;
import java.util.Scanner;

//Java Program to print all the characters in an arrays
public class Question86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        System.out.println("Method 1 : ");
        System.out.println(Arrays.toString(arr));
        method2(arr);
    }
    public static void method2(char[] arr){
        System.out.println("Method 2 : ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }
}
