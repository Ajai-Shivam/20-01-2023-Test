import java.util.Arrays;
import java.util.Scanner;


//.Java Program to sort the elements of an array in ascending order
public class Question77 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        method1(arr,n);
        method2(arr,n);
        method3(arr,n);
    }
    public static void method1(int[] arr , int n ){
        //Bublle sort
        System.out.println("Bubble Sort : ");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] =arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void method2(int []arr,int n){
        // Selection sort
        System.out.println("Selection Sort : ");
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i+1; j < n; j++) {
                if(arr[index]>arr[j]){
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] =  temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void method3(int []arr,int n){
        // insertion sort
        System.out.println("insertion Sort : ");
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}