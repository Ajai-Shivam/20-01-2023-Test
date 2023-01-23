import java.util.Arrays;
import java.util.Scanner;

//Java Program to print the elements of an array in reverse order
public class Question61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before : ");
        System.out.println(Arrays.toString(arr));
        method1(arr,n);
        System.out.println();
        System.out.println("Using Recursion : ");
        method2(arr,n-1);
    }
    public static void method1(int[] arr , int n){
        System.out.println("Array In Reverse order :");
        for (int i = n-1; i >=0 ; i--) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int method2(int[] arr , int n){
        if(n<0){
            return 0;
        }
        System.out.print(arr[n]+" ");
        return method2(arr,n-1);
    }

}
