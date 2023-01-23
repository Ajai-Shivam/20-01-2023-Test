import java.util.Arrays;
import java.util.Scanner;

public class Question43 {
    public static void main(String[] args) {
        // Java Program to left rotate the elements of an array
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
            int first_digit = arr[0];
            for (int j = 0; j < n-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[n-1] = first_digit;
        }
        System.out.println("Array After Rotation : ");
        System.out.println(Arrays.toString(arr));

    }
}
