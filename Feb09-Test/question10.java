import java.util.Scanner;

public class question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // The Array Size..
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            //  Array Input
        }
        int k = sc.nextInt(); // The Sum should be Divisible by this Number.
        question10 obj = new question10();
        obj.two_pointer(arr, k);
        obj.Brute_Force(arr , k);

    }
    public void two_pointer (int[] arr , int k ){
        // two Pointer Solution - Time Complexcity = O(N)
        System.out.println("Two Pointer Approach : ");

        int i = 0; int j  = i+1; // i<j Condition
        while (i<arr.length-1 && j < arr.length){
            if((arr[i]+arr[j]) % k  == 0){
                System.out.println("["+arr[i]+ " , " + arr[j]+"]");
                i++;
                j = i+1;
                continue;
            }
            j++;
        }
    }




    public void Brute_Force(int[] arr , int k){
        // Brute force Approch - Time Complexcity = o(N logn n );
        System.out.println("Brute Force Approach : ");
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1;j<arr.length; j++) {
                   if((arr[i] + arr[j]) % k == 0 ) // Condition Checking
                   {
                       System.out.println("["+arr[i]+ " , " + arr[j]+"]");
                       break;
                   }
            }
        }
    }

}
