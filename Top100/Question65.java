import java.util.Arrays;
import java.util.Scanner;

//Java Program to find the frequency of each element in the array
public class Question65 {
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
       boolean[] vist = new boolean[n]; //  This array is used to check if the element in the array is already Counted or not!
        System.out.println("Method 1 : ");
        System.out.println("The Frequency Of Each Element in a array : ");
        for (int i = 0; i < n-1; i++) {
            int count = 1; //  it is used to count the number of occurence of the number....
            if(vist[i]==true){
                continue;
            }
            for (int j =i+1; j < n; j++) {
                if(arr[i]==arr[j]){
                    count++;
                    vist[j] = true;
                }
            }
            System.out.println(arr[i]+" Occurs "+count+" times");
        }

    }
    public static void method2(int[] arr ,int n ){
        System.out.println("Method 2 : ");
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j =i+1; j < n; j++) {
                if(arr[i]==arr[j]){
                    count++;
                }
                else {
                    break;
                }
            }

            System.out.println(arr[i]+" Occurs "+count+" times");
            i += count -1;
        }

    }


}

