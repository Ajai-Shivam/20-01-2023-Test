import java.util.Arrays;
import java.util.Scanner;

//Java Program to find the 2nd Smallest Number in an Array
public class Question71 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        method1(arr, n);
        method2(arr, n);
        method3(arr, n);
    }

    public static void method1(int[] arr, int n) {
        Arrays.sort(arr);
        System.out.println("Method 1 : ");
        int secmin = 0,min =Integer.MAX_VALUE;
        for (int i = n-1; i >=0; i--) {
            if (arr[i]<min){
                secmin = min;
                min = arr[i];
            }
        }
        System.out.println("The Second Smallest Number is : "+secmin);
    }

    public static void method2(int[] arr, int n) {
        System.out.println("Method 2 : ");
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
        int secmin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i]<secmin && arr[i]!=min){
                secmin = arr[i];
            }
        }
        // This solution takes O(n'2)...
        System.out.println("The Second Smallest Number is : "+secmin);
    }
    public static void method3(int[] arr, int n) {
        // This Solution Works if there is no duplicate present in the Array...
        System.out.println("METHOD 3 : ");
        Arrays.sort(arr);
        System.out.println("The Second Smallest Number is : "+arr[1]);
    }
}