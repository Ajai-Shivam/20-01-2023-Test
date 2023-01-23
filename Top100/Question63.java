//.Java Program to print the largest element and smallest element in an array

import java.util.Arrays;
import java.util.Scanner;

public class Question63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        method2(arr,n);
        method1(arr,n);
    }
    public static void method1(int[] arr ,int n ){
        // Using Sort
        System.out.println("method1 : ");
        Arrays.sort(arr);
        System.out.println("the largest Number Of the Array : "+arr[n-1]);
        System.out.println("the smallest Number Of the Array : "+arr[0]);

    }
    public static void method2(int[] arr ,int n ){
        System.out.println("Method2 : ");
        int largest_Num = 0,smallest_num=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i]>largest_Num){
                largest_Num = arr[i];

            }
            if(arr[i]<smallest_num){
              smallest_num = arr[i];
            }

        }
        System.out.println("the largest Number Of the Array : "+largest_Num);
        System.out.println("the smallest Number Of the Array : "+smallest_num);

    }
}
