import java.util.Scanner;

//Java Program to print the elements of an array present on even position and odd
//        positions
public class Question62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        method1(arr,n);


    }
    public static void method1(int[]arr,int n){
        System.out.println("even position");
        for (int i = 0; i < n; i+=2) {
            System.out.print( arr[i]+" ");
        }
        System.out.println();
        System.out.println("odd Positiom :");
        for (int i = 1; i < n; i+=2) {
            System.out.print( arr[i]+" ");
        }
    }
}
