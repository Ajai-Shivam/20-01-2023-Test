import java.util.Scanner;

public class Question38 {
    public static void main(String[] args) {
        //Java Program to print the Largest Element IN the Array
        Scanner sc = new Scanner(System.in);
        // Enter the Size Of The Array.
        int n = sc.nextInt();
        int [] arr = new int[n];
        // Getting Input for Array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(max);

    }
}
