import java.util.Arrays;
import java.util.Scanner;

//Java Program to left rotate the elements of an array
public class Question66 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt(); // Number of Rotations

        method1(arr,n,k);
        method2(arr,n,k);
    }
    public static void method1(int[] arr , int n , int k ){
        System.out.println("Method 1 : ");
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[(k+i)%n];
        }
        System.out.println(Arrays.toString(ans));
    }
    public static void method2(int[] arr , int n , int k ){
        System.out.println("Method 2 : ");
        for (int i = 0; i < k; i++) {
            int first_digit = arr[0];
            for (int j = 0; j < n-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[n-1] = first_digit;
        }
        System.out.println(Arrays.toString(arr));
    }

}
