import java.util.Arrays;
import java.util.Scanner;

//Write a program to sort the elements in odd positions in descending order and
//        elements in ascending order
public class Question54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int des = n-1;
        int[] resultarr = new int[n];
        for (int i = 1; i < n; i+=2) {
            resultarr[i] = arr[des];
            des--;
        }
        int asc = 0;
        for (int i = 0; i < n; i+=2) {
            resultarr[i] = arr[asc];
            asc++;
        }
        System.out.println(Arrays.toString(resultarr));
    }
}
