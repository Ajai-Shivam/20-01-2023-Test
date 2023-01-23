import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//.Java Program to remove Duplicate Element in an Array
public class Question72 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        method1(arr, n);
        method2(arr, n);
    }
    public static void method1(int[] arr, int n) {
        System.out.println("Method 1 : ");
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }
        ArrayList<Integer> AL = new ArrayList<>(hs);
        System.out.println(AL);
    }

    public static void method2(int[] arr, int n) {
        System.out.println("Method 2 : ");
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i]==arr[j]){
                    arr[j] = -1;
                }
            }
        }
        ArrayList<Integer> AL = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i]!=-1){
                AL.add(arr[i]);
            }
        }
        System.out.println(AL);
    }
}
