import java.util.Arrays;
import java.util.Scanner;

//Java Program to print the sum of all the items of the array
public class Question68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        method1(arr,n);
        int sum = method2(arr,n-1);
        System.out.println("Method 2 : ");
        System.out.println("USING RECURSION : ");
        System.out.println("Sum : "+sum );
    }
    public static void method1(int[] arr , int n){
        int sum = 0;
        System.out.println("Method 1 : ");
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }
        System.out.println("Sum Of the Array : "+sum);
    }
    public static int method2(int[] arr , int n){
     if(n==0){
         return arr[0];
     }
        return arr[n]+method2(arr,n-1);

    }
}
