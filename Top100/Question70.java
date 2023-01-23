//Java Program to find the 2nd Largest Number in an Array

import java.util.Arrays;
import java.util.Scanner;

public class Question70 {
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
       int seclarge = 0,max =0;
        for (int i = 0; i < n; i++) {
            if (arr[i]>max){
                seclarge = max;
                max = arr[i];
            }
        }
        System.out.println("The Second Largest Number is : "+seclarge);
    }

    public static void method2(int[] arr, int n) {
        System.out.println("Method 2 : ");
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int seclarge = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>seclarge && arr[i]!=max){
                seclarge = arr[i];
            }
        }
        // This solution takes O(n'2)...
        System.out.println("The Second Largest Number is : "+seclarge);
    }
    public static void method3(int[] arr, int n) {
        // This Solution Works if there is no duplicate present in the Array...
        System.out.println("METHOD 3 : ");
        Arrays.sort(arr);
        System.out.println("The Second Largest Number is : "+arr[n-2]);
    }
}