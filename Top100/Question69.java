import java.util.Arrays;
import java.util.Scanner;

//Java Program to rotate the elements of an array in the right direction
public class Question69 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int [] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
       arr2 = arr.clone();
        int k = sc.nextInt(); // Number of Rotations
        method1(arr,n,k);

        method2(arr2,n,k);
    }
    public static void method1(int[] arr , int n , int k ){
        System.out.println("Method 1 : ");
        for (int i = 0; i < k; i++) {
            int Last_digit = arr[n-1];
            for (int j = n-1; j >0; j--) {
                arr[j] = arr[j-1];
            }
            arr[0] = Last_digit;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void method2(int[] arr , int n , int k ) {
        System.out.println("Method 2 : ");

        k %= arr.length;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void reverse(int[] arr,int start ,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

