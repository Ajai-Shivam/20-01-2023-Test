//Print Odd and Even Number from an Array
import java.util.Scanner;

public class Question75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        method1(arr, n);
    }
    public static void method1(int[] arr, int n) {
        System.out.println("Method 1 : ");
        System.out.println("Even : ");
        for (int i = 0; i < n; i++) {
            if(arr[i]%2==0){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
        System.out.println("Odd : ");
        for (int i = 0; i < n; i++) {
            if(arr[i]%2!=0){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}