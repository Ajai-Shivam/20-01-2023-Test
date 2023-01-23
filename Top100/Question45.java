import java.util.Scanner;

public class Question45 {
    public static void main(String[] args) {
        // Java Program to print the sum of all the items of the array
        Scanner sc = new Scanner(System.in);
        //GIve The Size Of the Array.
        System.out.print("Enter The Size Of the Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum  = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();      // Geting The Input For Array.
            sum+=arr[i];
        }
        System.out.print("The Sum of Entire Array : "+sum);
    }
}
