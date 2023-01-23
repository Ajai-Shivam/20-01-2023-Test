import java.util.Scanner;

public class Question37 {
    public static void main(String[] args) {
        //Java Program to print the elements of an array present on odd position
        Scanner sc = new Scanner(System.in);
        // Enter the Size Of The Array.
        int n = sc.nextInt();
        int [] arr = new int[n];
        // Getting Input for Array
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Printing The Odd Postion  Element In Array : ");
        for (int i = 1; i < n; i+=2) {
            System.out.print(arr[i]+" ");
        }
    }
}
