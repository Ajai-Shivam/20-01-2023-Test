import java.util.Arrays;
import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        // Insertion sort - Question 8
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // The Array size.
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Question8 obj = new Question8();
        obj.insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void insertion_sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
