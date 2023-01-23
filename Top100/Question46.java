import java.util.Arrays;
import java.util.Scanner;

public class Question46 {
    public static void main(String[] args) {
        //Java Program to rotate the elements of an array in the right direction
        Scanner sc = new Scanner(System.in);
        //GIve The Size Of the Array.
        System.out.print("Enter The Size Of the Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();      // Geting The Input For Array.
        }
        System.out.print("Enter The Number of Rotation to be Done : ");
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int Last_digit = arr[n-1];
            for (int j = n-1; j >0; j--) {
                arr[j] = arr[j-1];
            }
            arr[0] = Last_digit;
        }
        System.out.println("Array After Rotation : ");
        System.out.println(Arrays.toString(arr));
    }
}
