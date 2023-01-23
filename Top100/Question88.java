//Java Program to convert a sentence/paragraph to word(String) array with using
//        string function.

import java.util.Arrays;
import java.util.Scanner;

public class Question88 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        method1(s);
    }
    public static void method1(String s){
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
    }

}
