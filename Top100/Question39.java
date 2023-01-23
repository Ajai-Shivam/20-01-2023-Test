import java.util.Scanner;

public class Question39 {
    public static void main(String[] args) {
        //Java Program to print the Smallest Element IN the Array
        Scanner sc = new Scanner(System.in);
        // Enter the Size Of The Array.
        int n = sc.nextInt();
        int [] arr = new int[n];
        // Getting Input for Array
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
