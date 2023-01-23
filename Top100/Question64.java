import java.util.Arrays;
import java.util.Scanner;

//.Java Program to copy all elements of one array into another array
public class Question64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        method1(arr,n);
        method2(arr,n);

    }
    public static void method1(int[] arr ,int n ){
        // Using inbuild funtion
        System.out.println("Method 1 : ");
        System.out.println();
        System.out.println("Using inbuild funtion ");
        System.out.println();
        int[] copyarr = new int[n];
        copyarr = arr.clone(); // copied arr array to another array using clone funtion....
        copyarr[0]++; // to see the difference
        System.out.println(Arrays.toString(copyarr));

    }
    public static void method2(int[] arr ,int n ){
        // Using For Loop !
        System.out.println("Method2 : ");
        System.out.println();
        System.out.println("using For Loop !");
        int [] copyarr = new int[n];
        for (int i = 0; i < n; i++) {
            copyarr[i] = arr[i];
        }
        // tranfering element one by one
        System.out.println(Arrays.toString(copyarr));

    }
}
