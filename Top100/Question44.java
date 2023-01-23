import java.util.Scanner;

public class Question44 {
    public static void main(String[] args) {
        //Java Program to print the duplicate elements of an array
        Scanner sc = new Scanner(System.in);
        //GIve The Size Of the Array.
        System.out.print("Enter The Size Of the Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();      // Geting The Input For Array.
        }
        System.out.println("Repeated Element : ");
        boolean [] vist = new boolean[n];
        for (int i = 0; i < n; i++) {
            int count =1;
            if(vist[i] == true){
                continue;
            }
            for (int j = i+1; j <n ; j++) {
                if(arr[i] == arr[j]){
                    count++;
                    vist[j] = true;
                }
            }
            if(count>1){
                System.out.println(arr[i]);
            }
        }
    }
}
